package android.support.v7.p027a;

import android.content.Context;
import android.support.v7.p027a.C0798e.C0795a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class C0804k extends ArrayAdapter<CharSequence> {
    final /* synthetic */ ListView f2679a;
    final /* synthetic */ C0795a f2680b;

    C0804k(C0795a c0795a, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        this.f2680b = c0795a;
        this.f2679a = listView;
        super(context, i, i2, charSequenceArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f2680b.f2588C != null && this.f2680b.f2588C[i]) {
            this.f2679a.setItemChecked(i, true);
        }
        return view2;
    }
}
