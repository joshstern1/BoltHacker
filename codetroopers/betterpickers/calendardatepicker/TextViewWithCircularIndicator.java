package com.codetroopers.betterpickers.calendardatepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.TextView;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1285b;
import com.codetroopers.betterpickers.C1292c.C1289f;

public class TextViewWithCircularIndicator extends TextView {
    Paint f4734a = new Paint();
    private final int f4735b;
    private int f4736c;
    private final String f4737d;
    private boolean f4738e;

    public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        this.f4736c = resources.getColor(C1284a.bpBlue);
        this.f4735b = resources.getDimensionPixelOffset(C1285b.month_select_circle_radius);
        this.f4737d = context.getResources().getString(C1289f.item_is_selected);
        m8502a();
    }

    private void m8502a() {
        this.f4734a.setFakeBoldText(true);
        this.f4734a.setAntiAlias(true);
        this.f4734a.setColor(this.f4736c);
        this.f4734a.setTextAlign(Align.CENTER);
        this.f4734a.setStyle(Style.FILL);
        this.f4734a.setAlpha(60);
    }

    public void setCircleColor(int i) {
        this.f4736c = i;
        m8502a();
    }

    public void m8503a(boolean z) {
        this.f4738e = z;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4738e) {
            int width = getWidth();
            int height = getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (Math.min(width, height) / 2), this.f4734a);
        }
    }

    public CharSequence getContentDescription() {
        CharSequence text = getText();
        if (!this.f4738e) {
            return text;
        }
        return String.format(this.f4737d, new Object[]{text});
    }
}
