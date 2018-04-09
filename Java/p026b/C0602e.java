package android.support.v4.view.p026b;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public final class C0602e {
    public static Interpolator m4073a(Path path) {
        if (VERSION.SDK_INT >= 21) {
            return C0603f.m4074a(path);
        }
        return C0604g.m4075a(path);
    }
}
