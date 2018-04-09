package com.p059c.p060a;

import android.view.animation.Interpolator;
import com.p059c.p060a.C1257i.C1258a;
import com.p059c.p060a.C1257i.C1259b;
import java.util.ArrayList;
import java.util.Arrays;

class C1253j {
    int f4668a;
    C1257i f4669b;
    C1257i f4670c;
    Interpolator f4671d;
    ArrayList<C1257i> f4672e = new ArrayList();
    ab f4673f;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1232b();
    }

    public C1253j(C1257i... c1257iArr) {
        this.f4668a = c1257iArr.length;
        this.f4672e.addAll(Arrays.asList(c1257iArr));
        this.f4669b = (C1257i) this.f4672e.get(0);
        this.f4670c = (C1257i) this.f4672e.get(this.f4668a - 1);
        this.f4671d = this.f4670c.m8370d();
    }

    public static C1253j m8348a(float... fArr) {
        int i = 1;
        int length = fArr.length;
        C1258a[] c1258aArr = new C1258a[Math.max(length, 2)];
        if (length == 1) {
            c1258aArr[0] = (C1258a) C1257i.m8363a(0.0f);
            c1258aArr[1] = (C1258a) C1257i.m8364a(1.0f, fArr[0]);
        } else {
            c1258aArr[0] = (C1258a) C1257i.m8364a(0.0f, fArr[0]);
            while (i < length) {
                c1258aArr[i] = (C1258a) C1257i.m8364a(((float) i) / ((float) (length - 1)), fArr[i]);
                i++;
            }
        }
        return new C1254f(c1258aArr);
    }

    public static C1253j m8349a(C1257i... c1257iArr) {
        int i = 0;
        int length = c1257iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (c1257iArr[i5] instanceof C1258a) {
                i4 = 1;
            } else if (c1257iArr[i5] instanceof C1259b) {
                i3 = 1;
            } else {
                i2 = 1;
            }
        }
        if (i4 != 0 && i3 == 0 && r0 == 0) {
            C1258a[] c1258aArr = new C1258a[length];
            while (i < length) {
                c1258aArr[i] = (C1258a) c1257iArr[i];
                i++;
            }
            return new C1254f(c1258aArr);
        } else if (i3 == 0 || i4 != 0 || r0 != 0) {
            return new C1253j(c1257iArr);
        } else {
            C1259b[] c1259bArr = new C1259b[length];
            for (int i6 = 0; i6 < length; i6++) {
                c1259bArr[i6] = (C1259b) c1257iArr[i6];
            }
            return new C1256h(c1259bArr);
        }
    }

    public void m8351a(ab abVar) {
        this.f4673f = abVar;
    }

    public C1253j mo1232b() {
        ArrayList arrayList = this.f4672e;
        int size = this.f4672e.size();
        C1257i[] c1257iArr = new C1257i[size];
        for (int i = 0; i < size; i++) {
            c1257iArr[i] = ((C1257i) arrayList.get(i)).mo1237f();
        }
        return new C1253j(c1257iArr);
    }

    public Object mo1231a(float f) {
        if (this.f4668a == 2) {
            if (this.f4671d != null) {
                f = this.f4671d.getInterpolation(f);
            }
            return this.f4673f.mo1230a(f, this.f4669b.mo1235b(), this.f4670c.mo1235b());
        } else if (f <= 0.0f) {
            r0 = (C1257i) this.f4672e.get(1);
            r1 = r0.m8370d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = this.f4669b.m8369c();
            return this.f4673f.mo1230a((f - r1) / (r0.m8369c() - r1), this.f4669b.mo1235b(), r0.mo1235b());
        } else if (f >= 1.0f) {
            r0 = (C1257i) this.f4672e.get(this.f4668a - 2);
            r1 = this.f4670c.m8370d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = r0.m8369c();
            return this.f4673f.mo1230a((f - r1) / (this.f4670c.m8369c() - r1), r0.mo1235b(), this.f4670c.mo1235b());
        } else {
            C1257i c1257i = this.f4669b;
            int i = 1;
            while (i < this.f4668a) {
                r0 = (C1257i) this.f4672e.get(i);
                if (f < r0.m8369c()) {
                    r1 = r0.m8370d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    r1 = c1257i.m8369c();
                    return this.f4673f.mo1230a((f - r1) / (r0.m8369c() - r1), c1257i.mo1235b(), r0.mo1235b());
                }
                i++;
                c1257i = r0;
            }
            return this.f4670c.mo1235b();
        }
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.f4668a) {
            String str2 = str + ((C1257i) this.f4672e.get(i)).mo1235b() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
