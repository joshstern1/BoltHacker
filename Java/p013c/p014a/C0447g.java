package android.support.v4.p013c.p014a;

import android.graphics.drawable.Drawable;

class C0447g {
    public static void m3017a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m3018a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m3019b(Drawable drawable) {
        if (drawable instanceof C0165o) {
            return drawable;
        }
        return new C0458m(drawable);
    }

    public static int m3020c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
