package android.support.v7.p027a;

import android.support.v4.view.ao;

class ad implements Runnable {
    final /* synthetic */ C0819y f2458a;

    ad(C0819y c0819y) {
        this.f2458a = c0819y;
    }

    public void run() {
        this.f2458a.f2733o.showAtLocation(this.f2458a.f2732n, 55, 0, 0);
        this.f2458a.m5395x();
        if (this.f2458a.m5430s()) {
            ao.m3924c(this.f2458a.f2732n, 0.0f);
            this.f2458a.f2735q = ao.m3950t(this.f2458a.f2732n).m4189a(1.0f);
            this.f2458a.f2735q.m4191a(new ae(this));
            return;
        }
        ao.m3924c(this.f2458a.f2732n, 1.0f);
        this.f2458a.f2732n.setVisibility(0);
    }
}
