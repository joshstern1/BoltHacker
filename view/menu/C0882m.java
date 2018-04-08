package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p015d.p016a.C0462b;
import android.support.v4.view.C0641i;
import android.support.v4.view.C0675w.C0674e;
import android.support.v7.view.menu.C0195u.C0194a;
import android.support.v7.widget.C1011w;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class C0882m implements C0462b {
    private static String f2978w;
    private static String f2979x;
    private static String f2980y;
    private static String f2981z;
    private final int f2982a;
    private final int f2983b;
    private final int f2984c;
    private final int f2985d;
    private CharSequence f2986e;
    private CharSequence f2987f;
    private Intent f2988g;
    private char f2989h;
    private char f2990i;
    private Drawable f2991j;
    private int f2992k = 0;
    private C0197k f2993l;
    private aa f2994m;
    private Runnable f2995n;
    private OnMenuItemClickListener f2996o;
    private int f2997p = 16;
    private int f2998q = 0;
    private View f2999r;
    private C0641i f3000s;
    private C0674e f3001t;
    private boolean f3002u = false;
    private ContextMenuInfo f3003v;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m5695a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m5698a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m5704b(i);
    }

    C0882m(C0197k c0197k, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f2993l = c0197k;
        this.f2982a = i2;
        this.f2983b = i;
        this.f2984c = i3;
        this.f2985d = i4;
        this.f2986e = charSequence;
        this.f2998q = i5;
    }

    public boolean m5706b() {
        if ((this.f2996o != null && this.f2996o.onMenuItemClick(this)) || this.f2993l.mo162a(this.f2993l.mo167p(), (MenuItem) this)) {
            return true;
        }
        if (this.f2995n != null) {
            this.f2995n.run();
            return true;
        }
        if (this.f2988g != null) {
            try {
                this.f2993l.m1317e().startActivity(this.f2988g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f3000s == null || !this.f3000s.mo877d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f2997p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f2997p |= 16;
        } else {
            this.f2997p &= -17;
        }
        this.f2993l.mo169a(false);
        return this;
    }

    public int getGroupId() {
        return this.f2983b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f2982a;
    }

    public int getOrder() {
        return this.f2984c;
    }

    public int m5707c() {
        return this.f2985d;
    }

    public Intent getIntent() {
        return this.f2988g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2988g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f2990i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f2990i != c) {
            this.f2990i = Character.toLowerCase(c);
            this.f2993l.mo169a(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f2989h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f2989h != c) {
            this.f2989h = c;
            this.f2993l.mo169a(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2989h = c;
        this.f2990i = Character.toLowerCase(c2);
        this.f2993l.mo169a(false);
        return this;
    }

    char m5709d() {
        return this.f2993l.mo163b() ? this.f2990i : this.f2989h;
    }

    String m5711e() {
        char d = m5709d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f2978w);
        switch (d) {
            case '\b':
                stringBuilder.append(f2980y);
                break;
            case '\n':
                stringBuilder.append(f2979x);
                break;
            case ' ':
                stringBuilder.append(f2981z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m5713f() {
        return this.f2993l.mo164c() && m5709d() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f2994m;
    }

    public boolean hasSubMenu() {
        return this.f2994m != null;
    }

    public void m5701a(aa aaVar) {
        this.f2994m = aaVar;
        aaVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f2986e;
    }

    CharSequence m5700a(C0194a c0194a) {
        if (c0194a == null || !c0194a.mo131b()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2986e = charSequence;
        this.f2993l.mo169a(false);
        if (this.f2994m != null) {
            this.f2994m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f2993l.m1317e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2987f != null ? this.f2987f : this.f2986e;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2987f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f2986e;
        }
        this.f2993l.mo169a(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f2991j != null) {
            return this.f2991j;
        }
        if (this.f2992k == 0) {
            return null;
        }
        Drawable a = C1011w.m7254a().m7272a(this.f2993l.m1317e(), this.f2992k);
        this.f2992k = 0;
        this.f2991j = a;
        return a;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2992k = 0;
        this.f2991j = drawable;
        this.f2993l.mo169a(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f2991j = null;
        this.f2992k = i;
        this.f2993l.mo169a(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f2997p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f2997p;
        this.f2997p = (z ? 1 : 0) | (this.f2997p & -2);
        if (i != this.f2997p) {
            this.f2993l.mo169a(false);
        }
        return this;
    }

    public void m5703a(boolean z) {
        this.f2997p = (z ? 4 : 0) | (this.f2997p & -5);
    }

    public boolean m5714g() {
        return (this.f2997p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f2997p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f2997p & 4) != 0) {
            this.f2993l.m1296a((MenuItem) this);
        } else {
            m5705b(z);
        }
        return this;
    }

    void m5705b(boolean z) {
        int i;
        int i2 = this.f2997p;
        int i3 = this.f2997p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f2997p = i | i3;
        if (i2 != this.f2997p) {
            this.f2993l.mo169a(false);
        }
    }

    public boolean isVisible() {
        if (this.f3000s == null || !this.f3000s.mo885b()) {
            if ((this.f2997p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f2997p & 8) == 0 && this.f3000s.mo886c()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m5708c(boolean z) {
        int i = this.f2997p;
        this.f2997p = (z ? 0 : 8) | (this.f2997p & -9);
        if (i != this.f2997p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m5708c(z)) {
            this.f2993l.m1293a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2996o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f2986e != null ? this.f2986e.toString() : null;
    }

    void m5702a(ContextMenuInfo contextMenuInfo) {
        this.f3003v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f3003v;
    }

    public void m5715h() {
        this.f2993l.m1304b(this);
    }

    public boolean m5716i() {
        return this.f2993l.m1330q();
    }

    public boolean m5717j() {
        return (this.f2997p & 32) == 32;
    }

    public boolean m5718k() {
        return (this.f2998q & 1) == 1;
    }

    public boolean m5719l() {
        return (this.f2998q & 2) == 2;
    }

    public void m5710d(boolean z) {
        if (z) {
            this.f2997p |= 32;
        } else {
            this.f2997p &= -33;
        }
    }

    public boolean m5720m() {
        return (this.f2998q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f2998q = i;
                this.f2993l.m1304b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public C0462b m5698a(View view) {
        this.f2999r = view;
        this.f3000s = null;
        if (view != null && view.getId() == -1 && this.f2982a > 0) {
            view.setId(this.f2982a);
        }
        this.f2993l.m1304b(this);
        return this;
    }

    public C0462b m5695a(int i) {
        Context e = this.f2993l.m1317e();
        m5698a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.f2999r != null) {
            return this.f2999r;
        }
        if (this.f3000s == null) {
            return null;
        }
        this.f2999r = this.f3000s.mo883a((MenuItem) this);
        return this.f2999r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public C0641i mo851a() {
        return this.f3000s;
    }

    public C0462b mo849a(C0641i c0641i) {
        if (this.f3000s != null) {
            this.f3000s.m4283f();
        }
        this.f2999r = null;
        this.f3000s = c0641i;
        this.f2993l.mo169a(true);
        if (this.f3000s != null) {
            this.f3000s.mo884a(new C0883n(this));
        }
        return this;
    }

    public C0462b m5704b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!m5721n()) {
            return false;
        }
        if (this.f3001t == null || this.f3001t.mo881a(this)) {
            return this.f2993l.mo165c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f2998q & 8) == 0) {
            return false;
        }
        if (this.f2999r == null) {
            return true;
        }
        if (this.f3001t == null || this.f3001t.mo882b(this)) {
            return this.f2993l.mo166d(this);
        }
        return false;
    }

    public C0462b mo850a(C0674e c0674e) {
        this.f3001t = c0674e;
        return this;
    }

    public boolean m5721n() {
        if ((this.f2998q & 8) == 0) {
            return false;
        }
        if (this.f2999r == null && this.f3000s != null) {
            this.f2999r = this.f3000s.mo883a((MenuItem) this);
        }
        if (this.f2999r != null) {
            return true;
        }
        return false;
    }

    public void m5712e(boolean z) {
        this.f3002u = z;
        this.f2993l.mo169a(false);
    }

    public boolean isActionViewExpanded() {
        return this.f3002u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
