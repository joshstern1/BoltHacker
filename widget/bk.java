package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class bk implements OnItemSelectedListener {
    final /* synthetic */ bh f3719a;

    bk(bh bhVar) {
        this.f3719a = bhVar;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != -1) {
            ba a = this.f3719a.f3207h;
            if (a != null) {
                a.setListSelectionHidden(false);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
