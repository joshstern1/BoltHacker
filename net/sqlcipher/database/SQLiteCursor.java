package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private Map<String, Integer> mColumnNameMap;
    private String[] mColumns;
    private int mCount = -1;
    private int mCursorState = 0;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    private int mInitialRead = Integer.MAX_VALUE;
    private ReentrantLock mLock = null;
    private int mMaxRead = Integer.MAX_VALUE;
    protected MainThreadNotificationHandler mNotificationHandler;
    private boolean mPendingData = false;
    private SQLiteQuery mQuery;
    private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();

    protected class MainThreadNotificationHandler extends Handler {
        protected MainThreadNotificationHandler() {
        }

        public void handleMessage(Message message) {
            SQLiteCursor.this.notifyDataSetChange();
        }
    }

    private final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int i) {
            this.mThreadState = i;
        }

        private void sendMessage() {
            if (SQLiteCursor.this.mNotificationHandler != null) {
                SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
                SQLiteCursor.this.mPendingData = false;
                return;
            }
            SQLiteCursor.this.mPendingData = true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r4 = this;
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mWindow;
            r1 = android.os.Process.myTid();
            r2 = 10;
            android.os.Process.setThreadPriority(r1, r2);
        L_0x000f:
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mLock;
            r1.lock();
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mCursorState;
            r2 = r4.mThreadState;
            if (r1 == r2) goto L_0x002c;
        L_0x0022:
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mLock;
            r0.unlock();
        L_0x002b:
            return;
        L_0x002c:
            r1 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r1 = r1.mQuery;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r2 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r2 = r2.mMaxRead;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r3 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r3 = r3.mCount;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r1 = r1.fillWindow(r0, r2, r3);	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            if (r1 == 0) goto L_0x0071;
        L_0x0044:
            r2 = -1;
            if (r1 != r2) goto L_0x005f;
        L_0x0047:
            r1 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r2 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r2 = r2.mMaxRead;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            net.sqlcipher.database.SQLiteCursor.access$512(r1, r2);	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r4.sendMessage();	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mLock;
            r1.unlock();
            goto L_0x000f;
        L_0x005f:
            r0 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r0.mCount = r1;	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r4.sendMessage();	 Catch:{ Exception -> 0x007b, all -> 0x0086 }
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mLock;
            r0.unlock();
            goto L_0x002b;
        L_0x0071:
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mLock;
            r0.unlock();
            goto L_0x002b;
        L_0x007b:
            r0 = move-exception;
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mLock;
            r0.unlock();
            goto L_0x002b;
        L_0x0086:
            r0 = move-exception;
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mLock;
            r1.unlock();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCursor.QueryThread.run():void");
        }
    }

    static /* synthetic */ int access$512(SQLiteCursor sQLiteCursor, int i) {
        int i2 = sQLiteCursor.mCount + i;
        sQLiteCursor.mCount = i2;
        return i2;
    }

    public void setLoadStyle(int i, int i2) {
        this.mMaxRead = i2;
        this.mInitialRead = i;
        this.mLock = new ReentrantLock(true);
    }

    private void queryThreadLock() {
        if (this.mLock != null) {
            this.mLock.lock();
        }
    }

    private void queryThreadUnlock() {
        if (this.mLock != null) {
            this.mLock.unlock();
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if (!(Integer.MAX_VALUE == this.mMaxRead && Integer.MAX_VALUE == this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler();
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
                queryThreadUnlock();
            } catch (Throwable th) {
                queryThreadUnlock();
            }
        }
    }

    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        int i = 0;
        this.mDatabase = sQLiteDatabase;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.mQuery = sQLiteQuery;
        try {
            sQLiteDatabase.lock();
            int columnCountLocked = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCountLocked];
            while (i < columnCountLocked) {
                String columnNameLocked = this.mQuery.columnNameLocked(i);
                this.mColumns[i] = columnNameLocked;
                if ("_id".equals(columnNameLocked)) {
                    this.mRowIdColumnIndex = i;
                }
                i++;
            }
        } finally {
            sQLiteDatabase.unlock();
        }
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public boolean onMove(int i, int i2) {
        if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i2);
        }
        return true;
    }

    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    private void fillWindow(int i) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = this.mInitialRead + i;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    public int getColumnIndex(String str) {
        int i;
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            Map hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str.lastIndexOf(46);
        if (i != -1) {
            Log.e(TAG, "requesting column name with table name -- " + str, new Exception());
            str = str.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public boolean deleteRow() {
        SQLiteDatabase sQLiteDatabase = null;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            Log.e(TAG, "Could not delete row because either the row ID column is not available or ithas not been read.");
            return false;
        }
        boolean z;
        this.mDatabase.lock();
        try {
            this.mDatabase.delete(this.mEditTable, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[]{this.mCurrentRowID.toString()});
            z = true;
        } catch (SQLException e) {
            z = null;
        }
        try {
            int i = this.mPos;
            requery();
            moveToPosition(i);
            if (!z) {
                return sQLiteDatabase;
            }
            onChange(true);
            return true;
        } finally {
            sQLiteDatabase = this.mDatabase;
            sQLiteDatabase.unlock();
        }
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (supportsUpdates()) {
            synchronized (this.mUpdatedRows) {
                if (map != null) {
                    this.mUpdatedRows.putAll(map);
                }
                if (this.mUpdatedRows.size() == 0) {
                    return true;
                }
                this.mDatabase.beginTransaction();
                try {
                    StringBuilder stringBuilder = new StringBuilder(128);
                    for (Entry entry : this.mUpdatedRows.entrySet()) {
                        Entry entry2;
                        Map map2 = (Map) entry2.getValue();
                        Long l = (Long) entry2.getKey();
                        if (l == null || map2 == null) {
                            throw new IllegalStateException("null rowId or values found! rowId = " + l + ", values = " + map2);
                        } else if (map2.size() != 0) {
                            long longValue = l.longValue();
                            Iterator it = map2.entrySet().iterator();
                            stringBuilder.setLength(0);
                            stringBuilder.append("UPDATE " + this.mEditTable + " SET ");
                            Object[] objArr = new Object[map2.size()];
                            int i = 0;
                            while (it.hasNext()) {
                                entry2 = (Entry) it.next();
                                stringBuilder.append((String) entry2.getKey());
                                stringBuilder.append("=?");
                                objArr[i] = entry2.getValue();
                                if (it.hasNext()) {
                                    stringBuilder.append(", ");
                                }
                                i++;
                            }
                            stringBuilder.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + '=' + longValue);
                            stringBuilder.append(';');
                            this.mDatabase.execSQL(stringBuilder.toString(), objArr);
                            this.mDatabase.rowUpdated(this.mEditTable, longValue);
                        }
                    }
                    this.mDatabase.setTransactionSuccessful();
                    this.mDatabase.endTransaction();
                    this.mUpdatedRows.clear();
                    onChange(true);
                    return true;
                } catch (Throwable th) {
                    this.mDatabase.endTransaction();
                }
            }
        } else {
            Log.e(TAG, "commitUpdates not supported on this cursor, did you include the _id column?");
            return false;
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
    }

    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            if (this.mWindow != null) {
                this.mWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            this.mQuery.requery();
            queryThreadUnlock();
            this.mDatabase.unlock();
            return super.requery();
        } catch (Throwable th) {
            this.mDatabase.unlock();
        }
    }

    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                this.mCount = -1;
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow = cursorWindow;
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    protected void finalize() {
        int i = 100;
        try {
            if (this.mWindow != null) {
                int length = this.mQuery.mSql.length();
                String str = TAG;
                StringBuilder append = new StringBuilder().append("Finalizing a Cursor that has not been deactivated or closed. database = ").append(this.mDatabase.getPath()).append(", table = ").append(this.mEditTable).append(", query = ");
                String str2 = this.mQuery.mSql;
                if (length <= 100) {
                    i = length;
                }
                Log.e(str, append.append(str2.substring(0, i)).toString(), this.mStackTrace);
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void fillWindow(int i, android.database.CursorWindow cursorWindow) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = this.mInitialRead + i;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }
}
