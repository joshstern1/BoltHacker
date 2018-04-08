package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class au extends Animation {
    final /* synthetic */ SwipeRefreshLayout f2389a;

    au(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2389a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        int i;
        if (this.f2389a.f2263M) {
            i = (int) this.f2389a.f2259I;
        } else {
            i = (int) (this.f2389a.f2259I - ((float) Math.abs(this.f2389a.f2268b)));
        }
        this.f2389a.m4550a((((int) (((float) (i - this.f2389a.f2267a)) * f)) + this.f2389a.f2267a) - this.f2389a.f2290z.getTop(), false);
        this.f2389a.f2253C.m4673a(1.0f - f);
    }
}
