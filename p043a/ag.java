package com.p041a.p042a.p043a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import io.p038b.p039a.p040a.p044a.p045d.C1072a;
import java.io.IOException;
import org.json.JSONObject;

class ag implements C1072a<ae> {
    ag() {
    }

    public byte[] m7612a(ae aeVar) throws IOException {
        return m7614b(aeVar).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject m7614b(ae aeVar) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            af afVar = aeVar.f4076a;
            jSONObject.put("appBundleId", afVar.f4085a);
            jSONObject.put("executionId", afVar.f4086b);
            jSONObject.put("installationId", afVar.f4087c);
            jSONObject.put("androidId", afVar.f4088d);
            jSONObject.put("advertisingId", afVar.f4089e);
            jSONObject.put("limitAdTrackingEnabled", afVar.f4090f);
            jSONObject.put("betaDeviceToken", afVar.f4091g);
            jSONObject.put("buildId", afVar.f4092h);
            jSONObject.put("osVersion", afVar.f4093i);
            jSONObject.put("deviceModel", afVar.f4094j);
            jSONObject.put("appVersionCode", afVar.f4095k);
            jSONObject.put("appVersionName", afVar.f4096l);
            jSONObject.put("timestamp", aeVar.f4077b);
            jSONObject.put("type", aeVar.f4078c.toString());
            if (aeVar.f4079d != null) {
                jSONObject.put("details", new JSONObject(aeVar.f4079d));
            }
            jSONObject.put("customType", aeVar.f4080e);
            if (aeVar.f4081f != null) {
                jSONObject.put("customAttributes", new JSONObject(aeVar.f4081f));
            }
            jSONObject.put("predefinedType", aeVar.f4082g);
            if (aeVar.f4083h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(aeVar.f4083h));
            }
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
