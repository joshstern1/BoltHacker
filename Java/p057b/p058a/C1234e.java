package com.p057b.p058a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C1234e implements OnClickListener {
    final /* synthetic */ Context f4584a;

    C1234e(Context context) {
        this.f4584a = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (C1231b.f4580g != null) {
            C1231b.f4580g.m8199b();
        }
        C1231b.m8224b(this.f4584a, true);
    }
}
