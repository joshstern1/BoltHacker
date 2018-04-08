package android.support.design.widget;

import android.support.v4.view.bx;
import android.view.View;

class ao extends bx {
    boolean f1284a = false;
    final /* synthetic */ int f1285b;
    final /* synthetic */ Snackbar f1286c;

    ao(Snackbar snackbar, int i) {
        this.f1286c = snackbar;
        this.f1285b = i;
    }

    public void mo234a(View view) {
        if (!this.f1286c.f1163e.isEnabled()) {
            this.f1286c.f1161c.m1738b(0, 180);
        }
    }

    public void mo235b(View view) {
        this.f1286c.m1773d(this.f1285b);
    }
}
