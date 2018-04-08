package android.support.v7.widget;

import android.support.v4.view.bx;
import android.view.View;

class dl extends bx {
    final /* synthetic */ int f3853a;
    final /* synthetic */ dj f3854b;
    private boolean f3855c = false;

    dl(dj djVar, int i) {
        this.f3854b = djVar;
        this.f3853a = i;
    }

    public void mo234a(View view) {
        this.f3854b.f3833a.setVisibility(0);
    }

    public void mo235b(View view) {
        if (!this.f3855c) {
            this.f3854b.f3833a.setVisibility(this.f3853a);
        }
    }

    public void mo236c(View view) {
        this.f3855c = true;
    }
}
