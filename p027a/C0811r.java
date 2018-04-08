package android.support.v7.p027a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p017e.C0466c;
import android.support.v7.p027a.C0790b.C0781a;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class C0811r {
    private static int f2698a = -1;
    private static boolean f2699b = false;

    public abstract C0760a mo806a();

    public abstract View mo816a(int i);

    public abstract void mo818a(Configuration configuration);

    public abstract void mo819a(Bundle bundle);

    public abstract void mo820a(Toolbar toolbar);

    public abstract void mo821a(View view);

    public abstract void mo822a(View view, LayoutParams layoutParams);

    public abstract void mo807a(CharSequence charSequence);

    public abstract MenuInflater mo808b();

    public abstract void mo825b(int i);

    public abstract void mo826b(Bundle bundle);

    public abstract void mo827b(View view, LayoutParams layoutParams);

    public abstract void mo830c();

    public abstract void mo809c(Bundle bundle);

    public abstract boolean mo831c(int i);

    public abstract void mo832d();

    public abstract void mo833e();

    public abstract void mo810f();

    public abstract C0781a mo811g();

    public abstract void mo834h();

    public abstract boolean mo812i();

    public static C0811r m5308a(Activity activity, C0763q c0763q) {
        return C0811r.m5310a(activity, activity.getWindow(), c0763q);
    }

    public static C0811r m5309a(Dialog dialog, C0763q c0763q) {
        return C0811r.m5310a(dialog.getContext(), dialog.getWindow(), c0763q);
    }

    private static C0811r m5310a(Context context, Window window, C0763q c0763q) {
        int i = VERSION.SDK_INT;
        if (C0466c.m3056a()) {
            return new C0823u(context, window, c0763q);
        }
        if (i >= 23) {
            return new C0822x(context, window, c0763q);
        }
        if (i >= 14) {
            return new C0821w(context, window, c0763q);
        }
        if (i >= 11) {
            return new C0820v(context, window, c0763q);
        }
        return new C0819y(context, window, c0763q);
    }

    C0811r() {
    }

    public static int m5311j() {
        return f2698a;
    }

    public static boolean m5312k() {
        return f2699b;
    }
}
