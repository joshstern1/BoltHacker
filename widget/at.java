package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0199u;
import java.util.ArrayList;
import java.util.Iterator;

class at implements Runnable {
    final /* synthetic */ ArrayList f3664a;
    final /* synthetic */ aq f3665b;

    at(aq aqVar, ArrayList arrayList) {
        this.f3665b = aqVar;
        this.f3664a = arrayList;
    }

    public void run() {
        Iterator it = this.f3664a.iterator();
        while (it.hasNext()) {
            this.f3665b.m6838u((C0199u) it.next());
        }
        this.f3664a.clear();
        this.f3665b.f3653f.remove(this.f3664a);
    }
}
