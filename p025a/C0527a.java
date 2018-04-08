package android.support.v4.view.p025a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class C0527a {
    private static final C0523d f2053a;

    interface C0523d {
        int mo432a(AccessibilityEvent accessibilityEvent);

        void mo433a(AccessibilityEvent accessibilityEvent, int i);
    }

    static class C0524c implements C0523d {
        C0524c() {
        }

        public void mo433a(AccessibilityEvent accessibilityEvent, int i) {
        }

        public int mo432a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    static class C0525a extends C0524c {
        C0525a() {
        }
    }

    static class C0526b extends C0525a {
        C0526b() {
        }

        public void mo433a(AccessibilityEvent accessibilityEvent, int i) {
            C0528b.m3250a(accessibilityEvent, i);
        }

        public int mo432a(AccessibilityEvent accessibilityEvent) {
            return C0528b.m3249a(accessibilityEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f2053a = new C0526b();
        } else if (VERSION.SDK_INT >= 14) {
            f2053a = new C0525a();
        } else {
            f2053a = new C0524c();
        }
    }

    public static C0572s m3246a(AccessibilityEvent accessibilityEvent) {
        return new C0572s(accessibilityEvent);
    }

    public static void m3247a(AccessibilityEvent accessibilityEvent, int i) {
        f2053a.mo433a(accessibilityEvent, i);
    }

    public static int m3248b(AccessibilityEvent accessibilityEvent) {
        return f2053a.mo432a(accessibilityEvent);
    }
}
