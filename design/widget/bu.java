package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class bu extends ImageButton {
    private int f1123a;

    public bu(Context context) {
        this(context, null);
    }

    public bu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public bu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1123a = getVisibility();
    }

    public void setVisibility(int i) {
        m1713a(i, true);
    }

    final void m1713a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f1123a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f1123a;
    }
}
