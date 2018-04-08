package com.codetroopers.betterpickers;

import android.content.Context;
import android.database.ContentObserver;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.System;

public class C1282a {
    private final Context f4726a;
    private final ContentObserver f4727b = new C1283b(this, null);
    private Vibrator f4728c;
    private boolean f4729d;
    private boolean f4730e;
    private long f4731f;

    public C1282a(Context context) {
        this.f4726a = context;
    }

    private static boolean m8497b(Context context) {
        return System.getInt(context.getContentResolver(), "haptic_feedback_enabled", 0) == 1;
    }

    private static boolean m8498c(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0;
    }

    public void m8499a() {
        this.f4728c = (Vibrator) this.f4726a.getSystemService("vibrator");
        this.f4729d = C1282a.m8497b(this.f4726a);
        this.f4730e = C1282a.m8498c(this.f4726a);
        this.f4726a.getContentResolver().registerContentObserver(System.getUriFor("haptic_feedback_enabled"), false, this.f4727b);
    }

    public void m8500b() {
        this.f4728c = null;
        this.f4726a.getContentResolver().unregisterContentObserver(this.f4727b);
    }

    public void m8501c() {
        if (this.f4728c != null && this.f4729d && this.f4730e) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f4731f >= 125) {
                this.f4728c.vibrate(5);
                this.f4731f = uptimeMillis;
            }
        }
    }
}
