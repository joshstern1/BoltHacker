package com.onesignal;

import android.app.AlertDialog.Builder;

class as implements Runnable {
    final /* synthetic */ int f9216a;
    final /* synthetic */ ar f9217b;

    as(ar arVar, int i) {
        this.f9217b = arVar;
        this.f9216a = i;
    }

    public void run() {
        new Builder(this.f9217b.f9214a).setMessage("To receive push notifications please press 'Update' to enable 'Google Play services'.").setPositiveButton("Update", new au(this)).setNegativeButton("Skip", new at(this)).setNeutralButton("Close", null).create().show();
    }
}
