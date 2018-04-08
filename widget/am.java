package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

class am extends al {
    private static final int[] f3629b = new int[]{16843666, 16843667};
    private dc f3630c;
    private dc f3631d;

    am(TextView textView) {
        super(textView);
    }

    void mo981a(AttributeSet attributeSet, int i) {
        super.mo981a(attributeSet, i);
        Context context = this.a.getContext();
        C1011w a = C1011w.m7254a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3629b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f3630c = al.m6712a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f3631d = al.m6712a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    void mo980a() {
        super.mo980a();
        if (this.f3630c != null || this.f3631d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m6715a(compoundDrawablesRelative[0], this.f3630c);
            m6715a(compoundDrawablesRelative[2], this.f3631d);
        }
    }
}
