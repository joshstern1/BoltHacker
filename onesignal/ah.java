package com.onesignal;

import com.onesignal.ag.C2721a;
import org.json.JSONObject;

final class ah implements Runnable {
    final /* synthetic */ String f9180a;
    final /* synthetic */ JSONObject f9181b;
    final /* synthetic */ C2721a f9182c;

    ah(String str, JSONObject jSONObject, C2721a c2721a) {
        this.f9180a = str;
        this.f9181b = jSONObject;
        this.f9182c = c2721a;
    }

    public void run() {
        ag.m15879b(this.f9180a, "PUT", this.f9181b, this.f9182c);
    }
}
