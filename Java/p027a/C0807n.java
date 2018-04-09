package android.support.v7.p027a;

import android.support.v7.p027a.C0798e.C0795a;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

class C0807n implements OnItemClickListener {
    final /* synthetic */ ListView f2688a;
    final /* synthetic */ C0798e f2689b;
    final /* synthetic */ C0795a f2690c;

    C0807n(C0795a c0795a, ListView listView, C0798e c0798e) {
        this.f2690c = c0795a;
        this.f2688a = listView;
        this.f2689b = c0798e;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f2690c.f2588C != null) {
            this.f2690c.f2588C[i] = this.f2688a.isItemChecked(i);
        }
        this.f2690c.f2592G.onClick(this.f2689b.f2641b, i, this.f2688a.isItemChecked(i));
    }
}
