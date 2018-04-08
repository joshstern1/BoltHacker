package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0192a.C0190h;
import android.support.design.C0192a.C0191i;
import android.support.design.widget.CoordinatorLayout.C0220b;
import android.support.design.widget.CoordinatorLayout.C0227c;
import android.support.design.widget.CoordinatorLayout.C0229e;
import android.support.v4.p017e.C0468d;
import android.support.v4.view.ao;
import android.support.v4.view.bz;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@C0227c(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    boolean f1044a;
    private int f1045b;
    private int f1046c;
    private int f1047d;
    private float f1048e;
    private int f1049f;
    private bz f1050g;
    private final List<C0223b> f1051h;

    public static class Behavior extends C0221z<AppBarLayout> {
        private int f1029a;
        private boolean f1030b;
        private boolean f1031c;
        private bf f1032d;
        private int f1033e = -1;
        private boolean f1034f;
        private float f1035g;
        private WeakReference<View> f1036h;
        private C0219a f1037i;

        protected static class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR = C0468d.m3057a(new C0275d());
            int f1016a;
            float f1017b;
            boolean f1018c;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel);
                this.f1016a = parcel.readInt();
                this.f1017b = parcel.readFloat();
                this.f1018c = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f1016a);
                parcel.writeFloat(this.f1017b);
                parcel.writeByte((byte) (this.f1018c ? 1 : 0));
            }
        }

        public static abstract class C0219a {
            public abstract boolean m1486a(AppBarLayout appBarLayout);
        }

        /* synthetic */ int mo178a(View view) {
            return m1556c((AppBarLayout) view);
        }

        public /* bridge */ /* synthetic */ int mo187b() {
            return super.mo187b();
        }

        /* synthetic */ boolean mo190c(View view) {
            return m1544a((AppBarLayout) view);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean m1547a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.m1589d() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f1032d != null) {
                this.f1032d.m2044e();
            }
            this.f1036h = null;
            return z;
        }

        public void m1537a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.f1030b) {
                int i3;
                int b;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    b = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    b = 0;
                }
                iArr[1] = m1519b(coordinatorLayout, appBarLayout, i2, i3, b);
            }
        }

        public void m1536a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m1519b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f1030b = true;
                return;
            }
            this.f1030b = false;
        }

        public void m1535a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f1031c) {
                m1527c(coordinatorLayout, appBarLayout);
            }
            this.f1030b = false;
            this.f1031c = false;
            this.f1036h = new WeakReference(view);
        }

        public boolean m1546a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = m1517a(coordinatorLayout, (View) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (mo176a() < r1) {
                    m1526b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (mo176a() > r1) {
                    m1526b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            }
            this.f1031c = z2;
            return z2;
        }

        private void m1526b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int a = mo176a();
            if (a != i) {
                if (this.f1032d == null) {
                    this.f1032d = br.m2095a();
                    this.f1032d.m2040a(C0252a.f1256e);
                    this.f1032d.m2039a(new C0274c(this, coordinatorLayout, appBarLayout));
                } else {
                    this.f1032d.m2044e();
                }
                this.f1032d.m2036a(Math.round(((((float) Math.abs(a - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.f1032d.m2037a(a, i);
                this.f1032d.m2034a();
            } else if (this.f1032d != null && this.f1032d.m2041b()) {
                this.f1032d.m2044e();
            }
        }

        private View m1524a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return childAt;
                }
            }
            return null;
        }

        private void m1527c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = mo176a();
            View a2 = m1524a(appBarLayout, a);
            if (a2 != null) {
                C0222a c0222a = (C0222a) a2.getLayoutParams();
                if ((c0222a.m1578a() & 17) == 17) {
                    int s;
                    int i = -a2.getTop();
                    int i2 = -a2.getBottom();
                    if ((c0222a.m1578a() & 2) == 2) {
                        s = ao.m3949s(a2) + i2;
                    } else {
                        s = i2;
                    }
                    if (a >= (s + i) / 2) {
                        s = i;
                    }
                    m1526b(coordinatorLayout, appBarLayout, ab.m1910a(s, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public boolean m1545a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.mo173a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.getPendingAction();
            int i2;
            if (e != 0) {
                i2 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    e = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        m1526b(coordinatorLayout, appBarLayout, e);
                    } else {
                        a_(coordinatorLayout, appBarLayout, e);
                    }
                } else if ((e & 1) != 0) {
                    if (i2 != 0) {
                        m1526b(coordinatorLayout, appBarLayout, 0);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f1033e >= 0) {
                View childAt = appBarLayout.getChildAt(this.f1033e);
                e = -childAt.getBottom();
                if (this.f1034f) {
                    i2 = ao.m3949s(childAt) + e;
                } else {
                    i2 = Math.round(((float) childAt.getHeight()) * this.f1035g) + e;
                }
                mo184a(i2);
            }
            appBarLayout.m1591e();
            this.f1033e = -1;
            mo184a(ab.m1910a(mo187b(), -appBarLayout.getTotalScrollRange(), 0));
            m1528d(appBarLayout);
            return a;
        }

        boolean m1544a(AppBarLayout appBarLayout) {
            if (this.f1037i != null) {
                return this.f1037i.m1486a(appBarLayout);
            }
            if (this.f1036h == null) {
                return true;
            }
            View view = (View) this.f1036h.get();
            return (view == null || !view.isShown() || ao.m3923b(view, -1)) ? false : true;
        }

        void m1533a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m1527c(coordinatorLayout, appBarLayout);
        }

        int m1552b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        int m1556c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        int m1530a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = mo176a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f1029a = 0;
                return 0;
            }
            int a2 = ab.m1910a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.m1587c() ? m1525b(appBarLayout, a2) : a2;
            boolean a3 = mo184a(b);
            a -= a2;
            this.f1029a = a2 - b;
            if (!a3 && appBarLayout.m1587c()) {
                coordinatorLayout.m1688c((View) appBarLayout);
            }
            m1528d(appBarLayout);
            return a;
        }

        private void m1528d(AppBarLayout appBarLayout) {
            List h = appBarLayout.f1051h;
            int size = h.size();
            for (int i = 0; i < size; i++) {
                C0223b c0223b = (C0223b) h.get(i);
                if (c0223b != null) {
                    c0223b.m1580a(appBarLayout, mo187b());
                }
            }
        }

        private int m1525b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                C0222a c0222a = (C0222a) childAt.getLayoutParams();
                Interpolator b = c0222a.m1579b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = c0222a.m1578a();
                    if ((i2 & 1) != 0) {
                        height = (c0222a.bottomMargin + (childAt.getHeight() + c0222a.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= ao.m3949s(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (ao.m3955y(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        int mo176a() {
            return mo187b() + this.f1029a;
        }

        public Parcelable m1554b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.mo189b(coordinatorLayout, appBarLayout);
            int b2 = mo187b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.f1016a = i;
                    if (bottom == ao.m3949s(childAt)) {
                        z = true;
                    }
                    savedState.f1018c = z;
                    savedState.f1017b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        public void m1534a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.mo180a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.f1033e = savedState.f1016a;
                this.f1035g = savedState.f1017b;
                this.f1034f = savedState.f1018c;
                return;
            }
            super.mo180a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f1033e = -1;
        }
    }

    public static class ScrollingViewBehavior extends aa {
        public /* bridge */ /* synthetic */ boolean mo173a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo173a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean mo191a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo191a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ int mo187b() {
            return super.mo187b();
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.ScrollingViewBehavior_Params);
            m1564b(obtainStyledAttributes.getDimensionPixelSize(C0191i.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        public boolean mo196b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean mo197c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m1568e(coordinatorLayout, view, view2);
            return false;
        }

        private void m1568e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            C0220b b = ((C0229e) view2.getLayoutParams()).m1642b();
            if (b instanceof Behavior) {
                Behavior behavior = (Behavior) b;
                behavior.mo176a();
                view.offsetTopAndBottom(((behavior.f1029a + (view2.getBottom() - view.getTop())) + m1560a()) - m1566c(view2));
            }
        }

        float mo193a(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int b = appBarLayout.getDownNestedPreScrollRange();
            int a = m1567a(appBarLayout);
            if (b != 0 && totalScrollRange + a <= b) {
                return 0.0f;
            }
            totalScrollRange -= b;
            if (totalScrollRange != 0) {
                return 1.0f + (((float) a) / ((float) totalScrollRange));
            }
            return 0.0f;
        }

        private static int m1567a(AppBarLayout appBarLayout) {
            C0220b b = ((C0229e) appBarLayout.getLayoutParams()).m1642b();
            if (b instanceof Behavior) {
                return ((Behavior) b).mo176a();
            }
            return 0;
        }

        View mo194a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        int mo195b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.mo195b(view);
        }
    }

    public static class C0222a extends LayoutParams {
        int f1042a = 1;
        Interpolator f1043b;

        public C0222a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.AppBarLayout_LayoutParams);
            this.f1042a = obtainStyledAttributes.getInt(C0191i.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(C0191i.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
                this.f1043b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0191i.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public C0222a(int i, int i2) {
            super(i, i2);
        }

        public C0222a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0222a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0222a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int m1578a() {
            return this.f1042a;
        }

        public Interpolator m1579b() {
            return this.f1043b;
        }
    }

    public interface C0223b {
        void m1580a(AppBarLayout appBarLayout, int i);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m1596a();
    }

    protected /* synthetic */ LayoutParams m17755generateDefaultLayoutParams() {
        return m1596a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1597a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m1598a(layoutParams);
    }

    public /* synthetic */ LayoutParams m17756generateLayoutParams(AttributeSet attributeSet) {
        return m1597a(attributeSet);
    }

    protected /* synthetic */ LayoutParams m17757generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m1598a(layoutParams);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1045b = -1;
        this.f1046c = -1;
        this.f1047d = -1;
        this.f1049f = 0;
        setOrientation(1);
        be.m2015a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.AppBarLayout, 0, C0190h.Widget_Design_AppBarLayout);
        this.f1048e = (float) obtainStyledAttributes.getDimensionPixelSize(C0191i.AppBarLayout_elevation, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0191i.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(C0191i.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(C0191i.AppBarLayout_expanded, false));
        }
        obtainStyledAttributes.recycle();
        br.m2096a(this);
        this.f1051h = new ArrayList();
        ao.m3935f((View) this, this.f1048e);
        ao.m3910a((View) this, new C0262b(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m1585b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1585b();
        this.f1044a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0222a) getChildAt(i5).getLayoutParams()).m1579b() != null) {
                this.f1044a = true;
                return;
            }
        }
    }

    private void m1585b() {
        this.f1045b = -1;
        this.f1046c = -1;
        this.f1047d = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        m1599a(z, ao.m3895G(this));
    }

    public void m1599a(boolean z, boolean z2) {
        this.f1049f = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0222a;
    }

    protected C0222a m1596a() {
        return new C0222a(-1, -2);
    }

    public C0222a m1597a(AttributeSet attributeSet) {
        return new C0222a(getContext(), attributeSet);
    }

    protected C0222a m1598a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new C0222a((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0222a((MarginLayoutParams) layoutParams);
        }
        return new C0222a(layoutParams);
    }

    private boolean m1587c() {
        return this.f1044a;
    }

    public final int getTotalScrollRange() {
        if (this.f1045b != -1) {
            return this.f1045b;
        }
        int s;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0222a c0222a = (C0222a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0222a.f1042a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += c0222a.bottomMargin + (measuredHeight + c0222a.topMargin);
            if ((i3 & 2) != 0) {
                s = i - ao.m3949s(childAt);
                break;
            }
        }
        s = i;
        s = Math.max(0, s - getTopInset());
        this.f1045b = s;
        return s;
    }

    private boolean m1589d() {
        return getTotalScrollRange() != 0;
    }

    private int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    private int getDownNestedPreScrollRange() {
        if (this.f1046c != -1) {
            return this.f1046c;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0222a c0222a = (C0222a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0222a.f1042a;
            if ((i3 & 5) == 5) {
                i = (c0222a.bottomMargin + c0222a.topMargin) + i2;
                if ((i3 & 8) != 0) {
                    i += ao.m3949s(childAt);
                } else if ((i3 & 2) != 0) {
                    i += measuredHeight - ao.m3949s(childAt);
                } else {
                    i += measuredHeight;
                }
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2 - getTopInset());
        this.f1046c = i;
        return i;
    }

    private int getDownNestedScrollRange() {
        if (this.f1047d != -1) {
            return this.f1047d;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0222a c0222a = (C0222a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0222a.topMargin + c0222a.bottomMargin);
            i = c0222a.f1042a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (ao.m3949s(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f1047d = i;
        return i;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int s = ao.m3949s(this);
        if (s != 0) {
            return topInset + (s * 2);
        }
        s = getChildCount();
        return s >= 1 ? topInset + (ao.m3949s(getChildAt(s - 1)) * 2) : 0;
    }

    public void setTargetElevation(float f) {
        this.f1048e = f;
    }

    public float getTargetElevation() {
        return this.f1048e;
    }

    private int getPendingAction() {
        return this.f1049f;
    }

    private void m1591e() {
        this.f1049f = 0;
    }

    private int getTopInset() {
        return this.f1050g != null ? this.f1050g.mo628b() : 0;
    }

    private bz m1582a(bz bzVar) {
        bz bzVar2 = null;
        if (ao.m3955y(this)) {
            bzVar2 = bzVar;
        }
        if (bzVar2 != this.f1050g) {
            this.f1050g = bzVar2;
            m1585b();
        }
        return bzVar;
    }
}
