package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0547e.C0546m;
import android.support.v7.widget.LinearLayoutManager.C0918a;
import android.support.v7.widget.LinearLayoutManager.C0919b;
import android.support.v7.widget.LinearLayoutManager.C0920c;
import android.support.v7.widget.RecyclerView.C0915i;
import android.support.v7.widget.RecyclerView.C0917h;
import android.support.v7.widget.RecyclerView.C0935n;
import android.support.v7.widget.RecyclerView.C0940r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f3278a = false;
    int f3279b = -1;
    int[] f3280c;
    View[] f3281d;
    final SparseIntArray f3282e = new SparseIntArray();
    final SparseIntArray f3283f = new SparseIntArray();
    C0913c f3284g = new C0914a();
    final Rect f3285h = new Rect();

    public static abstract class C0913c {
        final SparseIntArray f3246a = new SparseIntArray();
        private boolean f3247b = false;

        public abstract int mo929a(int i);

        public void m5984a() {
            this.f3246a.clear();
        }

        int m5986b(int i, int i2) {
            if (!this.f3247b) {
                return mo930a(i, i2);
            }
            int i3 = this.f3246a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = mo930a(i, i2);
            this.f3246a.put(i, i3);
            return i3;
        }

        public int mo930a(int i, int i2) {
            int a = mo929a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.f3247b && this.f3246a.size() > 0) {
                b = m5985b(i);
                if (b >= 0) {
                    a2 = this.f3246a.get(b) + mo929a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = mo929a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    if (a2 + a > i2) {
                        return a2;
                    }
                    return 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = mo929a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
                return 0;
            }
            return a2;
        }

        int m5985b(int i) {
            int i2 = 0;
            int size = this.f3246a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f3246a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            if (size < 0 || size >= this.f3246a.size()) {
                return -1;
            }
            return this.f3246a.keyAt(size);
        }

        public int m5987c(int i, int i2) {
            int a = mo929a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = mo929a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            if (i5 + a > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    public static final class C0914a extends C0913c {
        public int mo929a(int i) {
            return 1;
        }

        public int mo930a(int i, int i2) {
            return i % i2;
        }
    }

    public static class C0916b extends C0915i {
        private int f3252e = -1;
        private int f3253f = 0;

        public C0916b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0916b(int i, int i2) {
            super(i, i2);
        }

        public C0916b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0916b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int m5997a() {
            return this.f3252e;
        }

        public int m5998b() {
            return this.f3253f;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m6224a(C0917h.m6001a(context, attributeSet, i, i2).f3323b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        m6224a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        m6224a(i);
    }

    public void mo966a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo966a(false);
    }

    public int mo954a(C0935n c0935n, C0940r c0940r) {
        if (this.i == 0) {
            return this.f3279b;
        }
        if (c0940r.m6395e() < 1) {
            return 0;
        }
        return m6207a(c0935n, c0940r, c0940r.m6395e() - 1) + 1;
    }

    public int mo968b(C0935n c0935n, C0940r c0940r) {
        if (this.i == 1) {
            return this.f3279b;
        }
        if (c0940r.m6395e() < 1) {
            return 0;
        }
        return m6207a(c0935n, c0940r, c0940r.m6395e() - 1) + 1;
    }

    public void mo961a(C0935n c0935n, C0940r c0940r, View view, C0547e c0547e) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0916b) {
            C0916b c0916b = (C0916b) layoutParams;
            int a = m6207a(c0935n, c0940r, c0916b.m5992e());
            if (this.i == 0) {
                int a2 = c0916b.m5997a();
                int b = c0916b.m5998b();
                boolean z = this.f3279b > 1 && c0916b.m5998b() == this.f3279b;
                c0547e.m3450c(C0546m.m3425a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = c0916b.m5997a();
            int b2 = c0916b.m5998b();
            boolean z2 = this.f3279b > 1 && c0916b.m5998b() == this.f3279b;
            c0547e.m3450c(C0546m.m3425a(a, 1, a3, b2, z2, false));
            return;
        }
        super.m6049a(view, c0547e);
    }

    public void mo944c(C0935n c0935n, C0940r c0940r) {
        if (c0940r.m6391a()) {
            m6204K();
        }
        super.mo944c(c0935n, c0940r);
        m6203J();
    }

    public void mo935a(C0940r c0940r) {
        super.mo935a(c0940r);
        this.f3278a = false;
    }

    private void m6203J() {
        this.f3282e.clear();
        this.f3283f.clear();
    }

    private void m6204K() {
        int t = m6128t();
        for (int i = 0; i < t; i++) {
            C0916b c0916b = (C0916b) m6110h(i).getLayoutParams();
            int e = c0916b.m5992e();
            this.f3282e.put(e, c0916b.m5998b());
            this.f3283f.put(e, c0916b.m5997a());
        }
    }

    public void mo963a(RecyclerView recyclerView, int i, int i2) {
        this.f3284g.m5984a();
    }

    public void mo962a(RecyclerView recyclerView) {
        this.f3284g.m5984a();
    }

    public void mo969b(RecyclerView recyclerView, int i, int i2) {
        this.f3284g.m5984a();
    }

    public void mo965a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f3284g.m5984a();
    }

    public void mo964a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f3284g.m5984a();
    }

    public C0915i mo932a() {
        if (this.i == 0) {
            return new C0916b(-2, -1);
        }
        return new C0916b(-1, -2);
    }

    public C0915i mo955a(Context context, AttributeSet attributeSet) {
        return new C0916b(context, attributeSet);
    }

    public C0915i mo956a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0916b((MarginLayoutParams) layoutParams);
        }
        return new C0916b(layoutParams);
    }

    public boolean mo967a(C0915i c0915i) {
        return c0915i instanceof C0916b;
    }

    private void m6205L() {
        int w;
        if (m6192f() == 1) {
            w = (m6131w() - m6011A()) - m6133y();
        } else {
            w = (m6132x() - m6012B()) - m6134z();
        }
        m6216l(w);
    }

    public void mo958a(Rect rect, int i, int i2) {
        if (this.f3280c == null) {
            super.mo958a(rect, i, i2);
        }
        int A = m6011A() + m6133y();
        int z = m6134z() + m6012B();
        if (this.i == 1) {
            z = C0917h.m5999a(i2, z + rect.height(), m6016F());
            A = C0917h.m5999a(i, A + this.f3280c[this.f3280c.length - 1], m6015E());
        } else {
            A = C0917h.m5999a(i, A + rect.width(), m6015E());
            z = C0917h.m5999a(i2, z + this.f3280c[this.f3280c.length - 1], m6016F());
        }
        m6093d(A, z);
    }

    private void m6216l(int i) {
        this.f3280c = m6211a(this.f3280c, this.f3279b, i);
    }

    static int[] m6211a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    void mo959a(C0935n c0935n, C0940r c0940r, C0918a c0918a, int i) {
        super.mo959a(c0935n, c0940r, c0918a, i);
        m6205L();
        if (c0940r.m6395e() > 0 && !c0940r.m6391a()) {
            m6214b(c0935n, c0940r, c0918a, i);
        }
        m6206M();
    }

    private void m6206M() {
        if (this.f3281d == null || this.f3281d.length != this.f3279b) {
            this.f3281d = new View[this.f3279b];
        }
    }

    public int mo931a(int i, C0935n c0935n, C0940r c0940r) {
        m6205L();
        m6206M();
        return super.mo931a(i, c0935n, c0940r);
    }

    public int mo939b(int i, C0935n c0935n, C0940r c0940r) {
        m6205L();
        m6206M();
        return super.mo939b(i, c0935n, c0940r);
    }

    private void m6214b(C0935n c0935n, C0940r c0940r, C0918a c0918a, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m6213b(c0935n, c0940r, c0918a.f3289a);
        if (obj != null) {
            while (b > 0 && c0918a.f3289a > 0) {
                c0918a.f3289a--;
                b = m6213b(c0935n, c0940r, c0918a.f3289a);
            }
            return;
        }
        int e = c0940r.m6395e() - 1;
        int i2 = c0918a.f3289a;
        int i3 = b;
        while (i2 < e) {
            b = m6213b(c0935n, c0940r, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        c0918a.f3289a = i2;
    }

    View mo957a(C0935n c0935n, C0940r c0940r, int i, int i2, int i3) {
        View view = null;
        m6197h();
        int c = this.j.mo1012c();
        int d = this.j.mo1014d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m6110h(i);
            int d2 = m6090d(h);
            if (d2 >= 0 && d2 < i3) {
                if (m6213b(c0935n, c0940r, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((C0915i) h.getLayoutParams()).m5990c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.mo1009a(h) < d && this.j.mo1011b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private int m6207a(C0935n c0935n, C0940r c0940r, int i) {
        if (!c0940r.m6391a()) {
            return this.f3284g.m5987c(i, this.f3279b);
        }
        int b = c0935n.m6329b(i);
        if (b != -1) {
            return this.f3284g.m5987c(b, this.f3279b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int m6213b(C0935n c0935n, C0940r c0940r, int i) {
        if (!c0940r.m6391a()) {
            return this.f3284g.m5986b(i, this.f3279b);
        }
        int i2 = this.f3283f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0935n.m6329b(i);
        if (i2 != -1) {
            return this.f3284g.m5986b(i2, this.f3279b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int m6215c(C0935n c0935n, C0940r c0940r, int i) {
        if (!c0940r.m6391a()) {
            return this.f3284g.mo929a(i);
        }
        int i2 = this.f3282e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0935n.m6329b(i);
        if (i2 != -1) {
            return this.f3284g.mo929a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    void mo960a(C0935n c0935n, C0940r c0940r, C0920c c0920c, C0919b c0919b) {
        int i = this.j.mo1022i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = m6128t() > 0 ? this.f3280c[this.f3279b] : 0;
        if (obj != null) {
            m6205L();
        }
        boolean z = c0920c.f3302e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f3279b;
        if (!z) {
            i5 = m6213b(c0935n, c0940r, c0920c.f3301d) + m6215c(c0935n, c0940r, c0920c.f3301d);
        }
        while (i3 < this.f3279b && c0920c.m6254a(c0940r) && i5 > 0) {
            int i6 = c0920c.f3301d;
            int c = m6215c(c0935n, c0940r, i6);
            if (c <= this.f3279b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = c0920c.m6251a(c0935n);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f3281d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f3279b + " spans.");
        }
        if (i3 == 0) {
            c0919b.f3295b = true;
            return;
        }
        int a2;
        int a3;
        View view;
        int a4;
        int a5;
        m6209a(c0935n, c0940r, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.f3281d[i7];
            if (c0920c.f3308k == null) {
                if (z) {
                    m6072b(view2);
                } else {
                    m6073b(view2, 0);
                }
            } else if (z) {
                m6043a(view2);
            } else {
                m6044a(view2, 0);
            }
            C0916b c0916b = (C0916b) view2.getLayoutParams();
            a2 = C0917h.m6000a(this.f3280c[c0916b.f3252e + c0916b.f3253f] - this.f3280c[c0916b.f3252e], i, 0, this.i == 0 ? c0916b.height : c0916b.width, false);
            a3 = C0917h.m6000a(this.j.mo1018f(), this.j.mo1021h(), 0, this.i == 1 ? c0916b.height : c0916b.width, true);
            if (this.i == 1) {
                m6210a(view2, a2, a3, c0916b.height == -1, false);
            } else {
                m6210a(view2, a3, a2, c0916b.width == -1, false);
            }
            i6 = this.j.mo1017e(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float f2 = (1.0f * ((float) this.j.mo1019f(view2))) / ((float) c0916b.f3253f);
            if (f2 <= f) {
                f2 = f;
            }
            i7++;
            f = f2;
            c = i6;
        }
        if (obj != null) {
            m6208a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.f3281d[i8];
                c0916b = (C0916b) view.getLayoutParams();
                a4 = C0917h.m6000a(this.f3280c[c0916b.f3252e + c0916b.f3253f] - this.f3280c[c0916b.f3252e], 1073741824, 0, this.i == 0 ? c0916b.height : c0916b.width, false);
                a5 = C0917h.m6000a(this.j.mo1018f(), this.j.mo1021h(), 0, this.i == 1 ? c0916b.height : c0916b.width, true);
                if (this.i == 1) {
                    m6210a(view, a4, a5, false, true);
                } else {
                    m6210a(view, a5, a4, false, true);
                }
                i5 = this.j.mo1017e(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        a5 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f3281d[i6];
            if (this.j.mo1017e(view) != c) {
                c0916b = (C0916b) view.getLayoutParams();
                a4 = C0917h.m6000a(this.f3280c[c0916b.f3252e + c0916b.f3253f] - this.f3280c[c0916b.f3252e], 1073741824, 0, this.i == 0 ? c0916b.height : c0916b.width, false);
                if (this.i == 1) {
                    m6210a(view, a4, a5, true, true);
                } else {
                    m6210a(view, a5, a4, true, true);
                }
            }
        }
        c0919b.f3294a = c;
        i6 = 0;
        i5 = 0;
        if (this.i == 1) {
            if (c0920c.f3303f == -1) {
                i5 = c0920c.f3299b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = c0920c.f3299b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (c0920c.f3303f == -1) {
            i4 = c0920c.f3299b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = c0920c.f3299b;
            c += i4;
        }
        a3 = i5;
        a5 = i6;
        a2 = c;
        a4 = i4;
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f3281d[i6];
            c0916b = (C0916b) view.getLayoutParams();
            if (this.i != 1) {
                a5 = m6134z() + this.f3280c[c0916b.f3252e];
                a3 = a5 + this.j.mo1019f(view);
            } else if (m6195g()) {
                a2 = m6133y() + this.f3280c[c0916b.f3252e + c0916b.f3253f];
                a4 = a2 - this.j.mo1019f(view);
            } else {
                a4 = m6133y() + this.f3280c[c0916b.f3252e];
                a2 = a4 + this.j.mo1019f(view);
            }
            m6046a(view, a4, a5, a2, a3);
            if (c0916b.m5990c() || c0916b.m5991d()) {
                c0919b.f3296c = true;
            }
            c0919b.f3297d |= view.isFocusable();
        }
        Arrays.fill(this.f3281d, null);
    }

    private void m6208a(float f, int i) {
        m6216l(Math.max(Math.round(((float) this.f3279b) * f), i));
    }

    private void m6210a(View view, int i, int i2, boolean z, boolean z2) {
        boolean a;
        m6074b(view, this.f3285h);
        C0915i c0915i = (C0915i) view.getLayoutParams();
        if (z || this.i == 1) {
            i = m6212b(i, c0915i.leftMargin + this.f3285h.left, c0915i.rightMargin + this.f3285h.right);
        }
        if (z || this.i == 0) {
            i2 = m6212b(i2, c0915i.topMargin + this.f3285h.top, c0915i.bottomMargin + this.f3285h.bottom);
        }
        if (z2) {
            a = m6062a(view, i, i2, c0915i);
        } else {
            a = m6076b(view, i, i2, c0915i);
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    private int m6212b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void m6209a(C0935n c0935n, C0940r c0940r, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && m6195g()) {
            i5 = this.f3279b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f3281d[i5];
            C0916b c0916b = (C0916b) view.getLayoutParams();
            c0916b.f3253f = m6215c(c0935n, c0940r, m6090d(view));
            if (i6 != -1 || c0916b.f3253f <= 1) {
                c0916b.f3252e = i7;
            } else {
                c0916b.f3252e = i7 - (c0916b.f3253f - 1);
            }
            i7 += c0916b.f3253f * i6;
        }
    }

    public void m6224a(int i) {
        if (i != this.f3279b) {
            this.f3278a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f3279b = i;
            this.f3284g.m5984a();
            m6121n();
        }
    }

    public View mo933a(View view, int i, C0935n c0935n, C0940r c0940r) {
        View e = m6097e(view);
        if (e == null) {
            return null;
        }
        C0916b c0916b = (C0916b) e.getLayoutParams();
        int a = c0916b.f3252e;
        int a2 = c0916b.f3252e + c0916b.f3253f;
        if (super.mo933a(view, i, c0935n, c0940r) == null) {
            return null;
        }
        int t;
        int i2;
        int i3;
        if (((m6189e(i) == 1) != this.k ? 1 : null) != null) {
            t = m6128t() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            t = 0;
            i2 = 1;
            i3 = m6128t();
        }
        Object obj = (this.i == 1 && m6195g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = t;
        while (i6 != i3) {
            View h = m6110h(i6);
            if (h == e) {
                break;
            }
            View view3;
            if (h.isFocusable()) {
                c0916b = (C0916b) h.getLayoutParams();
                int a3 = c0916b.f3252e;
                int a4 = c0916b.f3252e + c0916b.f3253f;
                if (a3 == a && a4 == a2) {
                    return h;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = c0916b.f3252e;
                    t = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = h;
                } else {
                    t = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                t = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = t;
        }
        return view2;
    }

    public boolean mo940b() {
        return this.n == null && !this.f3278a;
    }
}
