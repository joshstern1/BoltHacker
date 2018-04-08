package com.onesignal;

import android.app.AlertDialog.Builder;
import com.onesignal.C2758w.C2756d;

final class C2761z implements Runnable {
    final /* synthetic */ C2756d f9318a;
    final /* synthetic */ String f9319b;

    C2761z(C2756d c2756d, String str) {
        this.f9318a = c2756d;
        this.f9319b = str;
    }

    public void run() {
        if (C2720a.f9174b != null) {
            new Builder(C2720a.f9174b).setTitle(this.f9318a.toString()).setMessage(this.f9319b).show();
        }
    }
}
