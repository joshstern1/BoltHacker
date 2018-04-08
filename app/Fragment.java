package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p024g.C0494j;
import android.support.v4.p024g.C0499d;
import android.support.v4.view.C0658o;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0494j<String, Class<?>> f1484a = new C0494j();
    static final Object f1485j = new Object();
    int f1486A;
    C0404y f1487B;
    C0394w f1488C;
    C0404y f1489D;
    ad f1490E;
    Fragment f1491F;
    int f1492G;
    int f1493H;
    String f1494I;
    boolean f1495J;
    boolean f1496K;
    boolean f1497L;
    boolean f1498M;
    boolean f1499N;
    boolean f1500O = true;
    boolean f1501P;
    int f1502Q;
    ViewGroup f1503R;
    View f1504S;
    View f1505T;
    boolean f1506U;
    boolean f1507V = true;
    ap f1508W;
    boolean f1509X;
    boolean f1510Y;
    Object f1511Z = null;
    Object aa = f1485j;
    Object ab = null;
    Object ac = f1485j;
    Object ad = null;
    Object ae = f1485j;
    Boolean af;
    Boolean ag;
    bn ah = null;
    bn ai = null;
    int f1512k = 0;
    View f1513l;
    int f1514m;
    Bundle f1515n;
    SparseArray<Parcelable> f1516o;
    int f1517p = -1;
    String f1518q;
    Bundle f1519r;
    Fragment f1520s;
    int f1521t = -1;
    int f1522u;
    boolean f1523v;
    boolean f1524w;
    boolean f1525x;
    boolean f1526y;
    boolean f1527z;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C0393r();
        final Bundle f1483a;

        SavedState(Bundle bundle) {
            this.f1483a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f1483a = parcel.readBundle();
            if (classLoader != null && this.f1483a != null) {
                this.f1483a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f1483a);
        }
    }

    public static class C0306a extends RuntimeException {
        public C0306a(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static Fragment m2237a(Context context, String str) {
        return m2238a(context, str, null);
    }

    public static Fragment m2238a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f1484a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f1484a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f1519r = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new C0306a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0306a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0306a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m2239b(Context context, String str) {
        try {
            Class cls = (Class) f1484a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f1484a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void m2298f(Bundle bundle) {
        if (this.f1516o != null) {
            this.f1505T.restoreHierarchyState(this.f1516o);
            this.f1516o = null;
        }
        this.f1501P = false;
        m2302h(bundle);
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void m2263a(int i, Fragment fragment) {
        this.f1517p = i;
        if (fragment != null) {
            this.f1518q = fragment.f1518q + ":" + this.f1517p;
        } else {
            this.f1518q = "android:fragment:" + this.f1517p;
        }
    }

    final boolean m2304i() {
        return this.f1486A > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0499d.m3138a(this, stringBuilder);
        if (this.f1517p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f1517p);
        }
        if (this.f1492G != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f1492G));
        }
        if (this.f1494I != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f1494I);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final Bundle m2305j() {
        return this.f1519r;
    }

    public void m2275a(SavedState savedState) {
        if (this.f1517p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.f1483a == null) ? null : savedState.f1483a;
        this.f1515n = bundle;
    }

    public Context m2307k() {
        return this.f1488C == null ? null : this.f1488C.m2732g();
    }

    public final C0397s m2309l() {
        return this.f1488C == null ? null : (C0397s) this.f1488C.m2731f();
    }

    public final Resources m2310m() {
        if (this.f1488C != null) {
            return this.f1488C.m2732g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final String m2260a(int i) {
        return m2310m().getString(i);
    }

    public final String m2261a(int i, Object... objArr) {
        return m2310m().getString(i, objArr);
    }

    public final C0401x m2311n() {
        return this.f1487B;
    }

    public final C0401x m2312o() {
        if (this.f1489D == null) {
            m2247H();
            if (this.f1512k >= 5) {
                this.f1489D.m2873p();
            } else if (this.f1512k >= 4) {
                this.f1489D.m2872o();
            } else if (this.f1512k >= 2) {
                this.f1489D.m2871n();
            } else if (this.f1512k >= 1) {
                this.f1489D.m2870m();
            }
        }
        return this.f1489D;
    }

    public final boolean m2313p() {
        return this.f1488C != null && this.f1523v;
    }

    public final boolean m2314q() {
        return this.f1524w;
    }

    public final boolean m2315r() {
        return (!m2313p() || m2316s() || this.f1504S == null || this.f1504S.getWindowToken() == null || this.f1504S.getVisibility() != 0) ? false : true;
    }

    public final boolean m2316s() {
        return this.f1495J;
    }

    public void m2287c(boolean z) {
    }

    public void m2292d(boolean z) {
        if (this.f1500O != z) {
            this.f1500O = z;
            if (this.f1499N && m2313p() && !m2316s()) {
                this.f1488C.mo364c();
            }
        }
    }

    public void m2296e(boolean z) {
        if (!this.f1507V && z && this.f1512k < 4 && this.f1487B != null && m2313p()) {
            this.f1487B.m2843b(this);
        }
        this.f1507V = z;
        boolean z2 = this.f1512k < 4 && !z;
        this.f1506U = z2;
    }

    public void m2269a(Intent intent) {
        m2272a(intent, null);
    }

    public void m2272a(Intent intent, Bundle bundle) {
        if (this.f1488C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f1488C.mo359a(this, intent, -1, bundle);
    }

    public void m2270a(Intent intent, int i) {
        m2271a(intent, i, null);
    }

    public void m2271a(Intent intent, int i, Bundle bundle) {
        if (this.f1488C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f1488C.mo359a(this, intent, i, bundle);
    }

    public void mo1459a(int i, int i2, Intent intent) {
    }

    public void m2264a(int i, String[] strArr, int[] iArr) {
    }

    public LayoutInflater mo350b(Bundle bundle) {
        LayoutInflater b = this.f1488C.mo362b();
        m2312o();
        C0658o.m4325a(b, this.f1489D.m2880w());
        return b;
    }

    public void m2268a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f1501P = true;
        Activity f = this.f1488C == null ? null : this.f1488C.m2731f();
        if (f != null) {
            this.f1501P = false;
            mo1676a(f, attributeSet, bundle);
        }
    }

    @Deprecated
    public void mo1676a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f1501P = true;
    }

    public void m2276a(Fragment fragment) {
    }

    public void mo348a(Context context) {
        this.f1501P = true;
        Activity f = this.f1488C == null ? null : this.f1488C.m2731f();
        if (f != null) {
            this.f1501P = false;
            mo1675a(f);
        }
    }

    @Deprecated
    public void mo1675a(Activity activity) {
        this.f1501P = true;
    }

    public Animation m2259a(int i, boolean z, int i2) {
        return null;
    }

    public void mo349a(Bundle bundle) {
        this.f1501P = true;
        m2300g(bundle);
        if (this.f1489D != null && !this.f1489D.m2849b(1)) {
            this.f1489D.m2870m();
        }
    }

    void m2300g(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f1489D == null) {
                    m2247H();
                }
                this.f1489D.m2831a(parcelable, this.f1490E);
                this.f1490E = null;
                this.f1489D.m2870m();
            }
        }
    }

    public View mo1250a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void mo2188a(View view, Bundle bundle) {
    }

    public View m2317t() {
        return this.f1504S;
    }

    public void mo351d(Bundle bundle) {
        this.f1501P = true;
    }

    public void m2302h(Bundle bundle) {
        this.f1501P = true;
    }

    public void mo354f() {
        this.f1501P = true;
        if (!this.f1509X) {
            this.f1509X = true;
            if (!this.f1510Y) {
                this.f1510Y = true;
                this.f1508W = this.f1488C.m2716a(this.f1518q, this.f1509X, false);
            }
            if (this.f1508W != null) {
                this.f1508W.m2425b();
            }
        }
    }

    public void mo1260u() {
        this.f1501P = true;
    }

    public void mo353e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f1501P = true;
    }

    public void mo1261v() {
        this.f1501P = true;
    }

    public void mo355g() {
        this.f1501P = true;
    }

    public void onLowMemory() {
        this.f1501P = true;
    }

    public void mo356h() {
        this.f1501P = true;
    }

    public void mo1678w() {
        this.f1501P = true;
        if (!this.f1510Y) {
            this.f1510Y = true;
            this.f1508W = this.f1488C.m2716a(this.f1518q, this.f1509X, false);
        }
        if (this.f1508W != null) {
            this.f1508W.m2431h();
        }
    }

    void m2321x() {
        this.f1517p = -1;
        this.f1518q = null;
        this.f1523v = false;
        this.f1524w = false;
        this.f1525x = false;
        this.f1526y = false;
        this.f1527z = false;
        this.f1486A = 0;
        this.f1487B = null;
        this.f1489D = null;
        this.f1488C = null;
        this.f1492G = 0;
        this.f1493H = 0;
        this.f1494I = null;
        this.f1495J = false;
        this.f1496K = false;
        this.f1498M = false;
        this.f1508W = null;
        this.f1509X = false;
        this.f1510Y = false;
    }

    public void mo352e() {
        this.f1501P = true;
    }

    public void m2278a(Menu menu, MenuInflater menuInflater) {
    }

    public void m2277a(Menu menu) {
    }

    public void m2322y() {
    }

    public boolean m2281a(MenuItem menuItem) {
        return false;
    }

    public void m2284b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m2309l().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean m2286b(MenuItem menuItem) {
        return false;
    }

    public Object m2323z() {
        return this.f1511Z;
    }

    public Object m2240A() {
        return this.aa == f1485j ? m2323z() : this.aa;
    }

    public Object m2241B() {
        return this.ab;
    }

    public Object m2242C() {
        return this.ac == f1485j ? m2241B() : this.ac;
    }

    public Object m2243D() {
        return this.ad;
    }

    public Object m2244E() {
        return this.ae == f1485j ? m2243D() : this.ae;
    }

    public boolean m2245F() {
        return this.ag == null ? true : this.ag.booleanValue();
    }

    public boolean m2246G() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public void mo1460a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f1492G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f1493H));
        printWriter.print(" mTag=");
        printWriter.println(this.f1494I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1512k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f1517p);
        printWriter.print(" mWho=");
        printWriter.print(this.f1518q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f1486A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f1523v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f1524w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f1525x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f1526y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f1495J);
        printWriter.print(" mDetached=");
        printWriter.print(this.f1496K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f1500O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f1499N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f1497L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f1498M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f1507V);
        if (this.f1487B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f1487B);
        }
        if (this.f1488C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f1488C);
        }
        if (this.f1491F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f1491F);
        }
        if (this.f1519r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1519r);
        }
        if (this.f1515n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1515n);
        }
        if (this.f1516o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1516o);
        }
        if (this.f1520s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f1520s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1522u);
        }
        if (this.f1502Q != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f1502Q);
        }
        if (this.f1503R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f1503R);
        }
        if (this.f1504S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f1504S);
        }
        if (this.f1505T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f1504S);
        }
        if (this.f1513l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f1513l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f1514m);
        }
        if (this.f1508W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f1508W.m2423a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f1489D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f1489D + ":");
            this.f1489D.mo382a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    Fragment m2257a(String str) {
        if (str.equals(this.f1518q)) {
            return this;
        }
        if (this.f1489D != null) {
            return this.f1489D.m2842b(str);
        }
        return null;
    }

    void m2247H() {
        this.f1489D = new C0404y();
        this.f1489D.m2835a(this.f1488C, new C0392q(this), this);
    }

    void m2303i(Bundle bundle) {
        if (this.f1489D != null) {
            this.f1489D.m2869l();
        }
        this.f1512k = 1;
        this.f1501P = false;
        mo349a(bundle);
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    View m2283b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1489D != null) {
            this.f1489D.m2869l();
        }
        return mo1250a(layoutInflater, viewGroup, bundle);
    }

    void m2306j(Bundle bundle) {
        if (this.f1489D != null) {
            this.f1489D.m2869l();
        }
        this.f1512k = 2;
        this.f1501P = false;
        mo351d(bundle);
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f1489D != null) {
            this.f1489D.m2871n();
        }
    }

    void m2248I() {
        if (this.f1489D != null) {
            this.f1489D.m2869l();
            this.f1489D.m2864g();
        }
        this.f1512k = 4;
        this.f1501P = false;
        mo354f();
        if (this.f1501P) {
            if (this.f1489D != null) {
                this.f1489D.m2872o();
            }
            if (this.f1508W != null) {
                this.f1508W.m2430g();
                return;
            }
            return;
        }
        throw new bo("Fragment " + this + " did not call through to super.onStart()");
    }

    void m2249J() {
        if (this.f1489D != null) {
            this.f1489D.m2869l();
            this.f1489D.m2864g();
        }
        this.f1512k = 5;
        this.f1501P = false;
        mo1260u();
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f1489D != null) {
            this.f1489D.m2873p();
            this.f1489D.m2864g();
        }
    }

    void m2273a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f1489D != null) {
            this.f1489D.m2829a(configuration);
        }
    }

    void m2250K() {
        onLowMemory();
        if (this.f1489D != null) {
            this.f1489D.m2879v();
        }
    }

    boolean m2285b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f1495J) {
            return false;
        }
        if (this.f1499N && this.f1500O) {
            z = true;
            m2278a(menu, menuInflater);
        }
        if (this.f1489D != null) {
            return z | this.f1489D.m2840a(menu, menuInflater);
        }
        return z;
    }

    boolean m2288c(Menu menu) {
        boolean z = false;
        if (this.f1495J) {
            return false;
        }
        if (this.f1499N && this.f1500O) {
            z = true;
            m2277a(menu);
        }
        if (this.f1489D != null) {
            return z | this.f1489D.m2839a(menu);
        }
        return z;
    }

    boolean m2289c(MenuItem menuItem) {
        if (!this.f1495J) {
            if (this.f1499N && this.f1500O && m2281a(menuItem)) {
                return true;
            }
            if (this.f1489D != null && this.f1489D.m2841a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean m2293d(MenuItem menuItem) {
        if (!this.f1495J) {
            if (m2286b(menuItem)) {
                return true;
            }
            if (this.f1489D != null && this.f1489D.m2850b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m2291d(Menu menu) {
        if (!this.f1495J) {
            if (this.f1499N && this.f1500O) {
                m2284b(menu);
            }
            if (this.f1489D != null) {
                this.f1489D.m2846b(menu);
            }
        }
    }

    void m2308k(Bundle bundle) {
        mo353e(bundle);
        if (this.f1489D != null) {
            Parcelable k = this.f1489D.m2868k();
            if (k != null) {
                bundle.putParcelable("android:support:fragments", k);
            }
        }
    }

    void m2251L() {
        if (this.f1489D != null) {
            this.f1489D.m2874q();
        }
        this.f1512k = 4;
        this.f1501P = false;
        mo1261v();
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m2252M() {
        if (this.f1489D != null) {
            this.f1489D.m2875r();
        }
        this.f1512k = 3;
        this.f1501P = false;
        mo355g();
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m2253N() {
        if (this.f1489D != null) {
            this.f1489D.m2876s();
        }
        this.f1512k = 2;
        if (this.f1509X) {
            this.f1509X = false;
            if (!this.f1510Y) {
                this.f1510Y = true;
                this.f1508W = this.f1488C.m2716a(this.f1518q, this.f1509X, false);
            }
            if (this.f1508W == null) {
                return;
            }
            if (this.f1488C.m2735j()) {
                this.f1508W.m2427d();
            } else {
                this.f1508W.m2426c();
            }
        }
    }

    void m2254O() {
        if (this.f1489D != null) {
            this.f1489D.m2877t();
        }
        this.f1512k = 1;
        this.f1501P = false;
        mo356h();
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f1508W != null) {
            this.f1508W.m2429f();
        }
    }

    void m2255P() {
        if (this.f1489D != null) {
            this.f1489D.m2878u();
        }
        this.f1512k = 0;
        this.f1501P = false;
        mo1678w();
        if (this.f1501P) {
            this.f1489D = null;
            return;
        }
        throw new bo("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void m2256Q() {
        this.f1501P = false;
        mo352e();
        if (!this.f1501P) {
            throw new bo("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.f1489D == null) {
        } else {
            if (this.f1498M) {
                this.f1489D.m2878u();
                this.f1489D = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }
}
