package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0199u;
import android.support.v7.widget.RecyclerView.C0927e;
import android.support.v7.widget.RecyclerView.C0927e.C0926c;
import android.view.View;

public abstract class ct extends C0927e {
    boolean f3648a = true;

    public abstract boolean mo988a(C0199u c0199u);

    public abstract boolean mo989a(C0199u c0199u, int i, int i2, int i3, int i4);

    public abstract boolean mo990a(C0199u c0199u, C0199u c0199u2, int i, int i2, int i3, int i4);

    public abstract boolean mo993b(C0199u c0199u);

    public boolean mo986g(C0199u c0199u) {
        return !this.f3648a || c0199u.m1366n();
    }

    public boolean mo982a(C0199u c0199u, C0926c c0926c, C0926c c0926c2) {
        int i = c0926c.f3311a;
        int i2 = c0926c.f3312b;
        View view = c0199u.f968a;
        int left = c0926c2 == null ? view.getLeft() : c0926c2.f3311a;
        int top = c0926c2 == null ? view.getTop() : c0926c2.f3312b;
        if (c0199u.m1369q() || (i == left && i2 == top)) {
            return mo988a(c0199u);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo989a(c0199u, i, i2, left, top);
    }

    public boolean mo984b(C0199u c0199u, C0926c c0926c, C0926c c0926c2) {
        if (c0926c == null || (c0926c.f3311a == c0926c2.f3311a && c0926c.f3312b == c0926c2.f3312b)) {
            return mo993b(c0199u);
        }
        return mo989a(c0199u, c0926c.f3311a, c0926c.f3312b, c0926c2.f3311a, c0926c2.f3312b);
    }

    public boolean mo985c(C0199u c0199u, C0926c c0926c, C0926c c0926c2) {
        if (c0926c.f3311a == c0926c2.f3311a && c0926c.f3312b == c0926c2.f3312b) {
            m6809i(c0199u);
            return false;
        }
        return mo989a(c0199u, c0926c.f3311a, c0926c.f3312b, c0926c2.f3311a, c0926c2.f3312b);
    }

    public boolean mo983a(C0199u c0199u, C0199u c0199u2, C0926c c0926c, C0926c c0926c2) {
        int i;
        int i2;
        int i3 = c0926c.f3311a;
        int i4 = c0926c.f3312b;
        if (c0199u2.m1355c()) {
            i = c0926c.f3311a;
            i2 = c0926c.f3312b;
        } else {
            i = c0926c2.f3311a;
            i2 = c0926c2.f3312b;
        }
        return mo990a(c0199u, c0199u2, i3, i4, i, i2);
    }

    public final void m6808h(C0199u c0199u) {
        m6815o(c0199u);
        m6286e(c0199u);
    }

    public final void m6809i(C0199u c0199u) {
        m6819s(c0199u);
        m6286e(c0199u);
    }

    public final void m6810j(C0199u c0199u) {
        m6817q(c0199u);
        m6286e(c0199u);
    }

    public final void m6795a(C0199u c0199u, boolean z) {
        m6806d(c0199u, z);
        m6286e(c0199u);
    }

    public final void m6811k(C0199u c0199u) {
        m6814n(c0199u);
    }

    public final void m6812l(C0199u c0199u) {
        m6818r(c0199u);
    }

    public final void m6813m(C0199u c0199u) {
        m6816p(c0199u);
    }

    public final void m6801b(C0199u c0199u, boolean z) {
        m6804c(c0199u, z);
    }

    public void m6814n(C0199u c0199u) {
    }

    public void m6815o(C0199u c0199u) {
    }

    public void m6816p(C0199u c0199u) {
    }

    public void m6817q(C0199u c0199u) {
    }

    public void m6818r(C0199u c0199u) {
    }

    public void m6819s(C0199u c0199u) {
    }

    public void m6804c(C0199u c0199u, boolean z) {
    }

    public void m6806d(C0199u c0199u, boolean z) {
    }
}
