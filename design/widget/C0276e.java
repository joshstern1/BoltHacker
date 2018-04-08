package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior.C0225b;
import android.support.v4.view.ao;
import android.support.v4.widget.bd.C0258a;
import android.view.View;

class C0276e extends C0258a {
    final /* synthetic */ BottomSheetBehavior f1362a;

    C0276e(BottomSheetBehavior bottomSheetBehavior) {
        this.f1362a = bottomSheetBehavior;
    }

    public boolean mo241a(View view, int i) {
        if (this.f1362a.f1061f == 1 || this.f1362a.f1073r) {
            return false;
        }
        if (this.f1362a.f1061f == 3 && this.f1362a.f1071p == i) {
            View view2 = (View) this.f1362a.f1068m.get();
            if (view2 != null && ao.m3923b(view2, -1)) {
                return false;
            }
        }
        boolean z = this.f1362a.f1067l != null && this.f1362a.f1067l.get() == view;
        return z;
    }

    public void mo240a(View view, int i, int i2, int i3, int i4) {
        this.f1362a.m1613c(i2);
    }

    public void mo238a(int i) {
        if (i == 1) {
            this.f1362a.m1609b(1);
        }
    }

    public void mo239a(View view, float f, float f2) {
        int f3;
        int i = 3;
        if (f2 < 0.0f) {
            f3 = this.f1362a.f1058c;
        } else if (this.f1362a.f1060e && this.f1362a.m1607a(view, f2)) {
            f3 = this.f1362a.f1066k;
            i = 5;
        } else if (f2 == 0.0f) {
            int top = view.getTop();
            if (Math.abs(top - this.f1362a.f1058c) < Math.abs(top - this.f1362a.f1059d)) {
                f3 = this.f1362a.f1058c;
            } else {
                f3 = this.f1362a.f1059d;
                i = 4;
            }
        } else {
            f3 = this.f1362a.f1059d;
            i = 4;
        }
        if (this.f1362a.f1062g.m4830a(view.getLeft(), f3)) {
            this.f1362a.m1609b(2);
            ao.m3913a(view, new C0225b(this.f1362a, view, i));
            return;
        }
        this.f1362a.m1609b(i);
    }

    public int mo237a(View view, int i, int i2) {
        return ab.m1910a(i, this.f1362a.f1058c, this.f1362a.f1060e ? this.f1362a.f1066k : this.f1362a.f1059d);
    }

    public int mo243b(View view, int i, int i2) {
        return view.getLeft();
    }

    public int mo273a(View view) {
        if (this.f1362a.f1060e) {
            return this.f1362a.f1066k - this.f1362a.f1058c;
        }
        return this.f1362a.f1059d - this.f1362a.f1058c;
    }
}
