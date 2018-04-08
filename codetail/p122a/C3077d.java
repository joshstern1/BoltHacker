package io.codetail.p122a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import io.codetail.p122a.C3076c.C3075c;

class C3077d extends AnimatorListenerAdapter {
    final /* synthetic */ C3076c f10164a;

    C3077d(C3076c c3076c) {
        this.f10164a = c3076c;
    }

    public void onAnimationStart(Animator animator) {
        C3076c.m17402b(animator).m17397a(true);
    }

    public void onAnimationEnd(Animator animator) {
        C3075c a = C3076c.m17402b(animator);
        a.m17397a(false);
        this.f10164a.f10163b.remove(a.m17399b());
    }
}
