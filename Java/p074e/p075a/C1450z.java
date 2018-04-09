package com.p074e.p075a;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.p074e.p075a.C1402r.C1439a;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ak.C1411a;
import java.io.IOException;
import java.io.InputStream;

class C1450z extends ak {
    private final C1402r f5534a;
    private final am f5535b;

    static class C1449a extends IOException {
        public C1449a(String str) {
            super(str);
        }
    }

    public C1450z(C1402r c1402r, am amVar) {
        this.f5534a = c1402r;
        this.f5535b = amVar;
    }

    public boolean mo1326a(ah ahVar) {
        String scheme = ahVar.f5372d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    public C1411a mo1325a(ah ahVar, int i) throws IOException {
        C1439a a = this.f5534a.mo1323a(ahVar.f5372d, ahVar.f5371c);
        if (a == null) {
            return null;
        }
        C1406d c1406d = a.f5500c ? C1406d.DISK : C1406d.NETWORK;
        Bitmap b = a.m9166b();
        if (b != null) {
            return new C1411a(b, c1406d);
        }
        InputStream a2 = a.m9165a();
        if (a2 == null) {
            return null;
        }
        if (c1406d == C1406d.DISK && a.m9167c() == 0) {
            as.m9080a(a2);
            throw new C1449a("Received response with 0 content-length header.");
        }
        if (c1406d == C1406d.NETWORK && a.m9167c() > 0) {
            this.f5535b.m9046a(a.m9167c());
        }
        return new C1411a(a2, c1406d);
    }

    int mo1335a() {
        return 2;
    }

    boolean mo1336a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    boolean mo1337b() {
        return true;
    }
}
