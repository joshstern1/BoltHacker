package android.support.v4.p023f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0478b {
    private static Method f1915a;

    static {
        try {
            f1915a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m3068a(Locale locale) {
        try {
            return ((Locale) f1915a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
