package android.support.v4.p024g;

public class C0501f<E> implements Cloneable {
    private static final Object f1952a = new Object();
    private boolean f1953b;
    private long[] f1954c;
    private Object[] f1955d;
    private int f1956e;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m3141a();
    }

    public C0501f() {
        this(10);
    }

    public C0501f(int i) {
        this.f1953b = false;
        if (i == 0) {
            this.f1954c = C0498c.f1948b;
            this.f1955d = C0498c.f1949c;
        } else {
            int b = C0498c.m3136b(i);
            this.f1954c = new long[b];
            this.f1955d = new Object[b];
        }
        this.f1956e = 0;
    }

    public C0501f<E> m3141a() {
        try {
            C0501f<E> c0501f = (C0501f) super.clone();
            try {
                c0501f.f1954c = (long[]) this.f1954c.clone();
                c0501f.f1955d = (Object[]) this.f1955d.clone();
                return c0501f;
            } catch (CloneNotSupportedException e) {
                return c0501f;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m3142a(long j) {
        return m3143a(j, null);
    }

    public E m3143a(long j, E e) {
        int a = C0498c.m3134a(this.f1954c, this.f1956e, j);
        return (a < 0 || this.f1955d[a] == f1952a) ? e : this.f1955d[a];
    }

    public void m3147b(long j) {
        int a = C0498c.m3134a(this.f1954c, this.f1956e, j);
        if (a >= 0 && this.f1955d[a] != f1952a) {
            this.f1955d[a] = f1952a;
            this.f1953b = true;
        }
    }

    public void m3144a(int i) {
        if (this.f1955d[i] != f1952a) {
            this.f1955d[i] = f1952a;
            this.f1953b = true;
        }
    }

    private void m3140d() {
        int i = this.f1956e;
        long[] jArr = this.f1954c;
        Object[] objArr = this.f1955d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1952a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1953b = false;
        this.f1956e = i2;
    }

    public void m3148b(long j, E e) {
        int a = C0498c.m3134a(this.f1954c, this.f1956e, j);
        if (a >= 0) {
            this.f1955d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f1956e || this.f1955d[a] != f1952a) {
            if (this.f1953b && this.f1956e >= this.f1954c.length) {
                m3140d();
                a = C0498c.m3134a(this.f1954c, this.f1956e, j) ^ -1;
            }
            if (this.f1956e >= this.f1954c.length) {
                int b = C0498c.m3136b(this.f1956e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f1954c, 0, obj, 0, this.f1954c.length);
                System.arraycopy(this.f1955d, 0, obj2, 0, this.f1955d.length);
                this.f1954c = obj;
                this.f1955d = obj2;
            }
            if (this.f1956e - a != 0) {
                System.arraycopy(this.f1954c, a, this.f1954c, a + 1, this.f1956e - a);
                System.arraycopy(this.f1955d, a, this.f1955d, a + 1, this.f1956e - a);
            }
            this.f1954c[a] = j;
            this.f1955d[a] = e;
            this.f1956e++;
            return;
        }
        this.f1954c[a] = j;
        this.f1955d[a] = e;
    }

    public int m3145b() {
        if (this.f1953b) {
            m3140d();
        }
        return this.f1956e;
    }

    public long m3146b(int i) {
        if (this.f1953b) {
            m3140d();
        }
        return this.f1954c[i];
    }

    public E m3149c(int i) {
        if (this.f1953b) {
            m3140d();
        }
        return this.f1955d[i];
    }

    public void m3150c() {
        int i = this.f1956e;
        Object[] objArr = this.f1955d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1956e = 0;
        this.f1953b = false;
    }

    public String toString() {
        if (m3145b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1956e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1956e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m3146b(i));
            stringBuilder.append('=');
            C0501f c = m3149c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
