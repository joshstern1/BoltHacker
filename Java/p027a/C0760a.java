package android.support.v7.p027a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.C0778b;
import android.support.v7.view.C0778b.C0825a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class C0760a {

    public static class C0757a extends MarginLayoutParams {
        public int f2454a;

        public C0757a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2454a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0841k.ActionBarLayout);
            this.f2454a = obtainStyledAttributes.getInt(C0841k.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0757a(int i, int i2) {
            super(i, i2);
            this.f2454a = 0;
            this.f2454a = 8388627;
        }

        public C0757a(C0757a c0757a) {
            super(c0757a);
            this.f2454a = 0;
            this.f2454a = c0757a.f2454a;
        }

        public C0757a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2454a = 0;
        }
    }

    public interface C0758b {
        void m4961a(boolean z);
    }

    @Deprecated
    public static abstract class C0759c {
        public abstract Drawable m4962a();

        public abstract CharSequence m4963b();

        public abstract View m4964c();

        public abstract void m4965d();

        public abstract CharSequence m4966e();
    }

    public abstract int mo732a();

    public abstract void mo738a(boolean z);

    public abstract void mo740b(boolean z);

    public abstract boolean mo741b();

    public abstract void mo743c(boolean z);

    public void mo744d(boolean z) {
    }

    public Context mo742c() {
        return null;
    }

    public void mo736a(Drawable drawable) {
    }

    public void mo734a(int i) {
    }

    public void mo770e(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public int mo769d() {
        return 0;
    }

    public void mo733a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void mo746f(boolean z) {
    }

    public void mo748g(boolean z) {
    }

    public void mo735a(Configuration configuration) {
    }

    public void mo751h(boolean z) {
    }

    public C0778b mo767a(C0825a c0825a) {
        return null;
    }

    public boolean mo745e() {
        return false;
    }

    public boolean mo739a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean mo747f() {
        return false;
    }

    public void mo737a(CharSequence charSequence) {
    }

    boolean mo749g() {
        return false;
    }

    void mo750h() {
    }
}
