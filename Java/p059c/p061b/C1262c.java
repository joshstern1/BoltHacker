package com.p059c.p061b;

public abstract class C1262c<T, V> {
    private final String f4706a;
    private final Class<V> f4707b;

    public abstract V mo1247a(T t);

    public C1262c(Class<V> cls, String str) {
        this.f4706a = str;
        this.f4707b = cls;
    }

    public void mo1246a(T t, V v) {
        throw new UnsupportedOperationException("Property " + m8395a() + " is read-only");
    }

    public String m8395a() {
        return this.f4706a;
    }
}
