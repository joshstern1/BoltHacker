package android.support.v4.p020a;

import android.os.Build.VERSION;
import android.view.View;

public final class C0302a {
    private static final C0303b f1470a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f1470a = new C0305d();
        } else {
            f1470a = new C0304c();
        }
    }

    public static void m2232a(View view) {
        f1470a.mo297a(view);
    }
}
