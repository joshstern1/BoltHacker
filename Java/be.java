package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class be {
    static final C0611c f2118a;

    interface C0611c {
        void mo599a(ViewGroup viewGroup, boolean z);
    }

    static class C0612f implements C0611c {
        C0612f() {
        }

        public void mo599a(ViewGroup viewGroup, boolean z) {
        }
    }

    static class C0613a extends C0612f {
        C0613a() {
        }

        public void mo599a(ViewGroup viewGroup, boolean z) {
            bf.m4094a(viewGroup, z);
        }
    }

    static class C0614b extends C0613a {
        C0614b() {
        }
    }

    static class C0615d extends C0614b {
        C0615d() {
        }
    }

    static class C0616e extends C0615d {
        C0616e() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f2118a = new C0616e();
        } else if (i >= 18) {
            f2118a = new C0615d();
        } else if (i >= 14) {
            f2118a = new C0614b();
        } else if (i >= 11) {
            f2118a = new C0613a();
        } else {
            f2118a = new C0612f();
        }
    }

    public static void m4093a(ViewGroup viewGroup, boolean z) {
        f2118a.mo599a(viewGroup, z);
    }
}
