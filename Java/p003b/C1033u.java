package p003b;

import java.io.IOException;

final class C1033u implements C1019h {
    public final C1021e f3979a = new C1021e();
    public final aa f3980b;
    boolean f3981c;

    C1033u(aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f3980b = aaVar;
    }

    public C1021e mo1097b() {
        return this.f3979a;
    }

    public void mo8a(C1021e c1021e, long j) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.mo8a(c1021e, j);
        mo1122w();
    }

    public C1019h mo1098b(C1024j c1024j) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7331a(c1024j);
        return mo1122w();
    }

    public C1019h mo1099b(String str) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7332a(str);
        return mo1122w();
    }

    public C1019h mo1101c(byte[] bArr) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7343b(bArr);
        return mo1122w();
    }

    public C1019h mo1102c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7344b(bArr, i, i2);
        return mo1122w();
    }

    public long mo1095a(ab abVar) throws IOException {
        if (abVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = abVar.read(this.f3979a, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            mo1122w();
        }
    }

    public C1019h mo1111i(int i) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7342b(i);
        return mo1122w();
    }

    public C1019h mo1109h(int i) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7349c(i);
        return mo1122w();
    }

    public C1019h mo1106g(int i) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7354d(i);
        return mo1122w();
    }

    public C1019h mo1117l(long j) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7368i(j);
        return mo1122w();
    }

    public C1019h mo1114k(long j) throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        this.f3979a.m7372j(j);
        return mo1122w();
    }

    public C1019h mo1122w() throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        long g = this.f3979a.m7362g();
        if (g > 0) {
            this.f3980b.mo8a(this.f3979a, g);
        }
        return this;
    }

    public void flush() throws IOException {
        if (this.f3981c) {
            throw new IllegalStateException("closed");
        }
        if (this.f3979a.f3952b > 0) {
            this.f3980b.mo8a(this.f3979a, this.f3979a.f3952b);
        }
        this.f3980b.flush();
    }

    public void close() throws IOException {
        if (!this.f3981c) {
            Throwable th = null;
            try {
                if (this.f3979a.f3952b > 0) {
                    this.f3980b.mo8a(this.f3979a, this.f3979a.f3952b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f3980b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f3981c = true;
            if (th != null) {
                ae.m7285a(th);
            }
        }
    }

    public ac timeout() {
        return this.f3980b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f3980b + ")";
    }
}
