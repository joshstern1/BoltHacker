package android.support.v7.p027a;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class C0802i implements OnScrollListener {
    final /* synthetic */ View f2673a;
    final /* synthetic */ View f2674b;
    final /* synthetic */ C0798e f2675c;

    C0802i(C0798e c0798e, View view, View view2) {
        this.f2675c = c0798e;
        this.f2673a = view;
        this.f2674b = view2;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        C0798e.m5242b(absListView, this.f2673a, this.f2674b);
    }
}
