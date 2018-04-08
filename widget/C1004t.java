package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0841k;
import android.util.AttributeSet;
import android.view.View;

class C1004t {
    private final View f3908a;
    private final C1011w f3909b;
    private dc f3910c;
    private dc f3911d;
    private dc f3912e;

    C1004t(View view, C1011w c1011w) {
        this.f3908a = view;
        this.f3909b = c1011w;
    }

    void m7230a(AttributeSet attributeSet, int i) {
        de a = de.m7066a(this.f3908a.getContext(), attributeSet, C0841k.ViewBackgroundHelper, i, 0);
        try {
            if (a.m7083g(C0841k.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f3909b.m7275b(this.f3908a.getContext(), a.m7082g(C0841k.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m7232b(b);
                }
            }
            if (a.m7083g(C0841k.ViewBackgroundHelper_backgroundTint)) {
                ao.m3907a(this.f3908a, a.m7079e(C0841k.ViewBackgroundHelper_backgroundTint));
            }
            if (a.m7083g(C0841k.ViewBackgroundHelper_backgroundTintMode)) {
                ao.m3908a(this.f3908a, az.m6862a(a.m7068a(C0841k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.m7070a();
        } catch (Throwable th) {
            a.m7070a();
        }
    }

    void m7226a(int i) {
        m7232b(this.f3909b != null ? this.f3909b.m7275b(this.f3908a.getContext(), i) : null);
    }

    void m7229a(Drawable drawable) {
        m7232b(null);
    }

    void m7227a(ColorStateList colorStateList) {
        if (this.f3911d == null) {
            this.f3911d = new dc();
        }
        this.f3911d.f3823a = colorStateList;
        this.f3911d.f3826d = true;
        m7233c();
    }

    ColorStateList m7225a() {
        return this.f3911d != null ? this.f3911d.f3823a : null;
    }

    void m7228a(Mode mode) {
        if (this.f3911d == null) {
            this.f3911d = new dc();
        }
        this.f3911d.f3824b = mode;
        this.f3911d.f3825c = true;
        m7233c();
    }

    Mode m7231b() {
        return this.f3911d != null ? this.f3911d.f3824b : null;
    }

    void m7233c() {
        Drawable background = this.f3908a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !m7224b(background)) {
            if (this.f3911d != null) {
                C1011w.m7257a(background, this.f3911d, this.f3908a.getDrawableState());
            } else if (this.f3910c != null) {
                C1011w.m7257a(background, this.f3910c, this.f3908a.getDrawableState());
            }
        }
    }

    void m7232b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f3910c == null) {
                this.f3910c = new dc();
            }
            this.f3910c.f3823a = colorStateList;
            this.f3910c.f3826d = true;
        } else {
            this.f3910c = null;
        }
        m7233c();
    }

    private boolean m7224b(Drawable drawable) {
        if (this.f3912e == null) {
            this.f3912e = new dc();
        }
        dc dcVar = this.f3912e;
        dcVar.m7063a();
        ColorStateList C = ao.m3891C(this.f3908a);
        if (C != null) {
            dcVar.f3826d = true;
            dcVar.f3823a = C;
        }
        Mode D = ao.m3892D(this.f3908a);
        if (D != null) {
            dcVar.f3825c = true;
            dcVar.f3824b = D;
        }
        if (!dcVar.f3826d && !dcVar.f3825c) {
            return false;
        }
        C1011w.m7257a(drawable, dcVar, this.f3908a.getDrawableState());
        return true;
    }
}
