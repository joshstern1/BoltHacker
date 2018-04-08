package com.p059c.p060a;

import java.util.ArrayList;

public abstract class C1238a implements Cloneable {
    ArrayList<C1237a> f4586a = null;

    public interface C1237a {
        void mo1226a(C1238a c1238a);

        void mo1227b(C1238a c1238a);

        void mo1228c(C1238a c1238a);

        void mo1229d(C1238a c1238a);
    }

    public abstract boolean mo1223d();

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1225g();
    }

    public void mo1219a() {
    }

    public void mo1220b() {
    }

    public void mo1221c() {
    }

    public boolean mo1224e() {
        return mo1223d();
    }

    public void m8235a(C1237a c1237a) {
        if (this.f4586a == null) {
            this.f4586a = new ArrayList();
        }
        this.f4586a.add(c1237a);
    }

    public void m8237b(C1237a c1237a) {
        if (this.f4586a != null) {
            this.f4586a.remove(c1237a);
            if (this.f4586a.size() == 0) {
                this.f4586a = null;
            }
        }
    }

    public ArrayList<C1237a> m8241f() {
        return this.f4586a;
    }

    public C1238a mo1225g() {
        try {
            C1238a c1238a = (C1238a) super.clone();
            if (this.f4586a != null) {
                ArrayList arrayList = this.f4586a;
                c1238a.f4586a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    c1238a.f4586a.add(arrayList.get(i));
                }
            }
            return c1238a;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
