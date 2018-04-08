package com.p041a.p042a.p051c;

import java.util.concurrent.Callable;

class ai implements Callable<Void> {
    final /* synthetic */ String f4235a;
    final /* synthetic */ String f4236b;
    final /* synthetic */ String f4237c;
    final /* synthetic */ C1182y f4238d;

    ai(C1182y c1182y, String str, String str2, String str3) {
        this.f4238d = c1182y;
        this.f4235a = str;
        this.f4236b = str2;
        this.f4237c = str3;
    }

    public /* synthetic */ Object call() throws Exception {
        return m7744a();
    }

    public Void m7744a() throws Exception {
        new at(this.f4238d.m8078q()).m7784a(this.f4238d.m8071j(), new bf(this.f4235a, this.f4236b, this.f4237c));
        return null;
    }
}
