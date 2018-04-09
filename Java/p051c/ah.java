package com.p041a.p042a.p051c;

import java.util.Date;
import java.util.concurrent.Callable;

class ah implements Callable<Void> {
    final /* synthetic */ Date f4231a;
    final /* synthetic */ Thread f4232b;
    final /* synthetic */ Throwable f4233c;
    final /* synthetic */ C1182y f4234d;

    ah(C1182y c1182y, Date date, Thread thread, Throwable th) {
        this.f4234d = c1182y;
        this.f4231a = date;
        this.f4232b = thread;
        this.f4233c = th;
    }

    public /* synthetic */ Object call() throws Exception {
        return m7743a();
    }

    public Void m7743a() throws Exception {
        this.f4234d.m8051a(this.f4231a, this.f4232b, this.f4233c);
        return null;
    }
}
