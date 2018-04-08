package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class bb {
    static final C0606e f2117a;

    interface C0606e {
        int mo597a(ViewConfiguration viewConfiguration);

        boolean mo598b(ViewConfiguration viewConfiguration);
    }

    static class C0607a implements C0606e {
        C0607a() {
        }

        public int mo597a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean mo598b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class C0608b extends C0607a {
        C0608b() {
        }

        public int mo597a(ViewConfiguration viewConfiguration) {
            return bc.m4088a(viewConfiguration);
        }
    }

    static class C0609c extends C0608b {
        C0609c() {
        }

        public boolean mo598b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class C0610d extends C0609c {
        C0610d() {
        }

        public boolean mo598b(ViewConfiguration viewConfiguration) {
            return bd.m4089a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f2117a = new C0610d();
        } else if (VERSION.SDK_INT >= 11) {
            f2117a = new C0609c();
        } else if (VERSION.SDK_INT >= 8) {
            f2117a = new C0608b();
        } else {
            f2117a = new C0607a();
        }
    }

    public static int m4086a(ViewConfiguration viewConfiguration) {
        return f2117a.mo597a(viewConfiguration);
    }

    public static boolean m4087b(ViewConfiguration viewConfiguration) {
        return f2117a.mo598b(viewConfiguration);
    }
}
