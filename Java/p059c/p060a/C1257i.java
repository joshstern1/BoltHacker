package com.p059c.p060a;

import android.view.animation.Interpolator;

public abstract class C1257i implements Cloneable {
    float f4682a;
    Class f4683b;
    boolean f4684c = false;
    private Interpolator f4685d = null;

    static class C1258a extends C1257i {
        float f4686d;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m8377h();
        }

        public /* synthetic */ C1257i mo1237f() {
            return m8377h();
        }

        C1258a(float f, float f2) {
            this.a = f;
            this.f4686d = f2;
            this.b = Float.TYPE;
            this.c = true;
        }

        C1258a(float f) {
            this.a = f;
            this.b = Float.TYPE;
        }

        public float m8376g() {
            return this.f4686d;
        }

        public Object mo1235b() {
            return Float.valueOf(this.f4686d);
        }

        public void mo1234a(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.f4686d = ((Float) obj).floatValue();
                this.c = true;
            }
        }

        public C1258a m8377h() {
            C1258a c1258a = new C1258a(m8369c(), this.f4686d);
            c1258a.m8365a(m8370d());
            return c1258a;
        }
    }

    static class C1259b extends C1257i {
        int f4687d;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m8382h();
        }

        public /* synthetic */ C1257i mo1237f() {
            return m8382h();
        }

        C1259b(float f, int i) {
            this.a = f;
            this.f4687d = i;
            this.b = Integer.TYPE;
            this.c = true;
        }

        public int m8381g() {
            return this.f4687d;
        }

        public Object mo1235b() {
            return Integer.valueOf(this.f4687d);
        }

        public void mo1234a(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.f4687d = ((Integer) obj).intValue();
                this.c = true;
            }
        }

        public C1259b m8382h() {
            C1259b c1259b = new C1259b(m8369c(), this.f4687d);
            c1259b.m8365a(m8370d());
            return c1259b;
        }
    }

    public abstract void mo1234a(Object obj);

    public abstract Object mo1235b();

    public abstract C1257i mo1237f();

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1237f();
    }

    public static C1257i m8364a(float f, float f2) {
        return new C1258a(f, f2);
    }

    public static C1257i m8363a(float f) {
        return new C1258a(f);
    }

    public boolean m8367a() {
        return this.f4684c;
    }

    public float m8369c() {
        return this.f4682a;
    }

    public Interpolator m8370d() {
        return this.f4685d;
    }

    public void m8365a(Interpolator interpolator) {
        this.f4685d = interpolator;
    }

    public Class m8371e() {
        return this.f4683b;
    }
}
