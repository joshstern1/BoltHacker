package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public final class am {
    Object f2380a;
    C0709a f2381b;

    interface C0709a {
        Object mo686a(Context context, Interpolator interpolator);

        void mo687a(Object obj, int i, int i2, int i3, int i4);

        void mo688a(Object obj, int i, int i2, int i3, int i4, int i5);

        void mo689a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void mo690a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean mo691a(Object obj);

        boolean mo692a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        int mo693b(Object obj);

        int mo694c(Object obj);

        float mo695d(Object obj);

        boolean mo696e(Object obj);

        void mo697f(Object obj);

        int mo698g(Object obj);

        int mo699h(Object obj);
    }

    static class C0710b implements C0709a {
        C0710b() {
        }

        public Object mo686a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public boolean mo691a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public int mo693b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int mo694c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public float mo695d(Object obj) {
            return 0.0f;
        }

        public boolean mo696e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public void mo687a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void mo688a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public void mo689a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo690a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo697f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public int mo698g(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int mo699h(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        public boolean mo692a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    }

    static class C0711c implements C0709a {
        C0711c() {
        }

        public Object mo686a(Context context, Interpolator interpolator) {
            return an.m4776a(context, interpolator);
        }

        public boolean mo691a(Object obj) {
            return an.m4781a(obj);
        }

        public int mo693b(Object obj) {
            return an.m4783b(obj);
        }

        public int mo694c(Object obj) {
            return an.m4784c(obj);
        }

        public float mo695d(Object obj) {
            return 0.0f;
        }

        public boolean mo696e(Object obj) {
            return an.m4785d(obj);
        }

        public void mo687a(Object obj, int i, int i2, int i3, int i4) {
            an.m4777a(obj, i, i2, i3, i4);
        }

        public void mo688a(Object obj, int i, int i2, int i3, int i4, int i5) {
            an.m4778a(obj, i, i2, i3, i4, i5);
        }

        public void mo689a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            an.m4779a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo690a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            an.m4780a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public void mo697f(Object obj) {
            an.m4786e(obj);
        }

        public int mo698g(Object obj) {
            return an.m4787f(obj);
        }

        public int mo699h(Object obj) {
            return an.m4788g(obj);
        }

        public boolean mo692a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return an.m4782a(obj, i, i2, i3, i4, i5, i6);
        }
    }

    static class C0712d extends C0711c {
        C0712d() {
        }

        public float mo695d(Object obj) {
            return ao.m4789a(obj);
        }
    }

    public static am m4761a(Context context) {
        return m4762a(context, null);
    }

    public static am m4762a(Context context, Interpolator interpolator) {
        return new am(VERSION.SDK_INT, context, interpolator);
    }

    private am(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f2381b = new C0712d();
        } else if (i >= 9) {
            this.f2381b = new C0711c();
        } else {
            this.f2381b = new C0710b();
        }
        this.f2380a = this.f2381b.mo686a(context, interpolator);
    }

    public boolean m4767a() {
        return this.f2381b.mo691a(this.f2380a);
    }

    public int m4769b() {
        return this.f2381b.mo693b(this.f2380a);
    }

    public int m4770c() {
        return this.f2381b.mo694c(this.f2380a);
    }

    public int m4771d() {
        return this.f2381b.mo698g(this.f2380a);
    }

    public int m4772e() {
        return this.f2381b.mo699h(this.f2380a);
    }

    public float m4773f() {
        return this.f2381b.mo695d(this.f2380a);
    }

    public boolean m4774g() {
        return this.f2381b.mo696e(this.f2380a);
    }

    public void m4763a(int i, int i2, int i3, int i4) {
        this.f2381b.mo687a(this.f2380a, i, i2, i3, i4);
    }

    public void m4764a(int i, int i2, int i3, int i4, int i5) {
        this.f2381b.mo688a(this.f2380a, i, i2, i3, i4, i5);
    }

    public void m4765a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f2381b.mo689a(this.f2380a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m4766a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f2381b.mo690a(this.f2380a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m4768a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f2381b.mo692a(this.f2380a, i, i2, i3, i4, i5, i6);
    }

    public void m4775h() {
        this.f2381b.mo697f(this.f2380a);
    }
}
