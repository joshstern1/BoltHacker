package com.p057b.p058a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class C1232c implements OnClickListener {
    final /* synthetic */ Context f4582a;

    C1232c(Context context) {
        this.f4582a = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (C1231b.f4580g != null) {
            C1231b.f4580g.m8198a();
        }
        this.f4582a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + this.f4582a.getPackageName())));
        C1231b.m8224b(this.f4582a, true);
    }
}
