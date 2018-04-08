package android.support.v4.p021b.p022a;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class C0414e {
    public static Drawable m2899a(Resources resources, int i, Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return C0415f.m2900a(resources, i, theme);
        }
        return resources.getDrawable(i);
    }
}
