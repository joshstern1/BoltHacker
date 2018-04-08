package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class ap {
    private static ap f1289a;
    private final Object f1290b = new Object();
    private final Handler f1291c = new Handler(Looper.getMainLooper(), new aq(this));
    private C0256b f1292d;
    private C0256b f1293e;

    interface C0255a {
        void m1948a();

        void m1949a(int i);
    }

    private static class C0256b {
        private final WeakReference<C0255a> f1287a;
        private int f1288b;

        boolean m1952a(C0255a c0255a) {
            return c0255a != null && this.f1287a.get() == c0255a;
        }
    }

    static ap m1953a() {
        if (f1289a == null) {
            f1289a = new ap();
        }
        return f1289a;
    }

    private ap() {
    }

    public void m1962a(C0255a c0255a, int i) {
        synchronized (this.f1290b) {
            if (m1959f(c0255a)) {
                m1956a(this.f1292d, i);
            } else if (m1960g(c0255a)) {
                m1956a(this.f1293e, i);
            }
        }
    }

    public void m1961a(C0255a c0255a) {
        synchronized (this.f1290b) {
            if (m1959f(c0255a)) {
                this.f1292d = null;
                if (this.f1293e != null) {
                    m1957b();
                }
            }
        }
    }

    public void m1963b(C0255a c0255a) {
        synchronized (this.f1290b) {
            if (m1959f(c0255a)) {
                m1954a(this.f1292d);
            }
        }
    }

    public void m1964c(C0255a c0255a) {
        synchronized (this.f1290b) {
            if (m1959f(c0255a)) {
                this.f1291c.removeCallbacksAndMessages(this.f1292d);
            }
        }
    }

    public void m1965d(C0255a c0255a) {
        synchronized (this.f1290b) {
            if (m1959f(c0255a)) {
                m1954a(this.f1292d);
            }
        }
    }

    public boolean m1966e(C0255a c0255a) {
        boolean z;
        synchronized (this.f1290b) {
            z = m1959f(c0255a) || m1960g(c0255a);
        }
        return z;
    }

    private void m1957b() {
        if (this.f1293e != null) {
            this.f1292d = this.f1293e;
            this.f1293e = null;
            C0255a c0255a = (C0255a) this.f1292d.f1287a.get();
            if (c0255a != null) {
                c0255a.m1948a();
            } else {
                this.f1292d = null;
            }
        }
    }

    private boolean m1956a(C0256b c0256b, int i) {
        C0255a c0255a = (C0255a) c0256b.f1287a.get();
        if (c0255a == null) {
            return false;
        }
        this.f1291c.removeCallbacksAndMessages(c0256b);
        c0255a.m1949a(i);
        return true;
    }

    private boolean m1959f(C0255a c0255a) {
        return this.f1292d != null && this.f1292d.m1952a(c0255a);
    }

    private boolean m1960g(C0255a c0255a) {
        return this.f1293e != null && this.f1293e.m1952a(c0255a);
    }

    private void m1954a(C0256b c0256b) {
        if (c0256b.f1288b != -2) {
            int i = 2750;
            if (c0256b.f1288b > 0) {
                i = c0256b.f1288b;
            } else if (c0256b.f1288b == -1) {
                i = 1500;
            }
            this.f1291c.removeCallbacksAndMessages(c0256b);
            this.f1291c.sendMessageDelayed(Message.obtain(this.f1291c, 0, c0256b), (long) i);
        }
    }

    private void m1958b(C0256b c0256b) {
        synchronized (this.f1290b) {
            if (this.f1292d == c0256b || this.f1293e == c0256b) {
                m1956a(c0256b, 2);
            }
        }
    }
}
