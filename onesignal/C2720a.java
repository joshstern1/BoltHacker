package com.onesignal;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.C2758w.C2756d;

class C2720a {
    static boolean f9173a;
    static Activity f9174b;
    static C2719c f9175c = new C2719c();
    private static C2717a f9176d;

    interface C2717a {
        void mo2311a(Activity activity);
    }

    private static class C2718b implements Runnable {
        private boolean f9169a;
        private boolean f9170b;

        private C2718b() {
        }

        public void run() {
            if (C2720a.f9174b == null) {
                this.f9169a = true;
                C2758w.m16068a(false);
                this.f9170b = true;
            }
        }
    }

    static class C2719c extends HandlerThread {
        Handler f9171a = null;
        private C2718b f9172b;

        C2719c() {
            super("FocusHandlerThread");
            start();
            this.f9171a = new Handler(getLooper());
        }

        void m15856a() {
            if (this.f9172b != null) {
                this.f9172b.f9169a = false;
            }
        }

        void m15858b() {
            this.f9171a.removeCallbacksAndMessages(null);
        }

        void m15857a(C2718b c2718b) {
            if (this.f9172b == null || !this.f9172b.f9169a || this.f9172b.f9170b) {
                this.f9172b = c2718b;
                this.f9171a.removeCallbacksAndMessages(null);
                this.f9171a.postDelayed(c2718b, 2000);
            }
        }

        boolean m15859c() {
            if (this.f9172b != null) {
                return this.f9172b.f9169a;
            }
            return false;
        }
    }

    static void m15862a(C2717a c2717a) {
        if (f9174b != null) {
            c2717a.mo2311a(f9174b);
            f9176d = c2717a;
            return;
        }
        f9176d = c2717a;
    }

    public static void m15865b(C2717a c2717a) {
        f9176d = null;
    }

    private static void m15871g(Activity activity) {
        f9174b = activity;
        if (f9176d != null) {
            f9176d.mo2311a(f9174b);
        }
    }

    static void m15861a(Activity activity) {
    }

    static void m15864b(Activity activity) {
    }

    static void m15867c(Activity activity) {
        C2720a.m15871g(activity);
        C2720a.m15860a();
        C2720a.m15866c();
    }

    static void m15868d(Activity activity) {
        if (activity == f9174b) {
            f9174b = null;
            C2720a.m15863b();
        }
        C2720a.m15860a();
    }

    static void m15869e(Activity activity) {
        C2758w.m16057a(C2756d.DEBUG, "onActivityStopped: " + activity.getClass().getName());
        if (activity == f9174b) {
            f9174b = null;
            C2720a.m15863b();
        }
        C2720a.m15860a();
    }

    static void m15870f(Activity activity) {
        C2758w.m16057a(C2756d.DEBUG, "onActivityDestroyed: " + activity.getClass().getName());
        if (activity == f9174b) {
            f9174b = null;
            C2720a.m15863b();
        }
        C2720a.m15860a();
    }

    private static void m15860a() {
        C2758w.m16057a(C2756d.DEBUG, "curActivity is NOW: " + (f9174b != null ? "" + f9174b.getClass().getName() + ":" + f9174b : "null"));
    }

    private static void m15863b() {
        f9175c.m15857a(new C2718b());
    }

    private static void m15866c() {
        if (f9175c.m15859c() || f9173a) {
            f9173a = false;
            f9175c.m15856a();
            C2758w.m16049a();
            return;
        }
        f9175c.m15858b();
    }
}
