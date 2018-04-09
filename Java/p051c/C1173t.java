package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;
import java.util.concurrent.Callable;

class C1173t implements Callable<T> {
    final /* synthetic */ Callable f4382a;
    final /* synthetic */ C1171r f4383b;

    C1173t(C1171r c1171r, Callable callable) {
        this.f4383b = c1171r;
        this.f4382a = callable;
    }

    public T call() throws Exception {
        try {
            return this.f4382a.call();
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }
}
