package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class ar {
    private final ArrayList<C0257a> f1297a = new ArrayList();
    private C0257a f1298b = null;
    private Animation f1299c = null;
    private WeakReference<View> f1300d;
    private AnimationListener f1301e = new as(this);

    static class C0257a {
        final int[] f1295a;
        final Animation f1296b;

        private C0257a(int[] iArr, Animation animation) {
            this.f1295a = iArr;
            this.f1296b = animation;
        }
    }

    ar() {
    }

    public void m1975a(int[] iArr, Animation animation) {
        C0257a c0257a = new C0257a(iArr, animation);
        animation.setAnimationListener(this.f1301e);
        this.f1297a.add(c0257a);
    }

    View m1972a() {
        return this.f1300d == null ? null : (View) this.f1300d.get();
    }

    void m1973a(View view) {
        View a = m1972a();
        if (a != view) {
            if (a != null) {
                m1970c();
            }
            if (view != null) {
                this.f1300d = new WeakReference(view);
            }
        }
    }

    private void m1970c() {
        View a = m1972a();
        int size = this.f1297a.size();
        for (int i = 0; i < size; i++) {
            if (a.getAnimation() == ((C0257a) this.f1297a.get(i)).f1296b) {
                a.clearAnimation();
            }
        }
        this.f1300d = null;
        this.f1298b = null;
        this.f1299c = null;
    }

    void m1974a(int[] iArr) {
        C0257a c0257a = null;
        int size = this.f1297a.size();
        for (int i = 0; i < size; i++) {
            C0257a c0257a2 = (C0257a) this.f1297a.get(i);
            if (StateSet.stateSetMatches(c0257a2.f1295a, iArr)) {
                c0257a = c0257a2;
                break;
            }
        }
        if (c0257a != this.f1298b) {
            if (this.f1298b != null) {
                m1971d();
            }
            this.f1298b = c0257a;
            View view = (View) this.f1300d.get();
            if (c0257a != null && view != null && view.getVisibility() == 0) {
                m1969a(c0257a);
            }
        }
    }

    private void m1969a(C0257a c0257a) {
        this.f1299c = c0257a.f1296b;
        View a = m1972a();
        if (a != null) {
            a.startAnimation(this.f1299c);
        }
    }

    private void m1971d() {
        if (this.f1299c != null) {
            View a = m1972a();
            if (a != null && a.getAnimation() == this.f1299c) {
                a.clearAnimation();
            }
            this.f1299c = null;
        }
    }

    public void m1976b() {
        if (this.f1299c != null) {
            View a = m1972a();
            if (a != null && a.getAnimation() == this.f1299c) {
                a.clearAnimation();
            }
        }
    }
}
