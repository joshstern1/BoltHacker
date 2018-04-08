package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0249b;
import android.support.v4.view.p025a.C0547e;
import android.view.View;

class ca extends C0249b {
    final /* synthetic */ bz f3738a;

    ca(bz bzVar) {
        this.f3738a = bzVar;
    }

    public void mo219a(View view, C0547e c0547e) {
        super.mo219a(view, c0547e);
        if (!this.f3738a.m6991c() && this.f3738a.f3736a.getLayoutManager() != null) {
            this.f3738a.f3736a.getLayoutManager().m6049a(view, c0547e);
        }
    }

    public boolean mo431a(View view, int i, Bundle bundle) {
        if (super.mo431a(view, i, bundle)) {
            return true;
        }
        if (this.f3738a.m6991c() || this.f3738a.f3736a.getLayoutManager() == null) {
            return false;
        }
        return this.f3738a.f3736a.getLayoutManager().m6063a(view, i, bundle);
    }
}
