package android.support.v7.widget;

import android.support.v7.widget.C1003r.C0974a;
import android.support.v7.widget.C1003r.C1002b;
import android.support.v7.widget.RecyclerView.C0199u;
import android.support.v7.widget.RecyclerView.C0940r;

class bx implements C0974a {
    final /* synthetic */ RecyclerView f3735a;

    bx(RecyclerView recyclerView) {
        this.f3735a = recyclerView;
    }

    public C0199u mo1038a(int i) {
        C0199u a = this.f3735a.m1226a(i, true);
        if (a == null || this.f3735a.f923d.m6754c(a.f968a)) {
            return null;
        }
        return a;
    }

    public void mo1039a(int i, int i2) {
        this.f3735a.m1233a(i, i2, true);
        this.f3735a.f929j = true;
        C0940r c0940r = this.f3735a.f928i;
        c0940r.f3360i = c0940r.f3360i + i2;
    }

    public void mo1042b(int i, int i2) {
        this.f3735a.m1233a(i, i2, false);
        this.f3735a.f929j = true;
    }

    public void mo1040a(int i, int i2, Object obj) {
        this.f3735a.m1232a(i, i2, obj);
        this.f3735a.f930k = true;
    }

    public void mo1041a(C1002b c1002b) {
        m6984c(c1002b);
    }

    void m6984c(C1002b c1002b) {
        switch (c1002b.f3896a) {
            case 1:
                this.f3735a.f925f.mo963a(this.f3735a, c1002b.f3897b, c1002b.f3899d);
                return;
            case 2:
                this.f3735a.f925f.mo969b(this.f3735a, c1002b.f3897b, c1002b.f3899d);
                return;
            case 4:
                this.f3735a.f925f.mo965a(this.f3735a, c1002b.f3897b, c1002b.f3899d, c1002b.f3898c);
                return;
            case 8:
                this.f3735a.f925f.mo964a(this.f3735a, c1002b.f3897b, c1002b.f3899d, 1);
                return;
            default:
                return;
        }
    }

    public void mo1043b(C1002b c1002b) {
        m6984c(c1002b);
    }

    public void mo1044c(int i, int i2) {
        this.f3735a.m1255f(i, i2);
        this.f3735a.f929j = true;
    }

    public void mo1045d(int i, int i2) {
        this.f3735a.m1253e(i, i2);
        this.f3735a.f929j = true;
    }
}
