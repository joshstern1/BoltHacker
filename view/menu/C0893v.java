package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p015d.p016a.C0196a;
import android.support.v4.p015d.p016a.C0462b;
import android.support.v4.p015d.p016a.C0463c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class C0893v {
    public static Menu m5753a(Context context, C0196a c0196a) {
        if (VERSION.SDK_INT >= 14) {
            return new C0869w(context, c0196a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m5754a(Context context, C0462b c0462b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0890p(context, c0462b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0888o(context, c0462b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m5755a(Context context, C0463c c0463c) {
        if (VERSION.SDK_INT >= 14) {
            return new ab(context, c0463c);
        }
        throw new UnsupportedOperationException();
    }
}
