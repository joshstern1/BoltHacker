package net.sqlcipher.database;

import android.os.SystemClock;

public class SQLiteStatement extends SQLiteProgram {
    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
        super(sQLiteDatabase, str);
    }

    public void execute() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public long executeInsert() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                uptimeMillis = this.mDatabase.lastChangeCount() > 0 ? this.mDatabase.lastInsertRow() : -1;
                releaseReference();
                this.mDatabase.unlock();
                return uptimeMillis;
            } catch (Throwable th) {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public int executeUpdateDelete() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                int lastChangeCount = this.mDatabase.lastChangeCount();
                return lastChangeCount;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public long simpleQueryForLong() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.mDatabase;
            j.lock();
            acquireReference();
            try {
                j = native_1x1_long();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                return j;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public String simpleQueryForString() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            String str = this.mDatabase;
            str.lock();
            acquireReference();
            try {
                str = native_1x1_string();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                return str;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }
}
