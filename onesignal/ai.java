package com.onesignal;

import com.onesignal.ag.C2721a;
import org.json.JSONObject;

final class ai implements Runnable {
    final /* synthetic */ String f9183a;
    final /* synthetic */ JSONObject f9184b;
    final /* synthetic */ C2721a f9185c;

    ai(String str, JSONObject jSONObject, C2721a c2721a) {
        this.f9183a = str;
        this.f9184b = jSONObject;
        this.f9185c = c2721a;
    }

    public void run() {
        ag.m15879b(this.f9183a, "POST", this.f9184b, this.f9185c);
    }
}
