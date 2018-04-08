package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class aq extends Animation {
    final /* synthetic */ SwipeRefreshLayout f2383a;

    aq(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2383a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f2383a.setAnimationProgress(f);
    }
}
