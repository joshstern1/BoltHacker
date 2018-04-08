package com.p041a.p042a.p043a;

import android.content.Context;
import com.p041a.p042a.p043a.ae.C1070a;
import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p045d.C1076e;
import io.p038b.p039a.p040a.p044a.p054g.C3028b;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import java.util.concurrent.ScheduledExecutorService;

class C1077e implements C1076e {
    final ScheduledExecutorService f4109a;
    ad f4110b = new C1092s();
    private final C1062l f4111c;
    private final Context f4112d;
    private final C1084l f4113e;
    private final ah f4114f;
    private final C3009g f4115g;

    public C1077e(C1062l c1062l, Context context, C1084l c1084l, ah ahVar, C3009g c3009g, ScheduledExecutorService scheduledExecutorService) {
        this.f4111c = c1062l;
        this.f4112d = context;
        this.f4113e = c1084l;
        this.f4114f = ahVar;
        this.f4115g = c3009g;
        this.f4109a = scheduledExecutorService;
    }

    public void m7633a(C1070a c1070a) {
        m7634a(c1070a, false, false);
    }

    public void m7638b(C1070a c1070a) {
        m7634a(c1070a, false, true);
    }

    public void m7640c(C1070a c1070a) {
        m7634a(c1070a, true, false);
    }

    public void m7635a(C3028b c3028b, String str) {
        m7628b(new C1078f(this, c3028b, str));
    }

    public void m7632a() {
        m7628b(new C1079g(this));
    }

    public void mo1158a(String str) {
        m7628b(new C1080h(this));
    }

    public void m7637b() {
        m7628b(new C1081i(this));
    }

    public void m7639c() {
        m7628b(new C1082j(this));
    }

    void m7634a(C1070a c1070a, boolean z, boolean z2) {
        Runnable c1083k = new C1083k(this, c1070a, z2);
        if (z) {
            m7626a(c1083k);
        } else {
            m7628b(c1083k);
        }
    }

    private void m7626a(Runnable runnable) {
        try {
            this.f4109a.submit(runnable).get();
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to run events task", e);
        }
    }

    private void m7628b(Runnable runnable) {
        try {
            this.f4109a.submit(runnable);
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to submit events task", e);
        }
    }
}
