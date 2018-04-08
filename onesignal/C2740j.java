package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.C2758w.C2756d;

public class C2740j {
    public static void m15987a(Context context, Bundle bundle, boolean z) {
        if (bundle.containsKey("bgn") && "1".equals(bundle.getString("bgn"))) {
            Intent intent = new Intent();
            intent.setAction("com.onesignal.BackgroundBroadcast.RECEIVE");
            intent.setPackage(context.getPackageName());
            Bundle bundle2 = new Bundle(bundle);
            bundle2.putBoolean("isActive", z);
            intent.putExtra("data", bundle2);
            context.sendBroadcast(intent);
            C2758w.m16057a(C2756d.VERBOSE, "Sent OneSignal BackgroundBroadcaster");
        }
    }
}
