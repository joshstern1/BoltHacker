package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.C0192a.C0183a;
import android.support.design.widget.C0292w.C0286a;
import android.support.v4.p013c.p014a.C0441a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class C0293q extends C0292w {
    ae f1447a;
    private int f1448m;
    private ar f1449n = new ar();
    private boolean f1450o;

    private abstract class C0289a extends Animation {
        final /* synthetic */ C0293q f1429a;
        private float f1430b;
        private float f1431c;

        protected abstract float mo277a();

        private C0289a(C0293q c0293q) {
            this.f1429a = c0293q;
        }

        public void reset() {
            super.reset();
            this.f1430b = this.f1429a.f1447a.m1927a();
            this.f1431c = mo277a() - this.f1430b;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            this.f1429a.f1447a.m1931b(this.f1430b + (this.f1431c * f));
        }
    }

    private class C0290b extends C0289a {
        final /* synthetic */ C0293q f1432b;

        private C0290b(C0293q c0293q) {
            this.f1432b = c0293q;
            super();
        }

        protected float mo277a() {
            return this.f1432b.f + this.f1432b.g;
        }
    }

    private class C0291c extends C0289a {
        final /* synthetic */ C0293q f1433b;

        private C0291c(C0293q c0293q) {
            this.f1433b = c0293q;
            super();
        }

        protected float mo277a() {
            return this.f1433b.f;
        }
    }

    C0293q(bu buVar, af afVar) {
        super(buVar, afVar);
        this.f1448m = buVar.getResources().getInteger(17694720);
        this.f1449n.m1973a((View) buVar);
        this.f1449n.m1975a(h, m2197a(new C0290b()));
        this.f1449n.m1975a(i, m2197a(new C0290b()));
        this.f1449n.m1975a(j, m2197a(new C0291c()));
    }

    void mo282a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.b = C0441a.m3002f(m2196k());
        C0441a.m2992a(this.b, colorStateList);
        if (mode != null) {
            C0441a.m2995a(this.b, mode);
        }
        this.c = C0441a.m3002f(m2196k());
        C0441a.m2992a(this.c, C0293q.m2199b(i));
        if (i2 > 0) {
            this.d = m2173a(i2, colorStateList);
            drawableArr = new Drawable[]{this.d, this.b, this.c};
        } else {
            this.d = null;
            drawableArr = new Drawable[]{this.b, this.c};
        }
        this.e = new LayerDrawable(drawableArr);
        this.f1447a = new ae(this.k.getResources(), this.e, this.l.mo206a(), this.f, this.f + this.g);
        this.f1447a.m1930a(false);
        this.l.mo208a(this.f1447a);
    }

    void mo281a(ColorStateList colorStateList) {
        if (this.b != null) {
            C0441a.m2992a(this.b, colorStateList);
        }
        if (this.d != null) {
            this.d.m2116a(colorStateList);
        }
    }

    void mo283a(Mode mode) {
        if (this.b != null) {
            C0441a.m2995a(this.b, mode);
        }
    }

    void mo280a(int i) {
        if (this.c != null) {
            C0441a.m2992a(this.c, C0293q.m2199b(i));
        }
    }

    float mo278a() {
        return this.f;
    }

    void mo279a(float f) {
        if (this.f1447a != null) {
            this.f1447a.m1929a(f, this.g + f);
            m2192g();
        }
    }

    void mo288b(float f) {
        if (this.f1447a != null) {
            this.f1447a.m1932c(this.f + f);
            m2192g();
        }
    }

    void mo286a(int[] iArr) {
        this.f1449n.m1974a(iArr);
    }

    void mo287b() {
        this.f1449n.m1976b();
    }

    void mo285a(C0286a c0286a, boolean z) {
        if (!this.f1450o && this.k.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0183a.design_fab_out);
            loadAnimation.setInterpolator(C0252a.f1254c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new C0294r(this, z, c0286a));
            this.k.startAnimation(loadAnimation);
        } else if (c0286a != null) {
            c0286a.mo276b();
        }
    }

    void mo289b(C0286a c0286a, boolean z) {
        if (this.k.getVisibility() != 0 || this.f1450o) {
            this.k.clearAnimation();
            this.k.m1713a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0183a.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0252a.f1255d);
            loadAnimation.setAnimationListener(new C0295s(this, c0286a));
            this.k.startAnimation(loadAnimation);
        } else if (c0286a != null) {
            c0286a.mo275a();
        }
    }

    void mo290c() {
    }

    void mo284a(Rect rect) {
        this.f1447a.getPadding(rect);
    }

    private Animation m2197a(Animation animation) {
        animation.setInterpolator(C0252a.f1253b);
        animation.setDuration((long) this.f1448m);
        return animation;
    }

    private static ColorStateList m2199b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{i, i, h};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }
}
