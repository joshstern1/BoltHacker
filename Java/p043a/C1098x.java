package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.p044a.p047c.p048a.C2985e;

class C1098x {
    long f4156a;
    private C2985e f4157b;

    public C1098x(C2985e c2985e) {
        if (c2985e == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.f4157b = c2985e;
    }

    public boolean m7688a(long j) {
        return j - this.f4156a >= 1000000 * this.f4157b.m17084a();
    }

    public void m7689b(long j) {
        this.f4156a = j;
        this.f4157b = this.f4157b.m17085b();
    }

    public void m7687a() {
        this.f4156a = 0;
        this.f4157b = this.f4157b.m17086c();
    }
}
