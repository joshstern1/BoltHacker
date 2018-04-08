package android.support.v7.widget;

import android.support.v7.view.menu.C0866a;
import android.view.View;
import android.view.View.OnClickListener;

class dk implements OnClickListener {
    final C0866a f3851a = new C0866a(this.f3852b.f3833a.getContext(), 0, 16908332, 0, 0, this.f3852b.f3841i);
    final /* synthetic */ dj f3852b;

    dk(dj djVar) {
        this.f3852b = djVar;
    }

    public void onClick(View view) {
        if (this.f3852b.f3844l != null && this.f3852b.f3845m) {
            this.f3852b.f3844l.onMenuItemSelected(0, this.f3851a);
        }
    }
}
