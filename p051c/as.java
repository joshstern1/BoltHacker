package com.p041a.p042a.p051c;

import android.content.Context;
import android.os.Bundle;

class as implements be {
    private final Context f4257a;
    private final String f4258b;

    public as(Context context, String str) {
        this.f4257a = context;
        this.f4258b = str;
    }

    public String mo1182a() {
        String str = null;
        try {
            Bundle bundle = this.f4257a.getPackageManager().getApplicationInfo(this.f4258b, 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.unity.crashlytics.version");
            }
        } catch (Exception e) {
        }
        return str;
    }
}
