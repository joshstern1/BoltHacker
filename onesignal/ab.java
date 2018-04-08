package com.onesignal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.onesignal.aj.C2723b;
import java.util.List;
import java.util.Locale;

final class ab implements Runnable {
    ab() {
    }

    public void run() {
        C2723b b = aj.m15912b();
        Object packageName = C2758w.f9294c.getPackageName();
        PackageManager packageManager = C2758w.f9294c.getPackageManager();
        b.m15900a("app_id", C2758w.f9292a);
        b.m15900a("identifier", C2758w.f9314w);
        Object a = C2758w.f9310s.mo2315a(C2758w.f9294c);
        if (a == null) {
            a = new C2733f().mo2315a(C2758w.f9294c);
        }
        b.m15900a("ad_id", a);
        b.m15900a("device_os", VERSION.RELEASE);
        b.m15900a("timezone", Integer.valueOf(C2758w.m16116w()));
        b.m15900a("language", Locale.getDefault().getLanguage());
        b.m15900a("sdk", (Object) "020104");
        b.m15900a("sdk_type", C2758w.f9296e);
        b.m15900a("android_package", packageName);
        b.m15900a("device_model", Build.MODEL);
        b.m15900a("device_type", Integer.valueOf(C2758w.f9311t));
        b.m15901b("subscribableStatus", Integer.valueOf(C2758w.f9302k));
        try {
            b.m15900a("game_version", Integer.valueOf(packageManager.getPackageInfo(packageName, 0).versionCode));
        } catch (NameNotFoundException e) {
        }
        List installedPackages = packageManager.getInstalledPackages(0);
        int i = -1;
        for (int i2 = 0; i2 < installedPackages.size(); i2++) {
            int i3;
            if ((((PackageInfo) installedPackages.get(i2)).applicationInfo.flags & 1) == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            i += i3;
        }
        b.m15900a("pkgc", Integer.valueOf(i));
        b.m15900a("net_type", C2758w.f9312u.m16041b());
        b.m15900a("carrier", C2758w.f9312u.m16042c());
        b.m15900a("rooted", Boolean.valueOf(aw.m15946a()));
        b.m15900a("lat", C2758w.f9317z);
        b.m15900a("long", C2758w.f9288A);
        b.m15900a("loc_acc", C2758w.f9289B);
        b.m15900a("loc_type", C2758w.f9290C);
        aj.m15906a(b);
    }
}
