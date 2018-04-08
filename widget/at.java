package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class at implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f2388a;

    at(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2388a = swipeRefreshLayout;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f2388a.f2287v) {
            this.f2388a.m4564b(null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
