package com.electricimp.blinkup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class BlinkupController extends BaseBlinkupController {
    private static final String DEFAULT_BASE_URL = "https://api.electricimp.com/v1";
    private static BlinkupController instance = null;

    public /* bridge */ /* synthetic */ void acquireSetupToken(Activity activity, String str, TokenAcquireCallback tokenAcquireCallback) {
        super.acquireSetupToken(activity, str, tokenAcquireCallback);
    }

    public /* bridge */ /* synthetic */ void cancelTokenStatusPolling() {
        super.cancelTokenStatusPolling();
    }

    public /* bridge */ /* synthetic */ void clearDevice(Activity activity) {
        super.clearDevice(activity);
    }

    public /* bridge */ /* synthetic */ void clearDevice(Activity activity, boolean z) {
        super.clearDevice(activity, z);
    }

    public /* bridge */ /* synthetic */ void clearSavedData(Context context) {
        super.clearSavedData(context);
    }

    public /* bridge */ /* synthetic */ void getTokenStatus(TokenStatusCallback tokenStatusCallback) {
        super.getTokenStatus(tokenStatusCallback);
    }

    public /* bridge */ /* synthetic */ void getTokenStatus(String str, TokenStatusCallback tokenStatusCallback, long j) {
        super.getTokenStatus(str, tokenStatusCallback, j);
    }

    public /* bridge */ /* synthetic */ void selectWifi(Activity activity, String str, int i, ServerErrorHandler serverErrorHandler) {
        super.selectWifi(activity, str, i, serverErrorHandler);
    }

    public /* bridge */ /* synthetic */ void selectWifiAndSetupDevice(Activity activity, String str, ServerErrorHandler serverErrorHandler) {
        super.selectWifiAndSetupDevice(activity, str, serverErrorHandler);
    }

    public /* bridge */ /* synthetic */ void setBaseUrl(String str) {
        super.setBaseUrl(str);
    }

    public /* bridge */ /* synthetic */ void setPlanID(String str) {
        super.setPlanID(str);
    }

    public /* bridge */ /* synthetic */ void setupDevice(Activity activity, String str, String str2, ServerErrorHandler serverErrorHandler) {
        super.setupDevice(activity, str, str2, serverErrorHandler);
    }

    public /* bridge */ /* synthetic */ void setupDevice(Activity activity, String str, String str2, String str3, boolean z, ServerErrorHandler serverErrorHandler) {
        super.setupDevice(activity, str, str2, str3, z, serverErrorHandler);
    }

    private BlinkupController(String str) {
        super(str);
    }

    public static BlinkupController getInstance() {
        if (instance == null) {
            instance = new BlinkupController(DEFAULT_BASE_URL);
        }
        return instance;
    }

    public void handleActivityResult(Activity activity, int i, int i2, Intent intent) {
        BaseBlinkupController instance = getInstance();
        if (i2 != -1 || instance.lastMode == null) {
            return;
        }
        if (instance.lastMode.equals(BaseBlinkupController.MODE_CLEAR)) {
            if (instance.intentClearComplete != null) {
                activity.startActivity(instance.intentClearComplete);
            }
        } else if (instance.intentBlinkupComplete != null) {
            activity.startActivity(instance.intentBlinkupComplete);
        }
    }
}
