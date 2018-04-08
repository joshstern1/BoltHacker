package android.support.v4.p024g;

public class C0512k<E> implements Cloneable {
    private static final Object f1980a = new Object();
    private boolean f1981b;
    private int[] f1982c;
    private Object[] f1983d;
    private int f1984e;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m3168a();
    }

    public C0512k() {
        this(10);
    }

    public C0512k(int i) {
        this.f1981b = false;
        if (i == 0) {
            this.f1982c = C0498c.f1947a;
            this.f1983d = C0498c.f1949c;
        } else {
            int a = C0498c.m3132a(i);
            this.f1982c = new int[a];
            this.f1983d = new Object[a];
        }
        this.f1984e = 0;
    }

    public C0512k<E> m3168a() {
        try {
            C0512k<E> c0512k = (C0512k) super.clone();
            try {
                c0512k.f1982c = (int[]) this.f1982c.clone();
                c0512k.f1983d = (Object[]) this.f1983d.clone();
                return c0512k;
            } catch (CloneNotSupportedException e) {
                return c0512k;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m3169a(int i) {
        return m3170a(i, null);
    }

    public E m3170a(int i, E e) {
        int a = C0498c.m3133a(this.f1982c, this.f1984e, i);
        return (a < 0 || this.f1983d[a] == f1980a) ? e : this.f1983d[a];
    }

    public void m3172b(int i) {
        int a = C0498c.m3133a(this.f1982c, this.f1984e, i);
        if (a >= 0 && this.f1983d[a] != f1980a) {
            this.f1983d[a] = f1980a;
            this.f1981b = true;
        }
    }

    public void m3175c(int i) {
        m3172b(i);
    }

    private void m3167d() {
        int i = this.f1984e;
        int[] iArr = this.f1982c;
        Object[] objArr = this.f1983d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1980a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1981b = false;
        this.f1984e = i2;
    }

    public void m3173b(int i, E e) {
        int a = C0498c.m3133a(this.f1982c, this.f1984e, i);
        if (a >= 0) {
            this.f1983d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f1984e || this.f1983d[a] != f1980a) {
            if (this.f1981b && this.f1984e >= this.f1982c.length) {
                m3167d();
                a = C0498c.m3133a(this.f1982c, this.f1984e, i) ^ -1;
            }
            if (this.f1984e >= this.f1982c.length) {
                int a2 = C0498c.m3132a(this.f1984e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f1982c, 0, obj, 0, this.f1982c.length);
                System.arraycopy(this.f1983d, 0, obj2, 0, this.f1983d.length);
                this.f1982c = obj;
                this.f1983d = obj2;
            }
            if (this.f1984e - a != 0) {
                System.arraycopy(this.f1982c, a, this.f1982c, a + 1, this.f1984e - a);
                System.arraycopy(this.f1983d, a, this.f1983d, a + 1, this.f1984e - a);
            }
            this.f1982c[a] = i;
            this.f1983d[a] = e;
            this.f1984e++;
            return;
        }
        this.f1982c[a] = i;
        this.f1983d[a] = e;
    }

    public int m3171b() {
        if (this.f1981b) {
            m3167d();
        }
        return this.f1984e;
    }

    public int m3176d(int i) {
        if (this.f1981b) {
            m3167d();
        }
        return this.f1982c[i];
    }

    public E m3177e(int i) {
        if (this.f1981b) {
            m3167d();
        }
        return this.f1983d[i];
    }

    public int m3178f(int i) {
        if (this.f1981b) {
            m3167d();
        }
        return C0498c.m3133a(this.f1982c, this.f1984e, i);
    }

    public void m3174c() {
        int i = this.f1984e;
        Object[] objArr = this.f1983d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1984e = 0;
        this.f1981b = false;
    }

    public String toString() {
        if (m3171b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1984e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1984e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m3176d(i));
            stringBuilder.append('=');
            C0512k e = m3177e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
