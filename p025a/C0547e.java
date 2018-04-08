package android.support.v4.view.p025a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import no.nordicsemi.android.dfu.DfuBaseService;

public class C0547e {
    private static final C0535f f2080a;
    private final Object f2081b;

    public static class C0534a {
        public static final C0534a f2055a = new C0534a(1, null);
        public static final C0534a f2056b = new C0534a(2, null);
        public static final C0534a f2057c = new C0534a(4, null);
        public static final C0534a f2058d = new C0534a(8, null);
        public static final C0534a f2059e = new C0534a(16, null);
        public static final C0534a f2060f = new C0534a(32, null);
        public static final C0534a f2061g = new C0534a(64, null);
        public static final C0534a f2062h = new C0534a(128, null);
        public static final C0534a f2063i = new C0534a(256, null);
        public static final C0534a f2064j = new C0534a(512, null);
        public static final C0534a f2065k = new C0534a(1024, null);
        public static final C0534a f2066l = new C0534a(2048, null);
        public static final C0534a f2067m = new C0534a(4096, null);
        public static final C0534a f2068n = new C0534a(DfuBaseService.ERROR_REMOTE_MASK, null);
        public static final C0534a f2069o = new C0534a(DfuBaseService.ERROR_CONNECTION_MASK, null);
        public static final C0534a f2070p = new C0534a(DfuBaseService.ERROR_CONNECTION_STATE_MASK, null);
        public static final C0534a f2071q = new C0534a(65536, null);
        public static final C0534a f2072r = new C0534a(131072, null);
        public static final C0534a f2073s = new C0534a(262144, null);
        public static final C0534a f2074t = new C0534a(524288, null);
        public static final C0534a f2075u = new C0534a(1048576, null);
        public static final C0534a f2076v = new C0534a(2097152, null);
        private final Object f2077w;

        public C0534a(int i, CharSequence charSequence) {
            this(C0547e.f2080a.mo438a(i, charSequence));
        }

        private C0534a(Object obj) {
            this.f2077w = obj;
        }
    }

    interface C0535f {
        Object mo435a();

        Object mo436a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object mo437a(int i, int i2, boolean z, int i3);

        Object mo438a(int i, CharSequence charSequence);

        Object mo439a(View view);

        Object mo440a(Object obj);

        void mo441a(Object obj, int i);

        void mo442a(Object obj, Rect rect);

        void mo443a(Object obj, View view);

        void mo444a(Object obj, View view, int i);

        void mo445a(Object obj, CharSequence charSequence);

        void mo446a(Object obj, boolean z);

        boolean mo447a(Object obj, Object obj2);

        int mo448b(Object obj);

        void mo449b(Object obj, Rect rect);

        void mo450b(Object obj, View view);

        void mo451b(Object obj, View view, int i);

        void mo452b(Object obj, CharSequence charSequence);

        void mo453b(Object obj, Object obj2);

        void mo454b(Object obj, boolean z);

        int mo455c(Object obj);

        void mo456c(Object obj, Rect rect);

        void mo457c(Object obj, View view);

        void mo458c(Object obj, CharSequence charSequence);

        void mo459c(Object obj, Object obj2);

        void mo460c(Object obj, boolean z);

        CharSequence mo461d(Object obj);

        void mo462d(Object obj, Rect rect);

        void mo463d(Object obj, View view);

        void mo464d(Object obj, CharSequence charSequence);

        void mo465d(Object obj, boolean z);

        CharSequence mo466e(Object obj);

        void mo467e(Object obj, CharSequence charSequence);

        void mo468e(Object obj, boolean z);

        CharSequence mo469f(Object obj);

        void mo470f(Object obj, boolean z);

        CharSequence mo471g(Object obj);

        void mo472g(Object obj, boolean z);

        void mo473h(Object obj, boolean z);

        boolean mo474h(Object obj);

        void mo475i(Object obj, boolean z);

        boolean mo476i(Object obj);

        void mo477j(Object obj, boolean z);

        boolean mo478j(Object obj);

        boolean mo479k(Object obj);

        boolean mo480l(Object obj);

        boolean mo481m(Object obj);

        boolean mo482n(Object obj);

        boolean mo483o(Object obj);

        boolean mo484p(Object obj);

        boolean mo485q(Object obj);

        void mo486r(Object obj);

        boolean mo487s(Object obj);

        boolean mo488t(Object obj);

        String mo489u(Object obj);
    }

    static class C0536k implements C0535f {
        C0536k() {
        }

        public Object mo438a(int i, CharSequence charSequence) {
            return null;
        }

        public Object mo435a() {
            return null;
        }

        public Object mo439a(View view) {
            return null;
        }

        public Object mo440a(Object obj) {
            return null;
        }

        public void mo441a(Object obj, int i) {
        }

        public boolean mo447a(Object obj, Object obj2) {
            return false;
        }

        public void mo443a(Object obj, View view) {
        }

        public void mo451b(Object obj, View view, int i) {
        }

        public int mo448b(Object obj) {
            return 0;
        }

        public void mo442a(Object obj, Rect rect) {
        }

        public void mo449b(Object obj, Rect rect) {
        }

        public int mo455c(Object obj) {
            return 0;
        }

        public CharSequence mo461d(Object obj) {
            return null;
        }

        public CharSequence mo466e(Object obj) {
            return null;
        }

        public CharSequence mo469f(Object obj) {
            return null;
        }

        public CharSequence mo471g(Object obj) {
            return null;
        }

        public boolean mo474h(Object obj) {
            return false;
        }

        public boolean mo476i(Object obj) {
            return false;
        }

        public boolean mo478j(Object obj) {
            return false;
        }

        public boolean mo479k(Object obj) {
            return false;
        }

        public boolean mo480l(Object obj) {
            return false;
        }

        public boolean mo481m(Object obj) {
            return false;
        }

        public boolean mo487s(Object obj) {
            return false;
        }

        public boolean mo488t(Object obj) {
            return false;
        }

        public boolean mo482n(Object obj) {
            return false;
        }

        public boolean mo483o(Object obj) {
            return false;
        }

        public boolean mo484p(Object obj) {
            return false;
        }

        public boolean mo485q(Object obj) {
            return false;
        }

        public void mo456c(Object obj, Rect rect) {
        }

        public void mo462d(Object obj, Rect rect) {
        }

        public void mo452b(Object obj, CharSequence charSequence) {
        }

        public void mo446a(Object obj, boolean z) {
        }

        public void mo458c(Object obj, CharSequence charSequence) {
        }

        public void mo454b(Object obj, boolean z) {
        }

        public void mo460c(Object obj, boolean z) {
        }

        public void mo465d(Object obj, boolean z) {
        }

        public void mo473h(Object obj, boolean z) {
        }

        public void mo475i(Object obj, boolean z) {
        }

        public void mo468e(Object obj, boolean z) {
        }

        public void mo464d(Object obj, CharSequence charSequence) {
        }

        public void mo450b(Object obj, View view) {
        }

        public void mo470f(Object obj, boolean z) {
        }

        public void mo472g(Object obj, boolean z) {
        }

        public void mo457c(Object obj, View view) {
        }

        public void mo444a(Object obj, View view, int i) {
        }

        public void mo467e(Object obj, CharSequence charSequence) {
        }

        public void mo486r(Object obj) {
        }

        public String mo489u(Object obj) {
            return null;
        }

        public void mo453b(Object obj, Object obj2) {
        }

        public void mo459c(Object obj, Object obj2) {
        }

        public Object mo437a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object mo436a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public void mo477j(Object obj, boolean z) {
        }

        public void mo445a(Object obj, CharSequence charSequence) {
        }

        public void mo463d(Object obj, View view) {
        }
    }

    static class C0537e extends C0536k {
        C0537e() {
        }

        public Object mo435a() {
            return C0549g.m3488a();
        }

        public Object mo439a(View view) {
            return C0549g.m3489a(view);
        }

        public Object mo440a(Object obj) {
            return C0549g.m3490a(obj);
        }

        public void mo441a(Object obj, int i) {
            C0549g.m3491a(obj, i);
        }

        public void mo443a(Object obj, View view) {
            C0549g.m3493a(obj, view);
        }

        public int mo448b(Object obj) {
            return C0549g.m3496b(obj);
        }

        public void mo442a(Object obj, Rect rect) {
            C0549g.m3492a(obj, rect);
        }

        public void mo449b(Object obj, Rect rect) {
            C0549g.m3497b(obj, rect);
        }

        public int mo455c(Object obj) {
            return C0549g.m3501c(obj);
        }

        public CharSequence mo461d(Object obj) {
            return C0549g.m3506d(obj);
        }

        public CharSequence mo466e(Object obj) {
            return C0549g.m3510e(obj);
        }

        public CharSequence mo469f(Object obj) {
            return C0549g.m3512f(obj);
        }

        public CharSequence mo471g(Object obj) {
            return C0549g.m3514g(obj);
        }

        public boolean mo474h(Object obj) {
            return C0549g.m3516h(obj);
        }

        public boolean mo476i(Object obj) {
            return C0549g.m3517i(obj);
        }

        public boolean mo478j(Object obj) {
            return C0549g.m3518j(obj);
        }

        public boolean mo479k(Object obj) {
            return C0549g.m3519k(obj);
        }

        public boolean mo480l(Object obj) {
            return C0549g.m3520l(obj);
        }

        public boolean mo481m(Object obj) {
            return C0549g.m3521m(obj);
        }

        public boolean mo482n(Object obj) {
            return C0549g.m3522n(obj);
        }

        public boolean mo483o(Object obj) {
            return C0549g.m3523o(obj);
        }

        public boolean mo484p(Object obj) {
            return C0549g.m3524p(obj);
        }

        public boolean mo485q(Object obj) {
            return C0549g.m3525q(obj);
        }

        public void mo456c(Object obj, Rect rect) {
            C0549g.m3502c(obj, rect);
        }

        public void mo462d(Object obj, Rect rect) {
            C0549g.m3507d(obj, rect);
        }

        public void mo452b(Object obj, CharSequence charSequence) {
            C0549g.m3494a(obj, charSequence);
        }

        public void mo446a(Object obj, boolean z) {
            C0549g.m3495a(obj, z);
        }

        public void mo458c(Object obj, CharSequence charSequence) {
            C0549g.m3499b(obj, charSequence);
        }

        public void mo454b(Object obj, boolean z) {
            C0549g.m3500b(obj, z);
        }

        public void mo460c(Object obj, boolean z) {
            C0549g.m3505c(obj, z);
        }

        public void mo465d(Object obj, boolean z) {
            C0549g.m3509d(obj, z);
        }

        public void mo468e(Object obj, boolean z) {
            C0549g.m3511e(obj, z);
        }

        public void mo464d(Object obj, CharSequence charSequence) {
            C0549g.m3504c(obj, charSequence);
        }

        public void mo450b(Object obj, View view) {
            C0549g.m3498b(obj, view);
        }

        public void mo470f(Object obj, boolean z) {
            C0549g.m3513f(obj, z);
        }

        public void mo472g(Object obj, boolean z) {
            C0549g.m3515g(obj, z);
        }

        public void mo457c(Object obj, View view) {
            C0549g.m3503c(obj, view);
        }

        public void mo467e(Object obj, CharSequence charSequence) {
            C0549g.m3508d(obj, charSequence);
        }

        public void mo486r(Object obj) {
            C0549g.m3526r(obj);
        }
    }

    static class C0538g extends C0537e {
        C0538g() {
        }

        public void mo451b(Object obj, View view, int i) {
            C0550h.m3527a(obj, view, i);
        }

        public void mo444a(Object obj, View view, int i) {
            C0550h.m3530b(obj, view, i);
        }

        public boolean mo487s(Object obj) {
            return C0550h.m3529a(obj);
        }

        public void mo473h(Object obj, boolean z) {
            C0550h.m3528a(obj, z);
        }

        public boolean mo488t(Object obj) {
            return C0550h.m3532b(obj);
        }

        public void mo475i(Object obj, boolean z) {
            C0550h.m3531b(obj, z);
        }
    }

    static class C0539h extends C0538g {
        C0539h() {
        }

        public void mo463d(Object obj, View view) {
            C0551i.m3533a(obj, view);
        }
    }

    static class C0540i extends C0539h {
        C0540i() {
        }

        public String mo489u(Object obj) {
            return C0552j.m3534a(obj);
        }
    }

    static class C0541j extends C0540i {
        C0541j() {
        }

        public void mo453b(Object obj, Object obj2) {
            C0553k.m3537a(obj, obj2);
        }

        public Object mo437a(int i, int i2, boolean z, int i3) {
            return C0553k.m3536a(i, i2, z, i3);
        }

        public Object mo436a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return C0553k.m3535a(i, i2, i3, i4, z);
        }

        public void mo459c(Object obj, Object obj2) {
            C0553k.m3539b(obj, obj2);
        }

        public void mo477j(Object obj, boolean z) {
            C0553k.m3538a(obj, z);
        }
    }

    static class C0542b extends C0541j {
        C0542b() {
        }

        public Object mo438a(int i, CharSequence charSequence) {
            return C0548f.m3485a(i, charSequence);
        }

        public Object mo437a(int i, int i2, boolean z, int i3) {
            return C0548f.m3484a(i, i2, z, i3);
        }

        public boolean mo447a(Object obj, Object obj2) {
            return C0548f.m3487a(obj, obj2);
        }

        public Object mo436a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return C0548f.m3483a(i, i2, i3, i4, z, z2);
        }

        public void mo445a(Object obj, CharSequence charSequence) {
            C0548f.m3486a(obj, charSequence);
        }
    }

    static class C0543c extends C0542b {
        C0543c() {
        }
    }

    static class C0544d extends C0543c {
        C0544d() {
        }
    }

    public static class C0545l {
        final Object f2078a;

        public static C0545l m3424a(int i, int i2, boolean z, int i3) {
            return new C0545l(C0547e.f2080a.mo437a(i, i2, z, i3));
        }

        private C0545l(Object obj) {
            this.f2078a = obj;
        }
    }

    public static class C0546m {
        private final Object f2079a;

        public static C0546m m3425a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new C0546m(C0547e.f2080a.mo436a(i, i2, i3, i4, z, z2));
        }

        private C0546m(Object obj) {
            this.f2079a = obj;
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            f2080a = new C0544d();
        } else if (VERSION.SDK_INT >= 22) {
            f2080a = new C0543c();
        } else if (VERSION.SDK_INT >= 21) {
            f2080a = new C0542b();
        } else if (VERSION.SDK_INT >= 19) {
            f2080a = new C0541j();
        } else if (VERSION.SDK_INT >= 18) {
            f2080a = new C0540i();
        } else if (VERSION.SDK_INT >= 17) {
            f2080a = new C0539h();
        } else if (VERSION.SDK_INT >= 16) {
            f2080a = new C0538g();
        } else if (VERSION.SDK_INT >= 14) {
            f2080a = new C0537e();
        } else {
            f2080a = new C0536k();
        }
    }

    static C0547e m3429a(Object obj) {
        if (obj != null) {
            return new C0547e(obj);
        }
        return null;
    }

    public C0547e(Object obj) {
        this.f2081b = obj;
    }

    public Object m3433a() {
        return this.f2081b;
    }

    public static C0547e m3428a(View view) {
        return C0547e.m3429a(f2080a.mo439a(view));
    }

    public static C0547e m3430b() {
        return C0547e.m3429a(f2080a.mo435a());
    }

    public static C0547e m3427a(C0547e c0547e) {
        return C0547e.m3429a(f2080a.mo440a(c0547e.f2081b));
    }

    public void m3441b(View view) {
        f2080a.mo457c(this.f2081b, view);
    }

    public void m3436a(View view, int i) {
        f2080a.mo444a(this.f2081b, view, i);
    }

    public int m3446c() {
        return f2080a.mo455c(this.f2081b);
    }

    public void m3448c(View view) {
        f2080a.mo443a(this.f2081b, view);
    }

    public void m3442b(View view, int i) {
        f2080a.mo451b(this.f2081b, view, i);
    }

    public int m3452d() {
        return f2080a.mo448b(this.f2081b);
    }

    public void m3434a(int i) {
        f2080a.mo441a(this.f2081b, i);
    }

    public boolean m3439a(C0534a c0534a) {
        return f2080a.mo447a(this.f2081b, c0534a.f2077w);
    }

    public void m3454d(View view) {
        f2080a.mo450b(this.f2081b, view);
    }

    public void m3435a(Rect rect) {
        f2080a.mo442a(this.f2081b, rect);
    }

    public void m3440b(Rect rect) {
        f2080a.mo456c(this.f2081b, rect);
    }

    public void m3447c(Rect rect) {
        f2080a.mo449b(this.f2081b, rect);
    }

    public void m3453d(Rect rect) {
        f2080a.mo462d(this.f2081b, rect);
    }

    public boolean m3460e() {
        return f2080a.mo474h(this.f2081b);
    }

    public boolean m3462f() {
        return f2080a.mo476i(this.f2081b);
    }

    public boolean m3464g() {
        return f2080a.mo480l(this.f2081b);
    }

    public void m3438a(boolean z) {
        f2080a.mo460c(this.f2081b, z);
    }

    public boolean m3466h() {
        return f2080a.mo481m(this.f2081b);
    }

    public void m3445b(boolean z) {
        f2080a.mo465d(this.f2081b, z);
    }

    public boolean m3468i() {
        return f2080a.mo487s(this.f2081b);
    }

    public void m3451c(boolean z) {
        f2080a.mo473h(this.f2081b, z);
    }

    public boolean m3470j() {
        return f2080a.mo488t(this.f2081b);
    }

    public void m3456d(boolean z) {
        f2080a.mo475i(this.f2081b, z);
    }

    public boolean m3471k() {
        return f2080a.mo485q(this.f2081b);
    }

    public void m3459e(boolean z) {
        f2080a.mo472g(this.f2081b, z);
    }

    public boolean m3472l() {
        return f2080a.mo478j(this.f2081b);
    }

    public void m3461f(boolean z) {
        f2080a.mo446a(this.f2081b, z);
    }

    public boolean m3473m() {
        return f2080a.mo482n(this.f2081b);
    }

    public void m3463g(boolean z) {
        f2080a.mo468e(this.f2081b, z);
    }

    public boolean m3474n() {
        return f2080a.mo479k(this.f2081b);
    }

    public void m3465h(boolean z) {
        f2080a.mo454b(this.f2081b, z);
    }

    public boolean m3475o() {
        return f2080a.mo483o(this.f2081b);
    }

    public boolean m3476p() {
        return f2080a.mo484p(this.f2081b);
    }

    public void m3467i(boolean z) {
        f2080a.mo470f(this.f2081b, z);
    }

    public CharSequence m3477q() {
        return f2080a.mo469f(this.f2081b);
    }

    public void m3437a(CharSequence charSequence) {
        f2080a.mo464d(this.f2081b, charSequence);
    }

    public CharSequence m3478r() {
        return f2080a.mo461d(this.f2081b);
    }

    public void m3443b(CharSequence charSequence) {
        f2080a.mo452b(this.f2081b, charSequence);
    }

    public CharSequence m3479s() {
        return f2080a.mo471g(this.f2081b);
    }

    public void m3449c(CharSequence charSequence) {
        f2080a.mo467e(this.f2081b, charSequence);
    }

    public CharSequence m3480t() {
        return f2080a.mo466e(this.f2081b);
    }

    public void m3455d(CharSequence charSequence) {
        f2080a.mo458c(this.f2081b, charSequence);
    }

    public void m3481u() {
        f2080a.mo486r(this.f2081b);
    }

    public String m3482v() {
        return f2080a.mo489u(this.f2081b);
    }

    public void m3444b(Object obj) {
        f2080a.mo453b(this.f2081b, ((C0545l) obj).f2078a);
    }

    public void m3450c(Object obj) {
        f2080a.mo459c(this.f2081b, ((C0546m) obj).f2079a);
    }

    public void m3469j(boolean z) {
        f2080a.mo477j(this.f2081b, z);
    }

    public void m3458e(CharSequence charSequence) {
        f2080a.mo445a(this.f2081b, charSequence);
    }

    public void m3457e(View view) {
        f2080a.mo463d(this.f2081b, view);
    }

    public int hashCode() {
        return this.f2081b == null ? 0 : this.f2081b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0547e c0547e = (C0547e) obj;
        if (this.f2081b == null) {
            if (c0547e.f2081b != null) {
                return false;
            }
            return true;
        } else if (this.f2081b.equals(c0547e.f2081b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m3435a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m3447c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m3477q());
        stringBuilder.append("; className: ").append(m3478r());
        stringBuilder.append("; text: ").append(m3479s());
        stringBuilder.append("; contentDescription: ").append(m3480t());
        stringBuilder.append("; viewId: ").append(m3482v());
        stringBuilder.append("; checkable: ").append(m3460e());
        stringBuilder.append("; checked: ").append(m3462f());
        stringBuilder.append("; focusable: ").append(m3464g());
        stringBuilder.append("; focused: ").append(m3466h());
        stringBuilder.append("; selected: ").append(m3471k());
        stringBuilder.append("; clickable: ").append(m3472l());
        stringBuilder.append("; longClickable: ").append(m3473m());
        stringBuilder.append("; enabled: ").append(m3474n());
        stringBuilder.append("; password: ").append(m3475o());
        stringBuilder.append("; scrollable: " + m3476p());
        stringBuilder.append("; [");
        int d = m3452d();
        while (d != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(d);
            d &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0547e.m3431b(numberOfTrailingZeros));
            if (d != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m3431b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case DfuBaseService.ERROR_REMOTE_MASK /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case DfuBaseService.ERROR_CONNECTION_MASK /*16384*/:
                return "ACTION_COPY";
            case DfuBaseService.ERROR_CONNECTION_STATE_MASK /*32768*/:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
