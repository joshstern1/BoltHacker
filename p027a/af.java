package android.support.v7.p027a;

import android.support.v4.view.ao;
import android.support.v4.view.bx;
import android.view.View;

class af extends bx {
    final /* synthetic */ C0819y f2460a;

    af(C0819y c0819y) {
        this.f2460a = c0819y;
    }

    public void mo234a(View view) {
        this.f2460a.f2732n.setVisibility(0);
        this.f2460a.f2732n.sendAccessibilityEvent(32);
        if (this.f2460a.f2732n.getParent() != null) {
            ao.m3954x((View) this.f2460a.f2732n.getParent());
        }
    }

    public void mo235b(View view) {
        ao.m3924c(this.f2460a.f2732n, 1.0f);
        this.f2460a.f2735q.m4191a(null);
        this.f2460a.f2735q = null;
    }
}
