package android.support.v7.view;

import android.support.v4.view.bo;
import android.support.v4.view.bw;
import android.support.v4.view.bx;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class C0860h {
    private final ArrayList<bo> f2842a = new ArrayList();
    private long f2843b = -1;
    private Interpolator f2844c;
    private bw f2845d;
    private boolean f2846e;
    private final bx f2847f = new C0861i(this);

    public C0860h m5537a(bo boVar) {
        if (!this.f2846e) {
            this.f2842a.add(boVar);
        }
        return this;
    }

    public C0860h m5538a(bo boVar, bo boVar2) {
        this.f2842a.add(boVar);
        boVar2.m4195b(boVar.m4188a());
        this.f2842a.add(boVar2);
        return this;
    }

    public void m5541a() {
        if (!this.f2846e) {
            Iterator it = this.f2842a.iterator();
            while (it.hasNext()) {
                bo boVar = (bo) it.next();
                if (this.f2843b >= 0) {
                    boVar.m4190a(this.f2843b);
                }
                if (this.f2844c != null) {
                    boVar.m4193a(this.f2844c);
                }
                if (this.f2845d != null) {
                    boVar.m4191a(this.f2847f);
                }
                boVar.m4198c();
            }
            this.f2846e = true;
        }
    }

    private void m5535c() {
        this.f2846e = false;
    }

    public void m5542b() {
        if (this.f2846e) {
            Iterator it = this.f2842a.iterator();
            while (it.hasNext()) {
                ((bo) it.next()).m4196b();
            }
            this.f2846e = false;
        }
    }

    public C0860h m5536a(long j) {
        if (!this.f2846e) {
            this.f2843b = j;
        }
        return this;
    }

    public C0860h m5540a(Interpolator interpolator) {
        if (!this.f2846e) {
            this.f2844c = interpolator;
        }
        return this;
    }

    public C0860h m5539a(bw bwVar) {
        if (!this.f2846e) {
            this.f2845d = bwVar;
        }
        return this;
    }
}
