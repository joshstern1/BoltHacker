package android.support.design.widget;

import android.support.design.widget.C0252a.C0251a;
import android.support.design.widget.C0292w.C0286a;
import android.view.animation.Animation;

class C0294r extends C0251a {
    final /* synthetic */ boolean f1451a;
    final /* synthetic */ C0286a f1452b;
    final /* synthetic */ C0293q f1453c;

    C0294r(C0293q c0293q, boolean z, C0286a c0286a) {
        this.f1453c = c0293q;
        this.f1451a = z;
        this.f1452b = c0286a;
    }

    public void onAnimationStart(Animation animation) {
        this.f1453c.f1450o = true;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1453c.f1450o = false;
        this.f1453c.k.m1713a(8, this.f1451a);
        if (this.f1452b != null) {
            this.f1452b.mo276b();
        }
    }
}
