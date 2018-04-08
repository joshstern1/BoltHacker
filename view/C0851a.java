package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p021b.p022a.C0410a;
import android.support.v4.view.bb;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0832b;
import android.support.v7.p028b.C0842a.C0834d;
import android.support.v7.p028b.C0842a.C0841k;
import android.view.ViewConfiguration;

public class C0851a {
    private Context f2790a;

    public static C0851a m5478a(Context context) {
        return new C0851a(context);
    }

    private C0851a(Context context) {
        this.f2790a = context;
    }

    public int m5479a() {
        Resources resources = this.f2790a.getResources();
        int b = C0410a.m2891b(resources);
        int a = C0410a.m2890a(resources);
        if (C0410a.m2892c(resources) > 600 || b > 600 || ((b > 960 && a > 720) || (b > 720 && a > 960))) {
            return 5;
        }
        if (b >= 500 || ((b > 640 && a > 480) || (b > 480 && a > 640))) {
            return 4;
        }
        if (b >= 360) {
            return 3;
        }
        return 2;
    }

    public boolean m5480b() {
        if (VERSION.SDK_INT < 19 && bb.m4087b(ViewConfiguration.get(this.f2790a))) {
            return false;
        }
        return true;
    }

    public int m5481c() {
        return this.f2790a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m5482d() {
        return this.f2790a.getResources().getBoolean(C0832b.abc_action_bar_embed_tabs);
    }

    public int m5483e() {
        TypedArray obtainStyledAttributes = this.f2790a.obtainStyledAttributes(null, C0841k.ActionBar, C0831a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0841k.ActionBar_height, 0);
        Resources resources = this.f2790a.getResources();
        if (!m5482d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0834d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m5484f() {
        return this.f2790a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m5485g() {
        return this.f2790a.getResources().getDimensionPixelSize(C0834d.abc_action_bar_stacked_tab_max_width);
    }
}
