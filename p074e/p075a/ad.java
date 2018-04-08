package com.p074e.p075a;

import com.p074e.p075a.ab.C1404b;

class ad implements Runnable {
    final /* synthetic */ Exception f5342a;
    final /* synthetic */ C1404b f5343b;

    ad(C1404b c1404b, Exception exception) {
        this.f5343b = c1404b;
        this.f5342a = exception;
    }

    public void run() {
        throw new RuntimeException(this.f5342a);
    }
}
