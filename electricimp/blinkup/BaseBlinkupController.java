package com.electricimp.blinkup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import org.json.JSONException;
import org.json.JSONObject;

class BaseBlinkupController {
    static final int BLINKUP_REQUEST_CODE = 4;
    static final int CLEAR_REQUEST_CODE = 3;
    static final int DIRECT_BLINKUP_REQUEST_CODE = 5;
    static final int DIRECT_CLEAR_REQUEST_CODE = 6;
    public static final String FIELD_ERROR = "error";
    public static final String FIELD_MODE = "mode";
    public static final String FIELD_PASSWORD = "pwd";
    public static final String FIELD_PIN = "pin";
    public static final String FIELD_SSID = "ssid";
    public static final String FIELD_TOKEN = "token";
    private static final float FRAME_RATE_THRESHOLD = 45.0f;
    public static final String MODE_CLEAR = "clear";
    public static final String MODE_WIFI = "wifi";
    public static final String MODE_WPS = "wps";
    static final int NETWORK_LIST_REQUEST_CODE = 0;
    private static final String PREFERENCE_FILE_DEFAULT = "eimpPreferences";
    static final String TAG = "BlinkUp";
    static final int WIFI_REQUEST_CODE = 1;
    static final int WPS_REQUEST_CODE = 2;
    public int countdownSeconds = 3;
    public int drawableIdInterstitial = 0;
    public boolean enablePowerSaveMessage = true;
    private boolean frameRateCheckEnabled = true;
    private ImpController impController;
    public Intent intentBlinkupComplete = null;
    public Intent intentClearComplete = null;
    private String lastBitStream = null;
    protected String lastMode = null;
    private String lastSsid = null;
    private String preferenceFile = PREFERENCE_FILE_DEFAULT;
    public boolean setFullScreenBrightness = true;
    public boolean showClearConfig = true;
    public boolean showLegacyMode = false;
    public boolean showPassword = true;
    public String stringIdBlinkUpDesc = null;
    public String stringIdChangeNetwork = null;
    public String stringIdChooseWiFiNetwork = null;
    public String stringIdClearDeviceSettings = null;
    public String stringIdClearWireless = null;
    public String stringIdConnectUsingWps = null;
    public String stringIdCountdownDesc = null;
    public String stringIdLegacyMode = null;
    public String stringIdLegacyModeDesc = null;
    public String stringIdLowFrameRateDesc = null;
    public String stringIdLowFrameRateGoToSettings = null;
    public String stringIdLowFrameRateProceedAnyway = null;
    public String stringIdLowFrameRateTitle = null;
    public String stringIdNext = null;
    public String stringIdOk = null;
    public String stringIdPasswordHint = null;
    public String stringIdRememberPassword = null;
    public String stringIdSendBlinkUp = null;
    public String stringIdShowPassword = null;
    public String stringIdSsidHint = null;
    public String stringIdWpsInfo = null;
    public String stringIdWpsPinHint = null;

    private static class AcquireSetupTokenHandler extends Handler {
        private WeakReference<Activity> activity;
        private TokenAcquireCallback tokenAcquireCallback;

        public AcquireSetupTokenHandler(Activity activity, TokenAcquireCallback tokenAcquireCallback) {
            this.activity = new WeakReference(activity);
            this.tokenAcquireCallback = tokenAcquireCallback;
        }

        public void handleMessage(Message message) {
            if (this.activity.get() != null && !((Activity) this.activity.get()).isFinishing()) {
                Object obj;
                if (message.arg1 != 1) {
                    String str = (String) message.obj;
                } else if (this.tokenAcquireCallback != null) {
                    JSONObject jSONObject = (JSONObject) message.obj;
                    try {
                        String string = jSONObject.getString("id");
                        try {
                            new BigInteger(string, 16).longValue();
                            this.tokenAcquireCallback.onSuccess(jSONObject.getString("plan_id"), string);
                            obj = null;
                        } catch (NumberFormatException e) {
                            obj = e.getMessage();
                        }
                    } catch (JSONException e2) {
                        obj = e2.getMessage();
                    }
                } else {
                    obj = null;
                }
                if (!TextUtils.isEmpty(obj) && this.tokenAcquireCallback != null) {
                    this.tokenAcquireCallback.onError(obj);
                }
            }
        }
    }

    private static class TokenStatusHandler extends Handler {
        private final TokenStatusCallback callback;

        public TokenStatusHandler(TokenStatusCallback tokenStatusCallback) {
            this.callback = tokenStatusCallback;
        }

        public void handleMessage(Message message) {
            if (this.callback != null) {
                switch (message.arg1) {
                    case 0:
                        this.callback.onError((String) message.obj);
                        return;
                    case 1:
                        this.callback.onSuccess((JSONObject) message.obj);
                        return;
                    case 2:
                        this.callback.onTimeout();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setBaseUrl(String str) {
        this.impController.setBaseUrl(str);
    }

    public void setPlanID(String str) {
        this.impController.planID = str;
    }

    public void clearSavedData(Context context) {
        Editor edit = context.getSharedPreferences(PREFERENCE_FILE_DEFAULT, 0).edit();
        edit.clear();
        edit.commit();
        this.lastMode = null;
        this.lastSsid = null;
        this.lastBitStream = null;
        this.impController.setupToken = null;
        this.impController.planID = null;
        this.impController.apiKey = null;
    }

    public void selectWifiAndSetupDevice(Activity activity, String str, ServerErrorHandler serverErrorHandler) {
        selectWifiAndSetupDevice(activity, str);
    }

    public void selectWifi(Activity activity, String str, int i, ServerErrorHandler serverErrorHandler) {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.electricimp.blinkup.WifiSelectActivity");
        intent.putExtra("planID", this.impController.planID);
        intent.putExtra("preferenceFile", this.preferenceFile);
        intent.putExtra("tokenCreate", true);
        intent.putExtra("apiKey", str);
        activity.startActivityForResult(intent, i);
    }

    public void setupDevice(Activity activity, String str, String str2, String str3, ServerErrorHandler serverErrorHandler) {
        setupDeviceSsid(activity, str, str2, str3, false);
    }

    public void setupDevice(Activity activity, String str, String str2, String str3, boolean z, ServerErrorHandler serverErrorHandler) {
        setupDeviceSsid(activity, str, str2, str3, z);
    }

    public void setupDevice(Activity activity, String str, String str2, ServerErrorHandler serverErrorHandler) {
        setupDeviceWpsPin(activity, str, str2, false);
    }

    public void setupDevice(Activity activity, String str, String str2, boolean z, ServerErrorHandler serverErrorHandler) {
        setupDeviceWpsPin(activity, str, str2, z);
    }

    public void clearDevice(Activity activity) {
        clearDevice(activity, false);
    }

    public void clearDevice(Activity activity, boolean z) {
        Intent intent = new Intent();
        intent.putExtra(FIELD_MODE, MODE_CLEAR);
        intent.putExtra("slow", z);
        addBlinkupIntentFields(activity, intent);
        activity.startActivityForResult(intent, 6);
    }

    public static String getCurrentWifiSSID(Context context) {
        NetworkInfo[] networkInfoArr;
        int i = 0;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (VERSION.SDK_INT >= 21) {
            Network[] allNetworks = connectivityManager.getAllNetworks();
            NetworkInfo[] networkInfoArr2 = new NetworkInfo[allNetworks.length];
            for (int i2 = 0; i2 < allNetworks.length; i2++) {
                networkInfoArr2[i2] = connectivityManager.getNetworkInfo(allNetworks[i2]);
            }
            networkInfoArr = networkInfoArr2;
        } else {
            networkInfoArr = getAllNetworkInfo(connectivityManager);
        }
        int length = networkInfoArr.length;
        while (i < length) {
            NetworkInfo networkInfo = networkInfoArr[i];
            if (networkInfo.getType() == 1 && networkInfo.isConnected()) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getSystemService(MODE_WIFI)).getConnectionInfo();
                    if (!(connectionInfo == null || connectionInfo.getSSID() == null)) {
                        return connectionInfo.getSSID().replaceAll("\"", "");
                    }
                } catch (Throwable e) {
                    Log.v(TAG, "Error getting the current network");
                    Log.v(TAG, Log.getStackTraceString(e));
                }
            }
            i++;
        }
        return null;
    }

    private static NetworkInfo[] getAllNetworkInfo(ConnectivityManager connectivityManager) {
        return connectivityManager.getAllNetworkInfo();
    }

    public void acquireSetupToken(Activity activity, String str, TokenAcquireCallback tokenAcquireCallback) {
        this.impController.acquireSetupToken(str, new AcquireSetupTokenHandler(activity, tokenAcquireCallback));
    }

    public void getTokenStatus(TokenStatusCallback tokenStatusCallback) {
        this.impController.getTokenStatus(new TokenStatusHandler(tokenStatusCallback));
    }

    public void getTokenStatus(String str, TokenStatusCallback tokenStatusCallback) {
        this.impController.getTokenStatus(str, new TokenStatusHandler(tokenStatusCallback));
    }

    public void getTokenStatus(TokenStatusCallback tokenStatusCallback, long j) {
        this.impController.getTokenStatus(new TokenStatusHandler(tokenStatusCallback), j);
    }

    public void getTokenStatus(String str, TokenStatusCallback tokenStatusCallback, long j) {
        this.impController.getTokenStatus(str, new TokenStatusHandler(tokenStatusCallback), j);
    }

    public void cancelTokenStatusPolling() {
        this.impController.cancelTokenStatusPolling();
    }

    void selectWifiAndSetupDeviceWithSetupToken(Activity activity, String str, String str2) {
        this.impController.setupToken = str;
        this.impController.planID = str2;
        selectWifiAndSetupDevice(activity, null);
    }

    void saveLastMode(String str) {
        this.lastMode = str;
    }

    String getLastMode() {
        return this.lastMode;
    }

    void saveLastSsid(String str) {
        this.lastSsid = str;
    }

    String getLastSsid() {
        return this.lastSsid;
    }

    void saveLastBitStream(String str) {
        this.lastBitStream = str;
    }

    String getLastBitStream() {
        return this.lastBitStream;
    }

    static void setText(TextView textView, String str, int i) {
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText(i);
        }
    }

    static void setHint(TextView textView, String str, int i) {
        if (str != null) {
            textView.setHint(str);
        } else {
            textView.setHint(i);
        }
    }

    static String getCustomStringOrDefault(Context context, String str, int i) {
        return str != null ? str : context.getString(i);
    }

    void addBlinkupIntentFields(Context context, Intent intent) {
        if (!intent.getBooleanExtra("slow", false)) {
            intent.putExtra("trilevel", true);
        }
        if (this.drawableIdInterstitial > 0) {
            intent.setClassName(context, "com.electricimp.blinkup.InterstitialActivity");
        } else {
            intent.setClassName(context, "com.electricimp.blinkup.BlinkupGLActivity");
        }
    }

    boolean shouldCheckFrameRate(Context context) {
        if (!this.enablePowerSaveMessage || !this.frameRateCheckEnabled) {
            return false;
        }
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate() >= FRAME_RATE_THRESHOLD;
    }

    boolean isFrameRateTooLow(float f) {
        if (f >= FRAME_RATE_THRESHOLD) {
            return false;
        }
        this.frameRateCheckEnabled = false;
        return true;
    }

    protected BaseBlinkupController(String str) {
        this.impController = new ImpController(str);
    }

    private void setupDeviceSsid(Activity activity, String str, String str2, String str3, boolean z) {
        if (str != null && str.length() != 0) {
            Intent intent = new Intent();
            intent.putExtra(FIELD_MODE, MODE_WIFI);
            intent.putExtra(FIELD_SSID, str);
            intent.putExtra(FIELD_PASSWORD, str2);
            intent.putExtra(FIELD_TOKEN, this.impController.setupToken);
            intent.putExtra("siteid", this.impController.planID);
            intent.putExtra("apiKey", str3);
            intent.putExtra("slow", z);
            addBlinkupIntentFields(activity, intent);
            activity.startActivityForResult(intent, 5);
        }
    }

    private void setupDeviceWpsPin(Activity activity, String str, String str2, boolean z) {
        Intent intent = new Intent();
        intent.putExtra(FIELD_MODE, MODE_WPS);
        intent.putExtra(FIELD_PIN, str);
        intent.putExtra(FIELD_TOKEN, this.impController.setupToken);
        intent.putExtra("siteid", this.impController.planID);
        intent.putExtra("apiKey", str2);
        intent.putExtra("slow", z);
        addBlinkupIntentFields(activity, intent);
        activity.startActivityForResult(intent, 5);
    }

    private void selectWifiAndSetupDevice(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.electricimp.blinkup.WifiSelectActivity");
        intent.putExtra("setupToken", this.impController.setupToken);
        intent.putExtra("planID", this.impController.planID);
        intent.putExtra("preferenceFile", this.preferenceFile);
        if (str != null) {
            intent.putExtra("apiKey", str);
        }
        activity.startActivityForResult(intent, 0);
    }
}
