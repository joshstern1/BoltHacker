package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class av extends Animation {
    final /* synthetic */ SwipeRefreshLayout f2390a;

    av(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2390a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f2390a.m4566c(f);
    }
}
