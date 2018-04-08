package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ao.C0314a;
import android.support.v4.p021b.C0426h;
import android.support.v4.p021b.C0426h.C0315a;
import android.support.v4.p021b.C0426h.C0316b;
import android.support.v4.p024g.C0499d;
import android.support.v4.p024g.C0512k;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class ap extends ao {
    static boolean f1602a = false;
    final C0512k<C0317a> f1603b = new C0512k();
    final C0512k<C0317a> f1604c = new C0512k();
    final String f1605d;
    boolean f1606e;
    boolean f1607f;
    private C0394w f1608g;

    final class C0317a implements C0315a<Object>, C0316b<Object> {
        final int f1587a;
        final Bundle f1588b;
        C0314a<Object> f1589c;
        C0426h<Object> f1590d;
        boolean f1591e;
        boolean f1592f;
        Object f1593g;
        boolean f1594h;
        boolean f1595i;
        boolean f1596j;
        boolean f1597k;
        boolean f1598l;
        boolean f1599m;
        C0317a f1600n;
        final /* synthetic */ ap f1601o;

        void m2413a() {
            if (this.f1595i && this.f1596j) {
                this.f1594h = true;
            } else if (!this.f1594h) {
                this.f1594h = true;
                if (ap.f1602a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f1590d == null && this.f1589c != null) {
                    this.f1590d = this.f1589c.m2409a(this.f1587a, this.f1588b);
                }
                if (this.f1590d == null) {
                    return;
                }
                if (!this.f1590d.getClass().isMemberClass() || Modifier.isStatic(this.f1590d.getClass().getModifiers())) {
                    if (!this.f1599m) {
                        this.f1590d.m2914a(this.f1587a, this);
                        this.f1590d.m2915a((C0315a) this);
                        this.f1599m = true;
                    }
                    this.f1590d.m2913a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f1590d);
            }
        }

        void m2416b() {
            if (ap.f1602a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f1595i = true;
            this.f1596j = this.f1594h;
            this.f1594h = false;
            this.f1589c = null;
        }

        void m2417c() {
            if (this.f1595i) {
                if (ap.f1602a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f1595i = false;
                if (!(this.f1594h == this.f1596j || this.f1594h)) {
                    m2419e();
                }
            }
            if (this.f1594h && this.f1591e && !this.f1597k) {
                m2414a(this.f1590d, this.f1593g);
            }
        }

        void m2418d() {
            if (this.f1594h && this.f1597k) {
                this.f1597k = false;
                if (this.f1591e && !this.f1595i) {
                    m2414a(this.f1590d, this.f1593g);
                }
            }
        }

        void m2419e() {
            if (ap.f1602a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f1594h = false;
            if (!this.f1595i && this.f1590d != null && this.f1599m) {
                this.f1599m = false;
                this.f1590d.m2916a((C0316b) this);
                this.f1590d.m2919b(this);
                this.f1590d.m2920c();
            }
        }

        void m2420f() {
            String str;
            C0314a c0314a = null;
            if (ap.f1602a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f1598l = true;
            boolean z = this.f1592f;
            this.f1592f = false;
            if (this.f1589c != null && this.f1590d != null && this.f1591e && z) {
                if (ap.f1602a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f1601o.f1608g != null) {
                    String str2 = this.f1601o.f1608g.f1815d.f1864v;
                    this.f1601o.f1608g.f1815d.f1864v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f1589c.m2410a(this.f1590d);
                } finally {
                    c0314a = this.f1601o.f1608g;
                    if (c0314a != null) {
                        c0314a = this.f1601o.f1608g.f1815d;
                        c0314a.f1864v = str;
                    }
                }
            }
            this.f1589c = c0314a;
            this.f1593g = c0314a;
            this.f1591e = false;
            if (this.f1590d != null) {
                if (this.f1599m) {
                    this.f1599m = false;
                    this.f1590d.m2916a((C0316b) this);
                    this.f1590d.m2919b(this);
                }
                this.f1590d.m2922e();
            }
            if (this.f1600n != null) {
                this.f1600n.m2420f();
            }
        }

        void m2414a(C0426h<Object> c0426h, Object obj) {
            String str;
            if (this.f1589c != null) {
                if (this.f1601o.f1608g != null) {
                    String str2 = this.f1601o.f1608g.f1815d.f1864v;
                    this.f1601o.f1608g.f1815d.f1864v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (ap.f1602a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0426h + ": " + c0426h.m2912a(obj));
                    }
                    this.f1589c.m2411a((C0426h) c0426h, obj);
                    this.f1592f = true;
                } finally {
                    if (this.f1601o.f1608g != null) {
                        this.f1601o.f1608g.f1815d.f1864v = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f1587a);
            stringBuilder.append(" : ");
            C0499d.m3138a(this.f1590d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void m2415a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1587a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f1588b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f1589c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f1590d);
            if (this.f1590d != null) {
                this.f1590d.m2917a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f1591e || this.f1592f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f1591e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f1592f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f1593g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1594h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f1597k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f1598l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f1595i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f1596j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f1599m);
            if (this.f1600n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f1600n);
                printWriter.println(":");
                this.f1600n.m2415a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    ap(String str, C0394w c0394w, boolean z) {
        this.f1605d = str;
        this.f1608g = c0394w;
        this.f1606e = z;
    }

    void m2422a(C0394w c0394w) {
        this.f1608g = c0394w;
    }

    void m2425b() {
        if (f1602a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f1606e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f1606e = true;
        for (int b = this.f1603b.m3171b() - 1; b >= 0; b--) {
            ((C0317a) this.f1603b.m3177e(b)).m2413a();
        }
    }

    void m2426c() {
        if (f1602a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f1606e) {
            for (int b = this.f1603b.m3171b() - 1; b >= 0; b--) {
                ((C0317a) this.f1603b.m3177e(b)).m2419e();
            }
            this.f1606e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m2427d() {
        if (f1602a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f1606e) {
            this.f1607f = true;
            this.f1606e = false;
            for (int b = this.f1603b.m3171b() - 1; b >= 0; b--) {
                ((C0317a) this.f1603b.m3177e(b)).m2416b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m2428e() {
        if (this.f1607f) {
            if (f1602a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f1607f = false;
            for (int b = this.f1603b.m3171b() - 1; b >= 0; b--) {
                ((C0317a) this.f1603b.m3177e(b)).m2417c();
            }
        }
    }

    void m2429f() {
        for (int b = this.f1603b.m3171b() - 1; b >= 0; b--) {
            ((C0317a) this.f1603b.m3177e(b)).f1597k = true;
        }
    }

    void m2430g() {
        for (int b = this.f1603b.m3171b() - 1; b >= 0; b--) {
            ((C0317a) this.f1603b.m3177e(b)).m2418d();
        }
    }

    void m2431h() {
        int b;
        if (!this.f1607f) {
            if (f1602a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f1603b.m3171b() - 1; b >= 0; b--) {
                ((C0317a) this.f1603b.m3177e(b)).m2420f();
            }
            this.f1603b.m3174c();
        }
        if (f1602a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f1604c.m3171b() - 1; b >= 0; b--) {
            ((C0317a) this.f1604c.m3177e(b)).m2420f();
        }
        this.f1604c.m3174c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0499d.m3138a(this.f1608g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m2423a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f1603b.m3171b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f1603b.m3171b(); i2++) {
                C0317a c0317a = (C0317a) this.f1603b.m3177e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f1603b.m3176d(i2));
                printWriter.print(": ");
                printWriter.println(c0317a.toString());
                c0317a.m2415a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f1604c.m3171b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f1604c.m3171b()) {
                c0317a = (C0317a) this.f1604c.m3177e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f1604c.m3176d(i));
                printWriter.print(": ");
                printWriter.println(c0317a.toString());
                c0317a.m2415a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo310a() {
        int b = this.f1603b.m3171b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            C0317a c0317a = (C0317a) this.f1603b.m3177e(i);
            if (!c0317a.f1594h || c0317a.f1592f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
