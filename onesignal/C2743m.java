package com.onesignal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import java.util.List;
import org.json.JSONObject;

class C2743m implements OnClickListener {
    final /* synthetic */ List f9262a;
    final /* synthetic */ Intent f9263b;
    final /* synthetic */ C2742l f9264c;

    C2743m(C2742l c2742l, List list, Intent intent) {
        this.f9264c = c2742l;
        this.f9262a = list;
        this.f9263b = intent;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = i + 3;
        if (this.f9262a.size() > 1) {
            try {
                JSONObject jSONObject = new JSONObject(this.f9264c.f9260b.getString("custom"));
                jSONObject.getJSONObject("a").put("actionSelected", this.f9262a.get(i2));
                JSONObject jSONObject2 = new JSONObject(this.f9264c.f9260b.toString());
                jSONObject2.put("custom", jSONObject.toString());
                this.f9263b.putExtra("onesignal_data", jSONObject2.toString());
                C2753u.m16038b(this.f9264c.f9259a, this.f9263b);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        C2753u.m16038b(this.f9264c.f9259a, this.f9263b);
    }
}
