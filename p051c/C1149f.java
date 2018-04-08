package com.p041a.p042a.p051c;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class C1149f implements Flushable {
    private final byte[] f4332a;
    private final int f4333b;
    private int f4334c = 0;
    private final OutputStream f4335d;

    static class C1148a extends IOException {
        C1148a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C1149f(OutputStream outputStream, byte[] bArr) {
        this.f4335d = outputStream;
        this.f4332a = bArr;
        this.f4333b = bArr.length;
    }

    public static C1149f m7892a(OutputStream outputStream) {
        return C1149f.m7893a(outputStream, 4096);
    }

    public static C1149f m7893a(OutputStream outputStream, int i) {
        return new C1149f(outputStream, new byte[i]);
    }

    public void m7917a(int i, float f) throws IOException {
        m7935g(i, 5);
        m7915a(f);
    }

    public void m7919a(int i, long j) throws IOException {
        m7935g(i, 0);
        m7922a(j);
    }

    public void m7921a(int i, boolean z) throws IOException {
        m7935g(i, 0);
        m7925a(z);
    }

    public void m7920a(int i, C1142b c1142b) throws IOException {
        m7935g(i, 2);
        m7923a(c1142b);
    }

    public void m7918a(int i, int i2) throws IOException {
        m7935g(i, 0);
        m7928b(i2);
    }

    public void m7929b(int i, int i2) throws IOException {
        m7935g(i, 0);
        m7930c(i2);
    }

    public void m7931c(int i, int i2) throws IOException {
        m7935g(i, 0);
        m7934d(i2);
    }

    public void m7915a(float f) throws IOException {
        m7938m(Float.floatToRawIntBits(f));
    }

    public void m7922a(long j) throws IOException {
        m7932c(j);
    }

    public void m7916a(int i) throws IOException {
        if (i >= 0) {
            m7937k(i);
        } else {
            m7932c((long) i);
        }
    }

    public void m7925a(boolean z) throws IOException {
        m7936i(z ? 1 : 0);
    }

    public void m7923a(C1142b c1142b) throws IOException {
        m7937k(c1142b.m7836a());
        m7933c(c1142b);
    }

    public void m7928b(int i) throws IOException {
        m7937k(i);
    }

    public void m7930c(int i) throws IOException {
        m7916a(i);
    }

    public void m7934d(int i) throws IOException {
        m7937k(C1149f.m7913n(i));
    }

    public static int m7896b(int i, float f) {
        return C1149f.m7911j(i) + C1149f.m7895b(f);
    }

    public static int m7897b(int i, long j) {
        return C1149f.m7911j(i) + C1149f.m7900b(j);
    }

    public static int m7899b(int i, boolean z) {
        return C1149f.m7911j(i) + C1149f.m7902b(z);
    }

    public static int m7898b(int i, C1142b c1142b) {
        return C1149f.m7911j(i) + C1149f.m7901b(c1142b);
    }

    public static int m7903d(int i, int i2) {
        return C1149f.m7911j(i) + C1149f.m7907f(i2);
    }

    public static int m7906e(int i, int i2) {
        return C1149f.m7911j(i) + C1149f.m7909g(i2);
    }

    public static int m7908f(int i, int i2) {
        return C1149f.m7911j(i) + C1149f.m7910h(i2);
    }

    public static int m7895b(float f) {
        return 4;
    }

    public static int m7900b(long j) {
        return C1149f.m7904d(j);
    }

    public static int m7905e(int i) {
        if (i >= 0) {
            return C1149f.m7912l(i);
        }
        return 10;
    }

    public static int m7902b(boolean z) {
        return 1;
    }

    public static int m7901b(C1142b c1142b) {
        return C1149f.m7912l(c1142b.m7836a()) + c1142b.m7836a();
    }

    public static int m7907f(int i) {
        return C1149f.m7912l(i);
    }

    public static int m7909g(int i) {
        return C1149f.m7905e(i);
    }

    public static int m7910h(int i) {
        return C1149f.m7912l(C1149f.m7913n(i));
    }

    private void m7894a() throws IOException {
        if (this.f4335d == null) {
            throw new C1148a();
        }
        this.f4335d.write(this.f4332a, 0, this.f4334c);
        this.f4334c = 0;
    }

    public void flush() throws IOException {
        if (this.f4335d != null) {
            m7894a();
        }
    }

    public void m7914a(byte b) throws IOException {
        if (this.f4334c == this.f4333b) {
            m7894a();
        }
        byte[] bArr = this.f4332a;
        int i = this.f4334c;
        this.f4334c = i + 1;
        bArr[i] = b;
    }

    public void m7936i(int i) throws IOException {
        m7914a((byte) i);
    }

    public void m7933c(C1142b c1142b) throws IOException {
        m7924a(c1142b, 0, c1142b.m7836a());
    }

    public void m7926a(byte[] bArr) throws IOException {
        m7927a(bArr, 0, bArr.length);
    }

    public void m7927a(byte[] bArr, int i, int i2) throws IOException {
        if (this.f4333b - this.f4334c >= i2) {
            System.arraycopy(bArr, i, this.f4332a, this.f4334c, i2);
            this.f4334c += i2;
            return;
        }
        int i3 = this.f4333b - this.f4334c;
        System.arraycopy(bArr, i, this.f4332a, this.f4334c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f4334c = this.f4333b;
        m7894a();
        if (i3 <= this.f4333b) {
            System.arraycopy(bArr, i4, this.f4332a, 0, i3);
            this.f4334c = i3;
            return;
        }
        this.f4335d.write(bArr, i4, i3);
    }

    public void m7924a(C1142b c1142b, int i, int i2) throws IOException {
        if (this.f4333b - this.f4334c >= i2) {
            c1142b.m7837a(this.f4332a, i, this.f4334c, i2);
            this.f4334c += i2;
            return;
        }
        int i3 = this.f4333b - this.f4334c;
        c1142b.m7837a(this.f4332a, i, this.f4334c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f4334c = this.f4333b;
        m7894a();
        if (i3 <= this.f4333b) {
            c1142b.m7837a(this.f4332a, i4, 0, i3);
            this.f4334c = i3;
            return;
        }
        InputStream b = c1142b.m7838b();
        if (((long) i4) != b.skip((long) i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.f4333b);
            int read = b.read(this.f4332a, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed.");
            }
            this.f4335d.write(this.f4332a, 0, read);
            i3 -= read;
        }
    }

    public void m7935g(int i, int i2) throws IOException {
        m7937k(bh.m7885a(i, i2));
    }

    public static int m7911j(int i) {
        return C1149f.m7912l(bh.m7885a(i, 0));
    }

    public void m7937k(int i) throws IOException {
        while ((i & -128) != 0) {
            m7936i((i & 127) | 128);
            i >>>= 7;
        }
        m7936i(i);
    }

    public static int m7912l(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public void m7932c(long j) throws IOException {
        while ((-128 & j) != 0) {
            m7936i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m7936i((int) j);
    }

    public static int m7904d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    public void m7938m(int i) throws IOException {
        m7936i(i & 255);
        m7936i((i >> 8) & 255);
        m7936i((i >> 16) & 255);
        m7936i((i >> 24) & 255);
    }

    public static int m7913n(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
