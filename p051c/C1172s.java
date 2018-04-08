package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;

class C1172s implements Runnable {
    final /* synthetic */ Runnable f4380a;
    final /* synthetic */ C1171r f4381b;

    C1172s(C1171r c1171r, Runnable runnable) {
        this.f4381b = c1171r;
        this.f4380a = runnable;
    }

    public void run() {
        try {
            this.f4380a.run();
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Failed to execute task.", e);
        }
    }
}
