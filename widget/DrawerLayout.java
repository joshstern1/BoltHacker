package android.support.v4.widget;

import android.content.Context;
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
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.p017e.C0468d;
import android.support.v4.p021b.C0307a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.C0249b;
import android.support.v4.view.C0645j;
import android.support.v4.view.C0651l;
import android.support.v4.view.ao;
import android.support.v4.view.be;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0547e.C0534a;
import android.support.v4.widget.bd.C0258a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements C0693p {
    static final C0687c f2182a;
    private static final int[] f2183b = new int[]{16842931};
    private static final boolean f2184c = (VERSION.SDK_INT >= 19);
    private static final boolean f2185d;
    private float f2186A;
    private Drawable f2187B;
    private Drawable f2188C;
    private Drawable f2189D;
    private CharSequence f2190E;
    private CharSequence f2191F;
    private Object f2192G;
    private boolean f2193H;
    private Drawable f2194I;
    private Drawable f2195J;
    private Drawable f2196K;
    private Drawable f2197L;
    private final ArrayList<View> f2198M;
    private final C0686b f2199e;
    private float f2200f;
    private int f2201g;
    private int f2202h;
    private float f2203i;
    private Paint f2204j;
    private final bd f2205k;
    private final bd f2206l;
    private final C0692h f2207m;
    private final C0692h f2208n;
    private int f2209o;
    private boolean f2210p;
    private boolean f2211q;
    private int f2212r;
    private int f2213s;
    private int f2214t;
    private int f2215u;
    private boolean f2216v;
    private boolean f2217w;
    private C0690f f2218x;
    private List<C0690f> f2219y;
    private float f2220z;

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = C0468d.m3057a(new C0736m());
        int f2166b = 0;
        int f2167c;
        int f2168d;
        int f2169e;
        int f2170f;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2166b = parcel.readInt();
            this.f2167c = parcel.readInt();
            this.f2168d = parcel.readInt();
            this.f2169e = parcel.readInt();
            this.f2170f = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2166b);
            parcel.writeInt(this.f2167c);
            parcel.writeInt(this.f2168d);
            parcel.writeInt(this.f2169e);
            parcel.writeInt(this.f2170f);
        }
    }

    class C0685a extends C0249b {
        final /* synthetic */ DrawerLayout f2171a;
        private final Rect f2172c = new Rect();

        C0685a(DrawerLayout drawerLayout) {
            this.f2171a = drawerLayout;
        }

        public void mo219a(View view, C0547e c0547e) {
            if (DrawerLayout.f2184c) {
                super.mo219a(view, c0547e);
            } else {
                C0547e a = C0547e.m3427a(c0547e);
                super.mo219a(view, a);
                c0547e.m3441b(view);
                ViewParent i = ao.m3939i(view);
                if (i instanceof View) {
                    c0547e.m3454d((View) i);
                }
                m4411a(c0547e, a);
                a.m3481u();
                m4412a(c0547e, (ViewGroup) view);
            }
            c0547e.m3443b(DrawerLayout.class.getName());
            c0547e.m3438a(false);
            c0547e.m3445b(false);
            c0547e.m3439a(C0534a.f2055a);
            c0547e.m3439a(C0534a.f2056b);
        }

        public void mo220a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo220a(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public boolean mo667d(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.mo667d(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = this.f2171a.m4471k();
            if (a != null) {
                CharSequence b = this.f2171a.m4487b(this.f2171a.m4499e(a));
                if (b != null) {
                    text.add(b);
                }
            }
            return true;
        }

        public boolean mo666a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f2184c || DrawerLayout.m4474n(view)) {
                return super.mo666a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void m4412a(C0547e c0547e, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m4474n(childAt)) {
                    c0547e.m3448c(childAt);
                }
            }
        }

        private void m4411a(C0547e c0547e, C0547e c0547e2) {
            Rect rect = this.f2172c;
            c0547e2.m3435a(rect);
            c0547e.m3440b(rect);
            c0547e2.m3447c(rect);
            c0547e.m3453d(rect);
            c0547e.m3451c(c0547e2.m3468i());
            c0547e.m3437a(c0547e2.m3477q());
            c0547e.m3443b(c0547e2.m3478r());
            c0547e.m3455d(c0547e2.m3480t());
            c0547e.m3465h(c0547e2.m3474n());
            c0547e.m3461f(c0547e2.m3472l());
            c0547e.m3438a(c0547e2.m3464g());
            c0547e.m3445b(c0547e2.m3466h());
            c0547e.m3456d(c0547e2.m3470j());
            c0547e.m3459e(c0547e2.m3471k());
            c0547e.m3463g(c0547e2.m3473m());
            c0547e.m3434a(c0547e2.m3452d());
        }
    }

    final class C0686b extends C0249b {
        final /* synthetic */ DrawerLayout f2173a;

        C0686b(DrawerLayout drawerLayout) {
            this.f2173a = drawerLayout;
        }

        public void mo219a(View view, C0547e c0547e) {
            super.mo219a(view, c0547e);
            if (!DrawerLayout.m4474n(view)) {
                c0547e.m3454d(null);
            }
        }
    }

    interface C0687c {
        int mo668a(Object obj);

        Drawable mo669a(Context context);

        void mo670a(View view);

        void mo671a(View view, Object obj, int i);

        void mo672a(MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    static class C0688d implements C0687c {
        C0688d() {
        }

        public void mo670a(View view) {
            C0739o.m4875a(view);
        }

        public void mo671a(View view, Object obj, int i) {
            C0739o.m4876a(view, obj, i);
        }

        public void mo672a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            C0739o.m4877a(marginLayoutParams, obj, i);
        }

        public int mo668a(Object obj) {
            return C0739o.m4873a(obj);
        }

        public Drawable mo669a(Context context) {
            return C0739o.m4874a(context);
        }
    }

    static class C0689e implements C0687c {
        C0689e() {
        }

        public void mo670a(View view) {
        }

        public void mo671a(View view, Object obj, int i) {
        }

        public void mo672a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public int mo668a(Object obj) {
            return 0;
        }

        public Drawable mo669a(Context context) {
            return null;
        }
    }

    public interface C0690f {
        void mo783a(int i);

        void mo784a(View view);

        void mo785a(View view, float f);

        void mo786b(View view);
    }

    public static class C0691g extends MarginLayoutParams {
        public int f2174a = 0;
        private float f2175b;
        private boolean f2176c;
        private int f2177d;

        public C0691g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2183b);
            this.f2174a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public C0691g(int i, int i2) {
            super(i, i2);
        }

        public C0691g(C0691g c0691g) {
            super(c0691g);
            this.f2174a = c0691g.f2174a;
        }

        public C0691g(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0691g(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    private class C0692h extends C0258a {
        final /* synthetic */ DrawerLayout f2178a;
        private final int f2179b;
        private bd f2180c;
        private final Runnable f2181d = new C0737n(this);

        public C0692h(DrawerLayout drawerLayout, int i) {
            this.f2178a = drawerLayout;
            this.f2179b = i;
        }

        public void m4450a(bd bdVar) {
            this.f2180c = bdVar;
        }

        public void m4447a() {
            this.f2178a.removeCallbacks(this.f2181d);
        }

        public boolean mo241a(View view, int i) {
            return this.f2178a.m4504g(view) && this.f2178a.m4486a(view, this.f2179b) && this.f2178a.m4476a(view) == 0;
        }

        public void mo238a(int i) {
            this.f2178a.m4479a(this.f2179b, i, this.f2180c.m4840c());
        }

        public void mo240a(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (this.f2178a.m4486a(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.f2178a.getWidth() - i)) / ((float) width);
            }
            this.f2178a.m4492b(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.f2178a.invalidate();
        }

        public void mo244b(View view, int i) {
            ((C0691g) view.getLayoutParams()).f2176c = false;
            m4444b();
        }

        private void m4444b() {
            int i = 3;
            if (this.f2179b == 3) {
                i = 5;
            }
            View c = this.f2178a.m4494c(i);
            if (c != null) {
                this.f2178a.m4507i(c);
            }
        }

        public void mo239a(View view, float f, float f2) {
            int i;
            float d = this.f2178a.m4498d(view);
            int width = view.getWidth();
            if (this.f2178a.m4486a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
            } else {
                i = this.f2178a.getWidth();
                if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                    i -= width;
                }
            }
            this.f2180c.m4830a(i, view.getTop());
            this.f2178a.invalidate();
        }

        public void mo673a(int i, int i2) {
            this.f2178a.postDelayed(this.f2181d, 160);
        }

        private void m4445c() {
            View view;
            int i;
            int i2 = 0;
            int b = this.f2180c.m4834b();
            boolean z = this.f2179b == 3;
            if (z) {
                View c = this.f2178a.m4494c(3);
                if (c != null) {
                    i2 = -c.getWidth();
                }
                i2 += b;
                view = c;
                i = i2;
            } else {
                i2 = this.f2178a.getWidth() - b;
                view = this.f2178a.m4494c(5);
                i = i2;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f2178a.m4476a(view) == 0) {
                C0691g c0691g = (C0691g) view.getLayoutParams();
                this.f2180c.m4832a(view, i, view.getTop());
                c0691g.f2176c = true;
                this.f2178a.invalidate();
                m4444b();
                this.f2178a.m4495c();
            }
        }

        public boolean mo675b(int i) {
            return false;
        }

        public void mo674b(int i, int i2) {
            View c;
            if ((i & 1) == 1) {
                c = this.f2178a.m4494c(3);
            } else {
                c = this.f2178a.m4494c(5);
            }
            if (c != null && this.f2178a.m4476a(c) == 0) {
                this.f2180c.m4829a(c, i2);
            }
        }

        public int mo242b(View view) {
            return this.f2178a.m4504g(view) ? view.getWidth() : 0;
        }

        public int mo243b(View view, int i, int i2) {
            if (this.f2178a.m4486a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f2178a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int mo237a(View view, int i, int i2) {
            return view.getTop();
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        f2185d = z;
        if (VERSION.SDK_INT >= 21) {
            f2182a = new C0688d();
        } else {
            f2182a = new C0689e();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2199e = new C0686b(this);
        this.f2202h = -1728053248;
        this.f2204j = new Paint();
        this.f2211q = true;
        this.f2212r = 3;
        this.f2213s = 3;
        this.f2214t = 3;
        this.f2215u = 3;
        this.f2194I = null;
        this.f2195J = null;
        this.f2196K = null;
        this.f2197L = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f2201g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f2207m = new C0692h(this, 3);
        this.f2208n = new C0692h(this, 5);
        this.f2205k = bd.m4808a((ViewGroup) this, 1.0f, this.f2207m);
        this.f2205k.m4828a(1);
        this.f2205k.m4827a(f2);
        this.f2207m.m4450a(this.f2205k);
        this.f2206l = bd.m4808a((ViewGroup) this, 1.0f, this.f2208n);
        this.f2206l.m4828a(2);
        this.f2206l.m4827a(f2);
        this.f2208n.m4450a(this.f2206l);
        setFocusableInTouchMode(true);
        ao.m3925c((View) this, 1);
        ao.m3911a((View) this, new C0685a(this));
        be.m4093a(this, false);
        if (ao.m3955y(this)) {
            f2182a.mo670a((View) this);
            this.f2187B = f2182a.mo669a(context);
        }
        this.f2200f = f * 10.0f;
        this.f2198M = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.f2200f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m4504g(childAt)) {
                ao.m3935f(childAt, this.f2200f);
            }
        }
    }

    public float getDrawerElevation() {
        if (f2185d) {
            return this.f2200f;
        }
        return 0.0f;
    }

    public void mo676a(Object obj, boolean z) {
        this.f2192G = obj;
        this.f2193H = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.f2202h = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(C0690f c0690f) {
        if (this.f2218x != null) {
            m4490b(this.f2218x);
        }
        if (c0690f != null) {
            m4481a(c0690f);
        }
        this.f2218x = c0690f;
    }

    public void m4481a(C0690f c0690f) {
        if (c0690f != null) {
            if (this.f2219y == null) {
                this.f2219y = new ArrayList();
            }
            this.f2219y.add(c0690f);
        }
    }

    public void m4490b(C0690f c0690f) {
        if (c0690f != null && this.f2219y != null) {
            this.f2219y.remove(c0690f);
        }
    }

    public void setDrawerLockMode(int i) {
        m4478a(i, 3);
        m4478a(i, 5);
    }

    public void m4478a(int i, int i2) {
        int a = C0645j.m4290a(i2, ao.m3938h(this));
        switch (i2) {
            case 3:
                this.f2212r = i;
                break;
            case 5:
                this.f2213s = i;
                break;
            case 8388611:
                this.f2214t = i;
                break;
            case 8388613:
                this.f2215u = i;
                break;
        }
        if (i != 0) {
            (a == 3 ? this.f2205k : this.f2206l).m4846e();
        }
        View c;
        switch (i) {
            case 1:
                c = m4494c(a);
                if (c != null) {
                    m4507i(c);
                    return;
                }
                return;
            case 2:
                c = m4494c(a);
                if (c != null) {
                    m4505h(c);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int m4475a(int i) {
        int h = ao.m3938h(this);
        switch (i) {
            case 3:
                if (this.f2212r != 3) {
                    return this.f2212r;
                }
                h = h == 0 ? this.f2214t : this.f2215u;
                if (h != 3) {
                    return h;
                }
                break;
            case 5:
                if (this.f2213s != 3) {
                    return this.f2213s;
                }
                h = h == 0 ? this.f2215u : this.f2214t;
                if (h != 3) {
                    return h;
                }
                break;
            case 8388611:
                if (this.f2214t != 3) {
                    return this.f2214t;
                }
                h = h == 0 ? this.f2212r : this.f2213s;
                if (h != 3) {
                    return h;
                }
                break;
            case 8388613:
                if (this.f2215u != 3) {
                    return this.f2215u;
                }
                h = h == 0 ? this.f2213s : this.f2212r;
                if (h != 3) {
                    return h;
                }
                break;
        }
        return 0;
    }

    public int m4476a(View view) {
        if (m4504g(view)) {
            return m4475a(((C0691g) view.getLayoutParams()).f2174a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence m4487b(int i) {
        int a = C0645j.m4290a(i, ao.m3938h(this));
        if (a == 3) {
            return this.f2190E;
        }
        if (a == 5) {
            return this.f2191F;
        }
        return null;
    }

    void m4479a(int i, int i2, View view) {
        int a = this.f2205k.m4826a();
        int a2 = this.f2206l.m4826a();
        if (a == 1 || a2 == 1) {
            a = 1;
        } else if (a == 2 || a2 == 2) {
            a = 2;
        } else {
            a = 0;
        }
        if (view != null && i2 == 0) {
            C0691g c0691g = (C0691g) view.getLayoutParams();
            if (c0691g.f2175b == 0.0f) {
                m4491b(view);
            } else if (c0691g.f2175b == 1.0f) {
                m4496c(view);
            }
        }
        if (a != this.f2209o) {
            this.f2209o = a;
            if (this.f2219y != null) {
                for (int size = this.f2219y.size() - 1; size >= 0; size--) {
                    ((C0690f) this.f2219y.get(size)).mo783a(a);
                }
            }
        }
    }

    void m4491b(View view) {
        C0691g c0691g = (C0691g) view.getLayoutParams();
        if ((c0691g.f2177d & 1) == 1) {
            c0691g.f2177d = 0;
            if (this.f2219y != null) {
                for (int size = this.f2219y.size() - 1; size >= 0; size--) {
                    ((C0690f) this.f2219y.get(size)).mo786b(view);
                }
            }
            m4462c(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void m4496c(View view) {
        C0691g c0691g = (C0691g) view.getLayoutParams();
        if ((c0691g.f2177d & 1) == 0) {
            c0691g.f2177d = 1;
            if (this.f2219y != null) {
                for (int size = this.f2219y.size() - 1; size >= 0; size--) {
                    ((C0690f) this.f2219y.get(size)).mo784a(view);
                }
            }
            m4462c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    private void m4462c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m4504g(childAt)) && !(z && childAt == view)) {
                ao.m3925c(childAt, 4);
            } else {
                ao.m3925c(childAt, 1);
            }
        }
    }

    void m4482a(View view, float f) {
        if (this.f2219y != null) {
            for (int size = this.f2219y.size() - 1; size >= 0; size--) {
                ((C0690f) this.f2219y.get(size)).mo785a(view, f);
            }
        }
    }

    void m4492b(View view, float f) {
        C0691g c0691g = (C0691g) view.getLayoutParams();
        if (f != c0691g.f2175b) {
            c0691g.f2175b = f;
            m4482a(view, f);
        }
    }

    float m4498d(View view) {
        return ((C0691g) view.getLayoutParams()).f2175b;
    }

    int m4499e(View view) {
        return C0645j.m4290a(((C0691g) view.getLayoutParams()).f2174a, ao.m3938h(this));
    }

    boolean m4486a(View view, int i) {
        return (m4499e(view) & i) == i;
    }

    View m4477a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((C0691g) childAt.getLayoutParams()).f2177d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void m4497c(View view, float f) {
        float d = m4498d(view);
        int width = view.getWidth();
        int i = ((int) (((float) width) * f)) - ((int) (d * ((float) width)));
        if (!m4486a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        m4492b(view, f);
    }

    View m4494c(int i) {
        int a = C0645j.m4290a(i, ao.m3938h(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m4499e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    static String m4463d(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2211q = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2211q = true;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int h;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int a;
        int e;
        Object obj4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    mode = size;
                    size = size2;
                } else if (mode2 == 0) {
                    mode = size;
                    size = 300;
                }
                setMeasuredDimension(mode, size);
                if (this.f2192G == null && ao.m3955y(this)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                h = ao.m3938h(this);
                obj2 = null;
                obj3 = null;
                childCount = getChildCount();
                for (i3 = 0; i3 < childCount; i3++) {
                    childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 8) {
                        marginLayoutParams = (C0691g) childAt.getLayoutParams();
                        if (obj != null) {
                            a = C0645j.m4290a(marginLayoutParams.f2174a, h);
                            if (ao.m3955y(childAt)) {
                                f2182a.mo672a(marginLayoutParams, this.f2192G, a);
                            } else {
                                f2182a.mo671a(childAt, this.f2192G, a);
                            }
                        }
                        if (m4502f(childAt)) {
                            childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                        } else if (m4504g(childAt)) {
                            throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                        } else {
                            if (f2185d && ao.m3952v(childAt) != this.f2200f) {
                                ao.m3935f(childAt, this.f2200f);
                            }
                            e = m4499e(childAt) & 7;
                            obj4 = e != 3 ? 1 : null;
                            if ((obj4 != null || r5 == null) && (obj4 != null || r4 == null)) {
                                if (obj4 == null) {
                                    obj2 = 1;
                                } else {
                                    obj3 = 1;
                                }
                                childAt.measure(getChildMeasureSpec(i, (this.f2201g + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                            } else {
                                throw new IllegalStateException("Child drawer has absolute gravity " + m4463d(e) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size;
        size = size2;
        setMeasuredDimension(mode, size);
        if (this.f2192G == null) {
        }
        obj = null;
        h = ao.m3938h(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                marginLayoutParams = (C0691g) childAt.getLayoutParams();
                if (obj != null) {
                    a = C0645j.m4290a(marginLayoutParams.f2174a, h);
                    if (ao.m3955y(childAt)) {
                        f2182a.mo672a(marginLayoutParams, this.f2192G, a);
                    } else {
                        f2182a.mo671a(childAt, this.f2192G, a);
                    }
                }
                if (m4502f(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                } else if (m4504g(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    ao.m3935f(childAt, this.f2200f);
                    e = m4499e(childAt) & 7;
                    if (e != 3) {
                    }
                    if (obj4 != null) {
                    }
                    if (obj4 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.f2201g + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                }
            }
        }
    }

    private void m4466f() {
        if (!f2185d) {
            this.f2188C = m4467g();
            this.f2189D = m4468h();
        }
    }

    private Drawable m4467g() {
        int h = ao.m3938h(this);
        if (h == 0) {
            if (this.f2194I != null) {
                m4461a(this.f2194I, h);
                return this.f2194I;
            }
        } else if (this.f2195J != null) {
            m4461a(this.f2195J, h);
            return this.f2195J;
        }
        return this.f2196K;
    }

    private Drawable m4468h() {
        int h = ao.m3938h(this);
        if (h == 0) {
            if (this.f2195J != null) {
                m4461a(this.f2195J, h);
                return this.f2195J;
            }
        } else if (this.f2194I != null) {
            m4461a(this.f2194I, h);
            return this.f2194I;
        }
        return this.f2197L;
    }

    private boolean m4461a(Drawable drawable, int i) {
        if (drawable == null || !C0441a.m2997b(drawable)) {
            return false;
        }
        C0441a.m2998b(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2210p = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0691g c0691g = (C0691g) childAt.getLayoutParams();
                if (m4502f(childAt)) {
                    childAt.layout(c0691g.leftMargin, c0691g.topMargin, c0691g.leftMargin + childAt.getMeasuredWidth(), c0691g.topMargin + childAt.getMeasuredHeight());
                } else {
                    int a;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m4486a(childAt, 3)) {
                        a = ((int) (((float) measuredWidth) * c0691g.f2175b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * c0691g.f2175b));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    Object obj = f != c0691g.f2175b ? 1 : null;
                    int i7;
                    switch (c0691g.f2174a & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            i7 = (i8 - measuredHeight) / 2;
                            if (i7 < c0691g.topMargin) {
                                i7 = c0691g.topMargin;
                            } else if (i7 + measuredHeight > i8 - c0691g.bottomMargin) {
                                i7 = (i8 - c0691g.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i7, measuredWidth + a, measuredHeight + i7);
                            break;
                        case 80:
                            i7 = i4 - i2;
                            childAt.layout(a, (i7 - c0691g.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i7 - c0691g.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, c0691g.topMargin, measuredWidth + a, measuredHeight + c0691g.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m4492b(childAt, f);
                    }
                    int i9 = c0691g.f2175b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i9) {
                        childAt.setVisibility(i9);
                    }
                }
            }
        }
        this.f2210p = false;
        this.f2211q = false;
    }

    public void requestLayout() {
        if (!this.f2210p) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0691g) getChildAt(i).getLayoutParams()).f2175b);
        }
        this.f2203i = f;
        if ((this.f2205k.m4833a(true) | this.f2206l.m4833a(true)) != 0) {
            ao.m3928d(this);
        }
    }

    private static boolean m4473m(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f2187B = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2187B;
    }

    public void setStatusBarBackground(int i) {
        this.f2187B = i != 0 ? C0307a.m2325a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f2187B = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        m4466f();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2193H && this.f2187B != null) {
            int a = f2182a.mo668a(this.f2192G);
            if (a > 0) {
                this.f2187B.setBounds(0, 0, getWidth(), a);
                this.f2187B.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m4502f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m4473m(childAt) && m4504g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m4486a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f2203i > 0.0f && f) {
            this.f2204j.setColor((((int) (((float) ((this.f2202h & -16777216) >>> 24)) * this.f2203i)) << 24) | (this.f2202h & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f2204j);
        } else if (this.f2188C != null && m4486a(view, 3)) {
            i = this.f2188C.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f2205k.m4834b()), 1.0f));
            this.f2188C.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f2188C.setAlpha((int) (255.0f * r2));
            this.f2188C.draw(canvas);
        } else if (this.f2189D != null && m4486a(view, 5)) {
            i = this.f2189D.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f2206l.m4834b()), 1.0f));
            this.f2189D.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f2189D.setAlpha((int) (255.0f * r2));
            this.f2189D.draw(canvas);
        }
        return drawChild;
    }

    boolean m4502f(View view) {
        return ((C0691g) view.getLayoutParams()).f2174a == 0;
    }

    boolean m4504g(View view) {
        int a = C0645j.m4290a(((C0691g) view.getLayoutParams()).f2174a, ao.m3938h(view));
        if ((a & 3) != 0) {
            return true;
        }
        if ((a & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.C0684z.m4397a(r8);
        r3 = r7.f2205k;
        r3 = r3.m4831a(r8);
        r4 = r7.f2206l;
        r4 = r4.m4831a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m4469i();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f2217w;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f2220z = r0;
        r7.f2186A = r4;
        r5 = r7.f2203i;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.f2205k;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m4844d(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.m4502f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.f2216v = r2;
        r7.f2217w = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.f2205k;
        r4 = 3;
        r0 = r0.m4845d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.f2207m;
        r0.m4447a();
        r0 = r7.f2208n;
        r0.m4447a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.m4485a(r1);
        r7.f2216v = r2;
        r7.f2217w = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f2205k.m4835b(motionEvent);
        this.f2206l.m4835b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f2220z = x;
                this.f2186A = y;
                this.f2216v = false;
                this.f2217w = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f2205k.m4844d((int) x, (int) y);
                if (d != null && m4502f(d)) {
                    x -= this.f2220z;
                    y -= this.f2186A;
                    int d2 = this.f2205k.m4843d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m4477a();
                        if (a != null) {
                            z = m4476a(a) == 2;
                            m4485a(z);
                            this.f2216v = false;
                            break;
                        }
                    }
                }
                z = true;
                m4485a(z);
                this.f2216v = false;
            case 3:
                m4485a(true);
                this.f2216v = false;
                this.f2217w = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f2216v = z;
        if (z) {
            m4485a(true);
        }
    }

    public void m4488b() {
        m4485a(false);
    }

    void m4485a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0691g c0691g = (C0691g) childAt.getLayoutParams();
            if (m4504g(childAt) && (!z || c0691g.f2176c)) {
                int width = childAt.getWidth();
                if (m4486a(childAt, 3)) {
                    i |= this.f2205k.m4832a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f2206l.m4832a(childAt, getWidth(), childAt.getTop());
                }
                c0691g.f2176c = false;
            }
        }
        this.f2207m.m4447a();
        this.f2208n.m4447a();
        if (i != 0) {
            invalidate();
        }
    }

    public void m4505h(View view) {
        m4483a(view, true);
    }

    public void m4483a(View view, boolean z) {
        if (m4504g(view)) {
            C0691g c0691g = (C0691g) view.getLayoutParams();
            if (this.f2211q) {
                c0691g.f2175b = 1.0f;
                c0691g.f2177d = 1;
                m4462c(view, true);
            } else if (z) {
                c0691g.f2177d = c0691g.f2177d | 2;
                if (m4486a(view, 3)) {
                    this.f2205k.m4832a(view, 0, view.getTop());
                } else {
                    this.f2206l.m4832a(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                m4497c(view, 1.0f);
                m4479a(c0691g.f2174a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m4500e(int i) {
        m4480a(i, true);
    }

    public void m4480a(int i, boolean z) {
        View c = m4494c(i);
        if (c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m4463d(i));
        }
        m4483a(c, z);
    }

    public void m4507i(View view) {
        m4493b(view, true);
    }

    public void m4493b(View view, boolean z) {
        if (m4504g(view)) {
            C0691g c0691g = (C0691g) view.getLayoutParams();
            if (this.f2211q) {
                c0691g.f2175b = 0.0f;
                c0691g.f2177d = 0;
            } else if (z) {
                c0691g.f2177d = c0691g.f2177d | 4;
                if (m4486a(view, 3)) {
                    this.f2205k.m4832a(view, -view.getWidth(), view.getTop());
                } else {
                    this.f2206l.m4832a(view, getWidth(), view.getTop());
                }
            } else {
                m4497c(view, 0.0f);
                m4479a(c0691g.f2174a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m4501f(int i) {
        m4489b(i, true);
    }

    public void m4489b(int i, boolean z) {
        View c = m4494c(i);
        if (c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m4463d(i));
        }
        m4493b(c, z);
    }

    public boolean m4508j(View view) {
        if (m4504g(view)) {
            return (((C0691g) view.getLayoutParams()).f2177d & 1) == 1;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean m4503g(int i) {
        View c = m4494c(i);
        if (c != null) {
            return m4508j(c);
        }
        return false;
    }

    public boolean m4509k(View view) {
        if (m4504g(view)) {
            return ((C0691g) view.getLayoutParams()).f2175b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean m4506h(int i) {
        View c = m4494c(i);
        if (c != null) {
            return m4509k(c);
        }
        return false;
    }

    private boolean m4469i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0691g) getChildAt(i).getLayoutParams()).f2176c) {
                return true;
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0691g(-1, -1);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof C0691g) {
            return new C0691g((C0691g) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new C0691g((MarginLayoutParams) layoutParams) : new C0691g(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0691g) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0691g(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int i3 = 0;
        if (getDescendantFocusability() != 393216) {
            int i4;
            int childCount = getChildCount();
            int i5 = 0;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!m4504g(childAt)) {
                    this.f2198M.add(childAt);
                } else if (m4508j(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.f2198M.size();
                while (i3 < i4) {
                    View view = (View) this.f2198M.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.f2198M.clear();
        }
    }

    private boolean m4470j() {
        return m4471k() != null;
    }

    private View m4471k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m4504g(childAt) && m4509k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void m4495c() {
        int i = 0;
        if (!this.f2217w) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.f2217w = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m4470j()) {
            return super.onKeyDown(i, keyEvent);
        }
        C0651l.m4311b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View k = m4471k();
        if (k != null && m4476a(k) == 0) {
            m4488b();
        }
        return k != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.m3182a());
            if (savedState.f2166b != 0) {
                View c = m4494c(savedState.f2166b);
                if (c != null) {
                    m4505h(c);
                }
            }
            if (savedState.f2167c != 3) {
                m4478a(savedState.f2167c, 3);
            }
            if (savedState.f2168d != 3) {
                m4478a(savedState.f2168d, 5);
            }
            if (savedState.f2169e != 3) {
                m4478a(savedState.f2169e, 8388611);
            }
            if (savedState.f2170f != 3) {
                m4478a(savedState.f2170f, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0691g c0691g = (C0691g) getChildAt(i).getLayoutParams();
            Object obj = c0691g.f2177d == 1 ? 1 : null;
            Object obj2;
            if (c0691g.f2177d == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || r4 != null) {
                savedState.f2166b = c0691g.f2174a;
                break;
            }
        }
        savedState.f2167c = this.f2212r;
        savedState.f2168d = this.f2213s;
        savedState.f2169e = this.f2214t;
        savedState.f2170f = this.f2215u;
        return savedState;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m4477a() != null || m4504g(view)) {
            ao.m3925c(view, 4);
        } else {
            ao.m3925c(view, 1);
        }
        if (!f2184c) {
            ao.m3911a(view, this.f2199e);
        }
    }

    private static boolean m4474n(View view) {
        return (ao.m3931e(view) == 4 || ao.m3931e(view) == 2) ? false : true;
    }
}
