package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.bf.C0266e.C0265b;

class bl implements AnimatorUpdateListener {
    final /* synthetic */ C0265b f1344a;
    final /* synthetic */ bk f1345b;

    bl(bk bkVar, C0265b c0265b) {
        this.f1345b = bkVar;
        this.f1344a = c0265b;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1344a.mo253a();
    }
}
