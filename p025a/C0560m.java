package android.support.v4.view.p025a;

import android.os.Bundle;
import android.support.v4.view.p025a.C0558l.C0556b;
import android.support.v4.view.p025a.C0563o.C0559a;
import java.util.ArrayList;
import java.util.List;

class C0560m implements C0559a {
    final /* synthetic */ C0558l f2084a;
    final /* synthetic */ C0556b f2085b;

    C0560m(C0556b c0556b, C0558l c0558l) {
        this.f2085b = c0556b;
        this.f2084a = c0558l;
    }

    public boolean mo493a(int i, int i2, Bundle bundle) {
        return this.f2084a.mo715a(i, i2, bundle);
    }

    public List<Object> mo492a(String str, int i) {
        List a = this.f2084a.m3546a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0547e) a.get(i2)).m3433a());
        }
        return arrayList;
    }

    public Object mo491a(int i) {
        C0547e a = this.f2084a.mo714a(i);
        if (a == null) {
            return null;
        }
        return a.m3433a();
    }
}
