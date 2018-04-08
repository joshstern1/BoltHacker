package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.p013c.p014a.C0441a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class C0300y extends C0296t {
    private final Interpolator f1465m;
    private InsetDrawable f1466n;

    C0300y(bu buVar, af afVar) {
        super(buVar, afVar);
        this.f1465m = buVar.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), 17563661);
    }

    void mo282a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.b = C0441a.m3002f(m2196k());
        C0441a.m2992a(this.b, colorStateList);
        if (mode != null) {
            C0441a.m2995a(this.b, mode);
        }
        if (i2 > 0) {
            this.d = m2173a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.d, this.b});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        this.c = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.e = this.c;
        this.l.mo208a(this.c);
    }

    void mo280a(int i) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable) this.c).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo280a(i);
        }
    }

    public void mo279a(float f) {
        this.k.setElevation(f);
        if (this.l.mo209b()) {
            m2192g();
        }
    }

    void mo288b(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(h, m2219a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{f})));
        stateListAnimator.addState(i, m2219a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{f})));
        stateListAnimator.addState(j, m2219a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{0.0f})));
        this.k.setStateListAnimator(stateListAnimator);
        if (this.l.mo209b()) {
            m2192g();
        }
    }

    public float mo278a() {
        return this.k.getElevation();
    }

    void mo290c() {
        m2192g();
    }

    void mo295b(Rect rect) {
        if (this.l.mo209b()) {
            this.f1466n = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.mo208a(this.f1466n);
            return;
        }
        this.l.mo208a(this.c);
    }

    void mo286a(int[] iArr) {
    }

    void mo287b() {
    }

    boolean mo293d() {
        return false;
    }

    private Animator m2219a(Animator animator) {
        animator.setInterpolator(this.f1465m);
        return animator;
    }

    C0278g mo296j() {
        return new C0279h();
    }

    void mo284a(Rect rect) {
        if (this.l.mo209b()) {
            float a = this.l.mo206a();
            float a2 = mo278a() + this.g;
            int ceil = (int) Math.ceil((double) ae.m1924b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) ae.m1921a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
