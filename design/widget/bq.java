package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.view.ao;
import android.view.View;
import android.view.ViewParent;

class bq {
    private final View f1352a;
    private int f1353b;
    private int f1354c;
    private int f1355d;
    private int f1356e;

    public bq(View view) {
        this.f1352a = view;
    }

    public void m2088a() {
        this.f1353b = this.f1352a.getTop();
        this.f1354c = this.f1352a.getLeft();
        m2087c();
    }

    private void m2087c() {
        ao.m3933e(this.f1352a, this.f1355d - (this.f1352a.getTop() - this.f1353b));
        ao.m3936f(this.f1352a, this.f1356e - (this.f1352a.getLeft() - this.f1354c));
        if (VERSION.SDK_INT < 23) {
            m2086a(this.f1352a);
            ViewParent parent = this.f1352a.getParent();
            if (parent instanceof View) {
                m2086a((View) parent);
            }
        }
    }

    private static void m2086a(View view) {
        float p = ao.m3946p(view);
        ao.m3920b(view, 1.0f + p);
        ao.m3920b(view, p);
    }

    public boolean m2089a(int i) {
        if (this.f1355d == i) {
            return false;
        }
        this.f1355d = i;
        m2087c();
        return true;
    }

    public boolean m2091b(int i) {
        if (this.f1356e == i) {
            return false;
        }
        this.f1356e = i;
        m2087c();
        return true;
    }

    public int m2090b() {
        return this.f1355d;
    }
}
