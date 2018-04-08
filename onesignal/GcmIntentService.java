package com.onesignal;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.p021b.C0432l;

public class GcmIntentService extends IntentService {
    public GcmIntentService() {
        super("GcmIntentService");
    }

    private static boolean m15846a(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null || "gcm".equals(stringExtra)) {
            return true;
        }
        return false;
    }

    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (m15846a(intent)) {
            C2750r.m16030a(this, extras);
        }
        C0432l.m2933a(intent);
    }
}
