package com.onesignal;

import com.google.android.gms.common.api.GoogleApiClient;

public class C2745o {
    private final GoogleApiClient f9267a;
    private final Class f9268b;

    public C2745o(GoogleApiClient googleApiClient) {
        this.f9267a = googleApiClient;
        this.f9268b = googleApiClient.getClass();
    }

    public void m16013a() {
        try {
            this.f9268b.getMethod("connect", new Class[0]).invoke(this.f9267a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void m16014b() {
        try {
            this.f9268b.getMethod("disconnect", new Class[0]).invoke(this.f9267a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public GoogleApiClient m16015c() {
        return this.f9267a;
    }
}
