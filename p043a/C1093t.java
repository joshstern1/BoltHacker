package com.p041a.p042a.p043a;

import android.content.Context;
import com.p041a.p042a.p043a.ae.C1070a;
import com.p041a.p042a.p043a.ae.C1071b;
import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p045d.C1066g;
import io.p038b.p039a.p040a.p044a.p045d.C3006j;
import io.p038b.p039a.p040a.p044a.p046b.C2954h;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p054g.C3028b;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class C1093t implements ad {
    final af f4140a;
    C1066g f4141b;
    C2954h f4142c = new C2954h();
    C1094u f4143d = new C1095v();
    boolean f4144e = true;
    boolean f4145f = true;
    volatile int f4146g = -1;
    private final C1062l f4147h;
    private final C3009g f4148i;
    private final Context f4149j;
    private final aa f4150k;
    private final ScheduledExecutorService f4151l;
    private final AtomicReference<ScheduledFuture<?>> f4152m = new AtomicReference();

    public C1093t(C1062l c1062l, Context context, ScheduledExecutorService scheduledExecutorService, aa aaVar, C3009g c3009g, af afVar) {
        this.f4147h = c1062l;
        this.f4149j = context;
        this.f4151l = scheduledExecutorService;
        this.f4150k = aaVar;
        this.f4148i = c3009g;
        this.f4140a = afVar;
    }

    public void mo1168a(C3028b c3028b, String str) {
        this.f4141b = C1088o.m7659a(new ab(this.f4147h, str, c3028b.f10006a, this.f4148i, this.f4142c.m16973a(this.f4149j)));
        this.f4150k.m7575a(c3028b);
        this.f4144e = c3028b.f10011f;
        C3059d.m17342h().mo2431a("Answers", "Custom event tracking " + (this.f4144e ? "enabled" : "disabled"));
        this.f4145f = c3028b.f10012g;
        C3059d.m17342h().mo2431a("Answers", "Predefined event tracking " + (this.f4145f ? "enabled" : "disabled"));
        if (c3028b.f10014i > 1) {
            C3059d.m17342h().mo2431a("Answers", "Event sampling enabled");
            this.f4143d = new C1099y(c3028b.f10014i);
        }
        this.f4146g = c3028b.f10007b;
        m7675a(0, (long) this.f4146g);
    }

    public void mo1167a(C1070a c1070a) {
        ae a = c1070a.m7604a(this.f4140a);
        if (!this.f4144e && C1071b.CUSTOM.equals(a.f4078c)) {
            C3059d.m17342h().mo2431a("Answers", "Custom events tracking disabled - skipping event: " + a);
        } else if (!this.f4145f && C1071b.PREDEFINED.equals(a.f4078c)) {
            C3059d.m17342h().mo2431a("Answers", "Predefined events tracking disabled - skipping event: " + a);
        } else if (this.f4143d.mo1172a(a)) {
            C3059d.m17342h().mo2431a("Answers", "Skipping filtered event: " + a);
        } else {
            try {
                this.f4150k.m7566a((Object) a);
            } catch (Throwable e) {
                C3059d.m17342h().mo2439e("Answers", "Failed to write event: " + a, e);
            }
            m7681e();
        }
    }

    public void m7681e() {
        if ((this.f4146g != -1 ? 1 : null) != null) {
            m7675a((long) this.f4146g, (long) this.f4146g);
        }
    }

    public void mo1166a() {
        if (this.f4141b == null) {
            C2956j.m16993a(this.f4149j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C2956j.m16993a(this.f4149j, "Sending all files");
        List e = this.f4150k.m7571e();
        int i = 0;
        while (e.size() > 0) {
            int size;
            C2956j.m16993a(this.f4149j, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e.size())}));
            boolean a = this.f4141b.mo1155a(e);
            if (a) {
                size = e.size() + i;
                try {
                    this.f4150k.m7567a(e);
                    i = size;
                } catch (Exception e2) {
                    Throwable e3 = e2;
                }
            }
            if (!a) {
                break;
            }
            try {
                e = this.f4150k.m7571e();
            } catch (Throwable e4) {
                Throwable th = e4;
                size = i;
                e3 = th;
            }
        }
        if (i == 0) {
            this.f4150k.m7573g();
        }
        C2956j.m16994a(this.f4149j, "Failed to send batch of analytics files to server: " + e3.getMessage(), e3);
        i = size;
        if (i == 0) {
            this.f4150k.m7573g();
        }
    }

    public void mo1171d() {
        if (this.f4152m.get() != null) {
            C2956j.m16993a(this.f4149j, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f4152m.get()).cancel(false);
            this.f4152m.set(null);
        }
    }

    public void mo1169b() {
        this.f4150k.m7572f();
    }

    public boolean mo1170c() {
        try {
            return this.f4150k.m7570d();
        } catch (Throwable e) {
            C2956j.m16994a(this.f4149j, "Failed to roll file over.", e);
            return false;
        }
    }

    void m7675a(long j, long j2) {
        if ((this.f4152m.get() == null ? 1 : null) != null) {
            Runnable c3006j = new C3006j(this.f4149j, this);
            C2956j.m16993a(this.f4149j, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f4152m.set(this.f4151l.scheduleAtFixedRate(c3006j, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                C2956j.m16994a(this.f4149j, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
