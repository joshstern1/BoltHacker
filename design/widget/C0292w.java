package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.C0192a.C0185c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class C0292w {
    static final int[] f1434h = new int[]{16842919, 16842910};
    static final int[] f1435i = new int[]{16842908, 16842910};
    static final int[] f1436j = new int[0];
    private final Rect f1437a = new Rect();
    Drawable f1438b;
    Drawable f1439c;
    C0278g f1440d;
    Drawable f1441e;
    float f1442f;
    float f1443g;
    final bu f1444k;
    final af f1445l;
    private OnPreDrawListener f1446m;

    interface C0286a {
        void mo275a();

        void mo276b();
    }

    abstract float mo278a();

    abstract void mo279a(float f);

    abstract void mo280a(int i);

    abstract void mo281a(ColorStateList colorStateList);

    abstract void mo282a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void mo283a(Mode mode);

    abstract void mo284a(Rect rect);

    abstract void mo285a(C0286a c0286a, boolean z);

    abstract void mo286a(int[] iArr);

    abstract void mo287b();

    abstract void mo288b(float f);

    abstract void mo289b(C0286a c0286a, boolean z);

    abstract void mo290c();

    C0292w(bu buVar, af afVar) {
        this.f1444k = buVar;
        this.f1445l = afVar;
    }

    final void m2187c(float f) {
        if (this.f1442f != f) {
            this.f1442f = f;
            mo279a(f);
        }
    }

    final void m2188d(float f) {
        if (this.f1443g != f) {
            this.f1443g = f;
            mo288b(f);
        }
    }

    final Drawable m2191f() {
        return this.f1441e;
    }

    final void m2192g() {
        Rect rect = this.f1437a;
        mo284a(rect);
        mo295b(rect);
        this.f1445l.mo207a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void mo295b(Rect rect) {
    }

    void m2193h() {
        if (mo293d()) {
            m2171l();
            this.f1444k.getViewTreeObserver().addOnPreDrawListener(this.f1446m);
        }
    }

    void m2194i() {
        if (this.f1446m != null) {
            this.f1444k.getViewTreeObserver().removeOnPreDrawListener(this.f1446m);
            this.f1446m = null;
        }
    }

    boolean mo293d() {
        return false;
    }

    C0278g m2173a(int i, ColorStateList colorStateList) {
        Resources resources = this.f1444k.getResources();
        C0278g j = mo296j();
        j.m2115a(resources.getColor(C0185c.design_fab_stroke_top_outer_color), resources.getColor(C0185c.design_fab_stroke_top_inner_color), resources.getColor(C0185c.design_fab_stroke_end_inner_color), resources.getColor(C0185c.design_fab_stroke_end_outer_color));
        j.m2114a((float) i);
        j.m2116a(colorStateList);
        return j;
    }

    C0278g mo296j() {
        return new C0278g();
    }

    void mo294e() {
    }

    private void m2171l() {
        if (this.f1446m == null) {
            this.f1446m = new C0299x(this);
        }
    }

    GradientDrawable m2196k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
