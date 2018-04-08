package com.onesignal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.reflect.Method;

class ba implements ServiceConnection {
    final /* synthetic */ az f9243a;

    ba(az azVar) {
        this.f9243a = azVar;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        az.f9232a = -99;
        this.f9243a.f9235d = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Method a = az.m15963c(Class.forName("com.android.vending.billing.IInAppBillingService$Stub"));
            a.setAccessible(true);
            this.f9243a.f9235d = a.invoke(null, new Object[]{iBinder});
            this.f9243a.m15964c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
