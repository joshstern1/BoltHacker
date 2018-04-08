package com.codetroopers.betterpickers.calendardatepicker;

import android.content.Context;
import android.graphics.Canvas;

public class C1310k extends C1307h {
    public C1310k(Context context) {
        super(context);
    }

    public void mo1272a(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        if (this.x == i3) {
            canvas.drawCircle((float) i4, (float) (i5 - (d / 3)), (float) h, this.n);
        }
        if (this.w && this.y == i3) {
            this.k.setColor(this.I);
        } else if (z) {
            this.k.setColor(this.G);
        } else {
            this.k.setColor(this.H);
        }
        canvas.drawText(String.format("%d", new Object[]{Integer.valueOf(i3)}), (float) i4, (float) i5, this.k);
    }
}
