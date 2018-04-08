package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class C0728f {
    private static Field f2428a;
    private static boolean f2429b;

    static void m4865a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof bc) {
            ((bc) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m4866a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof bc) {
            ((bc) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    static Drawable m4864a(CompoundButton compoundButton) {
        if (!f2429b) {
            try {
                f2428a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f2428a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f2429b = true;
        }
        if (f2428a != null) {
            try {
                return (Drawable) f2428a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f2428a = null;
            }
        }
        return null;
    }
}
