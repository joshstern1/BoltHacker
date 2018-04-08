package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class cm implements OnFocusChangeListener {
    final /* synthetic */ SearchView f3779a;

    cm(SearchView searchView) {
        this.f3779a = searchView;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f3779a.f3393A != null) {
            this.f3779a.f3393A.onFocusChange(this.f3779a, z);
        }
    }
}
