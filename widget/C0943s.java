package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.al;
import android.support.v7.p028b.C0842a.C0831a;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class C0943s extends AutoCompleteTextView implements al {
    private static final int[] f3375a = new int[]{16843126};
    private C1011w f3376b;
    private C1004t f3377c;
    private al f3378d;

    public C0943s(Context context) {
        this(context, null);
    }

    public C0943s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.autoCompleteTextViewStyle);
    }

    public C0943s(Context context, AttributeSet attributeSet, int i) {
        super(db.m7061a(context), attributeSet, i);
        this.f3376b = C1011w.m7254a();
        de a = de.m7066a(getContext(), attributeSet, f3375a, i, 0);
        if (a.m7083g(0)) {
            setDropDownBackgroundDrawable(a.m7069a(0));
        }
        a.m7070a();
        this.f3377c = new C1004t(this, this.f3376b);
        this.f3377c.m7230a(attributeSet, i);
        this.f3378d = al.m6711a((TextView) this);
        this.f3378d.mo981a(attributeSet, i);
        this.f3378d.mo980a();
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f3376b != null) {
            setDropDownBackgroundDrawable(this.f3376b.m7272a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3377c != null) {
            this.f3377c.m7226a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3377c != null) {
            this.f3377c.m7229a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3377c != null) {
            this.f3377c.m7227a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f3377c != null ? this.f3377c.m7225a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f3377c != null) {
            this.f3377c.m7228a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f3377c != null ? this.f3377c.m7231b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3377c != null) {
            this.f3377c.m7233c();
        }
        if (this.f3378d != null) {
            this.f3378d.mo980a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3378d != null) {
            this.f3378d.m6714a(context, i);
        }
    }
}
