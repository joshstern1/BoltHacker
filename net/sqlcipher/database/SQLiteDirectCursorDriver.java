package net.sqlcipher.database;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase.CursorFactory;

public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;
    private String mEditTable;
    private SQLiteQuery mQuery;
    private String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
    }

    public Cursor query(CursorFactory cursorFactory, String[] strArr) {
        SQLiteQuery sQLiteQuery;
        int i = 0;
        SQLiteQuery sQLiteQuery2 = new SQLiteQuery(this.mDatabase, this.mSql, 0, strArr);
        int length = strArr == null ? 0 : strArr.length;
        while (i < length) {
            try {
                sQLiteQuery2.bindString(i + 1, strArr[i]);
                i++;
            } catch (Throwable th) {
                Throwable th2 = th;
                sQLiteQuery = sQLiteQuery2;
            }
        }
        if (cursorFactory == null) {
            this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery2);
        } else {
            this.mCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery2);
        }
        this.mQuery = sQLiteQuery2;
        sQLiteQuery = null;
        try {
            Cursor cursor = this.mCursor;
            if (sQLiteQuery != null) {
                sQLiteQuery.close();
            }
            return cursor;
        } catch (Throwable th3) {
            th2 = th3;
            if (sQLiteQuery != null) {
                sQLiteQuery.close();
            }
            throw th2;
        }
    }

    public void cursorClosed() {
        this.mCursor = null;
    }

    public void setBindArguments(String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            this.mQuery.bindString(i + 1, strArr[i]);
        }
    }

    public void cursorDeactivated() {
    }

    public void cursorRequeried(android.database.Cursor cursor) {
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
