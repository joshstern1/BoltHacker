package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.bb.C0761a;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements bb {
    private C0761a f3244a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0761a c0761a) {
        this.f3244a = c0761a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f3244a != null) {
            this.f3244a.mo720a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
