package android.support.v4.p023f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0479c {
    private static Method f1916a;
    private static Method f1917b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1916a = cls.getMethod("getScript", new Class[]{String.class});
                f1917b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f1916a = null;
            f1917b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m3070a(Locale locale) {
        String b = C0479c.m3071b(locale);
        if (b != null) {
            return C0479c.m3069a(b);
        }
        return null;
    }

    private static String m3069a(String str) {
        try {
            if (f1916a != null) {
                return (String) f1916a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String m3071b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1917b != null) {
                return (String) f1917b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
