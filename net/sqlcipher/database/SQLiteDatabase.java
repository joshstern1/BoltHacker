package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug.DbStats;

public class SQLiteDatabase extends SQLiteClosable {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "3.5.1";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap();
    private static int sQueryLogTimeInMillis = 0;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    int mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final Random mRandom;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    private static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    private native int native_getDbLookaside();

    private native void native_key(char[] cArr) throws SQLException;

    private native void native_rawExecSQL(String str);

    private native void native_rekey(String str) throws SQLException;

    private native int native_status(int i, boolean z);

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    native int lastChangeCount();

    native long lastInsertRow();

    native void native_execSQL(String str) throws SQLException;

    native void native_setLocale(String str, int i);

    public int status(int i, boolean z) {
        return native_status(i, z);
    }

    public void changePassword(String str) throws SQLiteException {
        if (isOpen()) {
            native_rekey(str);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public void changePassword(char[] cArr) throws SQLiteException {
        if (isOpen()) {
            native_rekey(String.valueOf(cArr));
            return;
        }
        throw new SQLiteException("database not open");
    }

    private static void loadICUData(Context context, File file) {
        ZipInputStream zipInputStream;
        Throwable e;
        OutputStream outputStream;
        ZipInputStream zipInputStream2;
        ZipInputStream zipInputStream3 = null;
        File file2 = new File(file, "icu");
        File file3 = new File(file2, "icudt46l.dat");
        try {
            OutputStream outputStream2;
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (file3.exists()) {
                zipInputStream = null;
                outputStream2 = null;
            } else {
                zipInputStream = new ZipInputStream(context.getAssets().open("icudt46l.zip"));
                try {
                    zipInputStream.getNextEntry();
                    outputStream2 = new FileOutputStream(file3);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            outputStream2.write(bArr, 0, read);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        zipInputStream3 = zipInputStream;
                        outputStream = outputStream2;
                        try {
                            Log.e(TAG, "Error copying icu dat file", e);
                            if (file3.exists()) {
                                file3.delete();
                            }
                            throw new RuntimeException(e);
                        } catch (Throwable th) {
                            e = th;
                            if (zipInputStream3 != null) {
                                try {
                                    zipInputStream3.close();
                                } catch (Throwable e3) {
                                    Log.e(TAG, "Error in closing streams IO streams after expanding ICU dat file", e3);
                                    throw new RuntimeException(e3);
                                }
                            }
                            if (outputStream != null) {
                                outputStream.flush();
                                outputStream.close();
                            }
                            throw e3;
                        }
                    } catch (Throwable th2) {
                        e3 = th2;
                        zipInputStream3 = zipInputStream;
                        outputStream = outputStream2;
                        if (zipInputStream3 != null) {
                            zipInputStream3.close();
                        }
                        if (outputStream != null) {
                            outputStream.flush();
                            outputStream.close();
                        }
                        throw e3;
                    }
                } catch (Exception e4) {
                    e3 = e4;
                    zipInputStream2 = zipInputStream;
                    outputStream = null;
                    zipInputStream3 = zipInputStream2;
                    Log.e(TAG, "Error copying icu dat file", e3);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    throw new RuntimeException(e3);
                } catch (Throwable th3) {
                    e3 = th3;
                    zipInputStream2 = zipInputStream;
                    outputStream = null;
                    zipInputStream3 = zipInputStream2;
                    if (zipInputStream3 != null) {
                        zipInputStream3.close();
                    }
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                    throw e3;
                }
            }
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e32) {
                    Log.e(TAG, "Error in closing streams IO streams after expanding ICU dat file", e32);
                    throw new RuntimeException(e32);
                }
            }
            if (outputStream2 != null) {
                outputStream2.flush();
                outputStream2.close();
            }
        } catch (Exception e5) {
            e32 = e5;
            outputStream = null;
            Log.e(TAG, "Error copying icu dat file", e32);
            if (file3.exists()) {
                file3.delete();
            }
            throw new RuntimeException(e32);
        } catch (Throwable th4) {
            e32 = th4;
            outputStream = null;
            if (zipInputStream3 != null) {
                zipInputStream3.close();
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
            throw e32;
        }
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    public static synchronized void loadLibs(Context context, File file) {
        synchronized (SQLiteDatabase.class) {
            System.loadLibrary("sqlcipher");
        }
    }

    void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.put(sQLiteClosable, null);
        } finally {
            unlock();
        }
    }

    void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.remove(sQLiteClosable);
        } finally {
            unlock();
        }
    }

    protected void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void setLockingEnabled(boolean z) {
        this.mLockingEnabled = z;
    }

    void onCorruption() {
        Log.e(TAG, "Calling error handler for corrupt database (detected) " + this.mPath);
        this.mErrorHandler.onCorruption(this);
    }

    void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private void checkLockHoldTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.mLockAcquiredWallTime;
        if ((j >= 2000 || Log.isLoggable(TAG, 2) || elapsedRealtime - this.mLastLockMessageTime >= 20000) && j > 300) {
            int threadCpuTimeNanos = (int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000);
            if (threadCpuTimeNanos > 100 || j > 2000) {
                this.mLastLockMessageTime = elapsedRealtime;
                String str = "lock held on " + this.mPath + " for " + j + "ms. Thread time was " + threadCpuTimeNanos + "ms";
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
                    Log.d(TAG, str, new Exception());
                } else {
                    Log.d(TAG, str);
                }
            }
        }
    }

    public void beginTransaction() {
        beginTransactionWithListener(null);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        lockForced();
        if (isOpen()) {
            try {
                if (this.mLock.getHoldCount() <= 1) {
                    execSQL("BEGIN EXCLUSIVE;");
                    this.mTransactionListener = sQLiteTransactionListener;
                    this.mTransactionIsSuccessful = true;
                    this.mInnerTransactionIsSuccessful = false;
                    if (sQLiteTransactionListener != null) {
                        sQLiteTransactionListener.onBegin();
                    }
                } else if (this.mInnerTransactionIsSuccessful) {
                    Throwable illegalStateException = new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                    Log.e(TAG, "beginTransaction() failed", illegalStateException);
                    throw illegalStateException;
                }
            } catch (RuntimeException e) {
                execSQL("ROLLBACK;");
                throw e;
            } catch (Throwable th) {
                unlockForced();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void endTransaction() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (this.mLock.isHeldByCurrentThread()) {
            RuntimeException runtimeException;
            try {
                if (this.mInnerTransactionIsSuccessful) {
                    this.mInnerTransactionIsSuccessful = false;
                } else {
                    this.mTransactionIsSuccessful = false;
                }
                if (this.mLock.getHoldCount() != 1) {
                    this.mTransactionListener = null;
                    unlockForced();
                    return;
                }
                if (this.mTransactionListener != null) {
                    if (this.mTransactionIsSuccessful) {
                        this.mTransactionListener.onCommit();
                    } else {
                        this.mTransactionListener.onRollback();
                    }
                    runtimeException = null;
                } else {
                    runtimeException = null;
                }
                if (this.mTransactionIsSuccessful) {
                    execSQL(COMMIT_SQL);
                } else {
                    try {
                        execSQL("ROLLBACK;");
                        if (runtimeException != null) {
                            throw runtimeException;
                        }
                    } catch (SQLException e) {
                        Log.d(TAG, "exception during rollback, maybe the DB previously performed an auto-rollback");
                    }
                }
                this.mTransactionListener = null;
                unlockForced();
            } catch (RuntimeException e2) {
                runtimeException = e2;
                this.mTransactionIsSuccessful = false;
            } catch (Throwable th) {
                this.mTransactionListener = null;
                unlockForced();
            }
        } else {
            throw new IllegalStateException("no transaction pending");
        }
    }

    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        } else if (this.mInnerTransactionIsSuccessful) {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        } else {
            this.mInnerTransactionIsSuccessful = true;
        }
    }

    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (isOpen()) {
            return yieldIfContendedHelper(false, -1);
        }
        return false;
    }

    public boolean yieldIfContendedSafely() {
        if (isOpen()) {
            return yieldIfContendedHelper(true, -1);
        }
        return false;
    }

    public boolean yieldIfContendedSafely(long j) {
        if (isOpen()) {
            return yieldIfContendedHelper(true, j);
        }
        return false;
    }

    private boolean yieldIfContendedHelper(boolean z, long j) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
        endTransaction();
        if (z && isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        if (j > 0) {
            long j2 = j;
            while (j2 > 0) {
                try {
                    Thread.sleep(j2 < 1000 ? j2 : 1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                j2 -= 1000;
                if (this.mLock.getQueueLength() == 0) {
                    break;
                }
            }
        }
        beginTransactionWithListener(sQLiteTransactionListener);
        return true;
    }

    public Map<String, String> getSyncedTables() {
        Map hashMap;
        synchronized (this.mSyncUpdateInfo) {
            hashMap = new HashMap();
            for (String str : this.mSyncUpdateInfo.keySet()) {
                SyncUpdateInfo syncUpdateInfo = (SyncUpdateInfo) this.mSyncUpdateInfo.get(str);
                if (syncUpdateInfo.deletedTable != null) {
                    hashMap.put(str, syncUpdateInfo.deletedTable);
                }
            }
        }
        return hashMap;
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i) {
        return openDatabase(str, str2.toCharArray(), cursorFactory, i, null);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        return openDatabase(str, cArr, cursorFactory, i, null);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2.toCharArray(), cursorFactory, i, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, i, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2.toCharArray(), cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = new SQLiteDatabase(str, cursorFactory, i, databaseErrorHandler);
            try {
                sQLiteDatabase.openDatabaseInternal(cArr, sQLiteDatabaseHook);
            } catch (Throwable e) {
                Throwable th2 = e;
                sQLiteDatabase2 = sQLiteDatabase;
                th = th2;
                Log.e(TAG, "Calling error handler for corrupt database " + str, th);
                databaseErrorHandler.onCorruption(sQLiteDatabase2);
                sQLiteDatabase = new SQLiteDatabase(str, cursorFactory, i, databaseErrorHandler);
                sQLiteDatabase.openDatabaseInternal(cArr, sQLiteDatabaseHook);
                if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                    sQLiteDatabase.enableSqlTracing(str);
                }
                if (SQLiteDebug.DEBUG_SQL_TIME) {
                    sQLiteDatabase.enableSqlProfiling(str);
                }
                synchronized (sActiveDatabases) {
                    sActiveDatabases.put(sQLiteDatabase, null);
                }
                return sQLiteDatabase;
            }
        } catch (SQLiteDatabaseCorruptException e2) {
            th = e2;
            Log.e(TAG, "Calling error handler for corrupt database " + str, th);
            databaseErrorHandler.onCorruption(sQLiteDatabase2);
            sQLiteDatabase = new SQLiteDatabase(str, cursorFactory, i, databaseErrorHandler);
            sQLiteDatabase.openDatabaseInternal(cArr, sQLiteDatabaseHook);
            if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                sQLiteDatabase.enableSqlTracing(str);
            }
            if (SQLiteDebug.DEBUG_SQL_TIME) {
                sQLiteDatabase.enableSqlProfiling(str);
            }
            synchronized (sActiveDatabases) {
                sActiveDatabases.put(sQLiteDatabase, null);
            }
            return sQLiteDatabase;
        }
        if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
            sQLiteDatabase.enableSqlTracing(str);
        }
        if (SQLiteDebug.DEBUG_SQL_TIME) {
            sQLiteDatabase.enableSqlProfiling(str);
        }
        synchronized (sActiveDatabases) {
            sActiveDatabases.put(sQLiteDatabase, null);
        }
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openOrCreateDatabase(file.getPath(), str, cursorFactory, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(file.getPath(), str.toCharArray(), cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2.toCharArray(), cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file.getPath(), str, cursorFactory, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        return openDatabase(str, str2.toCharArray(), cursorFactory, (int) CREATE_IF_NECESSARY, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        return openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, null);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        return openDatabase(":memory:", str.toCharArray(), cursorFactory, (int) CREATE_IF_NECESSARY);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        return openDatabase(":memory:", cArr, cursorFactory, (int) CREATE_IF_NECESSARY);
    }

    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Entry key : this.mPrograms.entrySet()) {
            SQLiteClosable sQLiteClosable = (SQLiteClosable) key.getKey();
            if (sQLiteClosable != null) {
                sQLiteClosable.onAllReferencesReleasedFromContainer();
            }
        }
    }

    public int getVersion() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        if (isOpen()) {
            try {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA user_version;");
                try {
                    int simpleQueryForLong = (int) sQLiteStatement.simpleQueryForLong();
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = null;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public void setVersion(int i) {
        execSQL("PRAGMA user_version = " + i);
    }

    public long getMaximumSize() {
        Throwable th;
        lock();
        if (isOpen()) {
            SQLiteStatement sQLiteStatement;
            try {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA max_page_count;");
                try {
                    long simpleQueryForLong = sQLiteStatement.simpleQueryForLong() * getPageSize();
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = null;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public long setMaximumSize(long j) {
        Throwable th;
        lock();
        if (isOpen()) {
            SQLiteStatement sQLiteStatement;
            try {
                long j2;
                long pageSize = getPageSize();
                long j3 = j / pageSize;
                if (j % pageSize != 0) {
                    j2 = j3 + 1;
                } else {
                    j2 = j3;
                }
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA max_page_count = " + j2);
                try {
                    long simpleQueryForLong = sQLiteStatement.simpleQueryForLong() * pageSize;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = null;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public long getPageSize() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        if (isOpen()) {
            try {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA page_size;");
                try {
                    long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = null;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public void setPageSize(long j) {
        execSQL("PRAGMA page_size = " + j);
    }

    public void markTableSyncable(String str, String str2) {
        if (isOpen()) {
            markTableSyncable(str, "_id", str, str2);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if (isOpen()) {
            markTableSyncable(str, str2, str3, null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            native_execSQL("SELECT _sync_dirty FROM " + str3 + " LIMIT 0");
            native_execSQL("SELECT " + str2 + " FROM " + str + " LIMIT 0");
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } finally {
            unlock();
        }
    }

    void rowUpdated(String str, long j) {
        synchronized (this.mSyncUpdateInfo) {
            SyncUpdateInfo syncUpdateInfo = (SyncUpdateInfo) this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            execSQL("UPDATE " + syncUpdateInfo.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + syncUpdateInfo.foreignKey + " FROM " + str + " WHERE _id=" + j + ")");
        }
    }

    public static String findEditTable(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("Invalid tables");
        }
        int indexOf = str.indexOf(32);
        int indexOf2 = str.indexOf(44);
        if (indexOf > 0 && (indexOf < indexOf2 || indexOf2 < 0)) {
            return str.substring(0, indexOf);
        }
        if (indexOf2 <= 0) {
            return str;
        }
        if (indexOf2 < indexOf || indexOf < 0) {
            return str.substring(0, indexOf2);
        }
        return str;
    }

    public SQLiteStatement compileStatement(String str) throws SQLException {
        lock();
        if (isOpen()) {
            try {
                SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str);
                return sQLiteStatement;
            } finally {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (isOpen()) {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str));
        }
        throw new IllegalStateException("database not open");
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null);
    }

    public net.sqlcipher.Cursor rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase.CursorFactory r9, java.lang.String r10, java.lang.String[] r11, java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Assign predecessor not found for B:10:? from B:28:?
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:102)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r2 = -1;
        r0 = r8.isOpen();
        if (r0 != 0) goto L_0x000f;
    L_0x0007:
        r0 = new java.lang.IllegalStateException;
        r1 = "database not open";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r0 = 0;
        r3 = r8.mSlowQueryThreshold;
        if (r3 == r2) goto L_0x0019;
    L_0x0015:
        r0 = java.lang.System.currentTimeMillis();
    L_0x0019:
        r4 = new net.sqlcipher.database.SQLiteDirectCursorDriver;
        r4.<init>(r8, r10, r12);
        r5 = 0;
        if (r9 == 0) goto L_0x0072;
    L_0x0021:
        r3 = r4.query(r9, r11);	 Catch:{ all -> 0x0075 }
        r5 = r8.mSlowQueryThreshold;
        if (r5 == r2) goto L_0x006c;
    L_0x0029:
        if (r3 == 0) goto L_0x002f;
    L_0x002b:
        r2 = r3.getCount();
    L_0x002f:
        r6 = java.lang.System.currentTimeMillis();
        r0 = r6 - r0;
        r5 = r8.mSlowQueryThreshold;
        r6 = (long) r5;
        r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x006c;
    L_0x003c:
        r5 = "Database";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "query (";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r1 = " ms): ";
        r0 = r0.append(r1);
        r1 = r4.toString();
        r0 = r0.append(r1);
        r1 = ", args are <redacted>, count is ";
        r0 = r0.append(r1);
        r0 = r0.append(r2);
        r0 = r0.toString();
        android.util.Log.v(r5, r0);
    L_0x006c:
        r0 = new net.sqlcipher.CrossProcessCursorWrapper;
        r0.<init>(r3);
        return r0;
    L_0x0072:
        r9 = r8.mFactory;	 Catch:{ all -> 0x0075 }
        goto L_0x0021;
    L_0x0075:
        r3 = move-exception;
        r6 = r8.mSlowQueryThreshold;
        if (r6 == r2) goto L_0x00bd;
    L_0x007a:
        if (r5 == 0) goto L_0x0080;
    L_0x007c:
        r2 = r5.getCount();
    L_0x0080:
        r6 = java.lang.System.currentTimeMillis();
        r0 = r6 - r0;
        r5 = r8.mSlowQueryThreshold;
        r6 = (long) r5;
        r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x00bd;
    L_0x008d:
        r5 = "Database";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "query (";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r1 = " ms): ";
        r0 = r0.append(r1);
        r1 = r4.toString();
        r0 = r0.append(r1);
        r1 = ", args are <redacted>, count is ";
        r0 = r0.append(r1);
        r0 = r0.append(r2);
        r0 = r0.toString();
        android.util.Log.v(r5, r0);
    L_0x00bd:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase$CursorFactory, java.lang.String, java.lang.String[], java.lang.String):net.sqlcipher.Cursor");
    }

    public Cursor rawQuery(String str, String[] strArr, int i, int i2) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i, i2);
        return cursorWrapper;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (Throwable e) {
            Log.e(TAG, "Error inserting <redacted values> into " + str, e);
            return -1;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (Throwable e) {
            Log.e(TAG, "Error inserting <redacted values> into " + str, e);
            return -1;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i) {
        SQLiteStatement sQLiteStatement = null;
        int i2 = 0;
        if (isOpen()) {
            Set set;
            StringBuilder stringBuilder = new StringBuilder(152);
            stringBuilder.append("INSERT");
            stringBuilder.append(CONFLICT_VALUES[i]);
            stringBuilder.append(" INTO ");
            stringBuilder.append(str);
            Object stringBuilder2 = new StringBuilder(40);
            if (contentValues == null || contentValues.size() <= 0) {
                stringBuilder.append("(" + str2 + ") ");
                stringBuilder2.append("NULL");
                set = null;
            } else {
                Set<Entry> valueSet = contentValues.valueSet();
                stringBuilder.append('(');
                int i3 = 0;
                for (Entry key : valueSet) {
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                        stringBuilder2.append(", ");
                    }
                    stringBuilder.append((String) key.getKey());
                    stringBuilder2.append('?');
                    i3 = 1;
                }
                stringBuilder.append(')');
                set = valueSet;
            }
            stringBuilder.append(" VALUES(");
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(");");
            lock();
            try {
                sQLiteStatement = compileStatement(stringBuilder.toString());
                if (set != null) {
                    int size = set.size();
                    Iterator it = set.iterator();
                    while (i2 < size) {
                        DatabaseUtils.bindObjectToProgram(sQLiteStatement, i2 + 1, ((Entry) it.next()).getValue());
                        i2++;
                    }
                }
                sQLiteStatement.execute();
                long lastInsertRow = lastInsertRow();
                if (lastInsertRow == -1) {
                    Log.e(TAG, "Error inserting <redacted values> using <redacted sql> into " + str);
                } else if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Inserting row " + lastInsertRow + " from <redacted values> using <redacted sql> into " + str);
                }
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                return lastInsertRow;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public int delete(String str, String str2, String[] strArr) {
        lock();
        if (isOpen()) {
            SQLiteStatement sQLiteStatement = null;
            try {
                int i;
                SQLiteProgram compileStatement = compileStatement("DELETE FROM " + str + (!TextUtils.isEmpty(str2) ? " WHERE " + str2 : ""));
                if (strArr != null) {
                    int length = strArr.length;
                    for (i = 0; i < length; i++) {
                        DatabaseUtils.bindObjectToProgram(compileStatement, i + 1, strArr[i]);
                    }
                }
                compileStatement.execute();
                i = lastChangeCount();
                if (compileStatement != null) {
                    compileStatement.close();
                }
                unlock();
                return i;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder stringBuilder = new StringBuilder(120);
        stringBuilder.append("UPDATE ");
        stringBuilder.append(CONFLICT_VALUES[i]);
        stringBuilder.append(str);
        stringBuilder.append(" SET ");
        Set valueSet = contentValues.valueSet();
        Iterator it = valueSet.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) ((Entry) it.next()).getKey());
            stringBuilder.append("=?");
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(str2);
        }
        lock();
        if (isOpen()) {
            SQLiteStatement sQLiteStatement = null;
            try {
                int i2;
                SQLiteProgram compileStatement = compileStatement(stringBuilder.toString());
                int size = valueSet.size();
                Iterator it2 = valueSet.iterator();
                int i3 = 1;
                for (i2 = 0; i2 < size; i2++) {
                    DatabaseUtils.bindObjectToProgram(compileStatement, i3, ((Entry) it2.next()).getValue());
                    i3++;
                }
                if (strArr != null) {
                    int i4 = i3;
                    for (String bindString : strArr) {
                        compileStatement.bindString(i4, bindString);
                        i4++;
                    }
                }
                compileStatement.execute();
                int lastChangeCount = lastChangeCount();
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Updated " + lastChangeCount + " rows using <redacted values> and <redacted sql> for " + str);
                }
                if (compileStatement != null) {
                    compileStatement.close();
                }
                unlock();
                return lastChangeCount;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (SQLException e2) {
                Log.e(TAG, "Error updating <redacted values> using <redacted sql> for " + str);
                throw e2;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void execSQL(String str) throws SQLException {
        long uptimeMillis = SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            logTimeStat(this.mLastSqlStatement, uptimeMillis, GET_LOCK_LOG_PREFIX);
            try {
                native_execSQL(str);
                unlock();
                if (str == COMMIT_SQL) {
                    logTimeStat(this.mLastSqlStatement, uptimeMillis, COMMIT_SQL);
                } else {
                    logTimeStat(str, uptimeMillis, null);
                }
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void rawExecSQL(String str) {
        long uptimeMillis = SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            logTimeStat(this.mLastSqlStatement, uptimeMillis, GET_LOCK_LOG_PREFIX);
            try {
                native_rawExecSQL(str);
                unlock();
                if (str == COMMIT_SQL) {
                    logTimeStat(this.mLastSqlStatement, uptimeMillis, COMMIT_SQL);
                } else {
                    logTimeStat(str, uptimeMillis, null);
                }
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            SQLiteStatement sQLiteStatement = null;
            try {
                SQLiteProgram compileStatement = compileStatement(str);
                if (objArr != null) {
                    int length = objArr.length;
                    for (int i = 0; i < length; i++) {
                        DatabaseUtils.bindObjectToProgram(compileStatement, i + 1, objArr[i]);
                    }
                }
                compileStatement.execute();
                if (compileStatement != null) {
                    compileStatement.close();
                }
                unlock();
                logTimeStat(str, uptimeMillis);
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    protected void finalize() {
        if (isOpen()) {
            Log.e(TAG, "close() was never explicitly called on database '" + this.mPath + "' ", this.mStackTrace);
            closeClosable();
            onAllReferencesReleased();
        }
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        this(str, cursorFactory, i, null);
        openDatabaseInternal(cArr, null);
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i, null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0;
        this.mLockAcquiredThreadTime = 0;
        this.mLastLockMessageTime = 0;
        this.mRandom = new Random();
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = MAX_SQL_CACHE_SIZE;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str == null) {
            throw new IllegalArgumentException("path should not be null");
        }
        this.mFlags = i;
        this.mPath = str;
        this.mSlowQueryThreshold = -1;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mFactory = cursorFactory;
        this.mPrograms = new WeakHashMap();
        this.mErrorHandler = databaseErrorHandler;
    }

    private void openDatabaseInternal(char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        dbopen(this.mPath, this.mFlags);
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        if (cArr != null) {
            native_key(cArr);
        }
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor rawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        } catch (Throwable e) {
            Log.e(TAG, "Failed to setLocale() when constructing, closing the database", e);
            dbclose();
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            throw e;
        }
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ").format(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean needUpgrade(int i) {
        return i > getVersion();
    }

    public final String getPath() {
        return this.mPath;
    }

    void logTimeStat(String str, long j) {
        logTimeStat(str, j, null);
    }

    void logTimeStat(String str, long j, String str2) {
        this.mLastSqlStatement = str;
        long uptimeMillis = SystemClock.uptimeMillis() - j;
        if (uptimeMillis != 0 || str2 != GET_LOCK_LOG_PREFIX) {
            if (sQueryLogTimeInMillis == 0) {
                sQueryLogTimeInMillis = 500;
            }
            if (uptimeMillis >= ((long) sQueryLogTimeInMillis) || this.mRandom.nextInt(100) < ((int) ((uptimeMillis * 100) / ((long) sQueryLogTimeInMillis))) + 1) {
                if (str2 != null) {
                    str = str2 + str;
                }
                if (str.length() > 64) {
                    str.substring(0, 64);
                }
                if ("unknown" == null) {
                    String str3 = "";
                }
            }
        }
    }

    private String getPathForLogs() {
        if (this.mPathForLogs != null) {
            return this.mPathForLogs;
        }
        if (this.mPath == null) {
            return null;
        }
        if (this.mPath.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void addToCompiledQueries(java.lang.String r5, net.sqlcipher.database.SQLiteCompiledSql r6) {
        /*
        r4 = this;
        r0 = r4.mMaxSqlCacheSize;
        if (r0 != 0) goto L_0x002f;
    L_0x0004:
        r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE;
        if (r0 == 0) goto L_0x002e;
    L_0x0008:
        r0 = "Database";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "|NOT adding_sql_to_cache|";
        r1 = r1.append(r2);
        r2 = r4.getPath();
        r1 = r1.append(r2);
        r2 = "|";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x002e:
        return;
    L_0x002f:
        r1 = r4.mCompiledQueries;
        monitor-enter(r1);
        r0 = r4.mCompiledQueries;	 Catch:{ all -> 0x003e }
        r0 = r0.get(r5);	 Catch:{ all -> 0x003e }
        r0 = (net.sqlcipher.database.SQLiteCompiledSql) r0;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0041;
    L_0x003c:
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x002e;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        throw r0;
    L_0x0041:
        r0 = r4.mCompiledQueries;	 Catch:{ all -> 0x003e }
        r0 = r0.size();	 Catch:{ all -> 0x003e }
        r2 = r4.mMaxSqlCacheSize;	 Catch:{ all -> 0x003e }
        if (r0 != r2) goto L_0x0088;
    L_0x004b:
        r0 = r4.mCacheFullWarnings;	 Catch:{ all -> 0x003e }
        r0 = r0 + 1;
        r4.mCacheFullWarnings = r0;	 Catch:{ all -> 0x003e }
        r2 = 1;
        if (r0 != r2) goto L_0x0086;
    L_0x0054:
        r0 = "Database";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003e }
        r2.<init>();	 Catch:{ all -> 0x003e }
        r3 = "Reached MAX size for compiled-sql statement cache for database ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = r4.getPath();	 Catch:{ all -> 0x003e }
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = "; i.e., NO space for this sql statement in cache: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r2 = r2.append(r5);	 Catch:{ all -> 0x003e }
        r3 = ". Please change your sql statements to use '?' for ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = "bindargs, instead of using actual values";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r2 = r2.toString();	 Catch:{ all -> 0x003e }
        android.util.Log.w(r0, r2);	 Catch:{ all -> 0x003e }
    L_0x0086:
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x002e;
    L_0x0088:
        r0 = r4.mCompiledQueries;	 Catch:{ all -> 0x003e }
        r0.put(r5, r6);	 Catch:{ all -> 0x003e }
        r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0086;
    L_0x0091:
        r0 = "Database";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003e }
        r2.<init>();	 Catch:{ all -> 0x003e }
        r3 = "|adding_sql_to_cache|";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = r4.getPath();	 Catch:{ all -> 0x003e }
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = "|";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = r4.mCompiledQueries;	 Catch:{ all -> 0x003e }
        r3 = r3.size();	 Catch:{ all -> 0x003e }
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = "|";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r2 = r2.append(r5);	 Catch:{ all -> 0x003e }
        r2 = r2.toString();	 Catch:{ all -> 0x003e }
        android.util.Log.v(r0, r2);	 Catch:{ all -> 0x003e }
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.addToCompiledQueries(java.lang.String, net.sqlcipher.database.SQLiteCompiledSql):void");
    }

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql releaseSqlStatement : this.mCompiledQueries.values()) {
                releaseSqlStatement.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    SQLiteCompiledSql getCompiledStatementForSql(String str) {
        SQLiteCompiledSql sQLiteCompiledSql;
        synchronized (this.mCompiledQueries) {
            if (this.mMaxSqlCacheSize == 0) {
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    Log.v(TAG, "|cache NOT found|" + getPath());
                }
                sQLiteCompiledSql = null;
            } else {
                sQLiteCompiledSql = (SQLiteCompiledSql) this.mCompiledQueries.get(str);
                boolean z = sQLiteCompiledSql != null;
                if (z) {
                    this.mNumCacheHits++;
                } else {
                    this.mNumCacheMisses++;
                }
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    Log.v(TAG, "|cache_stats|" + getPath() + "|" + this.mCompiledQueries.size() + "|" + this.mNumCacheHits + "|" + this.mNumCacheMisses + "|" + z + "|" + this.mTimeOpened + "|" + this.mTimeClosed + "|" + str);
                }
            }
        }
        return sQLiteCompiledSql;
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(str);
        }
        return containsKey;
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    public synchronized void setMaxSqlCacheSize(int i) {
        if (i > MAX_SQL_CACHE_SIZE || i < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        } else if (i < this.mMaxSqlCacheSize) {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        } else {
            this.mMaxSqlCacheSize = i;
        }
    }

    static ArrayList<DbStats> getDbStats() {
        ArrayList<DbStats> arrayList = new ArrayList();
        Iterator it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) it.next();
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                int native_getDbLookaside = sQLiteDatabase.native_getDbLookaside();
                String path = sQLiteDatabase.getPath();
                int lastIndexOf = path.lastIndexOf("/");
                String substring = path.substring(lastIndexOf != -1 ? lastIndexOf + 1 : 0);
                ArrayList attachedDbs = getAttachedDbs(sQLiteDatabase);
                if (attachedDbs != null) {
                    for (int i = 0; i < attachedDbs.size(); i++) {
                        Pair pair = (Pair) attachedDbs.get(i);
                        long pragmaVal = getPragmaVal(sQLiteDatabase, ((String) pair.first) + ".page_count;");
                        if (i == 0) {
                            path = substring;
                        } else {
                            String str = "  (attached) " + ((String) pair.first);
                            if (((String) pair.second).trim().length() > 0) {
                                int lastIndexOf2 = ((String) pair.second).lastIndexOf("/");
                                path = str + " : " + ((String) pair.second).substring(lastIndexOf2 != -1 ? lastIndexOf2 + 1 : 0);
                                native_getDbLookaside = 0;
                            } else {
                                path = str;
                                native_getDbLookaside = 0;
                            }
                        }
                        if (pragmaVal > 0) {
                            arrayList.add(new DbStats(path, pragmaVal, sQLiteDatabase.getPageSize(), native_getDbLookaside));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    private static long getPragmaVal(SQLiteDatabase sQLiteDatabase, String str) {
        Throwable th;
        if (!sQLiteDatabase.isOpen()) {
            return 0;
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteStatement sQLiteStatement2 = new SQLiteStatement(sQLiteDatabase, "PRAGMA " + str);
            try {
                long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong();
                if (sQLiteStatement2 == null) {
                    return simpleQueryForLong;
                }
                sQLiteStatement2.close();
                return simpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                sQLiteStatement = sQLiteStatement2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            throw th;
        }
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> arrayList = new ArrayList();
        Cursor rawQuery = sQLiteDatabase.rawQuery("pragma database_list;", null);
        while (rawQuery.moveToNext()) {
            arrayList.add(new Pair(rawQuery.getString(1), rawQuery.getString(2)));
        }
        rawQuery.close();
        return arrayList;
    }
}
