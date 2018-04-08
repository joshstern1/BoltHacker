package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p015d.p016a.C0196a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class C0869w extends C0868c<C0196a> implements Menu {
    C0869w(Context context, C0196a c0196a) {
        super(context, c0196a);
    }

    public MenuItem add(CharSequence charSequence) {
        return m5588a(((C0196a) this.b).add(charSequence));
    }

    public MenuItem add(int i) {
        return m5588a(((C0196a) this.b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m5588a(((C0196a) this.b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m5588a(((C0196a) this.b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m5589a(((C0196a) this.b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m5589a(((C0196a) this.b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m5589a(((C0196a) this.b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m5589a(((C0196a) this.b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((C0196a) this.b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m5588a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        m5592b(i);
        ((C0196a) this.b).removeItem(i);
    }

    public void removeGroup(int i) {
        m5591a(i);
        ((C0196a) this.b).removeGroup(i);
    }

    public void clear() {
        m5590a();
        ((C0196a) this.b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0196a) this.b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0196a) this.b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0196a) this.b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((C0196a) this.b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return m5588a(((C0196a) this.b).findItem(i));
    }

    public int size() {
        return ((C0196a) this.b).size();
    }

    public MenuItem getItem(int i) {
        return m5588a(((C0196a) this.b).getItem(i));
    }

    public void close() {
        ((C0196a) this.b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0196a) this.b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0196a) this.b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0196a) this.b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((C0196a) this.b).setQwertyMode(z);
    }
}
