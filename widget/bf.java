package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0645j;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0841k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class bf extends ViewGroup {
    private boolean f866a;
    private int f867b;
    private int f868c;
    private int f869d;
    private int f870e;
    private int f871f;
    private float f872g;
    private boolean f873h;
    private int[] f874i;
    private int[] f875j;
    private Drawable f876k;
    private int f877l;
    private int f878m;
    private int f879n;
    private int f880o;

    public static class C0905a extends MarginLayoutParams {
        public float f3136g;
        public int f3137h;

        public C0905a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3137h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0841k.LinearLayoutCompat_Layout);
            this.f3136g = obtainStyledAttributes.getFloat(C0841k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f3137h = obtainStyledAttributes.getInt(C0841k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0905a(int i, int i2) {
            super(i, i2);
            this.f3137h = -1;
            this.f3136g = 0.0f;
        }

        public C0905a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3137h = -1;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return mo921j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return mo915b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return mo916b(layoutParams);
    }

    public bf(Context context) {
        this(context, null);
    }

    public bf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public bf(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f866a = true;
        this.f867b = -1;
        this.f868c = 0;
        this.f870e = 8388659;
        de a = de.m7066a(context, attributeSet, C0841k.LinearLayoutCompat, i, 0);
        int a2 = a.m7068a(C0841k.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m7068a(C0841k.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m7071a(C0841k.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f872g = a.m7067a(C0841k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f867b = a.m7068a(C0841k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f873h = a.m7071a(C0841k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m7069a(C0841k.LinearLayoutCompat_divider));
        this.f879n = a.m7068a(C0841k.LinearLayoutCompat_showDividers, 0);
        this.f880o = a.m7078e(C0841k.LinearLayoutCompat_dividerPadding, 0);
        a.m7070a();
    }

    public void setShowDividers(int i) {
        if (i != this.f879n) {
            requestLayout();
        }
        this.f879n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f879n;
    }

    public Drawable getDividerDrawable() {
        return this.f876k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f876k) {
            this.f876k = drawable;
            if (drawable != null) {
                this.f877l = drawable.getIntrinsicWidth();
                this.f878m = drawable.getIntrinsicHeight();
            } else {
                this.f877l = 0;
                this.f878m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f880o = i;
    }

    public int getDividerPadding() {
        return this.f880o;
    }

    public int getDividerWidth() {
        return this.f877l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f876k != null) {
            if (this.f869d == 1) {
                m1116a(canvas);
            } else {
                m1125b(canvas);
            }
        }
    }

    void m1116a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m1122b(i);
            if (!(b == null || b.getVisibility() == 8 || !m1127c(i))) {
                m1117a(canvas, (b.getTop() - ((C0905a) b.getLayoutParams()).topMargin) - this.f878m);
            }
            i++;
        }
        if (m1127c(virtualChildCount)) {
            int height;
            View b2 = m1122b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f878m;
            } else {
                C0905a c0905a = (C0905a) b2.getLayoutParams();
                height = c0905a.bottomMargin + b2.getBottom();
            }
            m1117a(canvas, height);
        }
    }

    void m1125b(Canvas canvas) {
        C0905a c0905a;
        int virtualChildCount = getVirtualChildCount();
        boolean a = C0983do.m7164a(this);
        int i = 0;
        while (i < virtualChildCount) {
            int right;
            View b = m1122b(i);
            if (!(b == null || b.getVisibility() == 8 || !m1127c(i))) {
                c0905a = (C0905a) b.getLayoutParams();
                if (a) {
                    right = c0905a.rightMargin + b.getRight();
                } else {
                    right = (b.getLeft() - c0905a.leftMargin) - this.f877l;
                }
                m1126b(canvas, right);
            }
            i++;
        }
        if (m1127c(virtualChildCount)) {
            View b2 = m1122b(virtualChildCount - 1);
            if (b2 != null) {
                c0905a = (C0905a) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - c0905a.leftMargin) - this.f877l;
                } else {
                    right = c0905a.rightMargin + b2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.f877l;
            }
            m1126b(canvas, right);
        }
    }

    void m1117a(Canvas canvas, int i) {
        this.f876k.setBounds(getPaddingLeft() + this.f880o, i, (getWidth() - getPaddingRight()) - this.f880o, this.f878m + i);
        this.f876k.draw(canvas);
    }

    void m1126b(Canvas canvas, int i) {
        this.f876k.setBounds(i, getPaddingTop() + this.f880o, this.f877l + i, (getHeight() - getPaddingBottom()) - this.f880o);
        this.f876k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f866a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f873h = z;
    }

    public int getBaseline() {
        if (this.f867b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f867b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f867b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f868c;
            if (this.f869d == 1) {
                i = this.f870e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f871f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f871f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0905a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f867b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f867b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f867b = i;
    }

    View m1122b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f872g;
    }

    public void setWeightSum(float f) {
        this.f872g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f869d == 1) {
            m1114a(i, i2);
        } else {
            m1123b(i, i2);
        }
    }

    protected boolean m1127c(int i) {
        if (i == 0) {
            if ((this.f879n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f879n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f879n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void m1114a(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        View b;
        this.f871f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i9 = this.f867b;
        boolean z = this.f873h;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj5;
            int i12;
            int i13;
            View b2 = m1122b(i11);
            if (b2 == null) {
                this.f871f += m1128d(i11);
                i3 = i10;
                obj5 = obj4;
                obj = obj2;
                i12 = i6;
                i13 = i5;
            } else if (b2.getVisibility() == 8) {
                i11 += m1113a(b2, i11);
                i3 = i10;
                obj5 = obj4;
                obj = obj2;
                i12 = i6;
                i13 = i5;
            } else {
                if (m1127c(i11)) {
                    this.f871f += this.f878m;
                }
                C0905a c0905a = (C0905a) b2.getLayoutParams();
                float f2 = f + c0905a.f3136g;
                if (mode2 == 1073741824 && c0905a.height == 0 && c0905a.f3136g > 0.0f) {
                    i3 = this.f871f;
                    this.f871f = Math.max(i3, (c0905a.topMargin + i3) + c0905a.bottomMargin);
                    obj4 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0905a.height == 0 && c0905a.f3136g > 0.0f) {
                        i3 = 0;
                        c0905a.height = -2;
                    }
                    int i14 = i3;
                    m1118a(b2, i11, i, 0, i2, f2 == 0.0f ? this.f871f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0905a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f871f;
                    this.f871f = Math.max(i15, (((i15 + i3) + c0905a.topMargin) + c0905a.bottomMargin) + m1119b(b2));
                    if (z) {
                        i10 = Math.max(i3, i10);
                    }
                }
                if (i9 >= 0 && i9 == i11 + 1) {
                    this.f868c = this.f871f;
                }
                if (i11 >= i9 || c0905a.f3136g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0905a.width != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i12 = c0905a.rightMargin + c0905a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i12;
                    i5 = Math.max(i5, i13);
                    int a = C0983do.m7162a(i6, ao.m3942l(b2));
                    obj = (obj2 == null || c0905a.width != -1) ? null : 1;
                    if (c0905a.f3136g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i12;
                        } else {
                            i3 = i13;
                        }
                        i3 = Math.max(i8, i3);
                        i12 = i7;
                    } else {
                        if (obj7 == null) {
                            i12 = i13;
                        }
                        i12 = Math.max(i7, i12);
                        i3 = i8;
                    }
                    i11 += m1113a(b2, i11);
                    obj5 = obj4;
                    i8 = i3;
                    i7 = i12;
                    i13 = i5;
                    i3 = i10;
                    i12 = a;
                    obj3 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i11++;
            i10 = i3;
            obj4 = obj5;
            obj2 = obj;
            i6 = i12;
            i5 = i13;
        }
        if (this.f871f > 0 && m1127c(virtualChildCount)) {
            this.f871f += this.f878m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f871f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                b = m1122b(i4);
                if (b == null) {
                    this.f871f += m1128d(i4);
                    i3 = i4;
                } else if (b.getVisibility() == 8) {
                    i3 = m1113a(b, i4) + i4;
                } else {
                    C0905a c0905a2 = (C0905a) b.getLayoutParams();
                    int i16 = this.f871f;
                    this.f871f = Math.max(i16, (c0905a2.bottomMargin + ((i16 + i10) + c0905a2.topMargin)) + m1119b(b));
                    i3 = i4;
                }
                i4 = i3 + 1;
            }
        }
        this.f871f += getPaddingTop() + getPaddingBottom();
        int a2 = ao.m3900a(Math.max(this.f871f, getSuggestedMinimumHeight()), i2, 0);
        i4 = (16777215 & a2) - this.f871f;
        int i17;
        if (obj4 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f872g > 0.0f) {
                f = this.f872g;
            }
            this.f871f = 0;
            i10 = 0;
            float f3 = f;
            Object obj8 = obj2;
            i17 = i7;
            i16 = i6;
            i8 = i5;
            i15 = i4;
            while (i10 < virtualChildCount) {
                View b3 = m1122b(i10);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i4 = i16;
                    i12 = i8;
                    obj = obj8;
                } else {
                    float f4;
                    float f5;
                    c0905a2 = (C0905a) b3.getLayoutParams();
                    float f6 = c0905a2.f3136g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i4;
                        i12 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0905a2.leftMargin) + c0905a2.rightMargin, c0905a2.width);
                        if (c0905a2.height == 0 && mode2 == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        } else {
                            i4 += b3.getMeasuredHeight();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        }
                        f4 = f3;
                        i11 = i15;
                        i15 = C0983do.m7162a(i16, ao.m3942l(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i11 = i15;
                        i15 = i16;
                    }
                    i16 = c0905a2.leftMargin + c0905a2.rightMargin;
                    i12 = b3.getMeasuredWidth() + i16;
                    i8 = Math.max(i8, i12);
                    Object obj9 = (mode == 1073741824 || c0905a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i12;
                    }
                    i12 = Math.max(i17, i16);
                    obj = (obj8 == null || c0905a2.width != -1) ? null : 1;
                    i13 = this.f871f;
                    this.f871f = Math.max(i13, (c0905a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0905a2.topMargin)) + m1119b(b3));
                    i3 = i12;
                    i12 = i8;
                    f4 = f5;
                    i4 = i15;
                    i15 = i11;
                    f3 = f4;
                }
                i10++;
                i17 = i3;
                i8 = i12;
                obj8 = obj;
                i16 = i4;
            }
            this.f871f += getPaddingTop() + getPaddingBottom();
            obj2 = obj8;
            i3 = i17;
            i6 = i16;
            i4 = i8;
        } else {
            i17 = Math.max(i7, i8);
            if (z && mode2 != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    b = m1122b(i4);
                    if (!(b == null || b.getVisibility() == 8 || ((C0905a) b.getLayoutParams()).f3136g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                }
            }
            i3 = i17;
            i4 = i5;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(ao.m3900a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i6), a2);
        if (obj3 != null) {
            m1110c(virtualChildCount, i2);
        }
    }

    private void m1110c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m1122b(i3);
            if (b.getVisibility() != 8) {
                C0905a c0905a = (C0905a) b.getLayoutParams();
                if (c0905a.width == -1) {
                    int i4 = c0905a.height;
                    c0905a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0905a.height = i4;
                }
            }
        }
    }

    void m1123b(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        int i5;
        C0905a c0905a;
        this.f871f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.f874i == null || this.f875j == null) {
            this.f874i = new int[4];
            this.f875j = new int[4];
        }
        int[] iArr = this.f874i;
        int[] iArr2 = this.f875j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f866a;
        boolean z2 = this.f873h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i12;
            View b = m1122b(i11);
            if (b == null) {
                this.f871f += m1128d(i11);
                i3 = i10;
                obj5 = obj4;
                obj6 = obj2;
                i4 = i7;
                i12 = i6;
            } else if (b.getVisibility() == 8) {
                i11 += m1113a(b, i11);
                i3 = i10;
                obj5 = obj4;
                obj6 = obj2;
                i4 = i7;
                i12 = i6;
            } else {
                Object obj7;
                if (m1127c(i11)) {
                    this.f871f += this.f877l;
                }
                C0905a c0905a2 = (C0905a) b.getLayoutParams();
                float f2 = f + c0905a2.f3136g;
                if (mode == 1073741824 && c0905a2.width == 0 && c0905a2.f3136g > 0.0f) {
                    if (obj != null) {
                        this.f871f += c0905a2.leftMargin + c0905a2.rightMargin;
                    } else {
                        i3 = this.f871f;
                        this.f871f = Math.max(i3, (c0905a2.leftMargin + i3) + c0905a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj4 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0905a2.width == 0 && c0905a2.f3136g > 0.0f) {
                        i3 = 0;
                        c0905a2.width = -2;
                    }
                    int i13 = i3;
                    m1118a(b, i11, i, f2 == 0.0f ? this.f871f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0905a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj != null) {
                        this.f871f += ((c0905a2.leftMargin + i3) + c0905a2.rightMargin) + m1119b(b);
                    } else {
                        int i14 = this.f871f;
                        this.f871f = Math.max(i14, (((i14 + i3) + c0905a2.leftMargin) + c0905a2.rightMargin) + m1119b(b));
                    }
                    if (z2) {
                        i10 = Math.max(i3, i10);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0905a2.height != -1) {
                    obj7 = obj3;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i4 = c0905a2.bottomMargin + c0905a2.topMargin;
                i12 = b.getMeasuredHeight() + i4;
                int a = C0983do.m7162a(i7, ao.m3942l(b));
                if (z) {
                    i7 = b.getBaseline();
                    if (i7 != -1) {
                        int i15 = ((((c0905a2.f3137h < 0 ? this.f870e : c0905a2.f3137h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i7);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i7);
                    }
                }
                i7 = Math.max(i6, i12);
                obj6 = (obj2 == null || c0905a2.height != -1) ? null : 1;
                if (c0905a2.f3136g > 0.0f) {
                    if (obj8 != null) {
                        i3 = i4;
                    } else {
                        i3 = i12;
                    }
                    i3 = Math.max(i9, i3);
                    i4 = i8;
                } else {
                    if (obj8 == null) {
                        i4 = i12;
                    }
                    i4 = Math.max(i8, i4);
                    i3 = i9;
                }
                i11 += m1113a(b, i11);
                obj5 = obj4;
                i9 = i3;
                i8 = i4;
                i12 = i7;
                i3 = i10;
                i4 = a;
                obj3 = obj7;
                f = f2;
            }
            i11++;
            i10 = i3;
            obj4 = obj5;
            obj2 = obj6;
            i7 = i4;
            i6 = i12;
        }
        if (this.f871f > 0 && m1127c(virtualChildCount)) {
            this.f871f += this.f877l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i11 = i6;
        } else {
            i11 = Math.max(i6, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f871f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                View b2 = m1122b(i5);
                if (b2 == null) {
                    this.f871f += m1128d(i5);
                    i3 = i5;
                } else if (b2.getVisibility() == 8) {
                    i3 = m1113a(b2, i5) + i5;
                } else {
                    c0905a = (C0905a) b2.getLayoutParams();
                    if (obj != null) {
                        this.f871f = ((c0905a.rightMargin + (c0905a.leftMargin + i10)) + m1119b(b2)) + this.f871f;
                        i3 = i5;
                    } else {
                        i4 = this.f871f;
                        this.f871f = Math.max(i4, (c0905a.rightMargin + ((i4 + i10) + c0905a.leftMargin)) + m1119b(b2));
                        i3 = i5;
                    }
                }
                i5 = i3 + 1;
            }
        }
        this.f871f += getPaddingLeft() + getPaddingRight();
        int a2 = ao.m3900a(Math.max(this.f871f, getSuggestedMinimumWidth()), i, 0);
        i5 = (16777215 & a2) - this.f871f;
        int i16;
        if (obj4 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f872g > 0.0f) {
                f = this.f872g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f871f = 0;
            i10 = 0;
            float f3 = f;
            Object obj9 = obj2;
            i16 = i8;
            i15 = i7;
            i14 = i5;
            i8 = -1;
            while (i10 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m1122b(i10);
                if (b3 == null) {
                    f4 = f3;
                    i5 = i14;
                    i4 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i5 = i14;
                    i4 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0905a = (C0905a) b3.getLayoutParams();
                    float f6 = c0905a.f3136g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i4 = i14 - i5;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0905a.topMargin) + c0905a.bottomMargin, c0905a.height);
                        if (c0905a.width == 0 && mode == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        } else {
                            i5 += b3.getMeasuredWidth();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        }
                        i9 = C0983do.m7162a(i15, ao.m3942l(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i4 = i14;
                        i9 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.f871f += ((b3.getMeasuredWidth() + c0905a.leftMargin) + c0905a.rightMargin) + m1119b(b3);
                    } else {
                        i5 = this.f871f;
                        this.f871f = Math.max(i5, (((b3.getMeasuredWidth() + i5) + c0905a.leftMargin) + c0905a.rightMargin) + m1119b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || c0905a.height != -1) ? null : 1;
                    i11 = c0905a.topMargin + c0905a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i11;
                    i8 = Math.max(i8, i14);
                    if (obj5 != null) {
                        i5 = i11;
                    } else {
                        i5 = i14;
                    }
                    i11 = Math.max(i16, i5);
                    obj5 = (obj9 == null || c0905a.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((c0905a.f3137h < 0 ? this.f870e : c0905a.f3137h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i11;
                    obj10 = obj5;
                    i15 = i9;
                    i5 = i4;
                    i4 = i8;
                }
                i10++;
                i16 = i14;
                i8 = i4;
                obj9 = obj10;
                i14 = i5;
                f3 = f4;
            }
            this.f871f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i8 = Math.max(i8, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i16;
            i7 = i15;
            i5 = i8;
        } else {
            i16 = Math.max(i8, i9);
            if (z2 && mode != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    View b4 = m1122b(i5);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0905a) b4.getLayoutParams()).f3136g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i5 = i11;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension((-16777216 & i7) | a2, ao.m3900a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i7 << 16));
        if (obj3 != null) {
            m1111d(virtualChildCount, i);
        }
    }

    private void m1111d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m1122b(i3);
            if (b.getVisibility() != 8) {
                C0905a c0905a = (C0905a) b.getLayoutParams();
                if (c0905a.height == -1) {
                    int i4 = c0905a.width;
                    c0905a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0905a.width = i4;
                }
            }
        }
    }

    int m1113a(View view, int i) {
        return 0;
    }

    int m1128d(int i) {
        return 0;
    }

    void m1118a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m1112a(View view) {
        return 0;
    }

    int m1119b(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f869d == 1) {
            m1115a(i, i2, i3, i4);
        } else {
            m1124b(i, i2, i3, i4);
        }
    }

    void m1115a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f870e & 8388615;
        switch (this.f870e & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f871f) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.f871f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m1122b(i7);
            if (b == null) {
                i8 += m1128d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0905a c0905a = (C0905a) b.getLayoutParams();
                i5 = c0905a.f3137h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0645j.m4290a(i5, ao.m3938h(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0905a.leftMargin) - c0905a.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - c0905a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0905a.leftMargin;
                        break;
                }
                if (m1127c(i7)) {
                    i5 = this.f878m + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + c0905a.topMargin;
                m1109a(b, i9, i10 + m1112a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0905a.bottomMargin + measuredHeight) + m1119b(b));
                i5 = m1113a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m1124b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = C0983do.m7164a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f870e & 8388615;
        int i8 = this.f870e & 112;
        boolean z = this.f866a;
        int[] iArr = this.f874i;
        int[] iArr2 = this.f875j;
        switch (C0645j.m4290a(i7, ao.m3938h(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f871f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f871f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m1122b(i10);
            if (b == null) {
                paddingLeft += m1128d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0905a c0905a = (C0905a) b.getLayoutParams();
                if (!z || c0905a.height == -1) {
                    i7 = -1;
                } else {
                    i7 = b.getBaseline();
                }
                int i12 = c0905a.f3137h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0905a.topMargin) - c0905a.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + c0905a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - c0905a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (m1127c(i10)) {
                    i7 = this.f877l + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + c0905a.leftMargin;
                m1109a(b, paddingLeft + m1112a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0905a.rightMargin + measuredWidth) + m1119b(b);
                i7 = m1113a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void m1109a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f869d != i) {
            this.f869d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f869d;
    }

    public void setGravity(int i) {
        if (this.f870e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f870e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f870e & 8388615) != i2) {
            this.f870e = i2 | (this.f870e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f870e & 112) != i2) {
            this.f870e = i2 | (this.f870e & -113);
            requestLayout();
        }
    }

    public C0905a mo915b(AttributeSet attributeSet) {
        return new C0905a(getContext(), attributeSet);
    }

    protected C0905a mo921j() {
        if (this.f869d == 0) {
            return new C0905a(-2, -2);
        }
        if (this.f869d == 1) {
            return new C0905a(-1, -2);
        }
        return null;
    }

    protected C0905a mo916b(LayoutParams layoutParams) {
        return new C0905a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0905a;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(bf.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(bf.class.getName());
        }
    }
}
