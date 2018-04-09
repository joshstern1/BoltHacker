package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;

class bq {
    public static void m4201a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m4200a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m4205b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m4208c(View view, float f) {
        view.animate().translationY(f);
    }

    public static long m4199a(View view) {
        return view.animate().getDuration();
    }

    public static void m4203a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m4206b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m4204b(View view) {
        view.animate().cancel();
    }

    public static void m4207c(View view) {
        view.animate().start();
    }

    public static void m4202a(View view, bw bwVar) {
        if (bwVar != null) {
            view.animate().setListener(new br(bwVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
