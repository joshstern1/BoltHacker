package com.codetroopers.betterpickers.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0684z;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0245f;
import android.support.v4.view.bb;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1291h;

public class UnderlinePageIndicatorPicker extends View implements C1351a {
    private int f5154a;
    private final Paint f5155b;
    private ViewPager f5156c;
    private C0245f f5157d;
    private int f5158e;
    private int f5159f;
    private float f5160g;
    private int f5161h;
    private float f5162i;
    private int f5163j;
    private boolean f5164k;
    private C1316b f5165l;
    private Paint f5166m;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C1353d();
        int f5153a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5153a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5153a);
        }
    }

    public UnderlinePageIndicatorPicker(Context context) {
        this(context, null);
    }

    public UnderlinePageIndicatorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5155b = new Paint(1);
        this.f5162i = -1.0f;
        this.f5163j = -1;
        this.f5165l = null;
    }

    public UnderlinePageIndicatorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5155b = new Paint(1);
        this.f5162i = -1.0f;
        this.f5163j = -1;
        this.f5165l = null;
        this.f5154a = getResources().getColor(C1284a.dialog_text_color_holo_dark);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1291h.BetterPickersDialogFragment, i, 0);
        this.f5154a = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpKeyboardIndicatorColor, this.f5154a);
        this.f5166m = new Paint();
        this.f5166m.setAntiAlias(true);
        this.f5166m.setStyle(Style.FILL);
        obtainStyledAttributes.recycle();
        this.f5161h = bb.m4086a(ViewConfiguration.get(context));
    }

    public int getSelectedColor() {
        return this.f5155b.getColor();
    }

    public void setSelectedColor(int i) {
        this.f5155b.setColor(i);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int b = this.f5156c.getAdapter().mo1273b();
        if (!isInEditMode() && b != 0 && this.f5165l != null) {
            View a = this.f5165l.mo1274a(this.f5159f);
            float left = (float) a.getLeft();
            float right = (float) a.getRight();
            if (this.f5160g > 0.0f && this.f5159f < b - 1) {
                View a2 = this.f5165l.mo1274a(this.f5159f + 1);
                float left2 = (float) a2.getLeft();
                left = (left * (1.0f - this.f5160g)) + (left2 * this.f5160g);
                right = (((float) a2.getRight()) * this.f5160g) + ((1.0f - this.f5160g) * right);
            }
            canvas.drawRect(left, (float) getPaddingBottom(), right, (float) (getHeight() - getPaddingBottom()), this.f5155b);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f5156c == null || this.f5156c.getAdapter().mo1273b() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.f5163j = C0684z.m4400b(motionEvent, 0);
                this.f5162i = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.f5164k) {
                    int b = this.f5156c.getAdapter().mo1273b();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f5159f <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f5159f < b - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f5156c.setCurrentItem(this.f5159f + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f5156c.setCurrentItem(this.f5159f - 1);
                        return true;
                    }
                }
                this.f5164k = false;
                this.f5163j = -1;
                if (!this.f5156c.m3237f()) {
                    return true;
                }
                this.f5156c.m3236e();
                return true;
            case 2:
                float c = C0684z.m4401c(motionEvent, C0684z.m4398a(motionEvent, this.f5163j));
                float f3 = c - this.f5162i;
                if (!this.f5164k && Math.abs(f3) > ((float) this.f5161h)) {
                    this.f5164k = true;
                }
                if (!this.f5164k) {
                    return true;
                }
                this.f5162i = c;
                if (!this.f5156c.m3237f() && !this.f5156c.m3235d()) {
                    return true;
                }
                this.f5156c.m3231b(f3);
                return true;
            case 5:
                i = C0684z.m4399b(motionEvent);
                this.f5162i = C0684z.m4401c(motionEvent, i);
                this.f5163j = C0684z.m4400b(motionEvent, i);
                return true;
            case 6:
                action = C0684z.m4399b(motionEvent);
                if (C0684z.m4400b(motionEvent, action) == this.f5163j) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f5163j = C0684z.m4400b(motionEvent, i);
                }
                this.f5162i = C0684z.m4401c(motionEvent, C0684z.m4398a(motionEvent, this.f5163j));
                return true;
            default:
                return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f5156c != viewPager) {
            if (this.f5156c != null) {
                this.f5156c.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f5156c = viewPager;
            this.f5156c.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        if (this.f5156c == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f5156c.setCurrentItem(i);
        this.f5159f = i;
        invalidate();
    }

    public void mo213a(int i) {
        this.f5158e = i;
        if (this.f5157d != null) {
            this.f5157d.mo213a(i);
        }
    }

    public void mo214a(int i, float f, int i2) {
        this.f5159f = i;
        this.f5160g = f;
        invalidate();
        if (this.f5157d != null) {
            this.f5157d.mo214a(i, f, i2);
        }
    }

    public void mo215b(int i) {
        if (this.f5158e == 0) {
            this.f5159f = i;
            this.f5160g = 0.0f;
            invalidate();
        }
        if (this.f5157d != null) {
            this.f5157d.mo215b(i);
        }
    }

    public void setOnPageChangeListener(C0245f c0245f) {
        this.f5157d = c0245f;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f5159f = savedState.f5153a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5153a = this.f5159f;
        return savedState;
    }

    public void setTitleView(C1316b c1316b) {
        this.f5165l = c1316b;
        invalidate();
    }
}
