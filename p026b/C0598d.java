package android.support.v4.view.p026b;

import android.view.animation.Interpolator;

abstract class C0598d implements Interpolator {
    private final float[] f2110a;
    private final float f2111b = (1.0f / ((float) (this.f2110a.length - 1)));

    public C0598d(float[] fArr) {
        this.f2110a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f2110a.length - 1)) * f), this.f2110a.length - 2);
        float f2 = (f - (((float) min) * this.f2111b)) / this.f2111b;
        return ((this.f2110a[min + 1] - this.f2110a[min]) * f2) + this.f2110a[min];
    }
}
