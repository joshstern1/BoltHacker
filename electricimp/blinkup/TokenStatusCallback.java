package com.electricimp.blinkup;

import org.json.JSONObject;

public interface TokenStatusCallback {
    void onError(String str);

    void onSuccess(JSONObject jSONObject);

    void onTimeout();
}
