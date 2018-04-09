package com.p059c.p060a;

import com.p059c.p060a.C1250c.C1249e;
import java.util.ArrayList;

class C1251d extends C1244b {
    boolean f4665a = false;
    final /* synthetic */ ArrayList f4666b;
    final /* synthetic */ C1250c f4667c;

    C1251d(C1250c c1250c, ArrayList arrayList) {
        this.f4667c = c1250c;
        this.f4666b = arrayList;
    }

    public void mo1228c(C1238a c1238a) {
        this.f4665a = true;
    }

    public void mo1227b(C1238a c1238a) {
        if (!this.f4665a) {
            int size = this.f4666b.size();
            for (int i = 0; i < size; i++) {
                C1249e c1249e = (C1249e) this.f4666b.get(i);
                c1249e.f4648a.mo1219a();
                this.f4667c.f4655c.add(c1249e.f4648a);
            }
        }
    }
}
