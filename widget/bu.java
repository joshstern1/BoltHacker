package android.support.v7.widget;

import android.view.animation.Interpolator;

final class bu implements Interpolator {
    bu() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
