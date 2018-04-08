package p003b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

public final class C1028p implements ab {
    private final C1020i f3969a;
    private final Inflater f3970b;
    private int f3971c;
    private boolean f3972d;

    public C1028p(ab abVar, Inflater inflater) {
        this(C1029q.m7427a(abVar), inflater);
    }

    C1028p(C1020i c1020i, Inflater inflater) {
        if (c1020i == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f3969a = c1020i;
            this.f3970b = inflater;
        }
    }

    public long read(C1021e c1021e, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f3972d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean a;
            do {
                a = m7419a();
                try {
                    C1036x e = c1021e.m7356e(1);
                    int inflate = this.f3970b.inflate(e.f3986a, e.f3988c, 8192 - e.f3988c);
                    if (inflate > 0) {
                        e.f3988c += inflate;
                        c1021e.f3952b += (long) inflate;
                        return (long) inflate;
                    } else if (this.f3970b.finished() || this.f3970b.needsDictionary()) {
                        m7418b();
                        if (e.f3987b == e.f3988c) {
                            c1021e.f3951a = e.m7469a();
                            C1037y.m7475a(e);
                        }
                        return -1;
                    }
                } catch (Throwable e2) {
                    throw new IOException(e2);
                }
            } while (!a);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public boolean m7419a() throws IOException {
        if (!this.f3970b.needsInput()) {
            return false;
        }
        m7418b();
        if (this.f3970b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f3969a.mo1104e()) {
            return true;
        } else {
            C1036x c1036x = this.f3969a.mo1097b().f3951a;
            this.f3971c = c1036x.f3988c - c1036x.f3987b;
            this.f3970b.setInput(c1036x.f3986a, c1036x.f3987b, this.f3971c);
            return false;
        }
    }

    private void m7418b() throws IOException {
        if (this.f3971c != 0) {
            int remaining = this.f3971c - this.f3970b.getRemaining();
            this.f3971c -= remaining;
            this.f3969a.mo1110h((long) remaining);
        }
    }

    public ac timeout() {
        return this.f3969a.timeout();
    }

    public void close() throws IOException {
        if (!this.f3972d) {
            this.f3970b.end();
            this.f3972d = true;
            this.f3969a.close();
        }
    }
}
