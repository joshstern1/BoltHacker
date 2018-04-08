package android.support.v7.widget;

import android.support.v4.view.ao;
import android.support.v4.view.bo;
import android.support.v7.widget.aq.C0959a;
import android.support.v7.widget.aq.C0961c;
import android.view.View;

class ay extends C0961c {
    final /* synthetic */ C0959a f3680a;
    final /* synthetic */ bo f3681b;
    final /* synthetic */ View f3682c;
    final /* synthetic */ aq f3683d;

    ay(aq aqVar, C0959a c0959a, bo boVar, View view) {
        this.f3683d = aqVar;
        this.f3680a = c0959a;
        this.f3681b = boVar;
        this.f3682c = view;
        super();
    }

    public void mo234a(View view) {
        this.f3683d.m6801b(this.f3680a.f3638b, false);
    }

    public void mo235b(View view) {
        this.f3681b.m4191a(null);
        ao.m3924c(this.f3682c, 1.0f);
        ao.m3903a(this.f3682c, 0.0f);
        ao.m3920b(this.f3682c, 0.0f);
        this.f3683d.m6795a(this.f3680a.f3638b, false);
        this.f3683d.f3659l.remove(this.f3680a.f3638b);
        this.f3683d.m6836j();
    }
}
