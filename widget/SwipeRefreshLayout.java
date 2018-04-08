package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.C0684z;
import android.support.v4.view.ae;
import android.support.v4.view.af;
import android.support.v4.view.ag;
import android.support.v4.view.ah;
import android.support.v4.view.ao;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements ae, ag {
    private static final String f2249c = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] f2250y = new int[]{16842766};
    private int f2251A;
    private float f2252B;
    private ab f2253C;
    private Animation f2254D;
    private Animation f2255E;
    private Animation f2256F;
    private Animation f2257G;
    private Animation f2258H;
    private float f2259I;
    private boolean f2260J;
    private int f2261K;
    private int f2262L;
    private boolean f2263M;
    private AnimationListener f2264N;
    private final Animation f2265O;
    private final Animation f2266P;
    protected int f2267a;
    protected int f2268b;
    private View f2269d;
    private C0696a f2270e;
    private boolean f2271f;
    private int f2272g;
    private float f2273h;
    private float f2274i;
    private final ah f2275j;
    private final af f2276k;
    private final int[] f2277l;
    private final int[] f2278m;
    private boolean f2279n;
    private int f2280o;
    private int f2281p;
    private boolean f2282q;
    private float f2283r;
    private float f2284s;
    private boolean f2285t;
    private int f2286u;
    private boolean f2287v;
    private boolean f2288w;
    private final DecelerateInterpolator f2289x;
    private C0721c f2290z;

    public interface C0696a {
        void mo2187a();
    }

    private void m4560b() {
        this.f2290z.clearAnimation();
        this.f2253C.stop();
        this.f2290z.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f2287v) {
            setAnimationProgress(0.0f);
        } else {
            m4550a(this.f2268b - this.f2281p, true);
        }
        this.f2281p = this.f2290z.getTop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m4560b();
    }

    private void setColorViewAlpha(int i) {
        this.f2290z.getBackground().setAlpha(i);
        this.f2253C.setAlpha(i);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.f2261K = i2;
                this.f2262L = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.f2261K = i2;
                this.f2262L = i2;
            }
            this.f2290z.setImageDrawable(null);
            this.f2253C.m4675a(i);
            this.f2290z.setImageDrawable(this.f2253C);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2271f = false;
        this.f2273h = -1.0f;
        this.f2277l = new int[2];
        this.f2278m = new int[2];
        this.f2282q = false;
        this.f2286u = -1;
        this.f2251A = -1;
        this.f2264N = new ap(this);
        this.f2265O = new au(this);
        this.f2266P = new av(this);
        this.f2272g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f2280o = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f2289x = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2250y);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f2261K = (int) (displayMetrics.density * 40.0f);
        this.f2262L = (int) (displayMetrics.density * 40.0f);
        m4565c();
        ao.m3916a((ViewGroup) this, true);
        this.f2259I = displayMetrics.density * 64.0f;
        this.f2273h = this.f2259I;
        this.f2275j = new ah(this);
        this.f2276k = new af(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f2251A < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f2251A;
        }
        if (i2 >= this.f2251A) {
            return i2 + 1;
        }
        return i2;
    }

    private void m4565c() {
        this.f2290z = new C0721c(getContext(), -328966, 20.0f);
        this.f2253C = new ab(getContext(), this);
        this.f2253C.m4679b(-328966);
        this.f2290z.setImageDrawable(this.f2253C);
        this.f2290z.setVisibility(8);
        addView(this.f2290z);
    }

    public void setOnRefreshListener(C0696a c0696a) {
        this.f2270e = c0696a;
    }

    private boolean m4570d() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f2271f == z) {
            m4556a(z, false);
            return;
        }
        int i;
        this.f2271f = z;
        if (this.f2263M) {
            i = (int) this.f2259I;
        } else {
            i = (int) (this.f2259I + ((float) this.f2268b));
        }
        m4550a(i - this.f2281p, true);
        this.f2260J = false;
        m4555a(this.f2264N);
    }

    private void m4555a(AnimationListener animationListener) {
        this.f2290z.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f2253C.setAlpha(255);
        }
        this.f2254D = new aq(this);
        this.f2254D.setDuration((long) this.f2280o);
        if (animationListener != null) {
            this.f2290z.m4850a(animationListener);
        }
        this.f2290z.clearAnimation();
        this.f2290z.startAnimation(this.f2254D);
    }

    private void setAnimationProgress(float f) {
        if (m4570d()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ao.m3929d(this.f2290z, f);
        ao.m3932e(this.f2290z, f);
    }

    private void m4556a(boolean z, boolean z2) {
        if (this.f2271f != z) {
            this.f2260J = z2;
            m4575g();
            this.f2271f = z;
            if (this.f2271f) {
                m4549a(this.f2281p, this.f2264N);
            } else {
                m4564b(this.f2264N);
            }
        }
    }

    private void m4564b(AnimationListener animationListener) {
        this.f2255E = new ar(this);
        this.f2255E.setDuration(150);
        this.f2290z.m4850a(animationListener);
        this.f2290z.clearAnimation();
        this.f2290z.startAnimation(this.f2255E);
    }

    private void m4572e() {
        this.f2256F = m4547a(this.f2253C.getAlpha(), 76);
    }

    private void m4573f() {
        this.f2257G = m4547a(this.f2253C.getAlpha(), 255);
    }

    private Animation m4547a(int i, int i2) {
        if (this.f2287v && m4570d()) {
            return null;
        }
        Animation asVar = new as(this, i, i2);
        asVar.setDuration(300);
        this.f2290z.m4850a(null);
        this.f2290z.clearAnimation();
        this.f2290z.startAnimation(asVar);
        return asVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f2290z.setBackgroundColor(i);
        this.f2253C.m4679b(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m4575g();
        this.f2253C.m4677a(iArr);
    }

    private void m4575g() {
        if (this.f2269d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f2290z)) {
                    i++;
                } else {
                    this.f2269d = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f2273h = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f2269d == null) {
                m4575g();
            }
            if (this.f2269d != null) {
                View view = this.f2269d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f2290z.getMeasuredWidth();
                this.f2290z.layout((measuredWidth / 2) - (measuredHeight / 2), this.f2281p, (measuredWidth / 2) + (measuredHeight / 2), this.f2281p + this.f2290z.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2269d == null) {
            m4575g();
        }
        if (this.f2269d != null) {
            int i3;
            this.f2269d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f2290z.measure(MeasureSpec.makeMeasureSpec(this.f2261K, 1073741824), MeasureSpec.makeMeasureSpec(this.f2262L, 1073741824));
            if (!(this.f2263M || this.f2282q)) {
                this.f2282q = true;
                i3 = -this.f2290z.getMeasuredHeight();
                this.f2268b = i3;
                this.f2281p = i3;
            }
            this.f2251A = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f2290z) {
                    this.f2251A = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f2290z != null ? this.f2290z.getMeasuredHeight() : 0;
    }

    public boolean m4580a() {
        boolean z = false;
        if (VERSION.SDK_INT >= 14) {
            return ao.m3923b(this.f2269d, -1);
        }
        if (this.f2269d instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f2269d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (ao.m3923b(this.f2269d, -1) || this.f2269d.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m4575g();
        int a = C0684z.m4397a(motionEvent);
        if (this.f2288w && a == 0) {
            this.f2288w = false;
        }
        if (!isEnabled() || this.f2288w || m4580a() || this.f2271f || this.f2279n) {
            return false;
        }
        float a2;
        switch (a) {
            case 0:
                m4550a(this.f2268b - this.f2290z.getTop(), true);
                this.f2286u = C0684z.m4400b(motionEvent, 0);
                this.f2285t = false;
                a2 = m4545a(motionEvent, this.f2286u);
                if (a2 != -1.0f) {
                    this.f2284s = a2;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.f2285t = false;
                this.f2286u = -1;
                break;
            case 2:
                if (this.f2286u == -1) {
                    Log.e(f2249c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = m4545a(motionEvent, this.f2286u);
                if (a2 != -1.0f) {
                    if (a2 - this.f2284s > ((float) this.f2272g) && !this.f2285t) {
                        this.f2283r = this.f2284s + ((float) this.f2272g);
                        this.f2285t = true;
                        this.f2253C.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                m4554a(motionEvent);
                break;
        }
        return this.f2285t;
    }

    private float m4545a(MotionEvent motionEvent, int i) {
        int a = C0684z.m4398a(motionEvent, i);
        if (a < 0) {
            return -1.0f;
        }
        return C0684z.m4403d(motionEvent, a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.f2269d instanceof AbsListView)) {
            return;
        }
        if (this.f2269d == null || ao.m3893E(this.f2269d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f2288w || this.f2271f || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f2275j.m3662a(view, view2, i);
        startNestedScroll(i & 2);
        this.f2274i = 0.0f;
        this.f2279n = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f2274i > 0.0f) {
            if (((float) i2) > this.f2274i) {
                iArr[1] = i2 - ((int) this.f2274i);
                this.f2274i = 0.0f;
            } else {
                this.f2274i -= (float) i2;
                iArr[1] = i2;
            }
            m4548a(this.f2274i);
        }
        if (this.f2263M && i2 > 0 && this.f2274i == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f2290z.setVisibility(8);
        }
        int[] iArr2 = this.f2277l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f2275j.m3660a();
    }

    public void onStopNestedScroll(View view) {
        this.f2275j.m3661a(view);
        this.f2279n = false;
        if (this.f2274i > 0.0f) {
            m4561b(this.f2274i);
            this.f2274i = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f2278m);
        int i5 = this.f2278m[1] + i4;
        if (i5 < 0 && !m4580a()) {
            this.f2274i = ((float) Math.abs(i5)) + this.f2274i;
            m4548a(this.f2274i);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f2276k.m3651a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2276k.m3652a();
    }

    public boolean startNestedScroll(int i) {
        return this.f2276k.m3655a(i);
    }

    public void stopNestedScroll() {
        this.f2276k.m3659c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f2276k.m3658b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2276k.m3656a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f2276k.m3657a(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f2276k.m3654a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f2276k.m3653a(f, f2);
    }

    private boolean m4558a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void m4548a(float f) {
        this.f2253C.m4676a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f2273h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f2273h;
        float f2 = this.f2263M ? this.f2259I - ((float) this.f2268b) : this.f2259I;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.f2268b;
        if (this.f2290z.getVisibility() != 0) {
            this.f2290z.setVisibility(0);
        }
        if (!this.f2287v) {
            ao.m3929d(this.f2290z, 1.0f);
            ao.m3932e(this.f2290z, 1.0f);
        }
        if (this.f2287v) {
            setAnimationProgress(Math.min(1.0f, f / this.f2273h));
        }
        if (f < this.f2273h) {
            if (this.f2253C.getAlpha() > 76 && !m4558a(this.f2256F)) {
                m4572e();
            }
        } else if (this.f2253C.getAlpha() < 255 && !m4558a(this.f2257G)) {
            m4573f();
        }
        this.f2253C.m4674a(0.0f, Math.min(0.8f, max * 0.8f));
        this.f2253C.m4673a(Math.min(1.0f, max));
        this.f2253C.m4678b(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        m4550a(i - this.f2281p, true);
    }

    private void m4561b(float f) {
        if (f > this.f2273h) {
            m4556a(true, true);
            return;
        }
        this.f2271f = false;
        this.f2253C.m4674a(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.f2287v) {
            animationListener = new at(this);
        }
        m4562b(this.f2281p, animationListener);
        this.f2253C.m4676a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0684z.m4397a(motionEvent);
        if (this.f2288w && a == 0) {
            this.f2288w = false;
        }
        if (!isEnabled() || this.f2288w || m4580a() || this.f2279n) {
            return false;
        }
        float d;
        switch (a) {
            case 0:
                this.f2286u = C0684z.m4400b(motionEvent, 0);
                this.f2285t = false;
                break;
            case 1:
                a = C0684z.m4398a(motionEvent, this.f2286u);
                if (a < 0) {
                    Log.e(f2249c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                d = (C0684z.m4403d(motionEvent, a) - this.f2283r) * 0.5f;
                this.f2285t = false;
                m4561b(d);
                this.f2286u = -1;
                return false;
            case 2:
                a = C0684z.m4398a(motionEvent, this.f2286u);
                if (a < 0) {
                    Log.e(f2249c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                d = (C0684z.m4403d(motionEvent, a) - this.f2283r) * 0.5f;
                if (this.f2285t) {
                    if (d > 0.0f) {
                        m4548a(d);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                a = C0684z.m4399b(motionEvent);
                if (a >= 0) {
                    this.f2286u = C0684z.m4400b(motionEvent, a);
                    break;
                }
                Log.e(f2249c, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case 6:
                m4554a(motionEvent);
                break;
        }
        return true;
    }

    private void m4549a(int i, AnimationListener animationListener) {
        this.f2267a = i;
        this.f2265O.reset();
        this.f2265O.setDuration(200);
        this.f2265O.setInterpolator(this.f2289x);
        if (animationListener != null) {
            this.f2290z.m4850a(animationListener);
        }
        this.f2290z.clearAnimation();
        this.f2290z.startAnimation(this.f2265O);
    }

    private void m4562b(int i, AnimationListener animationListener) {
        if (this.f2287v) {
            m4567c(i, animationListener);
            return;
        }
        this.f2267a = i;
        this.f2266P.reset();
        this.f2266P.setDuration(200);
        this.f2266P.setInterpolator(this.f2289x);
        if (animationListener != null) {
            this.f2290z.m4850a(animationListener);
        }
        this.f2290z.clearAnimation();
        this.f2290z.startAnimation(this.f2266P);
    }

    private void m4566c(float f) {
        m4550a((this.f2267a + ((int) (((float) (this.f2268b - this.f2267a)) * f))) - this.f2290z.getTop(), false);
    }

    private void m4567c(int i, AnimationListener animationListener) {
        this.f2267a = i;
        if (m4570d()) {
            this.f2252B = (float) this.f2253C.getAlpha();
        } else {
            this.f2252B = ao.m3951u(this.f2290z);
        }
        this.f2258H = new aw(this);
        this.f2258H.setDuration(150);
        if (animationListener != null) {
            this.f2290z.m4850a(animationListener);
        }
        this.f2290z.clearAnimation();
        this.f2290z.startAnimation(this.f2258H);
    }

    private void m4550a(int i, boolean z) {
        this.f2290z.bringToFront();
        this.f2290z.offsetTopAndBottom(i);
        this.f2281p = this.f2290z.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m4554a(MotionEvent motionEvent) {
        int b = C0684z.m4399b(motionEvent);
        if (C0684z.m4400b(motionEvent, b) == this.f2286u) {
            this.f2286u = C0684z.m4400b(motionEvent, b == 0 ? 1 : 0);
        }
    }
}
