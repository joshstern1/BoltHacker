package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ar extends Animation {
    final /* synthetic */ SwipeRefreshLayout f2384a;

    ar(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2384a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f2384a.setAnimationProgress(1.0f - f);
    }
}
