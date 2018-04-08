package p003b;

import java.io.IOException;
import java.io.InputStream;

class C1035w extends InputStream {
    final /* synthetic */ C1034v f3985a;

    C1035w(C1034v c1034v) {
        this.f3985a = c1034v;
    }

    public int read() throws IOException {
        if (this.f3985a.f3984c) {
            throw new IOException("closed");
        } else if (this.f3985a.f3982a.f3952b == 0 && this.f3985a.f3983b.read(this.f3985a.f3982a, 8192) == -1) {
            return -1;
        } else {
            return this.f3985a.f3982a.mo1108h() & 255;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f3985a.f3984c) {
            throw new IOException("closed");
        }
        ae.m7284a((long) bArr.length, (long) i, (long) i2);
        if (this.f3985a.f3982a.f3952b == 0 && this.f3985a.f3983b.read(this.f3985a.f3982a, 8192) == -1) {
            return -1;
        }
        return this.f3985a.f3982a.m7323a(bArr, i, i2);
    }

    public int available() throws IOException {
        if (!this.f3985a.f3984c) {
            return (int) Math.min(this.f3985a.f3982a.f3952b, 2147483647L);
        }
        throw new IOException("closed");
    }

    public void close() throws IOException {
        this.f3985a.close();
    }

    public String toString() {
        return this.f3985a + ".inputStream()";
    }
}
