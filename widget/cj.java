package android.support.v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

class cj implements TextWatcher {
    final /* synthetic */ SearchView f3776a;

    cj(SearchView searchView) {
        this.f3776a = searchView;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f3776a.m6444c(charSequence);
    }

    public void afterTextChanged(Editable editable) {
    }
}
