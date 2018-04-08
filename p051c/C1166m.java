package com.p041a.p042a.p051c;

import android.app.Activity;
import io.p038b.p039a.p040a.p044a.p054g.C3048q.C1164b;
import io.p038b.p039a.p040a.p044a.p054g.C3050t;

class C1166m implements C1164b<Boolean> {
    final /* synthetic */ C1154g f4370a;

    C1166m(C1154g c1154g) {
        this.f4370a = c1154g;
    }

    public /* synthetic */ Object mo1202b(C3050t c3050t) {
        return m8015a(c3050t);
    }

    public Boolean m8015a(C3050t c3050t) {
        boolean z = true;
        Activity b = this.f4370a.m7541F().m17350b();
        if (!(b == null || b.isFinishing() || !this.f4370a.m7988x())) {
            z = this.f4370a.m7953a(b, c3050t.f10077c);
        }
        return Boolean.valueOf(z);
    }
}
