package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class as implements AnimationListener {
    final /* synthetic */ ar f1302a;

    as(ar arVar) {
        this.f1302a = arVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f1302a.f1299c == animation) {
            this.f1302a.f1299c = null;
        }
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
