package com.p041a.p042a.p049b;

import android.annotation.SuppressLint;
import android.content.Context;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2954h;
import io.p038b.p039a.p040a.p044a.p046b.C2960m;
import io.p038b.p039a.p040a.p044a.p046b.C2967t;
import io.p038b.p039a.p040a.p044a.p046b.C2967t.C2966a;
import io.p038b.p039a.p040a.p044a.p054g.C3032f;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import io.p038b.p039a.p040a.p044a.p121f.C3025c;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class C1104a implements C1103l {
    private final AtomicBoolean f4164a;
    private final AtomicBoolean f4165b;
    private Context f4166c;
    private C1109e f4167d;
    private C2967t f4168e;
    private C3032f f4169f;
    private C1110f f4170g;
    private C3025c f4171h;
    private C2960m f4172i;
    private C3009g f4173j;
    private long f4174k;

    public C1104a() {
        this(false);
    }

    public C1104a(boolean z) {
        this.f4164a = new AtomicBoolean();
        this.f4174k = 0;
        this.f4165b = new AtomicBoolean(z);
    }

    public void mo1175a(Context context, C1109e c1109e, C2967t c2967t, C3032f c3032f, C1110f c1110f, C3025c c3025c, C2960m c2960m, C3009g c3009g) {
        this.f4166c = context;
        this.f4167d = c1109e;
        this.f4168e = c2967t;
        this.f4169f = c3032f;
        this.f4170g = c1110f;
        this.f4171h = c3025c;
        this.f4172i = c2960m;
        this.f4173j = c3009g;
        if (m7707b()) {
            m7708c();
        }
    }

    protected boolean m7706a() {
        this.f4165b.set(true);
        return this.f4164a.get();
    }

    boolean m7707b() {
        this.f4164a.set(true);
        return this.f4165b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void m7708c() {
        synchronized (this.f4171h) {
            if (this.f4171h.mo2420a().contains("last_update_check")) {
                this.f4171h.mo2421a(this.f4171h.mo2422b().remove("last_update_check"));
            }
        }
        long a = this.f4172i.mo2401a();
        long j = ((long) this.f4169f.f10036b) * 1000;
        C3059d.m17342h().mo2431a("Beta", "Check for updates delay: " + j);
        C3059d.m17342h().mo2431a("Beta", "Check for updates last check time: " + m7709d());
        j += m7709d();
        C3059d.m17342h().mo2431a("Beta", "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                m7703e();
            } finally {
                m7704a(a);
            }
        } else {
            C3059d.m17342h().mo2431a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void m7703e() {
        C3059d.m17342h().mo2431a("Beta", "Performing update check");
        new C1111g(this.f4167d, this.f4167d.m7723g(), this.f4169f.f10035a, this.f4173j, new C1113i()).m7729a(new C2954h().m16973a(this.f4166c), (String) this.f4168e.m17045i().get(C2966a.FONT_TOKEN), this.f4170g);
    }

    void m7704a(long j) {
        this.f4174k = j;
    }

    long m7709d() {
        return this.f4174k;
    }
}
