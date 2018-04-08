package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase.CursorFactory;

public abstract class SQLiteOpenHelper {
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final DatabaseErrorHandler mErrorHandler;
    private final CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        } else if (databaseErrorHandler == null) {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        } else {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i;
            this.mHook = sQLiteDatabaseHook;
            this.mErrorHandler = databaseErrorHandler;
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase(String str) {
        return getWritableDatabase(str.toCharArray());
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] cArr) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2 = null;
        synchronized (this) {
            if (this.mDatabase != null && this.mDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                sQLiteDatabase = this.mDatabase;
            } else if (this.mIsInitializing) {
                throw new IllegalStateException("getWritableDatabase called recursively");
            } else {
                if (this.mDatabase != null) {
                    this.mDatabase.lock();
                }
                try {
                    this.mIsInitializing = true;
                    if (this.mName == null) {
                        sQLiteDatabase = SQLiteDatabase.create(null, cArr);
                    } else {
                        String path = this.mContext.getDatabasePath(this.mName).getPath();
                        File file = new File(path);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                        }
                        sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(path, cArr, this.mFactory, this.mHook, this.mErrorHandler);
                    }
                    try {
                        int version = sQLiteDatabase.getVersion();
                        if (version != this.mNewVersion) {
                            sQLiteDatabase.beginTransaction();
                            if (version == 0) {
                                onCreate(sQLiteDatabase);
                            } else {
                                onUpgrade(sQLiteDatabase, version, this.mNewVersion);
                            }
                            sQLiteDatabase.setVersion(this.mNewVersion);
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                        }
                        onOpen(sQLiteDatabase);
                        this.mIsInitializing = false;
                        if (this.mDatabase != null) {
                            try {
                                this.mDatabase.close();
                            } catch (Exception e) {
                            }
                            this.mDatabase.unlock();
                        }
                        this.mDatabase = sQLiteDatabase;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        sQLiteDatabase2 = sQLiteDatabase;
                        th = th3;
                        this.mIsInitializing = false;
                        if (this.mDatabase != null) {
                            this.mDatabase.unlock();
                        }
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    this.mIsInitializing = false;
                    if (this.mDatabase != null) {
                        this.mDatabase.unlock();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            }
        }
        return sQLiteDatabase;
    }

    public synchronized SQLiteDatabase getReadableDatabase(String str) {
        return getReadableDatabase(str.toCharArray());
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] cArr) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        boolean exists;
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            sQLiteDatabase = this.mDatabase;
        } else if (this.mIsInitializing) {
            throw new IllegalStateException("getReadableDatabase called recursively");
        } else {
            try {
                sQLiteDatabase = getWritableDatabase(cArr);
            } catch (SQLiteException e) {
                boolean e2 = e;
                if (this.mName == null) {
                    throw e2;
                }
                Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e2);
                sQLiteDatabase2 = null;
                this.mIsInitializing = e2;
                String path = this.mContext.getDatabasePath(this.mName).getPath();
                File file = new File(path);
                File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                exists = file.exists();
                if (!exists) {
                    this.mIsInitializing = exists;
                    sQLiteDatabase2 = getWritableDatabase(cArr);
                    this.mIsInitializing = true;
                    sQLiteDatabase2.close();
                }
                sQLiteDatabase2 = SQLiteDatabase.openDatabase(path, cArr, this.mFactory, 1);
                if (sQLiteDatabase2.getVersion() != this.mNewVersion) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase2.getVersion() + " to " + this.mNewVersion + ": " + path);
                }
                onOpen(sQLiteDatabase2);
                Log.w(TAG, "Opened " + this.mName + " in read-only mode");
                this.mDatabase = sQLiteDatabase2;
                sQLiteDatabase = this.mDatabase;
                this.mIsInitializing = false;
                if (!(sQLiteDatabase2 == null || sQLiteDatabase2 == this.mDatabase)) {
                    sQLiteDatabase2.close();
                }
            } finally {
                exists = false;
                this.mIsInitializing = false;
                if (!(sQLiteDatabase2 == null || sQLiteDatabase2 == this.mDatabase)) {
                    sQLiteDatabase2.close();
                }
            }
        }
        return sQLiteDatabase;
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        } else if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }
}
