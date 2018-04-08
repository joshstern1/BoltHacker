package android.support.design.widget;

import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.bf.C0259c;

class C0274c implements C0259c {
    final /* synthetic */ CoordinatorLayout f1359a;
    final /* synthetic */ AppBarLayout f1360b;
    final /* synthetic */ Behavior f1361c;

    C0274c(Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f1361c = behavior;
        this.f1359a = coordinatorLayout;
        this.f1360b = appBarLayout;
    }

    public void mo245a(bf bfVar) {
        this.f1361c.a_(this.f1359a, this.f1360b, bfVar.m2042c());
    }
}
