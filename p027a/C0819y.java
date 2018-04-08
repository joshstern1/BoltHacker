package android.support.v7.p027a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.aq;
import android.support.v4.view.C0403s;
import android.support.v4.view.C0658o;
import android.support.v4.view.bo;
import android.support.v4.widget.ag;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0833c;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.p028b.C0842a.C0840j;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.C0778b;
import android.support.v7.view.C0778b.C0825a;
import android.support.v7.view.C0853d;
import android.support.v7.view.C0854e;
import android.support.v7.view.menu.C0195u;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0197k.C0253a;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.view.menu.C0879i;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0983do;
import android.support.v7.widget.C1011w;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ao;
import android.support.v7.widget.bb;
import android.support.v7.widget.dm;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class C0819y extends C0814s implements C0403s, C0253a {
    private boolean f2720A;
    private C0828d[] f2721B;
    private C0828d f2722C;
    private boolean f2723D;
    private boolean f2724E;
    private int f2725F;
    private final Runnable f2726G = new C0830z(this);
    private boolean f2727H;
    private Rect f2728I;
    private Rect f2729J;
    private ai f2730K;
    C0778b f2731m;
    ActionBarContextView f2732n;
    PopupWindow f2733o;
    Runnable f2734p;
    bo f2735q = null;
    private ao f2736r;
    private C0824a f2737s;
    private C0829e f2738t;
    private boolean f2739u;
    private ViewGroup f2740v;
    private TextView f2741w;
    private View f2742x;
    private boolean f2743y;
    private boolean f2744z;

    private final class C0824a implements C0770a {
        final /* synthetic */ C0819y f2750a;

        private C0824a(C0819y c0819y) {
            this.f2750a = c0819y;
        }

        public boolean mo729a(C0197k c0197k) {
            Callback q = this.f2750a.m5358q();
            if (q != null) {
                q.onMenuOpened(108, c0197k);
            }
            return true;
        }

        public void mo728a(C0197k c0197k, boolean z) {
            this.f2750a.m5378b(c0197k);
        }
    }

    class C0826b implements C0825a {
        final /* synthetic */ C0819y f2751a;
        private C0825a f2752b;

        public C0826b(C0819y c0819y, C0825a c0825a) {
            this.f2751a = c0819y;
            this.f2752b = c0825a;
        }

        public boolean mo841a(C0778b c0778b, Menu menu) {
            return this.f2752b.mo841a(c0778b, menu);
        }

        public boolean mo843b(C0778b c0778b, Menu menu) {
            return this.f2752b.mo843b(c0778b, menu);
        }

        public boolean mo842a(C0778b c0778b, MenuItem menuItem) {
            return this.f2752b.mo842a(c0778b, menuItem);
        }

        public void mo840a(C0778b c0778b) {
            this.f2752b.mo840a(c0778b);
            if (this.f2751a.f2733o != null) {
                this.f2751a.b.getDecorView().removeCallbacks(this.f2751a.f2734p);
            }
            if (this.f2751a.f2732n != null) {
                this.f2751a.m5395x();
                this.f2751a.f2735q = android.support.v4.view.ao.m3950t(this.f2751a.f2732n).m4189a(0.0f);
                this.f2751a.f2735q.m4191a(new ag(this));
            }
            if (this.f2751a.e != null) {
                this.f2751a.e.mo725b(this.f2751a.f2731m);
            }
            this.f2751a.f2731m = null;
        }
    }

    private class C0827c extends ContentFrameLayout {
        final /* synthetic */ C0819y f2761a;

        public C0827c(C0819y c0819y, Context context) {
            this.f2761a = c0819y;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f2761a.mo824a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m5456a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f2761a.mo838d(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C1011w.m7254a().m7272a(getContext(), i));
        }

        private boolean m5456a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    protected static final class C0828d {
        int f2762a;
        int f2763b;
        int f2764c;
        int f2765d;
        int f2766e;
        int f2767f;
        ViewGroup f2768g;
        View f2769h;
        View f2770i;
        C0197k f2771j;
        C0879i f2772k;
        Context f2773l;
        boolean f2774m;
        boolean f2775n;
        boolean f2776o;
        public boolean f2777p;
        boolean f2778q = false;
        boolean f2779r;
        Bundle f2780s;

        C0828d(int i) {
            this.f2762a = i;
        }

        public boolean m5460a() {
            if (this.f2769h == null) {
                return false;
            }
            if (this.f2770i != null || this.f2772k.m5685d().getCount() > 0) {
                return true;
            }
            return false;
        }

        void m5458a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0831a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0831a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0840j.Theme_AppCompat_CompactMenu, true);
            }
            Context c0853d = new C0853d(context, 0);
            c0853d.getTheme().setTo(newTheme);
            this.f2773l = c0853d;
            TypedArray obtainStyledAttributes = c0853d.obtainStyledAttributes(C0841k.AppCompatTheme);
            this.f2763b = obtainStyledAttributes.getResourceId(C0841k.AppCompatTheme_panelBackground, 0);
            this.f2767f = obtainStyledAttributes.getResourceId(C0841k.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m5459a(C0197k c0197k) {
            if (c0197k != this.f2771j) {
                if (this.f2771j != null) {
                    this.f2771j.m1305b(this.f2772k);
                }
                this.f2771j = c0197k;
                if (c0197k != null && this.f2772k != null) {
                    c0197k.m1294a(this.f2772k);
                }
            }
        }

        C0195u m5457a(C0770a c0770a) {
            if (this.f2771j == null) {
                return null;
            }
            if (this.f2772k == null) {
                this.f2772k = new C0879i(this.f2773l, C0838h.abc_list_menu_item_layout);
                this.f2772k.mo152a(c0770a);
                this.f2771j.m1294a(this.f2772k);
            }
            return this.f2772k.m5671a(this.f2768g);
        }
    }

    private final class C0829e implements C0770a {
        final /* synthetic */ C0819y f2781a;

        private C0829e(C0819y c0819y) {
            this.f2781a = c0819y;
        }

        public void mo728a(C0197k c0197k, boolean z) {
            Menu menu;
            Menu p = c0197k.mo167p();
            boolean z2 = p != c0197k;
            C0819y c0819y = this.f2781a;
            if (z2) {
                menu = p;
            }
            C0828d a = c0819y.m5363a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.f2781a.m5364a(a.f2762a, a, p);
                this.f2781a.m5366a(a, true);
                return;
            }
            this.f2781a.m5366a(a, z);
        }

        public boolean mo729a(C0197k c0197k) {
            if (c0197k == null && this.f2781a.h) {
                Callback q = this.f2781a.m5358q();
                if (!(q == null || this.f2781a.m5357p())) {
                    q.onMenuOpened(108, c0197k);
                }
            }
            return true;
        }
    }

    C0819y(Context context, Window window, C0763q c0763q) {
        super(context, window, c0763q);
    }

    public void mo819a(Bundle bundle) {
        if ((this.c instanceof Activity) && aq.m2448b((Activity) this.c) != null) {
            C0760a m = m5354m();
            if (m == null) {
                this.f2727H = true;
            } else {
                m.mo746f(true);
            }
        }
    }

    public void mo826b(Bundle bundle) {
        m5392u();
    }

    public void mo835l() {
        m5392u();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new at((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new at((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.mo746f(this.f2727H);
            }
        }
    }

    public void mo820a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            C0760a a = mo806a();
            if (a instanceof at) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (a != null) {
                a.mo750h();
            }
            if (toolbar != null) {
                C0760a anVar = new an(toolbar, ((Activity) this.a).getTitle(), this.d);
                this.f = anVar;
                this.b.setCallback(anVar.m5072i());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            mo833e();
        }
    }

    public View mo816a(int i) {
        m5392u();
        return this.b.findViewById(i);
    }

    public void mo818a(Configuration configuration) {
        if (this.h && this.f2739u) {
            C0760a a = mo806a();
            if (a != null) {
                a.mo735a(configuration);
            }
        }
        mo812i();
    }

    public void mo830c() {
        C0760a a = mo806a();
        if (a != null) {
            a.mo748g(false);
        }
    }

    public void mo832d() {
        C0760a a = mo806a();
        if (a != null) {
            a.mo748g(true);
        }
    }

    public void mo821a(View view) {
        m5392u();
        ViewGroup viewGroup = (ViewGroup) this.f2740v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void mo825b(int i) {
        m5392u();
        ViewGroup viewGroup = (ViewGroup) this.f2740v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void mo822a(View view, LayoutParams layoutParams) {
        m5392u();
        ViewGroup viewGroup = (ViewGroup) this.f2740v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void mo827b(View view, LayoutParams layoutParams) {
        m5392u();
        ((ViewGroup) this.f2740v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void mo810f() {
        super.mo810f();
        if (this.f != null) {
            this.f.mo750h();
        }
    }

    private void m5392u() {
        if (!this.f2739u) {
            this.f2740v = m5393v();
            CharSequence r = m5359r();
            if (!TextUtils.isEmpty(r)) {
                mo828b(r);
            }
            m5394w();
            m5409a(this.f2740v);
            this.f2739u = true;
            C0828d a = m5398a(0, false);
            if (!m5357p()) {
                if (a == null || a.f2771j == null) {
                    m5387e(108);
                }
            }
        }
    }

    private ViewGroup m5393v() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0841k.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0841k.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0841k.AppCompatTheme_windowNoTitle, false)) {
                mo831c(1);
            } else if (obtainStyledAttributes.getBoolean(C0841k.AppCompatTheme_windowActionBar, false)) {
                mo831c(108);
            }
            if (obtainStyledAttributes.getBoolean(C0841k.AppCompatTheme_windowActionBarOverlay, false)) {
                mo831c(109);
            }
            if (obtainStyledAttributes.getBoolean(C0841k.AppCompatTheme_windowActionModeOverlay, false)) {
                mo831c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0841k.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2;
                if (this.j) {
                    view2 = (ViewGroup) from.inflate(C0838h.abc_screen_simple_overlay_action_mode, null);
                } else {
                    view2 = (ViewGroup) from.inflate(C0838h.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    android.support.v4.view.ao.m3910a(view2, new aa(this));
                    view = view2;
                } else {
                    ((bb) view2).setOnFitSystemWindowsListener(new ab(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0838h.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                Context c0853d;
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0831a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    c0853d = new C0853d(this.a, typedValue.resourceId);
                } else {
                    c0853d = this.a;
                }
                r0 = (ViewGroup) LayoutInflater.from(c0853d).inflate(C0838h.abc_screen_toolbar, null);
                this.f2736r = (ao) r0.findViewById(C0836f.decor_content_parent);
                this.f2736r.setWindowCallback(m5358q());
                if (this.i) {
                    this.f2736r.mo896a(109);
                }
                if (this.f2743y) {
                    this.f2736r.mo896a(2);
                }
                if (this.f2744z) {
                    this.f2736r.mo896a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f2736r == null) {
                this.f2741w = (TextView) view.findViewById(C0836f.title);
            }
            C0983do.m7165b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0836f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new ac(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    void m5409a(ViewGroup viewGroup) {
    }

    private void m5394w() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f2740v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m5454a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0841k.AppCompatTheme);
        obtainStyledAttributes.getValue(C0841k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0841k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0841k.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0841k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0841k.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0841k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0841k.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0841k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0841k.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0841k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean mo831c(int i) {
        int h = m5391h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                m5396y();
                this.l = true;
                return true;
            case 2:
                m5396y();
                this.f2743y = true;
                return true;
            case 5:
                m5396y();
                this.f2744z = true;
                return true;
            case 10:
                m5396y();
                this.j = true;
                return true;
            case 108:
                m5396y();
                this.h = true;
                return true;
            case 109:
                m5396y();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    void mo828b(CharSequence charSequence) {
        if (this.f2736r != null) {
            this.f2736r.setWindowTitle(charSequence);
        } else if (m5354m() != null) {
            m5354m().mo737a(charSequence);
        } else if (this.f2741w != null) {
            this.f2741w.setText(charSequence);
        }
    }

    void mo817a(int i, Menu menu) {
        if (i == 108) {
            C0760a a = mo806a();
            if (a != null) {
                a.mo751h(false);
            }
        } else if (i == 0) {
            C0828d a2 = m5398a(i, true);
            if (a2.f2776o) {
                m5366a(a2, false);
            }
        }
    }

    boolean mo829b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        C0760a a = mo806a();
        if (a == null) {
            return true;
        }
        a.mo751h(true);
        return true;
    }

    public boolean mo223a(C0197k c0197k, MenuItem menuItem) {
        Callback q = m5358q();
        if (!(q == null || m5357p())) {
            C0828d a = m5363a(c0197k.mo167p());
            if (a != null) {
                return q.onMenuItemSelected(a.f2762a, menuItem);
            }
        }
        return false;
    }

    public void mo222a(C0197k c0197k) {
        m5371a(c0197k, true);
    }

    public C0778b m5413b(C0825a c0825a) {
        if (c0825a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f2731m != null) {
            this.f2731m.mo761c();
        }
        C0825a c0826b = new C0826b(this, c0825a);
        C0760a a = mo806a();
        if (a != null) {
            this.f2731m = a.mo767a(c0826b);
            if (!(this.f2731m == null || this.e == null)) {
                this.e.mo724a(this.f2731m);
            }
        }
        if (this.f2731m == null) {
            this.f2731m = mo815a(c0826b);
        }
        return this.f2731m;
    }

    public void mo833e() {
        C0760a a = mo806a();
        if (a == null || !a.mo745e()) {
            m5387e(0);
        }
    }

    C0778b mo815a(C0825a c0825a) {
        C0778b c0778b;
        m5395x();
        if (this.f2731m != null) {
            this.f2731m.mo761c();
        }
        if (!(c0825a instanceof C0826b)) {
            c0825a = new C0826b(this, c0825a);
        }
        if (this.e == null || m5357p()) {
            c0778b = null;
        } else {
            try {
                c0778b = this.e.mo723a(c0825a);
            } catch (AbstractMethodError e) {
                c0778b = null;
            }
        }
        if (c0778b != null) {
            this.f2731m = c0778b;
        } else {
            if (this.f2732n == null) {
                if (this.k) {
                    Context c0853d;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0831a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0853d = new C0853d(this.a, 0);
                        c0853d.getTheme().setTo(newTheme);
                    } else {
                        c0853d = this.a;
                    }
                    this.f2732n = new ActionBarContextView(c0853d);
                    this.f2733o = new PopupWindow(c0853d, null, C0831a.actionModePopupWindowStyle);
                    ag.m4694a(this.f2733o, 2);
                    this.f2733o.setContentView(this.f2732n);
                    this.f2733o.setWidth(-1);
                    c0853d.getTheme().resolveAttribute(C0831a.actionBarSize, typedValue, true);
                    this.f2732n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0853d.getResources().getDisplayMetrics()));
                    this.f2733o.setHeight(-2);
                    this.f2734p = new ad(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f2740v.findViewById(C0836f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m5355n()));
                        this.f2732n = (ActionBarContextView) viewStubCompat.m6690a();
                    }
                }
            }
            if (this.f2732n != null) {
                boolean z;
                m5395x();
                this.f2732n.m5792c();
                Context context = this.f2732n.getContext();
                ActionBarContextView actionBarContextView = this.f2732n;
                if (this.f2733o == null) {
                    z = true;
                } else {
                    z = false;
                }
                C0778b c0854e = new C0854e(context, actionBarContextView, c0825a, z);
                if (c0825a.mo841a(c0854e, c0854e.mo758b())) {
                    c0854e.mo762d();
                    this.f2732n.m5789a(c0854e);
                    this.f2731m = c0854e;
                    if (m5430s()) {
                        android.support.v4.view.ao.m3924c(this.f2732n, 0.0f);
                        this.f2735q = android.support.v4.view.ao.m3950t(this.f2732n).m4189a(1.0f);
                        this.f2735q.m4191a(new af(this));
                    } else {
                        android.support.v4.view.ao.m3924c(this.f2732n, 1.0f);
                        this.f2732n.setVisibility(0);
                        this.f2732n.sendAccessibilityEvent(32);
                        if (this.f2732n.getParent() != null) {
                            android.support.v4.view.ao.m3954x((View) this.f2732n.getParent());
                        }
                    }
                    if (this.f2733o != null) {
                        this.b.getDecorView().post(this.f2734p);
                    }
                } else {
                    this.f2731m = null;
                }
            }
        }
        if (!(this.f2731m == null || this.e == null)) {
            this.e.mo724a(this.f2731m);
        }
        return this.f2731m;
    }

    final boolean m5430s() {
        return this.f2739u && this.f2740v != null && android.support.v4.view.ao.m3895G(this.f2740v);
    }

    private void m5395x() {
        if (this.f2735q != null) {
            this.f2735q.m4196b();
        }
    }

    boolean m5431t() {
        if (this.f2731m != null) {
            this.f2731m.mo761c();
            return true;
        }
        C0760a a = mo806a();
        if (a == null || !a.mo747f()) {
            return false;
        }
        return true;
    }

    boolean mo823a(int i, KeyEvent keyEvent) {
        C0760a a = mo806a();
        if (a != null && a.mo739a(i, keyEvent)) {
            return true;
        }
        if (this.f2722C == null || !m5373a(this.f2722C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f2722C == null) {
                C0828d a2 = m5398a(0, true);
                m5380b(a2, keyEvent);
                boolean a3 = m5373a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f2774m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f2722C == null) {
            return true;
        } else {
            this.f2722C.f2775n = true;
            return true;
        }
    }

    boolean mo824a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m5424c(keyCode, keyEvent) : m5419b(keyCode, keyEvent);
    }

    boolean m5419b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f2723D;
                this.f2723D = false;
                C0828d a = m5398a(0, false);
                if (a == null || !a.f2776o) {
                    if (m5431t()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m5366a(a, true);
                    return true;
                }
                break;
            case 82:
                m5388e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m5424c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f2723D = z;
                break;
            case 82:
                m5386d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            mo823a(i, keyEvent);
        }
        return false;
    }

    public View m5421c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = VERSION.SDK_INT < 21;
        if (this.f2730K == null) {
            this.f2730K = new ai();
        }
        if (z2 && m5375a((ViewParent) view)) {
            z = true;
        } else {
            z = false;
        }
        return this.f2730K.m5016a(view, str, context, attributeSet, z, z2, true, dm.m7140a());
    }

    private boolean m5375a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || android.support.v4.view.ao.m3897I((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    public void mo834h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0658o.m4325a(from, this);
        } else if (!(C0658o.m4324a(from) instanceof C0819y)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View mo379a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = mo836b(view, str, context, attributeSet);
        return b != null ? b : m5421c(view, str, context, attributeSet);
    }

    View mo836b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5365a(android.support.v7.p027a.C0819y.C0828d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f2776o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m5357p();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f2762a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m5358q();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f2762a;
        r5 = r11.f2771j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m5366a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m5380b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f2768g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f2778q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f2768g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m5372a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f2768g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m5383c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m5460a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f2769h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f2763b;
        r4 = r11.f2768g;
        r4.setBackgroundResource(r0);
        r0 = r11.f2769h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f2769h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f2768g;
        r4 = r11.f2769h;
        r0.addView(r4, r1);
        r0 = r11.f2769h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f2769h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f2775n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f2765d;
        r4 = r11.f2766e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f2764c;
        r0.gravity = r1;
        r1 = r11.f2767f;
        r0.windowAnimations = r1;
        r1 = r11.f2768g;
        r8.addView(r1, r0);
        r11.f2776o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f2778q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f2768g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f2768g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f2770i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f2770i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.y.a(android.support.v7.a.y$d, android.view.KeyEvent):void");
    }

    private boolean m5372a(C0828d c0828d) {
        c0828d.m5458a(m5355n());
        c0828d.f2768g = new C0827c(this, c0828d.f2773l);
        c0828d.f2764c = 81;
        return true;
    }

    private void m5371a(C0197k c0197k, boolean z) {
        if (this.f2736r == null || !this.f2736r.mo898d() || (android.support.v4.view.bb.m4087b(ViewConfiguration.get(this.a)) && !this.f2736r.mo900f())) {
            C0828d a = m5398a(0, true);
            a.f2778q = true;
            m5366a(a, false);
            m5365a(a, null);
            return;
        }
        Callback q = m5358q();
        if (this.f2736r.mo899e() && z) {
            this.f2736r.mo902h();
            if (!m5357p()) {
                q.onPanelClosed(108, m5398a(0, true).f2771j);
            }
        } else if (q != null && !m5357p()) {
            if (this.f2724E && (this.f2725F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f2726G);
                this.f2726G.run();
            }
            C0828d a2 = m5398a(0, true);
            if (a2.f2771j != null && !a2.f2779r && q.onPreparePanel(0, a2.f2770i, a2.f2771j)) {
                q.onMenuOpened(108, a2.f2771j);
                this.f2736r.mo901g();
            }
        }
    }

    private boolean m5379b(C0828d c0828d) {
        Context c0853d;
        C0197k c0197k;
        Context context = this.a;
        if ((c0828d.f2762a == 0 || c0828d.f2762a == 108) && this.f2736r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0831a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0831a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0831a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0853d = new C0853d(context, 0);
                c0853d.getTheme().setTo(theme3);
                c0197k = new C0197k(c0853d);
                c0197k.mo161a((C0253a) this);
                c0828d.m5459a(c0197k);
                return true;
            }
        }
        c0853d = context;
        c0197k = new C0197k(c0853d);
        c0197k.mo161a((C0253a) this);
        c0828d.m5459a(c0197k);
        return true;
    }

    private boolean m5383c(C0828d c0828d) {
        if (c0828d.f2770i != null) {
            c0828d.f2769h = c0828d.f2770i;
            return true;
        } else if (c0828d.f2771j == null) {
            return false;
        } else {
            if (this.f2738t == null) {
                this.f2738t = new C0829e();
            }
            c0828d.f2769h = (View) c0828d.m5457a(this.f2738t);
            return c0828d.f2769h != null;
        }
    }

    private boolean m5380b(C0828d c0828d, KeyEvent keyEvent) {
        if (m5357p()) {
            return false;
        }
        if (c0828d.f2774m) {
            return true;
        }
        if (!(this.f2722C == null || this.f2722C == c0828d)) {
            m5366a(this.f2722C, false);
        }
        Callback q = m5358q();
        if (q != null) {
            c0828d.f2770i = q.onCreatePanelView(c0828d.f2762a);
        }
        boolean z = c0828d.f2762a == 0 || c0828d.f2762a == 108;
        if (z && this.f2736r != null) {
            this.f2736r.mo903i();
        }
        if (c0828d.f2770i == null && !(z && (m5354m() instanceof an))) {
            if (c0828d.f2771j == null || c0828d.f2779r) {
                if (c0828d.f2771j == null && (!m5379b(c0828d) || c0828d.f2771j == null)) {
                    return false;
                }
                if (z && this.f2736r != null) {
                    if (this.f2737s == null) {
                        this.f2737s = new C0824a();
                    }
                    this.f2736r.mo897a(c0828d.f2771j, this.f2737s);
                }
                c0828d.f2771j.m1320g();
                if (q.onCreatePanelMenu(c0828d.f2762a, c0828d.f2771j)) {
                    c0828d.f2779r = false;
                } else {
                    c0828d.m5459a(null);
                    if (!z || this.f2736r == null) {
                        return false;
                    }
                    this.f2736r.mo897a(null, this.f2737s);
                    return false;
                }
            }
            c0828d.f2771j.m1320g();
            if (c0828d.f2780s != null) {
                c0828d.f2771j.m1315d(c0828d.f2780s);
                c0828d.f2780s = null;
            }
            if (q.onPreparePanel(0, c0828d.f2770i, c0828d.f2771j)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                c0828d.f2777p = z;
                c0828d.f2771j.setQwertyMode(c0828d.f2777p);
                c0828d.f2771j.m1321h();
            } else {
                if (z && this.f2736r != null) {
                    this.f2736r.mo897a(null, this.f2737s);
                }
                c0828d.f2771j.m1321h();
                return false;
            }
        }
        c0828d.f2774m = true;
        c0828d.f2775n = false;
        this.f2722C = c0828d;
        return true;
    }

    private void m5378b(C0197k c0197k) {
        if (!this.f2720A) {
            this.f2720A = true;
            this.f2736r.mo904j();
            Callback q = m5358q();
            if (!(q == null || m5357p())) {
                q.onPanelClosed(108, c0197k);
            }
            this.f2720A = false;
        }
    }

    private void mo838d(int i) {
        m5366a(m5398a(i, true), true);
    }

    private void m5366a(C0828d c0828d, boolean z) {
        if (z && c0828d.f2762a == 0 && this.f2736r != null && this.f2736r.mo899e()) {
            m5378b(c0828d.f2771j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !c0828d.f2776o || c0828d.f2768g == null)) {
            windowManager.removeView(c0828d.f2768g);
            if (z) {
                m5364a(c0828d.f2762a, c0828d, null);
            }
        }
        c0828d.f2774m = false;
        c0828d.f2775n = false;
        c0828d.f2776o = false;
        c0828d.f2769h = null;
        c0828d.f2778q = true;
        if (this.f2722C == c0828d) {
            this.f2722C = null;
        }
    }

    private boolean m5386d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0828d a = m5398a(i, true);
            if (!a.f2776o) {
                return m5380b(a, keyEvent);
            }
        }
        return false;
    }

    private boolean m5388e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f2731m != null) {
            return false;
        }
        C0828d a = m5398a(i, true);
        if (i != 0 || this.f2736r == null || !this.f2736r.mo898d() || android.support.v4.view.bb.m4087b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f2776o || a.f2775n) {
                z2 = a.f2776o;
                m5366a(a, true);
                z = z2;
            } else {
                if (a.f2774m) {
                    if (a.f2779r) {
                        a.f2774m = false;
                        z2 = m5380b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m5365a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f2736r.mo899e()) {
            z = this.f2736r.mo902h();
        } else {
            if (!m5357p() && m5380b(a, keyEvent)) {
                z = this.f2736r.mo901g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m5364a(int i, C0828d c0828d, Menu menu) {
        if (menu == null) {
            if (c0828d == null && i >= 0 && i < this.f2721B.length) {
                c0828d = this.f2721B[i];
            }
            if (c0828d != null) {
                menu = c0828d.f2771j;
            }
        }
        if ((c0828d == null || c0828d.f2776o) && !m5357p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    private C0828d m5363a(Menu menu) {
        C0828d[] c0828dArr = this.f2721B;
        int length = c0828dArr != null ? c0828dArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0828d c0828d = c0828dArr[i];
            if (c0828d != null && c0828d.f2771j == menu) {
                return c0828d;
            }
        }
        return null;
    }

    protected C0828d m5398a(int i, boolean z) {
        Object obj = this.f2721B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new C0828d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f2721B = obj2;
            obj = obj2;
        }
        C0828d c0828d = obj[i];
        if (c0828d != null) {
            return c0828d;
        }
        c0828d = new C0828d(i);
        obj[i] = c0828d;
        return c0828d;
    }

    private boolean m5373a(C0828d c0828d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((c0828d.f2774m || m5380b(c0828d, keyEvent)) && c0828d.f2771j != null) {
                z = c0828d.f2771j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f2736r == null) {
                m5366a(c0828d, true);
            }
        }
        return z;
    }

    private void m5387e(int i) {
        this.f2725F |= 1 << i;
        if (!this.f2724E) {
            android.support.v4.view.ao.m3913a(this.b.getDecorView(), this.f2726G);
            this.f2724E = true;
        }
    }

    private void m5389f(int i) {
        C0828d a = m5398a(i, true);
        if (a.f2771j != null) {
            Bundle bundle = new Bundle();
            a.f2771j.m1309c(bundle);
            if (bundle.size() > 0) {
                a.f2780s = bundle;
            }
            a.f2771j.m1320g();
            a.f2771j.clear();
        }
        a.f2779r = true;
        a.f2778q = true;
        if ((i == 108 || i == 0) && this.f2736r != null) {
            a = m5398a(0, false);
            if (a != null) {
                a.f2774m = false;
                m5380b(a, null);
            }
        }
    }

    private int m5390g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f2732n == null || !(this.f2732n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f2732n.getLayoutParams();
            if (this.f2732n.isShown()) {
                if (this.f2728I == null) {
                    this.f2728I = new Rect();
                    this.f2729J = new Rect();
                }
                Rect rect = this.f2728I;
                Rect rect2 = this.f2729J;
                rect.set(0, i, 0, 0);
                C0983do.m7163a(this.f2740v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f2742x == null) {
                        this.f2742x = new View(this.a);
                        this.f2742x.setBackgroundColor(this.a.getResources().getColor(C0833c.abc_input_method_navigation_guard));
                        this.f2740v.addView(this.f2742x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f2742x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f2742x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f2742x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f2732n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f2742x != null) {
            View view = this.f2742x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void m5396y() {
        if (this.f2739u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int m5391h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void m5397z() {
        if (this.f2736r != null) {
            this.f2736r.mo904j();
        }
        if (this.f2733o != null) {
            this.b.getDecorView().removeCallbacks(this.f2734p);
            if (this.f2733o.isShowing()) {
                try {
                    this.f2733o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f2733o = null;
        }
        m5395x();
        C0828d a = m5398a(0, false);
        if (a != null && a.f2771j != null) {
            a.f2771j.close();
        }
    }
}
