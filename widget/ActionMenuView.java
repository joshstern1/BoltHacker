package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0195u;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0197k.C0253a;
import android.support.v7.view.menu.C0197k.C0865b;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.view.menu.C0882m;
import android.support.v7.widget.bf.C0905a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends bf implements C0865b, C0195u {
    private C0197k f3145a;
    private Context f3146b;
    private int f3147c;
    private boolean f3148d;
    private ActionMenuPresenter f3149e;
    private C0770a f3150f;
    private C0253a f3151g;
    private boolean f3152h;
    private int f3153i;
    private int f3154j;
    private int f3155k;
    private C0908e f3156l;

    public interface C0864a {
        boolean mo846c();

        boolean mo847d();
    }

    private class C0904b implements C0770a {
        final /* synthetic */ ActionMenuView f3135a;

        private C0904b(ActionMenuView actionMenuView) {
            this.f3135a = actionMenuView;
        }

        public void mo728a(C0197k c0197k, boolean z) {
        }

        public boolean mo729a(C0197k c0197k) {
            return false;
        }
    }

    public static class C0906c extends C0905a {
        @ExportedProperty
        public boolean f3138a;
        @ExportedProperty
        public int f3139b;
        @ExportedProperty
        public int f3140c;
        @ExportedProperty
        public boolean f3141d;
        @ExportedProperty
        public boolean f3142e;
        boolean f3143f;

        public C0906c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0906c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0906c(C0906c c0906c) {
            super(c0906c);
            this.f3138a = c0906c.f3138a;
        }

        public C0906c(int i, int i2) {
            super(i, i2);
            this.f3138a = false;
        }
    }

    private class C0907d implements C0253a {
        final /* synthetic */ ActionMenuView f3144a;

        private C0907d(ActionMenuView actionMenuView) {
            this.f3144a = actionMenuView;
        }

        public boolean mo223a(C0197k c0197k, MenuItem menuItem) {
            return this.f3144a.f3156l != null && this.f3144a.f3156l.mo1052a(menuItem);
        }

        public void mo222a(C0197k c0197k) {
            if (this.f3144a.f3151g != null) {
                this.f3144a.f3151g.mo222a(c0197k);
            }
        }
    }

    public interface C0908e {
        boolean mo1052a(MenuItem menuItem);
    }

    public /* synthetic */ C0905a mo915b(AttributeSet attributeSet) {
        return m5885a(attributeSet);
    }

    protected /* synthetic */ C0905a mo916b(LayoutParams layoutParams) {
        return m5886a(layoutParams);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m5892b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m5885a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m5886a(layoutParams);
    }

    protected /* synthetic */ C0905a mo921j() {
        return m5892b();
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3154j = (int) (56.0f * f);
        this.f3155k = (int) (f * 4.0f);
        this.f3146b = context;
        this.f3147c = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f3147c != i) {
            this.f3147c = i;
            if (i == 0) {
                this.f3146b = getContext();
            } else {
                this.f3146b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f3147c;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f3149e = actionMenuPresenter;
        this.f3149e.m5859a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f3149e != null) {
            this.f3149e.mo153a(false);
            if (this.f3149e.m5874j()) {
                this.f3149e.m5871g();
                this.f3149e.m5870f();
            }
        }
    }

    public void setOnMenuItemClickListener(C0908e c0908e) {
        this.f3156l = c0908e;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f3152h;
        this.f3152h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f3152h) {
            this.f3153i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f3152h || this.f3145a == null || size == this.f3153i)) {
            this.f3153i = size;
            this.f3145a.mo169a(true);
        }
        int childCount = getChildCount();
        if (!this.f3152h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0906c c0906c = (C0906c) getChildAt(i3).getLayoutParams();
                c0906c.rightMargin = 0;
                c0906c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m5884c(i, i2);
    }

    private void m5884c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f3154j;
        size = i3 % this.f3154j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        C0906c c0906c;
        Object obj;
        Object obj2;
        int i6 = this.f3154j + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f3155k, 0, this.f3155k, 0);
                }
                c0906c = (C0906c) childAt.getLayoutParams();
                c0906c.f3143f = false;
                c0906c.f3140c = 0;
                c0906c.f3139b = 0;
                c0906c.f3141d = false;
                c0906c.leftMargin = 0;
                c0906c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m5569a();
                c0906c.f3142e = z2;
                if (c0906c.f3138a) {
                    paddingLeft = 1;
                } else {
                    paddingLeft = i4;
                }
                int a = m5881a(childAt, i6, paddingLeft, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                if (c0906c.f3141d) {
                    paddingLeft = i9 + 1;
                } else {
                    paddingLeft = i9;
                }
                if (c0906c.f3138a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj3 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj3 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        if (obj3 == null || paddingLeft != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0906c = (C0906c) getChildAt(i15).getLayoutParams();
                if (!c0906c.f3141d) {
                    size = i4;
                    i4 = i5;
                } else if (c0906c.f3139b < i5) {
                    i4 = c0906c.f3139b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (c0906c.f3139b == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                c0906c = (C0906c) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj2 != null && c0906c.f3142e && i4 == 1) {
                        childAt2.setPadding(this.f3155k + i6, 0, this.f3155k, 0);
                    }
                    c0906c.f3139b++;
                    c0906c.f3143f = true;
                    size = i4 - 1;
                } else if (c0906c.f3139b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj3 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0906c) getChildAt(0).getLayoutParams()).f3142e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0906c) getChildAt(childCount - 1).getLayoutParams()).f3142e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj2 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj2;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0906c = (C0906c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0906c.f3140c = paddingLeft;
                                c0906c.f3143f = true;
                                if (i4 == 0 && !c0906c.f3142e) {
                                    c0906c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0906c.f3138a) {
                                if (i4 != 0) {
                                    c0906c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0906c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj2;
                            } else {
                                c0906c.f3140c = paddingLeft;
                                c0906c.f3143f = true;
                                c0906c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj2 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0906c = (C0906c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0906c.f3140c = paddingLeft;
                        c0906c.f3143f = true;
                        c0906c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0906c.f3138a) {
                        if (i4 != 0) {
                            c0906c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0906c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj2;
                    } else {
                        c0906c.f3140c = paddingLeft;
                        c0906c.f3143f = true;
                        c0906c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj2;
                }
                i4++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0906c = (C0906c) childAt.getLayoutParams();
                if (c0906c.f3143f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0906c.f3140c + (c0906c.f3139b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    static int m5881a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        C0906c c0906c = (C0906c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.m5569a()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0906c.f3138a && z) {
            z2 = true;
        }
        c0906c.f3141d = z2;
        c0906c.f3139b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3152h) {
            int i5;
            int i6;
            C0906c c0906c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = C0983do.m7164a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0906c = (C0906c) childAt.getLayoutParams();
                    if (c0906c.f3138a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m5890a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0906c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0906c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0906c.leftMargin) + c0906c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m5890a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0906c = (C0906c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0906c.f3138a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0906c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0906c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0906c = (C0906c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0906c.f3138a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0906c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0906c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m5901i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f3149e.m5855a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f3149e.m5869e();
    }

    public boolean m5889a() {
        return this.f3148d;
    }

    public void setOverflowReserved(boolean z) {
        this.f3148d = z;
    }

    protected C0906c m5892b() {
        C0906c c0906c = new C0906c(-2, -2);
        c0906c.h = 16;
        return c0906c;
    }

    public C0906c m5885a(AttributeSet attributeSet) {
        return new C0906c(getContext(), attributeSet);
    }

    protected C0906c m5886a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m5892b();
        }
        C0906c c0906c = layoutParams instanceof C0906c ? new C0906c((C0906c) layoutParams) : new C0906c(layoutParams);
        if (c0906c.h > 0) {
            return c0906c;
        }
        c0906c.h = 16;
        return c0906c;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0906c);
    }

    public C0906c m5895c() {
        C0906c b = m5892b();
        b.f3138a = true;
        return b;
    }

    public boolean mo848a(C0882m c0882m) {
        return this.f3145a.m1300a((MenuItem) c0882m, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void mo141a(C0197k c0197k) {
        this.f3145a = c0197k;
    }

    public Menu getMenu() {
        if (this.f3145a == null) {
            Context context = getContext();
            this.f3145a = new C0197k(context);
            this.f3145a.mo161a(new C0907d());
            this.f3149e = new ActionMenuPresenter(context);
            this.f3149e.m5867c(true);
            this.f3149e.mo152a(this.f3150f != null ? this.f3150f : new C0904b());
            this.f3145a.m1295a(this.f3149e, this.f3146b);
            this.f3149e.m5859a(this);
        }
        return this.f3145a;
    }

    public void m5888a(C0770a c0770a, C0253a c0253a) {
        this.f3150f = c0770a;
        this.f3151g = c0253a;
    }

    public C0197k m5896d() {
        return this.f3145a;
    }

    public boolean m5897e() {
        return this.f3149e != null && this.f3149e.m5870f();
    }

    public boolean m5898f() {
        return this.f3149e != null && this.f3149e.m5871g();
    }

    public boolean m5899g() {
        return this.f3149e != null && this.f3149e.m5874j();
    }

    public boolean m5900h() {
        return this.f3149e != null && this.f3149e.m5875k();
    }

    public void m5901i() {
        if (this.f3149e != null) {
            this.f3149e.m5872h();
        }
    }

    protected boolean m5890a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0864a)) {
            z = 0 | ((C0864a) childAt).mo847d();
        }
        return (i <= 0 || !(childAt2 instanceof C0864a)) ? z : ((C0864a) childAt2).mo846c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f3149e.m5868d(z);
    }
}
