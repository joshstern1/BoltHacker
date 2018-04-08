package net.sqlcipher;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    public byte[] getBlob(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                byte[] bArr = (byte[]) getUpdatedField(i);
                return bArr;
            }
            return this.mWindow.getBlob(this.mPos, i);
        }
    }

    public String getString(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                String str = (String) getUpdatedField(i);
                return str;
            }
            return this.mWindow.getString(this.mPos, i);
        }
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                super.copyStringToBuffer(i, charArrayBuffer);
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i, charArrayBuffer);
    }

    public short getShort(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                short shortValue = ((Number) getUpdatedField(i)).shortValue();
                return shortValue;
            }
            return this.mWindow.getShort(this.mPos, i);
        }
    }

    public int getInt(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                int intValue = ((Number) getUpdatedField(i)).intValue();
                return intValue;
            }
            return this.mWindow.getInt(this.mPos, i);
        }
    }

    public long getLong(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                long longValue = ((Number) getUpdatedField(i)).longValue();
                return longValue;
            }
            return this.mWindow.getLong(this.mPos, i);
        }
    }

    public float getFloat(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                float floatValue = ((Number) getUpdatedField(i)).floatValue();
                return floatValue;
            }
            return this.mWindow.getFloat(this.mPos, i);
        }
    }

    public double getDouble(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                double doubleValue = ((Number) getUpdatedField(i)).doubleValue();
                return doubleValue;
            }
            return this.mWindow.getDouble(this.mPos, i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isNull(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r1 = r2.mUpdatedRows;
        monitor-enter(r1);
        r0 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0017;
    L_0x000c:
        r0 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x0015;
    L_0x0012:
        r0 = 1;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = 0;
        goto L_0x0013;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r0 = r0.isNull(r1, r3);
        goto L_0x0014;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isNull(int):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isBlob(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r1 = r2.mUpdatedRows;
        monitor-enter(r1);
        r0 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x001b;
    L_0x000c:
        r0 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r0 instanceof byte[];	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0 = 1;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = 0;
        goto L_0x0017;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r0 = r0.isBlob(r1, r3);
        goto L_0x0018;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isBlob(int):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isString(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r1 = r2.mUpdatedRows;
        monitor-enter(r1);
        r0 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x001b;
    L_0x000c:
        r0 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r0 instanceof java.lang.String;	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0 = 1;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = 0;
        goto L_0x0017;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r0 = r0.isString(r1, r3);
        goto L_0x0018;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isString(int):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLong(int r4) {
        /*
        r3 = this;
        r3.checkPosition();
        r1 = r3.mUpdatedRows;
        monitor-enter(r1);
        r0 = r3.isFieldUpdated(r4);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001f;
    L_0x000c:
        r0 = r3.getUpdatedField(r4);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r2 = r0 instanceof java.lang.Integer;	 Catch:{ all -> 0x0029 }
        if (r2 != 0) goto L_0x001a;
    L_0x0016:
        r0 = r0 instanceof java.lang.Long;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001d;
    L_0x001a:
        r0 = 1;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x001c:
        return r0;
    L_0x001d:
        r0 = 0;
        goto L_0x001b;
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        r0 = r3.mWindow;
        r1 = r3.mPos;
        r0 = r0.isLong(r1, r4);
        goto L_0x001c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isLong(int):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isFloat(int r4) {
        /*
        r3 = this;
        r3.checkPosition();
        r1 = r3.mUpdatedRows;
        monitor-enter(r1);
        r0 = r3.isFieldUpdated(r4);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001f;
    L_0x000c:
        r0 = r3.getUpdatedField(r4);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r2 = r0 instanceof java.lang.Float;	 Catch:{ all -> 0x0029 }
        if (r2 != 0) goto L_0x001a;
    L_0x0016:
        r0 = r0 instanceof java.lang.Double;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x001d;
    L_0x001a:
        r0 = 1;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x001c:
        return r0;
    L_0x001d:
        r0 = 0;
        goto L_0x001b;
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        r0 = r3.mWindow;
        r1 = r3.mPos;
        r0 = r0.isFloat(r1, r4);
        goto L_0x001c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isFloat(int):boolean");
    }

    public int getType(int i) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i);
    }

    protected void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Access closed cursor");
        }
    }

    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mWindow.close();
        }
        this.mWindow = cursorWindow;
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }
}
