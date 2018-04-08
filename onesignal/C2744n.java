package com.onesignal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

class C2744n implements OnCancelListener {
    final /* synthetic */ Intent f9265a;
    final /* synthetic */ C2742l f9266b;

    C2744n(C2742l c2742l, Intent intent) {
        this.f9266b = c2742l;
        this.f9265a = intent;
    }

    public void onCancel(DialogInterface dialogInterface) {
        C2753u.m16038b(this.f9266b.f9259a, this.f9265a);
    }
}
