package android.support.design.widget;

import android.view.animation.Interpolator;

class bf {
    private final C0266e f1326a;

    interface C0259c {
        void mo245a(bf bfVar);
    }

    interface C0260a {
        void mo246a(bf bfVar);

        void mo247b(bf bfVar);

        void mo248c(bf bfVar);
    }

    static class C0261b implements C0260a {
        C0261b() {
        }

        public void mo247b(bf bfVar) {
        }

        public void mo246a(bf bfVar) {
        }

        public void mo248c(bf bfVar) {
        }
    }

    interface C0263d {
        bf mo272a();
    }

    static abstract class C0266e {

        interface C0264a {
            void mo254a();

            void mo255b();

            void mo256c();
        }

        interface C0265b {
            void mo253a();
        }

        abstract void mo257a();

        abstract void mo258a(float f, float f2);

        abstract void mo259a(int i);

        abstract void mo260a(int i, int i2);

        abstract void mo261a(C0264a c0264a);

        abstract void mo262a(C0265b c0265b);

        abstract void mo263a(Interpolator interpolator);

        abstract boolean mo264b();

        abstract int mo265c();

        abstract float mo266d();

        abstract void mo267e();

        abstract float mo268f();

        abstract long mo269g();

        C0266e() {
        }
    }

    bf(C0266e c0266e) {
        this.f1326a = c0266e;
    }

    public void m2034a() {
        this.f1326a.mo257a();
    }

    public boolean m2041b() {
        return this.f1326a.mo264b();
    }

    public void m2040a(Interpolator interpolator) {
        this.f1326a.mo263a(interpolator);
    }

    public void m2039a(C0259c c0259c) {
        if (c0259c != null) {
            this.f1326a.mo262a(new bg(this, c0259c));
        } else {
            this.f1326a.mo262a(null);
        }
    }

    public void m2038a(C0260a c0260a) {
        if (c0260a != null) {
            this.f1326a.mo261a(new bh(this, c0260a));
        } else {
            this.f1326a.mo261a(null);
        }
    }

    public void m2037a(int i, int i2) {
        this.f1326a.mo260a(i, i2);
    }

    public int m2042c() {
        return this.f1326a.mo265c();
    }

    public void m2035a(float f, float f2) {
        this.f1326a.mo258a(f, f2);
    }

    public float m2043d() {
        return this.f1326a.mo266d();
    }

    public void m2036a(int i) {
        this.f1326a.mo259a(i);
    }

    public void m2044e() {
        this.f1326a.mo267e();
    }

    public float m2045f() {
        return this.f1326a.mo268f();
    }

    public long m2046g() {
        return this.f1326a.mo269g();
    }
}
