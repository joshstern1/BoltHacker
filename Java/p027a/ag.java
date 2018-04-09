package android.support.v7.p027a;

import android.support.v4.view.ao;
import android.support.v4.view.bx;
import android.support.v7.p027a.C0819y.C0826b;
import android.view.View;

class ag extends bx {
    final /* synthetic */ C0826b f2461a;

    ag(C0826b c0826b) {
        this.f2461a = c0826b;
    }

    public void mo235b(View view) {
        this.f2461a.f2751a.f2732n.setVisibility(8);
        if (this.f2461a.f2751a.f2733o != null) {
            this.f2461a.f2751a.f2733o.dismiss();
        } else if (this.f2461a.f2751a.f2732n.getParent() instanceof View) {
            ao.m3954x((View) this.f2461a.f2751a.f2732n.getParent());
        }
        this.f2461a.f2751a.f2732n.removeAllViews();
        this.f2461a.f2751a.f2735q.m4191a(null);
        this.f2461a.f2751a.f2735q = null;
    }
}
