package com.onesignal;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.util.Arrays;
import java.util.List;

class C2733f implements C2732h {
    private static final List<String> f9253a = Arrays.asList(new String[]{"", "0", "unknown", "739463", "000000000000000", "111111111111111", "352005048247251", "012345678912345", "012345678901237", "88508850885050", "0123456789abcde", "004999010640000", "862280010599525", "52443443484950", "355195000000017", "001068000000006", "358673013795895", "355692547693084", "004400152020000", "8552502717594321", "113456798945455", "012379000772883", "111111111111119", "358701042909755", "358000043654134", "345630000000115", "356299046587760", "356591000000222"});

    C2733f() {
    }

    public String mo2315a(Context context) {
        String b = m15978b(context);
        if (b != null) {
            return b;
        }
        b = m15979c(context);
        return b == null ? m15980d(context) : b;
    }

    private String m15978b(Context context) {
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (!(deviceId == null || f9253a.contains(deviceId))) {
                return deviceId;
            }
        } catch (RuntimeException e) {
        }
        return null;
    }

    private String m15979c(Context context) {
        try {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            if (string != "9774d56d682e549c") {
                return string;
            }
        } catch (RuntimeException e) {
        }
        return null;
    }

    private String m15980d(Context context) {
        try {
            if (VERSION.SDK_INT < 23) {
                return ((WifiManager) context.getSystemService(BaseBlinkupController.MODE_WIFI)).getConnectionInfo().getMacAddress();
            }
        } catch (RuntimeException e) {
        }
        return null;
    }
}
