package p003b;

import java.io.InputStream;

class C1023g extends InputStream {
    final /* synthetic */ C1021e f3954a;

    C1023g(C1021e c1021e) {
        this.f3954a = c1021e;
    }

    public int read() {
        if (this.f3954a.f3952b > 0) {
            return this.f3954a.mo1108h() & 255;
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.f3954a.m7323a(bArr, i, i2);
    }

    public int available() {
        return (int) Math.min(this.f3954a.f3952b, 2147483647L);
    }

    public void close() {
    }

    public String toString() {
        return this.f3954a + ".inputStream()";
    }
}
