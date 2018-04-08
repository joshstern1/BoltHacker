package android.support.v4.p013c.p014a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class C0446f {
    private static Method f1896a;
    private static boolean f1897b;
    private static Method f1898c;
    private static boolean f1899d;

    public static boolean m3016a(Drawable drawable, int i) {
        if (!f1897b) {
            try {
                f1896a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f1896a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f1897b = true;
        }
        if (f1896a != null) {
            try {
                f1896a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f1896a = null;
            }
        }
        return false;
    }

    public static int m3015a(Drawable drawable) {
        if (!f1899d) {
            try {
                f1898c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f1898c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f1899d = true;
        }
        if (f1898c != null) {
            try {
                return ((Integer) f1898c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f1898c = null;
            }
        }
        return -1;
    }
}
