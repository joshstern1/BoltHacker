package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class C0658o {
    static final C0654a f2153a;

    interface C0654a {
        C0403s mo649a(LayoutInflater layoutInflater);

        void mo650a(LayoutInflater layoutInflater, C0403s c0403s);
    }

    static class C0655b implements C0654a {
        C0655b() {
        }

        public void mo650a(LayoutInflater layoutInflater, C0403s c0403s) {
            C0660p.m4327a(layoutInflater, c0403s);
        }

        public C0403s mo649a(LayoutInflater layoutInflater) {
            return C0660p.m4326a(layoutInflater);
        }
    }

    static class C0656c extends C0655b {
        C0656c() {
        }

        public void mo650a(LayoutInflater layoutInflater, C0403s c0403s) {
            C0662q.m4328a(layoutInflater, c0403s);
        }
    }

    static class C0657d extends C0656c {
        C0657d() {
        }

        public void mo650a(LayoutInflater layoutInflater, C0403s c0403s) {
            C0663r.m4330a(layoutInflater, c0403s);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f2153a = new C0657d();
        } else if (i >= 11) {
            f2153a = new C0656c();
        } else {
            f2153a = new C0655b();
        }
    }

    public static void m4325a(LayoutInflater layoutInflater, C0403s c0403s) {
        f2153a.mo650a(layoutInflater, c0403s);
    }

    public static C0403s m4324a(LayoutInflater layoutInflater) {
        return f2153a.mo649a(layoutInflater);
    }
}
