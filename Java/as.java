package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

class as {
    static long m3972a() {
        return ValueAnimator.getFrameDelay();
    }

    public static float m3969a(View view) {
        return view.getAlpha();
    }

    public static void m3975a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m3977b(View view) {
        return view.getLayerType();
    }

    public static int m3971a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m3981c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int m3983d(View view) {
        return view.getMeasuredHeightAndState();
    }

    public static int m3985e(View view) {
        return view.getMeasuredState();
    }

    public static float m3987f(View view) {
        return view.getTranslationX();
    }

    public static float m3988g(View view) {
        return view.getTranslationY();
    }

    public static float m3989h(View view) {
        return view.getScaleX();
    }

    public static void m3973a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m3978b(View view, float f) {
        view.setTranslationY(f);
    }

    public static Matrix m3990i(View view) {
        return view.getMatrix();
    }

    public static void m3982c(View view, float f) {
        view.setAlpha(f);
    }

    public static void m3984d(View view, float f) {
        view.setScaleX(f);
    }

    public static void m3986e(View view, float f) {
        view.setScaleY(f);
    }

    public static void m3991j(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m3976a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static void m3980b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int m3970a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    static void m3974a(View view, int i) {
        view.offsetTopAndBottom(i);
        m3992k(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m3992k((View) parent);
        }
    }

    static void m3979b(View view, int i) {
        view.offsetLeftAndRight(i);
        m3992k(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m3992k((View) parent);
        }
    }

    private static void m3992k(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
