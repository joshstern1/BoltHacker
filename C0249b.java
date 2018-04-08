package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0558l;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class C0249b {
    private static final C0594b f1225a;
    private static final Object f1226c = f1225a.mo586a();
    final Object f1227b = f1225a.mo587a(this);

    interface C0594b {
        C0558l mo585a(Object obj, View view);

        Object mo586a();

        Object mo587a(C0249b c0249b);

        void mo588a(Object obj, View view, int i);

        void mo589a(Object obj, View view, C0547e c0547e);

        boolean mo590a(Object obj, View view, int i, Bundle bundle);

        boolean mo591a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean mo592a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo593b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo594c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo595d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static class C0595d implements C0594b {
        C0595d() {
        }

        public Object mo586a() {
            return null;
        }

        public Object mo587a(C0249b c0249b) {
            return null;
        }

        public boolean mo591a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void mo593b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo589a(Object obj, View view, C0547e c0547e) {
        }

        public void mo594c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean mo592a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void mo588a(Object obj, View view, int i) {
        }

        public void mo595d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public C0558l mo585a(Object obj, View view) {
            return null;
        }

        public boolean mo590a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class C0596a extends C0595d {
        C0596a() {
        }

        public Object mo586a() {
            return C0635e.m4259a();
        }

        public Object mo587a(C0249b c0249b) {
            return C0635e.m4260a(new C0632c(this, c0249b));
        }

        public boolean mo591a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return C0635e.m4263a(obj, view, accessibilityEvent);
        }

        public void mo593b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0635e.m4265b(obj, view, accessibilityEvent);
        }

        public void mo589a(Object obj, View view, C0547e c0547e) {
            C0635e.m4262a(obj, view, c0547e.m3433a());
        }

        public void mo594c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0635e.m4266c(obj, view, accessibilityEvent);
        }

        public boolean mo592a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C0635e.m4264a(obj, viewGroup, view, accessibilityEvent);
        }

        public void mo588a(Object obj, View view, int i) {
            C0635e.m4261a(obj, view, i);
        }

        public void mo595d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0635e.m4267d(obj, view, accessibilityEvent);
        }
    }

    static class C0597c extends C0596a {
        C0597c() {
        }

        public Object mo587a(C0249b c0249b) {
            return C0637g.m4268a(new C0634d(this, c0249b));
        }

        public C0558l mo585a(Object obj, View view) {
            Object a = C0637g.m4269a(obj, view);
            if (a != null) {
                return new C0558l(a);
            }
            return null;
        }

        public boolean mo590a(Object obj, View view, int i, Bundle bundle) {
            return C0637g.m4270a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1225a = new C0597c();
        } else if (VERSION.SDK_INT >= 14) {
            f1225a = new C0596a();
        } else {
            f1225a = new C0595d();
        }
    }

    Object m1877a() {
        return this.f1227b;
    }

    public void m1878a(View view, int i) {
        f1225a.mo588a(f1226c, view, i);
    }

    public void m1884c(View view, AccessibilityEvent accessibilityEvent) {
        f1225a.mo595d(f1226c, view, accessibilityEvent);
    }

    public boolean mo667d(View view, AccessibilityEvent accessibilityEvent) {
        return f1225a.mo591a(f1226c, view, accessibilityEvent);
    }

    public void mo221b(View view, AccessibilityEvent accessibilityEvent) {
        f1225a.mo594c(f1226c, view, accessibilityEvent);
    }

    public void mo220a(View view, AccessibilityEvent accessibilityEvent) {
        f1225a.mo593b(f1226c, view, accessibilityEvent);
    }

    public void mo219a(View view, C0547e c0547e) {
        f1225a.mo589a(f1226c, view, c0547e);
    }

    public boolean mo666a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f1225a.mo592a(f1226c, viewGroup, view, accessibilityEvent);
    }

    public C0558l mo716a(View view) {
        return f1225a.mo585a(f1226c, view);
    }

    public boolean mo431a(View view, int i, Bundle bundle) {
        return f1225a.mo590a(f1226c, view, i, bundle);
    }
}
