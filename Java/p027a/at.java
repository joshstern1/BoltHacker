package android.support.v7.p027a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ao;
import android.support.v4.view.bo;
import android.support.v4.view.bw;
import android.support.v4.view.by;
import android.support.v7.p027a.C0760a.C0758b;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.C0778b;
import android.support.v7.view.C0778b.C0825a;
import android.support.v7.view.C0851a;
import android.support.v7.view.C0859g;
import android.support.v7.view.C0860h;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0197k.C0253a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0780a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ap;
import android.support.v7.widget.ce;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class at extends C0760a implements C0780a {
    static final /* synthetic */ boolean f2513h = (!at.class.desiredAssertionStatus());
    private static final Interpolator f2514i = new AccelerateInterpolator();
    private static final Interpolator f2515j = new DecelerateInterpolator();
    private static final boolean f2516k;
    private boolean f2517A;
    private int f2518B = 0;
    private boolean f2519C = true;
    private boolean f2520D;
    private boolean f2521E;
    private boolean f2522F;
    private boolean f2523G = true;
    private C0860h f2524H;
    private boolean f2525I;
    C0779a f2526a;
    C0778b f2527b;
    C0825a f2528c;
    boolean f2529d;
    final bw f2530e = new au(this);
    final bw f2531f = new av(this);
    final by f2532g = new aw(this);
    private Context f2533l;
    private Context f2534m;
    private Activity f2535n;
    private Dialog f2536o;
    private ActionBarOverlayLayout f2537p;
    private ActionBarContainer f2538q;
    private ap f2539r;
    private ActionBarContextView f2540s;
    private View f2541t;
    private ce f2542u;
    private ArrayList<Object> f2543v = new ArrayList();
    private int f2544w = -1;
    private boolean f2545x;
    private boolean f2546y;
    private ArrayList<C0758b> f2547z = new ArrayList();

    public class C0779a extends C0778b implements C0253a {
        final /* synthetic */ at f2508a;
        private final Context f2509b;
        private final C0197k f2510c;
        private C0825a f2511d;
        private WeakReference<View> f2512e;

        public C0779a(at atVar, Context context, C0825a c0825a) {
            this.f2508a = atVar;
            this.f2509b = context;
            this.f2511d = c0825a;
            this.f2510c = new C0197k(context).m1284a(1);
            this.f2510c.mo161a((C0253a) this);
        }

        public MenuInflater mo753a() {
            return new C0859g(this.f2509b);
        }

        public Menu mo758b() {
            return this.f2510c;
        }

        public void mo761c() {
            if (this.f2508a.f2526a == this) {
                if (at.m5129b(this.f2508a.f2520D, this.f2508a.f2521E, false)) {
                    this.f2511d.mo840a(this);
                } else {
                    this.f2508a.f2527b = this;
                    this.f2508a.f2528c = this.f2511d;
                }
                this.f2511d = null;
                this.f2508a.m5171l(false);
                this.f2508a.f2540s.m5791b();
                this.f2508a.f2539r.mo1054a().sendAccessibilityEvent(32);
                this.f2508a.f2537p.setHideOnContentScrollEnabled(this.f2508a.f2529d);
                this.f2508a.f2526a = null;
            }
        }

        public void mo762d() {
            if (this.f2508a.f2526a == this) {
                this.f2510c.m1320g();
                try {
                    this.f2511d.mo843b(this, this.f2510c);
                } finally {
                    this.f2510c.m1321h();
                }
            }
        }

        public boolean m5112e() {
            this.f2510c.m1320g();
            try {
                boolean a = this.f2511d.mo841a((C0778b) this, this.f2510c);
                return a;
            } finally {
                this.f2510c.m1321h();
            }
        }

        public void mo755a(View view) {
            this.f2508a.f2540s.setCustomView(view);
            this.f2512e = new WeakReference(view);
        }

        public void mo756a(CharSequence charSequence) {
            this.f2508a.f2540s.setSubtitle(charSequence);
        }

        public void mo760b(CharSequence charSequence) {
            this.f2508a.f2540s.setTitle(charSequence);
        }

        public void mo754a(int i) {
            mo760b(this.f2508a.f2533l.getResources().getString(i));
        }

        public void mo759b(int i) {
            mo756a(this.f2508a.f2533l.getResources().getString(i));
        }

        public CharSequence mo763f() {
            return this.f2508a.f2540s.getTitle();
        }

        public CharSequence mo764g() {
            return this.f2508a.f2540s.getSubtitle();
        }

        public void mo757a(boolean z) {
            super.mo757a(z);
            this.f2508a.f2540s.setTitleOptional(z);
        }

        public boolean mo765h() {
            return this.f2508a.f2540s.m5793d();
        }

        public View mo766i() {
            return this.f2512e != null ? (View) this.f2512e.get() : null;
        }

        public boolean mo223a(C0197k c0197k, MenuItem menuItem) {
            if (this.f2511d != null) {
                return this.f2511d.mo842a((C0778b) this, menuItem);
            }
            return false;
        }

        public void mo222a(C0197k c0197k) {
            if (this.f2511d != null) {
                mo762d();
                this.f2508a.f2540s.mo889a();
            }
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f2516k = z;
    }

    public at(Activity activity, boolean z) {
        this.f2535n = activity;
        View decorView = activity.getWindow().getDecorView();
        m5124a(decorView);
        if (!z) {
            this.f2541t = decorView.findViewById(16908290);
        }
    }

    public at(Dialog dialog) {
        this.f2536o = dialog;
        m5124a(dialog.getWindow().getDecorView());
    }

    private void m5124a(View view) {
        this.f2537p = (ActionBarOverlayLayout) view.findViewById(C0836f.decor_content_parent);
        if (this.f2537p != null) {
            this.f2537p.setActionBarVisibilityCallback(this);
        }
        this.f2539r = m5127b(view.findViewById(C0836f.action_bar));
        this.f2540s = (ActionBarContextView) view.findViewById(C0836f.action_context_bar);
        this.f2538q = (ActionBarContainer) view.findViewById(C0836f.action_bar_container);
        if (this.f2539r == null || this.f2540s == null || this.f2538q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f2533l = this.f2539r.mo1063b();
        boolean z = (this.f2539r.mo1082o() & 4) != 0;
        if (z) {
            this.f2545x = true;
        }
        C0851a a = C0851a.m5478a(this.f2533l);
        if (a.m5484f() || z) {
            z = true;
        } else {
            z = false;
        }
        mo744d(z);
        m5137m(a.m5482d());
        TypedArray obtainStyledAttributes = this.f2533l.obtainStyledAttributes(null, C0841k.ActionBar, C0831a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0841k.ActionBar_hideOnContentScroll, false)) {
            mo770e(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0841k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo733a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ap m5127b(View view) {
        if (view instanceof ap) {
            return (ap) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public void mo733a(float f) {
        ao.m3935f(this.f2538q, f);
    }

    public void mo735a(Configuration configuration) {
        m5137m(C0851a.m5478a(this.f2533l).m5482d());
    }

    private void m5137m(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.f2517A = z;
        if (this.f2517A) {
            this.f2538q.setTabContainer(null);
            this.f2539r.mo1058a(this.f2542u);
        } else {
            this.f2539r.mo1058a(null);
            this.f2538q.setTabContainer(this.f2542u);
        }
        if (m5166j() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f2542u != null) {
            if (z2) {
                this.f2542u.setVisibility(0);
                if (this.f2537p != null) {
                    ao.m3954x(this.f2537p);
                }
            } else {
                this.f2542u.setVisibility(8);
            }
        }
        ap apVar = this.f2539r;
        if (this.f2517A || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        apVar.mo1062a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2537p;
        if (this.f2517A || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    void m5164i() {
        if (this.f2528c != null) {
            this.f2528c.mo840a(this.f2527b);
            this.f2527b = null;
            this.f2528c = null;
        }
    }

    public void mo768b(int i) {
        this.f2518B = i;
    }

    public void mo748g(boolean z) {
        this.f2525I = z;
        if (!z && this.f2524H != null) {
            this.f2524H.m5542b();
        }
    }

    public void mo751h(boolean z) {
        if (z != this.f2546y) {
            this.f2546y = z;
            int size = this.f2547z.size();
            for (int i = 0; i < size; i++) {
                ((C0758b) this.f2547z.get(i)).m4961a(z);
            }
        }
    }

    public void mo738a(boolean z) {
        m5146a(z ? 2 : 0, 2);
    }

    public void mo740b(boolean z) {
        m5146a(z ? 4 : 0, 4);
    }

    public void mo743c(boolean z) {
        m5146a(z ? 8 : 0, 8);
    }

    public void mo744d(boolean z) {
        this.f2539r.mo1066b(z);
    }

    public void mo737a(CharSequence charSequence) {
        this.f2539r.mo1061a(charSequence);
    }

    public boolean mo749g() {
        ViewGroup a = this.f2539r.mo1054a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m5146a(int i, int i2) {
        int o = this.f2539r.mo1082o();
        if ((i2 & 4) != 0) {
            this.f2545x = true;
        }
        this.f2539r.mo1067c((o & (i2 ^ -1)) | (i & i2));
    }

    public int m5166j() {
        return this.f2539r.mo1083p();
    }

    public int mo732a() {
        return this.f2539r.mo1082o();
    }

    public C0778b mo767a(C0825a c0825a) {
        if (this.f2526a != null) {
            this.f2526a.mo761c();
        }
        this.f2537p.setHideOnContentScrollEnabled(false);
        this.f2540s.m5792c();
        C0778b c0779a = new C0779a(this, this.f2540s.getContext(), c0825a);
        if (!c0779a.m5112e()) {
            return null;
        }
        this.f2526a = c0779a;
        c0779a.mo762d();
        this.f2540s.m5789a(c0779a);
        m5171l(true);
        this.f2540s.sendAccessibilityEvent(32);
        return c0779a;
    }

    public int m5168k() {
        return this.f2538q.getHeight();
    }

    public void mo771i(boolean z) {
        this.f2519C = z;
    }

    private void m5139p() {
        if (!this.f2522F) {
            this.f2522F = true;
            if (this.f2537p != null) {
                this.f2537p.setShowingForActionMode(true);
            }
            m5138n(false);
        }
    }

    public void mo772l() {
        if (this.f2521E) {
            this.f2521E = false;
            m5138n(true);
        }
    }

    private void m5140q() {
        if (this.f2522F) {
            this.f2522F = false;
            if (this.f2537p != null) {
                this.f2537p.setShowingForActionMode(false);
            }
            m5138n(false);
        }
    }

    public void mo773m() {
        if (!this.f2521E) {
            this.f2521E = true;
            m5138n(true);
        }
    }

    public void mo770e(boolean z) {
        if (!z || this.f2537p.m5820a()) {
            this.f2529d = z;
            this.f2537p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public int mo769d() {
        return this.f2537p.getActionBarHideOffset();
    }

    private static boolean m5129b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void m5138n(boolean z) {
        if (at.m5129b(this.f2520D, this.f2521E, this.f2522F)) {
            if (!this.f2523G) {
                this.f2523G = true;
                m5167j(z);
            }
        } else if (this.f2523G) {
            this.f2523G = false;
            m5169k(z);
        }
    }

    public void m5167j(boolean z) {
        if (this.f2524H != null) {
            this.f2524H.m5542b();
        }
        this.f2538q.setVisibility(0);
        if (this.f2518B == 0 && f2516k && (this.f2525I || z)) {
            ao.m3920b(this.f2538q, 0.0f);
            float f = (float) (-this.f2538q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f2538q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ao.m3920b(this.f2538q, f);
            C0860h c0860h = new C0860h();
            bo c = ao.m3950t(this.f2538q).m4197c(0.0f);
            c.m4192a(this.f2532g);
            c0860h.m5537a(c);
            if (this.f2519C && this.f2541t != null) {
                ao.m3920b(this.f2541t, f);
                c0860h.m5537a(ao.m3950t(this.f2541t).m4197c(0.0f));
            }
            c0860h.m5540a(f2515j);
            c0860h.m5536a(250);
            c0860h.m5539a(this.f2531f);
            this.f2524H = c0860h;
            c0860h.m5541a();
        } else {
            ao.m3924c(this.f2538q, 1.0f);
            ao.m3920b(this.f2538q, 0.0f);
            if (this.f2519C && this.f2541t != null) {
                ao.m3920b(this.f2541t, 0.0f);
            }
            this.f2531f.mo235b(null);
        }
        if (this.f2537p != null) {
            ao.m3954x(this.f2537p);
        }
    }

    public void m5169k(boolean z) {
        if (this.f2524H != null) {
            this.f2524H.m5542b();
        }
        if (this.f2518B == 0 && f2516k && (this.f2525I || z)) {
            ao.m3924c(this.f2538q, 1.0f);
            this.f2538q.setTransitioning(true);
            C0860h c0860h = new C0860h();
            float f = (float) (-this.f2538q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f2538q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            bo c = ao.m3950t(this.f2538q).m4197c(f);
            c.m4192a(this.f2532g);
            c0860h.m5537a(c);
            if (this.f2519C && this.f2541t != null) {
                c0860h.m5537a(ao.m3950t(this.f2541t).m4197c(f));
            }
            c0860h.m5540a(f2514i);
            c0860h.m5536a(250);
            c0860h.m5539a(this.f2530e);
            this.f2524H = c0860h;
            c0860h.m5541a();
            return;
        }
        this.f2530e.mo235b(null);
    }

    public boolean mo741b() {
        int k = m5168k();
        return this.f2523G && (k == 0 || mo769d() < k);
    }

    public void m5171l(boolean z) {
        if (z) {
            m5139p();
        } else {
            m5140q();
        }
        if (m5141r()) {
            bo a;
            bo a2;
            if (z) {
                a = this.f2539r.mo1053a(4, 100);
                a2 = this.f2540s.mo888a(0, 200);
            } else {
                a2 = this.f2539r.mo1053a(0, 200);
                a = this.f2540s.mo888a(8, 100);
            }
            C0860h c0860h = new C0860h();
            c0860h.m5538a(a, a2);
            c0860h.m5541a();
        } else if (z) {
            this.f2539r.mo1072e(4);
            this.f2540s.setVisibility(0);
        } else {
            this.f2539r.mo1072e(0);
            this.f2540s.setVisibility(8);
        }
    }

    private boolean m5141r() {
        return ao.m3895G(this.f2538q);
    }

    public Context mo742c() {
        if (this.f2534m == null) {
            TypedValue typedValue = new TypedValue();
            this.f2533l.getTheme().resolveAttribute(C0831a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f2534m = new ContextThemeWrapper(this.f2533l, i);
            } else {
                this.f2534m = this.f2533l;
            }
        }
        return this.f2534m;
    }

    public void mo736a(Drawable drawable) {
        this.f2539r.mo1065b(drawable);
    }

    public void mo734a(int i) {
        this.f2539r.mo1070d(i);
    }

    public void mo774n() {
        if (this.f2524H != null) {
            this.f2524H.m5542b();
            this.f2524H = null;
        }
    }

    public void mo775o() {
    }

    public boolean mo747f() {
        if (this.f2539r == null || !this.f2539r.mo1068c()) {
            return false;
        }
        this.f2539r.mo1069d();
        return true;
    }

    public void mo746f(boolean z) {
        if (!this.f2545x) {
            mo740b(z);
        }
    }
}
