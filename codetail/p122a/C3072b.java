package io.codetail.p122a;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewAnimationUtils;
import io.codetail.p122a.C3076c.C3073a;
import io.codetail.p122a.C3076c.C3075c;

public final class C3072b {
    private static final boolean f10148a = (VERSION.SDK_INT >= 21);

    public static Animator m17391a(View view, int i, int i2, float f, float f2) {
        return C3072b.m17392a(view, i, i2, f, f2, 1);
    }

    public static Animator m17392a(View view, int i, int i2, float f, float f2, int i3) {
        if (view.getParent() instanceof C3071a) {
            C3076c viewRevealManager = ((C3071a) view.getParent()).getViewRevealManager();
            if (!viewRevealManager.m17404a() && f10148a) {
                return ViewAnimationUtils.createCircularReveal(view, i, i2, f, f2);
            }
            C3075c c3075c = new C3075c(view, i, i2, f, f2);
            Animator a = viewRevealManager.m17403a(c3075c);
            if (i3 != view.getLayerType()) {
                a.addListener(new C3073a(c3075c, i3));
            }
            return a;
        }
        throw new IllegalArgumentException("Parent must be instance of RevealViewGroup");
    }
}
