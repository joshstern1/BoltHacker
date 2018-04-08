package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0684z;
import android.support.v4.view.am;
import android.support.v4.view.ao;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class bd {
    private static final Interpolator f2397v = new be();
    private int f2398a;
    private int f2399b;
    private int f2400c = -1;
    private float[] f2401d;
    private float[] f2402e;
    private float[] f2403f;
    private float[] f2404g;
    private int[] f2405h;
    private int[] f2406i;
    private int[] f2407j;
    private int f2408k;
    private VelocityTracker f2409l;
    private float f2410m;
    private float f2411n;
    private int f2412o;
    private int f2413p;
    private am f2414q;
    private final C0258a f2415r;
    private View f2416s;
    private boolean f2417t;
    private final ViewGroup f2418u;
    private final Runnable f2419w = new bf(this);

    public static abstract class C0258a {
        public abstract boolean mo241a(View view, int i);

        public void mo238a(int i) {
        }

        public void mo240a(View view, int i, int i2, int i3, int i4) {
        }

        public void mo244b(View view, int i) {
        }

        public void mo239a(View view, float f, float f2) {
        }

        public void mo673a(int i, int i2) {
        }

        public boolean mo675b(int i) {
            return false;
        }

        public void mo674b(int i, int i2) {
        }

        public int m1989c(int i) {
            return i;
        }

        public int mo242b(View view) {
            return 0;
        }

        public int mo273a(View view) {
            return 0;
        }

        public int mo243b(View view, int i, int i2) {
            return 0;
        }

        public int mo237a(View view, int i, int i2) {
            return 0;
        }
    }

    public static bd m4809a(ViewGroup viewGroup, C0258a c0258a) {
        return new bd(viewGroup.getContext(), viewGroup, c0258a);
    }

    public static bd m4808a(ViewGroup viewGroup, float f, C0258a c0258a) {
        bd a = m4809a(viewGroup, c0258a);
        a.f2399b = (int) (((float) a.f2399b) * (1.0f / f));
        return a;
    }

    private bd(Context context, ViewGroup viewGroup, C0258a c0258a) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0258a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f2418u = viewGroup;
            this.f2415r = c0258a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f2412o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f2399b = viewConfiguration.getScaledTouchSlop();
            this.f2410m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f2411n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f2414q = am.m4762a(context, f2397v);
        }
    }

    public void m4827a(float f) {
        this.f2411n = f;
    }

    public int m4826a() {
        return this.f2398a;
    }

    public void m4828a(int i) {
        this.f2413p = i;
    }

    public int m4834b() {
        return this.f2412o;
    }

    public void m4829a(View view, int i) {
        if (view.getParent() != this.f2418u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2418u + ")");
        }
        this.f2416s = view;
        this.f2400c = i;
        this.f2415r.mo244b(view, i);
        m4841c(1);
    }

    public View m4840c() {
        return this.f2416s;
    }

    public int m4843d() {
        return this.f2399b;
    }

    public void m4846e() {
        this.f2400c = -1;
        m4822f();
        if (this.f2409l != null) {
            this.f2409l.recycle();
            this.f2409l = null;
        }
    }

    public boolean m4832a(View view, int i, int i2) {
        this.f2416s = view;
        this.f2400c = -1;
        boolean a = m4813a(i, i2, 0, 0);
        if (!(a || this.f2398a != 0 || this.f2416s == null)) {
            this.f2416s = null;
        }
        return a;
    }

    public boolean m4830a(int i, int i2) {
        if (this.f2417t) {
            return m4813a(i, i2, (int) am.m3669a(this.f2409l, this.f2400c), (int) am.m3670b(this.f2409l, this.f2400c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m4813a(int i, int i2, int i3, int i4) {
        int left = this.f2416s.getLeft();
        int top = this.f2416s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f2414q.m4775h();
            m4841c(0);
            return false;
        }
        this.f2414q.m4764a(left, top, i5, i6, m4807a(this.f2416s, i5, i6, i3, i4));
        m4841c(2);
        return true;
    }

    private int m4807a(View view, int i, int i2, int i3, int i4) {
        int b = m4816b(i3, (int) this.f2411n, (int) this.f2410m);
        int b2 = m4816b(i4, (int) this.f2411n, (int) this.f2410m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m4806a(i2, b2, this.f2415r.mo273a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m4806a(i, b, this.f2415r.mo242b(view)))));
    }

    private int m4806a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f2418u.getWidth();
        int i4 = width / 2;
        float b = (m4815b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m4816b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m4805a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m4815b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m4833a(boolean z) {
        if (this.f2398a == 2) {
            int i;
            boolean g = this.f2414q.m4774g();
            int b = this.f2414q.m4769b();
            int c = this.f2414q.m4770c();
            int left = b - this.f2416s.getLeft();
            int top = c - this.f2416s.getTop();
            if (left != 0) {
                ao.m3936f(this.f2416s, left);
            }
            if (top != 0) {
                ao.m3933e(this.f2416s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f2415r.mo240a(this.f2416s, b, c, left, top);
            }
            if (g && b == this.f2414q.m4771d() && c == this.f2414q.m4772e()) {
                this.f2414q.m4775h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f2418u.post(this.f2419w);
                } else {
                    m4841c(0);
                }
            }
        }
        return this.f2398a == 2;
    }

    private void m4810a(float f, float f2) {
        this.f2417t = true;
        this.f2415r.mo239a(this.f2416s, f, f2);
        this.f2417t = false;
        if (this.f2398a == 1) {
            m4841c(0);
        }
    }

    private void m4822f() {
        if (this.f2401d != null) {
            Arrays.fill(this.f2401d, 0.0f);
            Arrays.fill(this.f2402e, 0.0f);
            Arrays.fill(this.f2403f, 0.0f);
            Arrays.fill(this.f2404g, 0.0f);
            Arrays.fill(this.f2405h, 0);
            Arrays.fill(this.f2406i, 0);
            Arrays.fill(this.f2407j, 0);
            this.f2408k = 0;
        }
    }

    private void m4821e(int i) {
        if (this.f2401d != null) {
            this.f2401d[i] = 0.0f;
            this.f2402e[i] = 0.0f;
            this.f2403f[i] = 0.0f;
            this.f2404g[i] = 0.0f;
            this.f2405h[i] = 0;
            this.f2406i[i] = 0;
            this.f2407j[i] = 0;
            this.f2408k &= (1 << i) ^ -1;
        }
    }

    private void m4823f(int i) {
        if (this.f2401d == null || this.f2401d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f2401d != null) {
                System.arraycopy(this.f2401d, 0, obj, 0, this.f2401d.length);
                System.arraycopy(this.f2402e, 0, obj2, 0, this.f2402e.length);
                System.arraycopy(this.f2403f, 0, obj3, 0, this.f2403f.length);
                System.arraycopy(this.f2404g, 0, obj4, 0, this.f2404g.length);
                System.arraycopy(this.f2405h, 0, obj5, 0, this.f2405h.length);
                System.arraycopy(this.f2406i, 0, obj6, 0, this.f2406i.length);
                System.arraycopy(this.f2407j, 0, obj7, 0, this.f2407j.length);
            }
            this.f2401d = obj;
            this.f2402e = obj2;
            this.f2403f = obj3;
            this.f2404g = obj4;
            this.f2405h = obj5;
            this.f2406i = obj6;
            this.f2407j = obj7;
        }
    }

    private void m4811a(float f, float f2, int i) {
        m4823f(i);
        float[] fArr = this.f2401d;
        this.f2403f[i] = f;
        fArr[i] = f;
        fArr = this.f2402e;
        this.f2404g[i] = f2;
        fArr[i] = f2;
        this.f2405h[i] = m4820e((int) f, (int) f2);
        this.f2408k |= 1 << i;
    }

    private void m4819c(MotionEvent motionEvent) {
        int c = C0684z.m4402c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0684z.m4400b(motionEvent, i);
            float c2 = C0684z.m4401c(motionEvent, i);
            float d = C0684z.m4403d(motionEvent, i);
            this.f2403f[b] = c2;
            this.f2404g[b] = d;
        }
    }

    public boolean m4836b(int i) {
        return (this.f2408k & (1 << i)) != 0;
    }

    void m4841c(int i) {
        this.f2418u.removeCallbacks(this.f2419w);
        if (this.f2398a != i) {
            this.f2398a = i;
            this.f2415r.mo238a(i);
            if (this.f2398a == 0) {
                this.f2416s = null;
            }
        }
    }

    boolean m4838b(View view, int i) {
        if (view == this.f2416s && this.f2400c == i) {
            return true;
        }
        if (view == null || !this.f2415r.mo241a(view, i)) {
            return false;
        }
        this.f2400c = i;
        m4829a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m4831a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.C0684z.m4397a(r14);
        r1 = android.support.v4.view.C0684z.m4399b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m4846e();
    L_0x000d:
        r2 = r13.f2409l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f2409l = r2;
    L_0x0017:
        r2 = r13.f2409l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f2398a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.C0684z.m4400b(r14, r2);
        r13.m4811a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m4844d(r0, r1);
        r1 = r13.f2416s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f2398a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m4838b(r0, r2);
    L_0x0048:
        r0 = r13.f2405h;
        r0 = r0[r2];
        r1 = r13.f2413p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f2415r;
        r3 = r13.f2413p;
        r0 = r0 & r3;
        r1.mo673a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.C0684z.m4400b(r14, r1);
        r2 = android.support.v4.view.C0684z.m4401c(r14, r1);
        r1 = android.support.v4.view.C0684z.m4403d(r14, r1);
        r13.m4811a(r2, r1, r0);
        r3 = r13.f2398a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f2405h;
        r1 = r1[r0];
        r2 = r13.f2413p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f2415r;
        r3 = r13.f2413p;
        r1 = r1 & r3;
        r2.mo673a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f2398a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m4844d(r2, r1);
        r2 = r13.f2416s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m4838b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f2401d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f2402e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.view.C0684z.m4402c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = android.support.v4.view.C0684z.m4400b(r14, r1);
        r0 = r13.m4825g(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = android.support.v4.view.C0684z.m4401c(r14, r1);
        r4 = android.support.v4.view.C0684z.m4403d(r14, r1);
        r5 = r13.f2401d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f2402e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m4844d(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m4814a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f2415r;
        r10 = (int) r5;
        r8 = r9.mo243b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f2415r;
        r12 = (int) r6;
        r10 = r11.mo237a(r4, r10, r12);
        r11 = r13.f2415r;
        r11 = r11.mo242b(r4);
        r12 = r13.f2415r;
        r12 = r12.mo273a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m4819c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m4817b(r5, r6, r3);
        r5 = r13.f2398a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m4838b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = android.support.v4.view.C0684z.m4400b(r14, r1);
        r13.m4821e(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m4846e();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.bd.a(android.view.MotionEvent):boolean");
    }

    public void m4835b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0684z.m4397a(motionEvent);
        int b = C0684z.m4399b(motionEvent);
        if (a == 0) {
            m4846e();
        }
        if (this.f2409l == null) {
            this.f2409l = VelocityTracker.obtain();
        }
        this.f2409l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = C0684z.m4400b(motionEvent, 0);
                d = m4844d((int) x, (int) y);
                m4811a(x, y, i);
                m4838b(d, i);
                i2 = this.f2405h[i];
                if ((this.f2413p & i2) != 0) {
                    this.f2415r.mo673a(i2 & this.f2413p, i);
                    return;
                }
                return;
            case 1:
                if (this.f2398a == 1) {
                    m4824g();
                }
                m4846e();
                return;
            case 2:
                if (this.f2398a != 1) {
                    i2 = C0684z.m4402c(motionEvent);
                    while (i < i2) {
                        a = C0684z.m4400b(motionEvent, i);
                        if (m4825g(a)) {
                            float c = C0684z.m4401c(motionEvent, i);
                            float d2 = C0684z.m4403d(motionEvent, i);
                            float f = c - this.f2401d[a];
                            float f2 = d2 - this.f2402e[a];
                            m4817b(f, f2, a);
                            if (this.f2398a != 1) {
                                d = m4844d((int) c, (int) d2);
                                if (m4814a(d, f, f2) && m4838b(d, a)) {
                                }
                            }
                            m4819c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m4819c(motionEvent);
                    return;
                } else if (m4825g(this.f2400c)) {
                    i = C0684z.m4398a(motionEvent, this.f2400c);
                    x = C0684z.m4401c(motionEvent, i);
                    i2 = (int) (x - this.f2403f[this.f2400c]);
                    i = (int) (C0684z.m4403d(motionEvent, i) - this.f2404g[this.f2400c]);
                    m4818b(this.f2416s.getLeft() + i2, this.f2416s.getTop() + i, i2, i);
                    m4819c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f2398a == 1) {
                    m4810a(0.0f, 0.0f);
                }
                m4846e();
                return;
            case 5:
                i = C0684z.m4400b(motionEvent, b);
                x = C0684z.m4401c(motionEvent, b);
                y = C0684z.m4403d(motionEvent, b);
                m4811a(x, y, i);
                if (this.f2398a == 0) {
                    m4838b(m4844d((int) x, (int) y), i);
                    i2 = this.f2405h[i];
                    if ((this.f2413p & i2) != 0) {
                        this.f2415r.mo673a(i2 & this.f2413p, i);
                        return;
                    }
                    return;
                } else if (m4842c((int) x, (int) y)) {
                    m4838b(this.f2416s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = C0684z.m4400b(motionEvent, b);
                if (this.f2398a == 1 && a == this.f2400c) {
                    b = C0684z.m4402c(motionEvent);
                    while (i < b) {
                        int b2 = C0684z.m4400b(motionEvent, i);
                        if (b2 != this.f2400c) {
                            if (m4844d((int) C0684z.m4401c(motionEvent, i), (int) C0684z.m4403d(motionEvent, i)) == this.f2416s && m4838b(this.f2416s, b2)) {
                                i = this.f2400c;
                                if (i == -1) {
                                    m4824g();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m4824g();
                    }
                }
                m4821e(a);
                return;
            default:
                return;
        }
    }

    private void m4817b(float f, float f2, int i) {
        int i2 = 1;
        if (!m4812a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m4812a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m4812a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m4812a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f2406i;
            iArr[i] = iArr[i] | i2;
            this.f2415r.mo674b(i2, i);
        }
    }

    private boolean m4812a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f2405h[i] & i2) != i2 || (this.f2413p & i2) == 0 || (this.f2407j[i] & i2) == i2 || (this.f2406i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f2399b) && abs2 <= ((float) this.f2399b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f2415r.mo675b(i2)) {
            int[] iArr = this.f2407j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f2406i[i] & i2) != 0 || abs <= ((float) this.f2399b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m4814a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f2415r.mo242b(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f2415r.mo273a(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f2399b * this.f2399b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f2399b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f2399b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m4845d(int i) {
        int length = this.f2401d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m4837b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m4837b(int i, int i2) {
        if (!m4836b(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f2403f[i2] - this.f2401d[i2];
        float f2 = this.f2404g[i2] - this.f2402e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f2399b * this.f2399b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f2399b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f2399b)) {
                return false;
            }
            return true;
        }
    }

    private void m4824g() {
        this.f2409l.computeCurrentVelocity(1000, this.f2410m);
        m4810a(m4805a(am.m3669a(this.f2409l, this.f2400c), this.f2411n, this.f2410m), m4805a(am.m3670b(this.f2409l, this.f2400c), this.f2411n, this.f2410m));
    }

    private void m4818b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.f2416s.getLeft();
        int top = this.f2416s.getTop();
        if (i3 != 0) {
            b = this.f2415r.mo243b(this.f2416s, i, i3);
            ao.m3936f(this.f2416s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.f2415r.mo237a(this.f2416s, i2, i4);
            ao.m3933e(this.f2416s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f2415r.mo240a(this.f2416s, b, a, b - left, a - top);
        }
    }

    public boolean m4842c(int i, int i2) {
        return m4839b(this.f2416s, i, i2);
    }

    public boolean m4839b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m4844d(int i, int i2) {
        for (int childCount = this.f2418u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f2418u.getChildAt(this.f2415r.m1989c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m4820e(int i, int i2) {
        int i3 = 0;
        if (i < this.f2418u.getLeft() + this.f2412o) {
            i3 = 1;
        }
        if (i2 < this.f2418u.getTop() + this.f2412o) {
            i3 |= 4;
        }
        if (i > this.f2418u.getRight() - this.f2412o) {
            i3 |= 2;
        }
        if (i2 > this.f2418u.getBottom() - this.f2412o) {
            return i3 | 8;
        }
        return i3;
    }

    private boolean m4825g(int i) {
        if (m4836b(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
