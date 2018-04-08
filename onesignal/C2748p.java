package com.onesignal;

import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.C1728a;
import com.google.android.gms.common.api.GoogleApiClient.C1729b;
import com.google.android.gms.common.api.GoogleApiClient.C1730c;
import com.google.android.gms.location.C1969k;
import com.onesignal.C2739i.C2737c;
import com.onesignal.C2758w.C2756d;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

class C2748p {
    static String f9269a;
    private static C2745o f9270b;
    private static C2747b f9271c;
    private static Thread f9272d;
    private static boolean f9273e;

    private static class C2746a implements C1729b, C1730c {
        private C2746a() {
        }

        public void mo1479a(Bundle bundle) {
            int i = 0;
            PermissionsActivity.f9167b = false;
            Location a = C1969k.f7101b.mo1621a(C2748p.f9270b.m16015c());
            if (a != null) {
                a.getAccuracy();
                Double valueOf = Double.valueOf(new BigDecimal(a.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
                Double valueOf2 = Double.valueOf(new BigDecimal(a.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
                Float valueOf3 = Float.valueOf(a.getAccuracy());
                if (!C2748p.f9273e) {
                    i = 1;
                }
                C2748p.m16024b(valueOf, valueOf2, valueOf3, Integer.valueOf(i));
            } else {
                C2748p.m16024b(null, null, null, null);
            }
            C2748p.f9270b.m16014b();
        }

        public void mo1478a(int i) {
            C2748p.m16023b();
        }

        public void mo1469a(ConnectionResult connectionResult) {
            C2748p.m16023b();
        }
    }

    interface C2747b {
        void mo2317a(Double d, Double d2, Float f, Integer num);
    }

    static void m16021a(Context context, boolean z, C2747b c2747b) {
        int i = -1;
        f9271c = c2747b;
        int a = C2737c.m15985a(context, "android.permission.ACCESS_FINE_LOCATION");
        if (a == -1) {
            i = C2737c.m15985a(context, "android.permission.ACCESS_COARSE_LOCATION");
            f9273e = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a == 0 || i == 0) {
                C2748p.m16020a();
            } else {
                c2747b.mo2317a(null, null, null, null);
            }
        } else if (a != 0) {
            try {
                List asList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
                if (asList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                    f9269a = "android.permission.ACCESS_FINE_LOCATION";
                } else if (asList.contains("android.permission.ACCESS_COARSE_LOCATION") && i != 0) {
                    f9269a = "android.permission.ACCESS_COARSE_LOCATION";
                }
                if (f9269a != null && z) {
                    PermissionsActivity.m15847a();
                } else if (i == 0) {
                    C2748p.m16020a();
                } else {
                    C2748p.m16023b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            C2748p.m16020a();
        }
    }

    static void m16020a() {
        try {
            C2748p.m16027e();
            C1730c c2746a = new C2746a();
            f9270b = new C2745o(new C1728a(C2758w.f9294c).m10793a(C1969k.f7100a).m10791a((C1729b) c2746a).m10792a(c2746a).m10795b());
            f9270b.m16013a();
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.WARN, "Location permission exists but there was an error initializing: ", th);
            C2748p.m16023b();
        }
    }

    private static void m16027e() {
        f9272d = new Thread(new C2749q());
        f9272d.start();
    }

    static void m16023b() {
        PermissionsActivity.f9167b = false;
        C2748p.m16024b(null, null, null, null);
        if (f9270b != null) {
            f9270b.m16014b();
        }
    }

    private static void m16024b(Double d, Double d2, Float f, Integer num) {
        f9271c.mo2317a(d, d2, f, num);
        if (f9272d != null && !Thread.currentThread().equals(f9272d)) {
            f9272d.interrupt();
        }
    }
}
