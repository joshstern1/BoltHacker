package net.sqlcipher.database;

import android.os.SystemClock;
import android.util.Log;
import net.sqlcipher.CursorWindow;

public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private boolean mClosed = false;
    private int mOffsetIndex;

    private final native int native_column_count();

    private final native String native_column_name(int i);

    private final native int native_fill_window(CursorWindow cursorWindow, int i, int i2, int i3, int i4);

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i;
        this.mBindArgs = strArr;
    }

    int fillWindow(CursorWindow cursorWindow, int i, int i2) {
        int native_fill_window;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mDatabase.lock();
        this.mDatabase.logTimeStat(this.mSql, uptimeMillis, "GETLOCK:");
        try {
            acquireReference();
            cursorWindow.acquireReference();
            native_fill_window = native_fill_window(cursorWindow, cursorWindow.getStartPosition(), this.mOffsetIndex, i, i2);
            if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                Log.d(TAG, "fillWindow(): " + this.mSql);
            }
            this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
            cursorWindow.releaseReference();
            releaseReference();
            this.mDatabase.unlock();
        } catch (IllegalStateException e) {
            native_fill_window = 0;
            cursorWindow.releaseReference();
            releaseReference();
            this.mDatabase.unlock();
        } catch (SQLiteDatabaseCorruptException e2) {
            this.mDatabase.onCorruption();
            throw e2;
        } catch (Throwable th) {
            cursorWindow.releaseReference();
        }
        return native_fill_window;
    }

    int columnCountLocked() {
        acquireReference();
        try {
            int native_column_count = native_column_count();
            return native_column_count;
        } finally {
            releaseReference();
        }
    }

    String columnNameLocked(int i) {
        acquireReference();
        try {
            String native_column_name = native_column_name(i);
            return native_column_name;
        } finally {
            releaseReference();
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    public void close() {
        super.close();
        this.mClosed = true;
    }

    void requery() {
        int i = 0;
        if (this.mBindArgs != null) {
            int length = this.mBindArgs.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    super.bindString(i2 + 1, this.mBindArgs[i2]);
                    i2++;
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder("mSql " + this.mSql);
                    while (i < length) {
                        stringBuilder.append(" ");
                        stringBuilder.append(this.mBindArgs[i]);
                        i++;
                    }
                    stringBuilder.append(" ");
                    throw new IllegalStateException(stringBuilder.toString(), e);
                }
            }
        }
    }

    public void bindNull(int i) {
        this.mBindArgs[i - 1] = null;
        if (!this.mClosed) {
            super.bindNull(i);
        }
    }

    public void bindLong(int i, long j) {
        this.mBindArgs[i - 1] = Long.toString(j);
        if (!this.mClosed) {
            super.bindLong(i, j);
        }
    }

    public void bindDouble(int i, double d) {
        this.mBindArgs[i - 1] = Double.toString(d);
        if (!this.mClosed) {
            super.bindDouble(i, d);
        }
    }

    public void bindString(int i, String str) {
        this.mBindArgs[i - 1] = str;
        if (!this.mClosed) {
            super.bindString(i, str);
        }
    }
}
