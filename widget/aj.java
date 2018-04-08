package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class aj {
    private static Method f2366a;
    private static boolean f2367b;

    static void m4700a(PopupWindow popupWindow, int i) {
        if (!f2367b) {
            try {
                f2366a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f2366a.setAccessible(true);
            } catch (Exception e) {
            }
            f2367b = true;
        }
        if (f2366a != null) {
            try {
                f2366a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
