package android.support.v7.view.menu;

import android.support.v7.view.menu.C0874e.C0871a;
import android.view.MenuItem;

class C0877h implements Runnable {
    final /* synthetic */ C0871a f2952a;
    final /* synthetic */ MenuItem f2953b;
    final /* synthetic */ C0197k f2954c;
    final /* synthetic */ C0876g f2955d;

    C0877h(C0876g c0876g, C0871a c0871a, MenuItem menuItem, C0197k c0197k) {
        this.f2955d = c0876g;
        this.f2952a = c0871a;
        this.f2953b = menuItem;
        this.f2954c = c0197k;
    }

    public void run() {
        if (this.f2952a != null) {
            this.f2955d.f2951a.f2949y = true;
            this.f2952a.f2922b.m1306b(false);
            this.f2955d.f2951a.f2949y = false;
        }
        if (this.f2953b.isEnabled() && this.f2953b.hasSubMenu()) {
            this.f2954c.m1300a(this.f2953b, 0);
        }
    }
}
