package android.support.v4.p021b.p022a;

import android.content.res.Resources;
import android.os.Build.VERSION;

public final class C0410a {
    private static final C0406a f1870a;

    private interface C0406a {
        int mo387a(Resources resources);

        int mo388b(Resources resources);

        int mo389c(Resources resources);
    }

    private static class C0407b implements C0406a {
        private C0407b() {
        }

        public int mo387a(Resources resources) {
            return C0412c.m2893a(resources);
        }

        public int mo388b(Resources resources) {
            return C0412c.m2894b(resources);
        }

        public int mo389c(Resources resources) {
            return C0412c.m2895c(resources);
        }
    }

    private static class C0408c extends C0407b {
        private C0408c() {
            super();
        }

        public int mo387a(Resources resources) {
            return C0413d.m2896a(resources);
        }

        public int mo388b(Resources resources) {
            return C0413d.m2897b(resources);
        }

        public int mo389c(Resources resources) {
            return C0413d.m2898c(resources);
        }
    }

    private static class C0409d extends C0408c {
        private C0409d() {
            super();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f1870a = new C0409d();
        } else if (i >= 13) {
            f1870a = new C0408c();
        } else {
            f1870a = new C0407b();
        }
    }

    public static int m2890a(Resources resources) {
        return f1870a.mo387a(resources);
    }

    public static int m2891b(Resources resources) {
        return f1870a.mo388b(resources);
    }

    public static int m2892c(Resources resources) {
        return f1870a.mo389c(resources);
    }
}
