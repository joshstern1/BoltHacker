package org.p129b.p130a;

import java.util.ArrayList;
import java.util.List;
import org.p129b.C3158b;
import org.p129b.C3162a;

public class C3164e implements C3162a {
    final List f10385a = new ArrayList();

    public C3158b mo2564a(String str) {
        synchronized (this.f10385a) {
            this.f10385a.add(str);
        }
        return C3161b.f10384a;
    }

    public List m17738a() {
        List arrayList = new ArrayList();
        synchronized (this.f10385a) {
            arrayList.addAll(this.f10385a);
        }
        return arrayList;
    }
}
