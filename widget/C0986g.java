package android.support.v7.widget;

import android.support.v4.view.ao;

class C0986g implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout f3866a;

    C0986g(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f3866a = actionBarOverlayLayout;
    }

    public void run() {
        this.f3866a.m5812k();
        this.f3866a.f3100x = ao.m3950t(this.f3866a.f3081e).m4197c((float) (-this.f3866a.f3081e.getHeight())).m4191a(this.f3866a.f3101y);
    }
}
