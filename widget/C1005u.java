package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class C1005u extends CheckedTextView {
    private static final int[] f3913a = new int[]{16843016};
    private C1011w f3914b;
    private al f3915c;

    public C1005u(Context context) {
        this(context, null);
    }

    public C1005u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C1005u(Context context, AttributeSet attributeSet, int i) {
        super(db.m7061a(context), attributeSet, i);
        this.f3915c = al.m6711a((TextView) this);
        this.f3915c.mo981a(attributeSet, i);
        this.f3915c.mo980a();
        this.f3914b = C1011w.m7254a();
        de a = de.m7066a(getContext(), attributeSet, f3913a, i, 0);
        setCheckMarkDrawable(a.m7069a(0));
        a.m7070a();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f3914b != null) {
            setCheckMarkDrawable(this.f3914b.m7272a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3915c != null) {
            this.f3915c.m6714a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3915c != null) {
            this.f3915c.mo980a();
        }
    }
}
