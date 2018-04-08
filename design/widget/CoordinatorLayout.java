package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.C0192a.C0190h;
import android.support.design.C0192a.C0191i;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.p017e.C0468d;
import android.support.v4.p021b.C0307a;
import android.support.v4.view.C0645j;
import android.support.v4.view.C0684z;
import android.support.v4.view.ag;
import android.support.v4.view.ah;
import android.support.v4.view.ai;
import android.support.v4.view.ao;
import android.support.v4.view.bz;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements ag {
    static final String f1092a;
    static final Class<?>[] f1093b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<C0220b>>> f1094c = new ThreadLocal();
    static final Comparator<View> f1095e;
    static final C0283l f1096f;
    final Comparator<View> f1097d;
    private final List<View> f1098g;
    private final List<View> f1099h;
    private final List<View> f1100i;
    private final Rect f1101j;
    private final Rect f1102k;
    private final Rect f1103l;
    private final int[] f1104m;
    private Paint f1105n;
    private boolean f1106o;
    private int[] f1107p;
    private View f1108q;
    private View f1109r;
    private View f1110s;
    private C0230f f1111t;
    private boolean f1112u;
    private bz f1113v;
    private boolean f1114w;
    private Drawable f1115x;
    private OnHierarchyChangeListener f1116y;
    private final ah f1117z;

    public static abstract class C0220b<V extends View> {
        public C0220b(Context context, AttributeSet attributeSet) {
        }

        public boolean mo174a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo175b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public int m1502c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float m1504d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean m1506e(CoordinatorLayout coordinatorLayout, V v) {
            return m1504d(coordinatorLayout, v) > 0.0f;
        }

        public boolean mo196b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean mo197c(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void m1505d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean mo191a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean mo173a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean mo186a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public void m1499b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void mo181a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void mo182a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void mo183a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean mo185a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean mo198a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public bz m1487a(CoordinatorLayout coordinatorLayout, V v, bz bzVar) {
            return bzVar;
        }

        public void mo180a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable mo189b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C0468d.m3057a(new C0282k());
        SparseArray<Parcelable> f1075a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1075a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f1075a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f1075a != null ? this.f1075a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f1075a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f1075a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    private class C0226a implements ai {
        final /* synthetic */ CoordinatorLayout f1076a;

        private C0226a(CoordinatorLayout coordinatorLayout) {
            this.f1076a = coordinatorLayout;
        }

        public bz mo172a(View view, bz bzVar) {
            return this.f1076a.m1657a(bzVar);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface C0227c {
        Class<? extends C0220b> m1633a();
    }

    private class C0228d implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout f1077a;

        private C0228d(CoordinatorLayout coordinatorLayout) {
            this.f1077a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.f1077a.f1116y != null) {
                this.f1077a.f1116y.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f1077a.m1684b(view2);
            if (this.f1077a.f1116y != null) {
                this.f1077a.f1116y.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class C0229e extends MarginLayoutParams {
        C0220b f1078a;
        boolean f1079b = false;
        public int f1080c = 0;
        public int f1081d = 0;
        public int f1082e = -1;
        int f1083f = -1;
        View f1084g;
        View f1085h;
        final Rect f1086i = new Rect();
        Object f1087j;
        private boolean f1088k;
        private boolean f1089l;
        private boolean f1090m;

        public C0229e(int i, int i2) {
            super(i, i2);
        }

        C0229e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.CoordinatorLayout_LayoutParams);
            this.f1080c = obtainStyledAttributes.getInteger(C0191i.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
            this.f1083f = obtainStyledAttributes.getResourceId(C0191i.CoordinatorLayout_LayoutParams_layout_anchor, -1);
            this.f1081d = obtainStyledAttributes.getInteger(C0191i.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
            this.f1082e = obtainStyledAttributes.getInteger(C0191i.CoordinatorLayout_LayoutParams_layout_keyline, -1);
            this.f1079b = obtainStyledAttributes.hasValue(C0191i.CoordinatorLayout_LayoutParams_layout_behavior);
            if (this.f1079b) {
                this.f1078a = CoordinatorLayout.m1655a(context, attributeSet, obtainStyledAttributes.getString(C0191i.CoordinatorLayout_LayoutParams_layout_behavior));
            }
            obtainStyledAttributes.recycle();
        }

        public C0229e(C0229e c0229e) {
            super(c0229e);
        }

        public C0229e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0229e(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int m1636a() {
            return this.f1083f;
        }

        public C0220b m1642b() {
            return this.f1078a;
        }

        public void m1638a(C0220b c0220b) {
            if (this.f1078a != c0220b) {
                this.f1078a = c0220b;
                this.f1087j = null;
                this.f1079b = true;
            }
        }

        void m1637a(Rect rect) {
            this.f1086i.set(rect);
        }

        Rect m1645c() {
            return this.f1086i;
        }

        boolean m1646d() {
            return this.f1084g == null && this.f1083f != -1;
        }

        boolean m1647e() {
            if (this.f1078a == null) {
                this.f1088k = false;
            }
            return this.f1088k;
        }

        boolean m1640a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1088k) {
                return true;
            }
            boolean e = (this.f1078a != null ? this.f1078a.m1506e(coordinatorLayout, view) : 0) | this.f1088k;
            this.f1088k = e;
            return e;
        }

        void m1648f() {
            this.f1088k = false;
        }

        void m1649g() {
            this.f1089l = false;
        }

        void m1639a(boolean z) {
            this.f1089l = z;
        }

        boolean m1650h() {
            return this.f1089l;
        }

        boolean m1651i() {
            return this.f1090m;
        }

        void m1644b(boolean z) {
            this.f1090m = z;
        }

        void m1652j() {
            this.f1090m = false;
        }

        boolean m1641a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f1085h || (this.f1078a != null && this.f1078a.mo196b(coordinatorLayout, view, view2));
        }

        View m1643b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1083f == -1) {
                this.f1085h = null;
                this.f1084g = null;
                return null;
            }
            if (this.f1084g == null || !m1635b(view, coordinatorLayout)) {
                m1634a(view, coordinatorLayout);
            }
            return this.f1084g;
        }

        private void m1634a(View view, CoordinatorLayout coordinatorLayout) {
            this.f1084g = coordinatorLayout.findViewById(this.f1083f);
            if (this.f1084g != null) {
                if (this.f1084g != coordinatorLayout) {
                    View view2 = this.f1084g;
                    View parent = this.f1084g.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f1085h = null;
                            this.f1084g = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f1085h = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f1085h = null;
                    this.f1084g = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f1085h = null;
                this.f1084g = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1083f) + " to anchor view " + view);
            }
        }

        private boolean m1635b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1084g.getId() != this.f1083f) {
                return false;
            }
            View view2 = this.f1084g;
            View parent = this.f1084g.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.f1085h = null;
                    this.f1084g = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.f1085h = view2;
            return true;
        }
    }

    class C0230f implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout f1091a;

        C0230f(CoordinatorLayout coordinatorLayout) {
            this.f1091a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f1091a.m1680a(false);
            return true;
        }
    }

    static class C0231g implements Comparator<View> {
        C0231g() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1653a((View) obj, (View) obj2);
        }

        public int m1653a(View view, View view2) {
            float H = ao.m3896H(view);
            float H2 = ao.m3896H(view2);
            if (H > H2) {
                return -1;
            }
            if (H < H2) {
                return 1;
            }
            return 0;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1690d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1671a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1673a(layoutParams);
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f1092a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f1095e = new C0231g();
            f1096f = new C0284m();
        } else {
            f1095e = null;
            f1096f = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f1097d = new C0281j(this);
        this.f1098g = new ArrayList();
        this.f1099h = new ArrayList();
        this.f1100i = new ArrayList();
        this.f1101j = new Rect();
        this.f1102k = new Rect();
        this.f1103l = new Rect();
        this.f1104m = new int[2];
        this.f1117z = new ah(this);
        be.m2015a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.CoordinatorLayout, i, C0190h.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0191i.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f1107p = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f1107p.length;
            while (i2 < length) {
                int[] iArr = this.f1107p;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f1115x = obtainStyledAttributes.getDrawable(C0191i.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (f1096f != null) {
            f1096f.mo274a(this, new C0226a());
        }
        super.setOnHierarchyChangeListener(new C0228d());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1116y = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m1669e();
        if (this.f1112u) {
            if (this.f1111t == null) {
                this.f1111t = new C0230f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1111t);
        }
        if (this.f1113v == null && ao.m3955y(this)) {
            ao.m3954x(this);
        }
        this.f1106o = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1669e();
        if (this.f1112u && this.f1111t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1111t);
        }
        if (this.f1110s != null) {
            onStopNestedScroll(this.f1110s);
        }
        this.f1106o = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f1115x != drawable) {
            if (this.f1115x != null) {
                this.f1115x.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f1115x = drawable2;
            if (this.f1115x != null) {
                if (this.f1115x.isStateful()) {
                    this.f1115x.setState(getDrawableState());
                }
                C0441a.setLayoutDirection(this.f1115x, ao.m3938h(this));
                this.f1115x.setVisible(getVisibility() == 0, false);
                this.f1115x.setCallback(this);
            }
            ao.m3928d(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f1115x;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f1115x;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1115x;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1115x != null && this.f1115x.isVisible() != z) {
            this.f1115x.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0307a.m2325a(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    private bz m1657a(bz bzVar) {
        boolean z = true;
        if (this.f1113v == bzVar) {
            return bzVar;
        }
        this.f1113v = bzVar;
        boolean z2 = bzVar != null && bzVar.mo628b() > 0;
        this.f1114w = z2;
        if (this.f1114w || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        bzVar = m1664b(bzVar);
        requestLayout();
        return bzVar;
    }

    private void m1669e() {
        int i = 0;
        if (this.f1108q != null) {
            C0220b b = ((C0229e) this.f1108q.getLayoutParams()).m1642b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.mo175b(this, this.f1108q, obtain);
                obtain.recycle();
            }
            this.f1108q = null;
        }
        int childCount = getChildCount();
        while (i < childCount) {
            ((C0229e) getChildAt(i).getLayoutParams()).m1648f();
            i++;
        }
    }

    private void m1660a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            int childDrawingOrder;
            if (isChildrenDrawingOrderEnabled) {
                childDrawingOrder = getChildDrawingOrder(childCount, i);
            } else {
                childDrawingOrder = i;
            }
            list.add(getChildAt(childDrawingOrder));
        }
        if (f1095e != null) {
            Collections.sort(list, f1095e);
        }
    }

    private boolean m1662a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = C0684z.m4397a(motionEvent);
        List list = this.f1099h;
        m1660a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            C0229e c0229e = (C0229e) view.getLayoutParams();
            C0220b b = c0229e.m1642b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case 0:
                            z2 = b.mo174a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = b.mo175b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f1108q = view;
                    }
                }
                z = z2;
                boolean e = c0229e.m1647e();
                boolean a2 = c0229e.m1640a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        b.mo174a(this, view, motionEvent3);
                        break;
                    case 1:
                        b.mo175b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = C0684z.m4397a(motionEvent);
        if (a == 0) {
            m1669e();
        }
        boolean a2 = m1662a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            m1669e();
        }
        return a2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2 = null;
        int a = C0684z.m4397a(motionEvent);
        MotionEvent obtain;
        if (this.f1108q == null) {
            boolean a2 = m1662a(motionEvent, 1);
            if (a2) {
                z = a2;
            } else {
                z = a2;
                z2 = false;
                if (this.f1108q == null) {
                    z2 |= super.onTouchEvent(motionEvent);
                } else if (z) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z2 || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        m1669e();
                    }
                    return z2;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m1669e();
                return z2;
            }
        }
        z = false;
        C0220b b = ((C0229e) this.f1108q.getLayoutParams()).m1642b();
        z2 = b != null ? b.mo175b(this, this.f1108q, motionEvent) : false;
        if (this.f1108q == null) {
            z2 |= super.onTouchEvent(motionEvent);
        } else if (z) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z2) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m1669e();
        return z2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m1669e();
        }
    }

    private int m1654a(int i) {
        if (this.f1107p == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f1107p.length) {
            return this.f1107p[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static C0220b m1655a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f1092a)) {
            str = f1092a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f1094c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f1094c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f1093b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0220b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    C0229e m1672a(View view) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        if (!c0229e.f1079b) {
            C0227c c0227c = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c0227c = (C0227c) cls.getAnnotation(C0227c.class);
                if (c0227c != null) {
                    break;
                }
            }
            C0227c c0227c2 = c0227c;
            if (c0227c2 != null) {
                try {
                    c0229e.m1638a((C0220b) c0227c2.m1633a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c0227c2.m1633a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0229e.f1079b = true;
        }
        return c0229e;
    }

    private void m1670f() {
        this.f1098g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            m1672a(childAt).m1643b(this, childAt);
            this.f1098g.add(childAt);
        }
        m1661a(this.f1098g, this.f1097d);
    }

    void m1678a(View view, Rect rect) {
        bn.m2083b(this, view, rect);
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void m1676a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        m1670f();
        m1674a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int h = ao.m3938h(this);
        Object obj2;
        if (h == 1) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        if (this.f1113v == null || !ao.m3955y(this)) {
            obj = null;
        } else {
            obj = 1;
        }
        int size3 = this.f1098g.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = paddingBottom;
        int i8 = suggestedMinimumWidth;
        while (i5 < size3) {
            int i9;
            View view = (View) this.f1098g.get(i5);
            C0229e c0229e = (C0229e) view.getLayoutParams();
            int i10 = 0;
            if (c0229e.f1082e >= 0 && mode != 0) {
                int a = m1654a(c0229e.f1082e);
                paddingTop = C0645j.m4290a(m1666c(c0229e.f1080c), h) & 7;
                if ((paddingTop == 3 && r9 == null) || (paddingTop == 5 && r9 != null)) {
                    i10 = Math.max(0, (size - paddingRight) - a);
                } else if ((paddingTop == 5 && r9 == null) || (paddingTop == 3 && r9 != null)) {
                    i10 = Math.max(0, a - paddingLeft);
                }
            }
            if (obj == null || ao.m3955y(view)) {
                i9 = i2;
                suggestedMinimumWidth = i;
            } else {
                paddingTop = this.f1113v.mo628b() + this.f1113v.mo630d();
                suggestedMinimumWidth = MeasureSpec.makeMeasureSpec(size - (this.f1113v.mo626a() + this.f1113v.mo629c()), mode);
                i9 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            C0220b b = c0229e.m1642b();
            if (b == null || !b.mo191a(this, view, suggestedMinimumWidth, i10, i9, 0)) {
                m1676a(view, suggestedMinimumWidth, i10, i9, 0);
            }
            i10 = Math.max(i8, ((view.getMeasuredWidth() + i3) + c0229e.leftMargin) + c0229e.rightMargin);
            suggestedMinimumWidth = Math.max(i7, ((view.getMeasuredHeight() + i4) + c0229e.topMargin) + c0229e.bottomMargin);
            i5++;
            i6 = ao.m3899a(i6, ao.m3942l(view));
            i7 = suggestedMinimumWidth;
            i8 = i10;
        }
        setMeasuredDimension(ao.m3900a(i8, i, -16777216 & i6), ao.m3900a(i7, i2, i6 << 16));
    }

    private bz m1664b(bz bzVar) {
        if (bzVar.mo631e()) {
            return bzVar;
        }
        bz a;
        int childCount = getChildCount();
        int i = 0;
        bz bzVar2 = bzVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (ao.m3955y(childAt)) {
                C0220b b = ((C0229e) childAt.getLayoutParams()).m1642b();
                if (b != null) {
                    a = b.m1487a(this, childAt, bzVar2);
                    if (a.mo631e()) {
                        break;
                    }
                    i++;
                    bzVar2 = a;
                }
            }
            a = bzVar2;
            i++;
            bzVar2 = a;
        }
        a = bzVar2;
        return a;
    }

    public void m1675a(View view, int i) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        if (c0229e.m1646d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0229e.f1084g != null) {
            m1659a(view, c0229e.f1084g, i);
        } else if (c0229e.f1082e >= 0) {
            m1665b(view, c0229e.f1082e, i);
        } else {
            m1667c(view, i);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int h = ao.m3938h(this);
        int size = this.f1098g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f1098g.get(i5);
            C0220b b = ((C0229e) view.getLayoutParams()).m1642b();
            if (b == null || !b.mo173a(this, view, h)) {
                m1675a(view, h);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1114w && this.f1115x != null) {
            int b = this.f1113v != null ? this.f1113v.mo628b() : 0;
            if (b > 0) {
                this.f1115x.setBounds(0, 0, getWidth(), b);
                this.f1115x.draw(canvas);
            }
        }
    }

    void m1686b(View view, Rect rect) {
        ((C0229e) view.getLayoutParams()).m1637a(rect);
    }

    void m1689c(View view, Rect rect) {
        rect.set(((C0229e) view.getLayoutParams()).m1645c());
    }

    void m1679a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            m1678a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    void m1677a(View view, int i, Rect rect, Rect rect2) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        int a = C0645j.m4290a(m1668d(c0229e.f1080c), i);
        int a2 = C0645j.m4290a(m1663b(c0229e.f1081d), i);
        int i2 = a & 7;
        int i3 = a & 112;
        a = a2 & 7;
        int i4 = a2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (a) {
            case 1:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i4) {
            case 16:
                a = rect.top + (rect.height() / 2);
                break;
            case 80:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i2) {
            case 1:
                a2 -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                a2 -= measuredWidth;
                break;
        }
        switch (i3) {
            case 16:
                a -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                a -= measuredHeight;
                break;
        }
        i2 = getWidth();
        i3 = getHeight();
        a2 = Math.max(getPaddingLeft() + c0229e.leftMargin, Math.min(a2, ((i2 - getPaddingRight()) - measuredWidth) - c0229e.rightMargin));
        int max = Math.max(getPaddingTop() + c0229e.topMargin, Math.min(a, ((i3 - getPaddingBottom()) - measuredHeight) - c0229e.bottomMargin));
        rect2.set(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private void m1659a(View view, View view2, int i) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        Rect rect = this.f1101j;
        Rect rect2 = this.f1102k;
        m1678a(view2, rect);
        m1677a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void m1665b(View view, int i, int i2) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        int a = C0645j.m4290a(m1666c(c0229e.f1080c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a2 = m1654a(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case 1:
                a2 += measuredWidth / 2;
                break;
            case 5:
                a2 += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                a = 0 + (measuredHeight / 2);
                break;
            case 80:
                a = 0 + measuredHeight;
                break;
        }
        a2 = Math.max(getPaddingLeft() + c0229e.leftMargin, Math.min(a2, ((width - getPaddingRight()) - measuredWidth) - c0229e.rightMargin));
        int max = Math.max(getPaddingTop() + c0229e.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - c0229e.bottomMargin));
        view.layout(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private void m1667c(View view, int i) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        Rect rect = this.f1101j;
        rect.set(getPaddingLeft() + c0229e.leftMargin, getPaddingTop() + c0229e.topMargin, (getWidth() - getPaddingRight()) - c0229e.rightMargin, (getHeight() - getPaddingBottom()) - c0229e.bottomMargin);
        if (!(this.f1113v == null || !ao.m3955y(this) || ao.m3955y(view))) {
            rect.left += this.f1113v.mo626a();
            rect.top += this.f1113v.mo628b();
            rect.right -= this.f1113v.mo629c();
            rect.bottom -= this.f1113v.mo630d();
        }
        Rect rect2 = this.f1102k;
        C0645j.m4291a(m1663b(c0229e.f1080c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int m1663b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private static int m1666c(int i) {
        return i == 0 ? 8388661 : i;
    }

    private static int m1668d(int i) {
        return i == 0 ? 17 : i;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        if (c0229e.f1078a != null && c0229e.f1078a.m1504d(this, view) > 0.0f) {
            if (this.f1105n == null) {
                this.f1105n = new Paint();
            }
            this.f1105n.setColor(c0229e.f1078a.m1502c(this, view));
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f1105n);
        }
        return super.drawChild(canvas, view, j);
    }

    void m1680a(boolean z) {
        int h = ao.m3938h(this);
        int size = this.f1098g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            View view = (View) this.f1098g.get(i);
            C0229e c0229e = (C0229e) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (c0229e.f1085h == ((View) this.f1098g.get(i2))) {
                    m1685b(view, h);
                }
            }
            Rect rect = this.f1101j;
            Rect rect2 = this.f1102k;
            m1689c(view, rect);
            m1679a(view, true, rect2);
            if (!rect.equals(rect2)) {
                m1686b(view, rect2);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.f1098g.get(i2);
                    C0229e c0229e2 = (C0229e) view2.getLayoutParams();
                    C0220b b = c0229e2.m1642b();
                    if (b != null && b.mo196b(this, view2, view)) {
                        if (z || !c0229e2.m1651i()) {
                            boolean c = b.mo197c(this, view2, view);
                            if (z) {
                                c0229e2.m1644b(c);
                            }
                        } else {
                            c0229e2.m1652j();
                        }
                    }
                }
            }
        }
    }

    void m1684b(View view) {
        int size = this.f1098g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f1098g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0229e c0229e = (C0229e) view2.getLayoutParams();
                    C0220b b = c0229e.m1642b();
                    if (b != null && c0229e.m1641a(this, view2, view)) {
                        b.m1505d(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    public void m1688c(View view) {
        int size = this.f1098g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f1098g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0229e c0229e = (C0229e) view2.getLayoutParams();
                    C0220b b = c0229e.m1642b();
                    if (b != null && c0229e.m1641a(this, view2, view)) {
                        b.mo197c(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    public List<View> m1691d(View view) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        List<View> list = this.f1100i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0229e.m1641a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    void m1674a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m1692e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f1112u) {
            return;
        }
        if (z) {
            m1683b();
        } else {
            m1687c();
        }
    }

    boolean m1692e(View view) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        if (c0229e.f1084g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0229e.m1641a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    void m1683b() {
        if (this.f1106o) {
            if (this.f1111t == null) {
                this.f1111t = new C0230f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1111t);
        }
        this.f1112u = true;
    }

    void m1687c() {
        if (this.f1106o && this.f1111t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1111t);
        }
        this.f1112u = false;
    }

    void m1685b(View view, int i) {
        C0229e c0229e = (C0229e) view.getLayoutParams();
        if (c0229e.f1084g != null) {
            Rect rect = this.f1101j;
            Rect rect2 = this.f1102k;
            Rect rect3 = this.f1103l;
            m1678a(c0229e.f1084g, rect);
            m1679a(view, false, rect2);
            m1677a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if (i2 != 0 || i3 != 0) {
                C0220b b = c0229e.m1642b();
                if (b != null) {
                    b.mo197c(this, view, c0229e.f1084g);
                }
            }
        }
    }

    public boolean m1681a(View view, int i, int i2) {
        Rect rect = this.f1101j;
        m1678a(view, rect);
        return rect.contains(i, i2);
    }

    public boolean m1682a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        boolean z;
        Rect rect = this.f1101j;
        m1679a(view, view.getParent() != this, rect);
        Rect rect2 = this.f1102k;
        if (view2.getParent() != this) {
            z = true;
        } else {
            z = false;
        }
        m1679a(view2, z, rect2);
        if (rect.left > rect2.right || rect.top > rect2.bottom || rect.right < rect2.left || rect.bottom < rect2.top) {
            return false;
        }
        return true;
    }

    public C0229e m1671a(AttributeSet attributeSet) {
        return new C0229e(getContext(), attributeSet);
    }

    protected C0229e m1673a(LayoutParams layoutParams) {
        if (layoutParams instanceof C0229e) {
            return new C0229e((C0229e) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0229e((MarginLayoutParams) layoutParams);
        }
        return new C0229e(layoutParams);
    }

    protected C0229e m1690d() {
        return new C0229e(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0229e) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            C0229e c0229e = (C0229e) childAt.getLayoutParams();
            C0220b b = c0229e.m1642b();
            if (b != null) {
                boolean a = b.mo186a(this, childAt, view, view2, i);
                z2 = z | a;
                c0229e.m1639a(a);
            } else {
                c0229e.m1639a(false);
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1117z.m3662a(view, view2, i);
        this.f1109r = view;
        this.f1110s = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0229e c0229e = (C0229e) childAt.getLayoutParams();
            if (c0229e.m1650h()) {
                C0220b b = c0229e.m1642b();
                if (b != null) {
                    b.m1499b(this, childAt, view, view2, i);
                }
            }
        }
    }

    public void onStopNestedScroll(View view) {
        this.f1117z.m3661a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0229e c0229e = (C0229e) childAt.getLayoutParams();
            if (c0229e.m1650h()) {
                C0220b b = c0229e.m1642b();
                if (b != null) {
                    b.mo181a(this, childAt, view);
                }
                c0229e.m1649g();
                c0229e.m1652j();
            }
        }
        this.f1109r = null;
        this.f1110s = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            C0229e c0229e = (C0229e) childAt.getLayoutParams();
            if (c0229e.m1650h()) {
                C0220b b = c0229e.m1642b();
                if (b != null) {
                    b.mo182a(this, childAt, view, i, i2, i3, i4);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m1680a(true);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            C0229e c0229e = (C0229e) childAt.getLayoutParams();
            if (c0229e.m1650h()) {
                C0220b b = c0229e.m1642b();
                if (b != null) {
                    int[] iArr2 = this.f1104m;
                    this.f1104m[1] = 0;
                    iArr2[0] = 0;
                    b.mo183a(this, childAt, view, i, i2, this.f1104m);
                    max = i > 0 ? Math.max(i3, this.f1104m[0]) : Math.min(i3, this.f1104m[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.f1104m[1]) : Math.min(i4, this.f1104m[1]);
                    int i6 = 1;
                } else {
                    obj2 = obj;
                    max = i3;
                    max2 = i4;
                }
            } else {
                obj2 = obj;
                max = i3;
                max2 = i4;
            }
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m1680a(true);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0229e c0229e = (C0229e) childAt.getLayoutParams();
            if (c0229e.m1650h()) {
                C0220b b = c0229e.m1642b();
                if (b != null) {
                    a = b.mo185a(this, childAt, view, f, f2, z) | z2;
                } else {
                    a = z2;
                }
            } else {
                a = z2;
            }
            i++;
            z2 = a;
        }
        if (z2) {
            m1680a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0229e c0229e = (C0229e) childAt.getLayoutParams();
            if (c0229e.m1650h()) {
                C0220b b = c0229e.m1642b();
                if (b != null) {
                    a = b.mo198a(this, childAt, view, f, f2) | z;
                } else {
                    a = z;
                }
            } else {
                a = z;
            }
            i++;
            z = a;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.f1117z.m3660a();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.f1075a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                C0220b b = m1672a(childAt).m1642b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.mo180a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0220b b = ((C0229e) childAt.getLayoutParams()).m1642b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.mo189b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        savedState.f1075a = sparseArray;
        return savedState;
    }

    private static void m1661a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }
}
