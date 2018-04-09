package android.support.v7.p027a;

import android.support.v7.p027a.C0798e.C0795a;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class C0806m implements OnItemClickListener {
    final /* synthetic */ C0798e f2686a;
    final /* synthetic */ C0795a f2687b;

    C0806m(C0795a c0795a, C0798e c0798e) {
        this.f2687b = c0795a;
        this.f2686a = c0798e;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2687b.f2619u.onClick(this.f2686a.f2641b, i);
        if (!this.f2687b.f2590E) {
            this.f2686a.f2641b.dismiss();
        }
    }
}
