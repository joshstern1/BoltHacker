package android.support.v7.widget;

import android.support.v7.widget.aq.C0959a;
import java.util.ArrayList;
import java.util.Iterator;

class as implements Runnable {
    final /* synthetic */ ArrayList f3662a;
    final /* synthetic */ aq f3663b;

    as(aq aqVar, ArrayList arrayList) {
        this.f3663b = aqVar;
        this.f3662a = arrayList;
    }

    public void run() {
        Iterator it = this.f3662a.iterator();
        while (it.hasNext()) {
            this.f3663b.m6821a((C0959a) it.next());
        }
        this.f3662a.clear();
        this.f3663b.f3655h.remove(this.f3662a);
    }
}
