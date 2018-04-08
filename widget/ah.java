package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class ah {
    private static Field f2365a;

    static {
        try {
            f2365a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f2365a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m4697a(PopupWindow popupWindow, boolean z) {
        if (f2365a != null) {
            try {
                f2365a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
