package android.support.v7.p027a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.C0690f;
import android.support.v7.p018d.p019a.C0783b;
import android.support.v7.p027a.C0793d.C0792a;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class C0790b implements C0690f {
    private final C0781a f2572a;
    private final DrawerLayout f2573b;
    private C0784d f2574c;
    private Drawable f2575d;
    private boolean f2576e;
    private final int f2577f;
    private final int f2578g;
    private OnClickListener f2579h;
    private boolean f2580i;

    public interface C0781a {
        Drawable mo778a();

        void mo779a(int i);

        void mo780a(Drawable drawable, int i);

        Context mo781b();

        boolean mo782c();
    }

    public interface C0782b {
        C0781a mo791b();
    }

    interface C0784d {
        void mo777a(float f);
    }

    static class C0785c extends C0783b implements C0784d {
        private final Activity f2564a;

        public C0785c(Activity activity, Context context) {
            super(context);
            this.f2564a = activity;
        }

        public void mo777a(float f) {
            if (f == 1.0f) {
                m5188b(true);
            } else if (f == 0.0f) {
                m5188b(false);
            }
            m5190d(f);
        }
    }

    static class C0786e implements C0781a {
        final Activity f2565a;

        C0786e(Activity activity) {
            this.f2565a = activity;
        }

        public void mo780a(Drawable drawable, int i) {
        }

        public void mo779a(int i) {
        }

        public Drawable mo778a() {
            return null;
        }

        public Context mo781b() {
            return this.f2565a;
        }

        public boolean mo782c() {
            return true;
        }
    }

    private static class C0787f implements C0781a {
        final Activity f2566a;
        C0792a f2567b;

        private C0787f(Activity activity) {
            this.f2566a = activity;
        }

        public Drawable mo778a() {
            return C0793d.m5225a(this.f2566a);
        }

        public Context mo781b() {
            ActionBar actionBar = this.f2566a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f2566a;
        }

        public boolean mo782c() {
            ActionBar actionBar = this.f2566a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void mo780a(Drawable drawable, int i) {
            this.f2566a.getActionBar().setDisplayShowHomeEnabled(true);
            this.f2567b = C0793d.m5227a(this.f2567b, this.f2566a, drawable, i);
            this.f2566a.getActionBar().setDisplayShowHomeEnabled(false);
        }

        public void mo779a(int i) {
            this.f2567b = C0793d.m5226a(this.f2567b, this.f2566a, i);
        }
    }

    private static class C0788g implements C0781a {
        final Activity f2568a;

        private C0788g(Activity activity) {
            this.f2568a = activity;
        }

        public Drawable mo778a() {
            TypedArray obtainStyledAttributes = mo781b().obtainStyledAttributes(null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public Context mo781b() {
            ActionBar actionBar = this.f2568a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f2568a;
        }

        public boolean mo782c() {
            ActionBar actionBar = this.f2568a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void mo780a(Drawable drawable, int i) {
            ActionBar actionBar = this.f2568a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }

        public void mo779a(int i) {
            ActionBar actionBar = this.f2568a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    static class C0789h implements C0781a {
        final Toolbar f2569a;
        final Drawable f2570b;
        final CharSequence f2571c;

        C0789h(Toolbar toolbar) {
            this.f2569a = toolbar;
            this.f2570b = toolbar.getNavigationIcon();
            this.f2571c = toolbar.getNavigationContentDescription();
        }

        public void mo780a(Drawable drawable, int i) {
            this.f2569a.setNavigationIcon(drawable);
            mo779a(i);
        }

        public void mo779a(int i) {
            if (i == 0) {
                this.f2569a.setNavigationContentDescription(this.f2571c);
            } else {
                this.f2569a.setNavigationContentDescription(i);
            }
        }

        public Drawable mo778a() {
            return this.f2570b;
        }

        public Context mo781b() {
            return this.f2569a.getContext();
        }

        public boolean mo782c() {
            return true;
        }
    }

    public C0790b(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
        this(activity, toolbar, drawerLayout, null, i, i2);
    }

    <T extends Drawable & C0784d> C0790b(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, T t, int i, int i2) {
        this.f2576e = true;
        this.f2580i = false;
        if (toolbar != null) {
            this.f2572a = new C0789h(toolbar);
            toolbar.setNavigationOnClickListener(new C0791c(this));
        } else if (activity instanceof C0782b) {
            this.f2572a = ((C0782b) activity).mo791b();
        } else if (VERSION.SDK_INT >= 18) {
            this.f2572a = new C0788g(activity);
        } else if (VERSION.SDK_INT >= 11) {
            this.f2572a = new C0787f(activity);
        } else {
            this.f2572a = new C0786e(activity);
        }
        this.f2573b = drawerLayout;
        this.f2577f = i;
        this.f2578g = i2;
        if (t == null) {
            this.f2574c = new C0785c(activity, this.f2572a.mo781b());
        } else {
            this.f2574c = (C0784d) t;
        }
        this.f2575d = m5222b();
    }

    public void m5217a() {
        if (this.f2573b.m4503g(8388611)) {
            this.f2574c.mo777a(1.0f);
        } else {
            this.f2574c.mo777a(0.0f);
        }
        if (this.f2576e) {
            m5219a((Drawable) this.f2574c, this.f2573b.m4503g(8388611) ? this.f2578g : this.f2577f);
        }
    }

    private void m5216c() {
        int a = this.f2573b.m4475a(8388611);
        if (this.f2573b.m4506h(8388611) && a != 2) {
            this.f2573b.m4501f(8388611);
        } else if (a != 1) {
            this.f2573b.m4500e(8388611);
        }
    }

    public void mo785a(View view, float f) {
        this.f2574c.mo777a(Math.min(1.0f, Math.max(0.0f, f)));
    }

    public void mo784a(View view) {
        this.f2574c.mo777a(1.0f);
        if (this.f2576e) {
            m5223b(this.f2578g);
        }
    }

    public void mo786b(View view) {
        this.f2574c.mo777a(0.0f);
        if (this.f2576e) {
            m5223b(this.f2577f);
        }
    }

    public void mo783a(int i) {
    }

    void m5219a(Drawable drawable, int i) {
        if (!(this.f2580i || this.f2572a.mo782c())) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f2580i = true;
        }
        this.f2572a.mo780a(drawable, i);
    }

    void m5223b(int i) {
        this.f2572a.mo779a(i);
    }

    Drawable m5222b() {
        return this.f2572a.mo778a();
    }
}
