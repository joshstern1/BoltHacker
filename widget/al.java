package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.p032f.C0849a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class al {
    private static final int[] f3623b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    final TextView f3624a;
    private dc f3625c;
    private dc f3626d;
    private dc f3627e;
    private dc f3628f;

    static al m6711a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new am(textView);
        }
        return new al(textView);
    }

    al(TextView textView) {
        this.f3624a = textView;
    }

    void mo981a(AttributeSet attributeSet, int i) {
        boolean z;
        Context context = this.f3624a.getContext();
        C1011w a = C1011w.m7254a();
        de a2 = de.m7066a(context, attributeSet, f3623b, i, 0);
        int g = a2.m7082g(0, -1);
        if (a2.m7083g(1)) {
            this.f3625c = m6712a(context, a, a2.m7082g(1, 0));
        }
        if (a2.m7083g(2)) {
            this.f3626d = m6712a(context, a, a2.m7082g(2, 0));
        }
        if (a2.m7083g(3)) {
            this.f3627e = m6712a(context, a, a2.m7082g(3, 0));
        }
        if (a2.m7083g(4)) {
            this.f3628f = m6712a(context, a, a2.m7082g(4, 0));
        }
        a2.m7070a();
        boolean z2 = this.f3624a.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList = null;
        boolean z3;
        if (g != -1) {
            de a3 = de.m7064a(context, g, C0841k.TextAppearance);
            if (z2 || !a3.m7083g(C0841k.TextAppearance_textAllCaps)) {
                z3 = false;
                z = false;
            } else {
                z = a3.m7071a(C0841k.TextAppearance_textAllCaps, false);
                int i2 = 1;
            }
            if (VERSION.SDK_INT < 23 && a3.m7083g(C0841k.TextAppearance_android_textColor)) {
                colorStateList = a3.m7079e(C0841k.TextAppearance_android_textColor);
            }
            a3.m7070a();
        } else {
            z3 = false;
            z = false;
        }
        de a4 = de.m7066a(context, attributeSet, C0841k.TextAppearance, i, 0);
        if (!z2 && a4.m7083g(C0841k.TextAppearance_textAllCaps)) {
            z = a4.m7071a(C0841k.TextAppearance_textAllCaps, false);
            i2 = 1;
        }
        if (VERSION.SDK_INT < 23 && a4.m7083g(C0841k.TextAppearance_android_textColor)) {
            colorStateList = a4.m7079e(C0841k.TextAppearance_android_textColor);
        }
        a4.m7070a();
        if (colorStateList != null) {
            this.f3624a.setTextColor(colorStateList);
        }
        if (!z2 && r0 != 0) {
            m6717a(z);
        }
    }

    void m6714a(Context context, int i) {
        de a = de.m7064a(context, i, C0841k.TextAppearance);
        if (a.m7083g(C0841k.TextAppearance_textAllCaps)) {
            m6717a(a.m7071a(C0841k.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.m7083g(C0841k.TextAppearance_android_textColor)) {
            ColorStateList e = a.m7079e(C0841k.TextAppearance_android_textColor);
            if (e != null) {
                this.f3624a.setTextColor(e);
            }
        }
        a.m7070a();
    }

    void m6717a(boolean z) {
        this.f3624a.setTransformationMethod(z ? new C0849a(this.f3624a.getContext()) : null);
    }

    void mo980a() {
        if (this.f3625c != null || this.f3626d != null || this.f3627e != null || this.f3628f != null) {
            Drawable[] compoundDrawables = this.f3624a.getCompoundDrawables();
            m6715a(compoundDrawables[0], this.f3625c);
            m6715a(compoundDrawables[1], this.f3626d);
            m6715a(compoundDrawables[2], this.f3627e);
            m6715a(compoundDrawables[3], this.f3628f);
        }
    }

    final void m6715a(Drawable drawable, dc dcVar) {
        if (drawable != null && dcVar != null) {
            C1011w.m7257a(drawable, dcVar, this.f3624a.getDrawableState());
        }
    }

    protected static dc m6712a(Context context, C1011w c1011w, int i) {
        ColorStateList b = c1011w.m7275b(context, i);
        if (b == null) {
            return null;
        }
        dc dcVar = new dc();
        dcVar.f3826d = true;
        dcVar.f3823a = b;
        return dcVar;
    }
}
