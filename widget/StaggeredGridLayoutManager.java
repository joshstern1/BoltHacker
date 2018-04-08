package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p025a.C0527a;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0547e.C0546m;
import android.support.v4.view.p025a.C0572s;
import android.support.v7.widget.RecyclerView.C0915i;
import android.support.v7.widget.RecyclerView.C0917h;
import android.support.v7.widget.RecyclerView.C0917h.C0930a;
import android.support.v7.widget.RecyclerView.C0935n;
import android.support.v7.widget.RecyclerView.C0940r;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C0917h {
    private final Runnable f3470A = new cu(this);
    bp f3471a;
    bp f3472b;
    boolean f3473c = false;
    int f3474d = -1;
    int f3475e = Integer.MIN_VALUE;
    LazySpanLookup f3476f = new LazySpanLookup();
    private int f3477g = -1;
    private C0951c[] f3478h;
    private int f3479i;
    private int f3480j;
    private final be f3481k;
    private boolean f3482l = false;
    private BitSet f3483m;
    private int f3484n = 2;
    private boolean f3485o;
    private boolean f3486t;
    private SavedState f3487u;
    private int f3488v;
    private final Rect f3489w = new Rect();
    private final C0949a f3490x = new C0949a(this);
    private boolean f3491y = false;
    private boolean f3492z = true;

    static class LazySpanLookup {
        int[] f3444a;
        List<FullSpanItem> f3445b;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new cv();
            int f3440a;
            int f3441b;
            int[] f3442c;
            boolean f3443d;

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.f3440a = parcel.readInt();
                this.f3441b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f3443d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f3442c = new int[readInt];
                    parcel.readIntArray(this.f3442c);
                }
            }

            int m6482a(int i) {
                return this.f3442c == null ? 0 : this.f3442c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3440a);
                parcel.writeInt(this.f3441b);
                parcel.writeInt(this.f3443d ? 1 : 0);
                if (this.f3442c == null || this.f3442c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f3442c.length);
                parcel.writeIntArray(this.f3442c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3440a + ", mGapDir=" + this.f3441b + ", mHasUnwantedGapAfter=" + this.f3443d + ", mGapPerSpan=" + Arrays.toString(this.f3442c) + '}';
            }
        }

        LazySpanLookup() {
        }

        int m6486a(int i) {
            if (this.f3445b != null) {
                for (int size = this.f3445b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f3445b.get(size)).f3440a >= i) {
                        this.f3445b.remove(size);
                    }
                }
            }
            return m6492b(i);
        }

        int m6492b(int i) {
            if (this.f3444a == null || i >= this.f3444a.length) {
                return -1;
            }
            int g = m6485g(i);
            if (g == -1) {
                Arrays.fill(this.f3444a, i, this.f3444a.length, -1);
                return this.f3444a.length;
            }
            Arrays.fill(this.f3444a, i, g + 1, -1);
            return g + 1;
        }

        int m6494c(int i) {
            if (this.f3444a == null || i >= this.f3444a.length) {
                return -1;
            }
            return this.f3444a[i];
        }

        void m6490a(int i, C0951c c0951c) {
            m6496e(i);
            this.f3444a[i] = c0951c.f3467d;
        }

        int m6495d(int i) {
            int length = this.f3444a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m6496e(int i) {
            if (this.f3444a == null) {
                this.f3444a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f3444a, -1);
            } else if (i >= this.f3444a.length) {
                Object obj = this.f3444a;
                this.f3444a = new int[m6495d(i)];
                System.arraycopy(obj, 0, this.f3444a, 0, obj.length);
                Arrays.fill(this.f3444a, obj.length, this.f3444a.length, -1);
            }
        }

        void m6488a() {
            if (this.f3444a != null) {
                Arrays.fill(this.f3444a, -1);
            }
            this.f3445b = null;
        }

        void m6489a(int i, int i2) {
            if (this.f3444a != null && i < this.f3444a.length) {
                m6496e(i + i2);
                System.arraycopy(this.f3444a, i + i2, this.f3444a, i, (this.f3444a.length - i) - i2);
                Arrays.fill(this.f3444a, this.f3444a.length - i2, this.f3444a.length, -1);
                m6483c(i, i2);
            }
        }

        private void m6483c(int i, int i2) {
            if (this.f3445b != null) {
                int i3 = i + i2;
                for (int size = this.f3445b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f3445b.get(size);
                    if (fullSpanItem.f3440a >= i) {
                        if (fullSpanItem.f3440a < i3) {
                            this.f3445b.remove(size);
                        } else {
                            fullSpanItem.f3440a -= i2;
                        }
                    }
                }
            }
        }

        void m6493b(int i, int i2) {
            if (this.f3444a != null && i < this.f3444a.length) {
                m6496e(i + i2);
                System.arraycopy(this.f3444a, i, this.f3444a, i + i2, (this.f3444a.length - i) - i2);
                Arrays.fill(this.f3444a, i, i + i2, -1);
                m6484d(i, i2);
            }
        }

        private void m6484d(int i, int i2) {
            if (this.f3445b != null) {
                for (int size = this.f3445b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f3445b.get(size);
                    if (fullSpanItem.f3440a >= i) {
                        fullSpanItem.f3440a += i2;
                    }
                }
            }
        }

        private int m6485g(int i) {
            if (this.f3445b == null) {
                return -1;
            }
            FullSpanItem f = m6497f(i);
            if (f != null) {
                this.f3445b.remove(f);
            }
            int size = this.f3445b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.f3445b.get(i2)).f3440a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.f3445b.get(i2);
            this.f3445b.remove(i2);
            return f.f3440a;
        }

        public void m6491a(FullSpanItem fullSpanItem) {
            if (this.f3445b == null) {
                this.f3445b = new ArrayList();
            }
            int size = this.f3445b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f3445b.get(i);
                if (fullSpanItem2.f3440a == fullSpanItem.f3440a) {
                    this.f3445b.remove(i);
                }
                if (fullSpanItem2.f3440a >= fullSpanItem.f3440a) {
                    this.f3445b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f3445b.add(fullSpanItem);
        }

        public FullSpanItem m6497f(int i) {
            if (this.f3445b == null) {
                return null;
            }
            for (int size = this.f3445b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f3445b.get(size);
                if (fullSpanItem.f3440a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem m6487a(int i, int i2, int i3, boolean z) {
            if (this.f3445b == null) {
                return null;
            }
            int size = this.f3445b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f3445b.get(i4);
                if (fullSpanItem.f3440a >= i2) {
                    return null;
                }
                if (fullSpanItem.f3440a >= i) {
                    if (i3 == 0 || fullSpanItem.f3441b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f3443d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new cw();
        int f3446a;
        int f3447b;
        int f3448c;
        int[] f3449d;
        int f3450e;
        int[] f3451f;
        List<FullSpanItem> f3452g;
        boolean f3453h;
        boolean f3454i;
        boolean f3455j;

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f3446a = parcel.readInt();
            this.f3447b = parcel.readInt();
            this.f3448c = parcel.readInt();
            if (this.f3448c > 0) {
                this.f3449d = new int[this.f3448c];
                parcel.readIntArray(this.f3449d);
            }
            this.f3450e = parcel.readInt();
            if (this.f3450e > 0) {
                this.f3451f = new int[this.f3450e];
                parcel.readIntArray(this.f3451f);
            }
            this.f3453h = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f3454i = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f3455j = z2;
            this.f3452g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3448c = savedState.f3448c;
            this.f3446a = savedState.f3446a;
            this.f3447b = savedState.f3447b;
            this.f3449d = savedState.f3449d;
            this.f3450e = savedState.f3450e;
            this.f3451f = savedState.f3451f;
            this.f3453h = savedState.f3453h;
            this.f3454i = savedState.f3454i;
            this.f3455j = savedState.f3455j;
            this.f3452g = savedState.f3452g;
        }

        void m6498a() {
            this.f3449d = null;
            this.f3448c = 0;
            this.f3450e = 0;
            this.f3451f = null;
            this.f3452g = null;
        }

        void m6499b() {
            this.f3449d = null;
            this.f3448c = 0;
            this.f3446a = -1;
            this.f3447b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.f3446a);
            parcel.writeInt(this.f3447b);
            parcel.writeInt(this.f3448c);
            if (this.f3448c > 0) {
                parcel.writeIntArray(this.f3449d);
            }
            parcel.writeInt(this.f3450e);
            if (this.f3450e > 0) {
                parcel.writeIntArray(this.f3451f);
            }
            if (this.f3453h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f3454i) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.f3455j) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.f3452g);
        }
    }

    class C0949a {
        int f3456a;
        int f3457b;
        boolean f3458c;
        boolean f3459d;
        boolean f3460e;
        final /* synthetic */ StaggeredGridLayoutManager f3461f;

        public C0949a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f3461f = staggeredGridLayoutManager;
            m6500a();
        }

        void m6500a() {
            this.f3456a = -1;
            this.f3457b = Integer.MIN_VALUE;
            this.f3458c = false;
            this.f3459d = false;
            this.f3460e = false;
        }

        void m6502b() {
            int d;
            if (this.f3458c) {
                d = this.f3461f.f3471a.mo1014d();
            } else {
                d = this.f3461f.f3471a.mo1012c();
            }
            this.f3457b = d;
        }

        void m6501a(int i) {
            if (this.f3458c) {
                this.f3457b = this.f3461f.f3471a.mo1014d() - i;
            } else {
                this.f3457b = this.f3461f.f3471a.mo1012c() + i;
            }
        }
    }

    public static class C0950b extends C0915i {
        C0951c f3462e;
        boolean f3463f;

        public C0950b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0950b(int i, int i2) {
            super(i, i2);
        }

        public C0950b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0950b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean m6503a() {
            return this.f3463f;
        }

        public final int m6504b() {
            if (this.f3462e == null) {
                return -1;
            }
            return this.f3462e.f3467d;
        }
    }

    class C0951c {
        int f3464a;
        int f3465b;
        int f3466c;
        final int f3467d;
        final /* synthetic */ StaggeredGridLayoutManager f3468e;
        private ArrayList<View> f3469f;

        private C0951c(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f3468e = staggeredGridLayoutManager;
            this.f3469f = new ArrayList();
            this.f3464a = Integer.MIN_VALUE;
            this.f3465b = Integer.MIN_VALUE;
            this.f3466c = 0;
            this.f3467d = i;
        }

        int m6506a(int i) {
            if (this.f3464a != Integer.MIN_VALUE) {
                return this.f3464a;
            }
            if (this.f3469f.size() == 0) {
                return i;
            }
            m6508a();
            return this.f3464a;
        }

        void m6508a() {
            View view = (View) this.f3469f.get(0);
            C0950b c = m6514c(view);
            this.f3464a = this.f3468e.f3471a.mo1009a(view);
            if (c.f3463f) {
                FullSpanItem f = this.f3468e.f3476f.m6497f(c.m5992e());
                if (f != null && f.f3441b == -1) {
                    this.f3464a -= f.m6482a(this.f3467d);
                }
            }
        }

        int m6511b() {
            if (this.f3464a != Integer.MIN_VALUE) {
                return this.f3464a;
            }
            m6508a();
            return this.f3464a;
        }

        int m6512b(int i) {
            if (this.f3465b != Integer.MIN_VALUE) {
                return this.f3465b;
            }
            if (this.f3469f.size() == 0) {
                return i;
            }
            m6515c();
            return this.f3465b;
        }

        void m6515c() {
            View view = (View) this.f3469f.get(this.f3469f.size() - 1);
            C0950b c = m6514c(view);
            this.f3465b = this.f3468e.f3471a.mo1011b(view);
            if (c.f3463f) {
                FullSpanItem f = this.f3468e.f3476f.m6497f(c.m5992e());
                if (f != null && f.f3441b == 1) {
                    this.f3465b = f.m6482a(this.f3467d) + this.f3465b;
                }
            }
        }

        int m6517d() {
            if (this.f3465b != Integer.MIN_VALUE) {
                return this.f3465b;
            }
            m6515c();
            return this.f3465b;
        }

        void m6509a(View view) {
            C0950b c = m6514c(view);
            c.f3462e = this;
            this.f3469f.add(0, view);
            this.f3464a = Integer.MIN_VALUE;
            if (this.f3469f.size() == 1) {
                this.f3465b = Integer.MIN_VALUE;
            }
            if (c.m5990c() || c.m5991d()) {
                this.f3466c += this.f3468e.f3471a.mo1017e(view);
            }
        }

        void m6513b(View view) {
            C0950b c = m6514c(view);
            c.f3462e = this;
            this.f3469f.add(view);
            this.f3465b = Integer.MIN_VALUE;
            if (this.f3469f.size() == 1) {
                this.f3464a = Integer.MIN_VALUE;
            }
            if (c.m5990c() || c.m5991d()) {
                this.f3466c += this.f3468e.f3471a.mo1017e(view);
            }
        }

        void m6510a(boolean z, int i) {
            int b;
            if (z) {
                b = m6512b(Integer.MIN_VALUE);
            } else {
                b = m6506a(Integer.MIN_VALUE);
            }
            m6519e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < this.f3468e.f3471a.mo1014d()) {
                    return;
                }
                if (z || b <= this.f3468e.f3471a.mo1012c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f3465b = b;
                    this.f3464a = b;
                }
            }
        }

        void m6519e() {
            this.f3469f.clear();
            m6520f();
            this.f3466c = 0;
        }

        void m6520f() {
            this.f3464a = Integer.MIN_VALUE;
            this.f3465b = Integer.MIN_VALUE;
        }

        void m6516c(int i) {
            this.f3464a = i;
            this.f3465b = i;
        }

        void m6521g() {
            int size = this.f3469f.size();
            View view = (View) this.f3469f.remove(size - 1);
            C0950b c = m6514c(view);
            c.f3462e = null;
            if (c.m5990c() || c.m5991d()) {
                this.f3466c -= this.f3468e.f3471a.mo1017e(view);
            }
            if (size == 1) {
                this.f3464a = Integer.MIN_VALUE;
            }
            this.f3465b = Integer.MIN_VALUE;
        }

        void m6522h() {
            View view = (View) this.f3469f.remove(0);
            C0950b c = m6514c(view);
            c.f3462e = null;
            if (this.f3469f.size() == 0) {
                this.f3465b = Integer.MIN_VALUE;
            }
            if (c.m5990c() || c.m5991d()) {
                this.f3466c -= this.f3468e.f3471a.mo1017e(view);
            }
            this.f3464a = Integer.MIN_VALUE;
        }

        public int m6523i() {
            return this.f3466c;
        }

        C0950b m6514c(View view) {
            return (C0950b) view.getLayoutParams();
        }

        void m6518d(int i) {
            if (this.f3464a != Integer.MIN_VALUE) {
                this.f3464a += i;
            }
            if (this.f3465b != Integer.MIN_VALUE) {
                this.f3465b += i;
            }
        }

        public View m6507a(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.f3469f.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.f3469f.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    boolean z;
                    if (this.f3468e.m6090d(view2) > i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.f3468e.f3482l) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            size = this.f3469f.size() - 1;
            while (size >= 0) {
                view2 = (View) this.f3469f.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                Object obj;
                if (this.f3468e.m6090d(view2) > i) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != (!this.f3468e.f3482l ? 1 : null)) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        C0930a a = C0917h.m6001a(context, attributeSet, i, i2);
        m6593b(a.f3322a);
        m6575a(a.f3323b);
        m6588a(a.f3324c);
        if (this.f3484n == 0) {
            z = false;
        }
        m6087c(z);
        this.f3481k = new be();
        m6555m();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f3479i = i2;
        m6575a(i);
        if (this.f3484n == 0) {
            z = false;
        }
        m6087c(z);
        this.f3481k = new be();
        m6555m();
    }

    private void m6555m() {
        this.f3471a = bp.m6904a(this, this.f3479i);
        this.f3472b = bp.m6904a(this, 1 - this.f3479i);
    }

    private boolean m6524J() {
        if (m6128t() == 0 || this.f3484n == 0 || !m6123o()) {
            return false;
        }
        int M;
        int N;
        if (this.f3473c) {
            M = m6527M();
            N = m6528N();
        } else {
            M = m6528N();
            N = m6527M();
        }
        if (M == 0 && m6608f() != null) {
            this.f3476f.m6488a();
            m6018H();
            m6121n();
            return true;
        } else if (!this.f3491y) {
            return false;
        } else {
            int i = this.f3473c ? -1 : 1;
            FullSpanItem a = this.f3476f.m6487a(M, N + 1, i, true);
            if (a == null) {
                this.f3491y = false;
                this.f3476f.m6486a(N + 1);
                return false;
            }
            FullSpanItem a2 = this.f3476f.m6487a(M, a.f3440a, i * -1, true);
            if (a2 == null) {
                this.f3476f.m6486a(a.f3440a);
            } else {
                this.f3476f.m6486a(a2.f3440a + 1);
            }
            m6018H();
            m6121n();
            return true;
        }
    }

    public void mo976k(int i) {
        if (i == 0) {
            m6524J();
        }
    }

    public void mo936a(RecyclerView recyclerView, C0935n c0935n) {
        m6064a(this.f3470A);
        for (int i = 0; i < this.f3477g; i++) {
            this.f3478h[i].m6519e();
        }
        recyclerView.requestLayout();
    }

    View m6608f() {
        int i;
        int i2;
        int t = m6128t() - 1;
        BitSet bitSet = new BitSet(this.f3477g);
        bitSet.set(0, this.f3477g, true);
        boolean z = (this.f3479i == 1 && m6612h()) ? true : true;
        if (this.f3473c) {
            i = -1;
        } else {
            i = t + 1;
            t = 0;
        }
        if (t < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = t;
        while (i3 != i) {
            View h = m6110h(i3);
            C0950b c0950b = (C0950b) h.getLayoutParams();
            if (bitSet.get(c0950b.f3462e.f3467d)) {
                if (m6540a(c0950b.f3462e)) {
                    return h;
                }
                bitSet.clear(c0950b.f3462e.f3467d);
            }
            if (!(c0950b.f3463f || i3 + i2 == i)) {
                boolean z2;
                View h2 = m6110h(i3 + i2);
                int b;
                if (this.f3473c) {
                    t = this.f3471a.mo1011b(h);
                    b = this.f3471a.mo1011b(h2);
                    if (t < b) {
                        return h;
                    }
                    if (t == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    t = this.f3471a.mo1009a(h);
                    b = this.f3471a.mo1009a(h2);
                    if (t > b) {
                        return h;
                    }
                    if (t == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if (c0950b.f3462e.f3467d - ((C0950b) h2.getLayoutParams()).f3462e.f3467d < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private boolean m6540a(C0951c c0951c) {
        boolean z = true;
        if (this.f3473c) {
            if (c0951c.m6517d() < this.f3471a.mo1014d()) {
                return !c0951c.m6514c((View) c0951c.f3469f.get(c0951c.f3469f.size() + -1)).f3463f;
            }
        } else if (c0951c.m6511b() > this.f3471a.mo1012c()) {
            if (c0951c.m6514c((View) c0951c.f3469f.get(0)).f3463f) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void m6575a(int i) {
        mo938a(null);
        if (i != this.f3477g) {
            m6610g();
            this.f3477g = i;
            this.f3483m = new BitSet(this.f3477g);
            this.f3478h = new C0951c[this.f3477g];
            for (int i2 = 0; i2 < this.f3477g; i2++) {
                this.f3478h[i2] = new C0951c(i2);
            }
            m6121n();
        }
    }

    public void m6593b(int i) {
        if (i == 0 || i == 1) {
            mo938a(null);
            if (i != this.f3479i) {
                this.f3479i = i;
                bp bpVar = this.f3471a;
                this.f3471a = this.f3472b;
                this.f3472b = bpVar;
                m6121n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void m6588a(boolean z) {
        mo938a(null);
        if (!(this.f3487u == null || this.f3487u.f3453h == z)) {
            this.f3487u.f3453h = z;
        }
        this.f3482l = z;
        m6121n();
    }

    public void mo938a(String str) {
        if (this.f3487u == null) {
            super.mo938a(str);
        }
    }

    public void m6610g() {
        this.f3476f.m6488a();
        m6121n();
    }

    private void m6525K() {
        boolean z = true;
        if (this.f3479i == 1 || !m6612h()) {
            this.f3473c = this.f3482l;
            return;
        }
        if (this.f3482l) {
            z = false;
        }
        this.f3473c = z;
    }

    boolean m6612h() {
        return m6126r() == 1;
    }

    public void mo958a(Rect rect, int i, int i2) {
        int A = m6011A() + m6133y();
        int z = m6134z() + m6012B();
        if (this.f3479i == 1) {
            z = C0917h.m5999a(i2, z + rect.height(), m6016F());
            A = C0917h.m5999a(i, A + (this.f3480j * this.f3477g), m6015E());
        } else {
            A = C0917h.m5999a(i, A + rect.width(), m6015E());
            z = C0917h.m5999a(i2, z + (this.f3480j * this.f3477g), m6016F());
        }
        m6093d(A, z);
    }

    public void mo944c(C0935n c0935n, C0940r c0940r) {
        m6533a(c0935n, c0940r, true);
    }

    private void m6533a(C0935n c0935n, C0940r c0940r, boolean z) {
        C0949a c0949a = this.f3490x;
        if (!(this.f3487u == null && this.f3474d == -1) && c0940r.m6395e() == 0) {
            m6081c(c0935n);
            c0949a.m6500a();
            return;
        }
        boolean z2;
        if (!(c0949a.f3460e && this.f3474d == -1 && this.f3487u == null)) {
            c0949a.m6500a();
            if (this.f3487u != null) {
                m6535a(c0949a);
            } else {
                m6525K();
                c0949a.f3458c = this.f3473c;
            }
            m6580a(c0940r, c0949a);
            c0949a.f3460e = true;
        }
        if (this.f3487u == null && this.f3474d == -1 && !(c0949a.f3458c == this.f3485o && m6612h() == this.f3486t)) {
            this.f3476f.m6488a();
            c0949a.f3459d = true;
        }
        if (m6128t() > 0 && (this.f3487u == null || this.f3487u.f3448c < 1)) {
            int i;
            if (c0949a.f3459d) {
                for (i = 0; i < this.f3477g; i++) {
                    this.f3478h[i].m6519e();
                    if (c0949a.f3457b != Integer.MIN_VALUE) {
                        this.f3478h[i].m6516c(c0949a.f3457b);
                    }
                }
            } else {
                for (i = 0; i < this.f3477g; i++) {
                    this.f3478h[i].m6510a(this.f3473c, c0949a.f3457b);
                }
            }
        }
        m6032a(c0935n);
        this.f3481k.f3703a = false;
        this.f3491y = false;
        m6605e(this.f3472b.mo1018f());
        m6531a(c0949a.f3456a, c0940r);
        if (c0949a.f3458c) {
            m6553l(-1);
            m6529a(c0935n, this.f3481k, c0940r);
            m6553l(1);
            this.f3481k.f3705c = c0949a.f3456a + this.f3481k.f3706d;
            m6529a(c0935n, this.f3481k, c0940r);
        } else {
            m6553l(1);
            m6529a(c0935n, this.f3481k, c0940r);
            m6553l(-1);
            this.f3481k.f3705c = c0949a.f3456a + this.f3481k.f3706d;
            m6529a(c0935n, this.f3481k, c0940r);
        }
        m6526L();
        if (m6128t() > 0) {
            if (this.f3473c) {
                m6545b(c0935n, c0940r, true);
                m6548c(c0935n, c0940r, false);
            } else {
                m6548c(c0935n, c0940r, true);
                m6545b(c0935n, c0940r, false);
            }
        }
        if (z && !c0940r.m6391a()) {
            if (this.f3484n == 0 || m6128t() <= 0 || (!this.f3491y && m6608f() == null)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                m6064a(this.f3470A);
                if (m6524J()) {
                    z2 = true;
                    if (c0940r.m6391a()) {
                        this.f3490x.m6500a();
                    }
                    this.f3485o = c0949a.f3458c;
                    this.f3486t = m6612h();
                    if (z2) {
                        this.f3490x.m6500a();
                        m6533a(c0935n, c0940r, false);
                    }
                }
            }
        }
        z2 = false;
        if (c0940r.m6391a()) {
            this.f3490x.m6500a();
        }
        this.f3485o = c0949a.f3458c;
        this.f3486t = m6612h();
        if (z2) {
            this.f3490x.m6500a();
            m6533a(c0935n, c0940r, false);
        }
    }

    public void mo935a(C0940r c0940r) {
        super.mo935a(c0940r);
        this.f3474d = -1;
        this.f3475e = Integer.MIN_VALUE;
        this.f3487u = null;
        this.f3490x.m6500a();
    }

    private void m6526L() {
        if (this.f3472b.mo1021h() != 1073741824) {
            float f = 0.0f;
            int t = m6128t();
            int i = 0;
            while (i < t) {
                float f2;
                View h = m6110h(i);
                float e = (float) this.f3472b.mo1017e(h);
                if (e < f) {
                    f2 = f;
                } else {
                    if (((C0950b) h.getLayoutParams()).m6503a()) {
                        f2 = (1.0f * e) / ((float) this.f3477g);
                    } else {
                        f2 = e;
                    }
                    f2 = Math.max(f, f2);
                }
                i++;
                f = f2;
            }
            i = this.f3480j;
            int round = Math.round(((float) this.f3477g) * f);
            if (this.f3472b.mo1021h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f3472b.mo1018f());
            }
            m6605e(round);
            if (this.f3480j != i) {
                for (int i2 = 0; i2 < t; i2++) {
                    View h2 = m6110h(i2);
                    C0950b c0950b = (C0950b) h2.getLayoutParams();
                    if (!c0950b.f3463f) {
                        if (m6612h() && this.f3479i == 1) {
                            h2.offsetLeftAndRight(((-((this.f3477g - 1) - c0950b.f3462e.f3467d)) * this.f3480j) - ((-((this.f3477g - 1) - c0950b.f3462e.f3467d)) * i));
                        } else {
                            int i3 = c0950b.f3462e.f3467d * this.f3480j;
                            round = c0950b.f3462e.f3467d * i;
                            if (this.f3479i == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m6535a(C0949a c0949a) {
        if (this.f3487u.f3448c > 0) {
            if (this.f3487u.f3448c == this.f3477g) {
                for (int i = 0; i < this.f3477g; i++) {
                    this.f3478h[i].m6519e();
                    int i2 = this.f3487u.f3449d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f3487u.f3454i) {
                            i2 += this.f3471a.mo1014d();
                        } else {
                            i2 += this.f3471a.mo1012c();
                        }
                    }
                    this.f3478h[i].m6516c(i2);
                }
            } else {
                this.f3487u.m6498a();
                this.f3487u.f3446a = this.f3487u.f3447b;
            }
        }
        this.f3486t = this.f3487u.f3455j;
        m6588a(this.f3487u.f3453h);
        m6525K();
        if (this.f3487u.f3446a != -1) {
            this.f3474d = this.f3487u.f3446a;
            c0949a.f3458c = this.f3487u.f3454i;
        } else {
            c0949a.f3458c = this.f3473c;
        }
        if (this.f3487u.f3450e > 1) {
            this.f3476f.f3444a = this.f3487u.f3451f;
            this.f3476f.f3445b = this.f3487u.f3452g;
        }
    }

    void m6580a(C0940r c0940r, C0949a c0949a) {
        if (!m6596b(c0940r, c0949a) && !m6549c(c0940r, c0949a)) {
            c0949a.m6502b();
            c0949a.f3456a = 0;
        }
    }

    private boolean m6549c(C0940r c0940r, C0949a c0949a) {
        int v;
        if (this.f3485o) {
            v = m6566v(c0940r.m6395e());
        } else {
            v = m6565u(c0940r.m6395e());
        }
        c0949a.f3456a = v;
        c0949a.f3457b = Integer.MIN_VALUE;
        return true;
    }

    boolean m6596b(C0940r c0940r, C0949a c0949a) {
        boolean z = false;
        if (c0940r.m6391a() || this.f3474d == -1) {
            return false;
        }
        if (this.f3474d < 0 || this.f3474d >= c0940r.m6395e()) {
            this.f3474d = -1;
            this.f3475e = Integer.MIN_VALUE;
            return false;
        } else if (this.f3487u == null || this.f3487u.f3446a == -1 || this.f3487u.f3448c < 1) {
            View c = mo943c(this.f3474d);
            if (c != null) {
                int M;
                if (this.f3473c) {
                    M = m6527M();
                } else {
                    M = m6528N();
                }
                c0949a.f3456a = M;
                if (this.f3475e != Integer.MIN_VALUE) {
                    if (c0949a.f3458c) {
                        c0949a.f3457b = (this.f3471a.mo1014d() - this.f3475e) - this.f3471a.mo1011b(c);
                        return true;
                    }
                    c0949a.f3457b = (this.f3471a.mo1012c() + this.f3475e) - this.f3471a.mo1009a(c);
                    return true;
                } else if (this.f3471a.mo1017e(c) > this.f3471a.mo1018f()) {
                    if (c0949a.f3458c) {
                        M = this.f3471a.mo1014d();
                    } else {
                        M = this.f3471a.mo1012c();
                    }
                    c0949a.f3457b = M;
                    return true;
                } else {
                    M = this.f3471a.mo1009a(c) - this.f3471a.mo1012c();
                    if (M < 0) {
                        c0949a.f3457b = -M;
                        return true;
                    }
                    M = this.f3471a.mo1014d() - this.f3471a.mo1011b(c);
                    if (M < 0) {
                        c0949a.f3457b = M;
                        return true;
                    }
                    c0949a.f3457b = Integer.MIN_VALUE;
                    return true;
                }
            }
            c0949a.f3456a = this.f3474d;
            if (this.f3475e == Integer.MIN_VALUE) {
                if (m6564t(c0949a.f3456a) == 1) {
                    z = true;
                }
                c0949a.f3458c = z;
                c0949a.m6502b();
            } else {
                c0949a.m6501a(this.f3475e);
            }
            c0949a.f3459d = true;
            return true;
        } else {
            c0949a.f3457b = Integer.MIN_VALUE;
            c0949a.f3456a = this.f3474d;
            return true;
        }
    }

    void m6605e(int i) {
        this.f3480j = i / this.f3477g;
        this.f3488v = MeasureSpec.makeMeasureSpec(i, this.f3472b.mo1021h());
    }

    public boolean mo940b() {
        return this.f3487u == null;
    }

    public int mo941c(C0940r c0940r) {
        return m6543b(c0940r);
    }

    private int m6543b(C0940r c0940r) {
        boolean z = false;
        if (m6128t() == 0) {
            return 0;
        }
        bp bpVar = this.f3471a;
        View a = m6574a(!this.f3492z, true);
        if (!this.f3492z) {
            z = true;
        }
        return cd.m7006a(c0940r, bpVar, a, m6592b(z, true), this, this.f3492z, this.f3473c);
    }

    public int mo945d(C0940r c0940r) {
        return m6543b(c0940r);
    }

    public int mo948e(C0940r c0940r) {
        return m6551i(c0940r);
    }

    private int m6551i(C0940r c0940r) {
        boolean z = false;
        if (m6128t() == 0) {
            return 0;
        }
        bp bpVar = this.f3471a;
        View a = m6574a(!this.f3492z, true);
        if (!this.f3492z) {
            z = true;
        }
        return cd.m7005a(c0940r, bpVar, a, m6592b(z, true), this, this.f3492z);
    }

    public int mo950f(C0940r c0940r) {
        return m6551i(c0940r);
    }

    public int mo951g(C0940r c0940r) {
        return m6552j(c0940r);
    }

    private int m6552j(C0940r c0940r) {
        boolean z = false;
        if (m6128t() == 0) {
            return 0;
        }
        bp bpVar = this.f3471a;
        View a = m6574a(!this.f3492z, true);
        if (!this.f3492z) {
            z = true;
        }
        return cd.m7007b(c0940r, bpVar, a, m6592b(z, true), this, this.f3492z);
    }

    public int mo952h(C0940r c0940r) {
        return m6552j(c0940r);
    }

    private void m6539a(View view, C0950b c0950b, boolean z) {
        if (c0950b.f3463f) {
            if (this.f3479i == 1) {
                m6537a(view, this.f3488v, C0917h.m6000a(m6132x(), m6130v(), 0, c0950b.height, true), z);
            } else {
                m6537a(view, C0917h.m6000a(m6131w(), m6129u(), 0, c0950b.width, true), this.f3488v, z);
            }
        } else if (this.f3479i == 1) {
            m6537a(view, C0917h.m6000a(this.f3480j, m6129u(), 0, c0950b.width, false), C0917h.m6000a(m6132x(), m6130v(), 0, c0950b.height, true), z);
        } else {
            m6537a(view, C0917h.m6000a(m6131w(), m6129u(), 0, c0950b.width, true), C0917h.m6000a(this.f3480j, m6130v(), 0, c0950b.height, false), z);
        }
    }

    private void m6537a(View view, int i, int i2, boolean z) {
        boolean a;
        m6074b(view, this.f3489w);
        C0950b c0950b = (C0950b) view.getLayoutParams();
        int b = m6542b(i, c0950b.leftMargin + this.f3489w.left, c0950b.rightMargin + this.f3489w.right);
        int b2 = m6542b(i2, c0950b.topMargin + this.f3489w.top, c0950b.bottomMargin + this.f3489w.bottom);
        if (z) {
            a = m6062a(view, b, b2, (C0915i) c0950b);
        } else {
            a = m6076b(view, b, b2, c0950b);
        }
        if (a) {
            view.measure(b, b2);
        }
    }

    private int m6542b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public void mo934a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f3487u = (SavedState) parcelable;
            m6121n();
        }
    }

    public Parcelable mo942c() {
        if (this.f3487u != null) {
            return new SavedState(this.f3487u);
        }
        SavedState savedState = new SavedState();
        savedState.f3453h = this.f3482l;
        savedState.f3454i = this.f3485o;
        savedState.f3455j = this.f3486t;
        if (this.f3476f == null || this.f3476f.f3444a == null) {
            savedState.f3450e = 0;
        } else {
            savedState.f3451f = this.f3476f.f3444a;
            savedState.f3450e = savedState.f3451f.length;
            savedState.f3452g = this.f3476f.f3445b;
        }
        if (m6128t() > 0) {
            int M;
            if (this.f3485o) {
                M = m6527M();
            } else {
                M = m6528N();
            }
            savedState.f3446a = M;
            savedState.f3447b = m6613i();
            savedState.f3448c = this.f3477g;
            savedState.f3449d = new int[this.f3477g];
            for (M = 0; M < this.f3477g; M++) {
                int b;
                if (this.f3485o) {
                    b = this.f3478h[M].m6512b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f3471a.mo1014d();
                    }
                } else {
                    b = this.f3478h[M].m6506a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f3471a.mo1012c();
                    }
                }
                savedState.f3449d[M] = b;
            }
        } else {
            savedState.f3446a = -1;
            savedState.f3447b = -1;
            savedState.f3448c = 0;
        }
        return savedState;
    }

    public void mo961a(C0935n c0935n, C0940r c0940r, View view, C0547e c0547e) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0950b) {
            C0950b c0950b = (C0950b) layoutParams;
            if (this.f3479i == 0) {
                c0547e.m3450c(C0546m.m3425a(c0950b.m6504b(), c0950b.f3463f ? this.f3477g : 1, -1, -1, c0950b.f3463f, false));
                return;
            } else {
                c0547e.m3450c(C0546m.m3425a(-1, -1, c0950b.m6504b(), c0950b.f3463f ? this.f3477g : 1, c0950b.f3463f, false));
                return;
            }
        }
        super.m6049a(view, c0547e);
    }

    public void mo937a(AccessibilityEvent accessibilityEvent) {
        super.mo937a(accessibilityEvent);
        if (m6128t() > 0) {
            C0572s a = C0527a.m3246a(accessibilityEvent);
            View a2 = m6574a(false, true);
            View b = m6592b(false, true);
            if (a2 != null && b != null) {
                int d = m6090d(a2);
                int d2 = m6090d(b);
                if (d < d2) {
                    a.m3615b(d);
                    a.m3618c(d2);
                    return;
                }
                a.m3615b(d2);
                a.m3618c(d);
            }
        }
    }

    int m6613i() {
        View b;
        if (this.f3473c) {
            b = m6592b(true, true);
        } else {
            b = m6574a(true, true);
        }
        return b == null ? -1 : m6090d(b);
    }

    public int mo954a(C0935n c0935n, C0940r c0940r) {
        if (this.f3479i == 0) {
            return this.f3477g;
        }
        return super.mo954a(c0935n, c0940r);
    }

    public int mo968b(C0935n c0935n, C0940r c0940r) {
        if (this.f3479i == 1) {
            return this.f3477g;
        }
        return super.mo968b(c0935n, c0940r);
    }

    View m6574a(boolean z, boolean z2) {
        int c = this.f3471a.mo1012c();
        int d = this.f3471a.mo1014d();
        int t = m6128t();
        View view = null;
        for (int i = 0; i < t; i++) {
            View h = m6110h(i);
            int a = this.f3471a.mo1009a(h);
            if (this.f3471a.mo1011b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    View m6592b(boolean z, boolean z2) {
        int c = this.f3471a.mo1012c();
        int d = this.f3471a.mo1014d();
        View view = null;
        for (int t = m6128t() - 1; t >= 0; t--) {
            View h = m6110h(t);
            int a = this.f3471a.mo1009a(h);
            int b = this.f3471a.mo1011b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    private void m6545b(C0935n c0935n, C0940r c0940r, boolean z) {
        int q = m6560q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.f3471a.mo1014d() - q;
            if (q > 0) {
                q -= -m6597c(-q, c0935n, c0940r);
                if (z && q > 0) {
                    this.f3471a.mo1010a(q);
                }
            }
        }
    }

    private void m6548c(C0935n c0935n, C0940r c0940r, boolean z) {
        int p = m6558p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.f3471a.mo1012c();
            if (p > 0) {
                p -= m6597c(p, c0935n, c0940r);
                if (z && p > 0) {
                    this.f3471a.mo1010a(-p);
                }
            }
        }
    }

    private void m6531a(int i, C0940r c0940r) {
        int c;
        int i2;
        be beVar;
        boolean z = false;
        this.f3481k.f3704b = 0;
        this.f3481k.f3705c = i;
        if (m6125q()) {
            c = c0940r.m6393c();
            if (c != -1) {
                if (this.f3473c == (c < i)) {
                    c = this.f3471a.mo1018f();
                    i2 = 0;
                } else {
                    i2 = this.f3471a.mo1018f();
                    c = 0;
                }
                if (m6124p()) {
                    this.f3481k.f3709g = c + this.f3471a.mo1016e();
                    this.f3481k.f3708f = -i2;
                } else {
                    this.f3481k.f3708f = this.f3471a.mo1012c() - i2;
                    this.f3481k.f3709g = c + this.f3471a.mo1014d();
                }
                this.f3481k.f3710h = false;
                this.f3481k.f3703a = true;
                beVar = this.f3481k;
                if (this.f3471a.mo1021h() == 0 && this.f3471a.mo1016e() == 0) {
                    z = true;
                }
                beVar.f3711i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (m6124p()) {
            this.f3481k.f3709g = c + this.f3471a.mo1016e();
            this.f3481k.f3708f = -i2;
        } else {
            this.f3481k.f3708f = this.f3471a.mo1012c() - i2;
            this.f3481k.f3709g = c + this.f3471a.mo1014d();
        }
        this.f3481k.f3710h = false;
        this.f3481k.f3703a = true;
        beVar = this.f3481k;
        z = true;
        beVar.f3711i = z;
    }

    private void m6553l(int i) {
        int i2 = 1;
        this.f3481k.f3707e = i;
        be beVar = this.f3481k;
        if (this.f3473c != (i == -1)) {
            i2 = -1;
        }
        beVar.f3706d = i2;
    }

    public void mo974i(int i) {
        super.mo974i(i);
        for (int i2 = 0; i2 < this.f3477g; i2++) {
            this.f3478h[i2].m6518d(i);
        }
    }

    public void mo975j(int i) {
        super.mo975j(i);
        for (int i2 = 0; i2 < this.f3477g; i2++) {
            this.f3478h[i2].m6518d(i);
        }
    }

    public void mo969b(RecyclerView recyclerView, int i, int i2) {
        m6547c(i, i2, 2);
    }

    public void mo963a(RecyclerView recyclerView, int i, int i2) {
        m6547c(i, i2, 1);
    }

    public void mo962a(RecyclerView recyclerView) {
        this.f3476f.m6488a();
        m6121n();
    }

    public void mo964a(RecyclerView recyclerView, int i, int i2, int i3) {
        m6547c(i, i2, 8);
    }

    public void mo965a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m6547c(i, i2, 4);
    }

    private void m6547c(int i, int i2, int i3) {
        int i4;
        int i5;
        int M = this.f3473c ? m6527M() : m6528N();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f3476f.m6492b(i5);
        switch (i3) {
            case 1:
                this.f3476f.m6493b(i, i2);
                break;
            case 2:
                this.f3476f.m6489a(i, i2);
                break;
            case 8:
                this.f3476f.m6489a(i, 1);
                this.f3476f.m6493b(i2, 1);
                break;
        }
        if (i4 > M) {
            if (i5 <= (this.f3473c ? m6528N() : m6527M())) {
                m6121n();
            }
        }
    }

    private int m6529a(C0935n c0935n, be beVar, C0940r c0940r) {
        int i;
        int d;
        int q;
        this.f3483m.set(0, this.f3477g, true);
        if (this.f3481k.f3711i) {
            if (beVar.f3707e == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (beVar.f3707e == 1) {
            i = beVar.f3709g + beVar.f3704b;
        } else {
            i = beVar.f3708f - beVar.f3704b;
        }
        m6550e(beVar.f3707e, i);
        if (this.f3473c) {
            d = this.f3471a.mo1014d();
        } else {
            d = this.f3471a.mo1012c();
        }
        Object obj = null;
        while (beVar.m6881a(c0940r) && (this.f3481k.f3711i || !this.f3483m.isEmpty())) {
            C0951c c0951c;
            int e;
            int e2;
            View a = beVar.m6880a(c0935n);
            C0950b c0950b = (C0950b) a.getLayoutParams();
            int e3 = c0950b.m5992e();
            int c = this.f3476f.m6494c(e3);
            Object obj2 = c == -1 ? 1 : null;
            if (obj2 != null) {
                C0951c a2 = c0950b.f3463f ? this.f3478h[0] : m6530a(beVar);
                this.f3476f.m6490a(e3, a2);
                c0951c = a2;
            } else {
                c0951c = this.f3478h[c];
            }
            c0950b.f3462e = c0951c;
            if (beVar.f3707e == 1) {
                m6072b(a);
            } else {
                m6073b(a, 0);
            }
            m6539a(a, c0950b, false);
            if (beVar.f3707e == 1) {
                if (c0950b.f3463f) {
                    q = m6560q(d);
                } else {
                    q = c0951c.m6512b(d);
                }
                e = q + this.f3471a.mo1017e(a);
                if (obj2 == null || !c0950b.f3463f) {
                    c = q;
                } else {
                    FullSpanItem m = m6554m(q);
                    m.f3441b = -1;
                    m.f3440a = e3;
                    this.f3476f.m6491a(m);
                    c = q;
                }
            } else {
                if (c0950b.f3463f) {
                    q = m6558p(d);
                } else {
                    q = c0951c.m6506a(d);
                }
                c = q - this.f3471a.mo1017e(a);
                if (obj2 != null && c0950b.f3463f) {
                    FullSpanItem n = m6556n(q);
                    n.f3441b = 1;
                    n.f3440a = e3;
                    this.f3476f.m6491a(n);
                }
                e = q;
            }
            if (c0950b.f3463f && beVar.f3706d == -1) {
                if (obj2 != null) {
                    this.f3491y = true;
                } else {
                    obj = beVar.f3707e == 1 ? !m6616j() ? 1 : null : !m6618l() ? 1 : null;
                    if (obj != null) {
                        FullSpanItem f = this.f3476f.m6497f(e3);
                        if (f != null) {
                            f.f3443d = true;
                        }
                        this.f3491y = true;
                    }
                }
            }
            m6538a(a, c0950b, beVar);
            if (m6612h() && this.f3479i == 1) {
                if (c0950b.f3463f) {
                    q = this.f3472b.mo1014d();
                } else {
                    q = this.f3472b.mo1014d() - (((this.f3477g - 1) - c0951c.f3467d) * this.f3480j);
                }
                e2 = q - this.f3472b.mo1017e(a);
                e3 = q;
            } else {
                if (c0950b.f3463f) {
                    q = this.f3472b.mo1012c();
                } else {
                    q = (c0951c.f3467d * this.f3480j) + this.f3472b.mo1012c();
                }
                e3 = q + this.f3472b.mo1017e(a);
                e2 = q;
            }
            if (this.f3479i == 1) {
                m6046a(a, e2, c, e3, e);
            } else {
                m6046a(a, c, e2, e, e3);
            }
            if (c0950b.f3463f) {
                m6550e(this.f3481k.f3707e, i);
            } else {
                m6536a(c0951c, this.f3481k.f3707e, i);
            }
            m6534a(c0935n, this.f3481k);
            if (this.f3481k.f3710h && a.isFocusable()) {
                if (c0950b.f3463f) {
                    this.f3483m.clear();
                } else {
                    this.f3483m.set(c0951c.f3467d, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m6534a(c0935n, this.f3481k);
        }
        if (this.f3481k.f3707e == -1) {
            q = this.f3471a.mo1012c() - m6558p(this.f3471a.mo1012c());
        } else {
            q = m6560q(this.f3471a.mo1014d()) - this.f3471a.mo1014d();
        }
        return q > 0 ? Math.min(beVar.f3704b, q) : 0;
    }

    private FullSpanItem m6554m(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f3442c = new int[this.f3477g];
        for (int i2 = 0; i2 < this.f3477g; i2++) {
            fullSpanItem.f3442c[i2] = i - this.f3478h[i2].m6512b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem m6556n(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f3442c = new int[this.f3477g];
        for (int i2 = 0; i2 < this.f3477g; i2++) {
            fullSpanItem.f3442c[i2] = this.f3478h[i2].m6506a(i) - i;
        }
        return fullSpanItem;
    }

    private void m6538a(View view, C0950b c0950b, be beVar) {
        if (beVar.f3707e == 1) {
            if (c0950b.f3463f) {
                m6559p(view);
            } else {
                c0950b.f3462e.m6513b(view);
            }
        } else if (c0950b.f3463f) {
            m6561q(view);
        } else {
            c0950b.f3462e.m6509a(view);
        }
    }

    private void m6534a(C0935n c0935n, be beVar) {
        if (beVar.f3703a && !beVar.f3711i) {
            if (beVar.f3704b == 0) {
                if (beVar.f3707e == -1) {
                    m6544b(c0935n, beVar.f3709g);
                } else {
                    m6532a(c0935n, beVar.f3708f);
                }
            } else if (beVar.f3707e == -1) {
                r0 = beVar.f3708f - m6557o(beVar.f3708f);
                if (r0 < 0) {
                    r0 = beVar.f3709g;
                } else {
                    r0 = beVar.f3709g - Math.min(r0, beVar.f3704b);
                }
                m6544b(c0935n, r0);
            } else {
                r0 = m6562r(beVar.f3709g) - beVar.f3709g;
                if (r0 < 0) {
                    r0 = beVar.f3708f;
                } else {
                    r0 = Math.min(r0, beVar.f3704b) + beVar.f3708f;
                }
                m6532a(c0935n, r0);
            }
        }
    }

    private void m6559p(View view) {
        for (int i = this.f3477g - 1; i >= 0; i--) {
            this.f3478h[i].m6513b(view);
        }
    }

    private void m6561q(View view) {
        for (int i = this.f3477g - 1; i >= 0; i--) {
            this.f3478h[i].m6509a(view);
        }
    }

    private void m6550e(int i, int i2) {
        for (int i3 = 0; i3 < this.f3477g; i3++) {
            if (!this.f3478h[i3].f3469f.isEmpty()) {
                m6536a(this.f3478h[i3], i, i2);
            }
        }
    }

    private void m6536a(C0951c c0951c, int i, int i2) {
        int i3 = c0951c.m6523i();
        if (i == -1) {
            if (i3 + c0951c.m6511b() <= i2) {
                this.f3483m.set(c0951c.f3467d, false);
            }
        } else if (c0951c.m6517d() - i3 >= i2) {
            this.f3483m.set(c0951c.f3467d, false);
        }
    }

    private int m6557o(int i) {
        int a = this.f3478h[0].m6506a(i);
        for (int i2 = 1; i2 < this.f3477g; i2++) {
            int a2 = this.f3478h[i2].m6506a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m6558p(int i) {
        int a = this.f3478h[0].m6506a(i);
        for (int i2 = 1; i2 < this.f3477g; i2++) {
            int a2 = this.f3478h[i2].m6506a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    boolean m6616j() {
        int b = this.f3478h[0].m6512b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3477g; i++) {
            if (this.f3478h[i].m6512b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean m6618l() {
        int a = this.f3478h[0].m6506a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3477g; i++) {
            if (this.f3478h[i].m6506a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    private int m6560q(int i) {
        int b = this.f3478h[0].m6512b(i);
        for (int i2 = 1; i2 < this.f3477g; i2++) {
            int b2 = this.f3478h[i2].m6512b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private int m6562r(int i) {
        int b = this.f3478h[0].m6512b(i);
        for (int i2 = 1; i2 < this.f3477g; i2++) {
            int b2 = this.f3478h[i2].m6512b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private void m6532a(C0935n c0935n, int i) {
        while (m6128t() > 0) {
            View h = m6110h(0);
            if (this.f3471a.mo1011b(h) <= i && this.f3471a.mo1013c(h) <= i) {
                C0950b c0950b = (C0950b) h.getLayoutParams();
                if (c0950b.f3463f) {
                    int i2 = 0;
                    while (i2 < this.f3477g) {
                        if (this.f3478h[i2].f3469f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f3477g; i2++) {
                        this.f3478h[i2].m6522h();
                    }
                } else if (c0950b.f3462e.f3469f.size() != 1) {
                    c0950b.f3462e.m6522h();
                } else {
                    return;
                }
                m6050a(h, c0935n);
            } else {
                return;
            }
        }
    }

    private void m6544b(C0935n c0935n, int i) {
        int t = m6128t() - 1;
        while (t >= 0) {
            View h = m6110h(t);
            if (this.f3471a.mo1009a(h) >= i && this.f3471a.mo1015d(h) >= i) {
                C0950b c0950b = (C0950b) h.getLayoutParams();
                if (c0950b.f3463f) {
                    int i2 = 0;
                    while (i2 < this.f3477g) {
                        if (this.f3478h[i2].f3469f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f3477g; i2++) {
                        this.f3478h[i2].m6521g();
                    }
                } else if (c0950b.f3462e.f3469f.size() != 1) {
                    c0950b.f3462e.m6521g();
                } else {
                    return;
                }
                m6050a(h, c0935n);
                t--;
            } else {
                return;
            }
        }
    }

    private boolean m6563s(int i) {
        if (this.f3479i == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.f3473c) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f3473c) != m6612h()) {
            return false;
        }
        return true;
    }

    private C0951c m6530a(be beVar) {
        int i;
        int i2;
        C0951c c0951c = null;
        int i3 = -1;
        if (m6563s(beVar.f3707e)) {
            i = this.f3477g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f3477g;
            i3 = 1;
        }
        int c;
        int i4;
        C0951c c0951c2;
        int b;
        C0951c c0951c3;
        if (beVar.f3707e == 1) {
            c = this.f3471a.mo1012c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                c0951c2 = this.f3478h[i4];
                b = c0951c2.m6512b(c);
                if (b < i) {
                    c0951c3 = c0951c2;
                } else {
                    b = i;
                    c0951c3 = c0951c;
                }
                i4 += i3;
                c0951c = c0951c3;
                i = b;
            }
        } else {
            c = this.f3471a.mo1014d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                c0951c2 = this.f3478h[i4];
                b = c0951c2.m6506a(c);
                if (b > i) {
                    c0951c3 = c0951c2;
                } else {
                    b = i;
                    c0951c3 = c0951c;
                }
                i4 += i3;
                c0951c = c0951c3;
                i = b;
            }
        }
        return c0951c;
    }

    public boolean mo949e() {
        return this.f3479i == 1;
    }

    public boolean mo947d() {
        return this.f3479i == 0;
    }

    public int mo931a(int i, C0935n c0935n, C0940r c0940r) {
        return m6597c(i, c0935n, c0940r);
    }

    public int mo939b(int i, C0935n c0935n, C0940r c0940r) {
        return m6597c(i, c0935n, c0940r);
    }

    private int m6564t(int i) {
        int i2 = -1;
        if (m6128t() != 0) {
            if ((i < m6528N()) == this.f3473c) {
                i2 = 1;
            }
            return i2;
        } else if (this.f3473c) {
            return 1;
        } else {
            return -1;
        }
    }

    public void mo946d(int i) {
        if (!(this.f3487u == null || this.f3487u.f3446a == i)) {
            this.f3487u.m6499b();
        }
        this.f3474d = i;
        this.f3475e = Integer.MIN_VALUE;
        m6121n();
    }

    int m6597c(int i, C0935n c0935n, C0940r c0940r) {
        int M;
        int i2;
        if (i > 0) {
            M = m6527M();
            i2 = 1;
        } else {
            i2 = -1;
            M = m6528N();
        }
        this.f3481k.f3703a = true;
        m6531a(M, c0940r);
        m6553l(i2);
        this.f3481k.f3705c = this.f3481k.f3706d + M;
        int abs = Math.abs(i);
        this.f3481k.f3704b = abs;
        i2 = m6529a(c0935n, this.f3481k, c0940r);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.f3471a.mo1010a(-i);
        this.f3485o = this.f3473c;
        return i;
    }

    private int m6527M() {
        int t = m6128t();
        return t == 0 ? 0 : m6090d(m6110h(t - 1));
    }

    private int m6528N() {
        if (m6128t() == 0) {
            return 0;
        }
        return m6090d(m6110h(0));
    }

    private int m6565u(int i) {
        int t = m6128t();
        for (int i2 = 0; i2 < t; i2++) {
            int d = m6090d(m6110h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m6566v(int i) {
        for (int t = m6128t() - 1; t >= 0; t--) {
            int d = m6090d(m6110h(t));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    public C0915i mo932a() {
        if (this.f3479i == 0) {
            return new C0950b(-2, -1);
        }
        return new C0950b(-1, -2);
    }

    public C0915i mo955a(Context context, AttributeSet attributeSet) {
        return new C0950b(context, attributeSet);
    }

    public C0915i mo956a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0950b((MarginLayoutParams) layoutParams);
        }
        return new C0950b(layoutParams);
    }

    public boolean mo967a(C0915i c0915i) {
        return c0915i instanceof C0950b;
    }

    public View mo933a(View view, int i, C0935n c0935n, C0940r c0940r) {
        int i2 = 0;
        if (m6128t() == 0) {
            return null;
        }
        View e = m6097e(view);
        if (e == null) {
            return null;
        }
        m6525K();
        int w = m6567w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        int M;
        View a;
        C0950b c0950b = (C0950b) e.getLayoutParams();
        boolean z = c0950b.f3463f;
        C0951c c0951c = c0950b.f3462e;
        if (w == 1) {
            M = m6527M();
        } else {
            M = m6528N();
        }
        m6531a(M, c0940r);
        m6553l(w);
        this.f3481k.f3705c = this.f3481k.f3706d + M;
        this.f3481k.f3704b = (int) (0.33333334f * ((float) this.f3471a.mo1018f()));
        this.f3481k.f3710h = true;
        this.f3481k.f3703a = false;
        m6529a(c0935n, this.f3481k, c0940r);
        this.f3485o = this.f3473c;
        if (!z) {
            a = c0951c.m6507a(M, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m6563s(w)) {
            for (int i3 = this.f3477g - 1; i3 >= 0; i3--) {
                View a2 = this.f3478h[i3].m6507a(M, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f3477g) {
                a = this.f3478h[i2].m6507a(M, w);
                if (a != null && a != e) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    private int m6567w(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                if (this.f3479i == 1 || !m6612h()) {
                    return -1;
                }
                return 1;
            case 2:
                if (this.f3479i == 1) {
                    return 1;
                }
                if (m6612h()) {
                    return -1;
                }
                return 1;
            case 17:
                if (this.f3479i != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.f3479i != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                if (this.f3479i != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.f3479i == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }
}
