package android.support.v4.app;

import android.support.v4.app.C0404y.C0309a;
import android.view.View;
import android.view.animation.Animation;

class ab extends C0309a {
    final /* synthetic */ Fragment f1551a;
    final /* synthetic */ C0404y f1552b;

    ab(C0404y c0404y, View view, Animation animation, Fragment fragment) {
        this.f1552b = c0404y;
        this.f1551a = fragment;
        super(view, animation);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.f1551a.f1513l != null) {
            this.f1551a.f1513l = null;
            this.f1552b.m2833a(this.f1551a, this.f1551a.f1514m, 0, 0, false);
        }
    }
}
