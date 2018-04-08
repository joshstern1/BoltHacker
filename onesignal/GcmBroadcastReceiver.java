package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.p021b.C0432l;

public class GcmBroadcastReceiver extends C0432l {
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && !"google.com/iid".equals(extras.getString("from"))) {
            C0432l.m2932a(context, intent.setComponent(new ComponentName(context.getPackageName(), GcmIntentService.class.getName())));
            setResultCode(-1);
        }
    }
}
