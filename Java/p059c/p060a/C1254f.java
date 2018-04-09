package com.p059c.p060a;

import com.p059c.p060a.C1257i.C1258a;
import java.util.ArrayList;

class C1254f extends C1253j {
    private float f4674g;
    private float f4675h;
    private float f4676i;
    private boolean f4677j = true;

    public /* synthetic */ C1253j mo1232b() {
        return m8353a();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m8353a();
    }

    public C1254f(C1258a... c1258aArr) {
        super(c1258aArr);
    }

    public Object mo1231a(float f) {
        return Float.valueOf(m8355b(f));
    }

    public C1254f m8353a() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        C1258a[] c1258aArr = new C1258a[size];
        for (int i = 0; i < size; i++) {
            c1258aArr[i] = (C1258a) ((C1257i) arrayList.get(i)).mo1237f();
        }
        return new C1254f(c1258aArr);
    }

    public float m8355b(float f) {
        int i = 1;
        if (this.a == 2) {
            if (this.f4677j) {
                this.f4677j = false;
                this.f4674g = ((C1258a) this.e.get(0)).m8376g();
                this.f4675h = ((C1258a) this.e.get(1)).m8376g();
                this.f4676i = this.f4675h - this.f4674g;
            }
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            if (this.f == null) {
                return this.f4674g + (this.f4676i * f);
            }
            return ((Number) this.f.mo1230a(f, Float.valueOf(this.f4674g), Float.valueOf(this.f4675h))).floatValue();
        } else if (f <= 0.0f) {
            r0 = (C1258a) this.e.get(0);
            r1 = (C1258a) this.e.get(1);
            r2 = r0.m8376g();
            r3 = r1.m8376g();
            r0 = r0.m8369c();
            r4 = r1.m8369c();
            r1 = r1.m8370d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? (r0 * (r3 - r2)) + r2 : ((Number) this.f.mo1230a(r0, Float.valueOf(r2), Float.valueOf(r3))).floatValue();
        } else if (f >= 1.0f) {
            r0 = (C1258a) this.e.get(this.a - 2);
            r1 = (C1258a) this.e.get(this.a - 1);
            r2 = r0.m8376g();
            r3 = r1.m8376g();
            r0 = r0.m8369c();
            r4 = r1.m8369c();
            r1 = r1.m8370d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? (r0 * (r3 - r2)) + r2 : ((Number) this.f.mo1230a(r0, Float.valueOf(r2), Float.valueOf(r3))).floatValue();
        } else {
            C1258a c1258a = (C1258a) this.e.get(0);
            while (i < this.a) {
                r0 = (C1258a) this.e.get(i);
                if (f < r0.m8369c()) {
                    r1 = r0.m8370d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    float c = (f - c1258a.m8369c()) / (r0.m8369c() - c1258a.m8369c());
                    r2 = c1258a.m8376g();
                    r0 = r0.m8376g();
                    return this.f == null ? ((r0 - r2) * c) + r2 : ((Number) this.f.mo1230a(c, Float.valueOf(r2), Float.valueOf(r0))).floatValue();
                } else {
                    i++;
                    c1258a = r0;
                }
            }
            return ((Number) ((C1257i) this.e.get(this.a - 1)).mo1235b()).floatValue();
        }
    }
}
