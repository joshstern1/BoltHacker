package com.onesignal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService extends Service {
    private void m15851b() {
        long f = C2758w.m16095f();
        if (f >= 60) {
            C2758w.m16051a(f, true);
        }
    }

    public void onCreate() {
        if (C2758w.f9294c == null) {
            C2758w.f9294c = getApplicationContext();
            new Thread(new ax(this)).start();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        m15849a();
    }

    static void m15849a() {
        C2720a.f9175c.m15858b();
        aj.m15904a();
        C2758w.m16068a(true);
    }
}
