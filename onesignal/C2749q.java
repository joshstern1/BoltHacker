package com.onesignal;

import com.onesignal.C2758w.C2756d;

final class C2749q implements Runnable {
    C2749q() {
    }

    public void run() {
        try {
            Thread.sleep(30000);
            C2758w.m16057a(C2756d.WARN, "Location permission exists but GoogleApiClient timedout. Maybe related to mismatch google-play aar versions.");
            C2748p.m16023b();
        } catch (Throwable th) {
        }
    }
}
