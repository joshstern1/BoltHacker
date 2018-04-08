package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.bb.C0761a;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements bb {
    private C0761a f3245a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0761a c0761a) {
        this.f3245a = c0761a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f3245a != null) {
            this.f3245a.mo720a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
