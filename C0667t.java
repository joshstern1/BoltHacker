package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class C0667t {
    static final C0664a f2157a;

    interface C0664a {
        int mo651a(MarginLayoutParams marginLayoutParams);

        int mo652b(MarginLayoutParams marginLayoutParams);
    }

    static class C0665b implements C0664a {
        C0665b() {
        }

        public int mo651a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int mo652b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    static class C0666c implements C0664a {
        C0666c() {
        }

        public int mo651a(MarginLayoutParams marginLayoutParams) {
            return C0668u.m4339a(marginLayoutParams);
        }

        public int mo652b(MarginLayoutParams marginLayoutParams) {
            return C0668u.m4340b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f2157a = new C0666c();
        } else {
            f2157a = new C0665b();
        }
    }

    public static int m4337a(MarginLayoutParams marginLayoutParams) {
        return f2157a.mo651a(marginLayoutParams);
    }

    public static int m4338b(MarginLayoutParams marginLayoutParams) {
        return f2157a.mo652b(marginLayoutParams);
    }
}
