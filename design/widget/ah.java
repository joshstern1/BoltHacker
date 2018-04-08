package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ah implements AnimationListener {
    final /* synthetic */ int f1276a;
    final /* synthetic */ Snackbar f1277b;

    ah(Snackbar snackbar, int i) {
        this.f1277b = snackbar;
        this.f1276a = i;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1277b.m1773d(this.f1276a);
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
