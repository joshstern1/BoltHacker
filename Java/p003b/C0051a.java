package p003b;

import java.io.IOException;
import java.io.InterruptedIOException;

public class C0051a extends ac {
    private static C0051a f227a;
    private boolean f228c;
    private C0051a f229d;
    private long f230e;

    private static final class C1015a extends Thread {
        public C1015a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                try {
                    C0051a e = C0051a.m329e();
                    if (e != null) {
                        e.mo49a();
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public final void m336c() {
        if (this.f228c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long p_ = p_();
        boolean q_ = q_();
        if (p_ != 0 || q_) {
            this.f228c = true;
            C0051a.m326a(this, p_, q_);
        }
    }

    private static synchronized void m326a(C0051a c0051a, long j, boolean z) {
        synchronized (C0051a.class) {
            if (f227a == null) {
                f227a = new C0051a();
                new C1015a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                c0051a.f230e = Math.min(j, c0051a.mo1123d() - nanoTime) + nanoTime;
            } else if (j != 0) {
                c0051a.f230e = nanoTime + j;
            } else if (z) {
                c0051a.f230e = c0051a.mo1123d();
            } else {
                throw new AssertionError();
            }
            long b = c0051a.m328b(nanoTime);
            C0051a c0051a2 = f227a;
            while (c0051a2.f229d != null && b >= c0051a2.f229d.m328b(nanoTime)) {
                c0051a2 = c0051a2.f229d;
            }
            c0051a.f229d = c0051a2.f229d;
            c0051a2.f229d = c0051a;
            if (c0051a2 == f227a) {
                C0051a.class.notify();
            }
        }
    }

    public final boolean o_() {
        if (!this.f228c) {
            return false;
        }
        this.f228c = false;
        return C0051a.m327a(this);
    }

    private static synchronized boolean m327a(C0051a c0051a) {
        boolean z;
        synchronized (C0051a.class) {
            for (C0051a c0051a2 = f227a; c0051a2 != null; c0051a2 = c0051a2.f229d) {
                if (c0051a2.f229d == c0051a) {
                    c0051a2.f229d = c0051a.f229d;
                    c0051a.f229d = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private long m328b(long j) {
        return this.f230e - j;
    }

    protected void mo49a() {
    }

    public final aa m330a(aa aaVar) {
        return new C1016b(this, aaVar);
    }

    public final ab m331a(ab abVar) {
        return new C1017c(this, abVar);
    }

    final void m334a(boolean z) throws IOException {
        if (o_() && z) {
            throw mo48a(null);
        }
    }

    final IOException m335b(IOException iOException) throws IOException {
        return !o_() ? iOException : mo48a(iOException);
    }

    protected IOException mo48a(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    static synchronized C0051a m329e() throws InterruptedException {
        C0051a c0051a = null;
        synchronized (C0051a.class) {
            C0051a c0051a2 = f227a.f229d;
            if (c0051a2 == null) {
                C0051a.class.wait();
            } else {
                long b = c0051a2.m328b(System.nanoTime());
                if (b > 0) {
                    long j = b / 1000000;
                    C0051a.class.wait(j, (int) (b - (1000000 * j)));
                } else {
                    f227a.f229d = c0051a2.f229d;
                    c0051a2.f229d = null;
                    c0051a = c0051a2;
                }
            }
        }
        return c0051a;
    }
}
