package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.bf.C0263d;
import android.view.View;

class br {
    static final C0263d f1357a = new bs();
    private static final C0271a f1358b;

    private interface C0271a {
        void mo271a(View view);
    }

    private static class C0272b implements C0271a {
        private C0272b() {
        }

        public void mo271a(View view) {
        }
    }

    private static class C0273c implements C0271a {
        private C0273c() {
        }

        public void mo271a(View view) {
            bt.m2098a(view);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1358b = new C0273c();
        } else {
            f1358b = new C0272b();
        }
    }

    static void m2096a(View view) {
        f1358b.mo271a(view);
    }

    static bf m2095a() {
        return f1357a.mo272a();
    }
}
