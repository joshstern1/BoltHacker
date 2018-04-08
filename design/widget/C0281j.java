package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0229e;
import android.view.View;
import java.util.Comparator;

class C0281j implements Comparator<View> {
    final /* synthetic */ CoordinatorLayout f1420a;

    C0281j(CoordinatorLayout coordinatorLayout) {
        this.f1420a = coordinatorLayout;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2153a((View) obj, (View) obj2);
    }

    public int m2153a(View view, View view2) {
        if (view == view2) {
            return 0;
        }
        if (((C0229e) view.getLayoutParams()).m1641a(this.f1420a, view, view2)) {
            return 1;
        }
        return ((C0229e) view2.getLayoutParams()).m1641a(this.f1420a, view2, view) ? -1 : 0;
    }
}
