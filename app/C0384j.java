package android.support.v4.app;

import android.support.v4.app.C0381g.C0380b;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class C0384j implements OnPreDrawListener {
    final /* synthetic */ View f1795a;
    final /* synthetic */ C0380b f1796b;
    final /* synthetic */ int f1797c;
    final /* synthetic */ Object f1798d;
    final /* synthetic */ C0381g f1799e;

    C0384j(C0381g c0381g, View view, C0380b c0380b, int i, Object obj) {
        this.f1799e = c0381g;
        this.f1795a = view;
        this.f1796b = c0380b;
        this.f1797c = i;
        this.f1798d = obj;
    }

    public boolean onPreDraw() {
        this.f1795a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f1799e.m2656a(this.f1796b, this.f1797c, this.f1798d);
        return true;
    }
}
