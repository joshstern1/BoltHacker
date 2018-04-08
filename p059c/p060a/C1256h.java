package com.p059c.p060a;

import com.p059c.p060a.C1257i.C1259b;
import java.util.ArrayList;

class C1256h extends C1253j {
    private int f4678g;
    private int f4679h;
    private int f4680i;
    private boolean f4681j = true;

    public /* synthetic */ C1253j mo1232b() {
        return m8359a();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m8359a();
    }

    public C1256h(C1259b... c1259bArr) {
        super(c1259bArr);
    }

    public Object mo1231a(float f) {
        return Integer.valueOf(m8361b(f));
    }

    public C1256h m8359a() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        C1259b[] c1259bArr = new C1259b[size];
        for (int i = 0; i < size; i++) {
            c1259bArr[i] = (C1259b) ((C1257i) arrayList.get(i)).mo1237f();
        }
        return new C1256h(c1259bArr);
    }

    public int m8361b(float f) {
        int i = 1;
        if (this.a == 2) {
            if (this.f4681j) {
                this.f4681j = false;
                this.f4678g = ((C1259b) this.e.get(0)).m8381g();
                this.f4679h = ((C1259b) this.e.get(1)).m8381g();
                this.f4680i = this.f4679h - this.f4678g;
            }
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            if (this.f == null) {
                return this.f4678g + ((int) (((float) this.f4680i) * f));
            }
            return ((Number) this.f.mo1230a(f, Integer.valueOf(this.f4678g), Integer.valueOf(this.f4679h))).intValue();
        } else if (f <= 0.0f) {
            r0 = (C1259b) this.e.get(0);
            r1 = (C1259b) this.e.get(1);
            r2 = r0.m8381g();
            r3 = r1.m8381g();
            r0 = r0.m8369c();
            r4 = r1.m8369c();
            r1 = r1.m8370d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? ((int) (r0 * ((float) (r3 - r2)))) + r2 : ((Number) this.f.mo1230a(r0, Integer.valueOf(r2), Integer.valueOf(r3))).intValue();
        } else if (f >= 1.0f) {
            r0 = (C1259b) this.e.get(this.a - 2);
            r1 = (C1259b) this.e.get(this.a - 1);
            r2 = r0.m8381g();
            r3 = r1.m8381g();
            r0 = r0.m8369c();
            r4 = r1.m8369c();
            r1 = r1.m8370d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? ((int) (r0 * ((float) (r3 - r2)))) + r2 : ((Number) this.f.mo1230a(r0, Integer.valueOf(r2), Integer.valueOf(r3))).intValue();
        } else {
            C1259b c1259b = (C1259b) this.e.get(0);
            while (i < this.a) {
                r0 = (C1259b) this.e.get(i);
                if (f < r0.m8369c()) {
                    r1 = r0.m8370d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    float c = (f - c1259b.m8369c()) / (r0.m8369c() - c1259b.m8369c());
                    r2 = c1259b.m8381g();
                    int g = r0.m8381g();
                    return this.f == null ? ((int) (((float) (g - r2)) * c)) + r2 : ((Number) this.f.mo1230a(c, Integer.valueOf(r2), Integer.valueOf(g))).intValue();
                } else {
                    i++;
                    c1259b = r0;
                }
            }
            return ((Number) ((C1257i) this.e.get(this.a - 1)).mo1235b()).intValue();
        }
    }
}
