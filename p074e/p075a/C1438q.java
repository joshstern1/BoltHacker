package com.p074e.p075a;

import android.os.Message;
import com.p074e.p075a.C1437p.C1434a;

class C1438q implements Runnable {
    final /* synthetic */ Message f5496a;
    final /* synthetic */ C1434a f5497b;

    C1438q(C1434a c1434a, Message message) {
        this.f5497b = c1434a;
        this.f5496a = message;
    }

    public void run() {
        throw new AssertionError("Unknown handler message received: " + this.f5496a.what);
    }
}
