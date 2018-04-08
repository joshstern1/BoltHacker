package android.support.v4.p013c;

import android.graphics.Color;

public final class C0461a {
    private static final ThreadLocal<double[]> f1911a = new ThreadLocal();

    public static int m3047a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int c = C0461a.m3050c(alpha2, alpha);
        return Color.argb(c, C0461a.m3048a(Color.red(i), alpha2, Color.red(i2), alpha, c), C0461a.m3048a(Color.green(i), alpha2, Color.green(i2), alpha, c), C0461a.m3048a(Color.blue(i), alpha2, Color.blue(i2), alpha, c));
    }

    private static int m3050c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int m3048a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int m3049b(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
