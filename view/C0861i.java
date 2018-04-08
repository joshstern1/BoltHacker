package android.support.v7.view;

import android.support.v4.view.bx;
import android.view.View;

class C0861i extends bx {
    final /* synthetic */ C0860h f2848a;
    private boolean f2849b = false;
    private int f2850c = 0;

    C0861i(C0860h c0860h) {
        this.f2848a = c0860h;
    }

    public void mo234a(View view) {
        if (!this.f2849b) {
            this.f2849b = true;
            if (this.f2848a.f2845d != null) {
                this.f2848a.f2845d.mo234a(null);
            }
        }
    }

    void m5543a() {
        this.f2850c = 0;
        this.f2849b = false;
        this.f2848a.m5535c();
    }

    public void mo235b(View view) {
        int i = this.f2850c + 1;
        this.f2850c = i;
        if (i == this.f2848a.f2842a.size()) {
            if (this.f2848a.f2845d != null) {
                this.f2848a.f2845d.mo235b(null);
            }
            m5543a();
        }
    }
}
