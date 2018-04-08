package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CursorWindow extends android.database.CursorWindow implements Parcelable {
    public static final Creator<CursorWindow> CREATOR = new C30811();
    private int mStartPos;
    private int nWindow;

    final class C30811 implements Creator<CursorWindow> {
        C30811() {
        }

        public CursorWindow createFromParcel(Parcel parcel) {
            return new CursorWindow(parcel, 0);
        }

        public CursorWindow[] newArray(int i) {
            return new CursorWindow[i];
        }
    }

    private native boolean allocRow_native();

    private native void close_native();

    private native char[] copyStringToBuffer_native(int i, int i2, int i3, CharArrayBuffer charArrayBuffer);

    private native void freeLastRow_native();

    private native byte[] getBlob_native(int i, int i2);

    private native double getDouble_native(int i, int i2);

    private native long getLong_native(int i, int i2);

    private native int getNumRows_native();

    private native String getString_native(int i, int i2);

    private native int getType_native(int i, int i2);

    private native boolean isBlob_native(int i, int i2);

    private native boolean isFloat_native(int i, int i2);

    private native boolean isInteger_native(int i, int i2);

    private native boolean isNull_native(int i, int i2);

    private native boolean isString_native(int i, int i2);

    private native void native_clear();

    private native IBinder native_getBinder();

    private native void native_init(IBinder iBinder);

    private native void native_init(boolean z);

    private native boolean putBlob_native(byte[] bArr, int i, int i2);

    private native boolean putDouble_native(double d, int i, int i2);

    private native boolean putLong_native(long j, int i, int i2);

    private native boolean putNull_native(int i, int i2);

    private native boolean putString_native(String str, int i, int i2);

    private native boolean setNumColumns_native(int i);

    public CursorWindow(boolean z) {
        super(z);
        this.mStartPos = 0;
        native_init(z);
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public void setStartPosition(int i) {
        this.mStartPos = i;
    }

    public int getNumRows() {
        acquireReference();
        try {
            int numRows_native = getNumRows_native();
            return numRows_native;
        } finally {
            releaseReference();
        }
    }

    public boolean setNumColumns(int i) {
        acquireReference();
        try {
            boolean numColumns_native = setNumColumns_native(i);
            return numColumns_native;
        } finally {
            releaseReference();
        }
    }

    public boolean allocRow() {
        acquireReference();
        try {
            boolean allocRow_native = allocRow_native();
            return allocRow_native;
        } finally {
            releaseReference();
        }
    }

    public void freeLastRow() {
        acquireReference();
        try {
            freeLastRow_native();
        } finally {
            releaseReference();
        }
    }

    public boolean putBlob(byte[] bArr, int i, int i2) {
        acquireReference();
        try {
            boolean putBlob_native = putBlob_native(bArr, i - this.mStartPos, i2);
            return putBlob_native;
        } finally {
            releaseReference();
        }
    }

    public boolean putString(String str, int i, int i2) {
        acquireReference();
        try {
            boolean putString_native = putString_native(str, i - this.mStartPos, i2);
            return putString_native;
        } finally {
            releaseReference();
        }
    }

    public boolean putLong(long j, int i, int i2) {
        acquireReference();
        try {
            boolean putLong_native = putLong_native(j, i - this.mStartPos, i2);
            return putLong_native;
        } finally {
            releaseReference();
        }
    }

    public boolean putDouble(double d, int i, int i2) {
        acquireReference();
        try {
            boolean putDouble_native = putDouble_native(d, i - this.mStartPos, i2);
            return putDouble_native;
        } finally {
            releaseReference();
        }
    }

    public boolean putNull(int i, int i2) {
        acquireReference();
        try {
            boolean putNull_native = putNull_native(i - this.mStartPos, i2);
            return putNull_native;
        } finally {
            releaseReference();
        }
    }

    public boolean isNull(int i, int i2) {
        acquireReference();
        try {
            boolean isNull_native = isNull_native(i - this.mStartPos, i2);
            return isNull_native;
        } finally {
            releaseReference();
        }
    }

    public byte[] getBlob(int i, int i2) {
        acquireReference();
        try {
            byte[] blob_native = getBlob_native(i - this.mStartPos, i2);
            return blob_native;
        } finally {
            releaseReference();
        }
    }

    public int getType(int i, int i2) {
        acquireReference();
        try {
            int type_native = getType_native(i - this.mStartPos, i2);
            return type_native;
        } finally {
            releaseReference();
        }
    }

    public boolean isBlob(int i, int i2) {
        acquireReference();
        try {
            boolean isBlob_native = isBlob_native(i - this.mStartPos, i2);
            return isBlob_native;
        } finally {
            releaseReference();
        }
    }

    public boolean isLong(int i, int i2) {
        acquireReference();
        try {
            boolean isInteger_native = isInteger_native(i - this.mStartPos, i2);
            return isInteger_native;
        } finally {
            releaseReference();
        }
    }

    public boolean isFloat(int i, int i2) {
        acquireReference();
        try {
            boolean isFloat_native = isFloat_native(i - this.mStartPos, i2);
            return isFloat_native;
        } finally {
            releaseReference();
        }
    }

    public boolean isString(int i, int i2) {
        acquireReference();
        try {
            boolean isString_native = isString_native(i - this.mStartPos, i2);
            return isString_native;
        } finally {
            releaseReference();
        }
    }

    public String getString(int i, int i2) {
        acquireReference();
        try {
            String string_native = getString_native(i - this.mStartPos, i2);
            return string_native;
        } finally {
            releaseReference();
        }
    }

    public void copyStringToBuffer(int i, int i2, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
        if (charArrayBuffer.data == null) {
            charArrayBuffer.data = new char[64];
        }
        acquireReference();
        try {
            char[] copyStringToBuffer_native = copyStringToBuffer_native(i - this.mStartPos, i2, charArrayBuffer.data.length, charArrayBuffer);
            if (copyStringToBuffer_native != null) {
                charArrayBuffer.data = copyStringToBuffer_native;
            }
            releaseReference();
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public long getLong(int i, int i2) {
        acquireReference();
        try {
            long long_native = getLong_native(i - this.mStartPos, i2);
            return long_native;
        } finally {
            releaseReference();
        }
    }

    public double getDouble(int i, int i2) {
        acquireReference();
        try {
            double double_native = getDouble_native(i - this.mStartPos, i2);
            return double_native;
        } finally {
            releaseReference();
        }
    }

    public short getShort(int i, int i2) {
        acquireReference();
        try {
            short long_native = (short) ((int) getLong_native(i - this.mStartPos, i2));
            return long_native;
        } finally {
            releaseReference();
        }
    }

    public int getInt(int i, int i2) {
        acquireReference();
        try {
            int long_native = (int) getLong_native(i - this.mStartPos, i2);
            return long_native;
        } finally {
            releaseReference();
        }
    }

    public float getFloat(int i, int i2) {
        acquireReference();
        try {
            float double_native = (float) getDouble_native(i - this.mStartPos, i2);
            return double_native;
        } finally {
            releaseReference();
        }
    }

    public void clear() {
        acquireReference();
        try {
            this.mStartPos = 0;
            native_clear();
        } finally {
            releaseReference();
        }
    }

    public void close() {
        releaseReference();
    }

    protected void finalize() {
        if (this.nWindow != 0) {
            close_native();
        }
    }

    public static CursorWindow newFromParcel(Parcel parcel) {
        return (CursorWindow) CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(native_getBinder());
        parcel.writeInt(this.mStartPos);
    }

    public CursorWindow(Parcel parcel, int i) {
        super(true);
        IBinder readStrongBinder = parcel.readStrongBinder();
        this.mStartPos = parcel.readInt();
        native_init(readStrongBinder);
    }

    protected void onAllReferencesReleased() {
        close_native();
        super.onAllReferencesReleased();
    }
}
