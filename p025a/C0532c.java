package android.support.v4.view.p025a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;

public final class C0532c {
    private static final C0529c f2054a;

    interface C0529c {
        boolean mo434a(AccessibilityManager accessibilityManager);
    }

    static class C0530b implements C0529c {
        C0530b() {
        }

        public boolean mo434a(AccessibilityManager accessibilityManager) {
            return false;
        }
    }

    static class C0531a extends C0530b {
        C0531a() {
        }

        public boolean mo434a(AccessibilityManager accessibilityManager) {
            return C0533d.m3255a(accessibilityManager);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f2054a = new C0531a();
        } else {
            f2054a = new C0530b();
        }
    }

    public static boolean m3254a(AccessibilityManager accessibilityManager) {
        return f2054a.mo434a(accessibilityManager);
    }
}
