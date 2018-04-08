package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C3059d;

class C1082j implements Runnable {
    final /* synthetic */ C1077e f4122a;

    C1082j(C1077e c1077e) {
        this.f4122a = c1077e;
    }

    public void run() {
        try {
            this.f4122a.f4110b.mo1170c();
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to flush events", e);
        }
    }
}
