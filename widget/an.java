package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class an {
    public static Object m4776a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static boolean m4781a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m4783b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m4784c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m4785d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m4777a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void m4778a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m4779a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void m4780a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static void m4786e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m4787f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m4788g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }

    public static boolean m4782a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return ((OverScroller) obj).springBack(i, i2, i3, i4, i5, i6);
    }
}
