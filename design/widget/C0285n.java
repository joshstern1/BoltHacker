package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class C0285n {
    private static Method f1421a;
    private static boolean f1422b;
    private static Field f1423c;
    private static boolean f1424d;

    static boolean m2160a(DrawableContainer drawableContainer, ConstantState constantState) {
        if (VERSION.SDK_INT >= 9) {
            return C0285n.m2161b(drawableContainer, constantState);
        }
        return C0285n.m2162c(drawableContainer, constantState);
    }

    private static boolean m2161b(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!f1422b) {
            try {
                f1421a = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                f1421a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f1422b = true;
        }
        if (f1421a != null) {
            try {
                f1421a.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }

    private static boolean m2162c(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!f1424d) {
            try {
                f1423c = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                f1423c.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("DrawableUtils", "Could not fetch mDrawableContainerStateField. Oh well.");
            }
            f1424d = true;
        }
        if (f1423c != null) {
            try {
                f1423c.set(drawableContainer, constantState);
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not set mDrawableContainerStateField. Oh well.");
            }
        }
        return false;
    }
}
