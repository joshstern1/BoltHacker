package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.onesignal.C2758w.C2756d;
import com.onesignal.ao.C2724a;

public class ar implements ao {
    private static int f9213c = 5;
    private Context f9214a;
    private C2724a f9215b;

    public void mo2312a(Context context, String str, C2724a c2724a) {
        this.f9214a = context;
        this.f9215b = c2724a;
        try {
            if (m15944c()) {
                m15941a(str);
                return;
            }
            C2758w.m16057a(C2756d.ERROR, "No valid Google Play services APK found.");
            this.f9215b.mo2316a(null);
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.ERROR, "Could not register with GCM due to an error with the AndroidManifest.xml file or with 'Google Play services'.", th);
            this.f9215b.mo2316a(null);
        }
    }

    private boolean m15943b() {
        try {
            PackageManager packageManager = this.f9214a.getPackageManager();
            String str = (String) packageManager.getPackageInfo("com.android.vending", 1).applicationInfo.loadLabel(packageManager);
            if (str == null || str.equals("Market")) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean m15944c() {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f9214a);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable) && m15943b()) {
            C2758w.m16057a(C2756d.INFO, "Google Play services Recoverable Error: " + isGooglePlayServicesAvailable);
            if (C2758w.m16097g(this.f9214a).getBoolean("GT_DO_NOT_SHOW_MISSING_GPS", false)) {
                return false;
            }
            try {
                m15940a(isGooglePlayServicesAvailable);
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        C2758w.m16057a(C2756d.WARN, "Google Play services error: This device is not supported. Code:" + isGooglePlayServicesAvailable);
        return false;
    }

    private void m15940a(int i) {
        ((Activity) this.f9214a).runOnUiThread(new as(this, i));
    }

    private void m15941a(String str) {
        new Thread(new av(this, str)).start();
    }
}
