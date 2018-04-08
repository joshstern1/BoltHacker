package com.p041a.p042a.p051c;

import com.p041a.p042a.p051c.p052a.p053a.C1120d;
import io.p038b.p039a.p040a.C3059d;
import java.util.concurrent.Callable;

class ab implements Callable<Boolean> {
    final /* synthetic */ C1182y f4227a;

    ab(C1182y c1182y) {
        this.f4227a = c1182y;
    }

    public /* synthetic */ Object call() throws Exception {
        return m7740a();
    }

    public Boolean m7740a() throws Exception {
        if (this.f4227a.f4401k.get()) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
            return Boolean.FALSE;
        }
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Finalizing previously open sessions.");
        C1120d v = this.f4227a.f4404n.m7986v();
        if (v != null) {
            this.f4227a.m8036a(v);
        }
        this.f4227a.m8052a(true);
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Closed all previously open sessions");
        return Boolean.TRUE;
    }
}
