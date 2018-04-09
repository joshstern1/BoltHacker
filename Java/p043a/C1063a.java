package com.p041a.p042a.p043a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p046b.C2958l.C2959a;
import io.p038b.p039a.p040a.p044a.p054g.C3048q;
import io.p038b.p039a.p040a.p044a.p054g.C3050t;
import java.io.File;

public class C1063a extends C1062l<Boolean> {
    ac f4039a;

    protected /* synthetic */ Object mo1150f() {
        return m7558e();
    }

    public static C1063a m7553c() {
        return (C1063a) C3059d.m17334a(C1063a.class);
    }

    public void m7555a(C1091r c1091r) {
        if (c1091r == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f4039a != null) {
            this.f4039a.m7588a(c1091r);
        }
    }

    public void m7556a(C2959a c2959a) {
        if (this.f4039a != null) {
            this.f4039a.m7590a(c2959a.m17021a(), c2959a.m17022b());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean h_() {
        try {
            long j;
            Context E = m7540E();
            PackageManager packageManager = E.getPackageManager();
            String packageName = E.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                j = packageInfo.firstInstallTime;
            } else {
                j = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f4039a = ac.m7585a(this, E, m7539D(), num, str, j);
            this.f4039a.m7592b();
            return true;
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    protected Boolean m7558e() {
        try {
            C3050t b = C3048q.m17296a().m17300b();
            if (b == null) {
                C3059d.m17342h().mo2438e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f10078d.f10048d) {
                C3059d.m17342h().mo2431a("Answers", "Analytics collection enabled");
                this.f4039a.m7589a(b.f10079e, m7560g());
                return Boolean.valueOf(true);
            } else {
                C3059d.m17342h().mo2431a("Answers", "Analytics collection disabled");
                this.f4039a.m7594c();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String mo1149b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String mo1148a() {
        return "1.3.8.127";
    }

    String m7560g() {
        return C2956j.m17003b(m7540E(), "com.crashlytics.ApiEndpoint");
    }
}
