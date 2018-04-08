package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class C0726d {
    private static final C0722c f2427a;

    interface C0722c {
        Drawable mo702a(CompoundButton compoundButton);

        void mo703a(CompoundButton compoundButton, ColorStateList colorStateList);

        void mo704a(CompoundButton compoundButton, Mode mode);
    }

    static class C0723b implements C0722c {
        C0723b() {
        }

        public void mo703a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0728f.m4865a(compoundButton, colorStateList);
        }

        public void mo704a(CompoundButton compoundButton, Mode mode) {
            C0728f.m4866a(compoundButton, mode);
        }

        public Drawable mo702a(CompoundButton compoundButton) {
            return C0728f.m4864a(compoundButton);
        }
    }

    static class C0724d extends C0723b {
        C0724d() {
        }

        public void mo703a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0729g.m4867a(compoundButton, colorStateList);
        }

        public void mo704a(CompoundButton compoundButton, Mode mode) {
            C0729g.m4868a(compoundButton, mode);
        }
    }

    static class C0725a extends C0724d {
        C0725a() {
        }

        public Drawable mo702a(CompoundButton compoundButton) {
            return C0727e.m4863a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f2427a = new C0725a();
        } else if (i >= 21) {
            f2427a = new C0724d();
        } else {
            f2427a = new C0723b();
        }
    }

    public static void m4861a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f2427a.mo703a(compoundButton, colorStateList);
    }

    public static void m4862a(CompoundButton compoundButton, Mode mode) {
        f2427a.mo704a(compoundButton, mode);
    }

    public static Drawable m4860a(CompoundButton compoundButton) {
        return f2427a.mo702a(compoundButton);
    }
}
