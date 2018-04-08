package android.support.v4.p024g;

import java.util.Map;

public class C0494j<K, V> {
    static Object[] f1935b;
    static int f1936c;
    static Object[] f1937d;
    static int f1938e;
    int[] f1939f;
    Object[] f1940g;
    int f1941h;

    int m3096a(Object obj, int i) {
        int i2 = this.f1941h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0498c.m3133a(this.f1939f, i2, i);
        if (a < 0 || obj.equals(this.f1940g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1939f[i3] == i) {
            if (obj.equals(this.f1940g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f1939f[a] == i) {
            if (obj.equals(this.f1940g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m3094a() {
        int i = this.f1941h;
        if (i == 0) {
            return -1;
        }
        int a = C0498c.m3133a(this.f1939f, i, 0);
        if (a < 0 || this.f1940g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1939f[i2] == 0) {
            if (this.f1940g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f1939f[a] == 0) {
            if (this.f1940g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m3093e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0495a.class) {
                if (f1937d != null) {
                    objArr = f1937d;
                    this.f1940g = objArr;
                    f1937d = (Object[]) objArr[0];
                    this.f1939f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1938e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0495a.class) {
                if (f1935b != null) {
                    objArr = f1935b;
                    this.f1940g = objArr;
                    f1935b = (Object[]) objArr[0];
                    this.f1939f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1936c--;
                    return;
                }
            }
        }
        this.f1939f = new int[i];
        this.f1940g = new Object[(i << 1)];
    }

    private static void m3092a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0495a.class) {
                if (f1938e < 10) {
                    objArr[0] = f1937d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1937d = objArr;
                    f1938e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0495a.class) {
                if (f1936c < 10) {
                    objArr[0] = f1935b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1935b = objArr;
                    f1936c++;
                }
            }
        }
    }

    public C0494j() {
        this.f1939f = C0498c.f1947a;
        this.f1940g = C0498c.f1949c;
        this.f1941h = 0;
    }

    public C0494j(int i) {
        if (i == 0) {
            this.f1939f = C0498c.f1947a;
            this.f1940g = C0498c.f1949c;
        } else {
            m3093e(i);
        }
        this.f1941h = 0;
    }

    public void clear() {
        if (this.f1941h != 0) {
            C0494j.m3092a(this.f1939f, this.f1940g, this.f1941h);
            this.f1939f = C0498c.f1947a;
            this.f1940g = C0498c.f1949c;
            this.f1941h = 0;
        }
    }

    public void m3098a(int i) {
        if (this.f1939f.length < i) {
            Object obj = this.f1939f;
            Object obj2 = this.f1940g;
            m3093e(i);
            if (this.f1941h > 0) {
                System.arraycopy(obj, 0, this.f1939f, 0, this.f1941h);
                System.arraycopy(obj2, 0, this.f1940g, 0, this.f1941h << 1);
            }
            C0494j.m3092a(obj, obj2, this.f1941h);
        }
    }

    public boolean containsKey(Object obj) {
        return m3095a(obj) >= 0;
    }

    public int m3095a(Object obj) {
        return obj == null ? m3094a() : m3096a(obj, obj.hashCode());
    }

    int m3099b(Object obj) {
        int i = 1;
        int i2 = this.f1941h * 2;
        Object[] objArr = this.f1940g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m3099b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m3095a(obj);
        return a >= 0 ? this.f1940g[(a << 1) + 1] : null;
    }

    public K m3100b(int i) {
        return this.f1940g[i << 1];
    }

    public V m3101c(int i) {
        return this.f1940g[(i << 1) + 1];
    }

    public V m3097a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f1940g[i2];
        this.f1940g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f1941h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m3094a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m3096a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f1940g[i3];
            this.f1940g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f1941h >= this.f1939f.length) {
            if (this.f1941h >= 8) {
                i2 = this.f1941h + (this.f1941h >> 1);
            } else if (this.f1941h < 4) {
                i2 = 4;
            }
            Object obj = this.f1939f;
            Object obj2 = this.f1940g;
            m3093e(i2);
            if (this.f1939f.length > 0) {
                System.arraycopy(obj, 0, this.f1939f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f1940g, 0, obj2.length);
            }
            C0494j.m3092a(obj, obj2, this.f1941h);
        }
        if (a < this.f1941h) {
            System.arraycopy(this.f1939f, a, this.f1939f, a + 1, this.f1941h - a);
            System.arraycopy(this.f1940g, a << 1, this.f1940g, (a + 1) << 1, (this.f1941h - a) << 1);
        }
        this.f1939f[a] = i;
        this.f1940g[a << 1] = k;
        this.f1940g[(a << 1) + 1] = v;
        this.f1941h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m3095a(obj);
        if (a >= 0) {
            return m3102d(a);
        }
        return null;
    }

    public V m3102d(int i) {
        int i2 = 8;
        V v = this.f1940g[(i << 1) + 1];
        if (this.f1941h <= 1) {
            C0494j.m3092a(this.f1939f, this.f1940g, this.f1941h);
            this.f1939f = C0498c.f1947a;
            this.f1940g = C0498c.f1949c;
            this.f1941h = 0;
        } else if (this.f1939f.length <= 8 || this.f1941h >= this.f1939f.length / 3) {
            this.f1941h--;
            if (i < this.f1941h) {
                System.arraycopy(this.f1939f, i + 1, this.f1939f, i, this.f1941h - i);
                System.arraycopy(this.f1940g, (i + 1) << 1, this.f1940g, i << 1, (this.f1941h - i) << 1);
            }
            this.f1940g[this.f1941h << 1] = null;
            this.f1940g[(this.f1941h << 1) + 1] = null;
        } else {
            if (this.f1941h > 8) {
                i2 = this.f1941h + (this.f1941h >> 1);
            }
            Object obj = this.f1939f;
            Object obj2 = this.f1940g;
            m3093e(i2);
            this.f1941h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f1939f, 0, i);
                System.arraycopy(obj2, 0, this.f1940g, 0, i << 1);
            }
            if (i < this.f1941h) {
                System.arraycopy(obj, i + 1, this.f1939f, i, this.f1941h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f1940g, i << 1, (this.f1941h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f1941h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof C0494j) {
            C0494j c0494j = (C0494j) obj;
            if (size() != c0494j.size()) {
                return false;
            }
            i = 0;
            while (i < this.f1941h) {
                try {
                    b = m3100b(i);
                    c = m3101c(i);
                    obj2 = c0494j.get(b);
                    if (c == null) {
                        if (obj2 != null || !c0494j.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.f1941h) {
                try {
                    b = m3100b(i);
                    c = m3101c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.f1939f;
        Object[] objArr = this.f1940g;
        int i = this.f1941h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1941h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1941h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0494j b = m3100b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m3101c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
