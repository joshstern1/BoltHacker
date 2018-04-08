package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class C0755y {
    public static void m4959a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            aa.m4628a(listView, i);
        } else {
            C0756z.m4960a(listView, i);
        }
    }
}
