package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C3059d;

class C1080h implements Runnable {
    final /* synthetic */ C1077e f4120a;

    C1080h(C1077e c1077e) {
        this.f4120a = c1077e;
    }

    public void run() {
        try {
            this.f4120a.f4110b.mo1166a();
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to send events files", e);
        }
    }
}
