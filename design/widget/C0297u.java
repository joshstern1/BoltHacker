package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.C0292w.C0286a;

class C0297u extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f1457a;
    final /* synthetic */ C0286a f1458b;
    final /* synthetic */ C0296t f1459c;
    private boolean f1460d;

    C0297u(C0296t c0296t, boolean z, C0286a c0286a) {
        this.f1459c = c0296t;
        this.f1457a = z;
        this.f1458b = c0286a;
    }

    public void onAnimationStart(Animator animator) {
        this.f1459c.f1456m = true;
        this.f1460d = false;
        this.f1459c.k.m1713a(0, this.f1457a);
    }

    public void onAnimationCancel(Animator animator) {
        this.f1459c.f1456m = false;
        this.f1460d = true;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1459c.f1456m = false;
        if (!this.f1460d) {
            this.f1459c.k.m1713a(8, this.f1457a);
            if (this.f1458b != null) {
                this.f1458b.mo276b();
            }
        }
    }
}
