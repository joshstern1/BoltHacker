package android.support.design.widget;

import android.support.design.widget.C0252a.C0251a;
import android.support.design.widget.C0292w.C0286a;
import android.view.animation.Animation;

class C0295s extends C0251a {
    final /* synthetic */ C0286a f1454a;
    final /* synthetic */ C0293q f1455b;

    C0295s(C0293q c0293q, C0286a c0286a) {
        this.f1455b = c0293q;
        this.f1454a = c0286a;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f1454a != null) {
            this.f1454a.mo275a();
        }
    }
}
