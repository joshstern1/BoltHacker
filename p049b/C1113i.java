package com.p041a.p042a.p049b;

import java.io.IOException;
import org.json.JSONObject;

class C1113i {
    C1113i() {
    }

    public C1112h m7730a(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        return new C1112h(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
