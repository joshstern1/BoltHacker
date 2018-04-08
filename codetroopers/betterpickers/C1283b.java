package com.codetroopers.betterpickers;

import android.database.ContentObserver;
import android.os.Handler;

class C1283b extends ContentObserver {
    final /* synthetic */ C1282a f4732a;

    C1283b(C1282a c1282a, Handler handler) {
        this.f4732a = c1282a;
        super(handler);
    }

    public void onChange(boolean z) {
        this.f4732a.f4729d = C1282a.m8497b(this.f4732a.f4726a);
    }
}
