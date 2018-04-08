package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;

public final class C0376d {
    private static final C0374b f1746a;

    private static class C0374b {
        private C0374b() {
        }

        public String mo339a(String str) {
            return null;
        }

        public int mo338a(Context context, String str, String str2) {
            return 1;
        }
    }

    private static class C0375a extends C0374b {
        private C0375a() {
            super();
        }

        public String mo339a(String str) {
            return C0378f.m2646a(str);
        }

        public int mo338a(Context context, String str, String str2) {
            return C0378f.m2645a(context, str, str2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f1746a = new C0375a();
        } else {
            f1746a = new C0374b();
        }
    }

    public static String m2644a(String str) {
        return f1746a.mo339a(str);
    }

    public static int m2643a(Context context, String str, String str2) {
        return f1746a.mo338a(context, str, str2);
    }
}
