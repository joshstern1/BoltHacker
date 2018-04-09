package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class C0441a {
    static final C0433b f1895a;

    interface C0433b {
        void mo391a(Drawable drawable);

        void mo392a(Drawable drawable, float f, float f2);

        void mo393a(Drawable drawable, int i);

        void mo394a(Drawable drawable, int i, int i2, int i3, int i4);

        void mo395a(Drawable drawable, ColorStateList colorStateList);

        void mo396a(Drawable drawable, Theme theme);

        void mo397a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException;

        void mo398a(Drawable drawable, Mode mode);

        void mo399a(Drawable drawable, boolean z);

        boolean mo400b(Drawable drawable);

        boolean mo401b(Drawable drawable, int i);

        Drawable mo402c(Drawable drawable);

        int mo403d(Drawable drawable);

        int mo404e(Drawable drawable);

        boolean mo405f(Drawable drawable);

        ColorFilter mo406g(Drawable drawable);
    }

    static class C0434a implements C0433b {
        C0434a() {
        }

        public void mo391a(Drawable drawable) {
        }

        public void mo399a(Drawable drawable, boolean z) {
        }

        public boolean mo400b(Drawable drawable) {
            return false;
        }

        public void mo392a(Drawable drawable, float f, float f2) {
        }

        public void mo394a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo393a(Drawable drawable, int i) {
            C0443c.m3008a(drawable, i);
        }

        public void mo395a(Drawable drawable, ColorStateList colorStateList) {
            C0443c.m3009a(drawable, colorStateList);
        }

        public void mo398a(Drawable drawable, Mode mode) {
            C0443c.m3011a(drawable, mode);
        }

        public Drawable mo402c(Drawable drawable) {
            return C0443c.m3007a(drawable);
        }

        public boolean mo401b(Drawable drawable, int i) {
            return false;
        }

        public int mo403d(Drawable drawable) {
            return 0;
        }

        public int mo404e(Drawable drawable) {
            return 0;
        }

        public void mo396a(Drawable drawable, Theme theme) {
        }

        public boolean mo405f(Drawable drawable) {
            return false;
        }

        public ColorFilter mo406g(Drawable drawable) {
            return null;
        }

        public void mo397a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
            C0443c.m3010a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class C0435c extends C0434a {
        C0435c() {
        }

        public Drawable mo402c(Drawable drawable) {
            return C0444d.m3012a(drawable);
        }
    }

    static class C0436d extends C0435c {
        C0436d() {
        }

        public void mo391a(Drawable drawable) {
            C0445e.m3013a(drawable);
        }

        public Drawable mo402c(Drawable drawable) {
            return C0445e.m3014b(drawable);
        }
    }

    static class C0437e extends C0436d {
        C0437e() {
        }

        public boolean mo401b(Drawable drawable, int i) {
            return C0446f.m3016a(drawable, i);
        }

        public int mo403d(Drawable drawable) {
            int a = C0446f.m3015a(drawable);
            return a >= 0 ? a : 0;
        }
    }

    static class C0438f extends C0437e {
        C0438f() {
        }

        public void mo399a(Drawable drawable, boolean z) {
            C0447g.m3017a(drawable, z);
        }

        public boolean mo400b(Drawable drawable) {
            return C0447g.m3018a(drawable);
        }

        public Drawable mo402c(Drawable drawable) {
            return C0447g.m3019b(drawable);
        }

        public int mo404e(Drawable drawable) {
            return C0447g.m3020c(drawable);
        }
    }

    static class C0439g extends C0438f {
        C0439g() {
        }

        public void mo392a(Drawable drawable, float f, float f2) {
            C0448h.m3022a(drawable, f, f2);
        }

        public void mo394a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0448h.m3024a(drawable, i, i2, i3, i4);
        }

        public void mo393a(Drawable drawable, int i) {
            C0448h.m3023a(drawable, i);
        }

        public void mo395a(Drawable drawable, ColorStateList colorStateList) {
            C0448h.m3025a(drawable, colorStateList);
        }

        public void mo398a(Drawable drawable, Mode mode) {
            C0448h.m3028a(drawable, mode);
        }

        public Drawable mo402c(Drawable drawable) {
            return C0448h.m3021a(drawable);
        }

        public void mo396a(Drawable drawable, Theme theme) {
            C0448h.m3026a(drawable, theme);
        }

        public boolean mo405f(Drawable drawable) {
            return C0448h.m3029b(drawable);
        }

        public ColorFilter mo406g(Drawable drawable) {
            return C0448h.m3030c(drawable);
        }

        public void mo397a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
            C0448h.m3027a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class C0440h extends C0439g {
        C0440h() {
        }

        public boolean mo401b(Drawable drawable, int i) {
            return C0442b.m3006a(drawable, i);
        }

        public int mo403d(Drawable drawable) {
            return C0442b.m3005a(drawable);
        }

        public Drawable mo402c(Drawable drawable) {
            return drawable;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1895a = new C0440h();
        } else if (i >= 21) {
            f1895a = new C0439g();
        } else if (i >= 19) {
            f1895a = new C0438f();
        } else if (i >= 17) {
            f1895a = new C0437e();
        } else if (i >= 11) {
            f1895a = new C0436d();
        } else if (i >= 5) {
            f1895a = new C0435c();
        } else {
            f1895a = new C0434a();
        }
    }

    public static void m2988a(Drawable drawable) {
        f1895a.mo391a(drawable);
    }

    public static void m2996a(Drawable drawable, boolean z) {
        f1895a.mo399a(drawable, z);
    }

    public static boolean m2997b(Drawable drawable) {
        return f1895a.mo400b(drawable);
    }

    public static void m2989a(Drawable drawable, float f, float f2) {
        f1895a.mo392a(drawable, f, f2);
    }

    public static void m2991a(Drawable drawable, int i, int i2, int i3, int i4) {
        f1895a.mo394a(drawable, i, i2, i3, i4);
    }

    public static void m2990a(Drawable drawable, int i) {
        f1895a.mo393a(drawable, i);
    }

    public static void m2992a(Drawable drawable, ColorStateList colorStateList) {
        f1895a.mo395a(drawable, colorStateList);
    }

    public static void m2995a(Drawable drawable, Mode mode) {
        f1895a.mo398a(drawable, mode);
    }

    public static int m2999c(Drawable drawable) {
        return f1895a.mo404e(drawable);
    }

    public static void m2993a(Drawable drawable, Theme theme) {
        f1895a.mo396a(drawable, theme);
    }

    public static boolean m3000d(Drawable drawable) {
        return f1895a.mo405f(drawable);
    }

    public static ColorFilter m3001e(Drawable drawable) {
        return f1895a.mo406g(drawable);
    }

    public static void m2994a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        f1895a.mo397a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable m3002f(Drawable drawable) {
        return f1895a.mo402c(drawable);
    }

    public static <T extends Drawable> T m3003g(Drawable drawable) {
        if (drawable instanceof C0449i) {
            return ((C0449i) drawable).mo408a();
        }
        return drawable;
    }

    public static boolean m2998b(Drawable drawable, int i) {
        return f1895a.mo401b(drawable, i);
    }

    public static int m3004h(Drawable drawable) {
        return f1895a.mo403d(drawable);
    }

    private C0441a() {
    }
}
