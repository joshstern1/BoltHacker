package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.al;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements al {
    private C1011w f2861a;
    private C1004t f2862b;
    private al f2863c;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(db.m7061a(context), attributeSet, i);
        this.f2861a = C1011w.m7254a();
        this.f2862b = new C1004t(this, this.f2861a);
        this.f2862b.m7230a(attributeSet, i);
        this.f2863c = al.m6711a((TextView) this);
        this.f2863c.mo981a(attributeSet, i);
        this.f2863c.mo980a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2862b != null) {
            this.f2862b.m7226a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2862b != null) {
            this.f2862b.m7229a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2862b != null) {
            this.f2862b.m7227a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2862b != null ? this.f2862b.m7225a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2862b != null) {
            this.f2862b.m7228a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2862b != null ? this.f2862b.m7231b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2863c != null) {
            this.f2863c.m6714a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2862b != null) {
            this.f2862b.m7233c();
        }
        if (this.f2863c != null) {
            this.f2863c.mo980a();
        }
    }
}
