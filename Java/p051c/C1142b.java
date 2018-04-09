package com.p041a.p042a.p051c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

final class C1142b {
    public static final C1142b f4302a = new C1142b(new byte[0]);
    private final byte[] f4303b;
    private volatile int f4304c = 0;

    private C1142b(byte[] bArr) {
        this.f4303b = bArr;
    }

    public int m7836a() {
        return this.f4303b.length;
    }

    public static C1142b m7835a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new C1142b(obj);
    }

    public static C1142b m7834a(String str) {
        try {
            return new C1142b(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void m7837a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f4303b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1142b)) {
            return false;
        }
        C1142b c1142b = (C1142b) obj;
        int length = this.f4303b.length;
        if (length != c1142b.f4303b.length) {
            return false;
        }
        byte[] bArr = this.f4303b;
        byte[] bArr2 = c1142b.f4303b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f4304c;
        if (i == 0) {
            byte[] bArr = this.f4303b;
            int length = this.f4303b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.f4304c = i;
        }
        return i;
    }

    public InputStream m7838b() {
        return new ByteArrayInputStream(this.f4303b);
    }
}
