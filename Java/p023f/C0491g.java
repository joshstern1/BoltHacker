package android.support.v4.p023f;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0491g {
    public static final Locale f1931a = new Locale("", "");
    private static final C0489a f1932b;
    private static String f1933c = "Arab";
    private static String f1934d = "Hebr";

    private static class C0489a {
        private C0489a() {
        }

        public int mo418a(Locale locale) {
            if (!(locale == null || locale.equals(C0491g.f1931a))) {
                String a = C0477a.m3067a(locale);
                if (a == null) {
                    return C0489a.m3085b(locale);
                }
                if (a.equalsIgnoreCase(C0491g.f1933c) || a.equalsIgnoreCase(C0491g.f1934d)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int m3085b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    private static class C0490b extends C0489a {
        private C0490b() {
            super();
        }

        public int mo418a(Locale locale) {
            return C0493i.m3091a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1932b = new C0490b();
        } else {
            f1932b = new C0489a();
        }
    }

    public static int m3088a(Locale locale) {
        return f1932b.mo418a(locale);
    }
}
