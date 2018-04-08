package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ao;
import android.support.v7.view.menu.C0195u.C0194a;
import android.support.v7.view.menu.C0211t.C0770a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class C0870b implements C0211t {
    protected Context f2911a;
    protected Context f2912b;
    protected C0197k f2913c;
    protected LayoutInflater f2914d;
    protected LayoutInflater f2915e;
    protected C0195u f2916f;
    private C0770a f2917g;
    private int f2918h;
    private int f2919i;
    private int f2920j;

    public abstract void mo911a(C0882m c0882m, C0194a c0194a);

    public C0870b(Context context, int i, int i2) {
        this.f2911a = context;
        this.f2914d = LayoutInflater.from(context);
        this.f2918h = i;
        this.f2919i = i2;
    }

    public void mo149a(Context context, C0197k c0197k) {
        this.f2912b = context;
        this.f2915e = LayoutInflater.from(this.f2912b);
        this.f2913c = c0197k;
    }

    public C0195u mo909a(ViewGroup viewGroup) {
        if (this.f2916f == null) {
            this.f2916f = (C0195u) this.f2914d.inflate(this.f2918h, viewGroup, false);
            this.f2916f.mo141a(this.f2913c);
            mo153a(true);
        }
        return this.f2916f;
    }

    public void mo153a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f2916f;
        if (viewGroup != null) {
            int i;
            if (this.f2913c != null) {
                this.f2913c.m1323j();
                ArrayList i2 = this.f2913c.m1322i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0882m c0882m = (C0882m) i2.get(i3);
                    if (mo912a(i, c0882m)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0882m itemData = childAt instanceof C0194a ? ((C0194a) childAt).getItemData() : null;
                        View a = mo910a(c0882m, childAt, viewGroup);
                        if (c0882m != itemData) {
                            a.setPressed(false);
                            ao.m3956z(a);
                        }
                        if (a != childAt) {
                            m5601a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo913a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void m5601a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f2916f).addView(view, i);
    }

    protected boolean mo913a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void mo152a(C0770a c0770a) {
        this.f2917g = c0770a;
    }

    public C0770a m5611d() {
        return this.f2917g;
    }

    public C0194a m5609b(ViewGroup viewGroup) {
        return (C0194a) this.f2914d.inflate(this.f2919i, viewGroup, false);
    }

    public View mo910a(C0882m c0882m, View view, ViewGroup viewGroup) {
        C0194a c0194a;
        if (view instanceof C0194a) {
            c0194a = (C0194a) view;
        } else {
            c0194a = m5609b(viewGroup);
        }
        mo911a(c0882m, c0194a);
        return (View) c0194a;
    }

    public boolean mo912a(int i, C0882m c0882m) {
        return true;
    }

    public void mo151a(C0197k c0197k, boolean z) {
        if (this.f2917g != null) {
            this.f2917g.mo728a(c0197k, z);
        }
    }

    public boolean mo155a(aa aaVar) {
        if (this.f2917g != null) {
            return this.f2917g.mo729a(aaVar);
        }
        return false;
    }

    public boolean mo154a() {
        return false;
    }

    public boolean mo156a(C0197k c0197k, C0882m c0882m) {
        return false;
    }

    public boolean mo158b(C0197k c0197k, C0882m c0882m) {
        return false;
    }

    public int mo157b() {
        return this.f2920j;
    }

    public void m5596a(int i) {
        this.f2920j = i;
    }
}
