package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public final class bl {
    static final C0617b f2122a;

    interface C0617b {
        void mo600a(ViewParent viewParent, View view);

        void mo601a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void mo602a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean mo603a(ViewParent viewParent, View view, float f, float f2);

        boolean mo604a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean mo605a(ViewParent viewParent, View view, View view2, int i);

        boolean mo606a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);

        void mo607b(ViewParent viewParent, View view, View view2, int i);
    }

    static class C0618e implements C0617b {
        C0618e() {
        }

        public boolean mo606a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            if (view == null) {
                return false;
            }
            ((AccessibilityManager) view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
            return true;
        }

        public boolean mo605a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof ag) {
                return ((ag) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void mo607b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof ag) {
                ((ag) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void mo600a(ViewParent viewParent, View view) {
            if (viewParent instanceof ag) {
                ((ag) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo601a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof ag) {
                ((ag) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo602a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof ag) {
                ((ag) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo604a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof ag) {
                return ((ag) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean mo603a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof ag) {
                return ((ag) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class C0619a extends C0618e {
        C0619a() {
        }

        public boolean mo606a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            return bm.m4133a(viewParent, view, accessibilityEvent);
        }
    }

    static class C0620c extends C0619a {
        C0620c() {
        }
    }

    static class C0621d extends C0620c {
        C0621d() {
        }

        public boolean mo605a(ViewParent viewParent, View view, View view2, int i) {
            return bn.m4139a(viewParent, view, view2, i);
        }

        public void mo607b(ViewParent viewParent, View view, View view2, int i) {
            bn.m4140b(viewParent, view, view2, i);
        }

        public void mo600a(ViewParent viewParent, View view) {
            bn.m4134a(viewParent, view);
        }

        public void mo601a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            bn.m4135a(viewParent, view, i, i2, i3, i4);
        }

        public void mo602a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            bn.m4136a(viewParent, view, i, i2, iArr);
        }

        public boolean mo604a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return bn.m4138a(viewParent, view, f, f2, z);
        }

        public boolean mo603a(ViewParent viewParent, View view, float f, float f2) {
            return bn.m4137a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f2122a = new C0621d();
        } else if (i >= 19) {
            f2122a = new C0620c();
        } else if (i >= 14) {
            f2122a = new C0619a();
        } else {
            f2122a = new C0618e();
        }
    }

    public static boolean m4131a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return f2122a.mo606a(viewParent, view, accessibilityEvent);
    }

    public static boolean m4130a(ViewParent viewParent, View view, View view2, int i) {
        return f2122a.mo605a(viewParent, view, view2, i);
    }

    public static void m4132b(ViewParent viewParent, View view, View view2, int i) {
        f2122a.mo607b(viewParent, view, view2, i);
    }

    public static void m4125a(ViewParent viewParent, View view) {
        f2122a.mo600a(viewParent, view);
    }

    public static void m4126a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f2122a.mo601a(viewParent, view, i, i2, i3, i4);
    }

    public static void m4127a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f2122a.mo602a(viewParent, view, i, i2, iArr);
    }

    public static boolean m4129a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f2122a.mo604a(viewParent, view, f, f2, z);
    }

    public static boolean m4128a(ViewParent viewParent, View view, float f, float f2) {
        return f2122a.mo603a(viewParent, view, f, f2);
    }
}
