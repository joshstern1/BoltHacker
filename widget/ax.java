package android.support.v7.widget;

import android.support.v4.view.ao;
import android.support.v4.view.bo;
import android.support.v7.widget.aq.C0959a;
import android.support.v7.widget.aq.C0961c;
import android.view.View;

class ax extends C0961c {
    final /* synthetic */ C0959a f3677a;
    final /* synthetic */ bo f3678b;
    final /* synthetic */ aq f3679c;

    ax(aq aqVar, C0959a c0959a, bo boVar) {
        this.f3679c = aqVar;
        this.f3677a = c0959a;
        this.f3678b = boVar;
        super();
    }

    public void mo234a(View view) {
        this.f3679c.m6801b(this.f3677a.f3637a, true);
    }

    public void mo235b(View view) {
        this.f3678b.m4191a(null);
        ao.m3924c(view, 1.0f);
        ao.m3903a(view, 0.0f);
        ao.m3920b(view, 0.0f);
        this.f3679c.m6795a(this.f3677a.f3637a, true);
        this.f3679c.f3659l.remove(this.f3677a.f3637a);
        this.f3679c.m6836j();
    }
}
