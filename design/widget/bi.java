package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.bf.C0266e;
import android.support.design.widget.bf.C0266e.C0264a;
import android.support.design.widget.bf.C0266e.C0265b;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class bi extends C0266e {
    private static final Handler f1331a = new Handler(Looper.getMainLooper());
    private long f1332b;
    private boolean f1333c;
    private final int[] f1334d = new int[2];
    private final float[] f1335e = new float[2];
    private int f1336f = 200;
    private Interpolator f1337g;
    private C0264a f1338h;
    private C0265b f1339i;
    private float f1340j;
    private final Runnable f1341k = new bj(this);

    bi() {
    }

    public void mo257a() {
        if (!this.f1333c) {
            if (this.f1337g == null) {
                this.f1337g = new AccelerateDecelerateInterpolator();
            }
            this.f1332b = SystemClock.uptimeMillis();
            this.f1333c = true;
            if (this.f1338h != null) {
                this.f1338h.mo254a();
            }
            f1331a.postDelayed(this.f1341k, 10);
        }
    }

    public boolean mo264b() {
        return this.f1333c;
    }

    public void mo263a(Interpolator interpolator) {
        this.f1337g = interpolator;
    }

    public void mo261a(C0264a c0264a) {
        this.f1338h = c0264a;
    }

    public void mo262a(C0265b c0265b) {
        this.f1339i = c0265b;
    }

    public void mo260a(int i, int i2) {
        this.f1334d[0] = i;
        this.f1334d[1] = i2;
    }

    public int mo265c() {
        return C0252a.m1908a(this.f1334d[0], this.f1334d[1], mo268f());
    }

    public void mo258a(float f, float f2) {
        this.f1335e[0] = f;
        this.f1335e[1] = f2;
    }

    public float mo266d() {
        return C0252a.m1907a(this.f1335e[0], this.f1335e[1], mo268f());
    }

    public void mo259a(int i) {
        this.f1336f = i;
    }

    public void mo267e() {
        this.f1333c = false;
        f1331a.removeCallbacks(this.f1341k);
        if (this.f1338h != null) {
            this.f1338h.mo256c();
        }
    }

    public float mo268f() {
        return this.f1340j;
    }

    public long mo269g() {
        return (long) this.f1336f;
    }

    private void m2052h() {
        if (this.f1333c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f1332b)) / ((float) this.f1336f);
            if (this.f1337g != null) {
                uptimeMillis = this.f1337g.getInterpolation(uptimeMillis);
            }
            this.f1340j = uptimeMillis;
            if (this.f1339i != null) {
                this.f1339i.mo253a();
            }
            if (SystemClock.uptimeMillis() >= this.f1332b + ((long) this.f1336f)) {
                this.f1333c = false;
                if (this.f1338h != null) {
                    this.f1338h.mo255b();
                }
            }
        }
        if (this.f1333c) {
            f1331a.postDelayed(this.f1341k, 10);
        }
    }
}
