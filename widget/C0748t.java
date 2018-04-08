package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.p024g.C0512k;
import android.support.v4.view.C0249b;
import android.support.v4.view.ao;
import android.support.v4.view.bl;
import android.support.v4.view.p025a.C0527a;
import android.support.v4.view.p025a.C0532c;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0558l;
import android.support.v4.view.p025a.C0572s;
import android.support.v4.widget.C0753w.C0749a;
import android.support.v4.widget.C0753w.C0751b;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;

public abstract class C0748t extends C0249b {
    private static final Rect f2440a = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final C0749a<C0547e> f2441m = new C0750u();
    private static final C0751b<C0512k<C0547e>, C0547e> f2442n = new C0752v();
    private final Rect f2443c = new Rect();
    private final Rect f2444d = new Rect();
    private final Rect f2445e = new Rect();
    private final int[] f2446f = new int[2];
    private final AccessibilityManager f2447g;
    private final View f2448h;
    private C0747a f2449i;
    private int f2450j = Integer.MIN_VALUE;
    private int f2451k = Integer.MIN_VALUE;
    private int f2452l = Integer.MIN_VALUE;

    private class C0747a extends C0558l {
        final /* synthetic */ C0748t f2439a;

        private C0747a(C0748t c0748t) {
            this.f2439a = c0748t;
        }

        public C0547e mo714a(int i) {
            return C0547e.m3427a(this.f2439a.m4933d(i));
        }

        public boolean mo715a(int i, int i2, Bundle bundle) {
            return this.f2439a.m4929b(i, i2, bundle);
        }
    }

    protected abstract void mo1264a(int i, C0547e c0547e);

    protected abstract void mo1266a(List<Integer> list);

    protected abstract boolean mo1267a(int i, int i2, Bundle bundle);

    public C0748t(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f2448h = view;
        this.f2447g = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ao.m3931e(view) == 0) {
            ao.m3925c(view, 1);
        }
    }

    public C0558l mo716a(View view) {
        if (this.f2449i == null) {
            this.f2449i = new C0747a();
        }
        return this.f2449i;
    }

    public final int m4951b() {
        return this.f2450j;
    }

    public final boolean m4949a(int i, int i2) {
        if (i == Integer.MIN_VALUE || !this.f2447g.isEnabled()) {
            return false;
        }
        ViewParent parent = this.f2448h.getParent();
        if (parent == null) {
            return false;
        }
        return bl.m4131a(parent, this.f2448h, m4931c(i, i2));
    }

    public final void m4954c() {
        m4952b(-1, 1);
    }

    public final void m4952b(int i, int i2) {
        if (i != Integer.MIN_VALUE && this.f2447g.isEnabled()) {
            ViewParent parent = this.f2448h.getParent();
            if (parent != null) {
                AccessibilityEvent c = m4931c(i, 2048);
                C0527a.m3247a(c, i2);
                bl.m4131a(parent, this.f2448h, c);
            }
        }
    }

    @Deprecated
    public int m4955d() {
        return m4951b();
    }

    protected void m4942a(int i, boolean z) {
    }

    private AccessibilityEvent m4931c(int i, int i2) {
        switch (i) {
            case -1:
                return mo1268c(i2);
            default:
                return m4934d(i, i2);
        }
    }

    private AccessibilityEvent mo1268c(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        ao.m3912a(this.f2448h, obtain);
        return obtain;
    }

    public void mo220a(View view, AccessibilityEvent accessibilityEvent) {
        super.mo220a(view, accessibilityEvent);
        m4946a(accessibilityEvent);
    }

    private AccessibilityEvent m4934d(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        C0572s a = C0527a.m3246a(obtain);
        C0547e d = m4933d(i);
        a.m3610a().add(d.m3479s());
        a.m3616b(d.m3480t());
        a.m3621d(d.m3476p());
        a.m3619c(d.m3475o());
        a.m3617b(d.m3474n());
        a.m3614a(d.m3462f());
        mo1265a(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        a.m3613a(d.m3478r());
        a.m3612a(this.f2448h, i);
        obtain.setPackageName(this.f2448h.getContext().getPackageName());
        return obtain;
    }

    private C0547e m4933d(int i) {
        if (i == -1) {
            return mo1269e();
        }
        return m4936e(i);
    }

    private C0547e mo1269e() {
        C0547e a = C0547e.m3428a(this.f2448h);
        ao.m3909a(this.f2448h, a);
        List arrayList = new ArrayList();
        mo1266a(arrayList);
        if (a.m3446c() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                a.m3442b(this.f2448h, ((Integer) arrayList.get(i)).intValue());
            }
            return a;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public void mo219a(View view, C0547e c0547e) {
        super.mo219a(view, c0547e);
        m4943a(c0547e);
    }

    private C0547e m4936e(int i) {
        C0547e b = C0547e.m3430b();
        b.m3465h(true);
        b.m3438a(true);
        b.m3443b((CharSequence) "android.view.View");
        b.m3440b(f2440a);
        b.m3453d(f2440a);
        mo1264a(i, b);
        if (b.m3479s() == null && b.m3480t() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        b.m3435a(this.f2444d);
        if (this.f2444d.equals(f2440a)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int d = b.m3452d();
        if ((d & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((d & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            boolean z;
            b.m3437a(this.f2448h.getContext().getPackageName());
            b.m3436a(this.f2448h, i);
            b.m3454d(this.f2448h);
            if (this.f2450j == i) {
                b.m3456d(true);
                b.m3434a(128);
            } else {
                b.m3456d(false);
                b.m3434a(64);
            }
            if (this.f2451k == i) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                b.m3434a(2);
            } else if (b.m3464g()) {
                b.m3434a(1);
            }
            b.m3445b(z);
            if (m4927a(this.f2444d)) {
                b.m3451c(true);
                b.m3440b(this.f2444d);
            }
            b.m3447c(this.f2443c);
            if (this.f2443c.equals(f2440a)) {
                this.f2448h.getLocationOnScreen(this.f2446f);
                b.m3435a(this.f2443c);
                this.f2443c.offset(this.f2446f[0] - this.f2448h.getScrollX(), this.f2446f[1] - this.f2448h.getScrollY());
                b.m3453d(this.f2443c);
            }
            return b;
        }
    }

    private boolean m4929b(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return m4926a(i2, bundle);
            default:
                return m4932c(i, i2, bundle);
        }
    }

    private boolean m4926a(int i, Bundle bundle) {
        return ao.m3918a(this.f2448h, i, bundle);
    }

    private boolean m4932c(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 1:
                return m4948a(i);
            case 2:
                return m4953b(i);
            case 64:
                return m4937f(i);
            case 128:
                return m4938g(i);
            default:
                return mo1267a(i, i2, bundle);
        }
    }

    private boolean m4927a(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.f2448h.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f2448h.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (ao.m3934f(view) <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        if (this.f2448h.getLocalVisibleRect(this.f2445e)) {
            return rect.intersect(this.f2445e);
        }
        return false;
    }

    private boolean m4937f(int i) {
        if (!this.f2447g.isEnabled() || !C0532c.m3254a(this.f2447g) || this.f2450j == i) {
            return false;
        }
        if (this.f2450j != Integer.MIN_VALUE) {
            m4938g(this.f2450j);
        }
        this.f2450j = i;
        this.f2448h.invalidate();
        m4949a(i, (int) DfuBaseService.ERROR_CONNECTION_STATE_MASK);
        return true;
    }

    private boolean m4938g(int i) {
        if (this.f2450j != i) {
            return false;
        }
        this.f2450j = Integer.MIN_VALUE;
        this.f2448h.invalidate();
        m4949a(i, 65536);
        return true;
    }

    public final boolean m4948a(int i) {
        if ((!this.f2448h.isFocused() && !this.f2448h.requestFocus()) || this.f2451k == i) {
            return false;
        }
        if (this.f2451k != Integer.MIN_VALUE) {
            m4953b(this.f2451k);
        }
        this.f2451k = i;
        m4942a(i, true);
        m4949a(i, 8);
        return true;
    }

    public final boolean m4953b(int i) {
        if (this.f2451k != i) {
            return false;
        }
        this.f2451k = Integer.MIN_VALUE;
        m4942a(i, false);
        m4949a(i, 8);
        return true;
    }

    protected void mo1265a(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void m4946a(AccessibilityEvent accessibilityEvent) {
    }

    protected void m4943a(C0547e c0547e) {
    }
}
