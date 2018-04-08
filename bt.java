package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class bt extends AnimatorListenerAdapter {
    final /* synthetic */ bw f2137a;
    final /* synthetic */ View f2138b;

    bt(bw bwVar, View view) {
        this.f2137a = bwVar;
        this.f2138b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2137a.mo236c(this.f2138b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f2137a.mo235b(this.f2138b);
    }

    public void onAnimationStart(Animator animator) {
        this.f2137a.mo234a(this.f2138b);
    }
}
