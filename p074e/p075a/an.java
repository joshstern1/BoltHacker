package com.p074e.p075a;

import android.os.Message;
import com.p074e.p075a.am.C1412a;

class an implements Runnable {
    final /* synthetic */ Message f5420a;
    final /* synthetic */ C1412a f5421b;

    an(C1412a c1412a, Message message) {
        this.f5421b = c1412a;
        this.f5420a = message;
    }

    public void run() {
        throw new AssertionError("Unhandled stats message." + this.f5420a.what);
    }
}
