package com.p074e.p075a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class C1444v extends InputStream {
    private final InputStream f5512a;
    private long f5513b;
    private long f5514c;
    private long f5515d;
    private long f5516e;

    public C1444v(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public C1444v(InputStream inputStream, int i) {
        this.f5516e = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, i);
        }
        this.f5512a = inputStream;
    }

    public void mark(int i) {
        this.f5516e = m9182a(i);
    }

    public long m9182a(int i) {
        long j = this.f5513b + ((long) i);
        if (this.f5515d < j) {
            m9181b(j);
        }
        return this.f5513b;
    }

    private void m9181b(long j) {
        try {
            if (this.f5514c >= this.f5513b || this.f5513b > this.f5515d) {
                this.f5514c = this.f5513b;
                this.f5512a.mark((int) (j - this.f5513b));
            } else {
                this.f5512a.reset();
                this.f5512a.mark((int) (j - this.f5514c));
                m9180a(this.f5514c, this.f5513b);
            }
            this.f5515d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public void reset() throws IOException {
        m9183a(this.f5516e);
    }

    public void m9183a(long j) throws IOException {
        if (this.f5513b > this.f5515d || j < this.f5514c) {
            throw new IOException("Cannot reset");
        }
        this.f5512a.reset();
        m9180a(this.f5514c, j);
        this.f5513b = j;
    }

    private void m9180a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f5512a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public int read() throws IOException {
        int read = this.f5512a.read();
        if (read != -1) {
            this.f5513b++;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = this.f5512a.read(bArr);
        if (read != -1) {
            this.f5513b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f5512a.read(bArr, i, i2);
        if (read != -1) {
            this.f5513b += (long) read;
        }
        return read;
    }

    public long skip(long j) throws IOException {
        long skip = this.f5512a.skip(j);
        this.f5513b += skip;
        return skip;
    }

    public int available() throws IOException {
        return this.f5512a.available();
    }

    public void close() throws IOException {
        this.f5512a.close();
    }

    public boolean markSupported() {
        return this.f5512a.markSupported();
    }
}
