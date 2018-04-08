package com.onesignal;

import com.onesignal.C2758w.C2756d;
import com.onesignal.ag.C2721a;
import org.json.JSONObject;

final class ak extends C2721a {
    final /* synthetic */ JSONObject f9203a;
    final /* synthetic */ JSONObject f9204b;

    ak(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f9203a = jSONObject;
        this.f9204b = jSONObject2;
    }

    void mo2309a(int i, String str, Throwable th) {
        C2758w.m16057a(C2756d.WARN, "Failed last request. statusCode: " + i + "\nresponse: " + str);
        if (aj.m15915b(i, str, "No user with this id found")) {
            aj.m15921f();
            aj.m15927l();
            return;
        }
        aj.m15911b(Integer.valueOf(0)).m15886c();
    }

    void mo2310a(String str) {
        aj.f9198e.m15897b(this.f9203a, this.f9204b);
    }
}
