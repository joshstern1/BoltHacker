package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ao;
import android.support.v4.view.bo;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0835e;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0839i;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0197k.C0253a;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.widget.Toolbar.C0954b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class dj implements ap {
    private Toolbar f3833a;
    private int f3834b;
    private View f3835c;
    private View f3836d;
    private Drawable f3837e;
    private Drawable f3838f;
    private Drawable f3839g;
    private boolean f3840h;
    private CharSequence f3841i;
    private CharSequence f3842j;
    private CharSequence f3843k;
    private Callback f3844l;
    private boolean f3845m;
    private ActionMenuPresenter f3846n;
    private int f3847o;
    private final C1011w f3848p;
    private int f3849q;
    private Drawable f3850r;

    public dj(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0839i.abc_action_bar_up_description, C0835e.abc_ic_ab_back_material);
    }

    public dj(Toolbar toolbar, boolean z, int i, int i2) {
        this.f3847o = 0;
        this.f3849q = 0;
        this.f3833a = toolbar;
        this.f3841i = toolbar.getTitle();
        this.f3842j = toolbar.getSubtitle();
        this.f3840h = this.f3841i != null;
        this.f3839g = toolbar.getNavigationIcon();
        de a = de.m7066a(toolbar.getContext(), null, C0841k.ActionBar, C0831a.actionBarStyle, 0);
        this.f3850r = a.m7069a(C0841k.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.m7075c(C0841k.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m7112b(c);
            }
            c = a.m7075c(C0841k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m7116c(c);
            }
            Drawable a2 = a.m7069a(C0841k.ActionBar_logo);
            if (a2 != null) {
                m7115c(a2);
            }
            a2 = a.m7069a(C0841k.ActionBar_icon);
            if (a2 != null) {
                mo1056a(a2);
            }
            if (this.f3839g == null && this.f3850r != null) {
                mo1065b(this.f3850r);
            }
            mo1067c(a.m7068a(C0841k.ActionBar_displayOptions, 0));
            int g = a.m7082g(C0841k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m7105a(LayoutInflater.from(this.f3833a.getContext()).inflate(g, this.f3833a, false));
                mo1067c(this.f3834b | 16);
            }
            g = a.m7080f(C0841k.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f3833a.getLayoutParams();
                layoutParams.height = g;
                this.f3833a.setLayoutParams(layoutParams);
            }
            g = a.m7076d(C0841k.ActionBar_contentInsetStart, -1);
            int d = a.m7076d(C0841k.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f3833a.m6673a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m7082g(C0841k.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f3833a.m6674a(this.f3833a.getContext(), g);
            }
            g = a.m7082g(C0841k.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f3833a.m6678b(this.f3833a.getContext(), g);
            }
            int g2 = a.m7082g(C0841k.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f3833a.setPopupTheme(g2);
            }
        } else {
            this.f3834b = m7094s();
        }
        a.m7070a();
        this.f3848p = C1011w.m7254a();
        m7124f(i);
        this.f3843k = this.f3833a.getNavigationContentDescription();
        this.f3833a.setNavigationOnClickListener(new dk(this));
    }

    public void m7124f(int i) {
        if (i != this.f3849q) {
            this.f3849q = i;
            if (TextUtils.isEmpty(this.f3833a.getNavigationContentDescription())) {
                mo1070d(this.f3849q);
            }
        }
    }

    private int m7094s() {
        if (this.f3833a.getNavigationIcon() == null) {
            return 11;
        }
        this.f3850r = this.f3833a.getNavigationIcon();
        return 15;
    }

    public ViewGroup mo1054a() {
        return this.f3833a;
    }

    public Context mo1063b() {
        return this.f3833a.getContext();
    }

    public boolean mo1068c() {
        return this.f3833a.m6684g();
    }

    public void mo1069d() {
        this.f3833a.m6685h();
    }

    public void mo1060a(Callback callback) {
        this.f3844l = callback;
    }

    public void mo1061a(CharSequence charSequence) {
        if (!this.f3840h) {
            m7093e(charSequence);
        }
    }

    public CharSequence mo1071e() {
        return this.f3833a.getTitle();
    }

    public void m7112b(CharSequence charSequence) {
        this.f3840h = true;
        m7093e(charSequence);
    }

    private void m7093e(CharSequence charSequence) {
        this.f3841i = charSequence;
        if ((this.f3834b & 8) != 0) {
            this.f3833a.setTitle(charSequence);
        }
    }

    public void m7116c(CharSequence charSequence) {
        this.f3842j = charSequence;
        if ((this.f3834b & 8) != 0) {
            this.f3833a.setSubtitle(charSequence);
        }
    }

    public void mo1073f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void mo1074g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void mo1055a(int i) {
        mo1056a(i != 0 ? this.f3848p.m7272a(mo1063b(), i) : null);
    }

    public void mo1056a(Drawable drawable) {
        this.f3837e = drawable;
        m7095t();
    }

    public void mo1064b(int i) {
        m7115c(i != 0 ? this.f3848p.m7272a(mo1063b(), i) : null);
    }

    public void m7115c(Drawable drawable) {
        this.f3838f = drawable;
        m7095t();
    }

    private void m7095t() {
        Drawable drawable = null;
        if ((this.f3834b & 2) != 0) {
            drawable = (this.f3834b & 1) != 0 ? this.f3838f != null ? this.f3838f : this.f3837e : this.f3837e;
        }
        this.f3833a.setLogo(drawable);
    }

    public boolean mo1075h() {
        return this.f3833a.m6677a();
    }

    public boolean mo1076i() {
        return this.f3833a.m6679b();
    }

    public boolean mo1077j() {
        return this.f3833a.m6680c();
    }

    public boolean mo1078k() {
        return this.f3833a.m6681d();
    }

    public boolean mo1079l() {
        return this.f3833a.m6682e();
    }

    public void mo1080m() {
        this.f3845m = true;
    }

    public void mo1059a(Menu menu, C0770a c0770a) {
        if (this.f3846n == null) {
            this.f3846n = new ActionMenuPresenter(this.f3833a.getContext());
            this.f3846n.m5596a(C0836f.action_menu_presenter);
        }
        this.f3846n.mo152a(c0770a);
        this.f3833a.m6675a((C0197k) menu, this.f3846n);
    }

    public void mo1081n() {
        this.f3833a.m6683f();
    }

    public int mo1082o() {
        return this.f3834b;
    }

    public void mo1067c(int i) {
        int i2 = this.f3834b ^ i;
        this.f3834b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m7097v();
                }
                m7096u();
            }
            if ((i2 & 3) != 0) {
                m7095t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f3833a.setTitle(this.f3841i);
                    this.f3833a.setSubtitle(this.f3842j);
                } else {
                    this.f3833a.setTitle(null);
                    this.f3833a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f3836d != null) {
                if ((i & 16) != 0) {
                    this.f3833a.addView(this.f3836d);
                } else {
                    this.f3833a.removeView(this.f3836d);
                }
            }
        }
    }

    public void mo1058a(ce ceVar) {
        if (this.f3835c != null && this.f3835c.getParent() == this.f3833a) {
            this.f3833a.removeView(this.f3835c);
        }
        this.f3835c = ceVar;
        if (ceVar != null && this.f3847o == 2) {
            this.f3833a.addView(this.f3835c, 0);
            C0954b c0954b = (C0954b) this.f3835c.getLayoutParams();
            c0954b.width = -2;
            c0954b.height = -2;
            c0954b.a = 8388691;
            ceVar.setAllowCollapse(true);
        }
    }

    public void mo1062a(boolean z) {
        this.f3833a.setCollapsible(z);
    }

    public void mo1066b(boolean z) {
    }

    public int mo1083p() {
        return this.f3847o;
    }

    public void m7105a(View view) {
        if (!(this.f3836d == null || (this.f3834b & 16) == 0)) {
            this.f3833a.removeView(this.f3836d);
        }
        this.f3836d = view;
        if (view != null && (this.f3834b & 16) != 0) {
            this.f3833a.addView(this.f3836d);
        }
    }

    public bo mo1053a(int i, long j) {
        return ao.m3950t(this.f3833a).m4189a(i == 0 ? 1.0f : 0.0f).m4190a(j).m4191a(new dl(this, i));
    }

    public void mo1065b(Drawable drawable) {
        this.f3839g = drawable;
        m7096u();
    }

    private void m7096u() {
        if ((this.f3834b & 4) != 0) {
            this.f3833a.setNavigationIcon(this.f3839g != null ? this.f3839g : this.f3850r);
        } else {
            this.f3833a.setNavigationIcon(null);
        }
    }

    public void m7120d(CharSequence charSequence) {
        this.f3843k = charSequence;
        m7097v();
    }

    public void mo1070d(int i) {
        m7120d(i == 0 ? null : mo1063b().getString(i));
    }

    private void m7097v() {
        if ((this.f3834b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f3843k)) {
            this.f3833a.setNavigationContentDescription(this.f3849q);
        } else {
            this.f3833a.setNavigationContentDescription(this.f3843k);
        }
    }

    public void mo1072e(int i) {
        this.f3833a.setVisibility(i);
    }

    public int mo1084q() {
        return this.f3833a.getVisibility();
    }

    public void mo1057a(C0770a c0770a, C0253a c0253a) {
        this.f3833a.m6676a(c0770a, c0253a);
    }

    public Menu mo1085r() {
        return this.f3833a.getMenu();
    }
}
