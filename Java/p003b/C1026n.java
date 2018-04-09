package p003b;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class C1026n extends ac {
    private ac f3963a;

    public C1026n(ac acVar) {
        if (acVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3963a = acVar;
    }

    public final ac m7407a() {
        return this.f3963a;
    }

    public final C1026n m7410a(ac acVar) {
        if (acVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3963a = acVar;
        return this;
    }

    public ac mo1091a(long j, TimeUnit timeUnit) {
        return this.f3963a.mo1091a(j, timeUnit);
    }

    public long p_() {
        return this.f3963a.p_();
    }

    public boolean q_() {
        return this.f3963a.q_();
    }

    public long mo1123d() {
        return this.f3963a.mo1123d();
    }

    public ac mo1090a(long j) {
        return this.f3963a.mo1090a(j);
    }

    public ac r_() {
        return this.f3963a.r_();
    }

    public ac mo1124f() {
        return this.f3963a.mo1124f();
    }

    public void mo1092g() throws IOException {
        this.f3963a.mo1092g();
    }
}
