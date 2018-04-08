package com.onesignal;

import android.app.PendingIntent.CanceledException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.google.android.gms.common.GooglePlayServicesUtil;

class au implements OnClickListener {
    final /* synthetic */ as f9219a;

    au(as asVar) {
        this.f9219a = asVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            GooglePlayServicesUtil.getErrorPendingIntent(this.f9219a.f9216a, this.f9219a.f9217b.f9214a, 0).send();
        } catch (CanceledException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
