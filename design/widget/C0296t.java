package android.support.design.widget;

import android.support.design.widget.C0292w.C0286a;
import android.support.v4.view.ao;

class C0296t extends C0293q {
    private boolean f1456m;

    C0296t(bu buVar, af afVar) {
        super(buVar, afVar);
    }

    boolean mo293d() {
        return true;
    }

    void mo294e() {
        m2214e(this.k.getRotation());
    }

    void mo285a(C0286a c0286a, boolean z) {
        if (this.f1456m || this.k.getVisibility() != 0) {
            if (c0286a != null) {
                c0286a.mo276b();
            }
        } else if (!ao.m3895G(this.k) || this.k.isInEditMode()) {
            this.k.m1713a(8, z);
            if (c0286a != null) {
                c0286a.mo276b();
            }
        } else {
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0252a.f1254c).setListener(new C0297u(this, z, c0286a));
        }
    }

    void mo289b(C0286a c0286a, boolean z) {
        if (!this.f1456m && this.k.getVisibility() == 0) {
            return;
        }
        if (!ao.m3895G(this.k) || this.k.isInEditMode()) {
            this.k.m1713a(0, z);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            if (c0286a != null) {
                c0286a.mo275a();
                return;
            }
            return;
        }
        this.k.animate().cancel();
        if (this.k.getVisibility() != 0) {
            this.k.setAlpha(0.0f);
            this.k.setScaleY(0.0f);
            this.k.setScaleX(0.0f);
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0252a.f1255d).setListener(new C0298v(this, z, c0286a));
    }

    private void m2214e(float f) {
        if (this.a != null) {
            this.a.m1928a(-f);
        }
        if (this.d != null) {
            this.d.m2117b(-f);
        }
    }
}
