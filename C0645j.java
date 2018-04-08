package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class C0645j {
    static final C0642a f2151a;

    interface C0642a {
        int mo642a(int i, int i2);

        void mo643a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);
    }

    static class C0643b implements C0642a {
        C0643b() {
        }

        public int mo642a(int i, int i2) {
            return -8388609 & i;
        }

        public void mo643a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    static class C0644c implements C0642a {
        C0644c() {
        }

        public int mo642a(int i, int i2) {
            return C0646k.m4292a(i, i2);
        }

        public void mo643a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            C0646k.m4293a(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f2151a = new C0644c();
        } else {
            f2151a = new C0643b();
        }
    }

    public static void m4291a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f2151a.mo643a(i, i2, i3, rect, rect2, i4);
    }

    public static int m4290a(int i, int i2) {
        return f2151a.mo642a(i, i2);
    }
}
