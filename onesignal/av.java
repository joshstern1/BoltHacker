package com.onesignal;

import com.google.android.gms.p086b.C1665b;
import com.onesignal.C2758w.C2756d;

class av implements Runnable {
    final /* synthetic */ String f9220a;
    final /* synthetic */ ar f9221b;

    av(ar arVar, String str) {
        this.f9221b = arVar;
        this.f9220a = str;
    }

    public void run() {
        Object obj = null;
        int i = 0;
        while (i < ar.f9213c) {
            try {
                String a = C1665b.m10321a(this.f9221b.f9214a).m10333a(this.f9220a);
                C2758w.m16057a(C2756d.INFO, "Device registered, Google Registration ID = " + a);
                this.f9221b.f9215b.mo2316a(a);
                return;
            } catch (Throwable e) {
                if (!"SERVICE_NOT_AVAILABLE".equals(e.getMessage())) {
                    C2758w.m16058a(C2756d.ERROR, "Error Getting Google Registration ID", e);
                    if (obj == null) {
                        this.f9221b.f9215b.mo2316a(null);
                        return;
                    }
                    return;
                } else if (i >= ar.f9213c - 1) {
                    C2758w.m16058a(C2756d.ERROR, "GCM_RETRY_COUNT of " + ar.f9213c + " exceed! Could not get a Google Registration Id", e);
                } else {
                    C2758w.m16058a(C2756d.INFO, "Google Play services returned SERVICE_NOT_AVAILABLE error. Current retry count: " + i, e);
                    if (i == 2) {
                        this.f9221b.f9215b.mo2316a(null);
                        obj = 1;
                    }
                    Thread.sleep((long) ((i + 1) * 10000));
                }
            } catch (Throwable th) {
            }
        }
        return;
        i++;
    }
}
