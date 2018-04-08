package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C3059d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

class C1089p {
    final AtomicReference<ScheduledFuture<?>> f4133a = new AtomicReference();
    boolean f4134b = true;
    private final ScheduledExecutorService f4135c;
    private final List<C1067a> f4136d = new ArrayList();
    private volatile boolean f4137e = true;

    public interface C1067a {
        void mo1156a();
    }

    public C1089p(ScheduledExecutorService scheduledExecutorService) {
        this.f4135c = scheduledExecutorService;
    }

    public void m7665a(boolean z) {
        this.f4137e = z;
    }

    private void m7662c() {
        for (C1067a a : this.f4136d) {
            a.mo1156a();
        }
    }

    public void m7664a(C1067a c1067a) {
        this.f4136d.add(c1067a);
    }

    public void m7663a() {
        this.f4134b = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f4133a.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void m7666b() {
        if (this.f4137e && !this.f4134b) {
            this.f4134b = true;
            try {
                this.f4133a.compareAndSet(null, this.f4135c.schedule(new C1090q(this), BootloaderScanner.TIMEOUT, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                C3059d.m17342h().mo2432a("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
