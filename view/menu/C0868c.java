package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p015d.p016a.C0462b;
import android.support.v4.p015d.p016a.C0463c;
import android.support.v4.p024g.C0495a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class C0868c<T> extends C0867d<T> {
    final Context f2908a;
    private Map<C0462b, MenuItem> f2909c;
    private Map<C0463c, SubMenu> f2910d;

    C0868c(Context context, T t) {
        super(t);
        this.f2908a = context;
    }

    final MenuItem m5588a(MenuItem menuItem) {
        if (!(menuItem instanceof C0462b)) {
            return menuItem;
        }
        C0462b c0462b = (C0462b) menuItem;
        if (this.f2909c == null) {
            this.f2909c = new C0495a();
        }
        MenuItem menuItem2 = (MenuItem) this.f2909c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0893v.m5754a(this.f2908a, c0462b);
        this.f2909c.put(c0462b, menuItem2);
        return menuItem2;
    }

    final SubMenu m5589a(SubMenu subMenu) {
        if (!(subMenu instanceof C0463c)) {
            return subMenu;
        }
        C0463c c0463c = (C0463c) subMenu;
        if (this.f2910d == null) {
            this.f2910d = new C0495a();
        }
        SubMenu subMenu2 = (SubMenu) this.f2910d.get(c0463c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0893v.m5755a(this.f2908a, c0463c);
        this.f2910d.put(c0463c, subMenu2);
        return subMenu2;
    }

    final void m5590a() {
        if (this.f2909c != null) {
            this.f2909c.clear();
        }
        if (this.f2910d != null) {
            this.f2910d.clear();
        }
    }

    final void m5591a(int i) {
        if (this.f2909c != null) {
            Iterator it = this.f2909c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m5592b(int i) {
        if (this.f2909c != null) {
            Iterator it = this.f2909c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
