package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p054g.C3028b;

class C1078f implements Runnable {
    final /* synthetic */ C3028b f4116a;
    final /* synthetic */ String f4117b;
    final /* synthetic */ C1077e f4118c;

    C1078f(C1077e c1077e, C3028b c3028b, String str) {
        this.f4118c = c1077e;
        this.f4116a = c3028b;
        this.f4117b = str;
    }

    public void run() {
        try {
            this.f4118c.f4110b.mo1168a(this.f4116a, this.f4117b);
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to set analytics settings data", e);
        }
    }
}
