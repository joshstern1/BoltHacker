package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.p013c.C0461a;
import android.util.TypedValue;

class cz {
    static final int[] f3808a = new int[]{-16842910};
    static final int[] f3809b = new int[]{16842908};
    static final int[] f3810c = new int[]{16843518};
    static final int[] f3811d = new int[]{16842919};
    static final int[] f3812e = new int[]{16842912};
    static final int[] f3813f = new int[]{16842913};
    static final int[] f3814g = new int[]{-16842919, -16842908};
    static final int[] f3815h = new int[0];
    private static final ThreadLocal<TypedValue> f3816i = new ThreadLocal();
    private static final int[] f3817j = new int[1];

    public static int m7054a(Context context, int i) {
        f3817j[0] = i;
        de a = de.m7065a(context, null, f3817j);
        try {
            int b = a.m7072b(0, 0);
            return b;
        } finally {
            a.m7070a();
        }
    }

    public static ColorStateList m7057b(Context context, int i) {
        f3817j[0] = i;
        de a = de.m7065a(context, null, f3817j);
        try {
            ColorStateList e = a.m7079e(0);
            return e;
        } finally {
            a.m7070a();
        }
    }

    public static int m7058c(Context context, int i) {
        ColorStateList b = m7057b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f3808a, b.getDefaultColor());
        }
        TypedValue a = m7056a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m7055a(context, i, a.getFloat());
    }

    private static TypedValue m7056a() {
        TypedValue typedValue = (TypedValue) f3816i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f3816i.set(typedValue);
        return typedValue;
    }

    static int m7055a(Context context, int i, float f) {
        int a = m7054a(context, i);
        return C0461a.m3049b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
