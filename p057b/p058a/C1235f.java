package com.p057b.p058a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class C1235f implements OnCancelListener {
    final /* synthetic */ Context f4585a;

    C1235f(Context context) {
        this.f4585a = context;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (C1231b.f4580g != null) {
            C1231b.f4580g.m8200c();
        }
        C1231b.m8227d(this.f4585a);
        C1231b.m8228e(this.f4585a);
    }
}
