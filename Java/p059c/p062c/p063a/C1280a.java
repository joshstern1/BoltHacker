package com.p059c.p062c.p063a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class C1280a extends Animation {
    public static final boolean f4708a = (Integer.valueOf(VERSION.SDK).intValue() < 11);
    private static final WeakHashMap<View, C1280a> f4709b = new WeakHashMap();
    private final WeakReference<View> f4710c;
    private final Camera f4711d = new Camera();
    private boolean f4712e;
    private float f4713f = 1.0f;
    private float f4714g;
    private float f4715h;
    private float f4716i;
    private float f4717j;
    private float f4718k;
    private float f4719l = 1.0f;
    private float f4720m = 1.0f;
    private float f4721n;
    private float f4722o;
    private final RectF f4723p = new RectF();
    private final RectF f4724q = new RectF();
    private final Matrix f4725r = new Matrix();

    public static C1280a m8460a(View view) {
        Animation animation = (C1280a) f4709b.get(view);
        if (animation != null && animation == view.getAnimation()) {
            return animation;
        }
        C1280a c1280a = new C1280a(view);
        f4709b.put(view, c1280a);
        return c1280a;
    }

    private C1280a(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f4710c = new WeakReference(view);
    }

    public float m8465a() {
        return this.f4713f;
    }

    public void m8466a(float f) {
        if (this.f4713f != f) {
            this.f4713f = f;
            View view = (View) this.f4710c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public float m8468b() {
        return this.f4714g;
    }

    public void m8469b(float f) {
        if (!this.f4712e || this.f4714g != f) {
            m8463o();
            this.f4712e = true;
            this.f4714g = f;
            m8464p();
        }
    }

    public float m8471c() {
        return this.f4715h;
    }

    public void m8472c(float f) {
        if (!this.f4712e || this.f4715h != f) {
            m8463o();
            this.f4712e = true;
            this.f4715h = f;
            m8464p();
        }
    }

    public float m8473d() {
        return this.f4718k;
    }

    public void m8474d(float f) {
        if (this.f4718k != f) {
            m8463o();
            this.f4718k = f;
            m8464p();
        }
    }

    public float m8475e() {
        return this.f4716i;
    }

    public void m8476e(float f) {
        if (this.f4716i != f) {
            m8463o();
            this.f4716i = f;
            m8464p();
        }
    }

    public float m8477f() {
        return this.f4717j;
    }

    public void m8478f(float f) {
        if (this.f4717j != f) {
            m8463o();
            this.f4717j = f;
            m8464p();
        }
    }

    public float m8479g() {
        return this.f4719l;
    }

    public void m8480g(float f) {
        if (this.f4719l != f) {
            m8463o();
            this.f4719l = f;
            m8464p();
        }
    }

    public float m8481h() {
        return this.f4720m;
    }

    public void m8482h(float f) {
        if (this.f4720m != f) {
            m8463o();
            this.f4720m = f;
            m8464p();
        }
    }

    public int m8483i() {
        View view = (View) this.f4710c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public void m8467a(int i) {
        View view = (View) this.f4710c.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public int m8485j() {
        View view = (View) this.f4710c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public void m8470b(int i) {
        View view = (View) this.f4710c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    public float m8487k() {
        return this.f4721n;
    }

    public void m8484i(float f) {
        if (this.f4721n != f) {
            m8463o();
            this.f4721n = f;
            m8464p();
        }
    }

    public float m8489l() {
        return this.f4722o;
    }

    public void m8486j(float f) {
        if (this.f4722o != f) {
            m8463o();
            this.f4722o = f;
            m8464p();
        }
    }

    public float m8491m() {
        View view = (View) this.f4710c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.f4721n;
    }

    public void m8488k(float f) {
        View view = (View) this.f4710c.get();
        if (view != null) {
            m8484i(f - ((float) view.getLeft()));
        }
    }

    public float m8492n() {
        View view = (View) this.f4710c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f4722o;
    }

    public void m8490l(float f) {
        View view = (View) this.f4710c.get();
        if (view != null) {
            m8486j(f - ((float) view.getTop()));
        }
    }

    private void m8463o() {
        View view = (View) this.f4710c.get();
        if (view != null) {
            m8462a(this.f4723p, view);
        }
    }

    private void m8464p() {
        View view = (View) this.f4710c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f4724q;
            m8462a(rectF, view);
            rectF.union(this.f4723p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    private void m8462a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f4725r;
        matrix.reset();
        m8461a(matrix, view);
        this.f4725r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            f = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f;
        }
    }

    private void m8461a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.f4712e;
        float f = z ? this.f4714g : width / 2.0f;
        float f2 = z ? this.f4715h : height / 2.0f;
        float f3 = this.f4716i;
        float f4 = this.f4717j;
        float f5 = this.f4718k;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.f4711d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        f3 = this.f4719l;
        f4 = this.f4720m;
        if (!(f3 == 1.0f && f4 == 1.0f)) {
            matrix.postScale(f3, f4);
            matrix.postTranslate((-(f / width)) * ((f3 * width) - width), (-(f2 / height)) * ((f4 * height) - height));
        }
        matrix.postTranslate(this.f4721n, this.f4722o);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.f4710c.get();
        if (view != null) {
            transformation.setAlpha(this.f4713f);
            m8461a(transformation.getMatrix(), view);
        }
    }
}
