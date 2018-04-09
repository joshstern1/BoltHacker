package android.support.v4.view.p025a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class C0558l {
    private static final C0554a f2082a;
    private final Object f2083b;

    interface C0554a {
        Object mo490a(C0558l c0558l);
    }

    static class C0555d implements C0554a {
        C0555d() {
        }

        public Object mo490a(C0558l c0558l) {
            return null;
        }
    }

    static class C0556b extends C0555d {
        C0556b() {
        }

        public Object mo490a(C0558l c0558l) {
            return C0563o.m3563a(new C0560m(this, c0558l));
        }
    }

    static class C0557c extends C0555d {
        C0557c() {
        }

        public Object mo490a(C0558l c0558l) {
            return C0565q.m3564a(new C0562n(this, c0558l));
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f2082a = new C0557c();
        } else if (VERSION.SDK_INT >= 16) {
            f2082a = new C0556b();
        } else {
            f2082a = new C0555d();
        }
    }

    public C0558l() {
        this.f2083b = f2082a.mo490a(this);
    }

    public C0558l(Object obj) {
        this.f2083b = obj;
    }

    public Object m3545a() {
        return this.f2083b;
    }

    public C0547e mo714a(int i) {
        return null;
    }

    public boolean mo715a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<C0547e> m3546a(String str, int i) {
        return null;
    }

    public C0547e m3548b(int i) {
        return null;
    }
}
