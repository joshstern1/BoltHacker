package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C1472c implements AnimatorUpdateListener {
    final /* synthetic */ ShimmerFrameLayout f5579a;

    C1472c(ShimmerFrameLayout shimmerFrameLayout) {
        this.f5579a = shimmerFrameLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        this.f5579a.setMaskOffsetX((int) ((((float) this.f5579a.f5566g.f5556a) * (1.0f - max)) + (((float) this.f5579a.f5566g.f5558c) * max)));
        this.f5579a.setMaskOffsetY((int) ((max * ((float) this.f5579a.f5566g.f5559d)) + (((float) this.f5579a.f5566g.f5557b) * (1.0f - max))));
    }
}
