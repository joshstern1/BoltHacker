package android.support.v7.widget;

import android.support.v7.widget.ActionMenuView.C0908e;
import android.view.MenuItem;

class df implements C0908e {
    final /* synthetic */ Toolbar f3830a;

    df(Toolbar toolbar) {
        this.f3830a = toolbar;
    }

    public boolean mo1052a(MenuItem menuItem) {
        if (this.f3830a.f3549G != null) {
            return this.f3830a.f3549G.mo752a(menuItem);
        }
        return false;
    }
}
