package android.support.v4.widget;

import android.support.v4.widget.ab.C0700a;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ad implements AnimationListener {
    final /* synthetic */ C0700a f2361a;
    final /* synthetic */ ab f2362b;

    ad(ab abVar, C0700a c0700a) {
        this.f2362b = abVar;
        this.f2361a = c0700a;
    }

    public void onAnimationStart(Animation animation) {
        this.f2362b.f2355k = 0.0f;
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
        this.f2361a.m4659l();
        this.f2361a.m4642b();
        this.f2361a.m4643b(this.f2361a.m4656i());
        if (this.f2362b.f2347a) {
            this.f2362b.f2347a = false;
            animation.setDuration(1332);
            this.f2361a.m4640a(false);
            return;
        }
        this.f2362b.f2355k = (this.f2362b.f2355k + 1.0f) % 5.0f;
    }
}
