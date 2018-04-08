package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class br extends AnimatorListenerAdapter {
    final /* synthetic */ bw f2135a;
    final /* synthetic */ View f2136b;

    br(bw bwVar, View view) {
        this.f2135a = bwVar;
        this.f2136b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2135a.mo236c(this.f2136b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f2135a.mo235b(this.f2136b);
    }

    public void onAnimationStart(Animator animator) {
        this.f2135a.mo234a(this.f2136b);
    }
}
