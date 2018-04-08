package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0199u;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class an {
    final C0958b f3634a;
    final C0957a f3635b = new C0957a();
    final List<View> f3636c = new ArrayList();

    static class C0957a {
        long f3632a = 0;
        C0957a f3633b;

        C0957a() {
        }

        void m6722a(int i) {
            if (i >= 64) {
                m6720b();
                this.f3633b.m6722a(i - 64);
                return;
            }
            this.f3632a |= 1 << i;
        }

        private void m6720b() {
            if (this.f3633b == null) {
                this.f3633b = new C0957a();
            }
        }

        void m6724b(int i) {
            if (i < 64) {
                this.f3632a &= (1 << i) ^ -1;
            } else if (this.f3633b != null) {
                this.f3633b.m6724b(i - 64);
            }
        }

        boolean m6725c(int i) {
            if (i < 64) {
                return (this.f3632a & (1 << i)) != 0;
            } else {
                m6720b();
                return this.f3633b.m6725c(i - 64);
            }
        }

        void m6721a() {
            this.f3632a = 0;
            if (this.f3633b != null) {
                this.f3633b.m6721a();
            }
        }

        void m6723a(int i, boolean z) {
            if (i >= 64) {
                m6720b();
                this.f3633b.m6723a(i - 64, z);
                return;
            }
            boolean z2 = (this.f3632a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f3632a = (((j ^ -1) & this.f3632a) << 1) | (this.f3632a & j);
            if (z) {
                m6722a(i);
            } else {
                m6724b(i);
            }
            if (z2 || this.f3633b != null) {
                m6720b();
                this.f3633b.m6723a(0, z2);
            }
        }

        boolean m6726d(int i) {
            if (i >= 64) {
                m6720b();
                return this.f3633b.m6726d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f3632a & j) != 0;
            this.f3632a &= j ^ -1;
            j--;
            this.f3632a = Long.rotateRight((j ^ -1) & this.f3632a, 1) | (this.f3632a & j);
            if (this.f3633b == null) {
                return z;
            }
            if (this.f3633b.m6725c(0)) {
                m6722a(63);
            }
            this.f3633b.m6726d(0);
            return z;
        }

        int m6727e(int i) {
            if (this.f3633b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f3632a);
                }
                return Long.bitCount(this.f3632a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f3632a & ((1 << i) - 1));
            } else {
                return this.f3633b.m6727e(i - 64) + Long.bitCount(this.f3632a);
            }
        }

        public String toString() {
            if (this.f3633b == null) {
                return Long.toBinaryString(this.f3632a);
            }
            return this.f3633b.toString() + "xx" + Long.toBinaryString(this.f3632a);
        }
    }

    interface C0958b {
        int mo1027a();

        int mo1028a(View view);

        void mo1029a(int i);

        void mo1030a(View view, int i);

        void mo1031a(View view, int i, LayoutParams layoutParams);

        C0199u mo1032b(View view);

        View mo1033b(int i);

        void mo1034b();

        void mo1035c(int i);

        void mo1036c(View view);

        void mo1037d(View view);
    }

    an(C0958b c0958b) {
        this.f3634a = c0958b;
    }

    private void m6740g(View view) {
        this.f3636c.add(view);
        this.f3634a.mo1036c(view);
    }

    private boolean m6741h(View view) {
        if (!this.f3636c.remove(view)) {
            return false;
        }
        this.f3634a.mo1037d(view);
        return true;
    }

    void m6748a(View view, boolean z) {
        m6747a(view, -1, z);
    }

    void m6747a(View view, int i, boolean z) {
        int a;
        if (i < 0) {
            a = this.f3634a.mo1027a();
        } else {
            a = m6739e(i);
        }
        this.f3635b.m6723a(a, z);
        if (z) {
            m6740g(view);
        }
        this.f3634a.mo1030a(view, a);
    }

    private int m6739e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f3634a.mo1027a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f3635b.m6727e(i2));
            if (e == 0) {
                while (this.f3635b.m6725c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    void m6745a(View view) {
        int a = this.f3634a.mo1028a(view);
        if (a >= 0) {
            if (this.f3635b.m6726d(a)) {
                m6741h(view);
            }
            this.f3634a.mo1029a(a);
        }
    }

    void m6744a(int i) {
        int e = m6739e(i);
        View b = this.f3634a.mo1033b(e);
        if (b != null) {
            if (this.f3635b.m6726d(e)) {
                m6741h(b);
            }
            this.f3634a.mo1029a(e);
        }
    }

    View m6751b(int i) {
        return this.f3634a.mo1033b(m6739e(i));
    }

    void m6743a() {
        this.f3635b.m6721a();
        for (int size = this.f3636c.size() - 1; size >= 0; size--) {
            this.f3634a.mo1037d((View) this.f3636c.get(size));
            this.f3636c.remove(size);
        }
        this.f3634a.mo1034b();
    }

    View m6742a(int i, int i2) {
        int size = this.f3636c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f3636c.get(i3);
            C0199u b = this.f3634a.mo1032b(view);
            if (b.m1356d() == i && !b.m1366n() && !b.m1369q() && (i2 == -1 || b.m1360h() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m6746a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a;
        if (i < 0) {
            a = this.f3634a.mo1027a();
        } else {
            a = m6739e(i);
        }
        this.f3635b.m6723a(a, z);
        if (z) {
            m6740g(view);
        }
        this.f3634a.mo1031a(view, a, layoutParams);
    }

    int m6749b() {
        return this.f3634a.mo1027a() - this.f3636c.size();
    }

    int m6752c() {
        return this.f3634a.mo1027a();
    }

    View m6753c(int i) {
        return this.f3634a.mo1033b(i);
    }

    void m6755d(int i) {
        int e = m6739e(i);
        this.f3635b.m6726d(e);
        this.f3634a.mo1035c(e);
    }

    int m6750b(View view) {
        int a = this.f3634a.mo1028a(view);
        if (a == -1 || this.f3635b.m6725c(a)) {
            return -1;
        }
        return a - this.f3635b.m6727e(a);
    }

    boolean m6754c(View view) {
        return this.f3636c.contains(view);
    }

    void m6756d(View view) {
        int a = this.f3634a.mo1028a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f3635b.m6722a(a);
        m6740g(view);
    }

    void m6757e(View view) {
        int a = this.f3634a.mo1028a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f3635b.m6725c(a)) {
            this.f3635b.m6724b(a);
            m6741h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f3635b.toString() + ", hidden list:" + this.f3636c.size();
    }

    boolean m6758f(View view) {
        int a = this.f3634a.mo1028a(view);
        if (a == -1) {
            return m6741h(view) ? true : true;
        } else {
            if (!this.f3635b.m6725c(a)) {
                return false;
            }
            this.f3635b.m6726d(a);
            if (m6741h(view)) {
                this.f3634a.mo1029a(a);
            } else {
                this.f3634a.mo1029a(a);
            }
            return true;
        }
    }
}
