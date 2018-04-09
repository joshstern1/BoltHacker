package android.support.p011a.p012a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.p014a.C0165o;
import android.support.v4.p013c.p014a.C0441a;
import android.util.AttributeSet;

@TargetApi(21)
abstract class C0166g extends Drawable implements C0165o {
    Drawable f787a;

    C0166g() {
    }

    static TypedArray m1035b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f787a != null) {
            this.f787a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f787a != null) {
            return C0441a.m3001e(this.f787a);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.f787a != null) {
            return this.f787a.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f787a != null) {
            this.f787a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f787a != null) {
            C0441a.m2989a(this.f787a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f787a != null) {
            C0441a.m2991a(this.f787a, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f787a != null) {
            this.f787a.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f787a != null) {
            C0441a.m2988a(this.f787a);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.f787a != null) {
            C0441a.m2996a(this.f787a, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.f787a != null) {
            C0441a.m2997b(this.f787a);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.f787a != null) {
            C0441a.m2993a(this.f787a, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.f787a != null) {
            C0441a.m3004h(this.f787a);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.f787a != null) {
            this.f787a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f787a != null) {
            return this.f787a.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f787a != null) {
            return this.f787a.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f787a != null) {
            return this.f787a.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f787a != null) {
            return this.f787a.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f787a != null) {
            return this.f787a.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f787a != null) {
            return this.f787a.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f787a != null) {
            this.f787a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f787a != null) {
            return this.f787a.setState(iArr);
        }
        return super.setState(iArr);
    }
}
