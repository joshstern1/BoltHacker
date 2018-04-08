package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class C0452j extends Drawable implements Callback, C0449i, C0165o {
    static final Mode f1904a = Mode.SRC_IN;
    C0450a f1905b;
    Drawable f1906c;
    private int f1907d;
    private Mode f1908e;
    private boolean f1909f;
    private boolean f1910g;

    protected static abstract class C0450a extends ConstantState {
        int f1900a;
        ConstantState f1901b;
        ColorStateList f1902c = null;
        Mode f1903d = C0452j.f1904a;

        public abstract Drawable newDrawable(Resources resources);

        C0450a(C0450a c0450a, Resources resources) {
            if (c0450a != null) {
                this.f1900a = c0450a.f1900a;
                this.f1901b = c0450a.f1901b;
                this.f1902c = c0450a.f1902c;
                this.f1903d = c0450a.f1903d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.f1901b != null ? this.f1901b.getChangingConfigurations() : 0) | this.f1900a;
        }

        boolean m3033a() {
            return this.f1901b != null;
        }
    }

    private static class C0451b extends C0450a {
        C0451b(C0450a c0450a, Resources resources) {
            super(c0450a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0452j(this, resources);
        }
    }

    C0452j(C0450a c0450a, Resources resources) {
        this.f1905b = c0450a;
        m3034a(resources);
    }

    C0452j(Drawable drawable) {
        this.f1905b = mo411b();
        mo409a(drawable);
    }

    private void m3034a(Resources resources) {
        if (this.f1905b != null && this.f1905b.f1901b != null) {
            mo409a(mo410a(this.f1905b.f1901b, resources));
        }
    }

    protected Drawable mo410a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.f1906c.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f1906c != null) {
            this.f1906c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f1906c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.f1905b != null ? this.f1905b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f1906c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1906c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1906c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1906c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1906c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo412c() || this.f1905b == null) ? null : this.f1905b.f1902c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1906c.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m3035a(iArr) || this.f1906c.setState(iArr);
    }

    public int[] getState() {
        return this.f1906c.getState();
    }

    public Drawable getCurrent() {
        return this.f1906c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1906c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f1906c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1906c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1906c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1906c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1906c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1906c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1906c.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f1905b == null || !this.f1905b.m3033a()) {
            return null;
        }
        this.f1905b.f1900a = getChangingConfigurations();
        return this.f1905b;
    }

    public Drawable mutate() {
        if (!this.f1910g && super.mutate() == this) {
            this.f1905b = mo411b();
            if (this.f1906c != null) {
                this.f1906c.mutate();
            }
            if (this.f1905b != null) {
                this.f1905b.f1901b = this.f1906c != null ? this.f1906c.getConstantState() : null;
            }
            this.f1910g = true;
        }
        return this;
    }

    C0450a mo411b() {
        return new C0451b(this.f1905b, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f1906c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1905b.f1902c = colorStateList;
        m3035a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f1905b.f1903d = mode;
        m3035a(getState());
    }

    private boolean m3035a(int[] iArr) {
        if (!mo412c()) {
            return false;
        }
        ColorStateList colorStateList = this.f1905b.f1902c;
        Mode mode = this.f1905b.f1903d;
        if (colorStateList == null || mode == null) {
            this.f1909f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1909f && colorForState == this.f1907d && mode == this.f1908e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f1907d = colorForState;
        this.f1908e = mode;
        this.f1909f = true;
        return true;
    }

    public final Drawable mo408a() {
        return this.f1906c;
    }

    public final void mo409a(Drawable drawable) {
        if (this.f1906c != null) {
            this.f1906c.setCallback(null);
        }
        this.f1906c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f1905b != null) {
                this.f1905b.f1901b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean mo412c() {
        return true;
    }
}
