package android.support.v4.p021b.p022a;

import android.content.res.Resources;
import android.util.DisplayMetrics;

class C0412c {
    static int m2893a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    static int m2894b(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    static int m2895c(Resources resources) {
        return Math.min(C0412c.m2894b(resources), C0412c.m2893a(resources));
    }
}
