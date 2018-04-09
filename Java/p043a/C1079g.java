package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C3059d;

class C1079g implements Runnable {
    final /* synthetic */ C1077e f4119a;

    C1079g(C1077e c1077e) {
        this.f4119a = c1077e;
    }

    public void run() {
        try {
            ad adVar = this.f4119a.f4110b;
            this.f4119a.f4110b = new C1092s();
            adVar.mo1169b();
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to disable events", e);
        }
    }
}
