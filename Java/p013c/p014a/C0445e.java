package android.support.v4.p013c.p014a;

import android.graphics.drawable.Drawable;

class C0445e {
    public static void m3013a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m3014b(Drawable drawable) {
        if (drawable instanceof C0165o) {
            return drawable;
        }
        return new C0456l(drawable);
    }
}
