package com.onesignal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.onesignal.C2758w.C2756d;

class C2734g implements C2732h {
    C2734g() {
    }

    public String mo2315a(Context context) {
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                return "OptedOut";
            }
            return id;
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.INFO, "Error getting Google Ad id: ", th);
            return null;
        }
    }
}
