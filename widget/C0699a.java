package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0684z;
import android.support.v4.view.ao;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class C0699a implements OnTouchListener {
    private static final int f2303r = ViewConfiguration.getTapTimeout();
    private final C0697a f2304a = new C0697a();
    private final Interpolator f2305b = new AccelerateInterpolator();
    private final View f2306c;
    private Runnable f2307d;
    private float[] f2308e = new float[]{0.0f, 0.0f};
    private float[] f2309f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f2310g;
    private int f2311h;
    private float[] f2312i = new float[]{0.0f, 0.0f};
    private float[] f2313j = new float[]{0.0f, 0.0f};
    private float[] f2314k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f2315l;
    private boolean f2316m;
    private boolean f2317n;
    private boolean f2318o;
    private boolean f2319p;
    private boolean f2320q;

    private static class C0697a {
        private int f2291a;
        private int f2292b;
        private float f2293c;
        private float f2294d;
        private long f2295e = Long.MIN_VALUE;
        private long f2296f = 0;
        private int f2297g = 0;
        private int f2298h = 0;
        private long f2299i = -1;
        private float f2300j;
        private int f2301k;

        public void m4585a(int i) {
            this.f2291a = i;
        }

        public void m4587b(int i) {
            this.f2292b = i;
        }

        public void m4583a() {
            this.f2295e = AnimationUtils.currentAnimationTimeMillis();
            this.f2299i = -1;
            this.f2296f = this.f2295e;
            this.f2300j = 0.5f;
            this.f2297g = 0;
            this.f2298h = 0;
        }

        public void m4586b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2301k = C0699a.m4602b((int) (currentAnimationTimeMillis - this.f2295e), 0, this.f2292b);
            this.f2300j = m4582a(currentAnimationTimeMillis);
            this.f2299i = currentAnimationTimeMillis;
        }

        public boolean m4588c() {
            return this.f2299i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2299i + ((long) this.f2301k);
        }

        private float m4582a(long j) {
            if (j < this.f2295e) {
                return 0.0f;
            }
            if (this.f2299i < 0 || j < this.f2299i) {
                return C0699a.m4601b(((float) (j - this.f2295e)) / ((float) this.f2291a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f2299i;
            return (C0699a.m4601b(((float) j2) / ((float) this.f2301k), 0.0f, 1.0f) * this.f2300j) + (1.0f - this.f2300j);
        }

        private float m4581a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        public void m4589d() {
            if (this.f2296f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m4581a(m4582a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f2296f;
            this.f2296f = currentAnimationTimeMillis;
            this.f2297g = (int) ((((float) j) * a) * this.f2293c);
            this.f2298h = (int) ((((float) j) * a) * this.f2294d);
        }

        public void m4584a(float f, float f2) {
            this.f2293c = f;
            this.f2294d = f2;
        }

        public int m4590e() {
            return (int) (this.f2293c / Math.abs(this.f2293c));
        }

        public int m4591f() {
            return (int) (this.f2294d / Math.abs(this.f2294d));
        }

        public int m4592g() {
            return this.f2297g;
        }

        public int m4593h() {
            return this.f2298h;
        }
    }

    private class C0698b implements Runnable {
        final /* synthetic */ C0699a f2302a;

        private C0698b(C0699a c0699a) {
            this.f2302a = c0699a;
        }

        public void run() {
            if (this.f2302a.f2318o) {
                if (this.f2302a.f2316m) {
                    this.f2302a.f2316m = false;
                    this.f2302a.f2304a.m4583a();
                }
                C0697a c = this.f2302a.f2304a;
                if (c.m4588c() || !this.f2302a.m4598a()) {
                    this.f2302a.f2318o = false;
                    return;
                }
                if (this.f2302a.f2317n) {
                    this.f2302a.f2317n = false;
                    this.f2302a.m4609d();
                }
                c.m4589d();
                this.f2302a.mo717a(c.m4592g(), c.m4593h());
                ao.m3913a(this.f2302a.f2306c, (Runnable) this);
            }
        }
    }

    public abstract void mo717a(int i, int i2);

    public abstract boolean mo718e(int i);

    public abstract boolean mo719f(int i);

    public C0699a(View view) {
        this.f2306c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m4615a((float) i, (float) i);
        m4619b((float) i2, (float) i2);
        m4616a(1);
        m4625e(Float.MAX_VALUE, Float.MAX_VALUE);
        m4623d(0.2f, 0.2f);
        m4621c(1.0f, 1.0f);
        m4620b(f2303r);
        m4622c(500);
        m4624d(500);
    }

    public C0699a m4617a(boolean z) {
        if (this.f2319p && !z) {
            m4607c();
        }
        this.f2319p = z;
        return this;
    }

    public C0699a m4615a(float f, float f2) {
        this.f2314k[0] = f / 1000.0f;
        this.f2314k[1] = f2 / 1000.0f;
        return this;
    }

    public C0699a m4619b(float f, float f2) {
        this.f2313j[0] = f / 1000.0f;
        this.f2313j[1] = f2 / 1000.0f;
        return this;
    }

    public C0699a m4621c(float f, float f2) {
        this.f2312i[0] = f / 1000.0f;
        this.f2312i[1] = f2 / 1000.0f;
        return this;
    }

    public C0699a m4616a(int i) {
        this.f2310g = i;
        return this;
    }

    public C0699a m4623d(float f, float f2) {
        this.f2308e[0] = f;
        this.f2308e[1] = f2;
        return this;
    }

    public C0699a m4625e(float f, float f2) {
        this.f2309f[0] = f;
        this.f2309f[1] = f2;
        return this;
    }

    public C0699a m4620b(int i) {
        this.f2311h = i;
        return this;
    }

    public C0699a m4622c(int i) {
        this.f2304a.m4585a(i);
        return this;
    }

    public C0699a m4624d(int i) {
        this.f2304a.m4587b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f2319p) {
            return false;
        }
        switch (C0684z.m4397a(motionEvent)) {
            case 0:
                this.f2317n = true;
                this.f2315l = false;
                break;
            case 1:
            case 3:
                m4607c();
                break;
            case 2:
                break;
        }
        this.f2304a.m4584a(m4596a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f2306c.getWidth()), m4596a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f2306c.getHeight()));
        if (!this.f2318o && m4598a()) {
            m4603b();
        }
        if (!(this.f2320q && this.f2318o)) {
            z = false;
        }
        return z;
    }

    private boolean m4598a() {
        C0697a c0697a = this.f2304a;
        int f = c0697a.m4591f();
        int e = c0697a.m4590e();
        return (f != 0 && mo719f(f)) || (e != 0 && mo718e(e));
    }

    private void m4603b() {
        if (this.f2307d == null) {
            this.f2307d = new C0698b();
        }
        this.f2318o = true;
        this.f2316m = true;
        if (this.f2315l || this.f2311h <= 0) {
            this.f2307d.run();
        } else {
            ao.m3914a(this.f2306c, this.f2307d, (long) this.f2311h);
        }
        this.f2315l = true;
    }

    private void m4607c() {
        if (this.f2316m) {
            this.f2318o = false;
        } else {
            this.f2304a.m4586b();
        }
    }

    private float m4596a(int i, float f, float f2, float f3) {
        float a = m4595a(this.f2308e[i], f2, this.f2309f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f2312i[i];
        float f5 = this.f2313j[i];
        float f6 = this.f2314k[i];
        f4 *= f3;
        if (a > 0.0f) {
            return C0699a.m4601b(a * f4, f5, f6);
        }
        return -C0699a.m4601b((-a) * f4, f5, f6);
    }

    private float m4595a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0699a.m4601b(f * f2, 0.0f, f3);
        b = m4612f(f2 - f4, b) - m4612f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f2305b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f2305b.getInterpolation(b);
        }
        return C0699a.m4601b(f5, -1.0f, 1.0f);
    }

    private float m4612f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f2310g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f2318o && this.f2310g == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static int m4602b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private static float m4601b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    private void m4609d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2306c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
