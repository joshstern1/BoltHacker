package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.p044a.p045d.C1066g;
import io.p038b.p039a.p040a.p044a.p047c.p048a.C2983b;
import io.p038b.p039a.p040a.p044a.p047c.p048a.C2984c;
import io.p038b.p039a.p040a.p044a.p047c.p048a.C2985e;
import java.io.File;
import java.util.List;

class C1088o implements C1066g {
    private final ab f4131a;
    private final C1098x f4132b;

    public static C1088o m7659a(ab abVar) {
        return new C1088o(abVar, new C1098x(new C2985e(new C1097w(new C2984c(1000, 8), 0.1d), new C2983b(5))));
    }

    C1088o(ab abVar, C1098x c1098x) {
        this.f4131a = abVar;
        this.f4132b = c1098x;
    }

    public boolean mo1155a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.f4132b.m7688a(nanoTime)) {
            return false;
        }
        if (this.f4131a.mo1155a(list)) {
            this.f4132b.m7687a();
            return true;
        }
        this.f4132b.m7689b(nanoTime);
        return false;
    }
}
