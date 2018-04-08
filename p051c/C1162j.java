package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;
import java.util.concurrent.Callable;

class C1162j implements Callable<Boolean> {
    final /* synthetic */ C1154g f4367a;

    C1162j(C1154g c1154g) {
        this.f4367a = c1154g;
    }

    public /* synthetic */ Object call() throws Exception {
        return m8010a();
    }

    public Boolean m8010a() throws Exception {
        try {
            boolean c = this.f4367a.f4346k.m8023c();
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Initialization marker file removed: " + c);
            return Boolean.valueOf(c);
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
            return Boolean.valueOf(false);
        }
    }
}
