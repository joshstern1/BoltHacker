package com.onesignal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

class C2754v {
    C2754v() {
    }

    int m16040a() {
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            return 2;
        } catch (ClassNotFoundException e) {
            return 1;
        }
    }

    Integer m16041b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) C2758w.f9294c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1 || type == 9) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(1);
    }

    String m16042c() {
        String networkOperatorName = ((TelephonyManager) C2758w.f9294c.getSystemService("phone")).getNetworkOperatorName();
        return "".equals(networkOperatorName) ? null : networkOperatorName;
    }
}
