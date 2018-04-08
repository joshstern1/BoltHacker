package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0192a.C0184b;

class be {
    private static final int[] f1325a = new int[]{C0184b.colorPrimary};

    static void m2015a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f1325a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
