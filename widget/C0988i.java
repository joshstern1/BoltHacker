package android.support.v7.widget;

import android.support.v7.view.menu.C0872x;
import android.support.v7.widget.ActionMenuPresenter.C0901d;
import android.view.View;

class C0988i extends bc {
    final /* synthetic */ ActionMenuPresenter f3867a;
    final /* synthetic */ C0901d f3868b;

    C0988i(C0901d c0901d, View view, ActionMenuPresenter actionMenuPresenter) {
        this.f3868b = c0901d;
        this.f3867a = actionMenuPresenter;
        super(view);
    }

    public C0872x mo844a() {
        if (this.f3868b.f3110a.f3132x == null) {
            return null;
        }
        return this.f3868b.f3110a.f3132x.m5748b();
    }

    public boolean mo845b() {
        this.f3868b.f3110a.m5870f();
        return true;
    }

    public boolean mo1086c() {
        if (this.f3868b.f3110a.f3134z != null) {
            return false;
        }
        this.f3868b.f3110a.m5871g();
        return true;
    }
}
