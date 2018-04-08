package android.support.v7.widget;

import android.view.View;

class cf implements Runnable {
    final /* synthetic */ View f3771a;
    final /* synthetic */ ce f3772b;

    cf(ce ceVar, View view) {
        this.f3772b = ceVar;
        this.f3771a = view;
    }

    public void run() {
        this.f3772b.smoothScrollTo(this.f3771a.getLeft() - ((this.f3772b.getWidth() - this.f3771a.getWidth()) / 2), 0);
        this.f3772b.f3760a = null;
    }
}
