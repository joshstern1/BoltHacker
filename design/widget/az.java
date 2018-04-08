package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

class az implements TextWatcher {
    final /* synthetic */ TextInputLayout f1319a;

    az(TextInputLayout textInputLayout) {
        this.f1319a = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
        this.f1319a.m1897a(true);
        if (this.f1319a.f1240l) {
            this.f1319a.m1892a(editable.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
