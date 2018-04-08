package android.support.v7.view.menu;

import android.support.v7.view.menu.C0874e.C0871a;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class C0875f implements OnGlobalLayoutListener {
    final /* synthetic */ C0874e f2950a;

    C0875f(C0874e c0874e) {
        this.f2950a = c0874e;
    }

    public void onGlobalLayout() {
        if (this.f2950a.mo870f() && this.f2950a.f2932h.size() > 0 && !((C0871a) this.f2950a.f2932h.get(0)).f2921a.m5948c()) {
            View b = this.f2950a.f2938n;
            if (b == null || !b.isShown()) {
                this.f2950a.mo869e();
                return;
            }
            for (C0871a c0871a : this.f2950a.f2932h) {
                c0871a.f2921a.mo868d();
            }
        }
    }
}
