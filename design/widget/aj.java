package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout.C0235a;
import android.view.View;

class aj implements C0235a {
    final /* synthetic */ Snackbar f1279a;

    aj(Snackbar snackbar) {
        this.f1279a = snackbar;
    }

    public void mo231a(View view) {
    }

    public void mo232b(View view) {
        if (this.f1279a.m1777a()) {
            Snackbar.f1159a.post(new ak(this));
        }
    }
}
