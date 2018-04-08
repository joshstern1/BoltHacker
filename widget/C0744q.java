package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class C0744q {
    private static final C0740c f2437b;
    private Object f2438a;

    interface C0740c {
        Object mo705a(Context context);

        void mo706a(Object obj, int i, int i2);

        boolean mo707a(Object obj);

        boolean mo708a(Object obj, float f);

        boolean mo709a(Object obj, float f, float f2);

        boolean mo710a(Object obj, int i);

        boolean mo711a(Object obj, Canvas canvas);

        void mo712b(Object obj);

        boolean mo713c(Object obj);
    }

    static class C0741a implements C0740c {
        C0741a() {
        }

        public Object mo705a(Context context) {
            return null;
        }

        public void mo706a(Object obj, int i, int i2) {
        }

        public boolean mo707a(Object obj) {
            return true;
        }

        public void mo712b(Object obj) {
        }

        public boolean mo708a(Object obj, float f) {
            return false;
        }

        public boolean mo713c(Object obj) {
            return false;
        }

        public boolean mo710a(Object obj, int i) {
            return false;
        }

        public boolean mo711a(Object obj, Canvas canvas) {
            return false;
        }

        public boolean mo709a(Object obj, float f, float f2) {
            return false;
        }
    }

    static class C0742b implements C0740c {
        C0742b() {
        }

        public Object mo705a(Context context) {
            return C0745r.m4914a(context);
        }

        public void mo706a(Object obj, int i, int i2) {
            C0745r.m4915a(obj, i, i2);
        }

        public boolean mo707a(Object obj) {
            return C0745r.m4916a(obj);
        }

        public void mo712b(Object obj) {
            C0745r.m4920b(obj);
        }

        public boolean mo708a(Object obj, float f) {
            return C0745r.m4917a(obj, f);
        }

        public boolean mo713c(Object obj) {
            return C0745r.m4921c(obj);
        }

        public boolean mo710a(Object obj, int i) {
            return C0745r.m4918a(obj, i);
        }

        public boolean mo711a(Object obj, Canvas canvas) {
            return C0745r.m4919a(obj, canvas);
        }

        public boolean mo709a(Object obj, float f, float f2) {
            return C0745r.m4917a(obj, f);
        }
    }

    static class C0743d extends C0742b {
        C0743d() {
        }

        public boolean mo709a(Object obj, float f, float f2) {
            return C0746s.m4922a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f2437b = new C0743d();
        } else if (VERSION.SDK_INT >= 14) {
            f2437b = new C0742b();
        } else {
            f2437b = new C0741a();
        }
    }

    public C0744q(Context context) {
        this.f2438a = f2437b.mo705a(context);
    }

    public void m4906a(int i, int i2) {
        f2437b.mo706a(this.f2438a, i, i2);
    }

    public boolean m4907a() {
        return f2437b.mo707a(this.f2438a);
    }

    public void m4912b() {
        f2437b.mo712b(this.f2438a);
    }

    @Deprecated
    public boolean m4908a(float f) {
        return f2437b.mo708a(this.f2438a, f);
    }

    public boolean m4909a(float f, float f2) {
        return f2437b.mo709a(this.f2438a, f, f2);
    }

    public boolean m4913c() {
        return f2437b.mo713c(this.f2438a);
    }

    public boolean m4910a(int i) {
        return f2437b.mo710a(this.f2438a, i);
    }

    public boolean m4911a(Canvas canvas) {
        return f2437b.mo711a(this.f2438a, canvas);
    }
}
