package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.C0197k.C0253a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class aa extends C0197k implements SubMenu {
    private C0197k f1010d;
    private C0882m f1011e;

    public aa(Context context, C0197k c0197k, C0882m c0882m) {
        super(context);
        this.f1010d = c0197k;
        this.f1011e = c0882m;
    }

    public void setQwertyMode(boolean z) {
        this.f1010d.setQwertyMode(z);
    }

    public boolean mo163b() {
        return this.f1010d.mo163b();
    }

    public boolean mo164c() {
        return this.f1010d.mo164c();
    }

    public Menu m1472s() {
        return this.f1010d;
    }

    public MenuItem getItem() {
        return this.f1011e;
    }

    public void mo161a(C0253a c0253a) {
        this.f1010d.mo161a(c0253a);
    }

    public C0197k mo167p() {
        return this.f1010d.mo167p();
    }

    boolean mo162a(C0197k c0197k, MenuItem menuItem) {
        return super.mo162a(c0197k, menuItem) || this.f1010d.mo162a(c0197k, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1011e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1011e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m1285a(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m1318e(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m1287a(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m1314d(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m1286a(view);
    }

    public boolean mo165c(C0882m c0882m) {
        return this.f1010d.mo165c(c0882m);
    }

    public boolean mo166d(C0882m c0882m) {
        return this.f1010d.mo166d(c0882m);
    }

    public String mo160a() {
        int itemId = this.f1011e != null ? this.f1011e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo160a() + ":" + itemId;
    }
}
