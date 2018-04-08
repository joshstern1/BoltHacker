package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.C0645j;
import android.support.v4.view.ao;
import android.view.View;
import android.widget.PopupWindow;

public final class ag {
    static final C0701f f2364a;

    interface C0701f {
        void mo677a(PopupWindow popupWindow, int i);

        void mo678a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void mo679a(PopupWindow popupWindow, boolean z);
    }

    static class C0702c implements C0701f {
        C0702c() {
        }

        public void mo678a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0645j.m4290a(i3, ao.m3938h(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo679a(PopupWindow popupWindow, boolean z) {
        }

        public void mo677a(PopupWindow popupWindow, int i) {
        }
    }

    static class C0703d extends C0702c {
        C0703d() {
        }

        public void mo677a(PopupWindow popupWindow, int i) {
            aj.m4700a(popupWindow, i);
        }
    }

    static class C0704e extends C0703d {
        C0704e() {
        }

        public void mo678a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            ak.m4701a(popupWindow, view, i, i2, i3);
        }
    }

    static class C0705a extends C0704e {
        C0705a() {
        }

        public void mo679a(PopupWindow popupWindow, boolean z) {
            ah.m4697a(popupWindow, z);
        }
    }

    static class C0706b extends C0705a {
        C0706b() {
        }

        public void mo679a(PopupWindow popupWindow, boolean z) {
            ai.m4699a(popupWindow, z);
        }

        public void mo677a(PopupWindow popupWindow, int i) {
            ai.m4698a(popupWindow, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f2364a = new C0706b();
        } else if (i >= 21) {
            f2364a = new C0705a();
        } else if (i >= 19) {
            f2364a = new C0704e();
        } else if (i >= 9) {
            f2364a = new C0703d();
        } else {
            f2364a = new C0702c();
        }
    }

    public static void m4695a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f2364a.mo678a(popupWindow, view, i, i2, i3);
    }

    public static void m4696a(PopupWindow popupWindow, boolean z) {
        f2364a.mo679a(popupWindow, z);
    }

    public static void m4694a(PopupWindow popupWindow, int i) {
        f2364a.mo677a(popupWindow, i);
    }
}
