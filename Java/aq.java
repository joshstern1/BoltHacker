package android.support.v4.view;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Method;

class aq {
    private static Method f2107a;

    public static void m3967a(ViewGroup viewGroup, boolean z) {
        if (f2107a == null) {
            try {
                f2107a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            f2107a.setAccessible(true);
        }
        try {
            f2107a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
