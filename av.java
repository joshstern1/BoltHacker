package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

class av {
    public static boolean m4003a(View view) {
        return view.hasTransientState();
    }

    public static void m4005b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m4001a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m4002a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m4006c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m4000a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static boolean m4004a(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static ViewParent m4007d(View view) {
        return view.getParentForAccessibility();
    }

    public static int m4008e(View view) {
        return view.getMinimumWidth();
    }

    public static int m4009f(View view) {
        return view.getMinimumHeight();
    }

    public static void m4010g(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m4011h(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m4012i(View view) {
        return view.hasOverlappingRendering();
    }
}
