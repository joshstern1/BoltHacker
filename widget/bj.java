package android.support.v7.widget;

import android.view.View;

class bj implements Runnable {
    final /* synthetic */ bh f3718a;

    bj(bh bhVar) {
        this.f3718a = bhVar;
    }

    public void run() {
        View i = this.f3718a.m5959i();
        if (i != null && i.getWindowToken() != null) {
            this.f3718a.mo868d();
        }
    }
}
