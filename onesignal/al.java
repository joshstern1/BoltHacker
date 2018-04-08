package com.onesignal;

import com.onesignal.C2758w.C2756d;
import com.onesignal.ag.C2721a;
import org.json.JSONObject;

final class al extends C2721a {
    final /* synthetic */ JSONObject f9205a;
    final /* synthetic */ JSONObject f9206b;

    al(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f9205a = jSONObject;
        this.f9206b = jSONObject2;
    }

    void mo2309a(int i, String str, Throwable th) {
        aj.f9197d = false;
        C2758w.m16057a(C2756d.WARN, "Failed last request. statusCode: " + i + "\nresponse: " + str);
        if (aj.m15915b(i, str, "not a valid device_type")) {
            aj.m15921f();
            aj.m15927l();
            return;
        }
        aj.m15911b(Integer.valueOf(0)).m15886c();
    }

    void mo2310a(String str) {
        aj.f9195b = true;
        aj.f9197d = false;
        aj.f9198e.m15897b(this.f9205a, this.f9206b);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("id")) {
                String string = jSONObject.getString("id");
                C2758w.m16077b(string);
                C2758w.m16084c();
                C2758w.m16057a(C2756d.INFO, "Device registered, UserId = " + string);
                return;
            }
            C2758w.m16057a(C2756d.INFO, "session sent, UserId = " + C2758w.m16092e());
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.ERROR, "ERROR parsing on_session or create JSON Response.", th);
        }
    }
}
