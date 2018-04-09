package android.support.v4.view.p025a;

import android.os.Bundle;
import android.support.v4.view.p025a.C0558l.C0557c;
import android.support.v4.view.p025a.C0565q.C0561a;
import java.util.ArrayList;
import java.util.List;

class C0562n implements C0561a {
    final /* synthetic */ C0558l f2086a;
    final /* synthetic */ C0557c f2087b;

    C0562n(C0557c c0557c, C0558l c0558l) {
        this.f2087b = c0557c;
        this.f2086a = c0558l;
    }

    public boolean mo496a(int i, int i2, Bundle bundle) {
        return this.f2086a.mo715a(i, i2, bundle);
    }

    public List<Object> mo495a(String str, int i) {
        List a = this.f2086a.m3546a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0547e) a.get(i2)).m3433a());
        }
        return arrayList;
    }

    public Object mo494a(int i) {
        C0547e a = this.f2086a.mo714a(i);
        if (a == null) {
            return null;
        }
        return a.m3433a();
    }

    public Object mo497b(int i) {
        C0547e b = this.f2086a.m3548b(i);
        if (b == null) {
            return null;
        }
        return b.m3433a();
    }
}
