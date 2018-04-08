package com.facebook.shimmer;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class C1471b implements OnGlobalLayoutListener {
    final /* synthetic */ ShimmerFrameLayout f5578a;

    C1471b(ShimmerFrameLayout shimmerFrameLayout) {
        this.f5578a = shimmerFrameLayout;
    }

    public void onGlobalLayout() {
        boolean a = this.f5578a.f5576q;
        this.f5578a.m9217g();
        if (this.f5578a.f5569j || a) {
            this.f5578a.m9221b();
        }
    }
}
