package android.support.design.widget;

import android.support.v4.view.bx;
import android.view.View;

class bb extends bx {
    final /* synthetic */ CharSequence f1322a;
    final /* synthetic */ TextInputLayout f1323b;

    bb(TextInputLayout textInputLayout, CharSequence charSequence) {
        this.f1323b = textInputLayout;
        this.f1322a = charSequence;
    }

    public void mo235b(View view) {
        this.f1323b.f1236h.setText(this.f1322a);
        view.setVisibility(4);
    }
}
