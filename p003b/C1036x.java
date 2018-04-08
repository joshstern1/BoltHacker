package p003b;

import no.nordicsemi.android.dfu.DfuBaseService;

final class C1036x {
    final byte[] f3986a;
    int f3987b;
    int f3988c;
    boolean f3989d;
    boolean f3990e;
    C1036x f3991f;
    C1036x f3992g;

    C1036x() {
        this.f3986a = new byte[DfuBaseService.ERROR_REMOTE_MASK];
        this.f3990e = true;
        this.f3989d = false;
    }

    C1036x(C1036x c1036x) {
        this(c1036x.f3986a, c1036x.f3987b, c1036x.f3988c);
        c1036x.f3989d = true;
    }

    C1036x(byte[] bArr, int i, int i2) {
        this.f3986a = bArr;
        this.f3987b = i;
        this.f3988c = i2;
        this.f3990e = false;
        this.f3989d = true;
    }

    public C1036x m7469a() {
        C1036x c1036x = this.f3991f != this ? this.f3991f : null;
        this.f3992g.f3991f = this.f3991f;
        this.f3991f.f3992g = this.f3992g;
        this.f3991f = null;
        this.f3992g = null;
        return c1036x;
    }

    public C1036x m7471a(C1036x c1036x) {
        c1036x.f3992g = this;
        c1036x.f3991f = this.f3991f;
        this.f3991f.f3992g = c1036x;
        this.f3991f = c1036x;
        return c1036x;
    }

    public C1036x m7470a(int i) {
        if (i <= 0 || i > this.f3988c - this.f3987b) {
            throw new IllegalArgumentException();
        }
        C1036x c1036x;
        if (i >= 1024) {
            c1036x = new C1036x(this);
        } else {
            c1036x = C1037y.m7474a();
            System.arraycopy(this.f3986a, this.f3987b, c1036x.f3986a, 0, i);
        }
        c1036x.f3988c = c1036x.f3987b + i;
        this.f3987b += i;
        this.f3992g.m7471a(c1036x);
        return c1036x;
    }

    public void m7473b() {
        if (this.f3992g == this) {
            throw new IllegalStateException();
        } else if (this.f3992g.f3990e) {
            int i = this.f3988c - this.f3987b;
            if (i <= (this.f3992g.f3989d ? 0 : this.f3992g.f3987b) + (8192 - this.f3992g.f3988c)) {
                m7472a(this.f3992g, i);
                m7469a();
                C1037y.m7475a(this);
            }
        }
    }

    public void m7472a(C1036x c1036x, int i) {
        if (c1036x.f3990e) {
            if (c1036x.f3988c + i > DfuBaseService.ERROR_REMOTE_MASK) {
                if (c1036x.f3989d) {
                    throw new IllegalArgumentException();
                } else if ((c1036x.f3988c + i) - c1036x.f3987b > DfuBaseService.ERROR_REMOTE_MASK) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(c1036x.f3986a, c1036x.f3987b, c1036x.f3986a, 0, c1036x.f3988c - c1036x.f3987b);
                    c1036x.f3988c -= c1036x.f3987b;
                    c1036x.f3987b = 0;
                }
            }
            System.arraycopy(this.f3986a, this.f3987b, c1036x.f3986a, c1036x.f3988c, i);
            c1036x.f3988c += i;
            this.f3987b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
