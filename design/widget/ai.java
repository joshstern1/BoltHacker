package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior.C0239a;
import android.view.View;

class ai implements C0239a {
    final /* synthetic */ Snackbar f1278a;

    ai(Snackbar snackbar) {
        this.f1278a = snackbar;
    }

    public void mo230a(View view) {
        view.setVisibility(8);
        this.f1278a.m1765b(0);
    }

    public void mo229a(int i) {
        switch (i) {
            case 0:
                ap.m1953a().m1965d(this.f1278a.f1164f);
                return;
            case 1:
            case 2:
                ap.m1953a().m1964c(this.f1278a.f1164f);
                return;
            default:
                return;
        }
    }
}
