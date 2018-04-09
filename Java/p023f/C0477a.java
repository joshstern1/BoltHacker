package android.support.v4.p023f;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0477a {
    private static final C0473a f1914a;

    interface C0473a {
        String mo414a(Locale locale);
    }

    static class C0474b implements C0473a {
        C0474b() {
        }

        public String mo414a(Locale locale) {
            return null;
        }
    }

    static class C0475c implements C0473a {
        C0475c() {
        }

        public String mo414a(Locale locale) {
            return C0479c.m3070a(locale);
        }
    }

    static class C0476d implements C0473a {
        C0476d() {
        }

        public String mo414a(Locale locale) {
            return C0478b.m3068a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1914a = new C0476d();
        } else if (i >= 14) {
            f1914a = new C0475c();
        } else {
            f1914a = new C0474b();
        }
    }

    public static String m3067a(Locale locale) {
        return f1914a.mo414a(locale);
    }
}
