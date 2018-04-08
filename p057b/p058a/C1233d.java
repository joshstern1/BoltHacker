package com.p057b.p058a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C1233d implements OnClickListener {
    final /* synthetic */ Context f4583a;

    C1233d(Context context) {
        this.f4583a = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (C1231b.f4580g != null) {
            C1231b.f4580g.m8200c();
        }
        C1231b.m8227d(this.f4583a);
        C1231b.m8228e(this.f4583a);
    }
}
