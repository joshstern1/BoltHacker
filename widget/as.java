package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class as extends Animation {
    final /* synthetic */ int f2385a;
    final /* synthetic */ int f2386b;
    final /* synthetic */ SwipeRefreshLayout f2387c;

    as(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f2387c = swipeRefreshLayout;
        this.f2385a = i;
        this.f2386b = i2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f2387c.f2253C.setAlpha((int) (((float) this.f2385a) + (((float) (this.f2386b - this.f2385a)) * f)));
    }
}
