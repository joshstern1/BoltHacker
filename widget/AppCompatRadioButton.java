package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p021b.C0307a;
import android.support.v4.widget.bc;
import android.support.v7.p028b.C0842a.C0831a;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton implements bc {
    private C1011w f3188a;
    private C1006v f3189b;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(db.m7061a(context), attributeSet, i);
        this.f3188a = C1011w.m7254a();
        this.f3189b = new C1006v(this, this.f3188a);
        this.f3189b.m7238a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f3189b != null) {
            this.f3189b.m7240c();
        }
    }

    public void setButtonDrawable(int i) {
        Drawable a;
        if (this.f3188a != null) {
            a = this.f3188a.m7272a(getContext(), i);
        } else {
            a = C0307a.m2325a(getContext(), i);
        }
        setButtonDrawable(a);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f3189b != null ? this.f3189b.m7234a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f3189b != null) {
            this.f3189b.m7236a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f3189b != null ? this.f3189b.m7235a() : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f3189b != null) {
            this.f3189b.m7237a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.f3189b != null ? this.f3189b.m7239b() : null;
    }
}
