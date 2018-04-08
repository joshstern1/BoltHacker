package com.onesignal;

import org.json.JSONObject;

final class ad implements Runnable {
    final /* synthetic */ String f9177a;
    final /* synthetic */ JSONObject f9178b;
    final /* synthetic */ boolean f9179c;

    ad(String str, JSONObject jSONObject, boolean z) {
        this.f9177a = str;
        this.f9178b = jSONObject;
        this.f9179c = z;
    }

    public void run() {
        C2758w.f9303l.m16044a(this.f9177a, this.f9178b, this.f9179c);
    }
}
