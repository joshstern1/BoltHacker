package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.C0192a.C0191i;
import android.support.v7.widget.de;
import android.util.AttributeSet;
import android.view.View;

public final class au extends View {
    final CharSequence f1305a;
    final Drawable f1306b;
    final int f1307c;

    public au(Context context) {
        this(context, null);
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        de a = de.m7065a(context, attributeSet, C0191i.TabItem);
        this.f1305a = a.m7075c(C0191i.TabItem_android_text);
        this.f1306b = a.m7069a(C0191i.TabItem_android_icon);
        this.f1307c = a.m7082g(C0191i.TabItem_android_layout, 0);
        a.m7070a();
    }
}
