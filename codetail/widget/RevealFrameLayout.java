package io.codetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import io.codetail.p122a.C3071a;
import io.codetail.p122a.C3076c;

public class RevealFrameLayout extends FrameLayout implements C3071a {
    private C3076c f10165a;

    public RevealFrameLayout(Context context) {
        this(context, null);
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10165a = new C3076c();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        try {
            canvas.save();
            this.f10165a.m17405a(canvas, view);
            boolean drawChild = super.drawChild(canvas, view, j);
            return drawChild;
        } finally {
            canvas.restore();
        }
    }

    public C3076c getViewRevealManager() {
        return this.f10165a;
    }
}
