package android.support.design.internal;

import android.support.v7.view.menu.C0882m;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

class C0213d implements OnClickListener {
    final /* synthetic */ C0212c f1009a;

    C0213d(C0212c c0212c) {
        this.f1009a = c0212c;
    }

    public void onClick(View view) {
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        this.f1009a.m1455b(true);
        C0882m itemData = navigationMenuItemView.getItemData();
        boolean a = this.f1009a.f997d.m1301a((MenuItem) itemData, this.f1009a, 0);
        if (itemData != null && itemData.isCheckable() && a) {
            this.f1009a.f999f.m1405a(itemData);
        }
        this.f1009a.m1455b(false);
        this.f1009a.mo153a(false);
    }
}
