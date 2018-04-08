package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0841k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable f3046a;
    Drawable f3047b;
    Drawable f3048c;
    boolean f3049d;
    boolean f3050e;
    private boolean f3051f;
    private View f3052g;
    private View f3053h;
    private View f3054i;
    private int f3055j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable c0975c;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            c0975c = new C0975c(this);
        } else {
            c0975c = new C0962b(this);
        }
        setBackgroundDrawable(c0975c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0841k.ActionBar);
        this.f3046a = obtainStyledAttributes.getDrawable(C0841k.ActionBar_background);
        this.f3047b = obtainStyledAttributes.getDrawable(C0841k.ActionBar_backgroundStacked);
        this.f3055j = obtainStyledAttributes.getDimensionPixelSize(C0841k.ActionBar_height, -1);
        if (getId() == C0836f.split_action_bar) {
            this.f3049d = true;
            this.f3048c = obtainStyledAttributes.getDrawable(C0841k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f3049d ? this.f3048c == null : this.f3046a == null && this.f3047b == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3053h = findViewById(C0836f.action_bar);
        this.f3054i = findViewById(C0836f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f3046a != null) {
            this.f3046a.setCallback(null);
            unscheduleDrawable(this.f3046a);
        }
        this.f3046a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3053h != null) {
                this.f3046a.setBounds(this.f3053h.getLeft(), this.f3053h.getTop(), this.f3053h.getRight(), this.f3053h.getBottom());
            }
        }
        if (this.f3049d) {
            if (this.f3048c != null) {
                z = false;
            }
        } else if (!(this.f3046a == null && this.f3047b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f3047b != null) {
            this.f3047b.setCallback(null);
            unscheduleDrawable(this.f3047b);
        }
        this.f3047b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3050e && this.f3047b != null) {
                this.f3047b.setBounds(this.f3052g.getLeft(), this.f3052g.getTop(), this.f3052g.getRight(), this.f3052g.getBottom());
            }
        }
        if (this.f3049d) {
            if (this.f3048c != null) {
                z = false;
            }
        } else if (!(this.f3046a == null && this.f3047b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f3048c != null) {
            this.f3048c.setCallback(null);
            unscheduleDrawable(this.f3048c);
        }
        this.f3048c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3049d && this.f3048c != null) {
                this.f3048c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f3049d) {
            if (this.f3048c != null) {
                z = false;
            }
        } else if (!(this.f3046a == null && this.f3047b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f3046a != null) {
            this.f3046a.setVisible(z, false);
        }
        if (this.f3047b != null) {
            this.f3047b.setVisible(z, false);
        }
        if (this.f3048c != null) {
            this.f3048c.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f3046a && !this.f3049d) || ((drawable == this.f3047b && this.f3050e) || ((drawable == this.f3048c && this.f3049d) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3046a != null && this.f3046a.isStateful()) {
            this.f3046a.setState(getDrawableState());
        }
        if (this.f3047b != null && this.f3047b.isStateful()) {
            this.f3047b.setState(getDrawableState());
        }
        if (this.f3048c != null && this.f3048c.isStateful()) {
            this.f3048c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f3046a != null) {
                this.f3046a.jumpToCurrentState();
            }
            if (this.f3047b != null) {
                this.f3047b.jumpToCurrentState();
            }
            if (this.f3048c != null) {
                this.f3048c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f3051f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3051f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ce ceVar) {
        if (this.f3052g != null) {
            removeView(this.f3052g);
        }
        this.f3052g = ceVar;
        if (ceVar != null) {
            addView(ceVar);
            LayoutParams layoutParams = ceVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            ceVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f3052g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private boolean m5778a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m5779b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.f3053h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f3055j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f3055j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f3053h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f3052g != null && this.f3052g.getVisibility() != 8 && mode != 1073741824) {
                int b;
                if (!m5778a(this.f3053h)) {
                    b = m5779b(this.f3053h);
                } else if (m5778a(this.f3054i)) {
                    b = 0;
                } else {
                    b = m5779b(this.f3054i);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m5779b(this.f3052g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f3052g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f3049d) {
            int i6;
            if (this.f3046a != null) {
                if (this.f3053h.getVisibility() == 0) {
                    this.f3046a.setBounds(this.f3053h.getLeft(), this.f3053h.getTop(), this.f3053h.getRight(), this.f3053h.getBottom());
                } else if (this.f3054i == null || this.f3054i.getVisibility() != 0) {
                    this.f3046a.setBounds(0, 0, 0, 0);
                } else {
                    this.f3046a.setBounds(this.f3054i.getLeft(), this.f3054i.getTop(), this.f3054i.getRight(), this.f3054i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f3050e = z2;
            if (!z2 || this.f3047b == null) {
                i5 = i6;
            } else {
                this.f3047b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f3048c != null) {
            this.f3048c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
