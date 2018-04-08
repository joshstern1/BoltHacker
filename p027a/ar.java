package android.support.v7.p027a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p021b.C0431k;
import android.util.Log;
import java.util.Calendar;

class ar {
    private static final C0777a f2503a = new C0777a();
    private final Context f2504b;
    private final LocationManager f2505c;

    private static class C0777a {
        boolean f2497a;
        long f2498b;
        long f2499c;
        long f2500d;
        long f2501e;
        long f2502f;

        private C0777a() {
        }
    }

    ar(Context context) {
        this.f2504b = context;
        this.f2505c = (LocationManager) context.getSystemService("location");
    }

    boolean m5082a() {
        C0777a c0777a = f2503a;
        if (m5080a(c0777a)) {
            return c0777a.f2497a;
        }
        Location b = m5081b();
        if (b != null) {
            m5079a(b);
            return c0777a.f2497a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location m5081b() {
        Location a;
        Location location = null;
        if (C0431k.m2930a(this.f2504b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            a = m5078a("network");
        } else {
            a = null;
        }
        if (C0431k.m2930a(this.f2504b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m5078a("gps");
        }
        if (location == null || a == null) {
            if (location == null) {
                location = a;
            }
            return location;
        } else if (location.getTime() > a.getTime()) {
            return location;
        } else {
            return a;
        }
    }

    private Location m5078a(String str) {
        if (this.f2505c != null) {
            try {
                if (this.f2505c.isProviderEnabled(str)) {
                    return this.f2505c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean m5080a(C0777a c0777a) {
        return c0777a != null && c0777a.f2502f > System.currentTimeMillis();
    }

    private void m5079a(Location location) {
        long j;
        C0777a c0777a = f2503a;
        long currentTimeMillis = System.currentTimeMillis();
        aq a = aq.m5076a();
        a.m5077a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f2494a;
        a.m5077a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f2496c == 1;
        long j3 = a.f2495b;
        long j4 = a.f2494a;
        a.m5077a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f2495b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        c0777a.f2497a = z;
        c0777a.f2498b = j2;
        c0777a.f2499c = j3;
        c0777a.f2500d = j4;
        c0777a.f2501e = j5;
        c0777a.f2502f = j;
    }
}
