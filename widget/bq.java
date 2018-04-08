package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0915i;
import android.support.v7.widget.RecyclerView.C0917h;
import android.view.View;

final class bq extends bp {
    bq(C0917h c0917h) {
        super(c0917h);
    }

    public int mo1014d() {
        return this.a.m6131w() - this.a.m6011A();
    }

    public int mo1016e() {
        return this.a.m6131w();
    }

    public void mo1010a(int i) {
        this.a.mo974i(i);
    }

    public int mo1012c() {
        return this.a.m6133y();
    }

    public int mo1017e(View view) {
        C0915i c0915i = (C0915i) view.getLayoutParams();
        return c0915i.rightMargin + (this.a.m6102f(view) + c0915i.leftMargin);
    }

    public int mo1019f(View view) {
        C0915i c0915i = (C0915i) view.getLayoutParams();
        return c0915i.bottomMargin + (this.a.m6106g(view) + c0915i.topMargin);
    }

    public int mo1011b(View view) {
        C0915i c0915i = (C0915i) view.getLayoutParams();
        return c0915i.rightMargin + this.a.m6113j(view);
    }

    public int mo1009a(View view) {
        return this.a.m6109h(view) - ((C0915i) view.getLayoutParams()).leftMargin;
    }

    public int mo1013c(View view) {
        this.a.m6051a(view, true, this.b);
        return this.b.right;
    }

    public int mo1015d(View view) {
        this.a.m6051a(view, true, this.b);
        return this.b.left;
    }

    public int mo1018f() {
        return (this.a.m6131w() - this.a.m6133y()) - this.a.m6011A();
    }

    public int mo1020g() {
        return this.a.m6011A();
    }

    public int mo1021h() {
        return this.a.m6129u();
    }

    public int mo1022i() {
        return this.a.m6130v();
    }
}
