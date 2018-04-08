package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p015d.p016a.C0463c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class ab extends C0869w implements SubMenu {
    ab(Context context, C0463c c0463c) {
        super(context, c0463c);
    }

    public C0463c m5593b() {
        return (C0463c) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        m5593b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m5593b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m5593b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m5593b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m5593b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m5593b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m5593b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m5593b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m5588a(m5593b().getItem());
    }
}
