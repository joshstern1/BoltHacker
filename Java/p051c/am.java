package com.p041a.p042a.p051c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class am {
    private static final IntentFilter f4241a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter f4242b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter f4243c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final AtomicBoolean f4244d;
    private final Context f4245e;
    private final BroadcastReceiver f4246f;
    private final BroadcastReceiver f4247g;
    private boolean f4248h;

    public am(Context context) {
        int i = -1;
        this.f4245e = context;
        Intent registerReceiver = context.registerReceiver(null, f4241a);
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        boolean z = i == 2 || i == 5;
        this.f4248h = z;
        this.f4247g = new an(this);
        this.f4246f = new ao(this);
        context.registerReceiver(this.f4247g, f4242b);
        context.registerReceiver(this.f4246f, f4243c);
        this.f4244d = new AtomicBoolean(true);
    }

    public boolean m7750a() {
        return this.f4248h;
    }

    public void m7751b() {
        if (this.f4244d.getAndSet(false)) {
            this.f4245e.unregisterReceiver(this.f4247g);
            this.f4245e.unregisterReceiver(this.f4246f);
        }
    }
}
