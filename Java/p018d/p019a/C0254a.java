package android.support.v7.p018d.p019a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p013c.p014a.C0441a;

public class C0254a extends Drawable implements Callback {
    private Drawable f1258a;

    public C0254a(Drawable drawable) {
        m1919a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f1258a.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f1258a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f1258a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f1258a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1258a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1258a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1258a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1258a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f1258a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f1258a.setState(iArr);
    }

    public int[] getState() {
        return this.f1258a.getState();
    }

    public void jumpToCurrentState() {
        C0441a.m2988a(this.f1258a);
    }

    public Drawable getCurrent() {
        return this.f1258a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1258a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f1258a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1258a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1258a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1258a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1258a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1258a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1258a.getPadding(rect);
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
        return this.f1258a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        C0441a.m2996a(this.f1258a, z);
    }

    public boolean isAutoMirrored() {
        return C0441a.m2997b(this.f1258a);
    }

    public void setTint(int i) {
        C0441a.m2990a(this.f1258a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0441a.m2992a(this.f1258a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0441a.m2995a(this.f1258a, mode);
    }

    public void setHotspot(float f, float f2) {
        C0441a.m2989a(this.f1258a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0441a.m2991a(this.f1258a, i, i2, i3, i4);
    }

    public Drawable m1920b() {
        return this.f1258a;
    }

    public void m1919a(Drawable drawable) {
        if (this.f1258a != null) {
            this.f1258a.setCallback(null);
        }
        this.f1258a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
