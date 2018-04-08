package android.support.v7.widget;

import android.support.v7.widget.aq.C0960b;
import java.util.ArrayList;
import java.util.Iterator;

class ar implements Runnable {
    final /* synthetic */ ArrayList f3660a;
    final /* synthetic */ aq f3661b;

    ar(aq aqVar, ArrayList arrayList) {
        this.f3661b = aqVar;
        this.f3660a = arrayList;
    }

    public void run() {
        Iterator it = this.f3660a.iterator();
        while (it.hasNext()) {
            C0960b c0960b = (C0960b) it.next();
            this.f3661b.m6828b(c0960b.f3643a, c0960b.f3644b, c0960b.f3645c, c0960b.f3646d, c0960b.f3647e);
        }
        this.f3660a.clear();
        this.f3661b.f3654g.remove(this.f3660a);
    }
}
