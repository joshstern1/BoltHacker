package p003b;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class C1025k implements aa {
    private final C1019h f3960a;
    private final Deflater f3961b;
    private boolean f3962c;

    public C1025k(aa aaVar, Deflater deflater) {
        this(C1029q.m7426a(aaVar), deflater);
    }

    C1025k(C1019h c1019h, Deflater deflater) {
        if (c1019h == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f3960a = c1019h;
            this.f3961b = deflater;
        }
    }

    public void mo8a(C1021e c1021e, long j) throws IOException {
        ae.m7284a(c1021e.f3952b, 0, j);
        while (j > 0) {
            C1036x c1036x = c1021e.f3951a;
            int min = (int) Math.min(j, (long) (c1036x.f3988c - c1036x.f3987b));
            this.f3961b.setInput(c1036x.f3986a, c1036x.f3987b, min);
            m7404a(false);
            c1021e.f3952b -= (long) min;
            c1036x.f3987b += min;
            if (c1036x.f3987b == c1036x.f3988c) {
                c1021e.f3951a = c1036x.m7469a();
                C1037y.m7475a(c1036x);
            }
            j -= (long) min;
        }
    }

    @IgnoreJRERequirement
    private void m7404a(boolean z) throws IOException {
        C1021e b = this.f3960a.mo1097b();
        while (true) {
            int deflate;
            C1036x e = b.m7356e(1);
            if (z) {
                deflate = this.f3961b.deflate(e.f3986a, e.f3988c, 8192 - e.f3988c, 2);
            } else {
                deflate = this.f3961b.deflate(e.f3986a, e.f3988c, 8192 - e.f3988c);
            }
            if (deflate > 0) {
                e.f3988c += deflate;
                b.f3952b += (long) deflate;
                this.f3960a.mo1122w();
            } else if (this.f3961b.needsInput()) {
                break;
            }
        }
        if (e.f3987b == e.f3988c) {
            b.f3951a = e.m7469a();
            C1037y.m7475a(e);
        }
    }

    public void flush() throws IOException {
        m7404a(true);
        this.f3960a.flush();
    }

    void m7405a() throws IOException {
        this.f3961b.finish();
        m7404a(false);
    }

    public void close() throws IOException {
        Throwable th;
        if (!this.f3962c) {
            Throwable th2 = null;
            try {
                m7405a();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f3961b.end();
                th = th2;
            } catch (Throwable th4) {
                th = th4;
                if (th2 != null) {
                    th = th2;
                }
            }
            try {
                this.f3960a.close();
            } catch (Throwable th22) {
                if (th == null) {
                    th = th22;
                }
            }
            this.f3962c = true;
            if (th != null) {
                ae.m7285a(th);
            }
        }
    }

    public ac timeout() {
        return this.f3960a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f3960a + ")";
    }
}
