package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class C0676x {
    public static void m4372a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m4370a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem m4373b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public static View m4371a(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
