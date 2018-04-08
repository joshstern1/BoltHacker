package com.onesignal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;

class at implements OnClickListener {
    final /* synthetic */ as f9218a;

    at(as asVar) {
        this.f9218a = asVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Editor edit = C2758w.m16097g(this.f9218a.f9217b.f9214a).edit();
        edit.putBoolean("GT_DO_NOT_SHOW_MISSING_GPS", true);
        edit.commit();
    }
}
