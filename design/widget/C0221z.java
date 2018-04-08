package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.C0684z;
import android.support.v4.view.ao;
import android.support.v4.widget.am;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class C0221z<V extends View> extends bp<V> {
    private Runnable f1022a;
    private am f1023b;
    private boolean f1024c;
    private int f1025d = -1;
    private int f1026e;
    private int f1027f = -1;
    private VelocityTracker f1028g;

    private class C0301a implements Runnable {
        final /* synthetic */ C0221z f1467a;
        private final CoordinatorLayout f1468b;
        private final V f1469c;

        C0301a(C0221z c0221z, CoordinatorLayout coordinatorLayout, V v) {
            this.f1467a = c0221z;
            this.f1468b = coordinatorLayout;
            this.f1469c = v;
        }

        public void run() {
            if (this.f1469c != null && this.f1467a.f1023b != null) {
                if (this.f1467a.f1023b.m4774g()) {
                    this.f1467a.a_(this.f1468b, this.f1469c, this.f1467a.f1023b.m4770c());
                    ao.m3913a(this.f1469c, (Runnable) this);
                    return;
                }
                this.f1467a.mo179a(this.f1468b, this.f1469c);
            }
        }
    }

    public C0221z(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo174a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f1027f < 0) {
            this.f1027f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f1024c) {
            return true;
        }
        int y;
        switch (C0684z.m4397a(motionEvent)) {
            case 0:
                this.f1024c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (mo190c(v) && coordinatorLayout.m1681a((View) v, x, y)) {
                    this.f1026e = y;
                    this.f1025d = C0684z.m4400b(motionEvent, 0);
                    m1512c();
                    break;
                }
            case 1:
            case 3:
                this.f1024c = false;
                this.f1025d = -1;
                if (this.f1028g != null) {
                    this.f1028g.recycle();
                    this.f1028g = null;
                    break;
                }
                break;
            case 2:
                y = this.f1025d;
                if (y != -1) {
                    y = C0684z.m4398a(motionEvent, y);
                    if (y != -1) {
                        y = (int) C0684z.m4403d(motionEvent, y);
                        if (Math.abs(y - this.f1026e) > this.f1027f) {
                            this.f1024c = true;
                            this.f1026e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f1028g != null) {
            this.f1028g.addMovement(motionEvent);
        }
        return this.f1024c;
    }

    public boolean mo175b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f1027f < 0) {
            this.f1027f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (C0684z.m4397a(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m1681a((View) v, (int) motionEvent.getX(), y) && mo190c(v)) {
                    this.f1026e = y;
                    this.f1025d = C0684z.m4400b(motionEvent, 0);
                    m1512c();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.f1028g != null) {
                    this.f1028g.addMovement(motionEvent);
                    this.f1028g.computeCurrentVelocity(1000);
                    m1517a(coordinatorLayout, (View) v, -mo178a((View) v), 0, android.support.v4.view.am.m3670b(this.f1028g, this.f1025d));
                    break;
                }
                break;
            case 2:
                int a = C0684z.m4398a(motionEvent, this.f1025d);
                if (a != -1) {
                    a = (int) C0684z.m4403d(motionEvent, a);
                    int i = this.f1026e - a;
                    if (!this.f1024c && Math.abs(i) > this.f1027f) {
                        this.f1024c = true;
                        i = i > 0 ? i - this.f1027f : i + this.f1027f;
                    }
                    if (this.f1024c) {
                        this.f1026e = a;
                        m1519b(coordinatorLayout, v, i, mo188b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.f1024c = false;
        this.f1025d = -1;
        if (this.f1028g != null) {
            this.f1028g.recycle();
            this.f1028g = null;
        }
        if (this.f1028g != null) {
            this.f1028g.addMovement(motionEvent);
        }
        return true;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo177a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int mo177a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = mo187b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = ab.m1910a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        mo184a(a);
        return b - a;
    }

    int mo176a() {
        return mo187b();
    }

    final int m1519b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo177a(coordinatorLayout, (View) v, mo176a() - i, i2, i3);
    }

    final boolean m1517a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f1022a != null) {
            v.removeCallbacks(this.f1022a);
            this.f1022a = null;
        }
        if (this.f1023b == null) {
            this.f1023b = am.m4761a(v.getContext());
        }
        this.f1023b.m4765a(0, mo187b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f1023b.m4774g()) {
            this.f1022a = new C0301a(this, coordinatorLayout, v);
            ao.m3913a((View) v, this.f1022a);
            return true;
        }
        mo179a(coordinatorLayout, v);
        return false;
    }

    void mo179a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean mo190c(V v) {
        return false;
    }

    int mo188b(V v) {
        return -v.getHeight();
    }

    int mo178a(V v) {
        return v.getHeight();
    }

    private void m1512c() {
        if (this.f1028g == null) {
            this.f1028g = VelocityTracker.obtain();
        }
    }
}
