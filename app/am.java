package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class am implements OnPreDrawListener {
    final /* synthetic */ View f1575a;
    final /* synthetic */ Transition f1576b;
    final /* synthetic */ ArrayList f1577c;
    final /* synthetic */ Transition f1578d;
    final /* synthetic */ ArrayList f1579e;
    final /* synthetic */ Transition f1580f;
    final /* synthetic */ ArrayList f1581g;
    final /* synthetic */ Map f1582h;
    final /* synthetic */ ArrayList f1583i;
    final /* synthetic */ Transition f1584j;
    final /* synthetic */ View f1585k;

    am(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
        this.f1575a = view;
        this.f1576b = transition;
        this.f1577c = arrayList;
        this.f1578d = transition2;
        this.f1579e = arrayList2;
        this.f1580f = transition3;
        this.f1581g = arrayList3;
        this.f1582h = map;
        this.f1583i = arrayList4;
        this.f1584j = transition4;
        this.f1585k = view2;
    }

    public boolean onPreDraw() {
        this.f1575a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f1576b != null) {
            ai.m2389a(this.f1576b, this.f1577c);
            ai.m2398b(this.f1576b, this.f1578d, this.f1579e, false);
            ai.m2398b(this.f1576b, this.f1580f, this.f1581g, false);
        }
        if (this.f1578d != null) {
            ai.m2389a(this.f1578d, this.f1579e);
            ai.m2398b(this.f1578d, this.f1576b, this.f1577c, false);
            ai.m2398b(this.f1578d, this.f1580f, this.f1581g, false);
        }
        if (this.f1580f != null) {
            ai.m2389a(this.f1580f, this.f1581g);
        }
        for (Entry entry : this.f1582h.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.f1583i.size();
        for (int i = 0; i < size; i++) {
            this.f1584j.excludeTarget((View) this.f1583i.get(i), false);
        }
        this.f1584j.excludeTarget(this.f1585k, false);
        return true;
    }
}
