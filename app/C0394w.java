package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p024g.C0494j;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class C0394w<E> extends C0391u {
    private final Activity f1812a;
    final Context f1813b;
    final int f1814c;
    final C0404y f1815d;
    private final Handler f1816e;
    private C0494j<String, ao> f1817f;
    private boolean f1818g;
    private ap f1819h;
    private boolean f1820i;
    private boolean f1821j;

    C0394w(C0397s c0397s) {
        this(c0397s, c0397s, c0397s.f1826c, 0);
    }

    C0394w(Activity activity, Context context, Handler handler, int i) {
        this.f1815d = new C0404y();
        this.f1812a = activity;
        this.f1813b = context;
        this.f1816e = handler;
        this.f1814c = i;
    }

    public void mo360a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean mo361a(Fragment fragment) {
        return true;
    }

    public LayoutInflater mo362b() {
        return (LayoutInflater) this.f1813b.getSystemService("layout_inflater");
    }

    public void mo364c() {
    }

    public void mo359a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f1813b.startActivity(intent);
    }

    public boolean mo365d() {
        return true;
    }

    public int mo366e() {
        return this.f1814c;
    }

    public View mo357a(int i) {
        return null;
    }

    public boolean mo358a() {
        return true;
    }

    Activity m2731f() {
        return this.f1812a;
    }

    Context m2732g() {
        return this.f1813b;
    }

    Handler m2733h() {
        return this.f1816e;
    }

    C0404y m2734i() {
        return this.f1815d;
    }

    void m2720a(String str) {
        if (this.f1817f != null) {
            ap apVar = (ap) this.f1817f.get(str);
            if (apVar != null && !apVar.f1607f) {
                apVar.m2431h();
                this.f1817f.remove(str);
            }
        }
    }

    void mo363b(Fragment fragment) {
    }

    boolean m2735j() {
        return this.f1818g;
    }

    void m2736k() {
        if (!this.f1821j) {
            this.f1821j = true;
            if (this.f1819h != null) {
                this.f1819h.m2425b();
            } else if (!this.f1820i) {
                this.f1819h = m2716a("(root)", this.f1821j, false);
                if (!(this.f1819h == null || this.f1819h.f1606e)) {
                    this.f1819h.m2425b();
                }
            }
            this.f1820i = true;
        }
    }

    void m2722a(boolean z) {
        this.f1818g = z;
        if (this.f1819h != null && this.f1821j) {
            this.f1821j = false;
            if (z) {
                this.f1819h.m2427d();
            } else {
                this.f1819h.m2426c();
            }
        }
    }

    void m2737l() {
        if (this.f1819h != null) {
            this.f1819h.m2431h();
        }
    }

    void m2738m() {
        if (this.f1817f != null) {
            int size = this.f1817f.size();
            ap[] apVarArr = new ap[size];
            for (int i = size - 1; i >= 0; i--) {
                apVarArr[i] = (ap) this.f1817f.m3101c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ap apVar = apVarArr[i2];
                apVar.m2428e();
                apVar.m2430g();
            }
        }
    }

    ap m2716a(String str, boolean z, boolean z2) {
        if (this.f1817f == null) {
            this.f1817f = new C0494j();
        }
        ap apVar = (ap) this.f1817f.get(str);
        if (apVar != null) {
            apVar.m2422a(this);
            return apVar;
        } else if (!z2) {
            return apVar;
        } else {
            apVar = new ap(str, this, z);
            this.f1817f.put(str, apVar);
            return apVar;
        }
    }

    C0494j<String, ao> m2739n() {
        int i;
        int i2 = 0;
        if (this.f1817f != null) {
            int size = this.f1817f.size();
            ap[] apVarArr = new ap[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                apVarArr[i3] = (ap) this.f1817f.m3101c(i3);
            }
            boolean j = m2735j();
            i = 0;
            while (i2 < size) {
                ap apVar = apVarArr[i2];
                if (!apVar.f1607f && j) {
                    if (!apVar.f1606e) {
                        apVar.m2425b();
                    }
                    apVar.m2427d();
                }
                if (apVar.f1607f) {
                    i = 1;
                } else {
                    apVar.m2431h();
                    this.f1817f.remove(apVar.f1605d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f1817f;
        }
        return null;
    }

    void m2719a(C0494j<String, ao> c0494j) {
        this.f1817f = c0494j;
    }

    void m2727b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f1821j);
        if (this.f1819h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f1819h)));
            printWriter.println(":");
            this.f1819h.m2423a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
