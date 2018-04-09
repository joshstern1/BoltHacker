package com.p041a.p042a.p043a;

import android.content.Context;
import io.p038b.p039a.p040a.p044a.p045d.C1064b;
import io.p038b.p039a.p040a.p044a.p045d.C3003d;
import io.p038b.p039a.p040a.p044a.p046b.C2960m;
import io.p038b.p039a.p040a.p044a.p054g.C3028b;
import java.io.IOException;
import java.util.UUID;

class aa extends C1064b<ae> {
    private C3028b f4047g;

    aa(Context context, ag agVar, C2960m c2960m, C3003d c3003d) throws IOException {
        super(context, agVar, c2960m, c3003d, 100);
    }

    protected String mo1152a() {
        return "sa" + "_" + UUID.randomUUID().toString() + "_" + this.c.mo2401a() + ".tap";
    }

    protected int mo1153b() {
        return this.f4047g == null ? super.mo1153b() : this.f4047g.f10010e;
    }

    protected int mo1154c() {
        return this.f4047g == null ? super.mo1154c() : this.f4047g.f10008c;
    }

    void m7575a(C3028b c3028b) {
        this.f4047g = c3028b;
    }
}
