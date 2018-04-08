package com.p074e.p075a;

final class C1423f implements Runnable {
    final /* synthetic */ ap f5466a;
    final /* synthetic */ RuntimeException f5467b;

    C1423f(ap apVar, RuntimeException runtimeException) {
        this.f5466a = apVar;
        this.f5467b = runtimeException;
    }

    public void run() {
        throw new RuntimeException("Transformation " + this.f5466a.mo2294a() + " crashed with exception.", this.f5467b);
    }
}
