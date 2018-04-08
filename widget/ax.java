package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class ax {
    static final C0713f f2392a;

    interface C0713f {
        int mo700a(TextView textView);

        void mo701a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);
    }

    static class C0714b implements C0713f {
        C0714b() {
        }

        public void mo701a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        public int mo700a(TextView textView) {
            return ay.m4799a(textView);
        }
    }

    static class C0715e extends C0714b {
        C0715e() {
        }

        public int mo700a(TextView textView) {
            return az.m4802a(textView);
        }
    }

    static class C0716c extends C0715e {
        C0716c() {
        }

        public void mo701a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            ba.m4803a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    static class C0717d extends C0716c {
        C0717d() {
        }

        public void mo701a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            bb.m4804a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    static class C0718a extends C0717d {
        C0718a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f2392a = new C0718a();
        } else if (i >= 18) {
            f2392a = new C0717d();
        } else if (i >= 17) {
            f2392a = new C0716c();
        } else if (i >= 16) {
            f2392a = new C0715e();
        } else {
            f2392a = new C0714b();
        }
    }

    public static void m4798a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f2392a.mo701a(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static int m4797a(TextView textView) {
        return f2392a.mo700a(textView);
    }
}
