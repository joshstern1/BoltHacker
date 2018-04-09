package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

class ay {
    private static ThreadLocal<Rect> f2108a;

    public static void m4024a(View view) {
        view.requestApplyInsets();
    }

    public static void m4025a(View view, float f) {
        view.setElevation(f);
    }

    public static float m4030b(View view) {
        return view.getElevation();
    }

    public static float m4033c(View view) {
        return view.getTranslationZ();
    }

    public static void m4029a(View view, ai aiVar) {
        if (aiVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new az(aiVar));
        }
    }

    static ColorStateList m4034d(View view) {
        return view.getBackgroundTintList();
    }

    static void m4027a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static Mode m4035e(View view) {
        return view.getBackgroundTintMode();
    }

    static void m4028a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static bz m4023a(View view, bz bzVar) {
        if (!(bzVar instanceof ca)) {
            return bzVar;
        }
        WindowInsets g = ((ca) bzVar).m4240g();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(g);
        if (onApplyWindowInsets != g) {
            return new ca(onApplyWindowInsets);
        }
        return bzVar;
    }

    public static bz m4031b(View view, bz bzVar) {
        if (!(bzVar instanceof ca)) {
            return bzVar;
        }
        WindowInsets g = ((ca) bzVar).m4240g();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(g);
        if (dispatchApplyWindowInsets != g) {
            return new ca(dispatchApplyWindowInsets);
        }
        return bzVar;
    }

    public static boolean m4036f(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void m4037g(View view) {
        view.stopNestedScroll();
    }

    public static float m4038h(View view) {
        return view.getZ();
    }

    static void m4026a(View view, int i) {
        Object obj;
        Rect a = m4022a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        as.m3974a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    static void m4032b(View view, int i) {
        Object obj;
        Rect a = m4022a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        as.m3979b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    private static Rect m4022a() {
        if (f2108a == null) {
            f2108a = new ThreadLocal();
        }
        Rect rect = (Rect) f2108a.get();
        if (rect == null) {
            rect = new Rect();
            f2108a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
