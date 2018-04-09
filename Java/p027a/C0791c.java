package android.support.v7.p027a;

import android.view.View;
import android.view.View.OnClickListener;

class C0791c implements OnClickListener {
    final /* synthetic */ C0790b f2581a;

    C0791c(C0790b c0790b) {
        this.f2581a = c0790b;
    }

    public void onClick(View view) {
        if (this.f2581a.f2576e) {
            this.f2581a.m5216c();
        } else if (this.f2581a.f2579h != null) {
            this.f2581a.f2579h.onClick(view);
        }
    }
}
