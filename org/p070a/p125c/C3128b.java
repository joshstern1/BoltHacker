package org.p070a.p125c;

public class C3128b extends Exception {
    private int f10300a;

    public C3128b(int i) {
        this.f10300a = i;
    }

    public C3128b(int i, String str) {
        super(str);
        this.f10300a = i;
    }

    public C3128b(int i, Throwable th) {
        super(th);
        this.f10300a = i;
    }

    public int m17582a() {
        return this.f10300a;
    }
}
