package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class aw extends Animation {
    final /* synthetic */ SwipeRefreshLayout f2391a;

    aw(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2391a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f2391a.setAnimationProgress(this.f2391a.f2252B + ((-this.f2391a.f2252B) * f));
        this.f2391a.m4566c(f);
    }
}
