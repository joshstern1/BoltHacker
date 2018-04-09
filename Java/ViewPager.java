package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p017e.C0468d;
import android.support.v4.view.p025a.C0527a;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0572s;
import android.support.v4.widget.C0744q;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;

public class ViewPager extends ViewGroup {
    private static final int[] f2004a = new int[]{16842931};
    private static final C0522i aj = new C0522i();
    private static final Comparator<C0516b> f2005c = new bg();
    private static final Interpolator f2006d = new bh();
    private int f2007A = 1;
    private boolean f2008B;
    private boolean f2009C;
    private int f2010D;
    private int f2011E;
    private int f2012F;
    private float f2013G;
    private float f2014H;
    private float f2015I;
    private float f2016J;
    private int f2017K = -1;
    private VelocityTracker f2018L;
    private int f2019M;
    private int f2020N;
    private int f2021O;
    private int f2022P;
    private boolean f2023Q;
    private long f2024R;
    private C0744q f2025S;
    private C0744q f2026T;
    private boolean f2027U = true;
    private boolean f2028V = false;
    private boolean f2029W;
    private int aa;
    private List<C0245f> ab;
    private C0245f ac;
    private C0245f ad;
    private List<C0519e> ae;
    private C0520g af;
    private Method ag;
    private int ah;
    private ArrayList<View> ai;
    private final Runnable ak = new bi(this);
    private int al = 0;
    private int f2030b;
    private final ArrayList<C0516b> f2031e = new ArrayList();
    private final C0516b f2032f = new C0516b();
    private final Rect f2033g = new Rect();
    private aj f2034h;
    private int f2035i;
    private int f2036j = -1;
    private Parcelable f2037k = null;
    private ClassLoader f2038l = null;
    private Scroller f2039m;
    private boolean f2040n;
    private C0521h f2041o;
    private int f2042p;
    private Drawable f2043q;
    private int f2044r;
    private int f2045s;
    private float f2046t = -3.4028235E38f;
    private float f2047u = Float.MAX_VALUE;
    private int f2048v;
    private int f2049w;
    private boolean f2050x;
    private boolean f2051y;
    private boolean f2052z;

    public interface C0245f {
        void mo213a(int i);

        void mo214a(int i, float f, int i2);

        void mo215b(int i);
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = C0468d.m3057a(new bk());
        int f1988b;
        Parcelable f1989c;
        ClassLoader f1990d;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1988b);
            parcel.writeParcelable(this.f1989c, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1988b + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f1988b = parcel.readInt();
            this.f1989c = parcel.readParcelable(classLoader);
            this.f1990d = classLoader;
        }
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface C0515a {
    }

    static class C0516b {
        Object f1991a;
        int f1992b;
        boolean f1993c;
        float f1994d;
        float f1995e;

        C0516b() {
        }
    }

    public static class C0517c extends LayoutParams {
        public boolean f1996a;
        public int f1997b;
        float f1998c = 0.0f;
        boolean f1999d;
        int f2000e;
        int f2001f;

        public C0517c() {
            super(-1, -1);
        }

        public C0517c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f2004a);
            this.f1997b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class C0518d extends C0249b {
        final /* synthetic */ ViewPager f2002a;

        C0518d(ViewPager viewPager) {
            this.f2002a = viewPager;
        }

        public void mo220a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo220a(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            C0572s a = C0527a.m3246a(accessibilityEvent);
            a.m3621d(m3183b());
            if (accessibilityEvent.getEventType() == 4096 && this.f2002a.f2034h != null) {
                a.m3611a(this.f2002a.f2034h.mo1273b());
                a.m3615b(this.f2002a.f2035i);
                a.m3618c(this.f2002a.f2035i);
            }
        }

        public void mo219a(View view, C0547e c0547e) {
            super.mo219a(view, c0547e);
            c0547e.m3443b(ViewPager.class.getName());
            c0547e.m3467i(m3183b());
            if (this.f2002a.canScrollHorizontally(1)) {
                c0547e.m3434a(4096);
            }
            if (this.f2002a.canScrollHorizontally(-1)) {
                c0547e.m3434a((int) DfuBaseService.ERROR_REMOTE_MASK);
            }
        }

        public boolean mo431a(View view, int i, Bundle bundle) {
            if (super.mo431a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.f2002a.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f2002a.setCurrentItem(this.f2002a.f2035i + 1);
                    return true;
                case DfuBaseService.ERROR_REMOTE_MASK /*8192*/:
                    if (!this.f2002a.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.f2002a.setCurrentItem(this.f2002a.f2035i - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean m3183b() {
            return this.f2002a.f2034h != null && this.f2002a.f2034h.mo1273b() > 1;
        }
    }

    public interface C0519e {
        void m3187a(ViewPager viewPager, aj ajVar, aj ajVar2);
    }

    public interface C0520g {
        void m3188a(View view, float f);
    }

    private class C0521h extends DataSetObserver {
        final /* synthetic */ ViewPager f2003a;

        private C0521h(ViewPager viewPager) {
            this.f2003a = viewPager;
        }

        public void onChanged() {
            this.f2003a.m3230b();
        }

        public void onInvalidated() {
            this.f2003a.m3230b();
        }
    }

    static class C0522i implements Comparator<View> {
        C0522i() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3189a((View) obj, (View) obj2);
        }

        public int m3189a(View view, View view2) {
            C0517c c0517c = (C0517c) view.getLayoutParams();
            C0517c c0517c2 = (C0517c) view2.getLayoutParams();
            if (c0517c.f1996a != c0517c2.f1996a) {
                return c0517c.f1996a ? 1 : -1;
            } else {
                return c0517c.f2000e - c0517c2.f2000e;
            }
        }
    }

    public ViewPager(Context context) {
        super(context);
        m3218a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3218a();
    }

    void m3218a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f2039m = new Scroller(context, f2006d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f2012F = bb.m4086a(viewConfiguration);
        this.f2019M = (int) (400.0f * f);
        this.f2020N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2025S = new C0744q(context);
        this.f2026T = new C0744q(context);
        this.f2021O = (int) (25.0f * f);
        this.f2022P = (int) (2.0f * f);
        this.f2010D = (int) (16.0f * f);
        ao.m3911a((View) this, new C0518d(this));
        if (ao.m3931e(this) == 0) {
            ao.m3925c((View) this, 1);
        }
        ao.m3910a((View) this, new bj(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ak);
        if (!(this.f2039m == null || this.f2039m.isFinished())) {
            this.f2039m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.al != i) {
            this.al = i;
            if (this.af != null) {
                m3202b(i != 0);
            }
            m3208f(i);
        }
    }

    public void setAdapter(aj ajVar) {
        int i = false;
        if (this.f2034h != null) {
            this.f2034h.m2359c(null);
            this.f2034h.mo302a((ViewGroup) this);
            for (int i2 = 0; i2 < this.f2031e.size(); i2++) {
                C0516b c0516b = (C0516b) this.f2031e.get(i2);
                this.f2034h.mo303a((ViewGroup) this, c0516b.f1992b, c0516b.f1991a);
            }
            this.f2034h.mo305b((ViewGroup) this);
            this.f2031e.clear();
            m3210j();
            this.f2035i = 0;
            scrollTo(0, 0);
        }
        aj ajVar2 = this.f2034h;
        this.f2034h = ajVar;
        this.f2030b = 0;
        if (this.f2034h != null) {
            if (this.f2041o == null) {
                this.f2041o = new C0521h();
            }
            this.f2034h.m2359c(this.f2041o);
            this.f2052z = false;
            boolean z = this.f2027U;
            this.f2027U = true;
            this.f2030b = this.f2034h.mo1273b();
            if (this.f2036j >= 0) {
                this.f2034h.mo301a(this.f2037k, this.f2038l);
                m3223a(this.f2036j, false, true);
                this.f2036j = -1;
                this.f2037k = null;
                this.f2038l = null;
            } else if (z) {
                requestLayout();
            } else {
                m3233c();
            }
        }
        if (this.ae != null && !this.ae.isEmpty()) {
            int size = this.ae.size();
            while (i < size) {
                ((C0519e) this.ae.get(i)).m3187a(this, ajVar2, ajVar);
                i++;
            }
        }
    }

    private void m3210j() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0517c) getChildAt(i).getLayoutParams()).f1996a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public aj getAdapter() {
        return this.f2034h;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f2052z = false;
        if (this.f2027U) {
            z = false;
        } else {
            z = true;
        }
        m3223a(i, z, false);
    }

    public void m3222a(int i, boolean z) {
        this.f2052z = false;
        m3223a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f2035i;
    }

    void m3223a(int i, boolean z, boolean z2) {
        m3224a(i, z, z2, 0);
    }

    void m3224a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f2034h == null || this.f2034h.mo1273b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f2035i != i || this.f2031e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f2034h.mo1273b()) {
                i = this.f2034h.mo1273b() - 1;
            }
            int i3 = this.f2007A;
            if (i > this.f2035i + i3 || i < this.f2035i - i3) {
                for (int i4 = 0; i4 < this.f2031e.size(); i4++) {
                    ((C0516b) this.f2031e.get(i4)).f1993c = true;
                }
            }
            if (this.f2035i != i) {
                z3 = true;
            }
            if (this.f2027U) {
                this.f2035i = i;
                if (z3) {
                    m3207e(i);
                }
                requestLayout();
                return;
            }
            m3219a(i);
            m3194a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m3194a(int i, boolean z, int i2, boolean z2) {
        int max;
        C0516b b = m3228b(i);
        if (b != null) {
            max = (int) (Math.max(this.f2046t, Math.min(b.f1995e, this.f2047u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m3221a(max, 0, i2);
            if (z2) {
                m3207e(i);
                return;
            }
            return;
        }
        if (z2) {
            m3207e(i);
        }
        m3198a(false);
        scrollTo(max, 0);
        m3206d(max);
    }

    @Deprecated
    public void setOnPageChangeListener(C0245f c0245f) {
        this.ac = c0245f;
    }

    public void m3225a(C0245f c0245f) {
        if (this.ab == null) {
            this.ab = new ArrayList();
        }
        this.ab.add(c0245f);
    }

    public void m3232b(C0245f c0245f) {
        if (this.ab != null) {
            this.ab.remove(c0245f);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ag == null) {
                try {
                    this.ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ag.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0517c) ((View) this.ai.get(i2)).getLayoutParams()).f2001f;
    }

    public int getOffscreenPageLimit() {
        return this.f2007A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f2007A) {
            this.f2007A = i;
            m3233c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f2042p;
        this.f2042p = i;
        int width = getWidth();
        m3193a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f2042p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f2043q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2043q;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2043q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m3215a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m3221a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.f2039m == null || this.f2039m.isFinished()) ? false : true;
        if (z) {
            int currX = this.f2040n ? this.f2039m.getCurrX() : this.f2039m.getStartX();
            this.f2039m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m3198a(false);
            m3233c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * m3215a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        if (abs > 0) {
            currX = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            currX = (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.f2034h.m2358c(this.f2035i)) + ((float) this.f2042p))) + 1.0f) * 100.0f);
        }
        i7 = Math.min(currX, 600);
        this.f2040n = false;
        this.f2039m.startScroll(i4, scrollY, i5, i6, i7);
        ao.m3928d(this);
    }

    C0516b m3216a(int i, int i2) {
        C0516b c0516b = new C0516b();
        c0516b.f1992b = i;
        c0516b.f1991a = this.f2034h.mo300a((ViewGroup) this, i);
        c0516b.f1994d = this.f2034h.m2358c(i);
        if (i2 < 0 || i2 >= this.f2031e.size()) {
            this.f2031e.add(c0516b);
        } else {
            this.f2031e.add(i2, c0516b);
        }
        return c0516b;
    }

    void m3230b() {
        boolean z;
        int i;
        int b = this.f2034h.mo1273b();
        this.f2030b = b;
        if (this.f2031e.size() >= (this.f2007A * 2) + 1 || this.f2031e.size() >= b) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = false;
        int i2 = this.f2035i;
        boolean z3 = z;
        int i3 = 0;
        while (i3 < this.f2031e.size()) {
            int i4;
            boolean z4;
            boolean z5;
            C0516b c0516b = (C0516b) this.f2031e.get(i3);
            int a = this.f2034h.m2340a(c0516b.f1991a);
            if (a == -1) {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            } else if (a == -2) {
                this.f2031e.remove(i3);
                i3--;
                if (!z2) {
                    this.f2034h.mo302a((ViewGroup) this);
                    z2 = true;
                }
                this.f2034h.mo303a((ViewGroup) this, c0516b.f1992b, c0516b.f1991a);
                if (this.f2035i == c0516b.f1992b) {
                    i4 = i3;
                    z4 = z2;
                    i = Math.max(0, Math.min(this.f2035i, b - 1));
                    z5 = true;
                } else {
                    i4 = i3;
                    z4 = z2;
                    i = i2;
                    z5 = true;
                }
            } else if (c0516b.f1992b != a) {
                if (c0516b.f1992b == this.f2035i) {
                    i2 = a;
                }
                c0516b.f1992b = a;
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = true;
            } else {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            }
            z3 = z5;
            i2 = i;
            z2 = z4;
            i3 = i4 + 1;
        }
        if (z2) {
            this.f2034h.mo305b((ViewGroup) this);
        }
        Collections.sort(this.f2031e, f2005c);
        if (z3) {
            i = getChildCount();
            for (i3 = 0; i3 < i; i3++) {
                C0517c c0517c = (C0517c) getChildAt(i3).getLayoutParams();
                if (!c0517c.f1996a) {
                    c0517c.f1998c = 0.0f;
                }
            }
            m3223a(i2, false, true);
            requestLayout();
        }
    }

    void m3233c() {
        m3219a(this.f2035i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m3219a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.f2035i;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.f2035i;
        r0 = r17;
        r2 = r0.m3228b(r2);
        r0 = r18;
        r1 = r17;
        r1.f2035i = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.f2034h;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.m3211k();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.f2052z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.m3211k();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.f2034h;
        r0 = r17;
        r2.mo302a(r0);
        r0 = r17;
        r2 = r0.f2007A;
        r4 = 0;
        r0 = r17;
        r5 = r0.f2035i;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.f2034h;
        r11 = r4.mo1273b();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.f2035i;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.f2030b;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.f2030b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.f2034h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
        r6 = r2.f1992b;
        r0 = r17;
        r7 = r0.f2035i;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f1992b;
        r0 = r17;
        r7 = r0.f2035i;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.f2035i;
        r0 = r17;
        r2 = r0.m3216a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.f2035i;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f1994d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.f2035i;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.m3195a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.f2034h;
        r0 = r17;
        r4 = r0.f2035i;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f1991a;
    L_0x0179:
        r0 = r17;
        r3.mo306b(r0, r4, r2);
        r0 = r17;
        r2 = r0.f2034h;
        r0 = r17;
        r2.mo305b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.C0517c) r2;
        r2.f2001f = r3;
        r6 = r2.f1996a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f1998c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.m3217a(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f1994d;
        r2.f1998c = r6;
        r5 = r5.f1992b;
        r2.f2000e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f1994d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f1992b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f1993c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.f2031e;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.f2034h;
        r2 = r2.f1991a;
        r0 = r17;
        r14.mo303a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f1992b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f1994d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.m3216a(r8, r2);
        r2 = r2.f1994d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f1992b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f1993c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.f2031e;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.f2034h;
        r2 = r2.f1991a;
        r0 = r17;
        r10.mo303a(r0, r8, r2);
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f1992b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f1994d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.m3216a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f1994d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.f2031e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0516b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.m3211k();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.m3229b(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f1992b;
        r0 = r17;
        r3 = r0.f2035i;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.m3217a(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f1992b;
        r0 = r17;
        r5 = r0.f2035i;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void m3211k() {
        if (this.ah != 0) {
            if (this.ai == null) {
                this.ai = new ArrayList();
            } else {
                this.ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ai.add(getChildAt(i));
            }
            Collections.sort(this.ai, aj);
        }
    }

    private void m3195a(C0516b c0516b, int i, C0516b c0516b2) {
        float f;
        float f2;
        int i2;
        C0516b c0516b3;
        int i3;
        int b = this.f2034h.mo1273b();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f2042p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (c0516b2 != null) {
            clientWidth = c0516b2.f1992b;
            int i4;
            if (clientWidth < c0516b.f1992b) {
                f2 = (c0516b2.f1995e + c0516b2.f1994d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= c0516b.f1992b && i2 < this.f2031e.size()) {
                    c0516b3 = (C0516b) this.f2031e.get(i2);
                    while (i4 > c0516b3.f1992b && i2 < this.f2031e.size() - 1) {
                        i2++;
                        c0516b3 = (C0516b) this.f2031e.get(i2);
                    }
                    while (i4 < c0516b3.f1992b) {
                        f2 += this.f2034h.m2358c(i4) + f;
                        i4++;
                    }
                    c0516b3.f1995e = f2;
                    f2 += c0516b3.f1994d + f;
                    i4++;
                }
            } else if (clientWidth > c0516b.f1992b) {
                i2 = this.f2031e.size() - 1;
                f2 = c0516b2.f1995e;
                i4 = clientWidth - 1;
                while (i4 >= c0516b.f1992b && i2 >= 0) {
                    c0516b3 = (C0516b) this.f2031e.get(i2);
                    while (i4 < c0516b3.f1992b && i2 > 0) {
                        i2--;
                        c0516b3 = (C0516b) this.f2031e.get(i2);
                    }
                    while (i4 > c0516b3.f1992b) {
                        f2 -= this.f2034h.m2358c(i4) + f;
                        i4--;
                    }
                    f2 -= c0516b3.f1994d + f;
                    c0516b3.f1995e = f2;
                    i4--;
                }
            }
        }
        int size = this.f2031e.size();
        float f3 = c0516b.f1995e;
        i2 = c0516b.f1992b - 1;
        this.f2046t = c0516b.f1992b == 0 ? c0516b.f1995e : -3.4028235E38f;
        this.f2047u = c0516b.f1992b == b + -1 ? (c0516b.f1995e + c0516b.f1994d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c0516b3 = (C0516b) this.f2031e.get(i3);
            f2 = f3;
            while (i2 > c0516b3.f1992b) {
                f2 -= this.f2034h.m2358c(i2) + f;
                i2--;
            }
            f3 = f2 - (c0516b3.f1994d + f);
            c0516b3.f1995e = f3;
            if (c0516b3.f1992b == 0) {
                this.f2046t = f3;
            }
            i2--;
        }
        f3 = (c0516b.f1995e + c0516b.f1994d) + f;
        i2 = c0516b.f1992b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c0516b3 = (C0516b) this.f2031e.get(i3);
            f2 = f3;
            while (i2 < c0516b3.f1992b) {
                f2 = (this.f2034h.m2358c(i2) + f) + f2;
                i2++;
            }
            if (c0516b3.f1992b == b - 1) {
                this.f2047u = (c0516b3.f1994d + f2) - 1.0f;
            }
            c0516b3.f1995e = f2;
            f3 = f2 + (c0516b3.f1994d + f);
            i2++;
        }
        this.f2028V = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1988b = this.f2035i;
        if (this.f2034h != null) {
            savedState.f1989c = this.f2034h.mo299a();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.m3182a());
            if (this.f2034h != null) {
                this.f2034h.mo301a(savedState.f1989c, savedState.f1990d);
                m3223a(savedState.f1988b, false, true);
                return;
            }
            this.f2036j = savedState.f1988b;
            this.f2037k = savedState.f1989c;
            this.f2038l = savedState.f1990d;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        C0517c c0517c = (C0517c) layoutParams2;
        c0517c.f1996a |= m3205c(view);
        if (!this.f2050x) {
            super.addView(view, i, layoutParams2);
        } else if (c0517c == null || !c0517c.f1996a) {
            c0517c.f1999d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean m3205c(View view) {
        return view.getClass().getAnnotation(C0515a.class) != null;
    }

    public void removeView(View view) {
        if (this.f2050x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    C0516b m3217a(View view) {
        for (int i = 0; i < this.f2031e.size(); i++) {
            C0516b c0516b = (C0516b) this.f2031e.get(i);
            if (this.f2034h.mo304a(view, c0516b.f1991a)) {
                return c0516b;
            }
        }
        return null;
    }

    C0516b m3229b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m3217a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    C0516b m3228b(int i) {
        for (int i2 = 0; i2 < this.f2031e.size(); i2++) {
            C0516b c0516b = (C0516b) this.f2031e.get(i2);
            if (c0516b.f1992b == i) {
                return c0516b;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2027U = true;
    }

    protected void onMeasure(int i, int i2) {
        C0517c c0517c;
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f2011E = Math.min(measuredWidth / 10, this.f2010D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c0517c = (C0517c) childAt.getLayoutParams();
                if (c0517c != null && c0517c.f1996a) {
                    int i6 = c0517c.f1997b & 7;
                    int i7 = c0517c.f1997b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (c0517c.width != -2) {
                        i7 = 1073741824;
                        i3 = c0517c.width != -1 ? c0517c.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (c0517c.height != -2) {
                        i5 = 1073741824;
                        if (c0517c.height != -1) {
                            measuredWidth = c0517c.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f2048v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f2049w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f2050x = true;
        m3233c();
        this.f2050x = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                c0517c = (C0517c) childAt2.getLayoutParams();
                if (c0517c == null || !c0517c.f1996a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0517c.f1998c * ((float) paddingLeft)), 1073741824), this.f2049w);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m3193a(i, i3, this.f2042p, this.f2042p);
        }
    }

    private void m3193a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f2031e.isEmpty()) {
            C0516b b = m3228b(this.f2035i);
            int min = (int) ((b != null ? Math.min(b.f1995e, this.f2047u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m3198a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.f2039m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.f2039m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            C0517c c0517c;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c0517c = (C0517c) childAt.getLayoutParams();
                if (c0517c.f1996a) {
                    int i9 = c0517c.f1997b & 112;
                    switch (c0517c.f1997b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c0517c = (C0517c) childAt2.getLayoutParams();
                if (!c0517c.f1996a) {
                    C0516b a = m3217a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f1995e * ((float) max))) + paddingLeft;
                        if (c0517c.f1999d) {
                            c0517c.f1999d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0517c.f1998c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f2044r = paddingTop;
        this.f2045s = i6 - paddingBottom;
        this.aa = i7;
        if (this.f2027U) {
            m3194a(this.f2035i, false, 0, false);
        }
        this.f2027U = false;
    }

    public void computeScroll() {
        this.f2040n = true;
        if (this.f2039m.isFinished() || !this.f2039m.computeScrollOffset()) {
            m3198a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f2039m.getCurrX();
        int currY = this.f2039m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m3206d(currX)) {
                this.f2039m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ao.m3928d(this);
    }

    private boolean m3206d(int i) {
        if (this.f2031e.size() != 0) {
            C0516b m = m3213m();
            int clientWidth = getClientWidth();
            int i2 = this.f2042p + clientWidth;
            float f = ((float) this.f2042p) / ((float) clientWidth);
            int i3 = m.f1992b;
            float f2 = ((((float) i) / ((float) clientWidth)) - m.f1995e) / (m.f1994d + f);
            clientWidth = (int) (((float) i2) * f2);
            this.f2029W = false;
            m3220a(i3, f2, clientWidth);
            if (this.f2029W) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f2027U) {
            return false;
        } else {
            this.f2029W = false;
            m3220a(0, 0.0f, 0);
            if (this.f2029W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void m3220a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.aa > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C0517c c0517c = (C0517c) childAt.getLayoutParams();
                if (c0517c.f1996a) {
                    int max;
                    switch (c0517c.f1997b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m3201b(i, f, i2);
        if (this.af != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C0517c) childAt2.getLayoutParams()).f1996a) {
                    this.af.m3188a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f2029W = true;
    }

    private void m3201b(int i, float f, int i2) {
        if (this.ac != null) {
            this.ac.mo214a(i, f, i2);
        }
        if (this.ab != null) {
            int size = this.ab.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0245f c0245f = (C0245f) this.ab.get(i3);
                if (c0245f != null) {
                    c0245f.mo214a(i, f, i2);
                }
            }
        }
        if (this.ad != null) {
            this.ad.mo214a(i, f, i2);
        }
    }

    private void m3207e(int i) {
        if (this.ac != null) {
            this.ac.mo215b(i);
        }
        if (this.ab != null) {
            int size = this.ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0245f c0245f = (C0245f) this.ab.get(i2);
                if (c0245f != null) {
                    c0245f.mo215b(i);
                }
            }
        }
        if (this.ad != null) {
            this.ad.mo215b(i);
        }
    }

    private void m3208f(int i) {
        if (this.ac != null) {
            this.ac.mo213a(i);
        }
        if (this.ab != null) {
            int size = this.ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0245f c0245f = (C0245f) this.ab.get(i2);
                if (c0245f != null) {
                    c0245f.mo213a(i);
                }
            }
        }
        if (this.ad != null) {
            this.ad.mo213a(i);
        }
    }

    private void m3198a(boolean z) {
        int scrollX;
        boolean z2 = this.al == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.f2039m.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.f2039m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f2039m.getCurrX();
                int currY = this.f2039m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m3206d(currX);
                    }
                }
            }
        }
        this.f2052z = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.f2031e.size(); scrollX++) {
            C0516b c0516b = (C0516b) this.f2031e.get(scrollX);
            if (c0516b.f1993c) {
                c0516b.f1993c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            ao.m3913a((View) this, this.ak);
        } else {
            this.ak.run();
        }
    }

    private boolean m3199a(float f, float f2) {
        return (f < ((float) this.f2011E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f2011E)) && f2 < 0.0f);
    }

    private void m3202b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ao.m3906a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m3212l();
            return false;
        }
        if (action != 0) {
            if (this.f2008B) {
                return true;
            }
            if (this.f2009C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f2015I = x;
                this.f2013G = x;
                x = motionEvent.getY();
                this.f2016J = x;
                this.f2014H = x;
                this.f2017K = C0684z.m4400b(motionEvent, 0);
                this.f2009C = false;
                this.f2040n = true;
                this.f2039m.computeScrollOffset();
                if (this.al == 2 && Math.abs(this.f2039m.getFinalX() - this.f2039m.getCurrX()) > this.f2022P) {
                    this.f2039m.abortAnimation();
                    this.f2052z = false;
                    m3233c();
                    this.f2008B = true;
                    m3203c(true);
                    setScrollState(1);
                    break;
                }
                m3198a(false);
                this.f2008B = false;
                break;
            case 2:
                action = this.f2017K;
                if (action != -1) {
                    action = C0684z.m4398a(motionEvent, action);
                    float c = C0684z.m4401c(motionEvent, action);
                    float f = c - this.f2013G;
                    float abs = Math.abs(f);
                    float d = C0684z.m4403d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f2016J);
                    if (f == 0.0f || m3199a(this.f2013G, f) || !m3227a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f2012F) && 0.5f * abs > abs2) {
                            this.f2008B = true;
                            m3203c(true);
                            setScrollState(1);
                            this.f2013G = f > 0.0f ? this.f2015I + ((float) this.f2012F) : this.f2015I - ((float) this.f2012F);
                            this.f2014H = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f2012F)) {
                            this.f2009C = true;
                        }
                        if (this.f2008B && m3204c(c)) {
                            ao.m3928d(this);
                            break;
                        }
                    }
                    this.f2013G = c;
                    this.f2014H = d;
                    this.f2009C = true;
                    return false;
                }
                break;
            case 6:
                m3197a(motionEvent);
                break;
        }
        if (this.f2018L == null) {
            this.f2018L = VelocityTracker.obtain();
        }
        this.f2018L.addMovement(motionEvent);
        return this.f2008B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f2023Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f2034h == null || this.f2034h.mo1273b() == 0) {
            return false;
        }
        if (this.f2018L == null) {
            this.f2018L = VelocityTracker.obtain();
        }
        this.f2018L.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f2039m.abortAnimation();
                this.f2052z = false;
                m3233c();
                x = motionEvent.getX();
                this.f2015I = x;
                this.f2013G = x;
                x = motionEvent.getY();
                this.f2016J = x;
                this.f2014H = x;
                this.f2017K = C0684z.m4400b(motionEvent, 0);
                break;
            case 1:
                if (this.f2008B) {
                    VelocityTracker velocityTracker = this.f2018L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f2020N);
                    a = (int) am.m3669a(velocityTracker, this.f2017K);
                    this.f2052z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0516b m = m3213m();
                    m3224a(m3190a(m.f1992b, ((((float) scrollX) / ((float) clientWidth)) - m.f1995e) / (m.f1994d + (((float) this.f2042p) / ((float) clientWidth))), a, (int) (C0684z.m4401c(motionEvent, C0684z.m4398a(motionEvent, this.f2017K)) - this.f2015I)), true, true, a);
                    z = m3212l();
                    break;
                }
                break;
            case 2:
                if (!this.f2008B) {
                    a = C0684z.m4398a(motionEvent, this.f2017K);
                    if (a == -1) {
                        z = m3212l();
                        break;
                    }
                    float c = C0684z.m4401c(motionEvent, a);
                    float abs = Math.abs(c - this.f2013G);
                    float d = C0684z.m4403d(motionEvent, a);
                    x = Math.abs(d - this.f2014H);
                    if (abs > ((float) this.f2012F) && abs > x) {
                        this.f2008B = true;
                        m3203c(true);
                        if (c - this.f2015I > 0.0f) {
                            x = this.f2015I + ((float) this.f2012F);
                        } else {
                            x = this.f2015I - ((float) this.f2012F);
                        }
                        this.f2013G = x;
                        this.f2014H = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f2008B) {
                    z = false | m3204c(C0684z.m4401c(motionEvent, C0684z.m4398a(motionEvent, this.f2017K)));
                    break;
                }
                break;
            case 3:
                if (this.f2008B) {
                    m3194a(this.f2035i, true, 0, false);
                    z = m3212l();
                    break;
                }
                break;
            case 5:
                a = C0684z.m4399b(motionEvent);
                this.f2013G = C0684z.m4401c(motionEvent, a);
                this.f2017K = C0684z.m4400b(motionEvent, a);
                break;
            case 6:
                m3197a(motionEvent);
                this.f2013G = C0684z.m4401c(motionEvent, C0684z.m4398a(motionEvent, this.f2017K));
                break;
        }
        if (z) {
            ao.m3928d(this);
        }
        return true;
    }

    private boolean m3212l() {
        this.f2017K = -1;
        m3214n();
        return this.f2025S.m4913c() | this.f2026T.m4913c();
    }

    private void m3203c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m3204c(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f2013G - f;
        this.f2013G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f2046t;
        float f5 = ((float) clientWidth) * this.f2047u;
        C0516b c0516b = (C0516b) this.f2031e.get(0);
        C0516b c0516b2 = (C0516b) this.f2031e.get(this.f2031e.size() - 1);
        if (c0516b.f1992b != 0) {
            f4 = c0516b.f1995e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c0516b2.f1992b != this.f2034h.mo1273b() - 1) {
            f2 = c0516b2.f1995e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f2025S.m4908a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f2026T.m4908a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f2013G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m3206d((int) f4);
        return z3;
    }

    private C0516b m3213m() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f2042p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C0516b c0516b = null;
        while (i2 < this.f2031e.size()) {
            int i3;
            C0516b c0516b2;
            C0516b c0516b3 = (C0516b) this.f2031e.get(i2);
            C0516b c0516b4;
            if (obj != null || c0516b3.f1992b == i + 1) {
                c0516b4 = c0516b3;
                i3 = i2;
                c0516b2 = c0516b4;
            } else {
                c0516b3 = this.f2032f;
                c0516b3.f1995e = (f2 + f3) + f;
                c0516b3.f1992b = i + 1;
                c0516b3.f1994d = this.f2034h.m2358c(c0516b3.f1992b);
                c0516b4 = c0516b3;
                i3 = i2 - 1;
                c0516b2 = c0516b4;
            }
            f2 = c0516b2.f1995e;
            f3 = (c0516b2.f1994d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0516b;
            }
            if (scrollX < f3 || i3 == this.f2031e.size() - 1) {
                return c0516b2;
            }
            f3 = f2;
            i = c0516b2.f1992b;
            obj = null;
            f2 = c0516b2.f1994d;
            c0516b = c0516b2;
            i2 = i3 + 1;
        }
        return c0516b;
    }

    private int m3190a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f2021O || Math.abs(i2) <= this.f2019M) {
            i = (int) ((i >= this.f2035i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f2031e.size() <= 0) {
            return i;
        }
        return Math.max(((C0516b) this.f2031e.get(0)).f1992b, Math.min(i, ((C0516b) this.f2031e.get(this.f2031e.size() - 1)).f1992b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ao.m3901a(this);
        if (a == 0 || (a == 1 && this.f2034h != null && this.f2034h.mo1273b() > 1)) {
            int height;
            int width;
            if (!this.f2025S.m4907a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f2046t * ((float) width));
                this.f2025S.m4906a(height, width);
                i = 0 | this.f2025S.m4911a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f2026T.m4907a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f2047u + 1.0f)) * ((float) height));
                this.f2026T.m4906a(width, height);
                i |= this.f2026T.m4911a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f2025S.m4912b();
            this.f2026T.m4912b();
        }
        if (i != 0) {
            ao.m3928d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2042p > 0 && this.f2043q != null && this.f2031e.size() > 0 && this.f2034h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f2042p) / ((float) width);
            C0516b c0516b = (C0516b) this.f2031e.get(0);
            float f2 = c0516b.f1995e;
            int size = this.f2031e.size();
            int i = c0516b.f1992b;
            int i2 = ((C0516b) this.f2031e.get(size - 1)).f1992b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0516b.f1992b && i3 < size) {
                    i3++;
                    c0516b = (C0516b) this.f2031e.get(i3);
                }
                if (i4 == c0516b.f1992b) {
                    f3 = (c0516b.f1995e + c0516b.f1994d) * ((float) width);
                    f2 = (c0516b.f1995e + c0516b.f1994d) + f;
                } else {
                    float c = this.f2034h.m2358c(i4);
                    f3 = (f2 + c) * ((float) width);
                    f2 += c + f;
                }
                if (((float) this.f2042p) + f3 > ((float) scrollX)) {
                    this.f2043q.setBounds(Math.round(f3), this.f2044r, Math.round(((float) this.f2042p) + f3), this.f2045s);
                    this.f2043q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean m3235d() {
        if (this.f2008B) {
            return false;
        }
        this.f2023Q = true;
        setScrollState(1);
        this.f2013G = 0.0f;
        this.f2015I = 0.0f;
        if (this.f2018L == null) {
            this.f2018L = VelocityTracker.obtain();
        } else {
            this.f2018L.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f2018L.addMovement(obtain);
        obtain.recycle();
        this.f2024R = uptimeMillis;
        return true;
    }

    public void m3236e() {
        if (this.f2023Q) {
            if (this.f2034h != null) {
                VelocityTracker velocityTracker = this.f2018L;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f2020N);
                int a = (int) am.m3669a(velocityTracker, this.f2017K);
                this.f2052z = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C0516b m = m3213m();
                m3224a(m3190a(m.f1992b, ((((float) scrollX) / ((float) clientWidth)) - m.f1995e) / m.f1994d, a, (int) (this.f2013G - this.f2015I)), true, true, a);
            }
            m3214n();
            this.f2023Q = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void m3231b(float f) {
        if (!this.f2023Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.f2034h != null) {
            float f2;
            float f3;
            this.f2013G += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f4 = ((float) clientWidth) * this.f2046t;
            float f5 = ((float) clientWidth) * this.f2047u;
            C0516b c0516b = (C0516b) this.f2031e.get(0);
            C0516b c0516b2 = (C0516b) this.f2031e.get(this.f2031e.size() - 1);
            if (c0516b.f1992b != 0) {
                f2 = c0516b.f1995e * ((float) clientWidth);
            } else {
                f2 = f4;
            }
            if (c0516b2.f1992b != this.f2034h.mo1273b() - 1) {
                f3 = c0516b2.f1995e * ((float) clientWidth);
            } else {
                f3 = f5;
            }
            if (scrollX >= f2) {
                if (scrollX > f3) {
                    f2 = f3;
                } else {
                    f2 = scrollX;
                }
            }
            this.f2013G += f2 - ((float) ((int) f2));
            scrollTo((int) f2, getScrollY());
            m3206d((int) f2);
            MotionEvent obtain = MotionEvent.obtain(this.f2024R, SystemClock.uptimeMillis(), 2, this.f2013G, 0.0f, 0);
            this.f2018L.addMovement(obtain);
            obtain.recycle();
        }
    }

    public boolean m3237f() {
        return this.f2023Q;
    }

    private void m3197a(MotionEvent motionEvent) {
        int b = C0684z.m4399b(motionEvent);
        if (C0684z.m4400b(motionEvent, b) == this.f2017K) {
            b = b == 0 ? 1 : 0;
            this.f2013G = C0684z.m4401c(motionEvent, b);
            this.f2017K = C0684z.m4400b(motionEvent, b);
            if (this.f2018L != null) {
                this.f2018L.clear();
            }
        }
    }

    private void m3214n() {
        this.f2008B = false;
        this.f2009C = false;
        if (this.f2018L != null) {
            this.f2018L.recycle();
            this.f2018L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f2051y != z) {
            this.f2051y = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f2034h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f2046t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f2047u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m3227a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m3227a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ao.m3917a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m3226a(keyEvent);
    }

    public boolean m3226a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m3234c(17);
            case 22:
                return m3234c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0651l.m4309a(keyEvent)) {
                    return m3234c(2);
                }
                if (C0651l.m4310a(keyEvent, 1)) {
                    return m3234c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m3234c(int i) {
        View view;
        boolean g;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                g = m3238g();
            } else {
                if (i == 66 || i == 2) {
                    g = m3239h();
                }
                g = false;
            }
        } else if (i == 17) {
            g = (view == null || m3191a(this.f2033g, findNextFocus).left < m3191a(this.f2033g, view).left) ? findNextFocus.requestFocus() : m3238g();
        } else {
            if (i == 66) {
                g = (view == null || m3191a(this.f2033g, findNextFocus).left > m3191a(this.f2033g, view).left) ? findNextFocus.requestFocus() : m3239h();
            }
            g = false;
        }
        if (g) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return g;
    }

    private Rect m3191a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean m3238g() {
        if (this.f2035i <= 0) {
            return false;
        }
        m3222a(this.f2035i - 1, true);
        return true;
    }

    boolean m3239h() {
        if (this.f2034h == null || this.f2035i >= this.f2034h.mo1273b() - 1) {
            return false;
        }
        m3222a(this.f2035i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0516b a = m3217a(childAt);
                    if (a != null && a.f1992b == this.f2035i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0516b a = m3217a(childAt);
                if (a != null && a.f1992b == this.f2035i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0516b a = m3217a(childAt);
                if (a != null && a.f1992b == this.f2035i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0516b a = m3217a(childAt);
                if (a != null && a.f1992b == this.f2035i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0517c();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0517c) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0517c(getContext(), attributeSet);
    }
}
