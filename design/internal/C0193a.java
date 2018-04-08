package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0192a.C0191i;
import android.support.v7.widget.bf;
import android.util.AttributeSet;
import android.view.Gravity;

public class C0193a extends bf {
    protected boolean f881a;
    boolean f882b;
    private Drawable f883c;
    private final Rect f884d;
    private final Rect f885e;
    private int f886f;

    public C0193a(Context context) {
        this(context, null);
    }

    public C0193a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0193a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f884d = new Rect();
        this.f885e = new Rect();
        this.f886f = 119;
        this.f881a = true;
        this.f882b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.ForegroundLinearLayout, i, 0);
        this.f886f = obtainStyledAttributes.getInt(C0191i.ForegroundLinearLayout_android_foregroundGravity, this.f886f);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0191i.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f881a = obtainStyledAttributes.getBoolean(C0191i.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.f886f;
    }

    public void setForegroundGravity(int i) {
        if (this.f886f != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f886f = i2;
            if (this.f886f == 119 && this.f883c != null) {
                this.f883c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f883c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f883c != null) {
            this.f883c.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f883c != null && this.f883c.isStateful()) {
            this.f883c.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.f883c != drawable) {
            if (this.f883c != null) {
                this.f883c.setCallback(null);
                unscheduleDrawable(this.f883c);
            }
            this.f883c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f886f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.f883c;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f882b |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f882b = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f883c != null) {
            Drawable drawable = this.f883c;
            if (this.f882b) {
                this.f882b = false;
                Rect rect = this.f884d;
                Rect rect2 = this.f885e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f881a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f886f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f883c != null) {
            this.f883c.setHotspot(f, f2);
        }
    }
}
