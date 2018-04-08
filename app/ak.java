package android.support.v4.app;

import android.support.v4.app.ai.C0311b;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class ak implements OnPreDrawListener {
    final /* synthetic */ View f1565a;
    final /* synthetic */ Transition f1566b;
    final /* synthetic */ View f1567c;
    final /* synthetic */ C0311b f1568d;
    final /* synthetic */ Map f1569e;
    final /* synthetic */ Map f1570f;
    final /* synthetic */ ArrayList f1571g;
    final /* synthetic */ Transition f1572h;

    ak(View view, Transition transition, View view2, C0311b c0311b, Map map, Map map2, ArrayList arrayList, Transition transition2) {
        this.f1565a = view;
        this.f1566b = transition;
        this.f1567c = view2;
        this.f1568d = c0311b;
        this.f1569e = map;
        this.f1570f = map2;
        this.f1571g = arrayList;
        this.f1572h = transition2;
    }

    public boolean onPreDraw() {
        this.f1565a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f1566b != null) {
            this.f1566b.removeTarget(this.f1567c);
        }
        if (this.f1568d != null) {
            View a = this.f1568d.mo346a();
            if (a != null) {
                if (!this.f1569e.isEmpty()) {
                    ai.m2392a(this.f1570f, a);
                    this.f1570f.keySet().retainAll(this.f1569e.values());
                    for (Entry entry : this.f1569e.entrySet()) {
                        View view = (View) this.f1570f.get((String) entry.getValue());
                        if (view != null) {
                            view.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.f1566b != null) {
                    ai.m2400b(this.f1571g, a);
                    this.f1571g.removeAll(this.f1570f.values());
                    this.f1571g.add(this.f1567c);
                    ai.m2399b(this.f1566b, this.f1571g);
                }
            }
        }
        ai.m2398b(this.f1572h, this.f1566b, this.f1571g, true);
        return true;
    }
}
