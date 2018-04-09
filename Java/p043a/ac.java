package com.p041a.p042a.p043a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.p041a.p042a.p043a.C1089p.C1067a;
import com.p041a.p042a.p043a.ae.C1071b;
import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3054a;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2962p;
import io.p038b.p039a.p040a.p044a.p046b.C2967t;
import io.p038b.p039a.p040a.p044a.p054g.C3028b;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import io.p038b.p039a.p040a.p044a.p055e.C3010b;
import io.p038b.p039a.p040a.p044a.p121f.C3024b;
import java.util.concurrent.ScheduledExecutorService;

class ac implements C1067a {
    final C1077e f4055a;
    final C3054a f4056b;
    final C1089p f4057c;
    final C1087n f4058d;
    private final long f4059e;

    public static ac m7585a(C1062l c1062l, Context context, C2967t c2967t, String str, String str2, long j) {
        ah ahVar = new ah(context, c2967t, str, str2);
        C1084l c1084l = new C1084l(context, new C3024b(c1062l));
        C3009g c3010b = new C3010b(C3059d.m17342h());
        C3054a c3054a = new C3054a(context);
        ScheduledExecutorService b = C2962p.m17029b("Answers Events Handler");
        C1089p c1089p = new C1089p(b);
        return new ac(new C1077e(c1062l, context, c1084l, ahVar, c3010b, b), c3054a, c1089p, C1087n.m7656a(context), j);
    }

    ac(C1077e c1077e, C3054a c3054a, C1089p c1089p, C1087n c1087n, long j) {
        this.f4055a = c1077e;
        this.f4056b = c3054a;
        this.f4057c = c1089p;
        this.f4058d = c1087n;
        this.f4059e = j;
    }

    public void m7592b() {
        this.f4055a.m7637b();
        this.f4056b.m17306a(new C1086m(this, this.f4057c));
        this.f4057c.m7664a((C1067a) this);
        if (m7591a(this.f4059e)) {
            m7595d();
            this.f4058d.m7657a();
        }
    }

    public void m7594c() {
        this.f4056b.m17305a();
        this.f4055a.m7632a();
    }

    public void m7588a(C1091r c1091r) {
        C3059d.m17342h().mo2431a("Answers", "Logged custom event: " + c1091r);
        this.f4055a.m7633a(ae.m7608a(c1091r));
    }

    public void m7590a(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        C3059d.m17342h().mo2431a("Answers", "Logged crash");
        this.f4055a.m7640c(ae.m7610a(str, str2));
    }

    public void m7595d() {
        C3059d.m17342h().mo2431a("Answers", "Logged install");
        this.f4055a.m7638b(ae.m7606a());
    }

    public void m7587a(Activity activity, C1071b c1071b) {
        C3059d.m17342h().mo2431a("Answers", "Logged lifecycle event: " + c1071b.name());
        this.f4055a.m7633a(ae.m7607a(c1071b, activity));
    }

    public void mo1156a() {
        C3059d.m17342h().mo2431a("Answers", "Flush events when app is backgrounded");
        this.f4055a.m7639c();
    }

    public void m7589a(C3028b c3028b, String str) {
        this.f4057c.m7665a(c3028b.f10013h);
        this.f4055a.m7635a(c3028b, str);
    }

    boolean m7591a(long j) {
        return !this.f4058d.m7658b() && m7593b(j);
    }

    boolean m7593b(long j) {
        return System.currentTimeMillis() - j < 3600000;
    }
}
