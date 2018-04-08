package android.support.v7.widget;

import android.support.v4.p024g.C0511i.C0508a;
import android.support.v4.p024g.C0511i.C0509b;
import android.support.v7.widget.RecyclerView.C0199u;
import android.support.v7.widget.bo.C0972a;
import java.util.ArrayList;
import java.util.List;

class C1003r implements C0972a {
    final ArrayList<C1002b> f3900a;
    final ArrayList<C1002b> f3901b;
    final C0974a f3902c;
    Runnable f3903d;
    final boolean f3904e;
    final bo f3905f;
    private C0508a<C1002b> f3906g;
    private int f3907h;

    interface C0974a {
        C0199u mo1038a(int i);

        void mo1039a(int i, int i2);

        void mo1040a(int i, int i2, Object obj);

        void mo1041a(C1002b c1002b);

        void mo1042b(int i, int i2);

        void mo1043b(C1002b c1002b);

        void mo1044c(int i, int i2);

        void mo1045d(int i, int i2);
    }

    static class C1002b {
        int f3896a;
        int f3897b;
        Object f3898c;
        int f3899d;

        C1002b(int i, int i2, int i3, Object obj) {
            this.f3896a = i;
            this.f3897b = i2;
            this.f3899d = i3;
            this.f3898c = obj;
        }

        String m7199a() {
            switch (this.f3896a) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 4:
                    return "up";
                case 8:
                    return "mv";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m7199a() + ",s:" + this.f3897b + "c:" + this.f3899d + ",p:" + this.f3898c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1002b c1002b = (C1002b) obj;
            if (this.f3896a != c1002b.f3896a) {
                return false;
            }
            if (this.f3896a == 8 && Math.abs(this.f3899d - this.f3897b) == 1 && this.f3899d == c1002b.f3897b && this.f3897b == c1002b.f3899d) {
                return true;
            }
            if (this.f3899d != c1002b.f3899d) {
                return false;
            }
            if (this.f3897b != c1002b.f3897b) {
                return false;
            }
            if (this.f3898c != null) {
                if (this.f3898c.equals(c1002b.f3898c)) {
                    return true;
                }
                return false;
            } else if (c1002b.f3898c != null) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            return (((this.f3896a * 31) + this.f3897b) * 31) + this.f3899d;
        }
    }

    C1003r(C0974a c0974a) {
        this(c0974a, false);
    }

    C1003r(C0974a c0974a, boolean z) {
        this.f3906g = new C0509b(30);
        this.f3900a = new ArrayList();
        this.f3901b = new ArrayList();
        this.f3907h = 0;
        this.f3902c = c0974a;
        this.f3904e = z;
        this.f3905f = new bo(this);
    }

    void m7210a() {
        m7213a(this.f3900a);
        m7213a(this.f3901b);
        this.f3907h = 0;
    }

    void m7217b() {
        this.f3905f.m6900a(this.f3900a);
        int size = this.f3900a.size();
        for (int i = 0; i < size; i++) {
            C1002b c1002b = (C1002b) this.f3900a.get(i);
            switch (c1002b.f3896a) {
                case 1:
                    m7206f(c1002b);
                    break;
                case 2:
                    m7202c(c1002b);
                    break;
                case 4:
                    m7203d(c1002b);
                    break;
                case 8:
                    m7200b(c1002b);
                    break;
            }
            if (this.f3903d != null) {
                this.f3903d.run();
            }
        }
        this.f3900a.clear();
    }

    void m7220c() {
        int size = this.f3901b.size();
        for (int i = 0; i < size; i++) {
            this.f3902c.mo1043b((C1002b) this.f3901b.get(i));
        }
        m7213a(this.f3901b);
        this.f3907h = 0;
    }

    private void m7200b(C1002b c1002b) {
        m7207g(c1002b);
    }

    private void m7202c(C1002b c1002b) {
        int i = c1002b.f3897b;
        int i2 = c1002b.f3897b + c1002b.f3899d;
        Object obj = -1;
        int i3 = c1002b.f3897b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f3902c.mo1038a(i3) != null || m7204d(i3)) {
                if (obj == null) {
                    m7205e(mo1087a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m7207g(mo1087a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != c1002b.f3899d) {
            mo1088a(c1002b);
            c1002b = mo1087a(2, i, i4, null);
        }
        if (obj == null) {
            m7205e(c1002b);
        } else {
            m7207g(c1002b);
        }
    }

    private void m7203d(C1002b c1002b) {
        int i = c1002b.f3897b;
        int i2 = c1002b.f3897b + c1002b.f3899d;
        int i3 = c1002b.f3897b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f3902c.mo1038a(i3) != null || m7204d(i3)) {
                if (obj == null) {
                    m7205e(mo1087a(4, i, i4, c1002b.f3898c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m7207g(mo1087a(4, i, i4, c1002b.f3898c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c1002b.f3899d) {
            Object obj4 = c1002b.f3898c;
            mo1088a(c1002b);
            c1002b = mo1087a(4, i, i4, obj4);
        }
        if (obj == null) {
            m7205e(c1002b);
        } else {
            m7207g(c1002b);
        }
    }

    private void m7205e(C1002b c1002b) {
        if (c1002b.f3896a == 1 || c1002b.f3896a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int c = m7201c(c1002b.f3897b, c1002b.f3896a);
        int i2 = c1002b.f3897b;
        switch (c1002b.f3896a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c1002b);
        }
        int i3 = 1;
        int i4 = c;
        c = i2;
        for (i2 = 1; i2 < c1002b.f3899d; i2++) {
            Object obj;
            int c2 = m7201c(c1002b.f3897b + (i * i2), c1002b.f3896a);
            int i5;
            switch (c1002b.f3896a) {
                case 2:
                    if (c2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (c2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C1002b a = mo1087a(c1002b.f3896a, i4, i3, c1002b.f3898c);
                m7212a(a, c);
                mo1088a(a);
                if (c1002b.f3896a == 4) {
                    c += i3;
                }
                i3 = 1;
                i4 = c2;
            }
        }
        Object obj2 = c1002b.f3898c;
        mo1088a(c1002b);
        if (i3 > 0) {
            C1002b a2 = mo1087a(c1002b.f3896a, i4, i3, obj2);
            m7212a(a2, c);
            mo1088a(a2);
        }
    }

    void m7212a(C1002b c1002b, int i) {
        this.f3902c.mo1041a(c1002b);
        switch (c1002b.f3896a) {
            case 2:
                this.f3902c.mo1039a(i, c1002b.f3899d);
                return;
            case 4:
                this.f3902c.mo1040a(i, c1002b.f3899d, c1002b.f3898c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int m7201c(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f3901b.size() - 1; size >= 0; size--) {
            C1002b c1002b = (C1002b) this.f3901b.get(size);
            if (c1002b.f3896a == 8) {
                int i5;
                int i6;
                if (c1002b.f3897b < c1002b.f3899d) {
                    i5 = c1002b.f3897b;
                    i3 = c1002b.f3899d;
                } else {
                    i5 = c1002b.f3899d;
                    i3 = c1002b.f3897b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c1002b.f3897b) {
                        if (i2 == 1) {
                            c1002b.f3897b++;
                            c1002b.f3899d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            c1002b.f3897b--;
                            c1002b.f3899d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c1002b.f3897b) {
                    if (i2 == 1) {
                        c1002b.f3899d++;
                    } else if (i2 == 2) {
                        c1002b.f3899d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c1002b.f3897b++;
                    } else if (i2 == 2) {
                        c1002b.f3897b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c1002b.f3897b <= i4) {
                if (c1002b.f3896a == 1) {
                    i4 -= c1002b.f3899d;
                } else if (c1002b.f3896a == 2) {
                    i4 += c1002b.f3899d;
                }
            } else if (i2 == 1) {
                c1002b.f3897b++;
            } else if (i2 == 2) {
                c1002b.f3897b--;
            }
        }
        for (i3 = this.f3901b.size() - 1; i3 >= 0; i3--) {
            c1002b = (C1002b) this.f3901b.get(i3);
            if (c1002b.f3896a == 8) {
                if (c1002b.f3899d == c1002b.f3897b || c1002b.f3899d < 0) {
                    this.f3901b.remove(i3);
                    mo1088a(c1002b);
                }
            } else if (c1002b.f3899d <= 0) {
                this.f3901b.remove(i3);
                mo1088a(c1002b);
            }
        }
        return i4;
    }

    private boolean m7204d(int i) {
        int size = this.f3901b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1002b c1002b = (C1002b) this.f3901b.get(i2);
            if (c1002b.f3896a == 8) {
                if (m7208a(c1002b.f3899d, i2 + 1) == i) {
                    return true;
                }
            } else if (c1002b.f3896a == 1) {
                int i3 = c1002b.f3897b + c1002b.f3899d;
                for (int i4 = c1002b.f3897b; i4 < i3; i4++) {
                    if (m7208a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m7206f(C1002b c1002b) {
        m7207g(c1002b);
    }

    private void m7207g(C1002b c1002b) {
        this.f3901b.add(c1002b);
        switch (c1002b.f3896a) {
            case 1:
                this.f3902c.mo1044c(c1002b.f3897b, c1002b.f3899d);
                return;
            case 2:
                this.f3902c.mo1042b(c1002b.f3897b, c1002b.f3899d);
                return;
            case 4:
                this.f3902c.mo1040a(c1002b.f3897b, c1002b.f3899d, c1002b.f3898c);
                return;
            case 8:
                this.f3902c.mo1045d(c1002b.f3897b, c1002b.f3899d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c1002b);
        }
    }

    boolean m7221d() {
        return this.f3900a.size() > 0;
    }

    boolean m7214a(int i) {
        return (this.f3907h & i) != 0;
    }

    int m7216b(int i) {
        return m7208a(i, 0);
    }

    int m7208a(int i, int i2) {
        int size = this.f3901b.size();
        int i3 = i;
        while (i2 < size) {
            C1002b c1002b = (C1002b) this.f3901b.get(i2);
            if (c1002b.f3896a == 8) {
                if (c1002b.f3897b == i3) {
                    i3 = c1002b.f3899d;
                } else {
                    if (c1002b.f3897b < i3) {
                        i3--;
                    }
                    if (c1002b.f3899d <= i3) {
                        i3++;
                    }
                }
            } else if (c1002b.f3897b > i3) {
                continue;
            } else if (c1002b.f3896a == 2) {
                if (i3 < c1002b.f3897b + c1002b.f3899d) {
                    return -1;
                }
                i3 -= c1002b.f3899d;
            } else if (c1002b.f3896a == 1) {
                i3 += c1002b.f3899d;
            }
            i2++;
        }
        return i3;
    }

    boolean m7215a(int i, int i2, Object obj) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.f3900a.add(mo1087a(4, i, i2, obj));
        this.f3907h |= 4;
        if (this.f3900a.size() != 1) {
            z = false;
        }
        return z;
    }

    boolean m7218b(int i, int i2) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.f3900a.add(mo1087a(1, i, i2, null));
        this.f3907h |= 1;
        if (this.f3900a.size() != 1) {
            z = false;
        }
        return z;
    }

    void m7222e() {
        m7220c();
        int size = this.f3900a.size();
        for (int i = 0; i < size; i++) {
            C1002b c1002b = (C1002b) this.f3900a.get(i);
            switch (c1002b.f3896a) {
                case 1:
                    this.f3902c.mo1043b(c1002b);
                    this.f3902c.mo1044c(c1002b.f3897b, c1002b.f3899d);
                    break;
                case 2:
                    this.f3902c.mo1043b(c1002b);
                    this.f3902c.mo1039a(c1002b.f3897b, c1002b.f3899d);
                    break;
                case 4:
                    this.f3902c.mo1043b(c1002b);
                    this.f3902c.mo1040a(c1002b.f3897b, c1002b.f3899d, c1002b.f3898c);
                    break;
                case 8:
                    this.f3902c.mo1043b(c1002b);
                    this.f3902c.mo1045d(c1002b.f3897b, c1002b.f3899d);
                    break;
            }
            if (this.f3903d != null) {
                this.f3903d.run();
            }
        }
        m7213a(this.f3900a);
        this.f3907h = 0;
    }

    public int m7219c(int i) {
        int size = this.f3900a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C1002b c1002b = (C1002b) this.f3900a.get(i3);
            switch (c1002b.f3896a) {
                case 1:
                    if (c1002b.f3897b > i2) {
                        break;
                    }
                    i2 += c1002b.f3899d;
                    break;
                case 2:
                    if (c1002b.f3897b <= i2) {
                        if (c1002b.f3897b + c1002b.f3899d <= i2) {
                            i2 -= c1002b.f3899d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (c1002b.f3897b != i2) {
                        if (c1002b.f3897b < i2) {
                            i2--;
                        }
                        if (c1002b.f3899d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c1002b.f3899d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    boolean m7223f() {
        return (this.f3901b.isEmpty() || this.f3900a.isEmpty()) ? false : true;
    }

    public C1002b mo1087a(int i, int i2, int i3, Object obj) {
        C1002b c1002b = (C1002b) this.f3906g.mo428a();
        if (c1002b == null) {
            return new C1002b(i, i2, i3, obj);
        }
        c1002b.f3896a = i;
        c1002b.f3897b = i2;
        c1002b.f3899d = i3;
        c1002b.f3898c = obj;
        return c1002b;
    }

    public void mo1088a(C1002b c1002b) {
        if (!this.f3904e) {
            c1002b.f3898c = null;
            this.f3906g.mo429a(c1002b);
        }
    }

    void m7213a(List<C1002b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo1088a((C1002b) list.get(i));
        }
        list.clear();
    }
}
