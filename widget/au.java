package android.support.v7.widget;

import android.support.v4.view.ao;
import android.support.v4.view.bo;
import android.support.v7.widget.RecyclerView.C0199u;
import android.support.v7.widget.aq.C0961c;
import android.view.View;

class au extends C0961c {
    final /* synthetic */ C0199u f3666a;
    final /* synthetic */ bo f3667b;
    final /* synthetic */ aq f3668c;

    au(aq aqVar, C0199u c0199u, bo boVar) {
        this.f3668c = aqVar;
        this.f3666a = c0199u;
        this.f3667b = boVar;
        super();
    }

    public void mo234a(View view) {
        this.f3668c.m6811k(this.f3666a);
    }

    public void mo235b(View view) {
        this.f3667b.m4191a(null);
        ao.m3924c(view, 1.0f);
        this.f3668c.m6808h(this.f3666a);
        this.f3668c.f3658k.remove(this.f3666a);
        this.f3668c.m6836j();
    }
}
