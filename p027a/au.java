package android.support.v7.p027a;

import android.support.v4.view.ao;
import android.support.v4.view.bx;
import android.view.View;

class au extends bx {
    final /* synthetic */ at f2548a;

    au(at atVar) {
        this.f2548a = atVar;
    }

    public void mo235b(View view) {
        if (this.f2548a.f2519C && this.f2548a.f2541t != null) {
            ao.m3920b(this.f2548a.f2541t, 0.0f);
            ao.m3920b(this.f2548a.f2538q, 0.0f);
        }
        this.f2548a.f2538q.setVisibility(8);
        this.f2548a.f2538q.setTransitioning(false);
        this.f2548a.f2524H = null;
        this.f2548a.m5164i();
        if (this.f2548a.f2537p != null) {
            ao.m3954x(this.f2548a.f2537p);
        }
    }
}
