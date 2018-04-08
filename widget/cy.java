package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class cy implements AnimationListener {
    final /* synthetic */ boolean f3806a;
    final /* synthetic */ SwitchCompat f3807b;

    cy(SwitchCompat switchCompat, boolean z) {
        this.f3807b = switchCompat;
        this.f3806a = z;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f3807b.f3508K == animation) {
            this.f3807b.setThumbPosition(this.f3806a ? 1.0f : 0.0f);
            this.f3807b.f3508K = null;
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
