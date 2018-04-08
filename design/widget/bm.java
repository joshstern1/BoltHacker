package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.bf.C0266e.C0264a;

class bm extends AnimatorListenerAdapter {
    final /* synthetic */ C0264a f1346a;
    final /* synthetic */ bk f1347b;

    bm(bk bkVar, C0264a c0264a) {
        this.f1347b = bkVar;
        this.f1346a = c0264a;
    }

    public void onAnimationStart(Animator animator) {
        this.f1346a.mo254a();
    }

    public void onAnimationEnd(Animator animator) {
        this.f1346a.mo255b();
    }

    public void onAnimationCancel(Animator animator) {
        this.f1346a.mo256c();
    }
}
