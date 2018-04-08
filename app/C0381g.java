package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.ai.C0310a;
import android.support.v4.app.ai.C0311b;
import android.support.v4.p024g.C0495a;
import android.support.v4.p024g.C0500e;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class C0381g extends ah implements Runnable {
    static final boolean f1761a = (VERSION.SDK_INT >= 21);
    final C0404y f1762b;
    C0379a f1763c;
    C0379a f1764d;
    int f1765e;
    int f1766f;
    int f1767g;
    int f1768h;
    int f1769i;
    int f1770j;
    int f1771k;
    boolean f1772l;
    boolean f1773m = true;
    String f1774n;
    boolean f1775o;
    int f1776p = -1;
    int f1777q;
    CharSequence f1778r;
    int f1779s;
    CharSequence f1780t;
    ArrayList<String> f1781u;
    ArrayList<String> f1782v;

    static final class C0379a {
        C0379a f1747a;
        C0379a f1748b;
        int f1749c;
        Fragment f1750d;
        int f1751e;
        int f1752f;
        int f1753g;
        int f1754h;
        ArrayList<Fragment> f1755i;

        C0379a() {
        }
    }

    public class C0380b {
        public C0495a<String, String> f1756a = new C0495a();
        public ArrayList<View> f1757b = new ArrayList();
        public C0310a f1758c = new C0310a();
        public View f1759d;
        final /* synthetic */ C0381g f1760e;

        public C0380b(C0381g c0381g) {
            this.f1760e = c0381g;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1776p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f1776p);
        }
        if (this.f1774n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f1774n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m2683a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m2684a(str, printWriter, true);
    }

    public void m2684a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1774n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1776p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1775o);
            if (this.f1770j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1770j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1771k));
            }
            if (!(this.f1766f == 0 && this.f1767g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1766f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1767g));
            }
            if (!(this.f1768h == 0 && this.f1769i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1768h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1769i));
            }
            if (!(this.f1777q == 0 && this.f1778r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1777q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1778r);
            }
            if (!(this.f1779s == 0 && this.f1780t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1779s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1780t);
            }
        }
        if (this.f1763c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0379a c0379a = this.f1763c;
            while (c0379a != null) {
                String str3;
                switch (c0379a.f1749c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0379a.f1749c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0379a.f1750d);
                if (z) {
                    if (!(c0379a.f1751e == 0 && c0379a.f1752f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0379a.f1751e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0379a.f1752f));
                    }
                    if (!(c0379a.f1753g == 0 && c0379a.f1754h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0379a.f1753g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0379a.f1754h));
                    }
                }
                if (c0379a.f1755i != null && c0379a.f1755i.size() > 0) {
                    for (int i2 = 0; i2 < c0379a.f1755i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0379a.f1755i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0379a.f1755i.get(i2));
                    }
                }
                c0379a = c0379a.f1747a;
                i++;
            }
        }
    }

    public C0381g(C0404y c0404y) {
        this.f1762b = c0404y;
    }

    void m2681a(C0379a c0379a) {
        if (this.f1763c == null) {
            this.f1764d = c0379a;
            this.f1763c = c0379a;
        } else {
            c0379a.f1748b = this.f1764d;
            this.f1764d.f1747a = c0379a;
            this.f1764d = c0379a;
        }
        c0379a.f1751e = this.f1766f;
        c0379a.f1752f = this.f1767g;
        c0379a.f1753g = this.f1768h;
        c0379a.f1754h = this.f1769i;
        this.f1765e++;
    }

    public ah mo342a(Fragment fragment, String str) {
        m2655a(0, fragment, str, 1);
        return this;
    }

    public ah mo340a(int i, Fragment fragment) {
        m2655a(i, fragment, null, 1);
        return this;
    }

    private void m2655a(int i, Fragment fragment, String str, int i2) {
        fragment.f1487B = this.f1762b;
        if (str != null) {
            if (fragment.f1494I == null || str.equals(fragment.f1494I)) {
                fragment.f1494I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f1494I + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.f1492G == 0 || fragment.f1492G == i) {
                fragment.f1492G = i;
                fragment.f1493H = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f1492G + " now " + i);
            }
        }
        C0379a c0379a = new C0379a();
        c0379a.f1749c = i2;
        c0379a.f1750d = fragment;
        m2681a(c0379a);
    }

    public ah mo341a(Fragment fragment) {
        C0379a c0379a = new C0379a();
        c0379a.f1749c = 3;
        c0379a.f1750d = fragment;
        m2681a(c0379a);
        return this;
    }

    public ah m2675a() {
        if (this.f1772l) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1773m = false;
        return this;
    }

    void m2680a(int i) {
        if (this.f1772l) {
            if (C0404y.f1843a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0379a c0379a = this.f1763c; c0379a != null; c0379a = c0379a.f1747a) {
                Fragment fragment;
                if (c0379a.f1750d != null) {
                    fragment = c0379a.f1750d;
                    fragment.f1486A += i;
                    if (C0404y.f1843a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0379a.f1750d + " to " + c0379a.f1750d.f1486A);
                    }
                }
                if (c0379a.f1755i != null) {
                    for (int size = c0379a.f1755i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0379a.f1755i.get(size);
                        fragment.f1486A += i;
                        if (C0404y.f1843a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f1486A);
                        }
                    }
                }
            }
        }
    }

    public int mo343b() {
        return m2674a(false);
    }

    public int mo344c() {
        return m2674a(true);
    }

    public void mo345d() {
        m2675a();
        this.f1762b.m2847b((Runnable) this, true);
    }

    int m2674a(boolean z) {
        if (this.f1775o) {
            throw new IllegalStateException("commit already called");
        }
        if (C0404y.f1843a) {
            Log.v("FragmentManager", "Commit: " + this);
            m2683a("  ", null, new PrintWriter(new C0500e("FragmentManager")), null);
        }
        this.f1775o = true;
        if (this.f1772l) {
            this.f1776p = this.f1762b.m2817a(this);
        } else {
            this.f1776p = -1;
        }
        this.f1762b.m2836a((Runnable) this, z);
        return this.f1776p;
    }

    public void run() {
        if (C0404y.f1843a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f1772l || this.f1776p >= 0) {
            C0380b c0380b;
            m2680a(1);
            if (!f1761a || this.f1762b.f1857n < 1) {
                c0380b = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m2672b(sparseArray, sparseArray2);
                c0380b = m2647a(sparseArray, sparseArray2, false);
            }
            int i = c0380b != null ? 0 : this.f1771k;
            int i2 = c0380b != null ? 0 : this.f1770j;
            C0379a c0379a = this.f1763c;
            while (c0379a != null) {
                int i3 = c0380b != null ? 0 : c0379a.f1751e;
                int i4 = c0380b != null ? 0 : c0379a.f1752f;
                Fragment fragment;
                switch (c0379a.f1749c) {
                    case 1:
                        fragment = c0379a.f1750d;
                        fragment.f1502Q = i3;
                        this.f1762b.m2834a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = c0379a.f1750d;
                        int i5 = fragment2.f1493H;
                        if (this.f1762b.f1850g != null) {
                            int size = this.f1762b.f1850g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.f1762b.f1850g.get(size);
                                if (C0404y.f1843a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.f1493H == i5) {
                                    if (fragment == fragment2) {
                                        fragment = null;
                                        c0379a.f1750d = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (c0379a.f1755i == null) {
                                            c0379a.f1755i = new ArrayList();
                                        }
                                        c0379a.f1755i.add(fragment);
                                        fragment.f1502Q = i4;
                                        if (this.f1772l) {
                                            fragment.f1486A++;
                                            if (C0404y.f1843a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f1486A);
                                            }
                                        }
                                        this.f1762b.m2832a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f1502Q = i3;
                        this.f1762b.m2834a(fragment2, false);
                        break;
                    case 3:
                        fragment = c0379a.f1750d;
                        fragment.f1502Q = i4;
                        this.f1762b.m2832a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = c0379a.f1750d;
                        fragment.f1502Q = i4;
                        this.f1762b.m2844b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = c0379a.f1750d;
                        fragment.f1502Q = i3;
                        this.f1762b.m2853c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = c0379a.f1750d;
                        fragment.f1502Q = i4;
                        this.f1762b.m2857d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = c0379a.f1750d;
                        fragment.f1502Q = i3;
                        this.f1762b.m2859e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0379a.f1749c);
                }
                c0379a = c0379a.f1747a;
            }
            this.f1762b.m2826a(this.f1762b.f1857n, i2, i, true);
            if (this.f1772l) {
                this.f1762b.m2845b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m2666a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f1493H;
            if (i != 0 && !fragment.m2316s()) {
                if (fragment.m2313p() && fragment.m2317t() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m2673b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f1493H;
            if (i != 0) {
                if (!fragment.m2313p()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.f1512k < 1 && this.f1762b.f1857n >= 1) {
                this.f1762b.m2856d(fragment);
                this.f1762b.m2833a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void m2672b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f1762b.f1859p.mo358a()) {
            for (C0379a c0379a = this.f1763c; c0379a != null; c0379a = c0379a.f1747a) {
                switch (c0379a.f1749c) {
                    case 1:
                        m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 2:
                        Fragment fragment = c0379a.f1750d;
                        if (this.f1762b.f1850g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.f1762b.f1850g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f1762b.f1850g.get(i);
                                if (fragment2 == null || fragment3.f1493H == fragment2.f1493H) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.f1493H);
                                    } else {
                                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 3:
                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 4:
                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 5:
                        m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 6:
                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 7:
                        m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m2682a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f1762b.f1859p.mo358a()) {
            for (C0379a c0379a = this.f1764d; c0379a != null; c0379a = c0379a.f1748b) {
                switch (c0379a.f1749c) {
                    case 1:
                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 2:
                        if (c0379a.f1755i != null) {
                            for (int size = c0379a.f1755i.size() - 1; size >= 0; size--) {
                                m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) c0379a.f1755i.get(size));
                            }
                        }
                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 3:
                        m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 4:
                        m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 5:
                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 6:
                        m2673b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    case 7:
                        C0381g.m2666a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0379a.f1750d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public C0380b m2679a(boolean z, C0380b c0380b, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (C0404y.f1843a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m2683a("  ", null, new PrintWriter(new C0500e("FragmentManager")), null);
        }
        if (f1761a && this.f1762b.f1857n >= 1) {
            if (c0380b == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0380b = m2647a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0381g.m2660a(c0380b, this.f1782v, this.f1781u);
            }
        }
        m2680a(-1);
        int i = c0380b != null ? 0 : this.f1771k;
        int i2 = c0380b != null ? 0 : this.f1770j;
        C0379a c0379a = this.f1764d;
        while (c0379a != null) {
            int i3 = c0380b != null ? 0 : c0379a.f1753g;
            int i4 = c0380b != null ? 0 : c0379a.f1754h;
            Fragment fragment;
            Fragment fragment2;
            switch (c0379a.f1749c) {
                case 1:
                    fragment = c0379a.f1750d;
                    fragment.f1502Q = i4;
                    this.f1762b.m2832a(fragment, C0404y.m2815d(i2), i);
                    break;
                case 2:
                    fragment = c0379a.f1750d;
                    if (fragment != null) {
                        fragment.f1502Q = i4;
                        this.f1762b.m2832a(fragment, C0404y.m2815d(i2), i);
                    }
                    if (c0379a.f1755i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0379a.f1755i.size(); i5++) {
                        fragment2 = (Fragment) c0379a.f1755i.get(i5);
                        fragment2.f1502Q = i3;
                        this.f1762b.m2834a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = c0379a.f1750d;
                    fragment2.f1502Q = i3;
                    this.f1762b.m2834a(fragment2, false);
                    break;
                case 4:
                    fragment2 = c0379a.f1750d;
                    fragment2.f1502Q = i3;
                    this.f1762b.m2853c(fragment2, C0404y.m2815d(i2), i);
                    break;
                case 5:
                    fragment = c0379a.f1750d;
                    fragment.f1502Q = i4;
                    this.f1762b.m2844b(fragment, C0404y.m2815d(i2), i);
                    break;
                case 6:
                    fragment2 = c0379a.f1750d;
                    fragment2.f1502Q = i3;
                    this.f1762b.m2859e(fragment2, C0404y.m2815d(i2), i);
                    break;
                case 7:
                    fragment2 = c0379a.f1750d;
                    fragment2.f1502Q = i3;
                    this.f1762b.m2857d(fragment2, C0404y.m2815d(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0379a.f1749c);
            }
            c0379a = c0379a.f1748b;
        }
        if (z) {
            this.f1762b.m2826a(this.f1762b.f1857n, C0404y.m2815d(i2), i, true);
            c0380b = null;
        }
        if (this.f1776p >= 0) {
            this.f1762b.m2851c(this.f1776p);
            this.f1776p = -1;
        }
        return c0380b;
    }

    public String m2688e() {
        return this.f1774n;
    }

    private C0380b m2647a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        C0380b c0380b = new C0380b(this);
        c0380b.f1759d = new View(this.f1762b.f1858o.m2732g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (m2668a(sparseArray.keyAt(i2), c0380b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m2668a(i4, c0380b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return c0380b;
    }

    private static Object m2653a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return ai.m2376a(z ? fragment.m2242C() : fragment.m2323z());
    }

    private static Object m2670b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return ai.m2376a(z ? fragment.m2240A() : fragment.m2241B());
    }

    private static Object m2652a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object E;
        if (z) {
            E = fragment2.m2244E();
        } else {
            E = fragment.m2243D();
        }
        return ai.m2397b(E);
    }

    private static Object m2654a(Object obj, Fragment fragment, ArrayList<View> arrayList, C0495a<String, View> c0495a, View view) {
        if (obj != null) {
            return ai.m2377a(obj, fragment.m2317t(), (ArrayList) arrayList, (Map) c0495a, view);
        }
        return obj;
    }

    private C0495a<String, View> m2648a(C0380b c0380b, Fragment fragment, boolean z) {
        C0495a c0495a = new C0495a();
        if (this.f1781u != null) {
            ai.m2392a((Map) c0495a, fragment.m2317t());
            if (z) {
                c0495a.m3104a(this.f1782v);
            } else {
                c0495a = C0381g.m2651a(this.f1781u, this.f1782v, c0495a);
            }
        }
        if (z) {
            if (fragment.ah != null) {
                fragment.ah.m2628a(this.f1782v, c0495a);
            }
            m2658a(c0380b, c0495a, false);
        } else {
            if (fragment.ai != null) {
                fragment.ai.m2628a(this.f1782v, c0495a);
            }
            m2671b(c0380b, c0495a, false);
        }
        return c0495a;
    }

    private boolean m2668a(int i, C0380b c0380b, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f1762b.f1859p.mo357a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        C0311b c0382h;
        ArrayList arrayList2;
        Map c0495a;
        boolean z2;
        Object a2;
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = C0381g.m2653a(fragment, z);
        Object a4 = C0381g.m2652a(fragment, fragment2, z);
        Object b = C0381g.m2670b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m2648a(c0380b, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0381g.m2654a(b, fragment2, arrayList, (C0495a) map, c0380b.f1759d);
                if (!(this.f1782v == null || map == null)) {
                    view2 = (View) map.get(this.f1782v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            ai.m2384a(a, view2);
                        }
                        if (obj != null) {
                            ai.m2384a(obj, view2);
                        }
                    }
                }
                c0382h = new C0382h(this, fragment);
                arrayList2 = new ArrayList();
                c0495a = new C0495a();
                z2 = true;
                if (fragment != null) {
                    if (z) {
                        z2 = fragment.m2245F();
                    } else {
                        z2 = fragment.m2246G();
                    }
                }
                a2 = ai.m2378a(a3, a, obj, z2);
                if (a2 != null) {
                    ai.m2387a(a3, obj, a, view, c0382h, c0380b.f1759d, c0380b.f1758c, c0380b.f1756a, arrayList2, arrayList, map, c0495a, arrayList3);
                    m2667a(view, c0380b, i, a2);
                    ai.m2386a(a2, c0380b.f1759d, true);
                    m2656a(c0380b, i, a2);
                    ai.m2383a((ViewGroup) view, a2);
                    ai.m2382a(view, c0380b.f1759d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0380b.f1757b, c0495a);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            bn bnVar = z ? fragment2.ah : fragment.ah;
            if (bnVar != null) {
                bnVar.m2627a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            m2659a(c0380b, view, a4, fragment, fragment2, z, arrayList3, a3, b);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0381g.m2654a(b, fragment2, arrayList, (C0495a) map, c0380b.f1759d);
        view2 = (View) map.get(this.f1782v.get(0));
        if (view2 != null) {
            if (a != null) {
                ai.m2384a(a, view2);
            }
            if (obj != null) {
                ai.m2384a(obj, view2);
            }
        }
        c0382h = new C0382h(this, fragment);
        arrayList2 = new ArrayList();
        c0495a = new C0495a();
        z2 = true;
        if (fragment != null) {
            if (z) {
                z2 = fragment.m2245F();
            } else {
                z2 = fragment.m2246G();
            }
        }
        a2 = ai.m2378a(a3, a, obj, z2);
        if (a2 != null) {
            ai.m2387a(a3, obj, a, view, c0382h, c0380b.f1759d, c0380b.f1758c, c0380b.f1756a, arrayList2, arrayList, map, c0495a, arrayList3);
            m2667a(view, c0380b, i, a2);
            ai.m2386a(a2, c0380b.f1759d, true);
            m2656a(c0380b, i, a2);
            ai.m2383a((ViewGroup) view, a2);
            ai.m2382a(view, c0380b.f1759d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0380b.f1757b, c0495a);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void m2659a(C0380b c0380b, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList, Object obj2, Object obj3) {
        if (obj != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C0383i(this, view, obj, arrayList, c0380b, obj2, obj3, z, fragment, fragment2));
        }
    }

    private void m2657a(C0380b c0380b, Fragment fragment, Fragment fragment2, boolean z, C0495a<String, View> c0495a) {
        bn bnVar = z ? fragment2.ah : fragment.ah;
        if (bnVar != null) {
            bnVar.m2629b(new ArrayList(c0495a.keySet()), new ArrayList(c0495a.values()), null);
        }
    }

    private void m2664a(C0495a<String, View> c0495a, C0380b c0380b) {
        if (this.f1782v != null && !c0495a.isEmpty()) {
            View view = (View) c0495a.get(this.f1782v.get(0));
            if (view != null) {
                c0380b.f1758c.f1563a = view;
            }
        }
    }

    private C0495a<String, View> m2649a(C0380b c0380b, boolean z, Fragment fragment) {
        C0495a b = m2669b(c0380b, fragment, z);
        if (z) {
            if (fragment.ai != null) {
                fragment.ai.m2628a(this.f1782v, b);
            }
            m2658a(c0380b, b, true);
        } else {
            if (fragment.ah != null) {
                fragment.ah.m2628a(this.f1782v, b);
            }
            m2671b(c0380b, b, true);
        }
        return b;
    }

    private static C0495a<String, View> m2651a(ArrayList<String> arrayList, ArrayList<String> arrayList2, C0495a<String, View> c0495a) {
        if (c0495a.isEmpty()) {
            return c0495a;
        }
        C0495a<String, View> c0495a2 = new C0495a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0495a.get(arrayList.get(i));
            if (view != null) {
                c0495a2.put(arrayList2.get(i), view);
            }
        }
        return c0495a2;
    }

    private C0495a<String, View> m2669b(C0380b c0380b, Fragment fragment, boolean z) {
        C0495a c0495a = new C0495a();
        View t = fragment.m2317t();
        if (t == null || this.f1781u == null) {
            return c0495a;
        }
        ai.m2392a((Map) c0495a, t);
        if (z) {
            return C0381g.m2651a(this.f1781u, this.f1782v, c0495a);
        }
        c0495a.m3104a(this.f1782v);
        return c0495a;
    }

    private void m2667a(View view, C0380b c0380b, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0384j(this, view, c0380b, i, obj));
    }

    private void m2656a(C0380b c0380b, int i, Object obj) {
        if (this.f1762b.f1850g != null) {
            for (int i2 = 0; i2 < this.f1762b.f1850g.size(); i2++) {
                Fragment fragment = (Fragment) this.f1762b.f1850g.get(i2);
                if (!(fragment.f1504S == null || fragment.f1503R == null || fragment.f1493H != i)) {
                    if (!fragment.f1495J) {
                        ai.m2386a(obj, fragment.f1504S, false);
                        c0380b.f1757b.remove(fragment.f1504S);
                    } else if (!c0380b.f1757b.contains(fragment.f1504S)) {
                        ai.m2386a(obj, fragment.f1504S, true);
                        c0380b.f1757b.add(fragment.f1504S);
                    }
                }
            }
        }
    }

    private static void m2665a(C0495a<String, String> c0495a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0495a.size(); i++) {
                if (str.equals(c0495a.m3101c(i))) {
                    c0495a.m3097a(i, (Object) str2);
                    return;
                }
            }
            c0495a.put(str, str2);
        }
    }

    private static void m2660a(C0380b c0380b, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0381g.m2665a(c0380b.f1756a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m2658a(C0380b c0380b, C0495a<String, View> c0495a, boolean z) {
        int size = this.f1782v == null ? 0 : this.f1782v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f1781u.get(i);
            View view = (View) c0495a.get((String) this.f1782v.get(i));
            if (view != null) {
                String a = ai.m2379a(view);
                if (z) {
                    C0381g.m2665a(c0380b.f1756a, str, a);
                } else {
                    C0381g.m2665a(c0380b.f1756a, a, str);
                }
            }
        }
    }

    private void m2671b(C0380b c0380b, C0495a<String, View> c0495a, boolean z) {
        int size = c0495a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0495a.m3100b(i);
            String a = ai.m2379a((View) c0495a.m3101c(i));
            if (z) {
                C0381g.m2665a(c0380b.f1756a, str, a);
            } else {
                C0381g.m2665a(c0380b.f1756a, a, str);
            }
        }
    }
}
