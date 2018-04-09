package android.support.v4.p021b;

import android.support.v4.p024g.C0499d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0426h<D> {
    int f1872a;
    C0316b<D> f1873b;
    C0315a<D> f1874c;
    boolean f1875d;
    boolean f1876e;
    boolean f1877f;
    boolean f1878g;
    boolean f1879h;

    public interface C0315a<D> {
    }

    public interface C0316b<D> {
    }

    public void m2914a(int i, C0316b<D> c0316b) {
        if (this.f1873b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1873b = c0316b;
        this.f1872a = i;
    }

    public void m2916a(C0316b<D> c0316b) {
        if (this.f1873b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1873b != c0316b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1873b = null;
        }
    }

    public void m2915a(C0315a<D> c0315a) {
        if (this.f1874c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1874c = c0315a;
    }

    public void m2919b(C0315a<D> c0315a) {
        if (this.f1874c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1874c != c0315a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1874c = null;
        }
    }

    public final void m2913a() {
        this.f1875d = true;
        this.f1877f = false;
        this.f1876e = false;
        m2918b();
    }

    protected void m2918b() {
    }

    public void m2920c() {
        this.f1875d = false;
        m2921d();
    }

    protected void m2921d() {
    }

    public void m2922e() {
        m2923f();
        this.f1877f = true;
        this.f1875d = false;
        this.f1876e = false;
        this.f1878g = false;
        this.f1879h = false;
    }

    protected void m2923f() {
    }

    public String m2912a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0499d.m3138a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0499d.m3138a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f1872a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m2917a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1872a);
        printWriter.print(" mListener=");
        printWriter.println(this.f1873b);
        if (this.f1875d || this.f1878g || this.f1879h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1875d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f1878g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f1879h);
        }
        if (this.f1876e || this.f1877f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f1876e);
            printWriter.print(" mReset=");
            printWriter.println(this.f1877f);
        }
    }
}
