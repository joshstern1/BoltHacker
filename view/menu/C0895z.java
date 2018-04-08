package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class C0895z implements OnGlobalLayoutListener {
    final /* synthetic */ C0894y f3045a;

    C0895z(C0894y c0894y) {
        this.f3045a = c0894y;
    }

    public void onGlobalLayout() {
        if (this.f3045a.mo870f() && !this.f3045a.f3033h.m5948c()) {
            View b = this.f3045a.f3037l;
            if (b == null || !b.isShown()) {
                this.f3045a.mo869e();
            } else {
                this.f3045a.f3033h.mo868d();
            }
        }
    }
}
