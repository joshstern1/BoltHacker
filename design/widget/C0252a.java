package android.support.design.widget;

import android.support.v4.view.p026b.C0599a;
import android.support.v4.view.p026b.C0600b;
import android.support.v4.view.p026b.C0601c;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class C0252a {
    static final Interpolator f1252a = new LinearInterpolator();
    static final Interpolator f1253b = new C0600b();
    static final Interpolator f1254c = new C0599a();
    static final Interpolator f1255d = new C0601c();
    static final Interpolator f1256e = new DecelerateInterpolator();

    static class C0251a implements AnimationListener {
        C0251a() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    static float m1907a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int m1908a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
