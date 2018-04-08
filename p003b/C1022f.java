package p003b;

import java.io.OutputStream;

class C1022f extends OutputStream {
    final /* synthetic */ C1021e f3953a;

    C1022f(C1021e c1021e) {
        this.f3953a = c1021e;
    }

    public void write(int i) {
        this.f3953a.m7342b((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f3953a.m7344b(bArr, i, i2);
    }

    public void flush() {
    }

    public void close() {
    }

    public String toString() {
        return this.f3953a + ".outputStream()";
    }
}
