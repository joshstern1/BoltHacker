package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ap implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f2382a;

    ap(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2382a = swipeRefreshLayout;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f2382a.f2271f) {
            this.f2382a.f2253C.setAlpha(255);
            this.f2382a.f2253C.start();
            if (this.f2382a.f2260J && this.f2382a.f2270e != null) {
                this.f2382a.f2270e.mo2187a();
            }
            this.f2382a.f2281p = this.f2382a.f2290z.getTop();
            return;
        }
        this.f2382a.m4560b();
    }
}
