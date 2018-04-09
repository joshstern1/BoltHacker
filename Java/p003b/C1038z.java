package p003b;

import java.util.Arrays;

final class C1038z extends C1024j {
    final transient byte[][] f3995f;
    final transient int[] f3996g;

    C1038z(C1021e c1021e, int i) {
        int i2 = 0;
        super(null);
        ae.m7284a(c1021e.f3952b, 0, (long) i);
        C1036x c1036x = c1021e.f3951a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (c1036x.f3988c == c1036x.f3987b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += c1036x.f3988c - c1036x.f3987b;
            i3++;
            c1036x = c1036x.f3991f;
        }
        this.f3995f = new byte[i3][];
        this.f3996g = new int[(i3 * 2)];
        C1036x c1036x2 = c1021e.f3951a;
        i4 = 0;
        while (i2 < i) {
            this.f3995f[i4] = c1036x2.f3986a;
            int i5 = (c1036x2.f3988c - c1036x2.f3987b) + i2;
            if (i5 > i) {
                i5 = i;
            }
            this.f3996g[i4] = i5;
            this.f3996g[this.f3995f.length + i4] = c1036x2.f3987b;
            c1036x2.f3989d = true;
            i4++;
            c1036x2 = c1036x2.f3991f;
            i2 = i5;
        }
    }

    public String mo1130a() {
        return m7477g().mo1130a();
    }

    public String mo1134b() {
        return m7477g().mo1134b();
    }

    public String mo1135c() {
        return m7477g().mo1135c();
    }

    public C1024j mo1136d() {
        return m7477g().mo1136d();
    }

    public C1024j mo1129a(int i, int i2) {
        return m7477g().mo1129a(i, i2);
    }

    public byte mo1128a(int i) {
        ae.m7284a((long) this.f3996g[this.f3995f.length - 1], (long) i, 1);
        int b = m7476b(i);
        return this.f3995f[b][(i - (b == 0 ? 0 : this.f3996g[b - 1])) + this.f3996g[this.f3995f.length + b]];
    }

    private int m7476b(int i) {
        int binarySearch = Arrays.binarySearch(this.f3996g, 0, this.f3995f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public int mo1137e() {
        return this.f3996g[this.f3995f.length - 1];
    }

    public byte[] mo1139f() {
        int i = 0;
        Object obj = new byte[this.f3996g[this.f3995f.length - 1]];
        int length = this.f3995f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f3996g[length + i];
            int i4 = this.f3996g[i];
            System.arraycopy(this.f3995f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    void mo1131a(C1021e c1021e) {
        int i = 0;
        int length = this.f3995f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f3996g[length + i];
            int i4 = this.f3996g[i];
            C1036x c1036x = new C1036x(this.f3995f[i], i3, (i3 + i4) - i2);
            if (c1021e.f3951a == null) {
                c1036x.f3992g = c1036x;
                c1036x.f3991f = c1036x;
                c1021e.f3951a = c1036x;
            } else {
                c1021e.f3951a.f3992g.m7471a(c1036x);
            }
            i++;
            i2 = i4;
        }
        c1021e.f3952b = ((long) i2) + c1021e.f3952b;
    }

    public boolean mo1132a(int i, C1024j c1024j, int i2, int i3) {
        if (i < 0 || i > mo1137e() - i3) {
            return false;
        }
        int b = m7476b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f3996g[b - 1];
            int min = Math.min(i3, ((this.f3996g[b] - i4) + i4) - i);
            if (!c1024j.mo1133a(i2, this.f3995f[b], (i - i4) + this.f3996g[this.f3995f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public boolean mo1133a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > mo1137e() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m7476b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f3996g[b - 1];
            int min = Math.min(i3, ((this.f3996g[b] - i4) + i4) - i);
            if (!ae.m7286a(this.f3995f[b], (i - i4) + this.f3996g[this.f3995f.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private C1024j m7477g() {
        return new C1024j(mo1139f());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z;
        if ((obj instanceof C1024j) && ((C1024j) obj).mo1137e() == mo1137e() && mo1132a(0, (C1024j) obj, 0, mo1137e())) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.d;
        if (i == 0) {
            i = 1;
            int length = this.f3995f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f3995f[i2];
                int i4 = this.f3996g[length + i2];
                int i5 = this.f3996g[i2];
                i3 = (i5 - i3) + i4;
                int i6 = i4;
                i4 = i;
                for (i = i6; i < i3; i++) {
                    i4 = (i4 * 31) + bArr[i];
                }
                i2++;
                i3 = i5;
                i = i4;
            }
            this.d = i;
        }
        return i;
    }

    public String toString() {
        return m7477g().toString();
    }
}
