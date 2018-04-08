package com.onesignal;

class ax implements Runnable {
    final /* synthetic */ SyncService f9222a;

    ax(SyncService syncService) {
        this.f9222a = syncService;
    }

    public void run() {
        if (C2758w.m16092e() == null) {
            this.f9222a.stopSelf();
            return;
        }
        C2758w.f9292a = C2758w.m16088d();
        aj.m15905a(C2758w.f9294c);
        aj.m15909a(true);
        this.f9222a.m15851b();
        this.f9222a.stopSelf();
    }
}
