package android.support.v7.widget;

import android.support.v4.view.ao;
import android.support.v4.view.bo;
import android.support.v7.widget.RecyclerView.C0199u;
import android.support.v7.widget.aq.C0961c;
import android.view.View;

class av extends C0961c {
    final /* synthetic */ C0199u f3669a;
    final /* synthetic */ bo f3670b;
    final /* synthetic */ aq f3671c;

    av(aq aqVar, C0199u c0199u, bo boVar) {
        this.f3671c = aqVar;
        this.f3669a = c0199u;
        this.f3670b = boVar;
        super();
    }

    public void mo234a(View view) {
        this.f3671c.m6813m(this.f3669a);
    }

    public void mo236c(View view) {
        ao.m3924c(view, 1.0f);
    }

    public void mo235b(View view) {
        this.f3670b.m4191a(null);
        this.f3671c.m6810j(this.f3669a);
        this.f3671c.f3656i.remove(this.f3669a);
        this.f3671c.m6836j();
    }
}
