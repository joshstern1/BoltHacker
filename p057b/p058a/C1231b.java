package com.p057b.p058a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v7.p027a.C0809o;
import android.support.v7.p027a.C0809o.C0808a;
import com.p057b.p058a.C1228a.C1227a;
import java.lang.ref.WeakReference;
import java.util.Date;

public class C1231b {
    private static final String f4574a = C1231b.class.getSimpleName();
    private static Date f4575b = new Date();
    private static int f4576c = 0;
    private static boolean f4577d = false;
    private static Date f4578e = new Date();
    private static C1230b f4579f = new C1230b();
    private static C1229a f4580g = null;
    private static WeakReference<C0809o> f4581h = null;

    public interface C1229a {
        void m8198a();

        void m8199b();

        void m8200c();
    }

    public static class C1230b {
        private int f4567a;
        private int f4568b;
        private int f4569c;
        private int f4570d;
        private int f4571e;
        private int f4572f;
        private int f4573g;

        public C1230b() {
            this(7, 10);
        }

        public C1230b(int i, int i2) {
            this.f4569c = 0;
            this.f4570d = 0;
            this.f4571e = 0;
            this.f4572f = 0;
            this.f4573g = 0;
            this.f4567a = i;
            this.f4568b = i2;
        }

        public void m8208a(int i) {
            this.f4569c = i;
        }

        public void m8209b(int i) {
            this.f4570d = i;
        }

        public void m8210c(int i) {
            this.f4571e = i;
        }

        public void m8211d(int i) {
            this.f4572f = i;
        }

        public void m8212e(int i) {
            this.f4573g = i;
        }
    }

    public static void m8217a(C1230b c1230b) {
        f4579f = c1230b;
    }

    public static void m8213a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RateThisApp", 0);
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.getLong("rta_install_date", 0) == 0) {
            C1231b.m8214a(context, edit);
        }
        int i = sharedPreferences.getInt("rta_launch_times", 0) + 1;
        edit.putInt("rta_launch_times", i);
        C1231b.m8218a("Launch times; " + i);
        edit.commit();
        f4575b = new Date(sharedPreferences.getLong("rta_install_date", 0));
        f4576c = sharedPreferences.getInt("rta_launch_times", 0);
        f4577d = sharedPreferences.getBoolean("rta_opt_out", false);
        f4578e = new Date(sharedPreferences.getLong("rta_ask_later_date", 0));
        C1231b.m8229f(context);
    }

    public static boolean m8220a(Context context, int i) {
        if (!C1231b.m8219a()) {
            return false;
        }
        C1231b.m8223b(context, i);
        return true;
    }

    public static boolean m8219a() {
        if (f4577d) {
            return false;
        }
        if (f4576c >= f4579f.f4568b) {
            return true;
        }
        long b = ((long) (((f4579f.f4567a * 24) * 60) * 60)) * 1000;
        if (new Date().getTime() - f4575b.getTime() < b || new Date().getTime() - f4578e.getTime() < b) {
            return false;
        }
        return true;
    }

    public static void m8223b(Context context, int i) {
        C1231b.m8215a(context, new C0808a(context, i));
    }

    private static void m8215a(Context context, C0808a c0808a) {
        if (f4581h == null || f4581h.get() == null) {
            int c = f4579f.f4569c != 0 ? f4579f.f4569c : C1227a.rta_dialog_title;
            int d = f4579f.f4570d != 0 ? f4579f.f4570d : C1227a.rta_dialog_message;
            int e = f4579f.f4573g != 0 ? f4579f.f4573g : C1227a.rta_dialog_cancel;
            int f = f4579f.f4572f != 0 ? f4579f.f4572f : C1227a.rta_dialog_no;
            int g = f4579f.f4571e != 0 ? f4579f.f4571e : C1227a.rta_dialog_ok;
            c0808a.m5274a(c);
            c0808a.m5284b(d);
            c0808a.m5275a(g, new C1232c(context));
            c0808a.m5287c(e, new C1233d(context));
            c0808a.m5285b(f, new C1234e(context));
            c0808a.m5276a(new C1235f(context));
            c0808a.m5277a(new C1236g());
            f4581h = new WeakReference(c0808a.m5288c());
        }
    }

    private static void m8227d(Context context) {
        Editor edit = context.getSharedPreferences("RateThisApp", 0).edit();
        edit.remove("rta_install_date");
        edit.remove("rta_launch_times");
        edit.commit();
    }

    private static void m8224b(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("RateThisApp", 0).edit();
        edit.putBoolean("rta_opt_out", z);
        edit.commit();
        f4577d = z;
    }

    private static void m8214a(Context context, Editor editor) {
        Date date;
        Date date2 = new Date();
        if (VERSION.SDK_INT >= 9) {
            try {
                date = new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            editor.putLong("rta_install_date", date.getTime());
            C1231b.m8218a("First install: " + date.toString());
        }
        date = date2;
        editor.putLong("rta_install_date", date.getTime());
        C1231b.m8218a("First install: " + date.toString());
    }

    private static void m8228e(Context context) {
        Editor edit = context.getSharedPreferences("RateThisApp", 0).edit();
        edit.putLong("rta_ask_later_date", System.currentTimeMillis());
        edit.commit();
    }

    private static void m8229f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RateThisApp", 0);
        C1231b.m8218a("*** RateThisApp Status ***");
        C1231b.m8218a("Install Date: " + new Date(sharedPreferences.getLong("rta_install_date", 0)));
        C1231b.m8218a("Launch Times: " + sharedPreferences.getInt("rta_launch_times", 0));
        C1231b.m8218a("Opt out: " + sharedPreferences.getBoolean("rta_opt_out", false));
    }

    private static void m8218a(String str) {
    }
}
