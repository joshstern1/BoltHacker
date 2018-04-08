package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p028b.C0842a.C0841k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f3585a;
    private int f3586b;
    private WeakReference<View> f3587c;
    private LayoutInflater f3588d;
    private C0955a f3589e;

    public interface C0955a {
        void m6689a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3585a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0841k.ViewStubCompat, i, 0);
        this.f3586b = obtainStyledAttributes.getResourceId(C0841k.ViewStubCompat_android_inflatedId, -1);
        this.f3585a = obtainStyledAttributes.getResourceId(C0841k.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0841k.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f3586b;
    }

    public void setInflatedId(int i) {
        this.f3586b = i;
    }

    public int getLayoutResource() {
        return this.f3585a;
    }

    public void setLayoutResource(int i) {
        this.f3585a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f3588d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f3588d;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.f3587c != null) {
            View view = (View) this.f3587c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m6690a();
        }
    }

    public View m6690a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f3585a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f3588d != null) {
                layoutInflater = this.f3588d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f3585a, viewGroup, false);
            if (this.f3586b != -1) {
                inflate.setId(this.f3586b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f3587c = new WeakReference(inflate);
            if (this.f3589e != null) {
                this.f3589e.m6689a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C0955a c0955a) {
        this.f3589e = c0955a;
    }
}
