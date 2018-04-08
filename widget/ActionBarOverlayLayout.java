package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v4.view.ah;
import android.support.v4.view.ao;
import android.support.v4.view.bo;
import android.support.v4.view.bw;
import android.support.v4.widget.am;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.view.menu.C0211t.C0770a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements ag, ao {
    static final int[] f3075a = new int[]{C0831a.actionBarSize, 16842841};
    private final Runnable f3076A;
    private final ah f3077B;
    private int f3078b;
    private int f3079c;
    private ContentFrameLayout f3080d;
    private ActionBarContainer f3081e;
    private ap f3082f;
    private Drawable f3083g;
    private boolean f3084h;
    private boolean f3085i;
    private boolean f3086j;
    private boolean f3087k;
    private boolean f3088l;
    private int f3089m;
    private int f3090n;
    private final Rect f3091o;
    private final Rect f3092p;
    private final Rect f3093q;
    private final Rect f3094r;
    private final Rect f3095s;
    private final Rect f3096t;
    private C0780a f3097u;
    private final int f3098v;
    private am f3099w;
    private bo f3100x;
    private final bw f3101y;
    private final Runnable f3102z;

    public interface C0780a {
        void mo768b(int i);

        void mo771i(boolean z);

        void mo772l();

        void mo773m();

        void mo774n();

        void mo775o();
    }

    public static class C0897b extends MarginLayoutParams {
        public C0897b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0897b(int i, int i2) {
            super(i, i2);
        }

        public C0897b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m5821b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m5817a(attributeSet);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3079c = 0;
        this.f3091o = new Rect();
        this.f3092p = new Rect();
        this.f3093q = new Rect();
        this.f3094r = new Rect();
        this.f3095s = new Rect();
        this.f3096t = new Rect();
        this.f3098v = 600;
        this.f3101y = new C0984e(this);
        this.f3102z = new C0985f(this);
        this.f3076A = new C0986g(this);
        m5805a(context);
        this.f3077B = new ah(this);
    }

    private void m5805a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f3075a);
        this.f3078b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3083g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f3083g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f3084h = z;
        this.f3099w = am.m4761a(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m5812k();
    }

    public void setActionBarVisibilityCallback(C0780a c0780a) {
        this.f3097u = c0780a;
        if (getWindowToken() != null) {
            this.f3097u.mo768b(this.f3079c);
            if (this.f3090n != 0) {
                onWindowSystemUiVisibilityChanged(this.f3090n);
                ao.m3954x(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f3085i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f3084h = z2;
    }

    public boolean m5820a() {
        return this.f3085i;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f3086j = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m5805a(getContext());
        ao.m3954x(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m5822c();
        int i2 = this.f3090n ^ i;
        this.f3090n = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f3097u != null) {
            C0780a c0780a = this.f3097u;
            if (z) {
                z2 = false;
            }
            c0780a.mo771i(z2);
            if (z3 || !z) {
                this.f3097u.mo772l();
            } else {
                this.f3097u.mo773m();
            }
        }
        if ((i2 & 256) != 0 && this.f3097u != null) {
            ao.m3954x(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f3079c = i;
        if (this.f3097u != null) {
            this.f3097u.mo768b(i);
        }
    }

    private boolean m5809a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0897b c0897b = (C0897b) view.getLayoutParams();
        if (z && c0897b.leftMargin != rect.left) {
            c0897b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0897b.topMargin != rect.top) {
            c0897b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0897b.rightMargin != rect.right) {
            c0897b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0897b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0897b.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m5822c();
        if ((ao.m3953w(this) & 256) != 0) {
            a = m5809a(this.f3081e, rect, true, true, false, true);
            this.f3094r.set(rect);
            C0983do.m7163a(this, this.f3094r, this.f3091o);
        } else {
            a = m5809a(this.f3081e, rect, true, true, false, true);
            this.f3094r.set(rect);
            C0983do.m7163a(this, this.f3094r, this.f3091o);
        }
        if (!this.f3092p.equals(this.f3091o)) {
            this.f3092p.set(this.f3091o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected C0897b m5821b() {
        return new C0897b(-1, -1);
    }

    public C0897b m5817a(AttributeSet attributeSet) {
        return new C0897b(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0897b(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0897b;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int i3;
        m5822c();
        measureChildWithMargins(this.f3081e, i, 0, i2, 0);
        C0897b c0897b = (C0897b) this.f3081e.getLayoutParams();
        int max = Math.max(0, (this.f3081e.getMeasuredWidth() + c0897b.leftMargin) + c0897b.rightMargin);
        int max2 = Math.max(0, c0897b.bottomMargin + (this.f3081e.getMeasuredHeight() + c0897b.topMargin));
        int a = C0983do.m7162a(0, ao.m3942l(this.f3081e));
        if ((ao.m3953w(this) & 256) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i3 = this.f3078b;
            if (this.f3086j && this.f3081e.getTabContainer() != null) {
                i3 += this.f3078b;
            }
        } else {
            i3 = this.f3081e.getVisibility() != 8 ? this.f3081e.getMeasuredHeight() : 0;
        }
        this.f3093q.set(this.f3091o);
        this.f3095s.set(this.f3094r);
        Rect rect;
        Rect rect2;
        if (this.f3085i || obj != null) {
            rect = this.f3095s;
            rect.top = i3 + rect.top;
            rect2 = this.f3095s;
            rect2.bottom += 0;
        } else {
            rect = this.f3093q;
            rect.top = i3 + rect.top;
            rect2 = this.f3093q;
            rect2.bottom += 0;
        }
        m5809a(this.f3080d, this.f3093q, true, true, true, true);
        if (!this.f3096t.equals(this.f3095s)) {
            this.f3096t.set(this.f3095s);
            this.f3080d.m5455a(this.f3095s);
        }
        measureChildWithMargins(this.f3080d, i, 0, i2, 0);
        c0897b = (C0897b) this.f3080d.getLayoutParams();
        int max3 = Math.max(max, (this.f3080d.getMeasuredWidth() + c0897b.leftMargin) + c0897b.rightMargin);
        i3 = Math.max(max2, c0897b.bottomMargin + (this.f3080d.getMeasuredHeight() + c0897b.topMargin));
        int a2 = C0983do.m7162a(a, ao.m3942l(this.f3080d));
        setMeasuredDimension(ao.m3900a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ao.m3900a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0897b c0897b = (C0897b) childAt.getLayoutParams();
                int i6 = c0897b.leftMargin + paddingLeft;
                paddingRight = c0897b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3083g != null && !this.f3084h) {
            int bottom = this.f3081e.getVisibility() == 0 ? (int) ((((float) this.f3081e.getBottom()) + ao.m3946p(this.f3081e)) + 0.5f) : 0;
            this.f3083g.setBounds(0, bottom, getWidth(), this.f3083g.getIntrinsicHeight() + bottom);
            this.f3083g.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f3081e.getVisibility() != 0) {
            return false;
        }
        return this.f3087k;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3077B.m3662a(view, view2, i);
        this.f3089m = getActionBarHideOffset();
        m5812k();
        if (this.f3097u != null) {
            this.f3097u.mo774n();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f3089m += i2;
        setActionBarHideOffset(this.f3089m);
    }

    public void onStopNestedScroll(View view) {
        if (this.f3087k && !this.f3088l) {
            if (this.f3089m <= this.f3081e.getHeight()) {
                m5813l();
            } else {
                m5814m();
            }
        }
        if (this.f3097u != null) {
            this.f3097u.mo775o();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f3087k || !z) {
            return false;
        }
        if (m5807a(f, f2)) {
            m5816o();
        } else {
            m5815n();
        }
        this.f3088l = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f3077B.m3660a();
    }

    void m5822c() {
        if (this.f3080d == null) {
            this.f3080d = (ContentFrameLayout) findViewById(C0836f.action_bar_activity_content);
            this.f3081e = (ActionBarContainer) findViewById(C0836f.action_bar_container);
            this.f3082f = m5804a(findViewById(C0836f.action_bar));
        }
    }

    private ap m5804a(View view) {
        if (view instanceof ap) {
            return (ap) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f3087k) {
            this.f3087k = z;
            if (!z) {
                m5812k();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f3081e != null ? -((int) ao.m3946p(this.f3081e)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        m5812k();
        ao.m3920b(this.f3081e, (float) (-Math.max(0, Math.min(i, this.f3081e.getHeight()))));
    }

    private void m5812k() {
        removeCallbacks(this.f3102z);
        removeCallbacks(this.f3076A);
        if (this.f3100x != null) {
            this.f3100x.m4196b();
        }
    }

    private void m5813l() {
        m5812k();
        postDelayed(this.f3102z, 600);
    }

    private void m5814m() {
        m5812k();
        postDelayed(this.f3076A, 600);
    }

    private void m5815n() {
        m5812k();
        this.f3102z.run();
    }

    private void m5816o() {
        m5812k();
        this.f3076A.run();
    }

    private boolean m5807a(float f, float f2) {
        this.f3099w.m4765a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f3099w.m4772e() > this.f3081e.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Callback callback) {
        m5822c();
        this.f3082f.mo1060a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m5822c();
        this.f3082f.mo1061a(charSequence);
    }

    public CharSequence getTitle() {
        m5822c();
        return this.f3082f.mo1071e();
    }

    public void mo896a(int i) {
        m5822c();
        switch (i) {
            case 2:
                this.f3082f.mo1073f();
                return;
            case 5:
                this.f3082f.mo1074g();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m5822c();
        this.f3082f.mo1055a(i);
    }

    public void setIcon(Drawable drawable) {
        m5822c();
        this.f3082f.mo1056a(drawable);
    }

    public void setLogo(int i) {
        m5822c();
        this.f3082f.mo1064b(i);
    }

    public boolean mo898d() {
        m5822c();
        return this.f3082f.mo1075h();
    }

    public boolean mo899e() {
        m5822c();
        return this.f3082f.mo1076i();
    }

    public boolean mo900f() {
        m5822c();
        return this.f3082f.mo1077j();
    }

    public boolean mo901g() {
        m5822c();
        return this.f3082f.mo1078k();
    }

    public boolean mo902h() {
        m5822c();
        return this.f3082f.mo1079l();
    }

    public void mo903i() {
        m5822c();
        this.f3082f.mo1080m();
    }

    public void mo897a(Menu menu, C0770a c0770a) {
        m5822c();
        this.f3082f.mo1059a(menu, c0770a);
    }

    public void mo904j() {
        m5822c();
        this.f3082f.mo1081n();
    }
}
