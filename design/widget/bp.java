package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.C0220b;
import android.util.AttributeSet;
import android.view.View;

class bp<V extends View> extends C0220b<V> {
    private bq f1019a;
    private int f1020b = 0;
    private int f1021c = 0;

    public bp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo173a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo192b(coordinatorLayout, v, i);
        if (this.f1019a == null) {
            this.f1019a = new bq(v);
        }
        this.f1019a.m2088a();
        if (this.f1020b != 0) {
            this.f1019a.m2089a(this.f1020b);
            this.f1020b = 0;
        }
        if (this.f1021c != 0) {
            this.f1019a.m2091b(this.f1021c);
            this.f1021c = 0;
        }
        return true;
    }

    protected void mo192b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m1675a((View) v, i);
    }

    public boolean mo184a(int i) {
        if (this.f1019a != null) {
            return this.f1019a.m2089a(i);
        }
        this.f1020b = i;
        return false;
    }

    public int mo187b() {
        return this.f1019a != null ? this.f1019a.m2090b() : 0;
    }
}
