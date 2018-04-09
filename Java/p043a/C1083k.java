package com.p041a.p042a.p043a;

import com.p041a.p042a.p043a.ae.C1070a;
import io.p038b.p039a.p040a.C3059d;

class C1083k implements Runnable {
    final /* synthetic */ C1070a f4123a;
    final /* synthetic */ boolean f4124b;
    final /* synthetic */ C1077e f4125c;

    C1083k(C1077e c1077e, C1070a c1070a, boolean z) {
        this.f4125c = c1077e;
        this.f4123a = c1070a;
        this.f4124b = z;
    }

    public void run() {
        try {
            this.f4125c.f4110b.mo1167a(this.f4123a);
            if (this.f4124b) {
                this.f4125c.f4110b.mo1170c();
            }
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to process event", e);
        }
    }
}
