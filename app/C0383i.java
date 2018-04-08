package android.support.v4.app;

import android.support.v4.app.C0381g.C0380b;
import android.support.v4.p024g.C0495a;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;

class C0383i implements OnPreDrawListener {
    final /* synthetic */ View f1785a;
    final /* synthetic */ Object f1786b;
    final /* synthetic */ ArrayList f1787c;
    final /* synthetic */ C0380b f1788d;
    final /* synthetic */ Object f1789e;
    final /* synthetic */ Object f1790f;
    final /* synthetic */ boolean f1791g;
    final /* synthetic */ Fragment f1792h;
    final /* synthetic */ Fragment f1793i;
    final /* synthetic */ C0381g f1794j;

    C0383i(C0381g c0381g, View view, Object obj, ArrayList arrayList, C0380b c0380b, Object obj2, Object obj3, boolean z, Fragment fragment, Fragment fragment2) {
        this.f1794j = c0381g;
        this.f1785a = view;
        this.f1786b = obj;
        this.f1787c = arrayList;
        this.f1788d = c0380b;
        this.f1789e = obj2;
        this.f1790f = obj3;
        this.f1791g = z;
        this.f1792h = fragment;
        this.f1793i = fragment2;
    }

    public boolean onPreDraw() {
        this.f1785a.getViewTreeObserver().removeOnPreDrawListener(this);
        ai.m2389a(this.f1786b, this.f1787c);
        this.f1787c.remove(this.f1788d.f1759d);
        ai.m2388a(this.f1789e, this.f1790f, this.f1786b, this.f1787c, false);
        this.f1787c.clear();
        C0495a a = this.f1794j.m2649a(this.f1788d, this.f1791g, this.f1792h);
        ai.m2385a(this.f1786b, this.f1788d.f1759d, (Map) a, this.f1787c);
        this.f1794j.m2664a(a, this.f1788d);
        this.f1794j.m2657a(this.f1788d, this.f1792h, this.f1793i, this.f1791g, a);
        ai.m2388a(this.f1789e, this.f1790f, this.f1786b, this.f1787c, true);
        return true;
    }
}
