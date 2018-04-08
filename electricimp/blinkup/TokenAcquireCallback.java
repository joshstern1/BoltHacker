package com.electricimp.blinkup;

public interface TokenAcquireCallback {
    void onError(String str);

    void onSuccess(String str, String str2);
}
