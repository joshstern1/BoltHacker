package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0935n;
import android.support.v7.widget.RecyclerView.C0940r;
import android.view.View;

class be {
    boolean f3703a = true;
    int f3704b;
    int f3705c;
    int f3706d;
    int f3707e;
    int f3708f = 0;
    int f3709g = 0;
    boolean f3710h;
    boolean f3711i;

    be() {
    }

    boolean m6881a(C0940r c0940r) {
        return this.f3705c >= 0 && this.f3705c < c0940r.m6395e();
    }

    View m6880a(C0935n c0935n) {
        View c = c0935n.m6335c(this.f3705c);
        this.f3705c += this.f3706d;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3704b + ", mCurrentPosition=" + this.f3705c + ", mItemDirection=" + this.f3706d + ", mLayoutDirection=" + this.f3707e + ", mStartLine=" + this.f3708f + ", mEndLine=" + this.f3709g + '}';
    }
}
