package com.p041a.p042a.p043a;

public class C1091r extends C1074c<C1091r> {
    private final String f4139c;

    public C1091r(String str) {
        if (str == null) {
            throw new NullPointerException("eventName must not be null");
        }
        this.f4139c = this.a.m7621a(str);
    }

    String m7667b() {
        return this.f4139c;
    }

    public String toString() {
        return "{eventName:\"" + this.f4139c + '\"' + ", customAttributes:" + this.b + "}";
    }
}
