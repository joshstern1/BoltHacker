package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ap {
    private static Field f2103a;
    private static boolean f2104b;
    private static Field f2105c;
    private static boolean f2106d;

    static ColorStateList m3957a(View view) {
        return view instanceof al ? ((al) view).getSupportBackgroundTintList() : null;
    }

    static void m3959a(View view, ColorStateList colorStateList) {
        if (view instanceof al) {
            ((al) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static Mode m3961b(View view) {
        return view instanceof al ? ((al) view).getSupportBackgroundTintMode() : null;
    }

    static void m3960a(View view, Mode mode) {
        if (view instanceof al) {
            ((al) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean m3963c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m3964d(View view) {
        if (!f2104b) {
            try {
                f2103a = View.class.getDeclaredField("mMinWidth");
                f2103a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f2104b = true;
        }
        if (f2103a != null) {
            try {
                return ((Integer) f2103a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m3965e(View view) {
        if (!f2106d) {
            try {
                f2105c = View.class.getDeclaredField("mMinHeight");
                f2105c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f2106d = true;
        }
        if (f2105c != null) {
            try {
                return ((Integer) f2105c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m3966f(View view) {
        return view.getWindowToken() != null;
    }

    static void m3958a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m3962b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }
}
