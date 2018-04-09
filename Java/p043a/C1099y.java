package com.p041a.p042a.p043a;

import com.p041a.p042a.p043a.ae.C1071b;
import java.util.Set;

class C1099y implements C1094u {
    static final Set<C1071b> f4158b = new C1100z();
    final int f4159a;

    public C1099y(int i) {
        this.f4159a = i;
    }

    public boolean mo1172a(ae aeVar) {
        boolean z;
        if (f4158b.contains(aeVar.f4078c) && aeVar.f4076a.f4091g == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(aeVar.f4076a.f4087c.hashCode() % this.f4159a) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
