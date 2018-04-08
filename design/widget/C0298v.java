package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.C0292w.C0286a;

class C0298v extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f1461a;
    final /* synthetic */ C0286a f1462b;
    final /* synthetic */ C0296t f1463c;

    C0298v(C0296t c0296t, boolean z, C0286a c0286a) {
        this.f1463c = c0296t;
        this.f1461a = z;
        this.f1462b = c0286a;
    }

    public void onAnimationStart(Animator animator) {
        this.f1463c.k.m1713a(0, this.f1461a);
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f1462b != null) {
            this.f1462b.mo275a();
        }
    }
}
