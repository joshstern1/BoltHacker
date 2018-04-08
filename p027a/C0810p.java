package android.support.v7.p027a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0308a;
import android.support.v4.app.C0397s;
import android.support.v4.app.aq;
import android.support.v4.app.bp;
import android.support.v4.app.bp.C0369a;
import android.support.v4.view.C0651l;
import android.support.v7.p027a.C0790b.C0781a;
import android.support.v7.p027a.C0790b.C0782b;
import android.support.v7.view.C0778b;
import android.support.v7.view.C0778b.C0825a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.dm;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class C0810p extends C0397s implements C0369a, C0782b, C0763q {
    private C0811r f2694m;
    private int f2695n = 0;
    private boolean f2696o;
    private Resources f2697p;

    protected void onCreate(Bundle bundle) {
        C0811r j = m5307j();
        j.mo834h();
        j.mo819a(bundle);
        if (j.mo812i() && this.f2695n != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f2695n, false);
            } else {
                setTheme(this.f2695n);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f2695n = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m5307j().mo826b(bundle);
    }

    public C0760a m5304g() {
        return m5307j().mo806a();
    }

    public void mo2163a(Toolbar toolbar) {
        m5307j().mo820a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return m5307j().mo808b();
    }

    public void setContentView(int i) {
        m5307j().mo825b(i);
    }

    public void setContentView(View view) {
        m5307j().mo821a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m5307j().mo822a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m5307j().mo827b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m5307j().mo818a(configuration);
        if (this.f2697p != null) {
            this.f2697p.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onStop() {
        super.onStop();
        m5307j().mo830c();
    }

    protected void onPostResume() {
        super.onPostResume();
        m5307j().mo832d();
    }

    public View findViewById(int i) {
        return m5307j().mo816a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0760a g = m5304g();
        if (menuItem.getItemId() != 16908332 || g == null || (g.mo732a() & 4) == 0) {
            return false;
        }
        return m5305h();
    }

    protected void onDestroy() {
        super.onDestroy();
        m5307j().mo810f();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m5307j().mo807a(charSequence);
    }

    public void mo792d() {
        m5307j().mo833e();
    }

    public void invalidateOptionsMenu() {
        m5307j().mo833e();
    }

    public void mo724a(C0778b c0778b) {
    }

    public void mo725b(C0778b c0778b) {
    }

    public C0778b mo723a(C0825a c0825a) {
        return null;
    }

    public void m5295a(bp bpVar) {
        bpVar.m2632a((Activity) this);
    }

    public void m5301b(bp bpVar) {
    }

    public boolean m5305h() {
        Intent a = mo790a();
        if (a == null) {
            return false;
        }
        if (m5298a(a)) {
            bp a2 = bp.m2631a((Context) this);
            m5295a(a2);
            m5301b(a2);
            a2.m2635a();
            try {
                C0308a.m2331a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m5300b(a);
        }
        return true;
    }

    public Intent mo790a() {
        return aq.m2445a(this);
    }

    public boolean m5298a(Intent intent) {
        return aq.m2447a((Activity) this, intent);
    }

    public void m5300b(Intent intent) {
        aq.m2450b((Activity) this, intent);
    }

    public void onContentChanged() {
        m5306i();
    }

    @Deprecated
    public void m5306i() {
    }

    public C0781a mo791b() {
        return m5307j().mo811g();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m5307j().mo809c(bundle);
    }

    public C0811r m5307j() {
        if (this.f2694m == null) {
            this.f2694m = C0811r.m5308a((Activity) this, (C0763q) this);
        }
        return this.f2694m;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (C0651l.m4312c(keyEvent) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                C0760a g = m5304g();
                if (g != null && g.mo741b() && g.mo749g()) {
                    this.f2696o = true;
                    return true;
                }
            } else if (action == 1 && this.f2696o) {
                this.f2696o = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.f2697p == null && dm.m7140a()) {
            this.f2697p = new dm(this, super.getResources());
        }
        return this.f2697p == null ? super.getResources() : this.f2697p;
    }
}
