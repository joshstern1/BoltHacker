package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0249b;
import android.support.v4.view.C0684z;
import android.support.v4.view.ae;
import android.support.v4.view.af;
import android.support.v4.view.ag;
import android.support.v4.view.ah;
import android.support.v4.view.ak;
import android.support.v4.view.am;
import android.support.v4.view.ao;
import android.support.v4.view.p025a.C0527a;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0572s;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;

public class NestedScrollView extends FrameLayout implements ae, ag, ak {
    private static final C0694a f2222v = new C0694a();
    private static final int[] f2223w = new int[]{16843130};
    private C0695b f2224A;
    private long f2225a;
    private final Rect f2226b;
    private am f2227c;
    private C0744q f2228d;
    private C0744q f2229e;
    private int f2230f;
    private boolean f2231g;
    private boolean f2232h;
    private View f2233i;
    private boolean f2234j;
    private VelocityTracker f2235k;
    private boolean f2236l;
    private boolean f2237m;
    private int f2238n;
    private int f2239o;
    private int f2240p;
    private int f2241q;
    private final int[] f2242r;
    private final int[] f2243s;
    private int f2244t;
    private SavedState f2245u;
    private final ah f2246x;
    private final af f2247y;
    private float f2248z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new af();
        public int f2221a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2221a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2221a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2221a + "}";
        }
    }

    static class C0694a extends C0249b {
        C0694a() {
        }

        public boolean mo431a(View view, int i, Bundle bundle) {
            if (super.mo431a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m4539b(0, min);
                    return true;
                case DfuBaseService.ERROR_REMOTE_MASK /*8192*/:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m4539b(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void mo219a(View view, C0547e c0547e) {
            super.mo219a(view, c0547e);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0547e.m3443b(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.getScrollRange();
                if (a > 0) {
                    c0547e.m3467i(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0547e.m3434a((int) DfuBaseService.ERROR_REMOTE_MASK);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        c0547e.m3434a(4096);
                    }
                }
            }
        }

        public void mo220a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo220a(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            C0572s a = C0527a.m3246a(accessibilityEvent);
            a.m3621d(nestedScrollView.getScrollRange() > 0);
            a.m3620d(nestedScrollView.getScrollX());
            a.m3622e(nestedScrollView.getScrollY());
            a.m3623f(nestedScrollView.getScrollX());
            a.m3624g(nestedScrollView.getScrollRange());
        }
    }

    public interface C0695b {
        void mo787a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2226b = new Rect();
        this.f2231g = true;
        this.f2232h = false;
        this.f2233i = null;
        this.f2234j = false;
        this.f2237m = true;
        this.f2241q = -1;
        this.f2242r = new int[2];
        this.f2243s = new int[2];
        m4516a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2223w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2246x = new ah(this);
        this.f2247y = new af(this);
        setNestedScrollingEnabled(true);
        ao.m3911a((View) this, f2222v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f2247y.m3651a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2247y.m3652a();
    }

    public boolean startNestedScroll(int i) {
        return this.f2247y.m3655a(i);
    }

    public void stopNestedScroll() {
        this.f2247y.m3659c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f2247y.m3658b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2247y.m3656a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f2247y.m3657a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f2247y.m3654a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f2247y.m3653a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f2246x.m3662a(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f2246x.m3661a(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m4532f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.f2246x.m3660a();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void m4516a() {
        this.f2227c = am.m4762a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2238n = viewConfiguration.getScaledTouchSlop();
        this.f2239o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2240p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(C0695b c0695b) {
        this.f2224A = c0695b;
    }

    private boolean m4525b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f2236l) {
            this.f2236l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f2237m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f2224A != null) {
            this.f2224A.mo787a(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2236l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m4538a(keyEvent);
    }

    public boolean m4538a(KeyEvent keyEvent) {
        int i = 33;
        this.f2226b.setEmpty();
        if (m4525b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return m4540b(33);
                    }
                    return m4541c(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return m4540b(130);
                    }
                    return m4541c(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m4536a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            boolean z;
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m4527c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void m4526c() {
        if (this.f2235k == null) {
            this.f2235k = VelocityTracker.obtain();
        } else {
            this.f2235k.clear();
        }
    }

    private void m4528d() {
        if (this.f2235k == null) {
            this.f2235k = VelocityTracker.obtain();
        }
    }

    private void m4529e() {
        if (this.f2235k != null) {
            this.f2235k.recycle();
            this.f2235k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m4529e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f2234j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m4527c((int) motionEvent.getX(), action)) {
                    this.f2234j = false;
                    m4529e();
                    break;
                }
                this.f2230f = action;
                this.f2241q = C0684z.m4400b(motionEvent, 0);
                m4526c();
                this.f2235k.addMovement(motionEvent);
                this.f2227c.m4774g();
                if (!this.f2227c.m4767a()) {
                    z = true;
                }
                this.f2234j = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f2234j = false;
                this.f2241q = -1;
                m4529e();
                if (this.f2227c.m4768a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ao.m3928d(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.f2241q;
                if (action != -1) {
                    int a = C0684z.m4398a(motionEvent, action);
                    if (a != -1) {
                        action = (int) C0684z.m4403d(motionEvent, a);
                        if (Math.abs(action - this.f2230f) > this.f2238n && (getNestedScrollAxes() & 2) == 0) {
                            this.f2234j = true;
                            this.f2230f = action;
                            m4528d();
                            this.f2235k.addMovement(motionEvent);
                            this.f2244t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m4517a(motionEvent);
                break;
        }
        return this.f2234j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m4528d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0684z.m4397a(motionEvent);
        if (a == 0) {
            this.f2244t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f2244t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f2227c.m4767a();
                    this.f2234j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f2227c.m4767a()) {
                        this.f2227c.m4775h();
                    }
                    this.f2230f = (int) motionEvent.getY();
                    this.f2241q = C0684z.m4400b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.f2234j) {
                    VelocityTracker velocityTracker = this.f2235k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f2240p);
                    a = (int) am.m3670b(velocityTracker, this.f2241q);
                    if (Math.abs(a) > this.f2239o) {
                        m4532f(-a);
                    } else if (this.f2227c.m4768a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ao.m3928d(this);
                    }
                }
                this.f2241q = -1;
                m4531f();
                break;
            case 2:
                int a2 = C0684z.m4398a(motionEvent, this.f2241q);
                if (a2 != -1) {
                    int i;
                    int d = (int) C0684z.m4403d(motionEvent, a2);
                    a = this.f2230f - d;
                    if (dispatchNestedPreScroll(0, a, this.f2243s, this.f2242r)) {
                        a -= this.f2243s[1];
                        obtain.offsetLocation(0.0f, (float) this.f2242r[1]);
                        this.f2244t += this.f2242r[1];
                    }
                    if (this.f2234j || Math.abs(a) <= this.f2238n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f2234j = true;
                        if (a > 0) {
                            i = a - this.f2238n;
                        } else {
                            i = a + this.f2238n;
                        }
                    }
                    if (this.f2234j) {
                        Object obj;
                        this.f2230f = d - this.f2242r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = ao.m3901a(this);
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m4537a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f2235k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f2242r)) {
                            if (obj != null) {
                                m4533g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f2228d.m4909a(((float) i) / ((float) getHeight()), C0684z.m4401c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f2229e.m4907a()) {
                                        this.f2229e.m4913c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f2229e.m4909a(((float) i) / ((float) getHeight()), 1.0f - (C0684z.m4401c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f2228d.m4907a()) {
                                        this.f2228d.m4913c();
                                    }
                                }
                                if (!(this.f2228d == null || (this.f2228d.m4907a() && this.f2229e.m4907a()))) {
                                    ao.m3928d(this);
                                    break;
                                }
                            }
                        }
                        this.f2230f -= this.f2242r[1];
                        obtain.offsetLocation(0.0f, (float) this.f2242r[1]);
                        this.f2244t += this.f2242r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f2241q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f2234j && getChildCount() > 0 && this.f2227c.m4768a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ao.m3928d(this);
                }
                this.f2241q = -1;
                m4531f();
                break;
            case 5:
                a = C0684z.m4399b(motionEvent);
                this.f2230f = (int) C0684z.m4403d(motionEvent, a);
                this.f2241q = C0684z.m4400b(motionEvent, a);
                break;
            case 6:
                m4517a(motionEvent);
                this.f2230f = (int) C0684z.m4403d(motionEvent, C0684z.m4398a(motionEvent, this.f2241q));
                break;
        }
        if (this.f2235k != null) {
            this.f2235k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m4517a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (C0684z.m4400b(motionEvent, action) == this.f2241q) {
            action = action == 0 ? 1 : 0;
            this.f2230f = (int) C0684z.m4403d(motionEvent, action);
            this.f2241q = C0684z.m4400b(motionEvent, action);
            if (this.f2235k != null) {
                this.f2235k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((C0684z.m4404d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f2234j) {
                    return false;
                }
                float e = C0684z.m4405e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f2248z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f2248z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f2248z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean m4537a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = ao.m3901a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f2227c.m4768a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View m4515a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    public boolean m4536a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f2226b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f2226b.top + height > childAt.getBottom()) {
                    this.f2226b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f2226b.top = getScrollY() - height;
            if (this.f2226b.top < 0) {
                this.f2226b.top = 0;
            }
        }
        this.f2226b.bottom = this.f2226b.top + height;
        return m4518a(i, this.f2226b.top, this.f2226b.bottom);
    }

    public boolean m4540b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f2226b.top = 0;
        this.f2226b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f2226b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f2226b.top = this.f2226b.bottom - height;
            }
        }
        return m4518a(i, this.f2226b.top, this.f2226b.bottom);
    }

    private boolean m4518a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m4515a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m4530e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean m4541c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m4521a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m4530e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f2226b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2226b);
            m4530e(m4534a(this.f2226b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m4520a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m4520a(View view) {
        return !m4521a(view, 0, getHeight());
    }

    private boolean m4521a(View view, int i, int i2) {
        view.getDrawingRect(this.f2226b);
        offsetDescendantRectToMyCoords(view, this.f2226b);
        return this.f2226b.bottom + i >= getScrollY() && this.f2226b.top - i <= getScrollY() + i2;
    }

    private void m4530e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f2237m) {
            m4535a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void m4535a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2225a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f2227c.m4763a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ao.m3928d(this);
            } else {
                if (!this.f2227c.m4767a()) {
                    this.f2227c.m4775h();
                }
                scrollBy(i, i2);
            }
            this.f2225a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m4539b(int i, int i2) {
        m4535a(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.f2227c.m4774g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f2227c.m4769b();
            int c = this.f2227c.m4770c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = ao.m3901a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m4537a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m4533g();
                    if (c <= 0 && scrollY > 0) {
                        this.f2228d.m4910a((int) this.f2227c.m4773f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f2229e.m4910a((int) this.f2227c.m4773f());
                    }
                }
            }
        }
    }

    private void m4524b(View view) {
        view.getDrawingRect(this.f2226b);
        offsetDescendantRectToMyCoords(view, this.f2226b);
        int a = m4534a(this.f2226b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m4519a(Rect rect, boolean z) {
        int a = m4534a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m4535a(0, a);
            }
        }
        return z2;
    }

    protected int m4534a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f2231g) {
            this.f2233i = view2;
        } else {
            m4524b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocus;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocus == null || m4520a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m4519a(rect, z);
    }

    public void requestLayout() {
        this.f2231g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2231g = false;
        if (this.f2233i != null && m4522a(this.f2233i, (View) this)) {
            m4524b(this.f2233i);
        }
        this.f2233i = null;
        if (!this.f2232h) {
            if (this.f2245u != null) {
                scrollTo(getScrollX(), this.f2245u.f2221a);
                this.f2245u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2232h = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2232h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m4521a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f2226b);
            offsetDescendantRectToMyCoords(findFocus, this.f2226b);
            m4530e(m4534a(this.f2226b));
        }
    }

    private static boolean m4522a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m4522a((View) parent, view2);
        return z;
    }

    public void m4542d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f2227c.m4766a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ao.m3928d(this);
        }
    }

    private void m4532f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m4542d(i);
            }
        }
    }

    private void m4531f() {
        this.f2234j = false;
        m4529e();
        stopNestedScroll();
        if (this.f2228d != null) {
            this.f2228d.m4913c();
            this.f2229e.m4913c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m4523b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m4523b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void m4533g() {
        if (ao.m3901a(this) == 2) {
            this.f2228d = null;
            this.f2229e = null;
        } else if (this.f2228d == null) {
            Context context = getContext();
            this.f2228d = new C0744q(context);
            this.f2229e = new C0744q(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2228d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f2228d.m4907a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f2228d.m4906a(width, getHeight());
                if (this.f2228d.m4911a(canvas)) {
                    ao.m3928d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f2229e.m4907a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f2229e.m4906a(width, height);
                if (this.f2229e.m4911a(canvas)) {
                    ao.m3928d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m4523b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f2245u = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2221a = getScrollY();
        return savedState;
    }
}
