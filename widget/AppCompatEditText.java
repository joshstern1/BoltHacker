package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.al;
import android.support.v7.p028b.C0842a.C0831a;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class AppCompatEditText extends EditText implements al {
    private C1011w f1316a;
    private C1004t f1317b;
    private al f1318c;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(db.m7061a(context), attributeSet, i);
        this.f1316a = C1011w.m7254a();
        this.f1317b = new C1004t(this, this.f1316a);
        this.f1317b.m7230a(attributeSet, i);
        this.f1318c = al.m6711a((TextView) this);
        this.f1318c.mo981a(attributeSet, i);
        this.f1318c.mo980a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1317b != null) {
            this.f1317b.m7226a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1317b != null) {
            this.f1317b.m7229a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1317b != null) {
            this.f1317b.m7227a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1317b != null ? this.f1317b.m7225a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1317b != null) {
            this.f1317b.m7228a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1317b != null ? this.f1317b.m7231b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1317b != null) {
            this.f1317b.m7233c();
        }
        if (this.f1318c != null) {
            this.f1318c.mo980a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1318c != null) {
            this.f1318c.m6714a(context, i);
        }
    }
}
