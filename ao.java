package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p017e.C0466c;
import android.support.v4.view.p025a.C0547e;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class ao {
    static final C0580n f2102a;

    interface C0580n {
        boolean mo515A(View view);

        void mo516B(View view);

        boolean mo517C(View view);

        boolean mo518D(View view);

        ColorStateList mo519E(View view);

        Mode mo520F(View view);

        void mo521G(View view);

        boolean mo522H(View view);

        float mo523I(View view);

        boolean mo524J(View view);

        boolean mo525K(View view);

        int mo526a(int i, int i2);

        int mo527a(int i, int i2, int i3);

        int mo528a(View view);

        bz mo529a(View view, bz bzVar);

        void mo530a(View view, float f);

        void mo531a(View view, int i, int i2);

        void mo532a(View view, int i, int i2, int i3, int i4);

        void mo533a(View view, int i, Paint paint);

        void mo534a(View view, ColorStateList colorStateList);

        void mo535a(View view, Mode mode);

        void mo536a(View view, C0547e c0547e);

        void mo537a(View view, ai aiVar);

        void mo538a(View view, C0249b c0249b);

        void mo539a(View view, AccessibilityEvent accessibilityEvent);

        void mo540a(View view, Runnable runnable);

        void mo541a(View view, Runnable runnable, long j);

        void mo542a(View view, boolean z);

        void mo543a(ViewGroup viewGroup, boolean z);

        boolean mo544a(View view, int i);

        boolean mo545a(View view, int i, Bundle bundle);

        bz mo546b(View view, bz bzVar);

        void mo547b(View view, float f);

        void mo548b(View view, boolean z);

        boolean mo549b(View view);

        boolean mo550b(View view, int i);

        void mo551c(View view, float f);

        void mo552c(View view, int i);

        void mo553c(View view, boolean z);

        boolean mo554c(View view);

        void mo555d(View view);

        void mo556d(View view, float f);

        void mo557d(View view, int i);

        int mo558e(View view);

        void mo559e(View view, float f);

        void mo560e(View view, int i);

        float mo561f(View view);

        void mo562f(View view, float f);

        void mo563f(View view, int i);

        int mo564g(View view);

        int mo565h(View view);

        ViewParent mo566i(View view);

        int mo567j(View view);

        int mo568k(View view);

        int mo569l(View view);

        int mo570m(View view);

        int mo571n(View view);

        boolean mo572o(View view);

        float mo573p(View view);

        float mo574q(View view);

        float mo575r(View view);

        Matrix mo576s(View view);

        int mo577t(View view);

        int mo578u(View view);

        bo mo579v(View view);

        int mo580w(View view);

        void mo581x(View view);

        float mo582y(View view);
    }

    static class C0581b implements C0580n {
        WeakHashMap<View, bo> f2099a = null;

        C0581b() {
        }

        public boolean mo544a(View view, int i) {
            return (view instanceof ak) && m3741a((ak) view, i);
        }

        public boolean mo550b(View view, int i) {
            return (view instanceof ak) && m3742b((ak) view, i);
        }

        public int mo528a(View view) {
            return 2;
        }

        public void mo538a(View view, C0249b c0249b) {
        }

        public boolean mo549b(View view) {
            return false;
        }

        public void mo539a(View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo536a(View view, C0547e c0547e) {
        }

        public boolean mo554c(View view) {
            return false;
        }

        public void mo555d(View view) {
            view.invalidate();
        }

        public void mo540a(View view, Runnable runnable) {
            view.postDelayed(runnable, mo583a());
        }

        public void mo541a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo583a() + j);
        }

        long mo583a() {
            return 10;
        }

        public int mo558e(View view) {
            return 0;
        }

        public void mo552c(View view, int i) {
        }

        public boolean mo545a(View view, int i, Bundle bundle) {
            return false;
        }

        public float mo561f(View view) {
            return 1.0f;
        }

        public void mo533a(View view, int i, Paint paint) {
        }

        public int mo564g(View view) {
            return 0;
        }

        public int mo565h(View view) {
            return 0;
        }

        public ViewParent mo566i(View view) {
            return view.getParent();
        }

        public int mo527a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int mo567j(View view) {
            return view.getMeasuredWidth();
        }

        public int mo568k(View view) {
            return view.getMeasuredHeight();
        }

        public int mo569l(View view) {
            return 0;
        }

        public void mo557d(View view, int i) {
        }

        public int mo570m(View view) {
            return view.getPaddingLeft();
        }

        public int mo571n(View view) {
            return view.getPaddingRight();
        }

        public void mo532a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public boolean mo572o(View view) {
            return true;
        }

        public float mo573p(View view) {
            return 0.0f;
        }

        public float mo574q(View view) {
            return 0.0f;
        }

        public float mo575r(View view) {
            return 0.0f;
        }

        public Matrix mo576s(View view) {
            return null;
        }

        public int mo577t(View view) {
            return ap.m3964d(view);
        }

        public int mo578u(View view) {
            return ap.m3965e(view);
        }

        public bo mo579v(View view) {
            return new bo(view);
        }

        public void mo530a(View view, float f) {
        }

        public void mo547b(View view, float f) {
        }

        public void mo551c(View view, float f) {
        }

        public void mo556d(View view, float f) {
        }

        public void mo559e(View view, float f) {
        }

        public int mo580w(View view) {
            return 0;
        }

        public void mo581x(View view) {
        }

        public void mo562f(View view, float f) {
        }

        public float mo582y(View view) {
            return 0.0f;
        }

        public float mo584z(View view) {
            return 0.0f;
        }

        public void mo543a(ViewGroup viewGroup, boolean z) {
        }

        public boolean mo515A(View view) {
            return false;
        }

        public void mo542a(View view, boolean z) {
        }

        public void mo516B(View view) {
        }

        public void mo537a(View view, ai aiVar) {
        }

        public bz mo529a(View view, bz bzVar) {
            return bzVar;
        }

        public bz mo546b(View view, bz bzVar) {
            return bzVar;
        }

        public void mo548b(View view, boolean z) {
        }

        public void mo553c(View view, boolean z) {
        }

        public boolean mo517C(View view) {
            return false;
        }

        public boolean mo518D(View view) {
            if (view instanceof ae) {
                return ((ae) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public ColorStateList mo519E(View view) {
            return ap.m3957a(view);
        }

        public void mo534a(View view, ColorStateList colorStateList) {
            ap.m3959a(view, colorStateList);
        }

        public void mo535a(View view, Mode mode) {
            ap.m3960a(view, mode);
        }

        public Mode mo520F(View view) {
            return ap.m3961b(view);
        }

        private boolean m3741a(ak akVar, int i) {
            int computeHorizontalScrollOffset = akVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = akVar.computeHorizontalScrollRange() - akVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeHorizontalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        private boolean m3742b(ak akVar, int i) {
            int computeVerticalScrollOffset = akVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = akVar.computeVerticalScrollRange() - akVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeVerticalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        public void mo521G(View view) {
            if (view instanceof ae) {
                ((ae) view).stopNestedScroll();
            }
        }

        public boolean mo522H(View view) {
            return ap.m3963c(view);
        }

        public int mo526a(int i, int i2) {
            return i | i2;
        }

        public float mo523I(View view) {
            return mo584z(view) + mo582y(view);
        }

        public boolean mo524J(View view) {
            return ap.m3966f(view);
        }

        public boolean mo525K(View view) {
            return false;
        }

        public void mo531a(View view, int i, int i2) {
        }

        public void mo560e(View view, int i) {
            ap.m3962b(view, i);
        }

        public void mo563f(View view, int i) {
            ap.m3958a(view, i);
        }
    }

    static class C0582c extends C0581b {
        C0582c() {
        }

        public void mo543a(ViewGroup viewGroup, boolean z) {
            aq.m3967a(viewGroup, z);
        }
    }

    static class C0583d extends C0582c {
        C0583d() {
        }

        public int mo528a(View view) {
            return ar.m3968a(view);
        }
    }

    static class C0584e extends C0583d {
        C0584e() {
        }

        long mo583a() {
            return as.m3972a();
        }

        public float mo561f(View view) {
            return as.m3969a(view);
        }

        public void mo533a(View view, int i, Paint paint) {
            as.m3975a(view, i, paint);
        }

        public int mo564g(View view) {
            return as.m3977b(view);
        }

        public int mo527a(int i, int i2, int i3) {
            return as.m3971a(i, i2, i3);
        }

        public int mo567j(View view) {
            return as.m3981c(view);
        }

        public int mo568k(View view) {
            return as.m3983d(view);
        }

        public int mo569l(View view) {
            return as.m3985e(view);
        }

        public float mo573p(View view) {
            return as.m3987f(view);
        }

        public float mo574q(View view) {
            return as.m3988g(view);
        }

        public Matrix mo576s(View view) {
            return as.m3990i(view);
        }

        public void mo530a(View view, float f) {
            as.m3973a(view, f);
        }

        public void mo547b(View view, float f) {
            as.m3978b(view, f);
        }

        public void mo551c(View view, float f) {
            as.m3982c(view, f);
        }

        public void mo556d(View view, float f) {
            as.m3984d(view, f);
        }

        public void mo559e(View view, float f) {
            as.m3986e(view, f);
        }

        public float mo575r(View view) {
            return as.m3989h(view);
        }

        public void mo516B(View view) {
            as.m3991j(view);
        }

        public void mo548b(View view, boolean z) {
            as.m3976a(view, z);
        }

        public void mo553c(View view, boolean z) {
            as.m3980b(view, z);
        }

        public int mo526a(int i, int i2) {
            return as.m3970a(i, i2);
        }

        public void mo560e(View view, int i) {
            as.m3979b(view, i);
        }

        public void mo563f(View view, int i) {
            as.m3974a(view, i);
        }
    }

    static class C0585g extends C0584e {
        static Field f2100b;
        static boolean f2101c = false;

        C0585g() {
        }

        public boolean mo544a(View view, int i) {
            return at.m3996a(view, i);
        }

        public boolean mo550b(View view, int i) {
            return at.m3998b(view, i);
        }

        public void mo539a(View view, AccessibilityEvent accessibilityEvent) {
            at.m3993a(view, accessibilityEvent);
        }

        public void mo536a(View view, C0547e c0547e) {
            at.m3997b(view, c0547e.m3433a());
        }

        public void mo538a(View view, C0249b c0249b) {
            Object obj;
            if (c0249b == null) {
                obj = null;
            } else {
                obj = c0249b.m1877a();
            }
            at.m3994a(view, obj);
        }

        public boolean mo549b(View view) {
            boolean z = true;
            if (f2101c) {
                return false;
            }
            if (f2100b == null) {
                try {
                    f2100b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f2100b.setAccessible(true);
                } catch (Throwable th) {
                    f2101c = true;
                    return false;
                }
            }
            try {
                if (f2100b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f2101c = true;
                return false;
            }
        }

        public bo mo579v(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            bo boVar = (bo) this.a.get(view);
            if (boVar != null) {
                return boVar;
            }
            boVar = new bo(view);
            this.a.put(view, boVar);
            return boVar;
        }

        public void mo542a(View view, boolean z) {
            at.m3995a(view, z);
        }
    }

    static class C0586f extends C0585g {
        C0586f() {
        }

        public boolean mo525K(View view) {
            return au.m3999a(view);
        }
    }

    static class C0587h extends C0586f {
        C0587h() {
        }

        public boolean mo554c(View view) {
            return av.m4003a(view);
        }

        public void mo555d(View view) {
            av.m4005b(view);
        }

        public void mo540a(View view, Runnable runnable) {
            av.m4001a(view, runnable);
        }

        public void mo541a(View view, Runnable runnable, long j) {
            av.m4002a(view, runnable, j);
        }

        public int mo558e(View view) {
            return av.m4006c(view);
        }

        public void mo552c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            av.m4000a(view, i);
        }

        public boolean mo545a(View view, int i, Bundle bundle) {
            return av.m4004a(view, i, bundle);
        }

        public ViewParent mo566i(View view) {
            return av.m4007d(view);
        }

        public int mo577t(View view) {
            return av.m4008e(view);
        }

        public int mo578u(View view) {
            return av.m4009f(view);
        }

        public void mo581x(View view) {
            av.m4010g(view);
        }

        public boolean mo515A(View view) {
            return av.m4011h(view);
        }

        public boolean mo572o(View view) {
            return av.m4012i(view);
        }
    }

    static class C0588i extends C0587h {
        C0588i() {
        }

        public int mo565h(View view) {
            return aw.m4013a(view);
        }

        public int mo570m(View view) {
            return aw.m4015b(view);
        }

        public int mo571n(View view) {
            return aw.m4016c(view);
        }

        public void mo532a(View view, int i, int i2, int i3, int i4) {
            aw.m4014a(view, i, i2, i3, i4);
        }

        public int mo580w(View view) {
            return aw.m4017d(view);
        }

        public boolean mo517C(View view) {
            return aw.m4018e(view);
        }
    }

    static class C0589j extends C0588i {
        C0589j() {
        }
    }

    static class C0590k extends C0589j {
        C0590k() {
        }

        public void mo557d(View view, int i) {
            ax.m4019a(view, i);
        }

        public void mo552c(View view, int i) {
            av.m4000a(view, i);
        }

        public boolean mo522H(View view) {
            return ax.m4020a(view);
        }

        public boolean mo524J(View view) {
            return ax.m4021b(view);
        }
    }

    static class C0591l extends C0590k {
        C0591l() {
        }

        public void mo581x(View view) {
            ay.m4024a(view);
        }

        public void mo562f(View view, float f) {
            ay.m4025a(view, f);
        }

        public float mo582y(View view) {
            return ay.m4030b(view);
        }

        public float mo584z(View view) {
            return ay.m4033c(view);
        }

        public void mo537a(View view, ai aiVar) {
            ay.m4029a(view, aiVar);
        }

        public boolean mo518D(View view) {
            return ay.m4036f(view);
        }

        public void mo521G(View view) {
            ay.m4037g(view);
        }

        public ColorStateList mo519E(View view) {
            return ay.m4034d(view);
        }

        public void mo534a(View view, ColorStateList colorStateList) {
            ay.m4027a(view, colorStateList);
        }

        public void mo535a(View view, Mode mode) {
            ay.m4028a(view, mode);
        }

        public Mode mo520F(View view) {
            return ay.m4035e(view);
        }

        public bz mo529a(View view, bz bzVar) {
            return ay.m4023a(view, bzVar);
        }

        public bz mo546b(View view, bz bzVar) {
            return ay.m4031b(view, bzVar);
        }

        public float mo523I(View view) {
            return ay.m4038h(view);
        }

        public void mo560e(View view, int i) {
            ay.m4032b(view, i);
        }

        public void mo563f(View view, int i) {
            ay.m4026a(view, i);
        }
    }

    static class C0592m extends C0591l {
        C0592m() {
        }

        public void mo531a(View view, int i, int i2) {
            ba.m4077a(view, i, i2);
        }

        public void mo560e(View view, int i) {
            ba.m4078b(view, i);
        }

        public void mo563f(View view, int i) {
            ba.m4076a(view, i);
        }
    }

    static class C0593a extends C0592m {
        C0593a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (C0466c.m3056a()) {
            f2102a = new C0593a();
        } else if (i >= 23) {
            f2102a = new C0592m();
        } else if (i >= 21) {
            f2102a = new C0591l();
        } else if (i >= 19) {
            f2102a = new C0590k();
        } else if (i >= 18) {
            f2102a = new C0589j();
        } else if (i >= 17) {
            f2102a = new C0588i();
        } else if (i >= 16) {
            f2102a = new C0587h();
        } else if (i >= 15) {
            f2102a = new C0586f();
        } else if (i >= 14) {
            f2102a = new C0585g();
        } else if (i >= 11) {
            f2102a = new C0584e();
        } else if (i >= 9) {
            f2102a = new C0583d();
        } else if (i >= 7) {
            f2102a = new C0582c();
        } else {
            f2102a = new C0581b();
        }
    }

    public static boolean m3917a(View view, int i) {
        return f2102a.mo544a(view, i);
    }

    public static boolean m3923b(View view, int i) {
        return f2102a.mo550b(view, i);
    }

    public static int m3901a(View view) {
        return f2102a.mo528a(view);
    }

    public static void m3912a(View view, AccessibilityEvent accessibilityEvent) {
        f2102a.mo539a(view, accessibilityEvent);
    }

    public static void m3909a(View view, C0547e c0547e) {
        f2102a.mo536a(view, c0547e);
    }

    public static void m3911a(View view, C0249b c0249b) {
        f2102a.mo538a(view, c0249b);
    }

    public static boolean m3922b(View view) {
        return f2102a.mo549b(view);
    }

    public static boolean m3927c(View view) {
        return f2102a.mo554c(view);
    }

    public static void m3928d(View view) {
        f2102a.mo555d(view);
    }

    public static void m3913a(View view, Runnable runnable) {
        f2102a.mo540a(view, runnable);
    }

    public static void m3914a(View view, Runnable runnable, long j) {
        f2102a.mo541a(view, runnable, j);
    }

    public static int m3931e(View view) {
        return f2102a.mo558e(view);
    }

    public static void m3925c(View view, int i) {
        f2102a.mo552c(view, i);
    }

    public static boolean m3918a(View view, int i, Bundle bundle) {
        return f2102a.mo545a(view, i, bundle);
    }

    public static float m3934f(View view) {
        return f2102a.mo561f(view);
    }

    public static void m3906a(View view, int i, Paint paint) {
        f2102a.mo533a(view, i, paint);
    }

    public static int m3937g(View view) {
        return f2102a.mo564g(view);
    }

    public static int m3938h(View view) {
        return f2102a.mo565h(view);
    }

    public static ViewParent m3939i(View view) {
        return f2102a.mo566i(view);
    }

    public static int m3900a(int i, int i2, int i3) {
        return f2102a.mo527a(i, i2, i3);
    }

    public static int m3940j(View view) {
        return f2102a.mo567j(view);
    }

    public static int m3941k(View view) {
        return f2102a.mo568k(view);
    }

    public static int m3942l(View view) {
        return f2102a.mo569l(view);
    }

    public static int m3899a(int i, int i2) {
        return f2102a.mo526a(i, i2);
    }

    public static void m3930d(View view, int i) {
        f2102a.mo557d(view, i);
    }

    public static int m3943m(View view) {
        return f2102a.mo570m(view);
    }

    public static int m3944n(View view) {
        return f2102a.mo571n(view);
    }

    public static void m3905a(View view, int i, int i2, int i3, int i4) {
        f2102a.mo532a(view, i, i2, i3, i4);
    }

    public static float m3945o(View view) {
        return f2102a.mo573p(view);
    }

    public static float m3946p(View view) {
        return f2102a.mo574q(view);
    }

    public static Matrix m3947q(View view) {
        return f2102a.mo576s(view);
    }

    public static int m3948r(View view) {
        return f2102a.mo577t(view);
    }

    public static int m3949s(View view) {
        return f2102a.mo578u(view);
    }

    public static bo m3950t(View view) {
        return f2102a.mo579v(view);
    }

    public static void m3903a(View view, float f) {
        f2102a.mo530a(view, f);
    }

    public static void m3920b(View view, float f) {
        f2102a.mo547b(view, f);
    }

    public static void m3924c(View view, float f) {
        f2102a.mo551c(view, f);
    }

    public static void m3929d(View view, float f) {
        f2102a.mo556d(view, f);
    }

    public static void m3932e(View view, float f) {
        f2102a.mo559e(view, f);
    }

    public static float m3951u(View view) {
        return f2102a.mo575r(view);
    }

    public static void m3935f(View view, float f) {
        f2102a.mo562f(view, f);
    }

    public static float m3952v(View view) {
        return f2102a.mo582y(view);
    }

    public static int m3953w(View view) {
        return f2102a.mo580w(view);
    }

    public static void m3954x(View view) {
        f2102a.mo581x(view);
    }

    public static void m3916a(ViewGroup viewGroup, boolean z) {
        f2102a.mo543a(viewGroup, z);
    }

    public static boolean m3955y(View view) {
        return f2102a.mo515A(view);
    }

    public static void m3915a(View view, boolean z) {
        f2102a.mo542a(view, z);
    }

    public static void m3956z(View view) {
        f2102a.mo516B(view);
    }

    public static void m3910a(View view, ai aiVar) {
        f2102a.mo537a(view, aiVar);
    }

    public static bz m3902a(View view, bz bzVar) {
        return f2102a.mo529a(view, bzVar);
    }

    public static bz m3919b(View view, bz bzVar) {
        return f2102a.mo546b(view, bzVar);
    }

    public static void m3921b(View view, boolean z) {
        f2102a.mo548b(view, z);
    }

    public static void m3926c(View view, boolean z) {
        f2102a.mo553c(view, z);
    }

    public static boolean m3889A(View view) {
        return f2102a.mo572o(view);
    }

    public static boolean m3890B(View view) {
        return f2102a.mo517C(view);
    }

    public static ColorStateList m3891C(View view) {
        return f2102a.mo519E(view);
    }

    public static void m3907a(View view, ColorStateList colorStateList) {
        f2102a.mo534a(view, colorStateList);
    }

    public static Mode m3892D(View view) {
        return f2102a.mo520F(view);
    }

    public static void m3908a(View view, Mode mode) {
        f2102a.mo535a(view, mode);
    }

    public static boolean m3893E(View view) {
        return f2102a.mo518D(view);
    }

    public static void m3894F(View view) {
        f2102a.mo521G(view);
    }

    public static boolean m3895G(View view) {
        return f2102a.mo522H(view);
    }

    public static float m3896H(View view) {
        return f2102a.mo523I(view);
    }

    public static void m3933e(View view, int i) {
        f2102a.mo563f(view, i);
    }

    public static void m3936f(View view, int i) {
        f2102a.mo560e(view, i);
    }

    public static boolean m3897I(View view) {
        return f2102a.mo524J(view);
    }

    public static boolean m3898J(View view) {
        return f2102a.mo525K(view);
    }

    public static void m3904a(View view, int i, int i2) {
        f2102a.mo531a(view, i, i2);
    }
}
