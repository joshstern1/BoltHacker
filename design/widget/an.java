package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class an implements AnimationListener {
    final /* synthetic */ Snackbar f1283a;

    an(Snackbar snackbar) {
        this.f1283a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1283a.m1774e();
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
