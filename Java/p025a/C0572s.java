package android.support.v4.view.p025a;

import android.os.Build.VERSION;
import android.view.View;
import java.util.Collections;
import java.util.List;

public class C0572s {
    private static final C0567c f2090a;
    private final Object f2091b;

    interface C0567c {
        List<CharSequence> mo498a(Object obj);

        void mo499a(Object obj, int i);

        void mo500a(Object obj, View view, int i);

        void mo501a(Object obj, CharSequence charSequence);

        void mo502a(Object obj, boolean z);

        void mo503b(Object obj, int i);

        void mo504b(Object obj, CharSequence charSequence);

        void mo505b(Object obj, boolean z);

        void mo506c(Object obj, int i);

        void mo507c(Object obj, boolean z);

        void mo508d(Object obj, int i);

        void mo509d(Object obj, boolean z);

        void mo510e(Object obj, int i);

        void mo511f(Object obj, int i);

        void mo512g(Object obj, int i);
    }

    static class C0568e implements C0567c {
        C0568e() {
        }

        public List<CharSequence> mo498a(Object obj) {
            return Collections.emptyList();
        }

        public void mo502a(Object obj, boolean z) {
        }

        public void mo501a(Object obj, CharSequence charSequence) {
        }

        public void mo504b(Object obj, CharSequence charSequence) {
        }

        public void mo505b(Object obj, boolean z) {
        }

        public void mo499a(Object obj, int i) {
        }

        public void mo503b(Object obj, int i) {
        }

        public void mo511f(Object obj, int i) {
        }

        public void mo512g(Object obj, int i) {
        }

        public void mo507c(Object obj, boolean z) {
        }

        public void mo506c(Object obj, int i) {
        }

        public void mo508d(Object obj, int i) {
        }

        public void mo509d(Object obj, boolean z) {
        }

        public void mo500a(Object obj, View view, int i) {
        }

        public void mo510e(Object obj, int i) {
        }
    }

    static class C0569a extends C0568e {
        C0569a() {
        }

        public List<CharSequence> mo498a(Object obj) {
            return C0573t.m3625a(obj);
        }

        public void mo502a(Object obj, boolean z) {
            C0573t.m3628a(obj, z);
        }

        public void mo501a(Object obj, CharSequence charSequence) {
            C0573t.m3627a(obj, charSequence);
        }

        public void mo504b(Object obj, CharSequence charSequence) {
            C0573t.m3630b(obj, charSequence);
        }

        public void mo505b(Object obj, boolean z) {
            C0573t.m3631b(obj, z);
        }

        public void mo499a(Object obj, int i) {
            C0573t.m3626a(obj, i);
        }

        public void mo503b(Object obj, int i) {
            C0573t.m3629b(obj, i);
        }

        public void mo507c(Object obj, boolean z) {
            C0573t.m3633c(obj, z);
        }

        public void mo506c(Object obj, int i) {
            C0573t.m3632c(obj, i);
        }

        public void mo508d(Object obj, int i) {
            C0573t.m3634d(obj, i);
        }

        public void mo509d(Object obj, boolean z) {
            C0573t.m3635d(obj, z);
        }

        public void mo510e(Object obj, int i) {
            C0573t.m3636e(obj, i);
        }
    }

    static class C0570b extends C0569a {
        C0570b() {
        }

        public void mo511f(Object obj, int i) {
            C0574u.m3637a(obj, i);
        }

        public void mo512g(Object obj, int i) {
            C0574u.m3638b(obj, i);
        }
    }

    static class C0571d extends C0570b {
        C0571d() {
        }

        public void mo500a(Object obj, View view, int i) {
            C0575v.m3639a(obj, view, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f2090a = new C0571d();
        } else if (VERSION.SDK_INT >= 15) {
            f2090a = new C0570b();
        } else if (VERSION.SDK_INT >= 14) {
            f2090a = new C0569a();
        } else {
            f2090a = new C0568e();
        }
    }

    @Deprecated
    public C0572s(Object obj) {
        this.f2091b = obj;
    }

    public void m3612a(View view, int i) {
        f2090a.mo500a(this.f2091b, view, i);
    }

    public void m3614a(boolean z) {
        f2090a.mo502a(this.f2091b, z);
    }

    public void m3617b(boolean z) {
        f2090a.mo505b(this.f2091b, z);
    }

    public void m3619c(boolean z) {
        f2090a.mo507c(this.f2091b, z);
    }

    public void m3621d(boolean z) {
        f2090a.mo509d(this.f2091b, z);
    }

    public void m3611a(int i) {
        f2090a.mo503b(this.f2091b, i);
    }

    public void m3615b(int i) {
        f2090a.mo499a(this.f2091b, i);
    }

    public void m3618c(int i) {
        f2090a.mo510e(this.f2091b, i);
    }

    public void m3620d(int i) {
        f2090a.mo506c(this.f2091b, i);
    }

    public void m3622e(int i) {
        f2090a.mo508d(this.f2091b, i);
    }

    public void m3623f(int i) {
        f2090a.mo511f(this.f2091b, i);
    }

    public void m3624g(int i) {
        f2090a.mo512g(this.f2091b, i);
    }

    public void m3613a(CharSequence charSequence) {
        f2090a.mo501a(this.f2091b, charSequence);
    }

    public List<CharSequence> m3610a() {
        return f2090a.mo498a(this.f2091b);
    }

    public void m3616b(CharSequence charSequence) {
        f2090a.mo504b(this.f2091b, charSequence);
    }

    public int hashCode() {
        return this.f2091b == null ? 0 : this.f2091b.hashCode();
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
        C0572s c0572s = (C0572s) obj;
        if (this.f2091b == null) {
            if (c0572s.f2091b != null) {
                return false;
            }
            return true;
        } else if (this.f2091b.equals(c0572s.f2091b)) {
            return true;
        } else {
            return false;
        }
    }
}
