package com.codetroopers.betterpickers.radialtimepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1289f;
import com.codetroopers.betterpickers.C1292c.C1291h;

public class C1330b extends View {
    private final Paint f5039a = new Paint();
    private boolean f5040b;
    private int f5041c;
    private int f5042d;
    private float f5043e;
    private float f5044f;
    private boolean f5045g;
    private boolean f5046h;
    private int f5047i;
    private int f5048j;
    private int f5049k;

    public C1330b(Context context) {
        super(context);
        Resources resources = context.getResources();
        this.f5041c = resources.getColor(C1284a.bpWhite);
        this.f5042d = resources.getColor(C1284a.numbers_text_color);
        this.f5039a.setAntiAlias(true);
        this.f5045g = false;
    }

    public void m8716a(Context context, boolean z) {
        if (this.f5045g) {
            Log.e("CircleView", "CircleView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.f5040b = z;
        if (z) {
            this.f5043e = Float.parseFloat(resources.getString(C1289f.circle_radius_multiplier_24HourMode));
        } else {
            this.f5043e = Float.parseFloat(resources.getString(C1289f.circle_radius_multiplier));
            this.f5044f = Float.parseFloat(resources.getString(C1289f.ampm_circle_radius_multiplier));
        }
        this.f5045g = true;
    }

    void setTheme(TypedArray typedArray) {
        this.f5041c = typedArray.getColor(C1291h.BetterPickersDialog_bpMainColor1, C1284a.bpWhite);
        this.f5042d = typedArray.getColor(C1291h.BetterPickersDialog_bpMainColor2, C1284a.numbers_text_color);
    }

    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && this.f5045g) {
            if (!this.f5046h) {
                this.f5047i = getWidth() / 2;
                this.f5048j = getHeight() / 2;
                this.f5049k = (int) (((float) Math.min(this.f5047i, this.f5048j)) * this.f5043e);
                if (!this.f5040b) {
                    this.f5048j -= ((int) (((float) this.f5049k) * this.f5044f)) / 2;
                }
                this.f5046h = true;
            }
            this.f5039a.setColor(this.f5041c);
            canvas.drawCircle((float) this.f5047i, (float) this.f5048j, (float) this.f5049k, this.f5039a);
            this.f5039a.setColor(this.f5042d);
            canvas.drawCircle((float) this.f5047i, (float) this.f5048j, 2.0f, this.f5039a);
        }
    }
}
