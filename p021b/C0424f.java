package android.support.v4.p021b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class C0424f {
    private static final C0420a f1871a;

    interface C0420a {
        Intent mo390a(ComponentName componentName);
    }

    static class C0421b implements C0420a {
        C0421b() {
        }

        public Intent mo390a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class C0422c extends C0421b {
        C0422c() {
        }

        public Intent mo390a(ComponentName componentName) {
            return C0425g.m2911a(componentName);
        }
    }

    static class C0423d extends C0422c {
        C0423d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f1871a = new C0423d();
        } else if (i >= 11) {
            f1871a = new C0422c();
        } else {
            f1871a = new C0421b();
        }
    }

    public static Intent m2910a(ComponentName componentName) {
        return f1871a.mo390a(componentName);
    }
}
