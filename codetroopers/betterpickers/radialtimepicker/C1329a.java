package com.codetroopers.betterpickers.radialtimepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1289f;
import com.codetroopers.betterpickers.C1292c.C1291h;
import java.text.DateFormatSymbols;

public class C1329a extends View {
    private final Paint f5022a = new Paint();
    private int f5023b;
    private int f5024c;
    private int f5025d;
    private int f5026e;
    private float f5027f;
    private float f5028g;
    private String f5029h;
    private String f5030i;
    private boolean f5031j = false;
    private boolean f5032k;
    private int f5033l;
    private int f5034m;
    private int f5035n;
    private int f5036o;
    private int f5037p;
    private int f5038q;

    public C1329a(Context context) {
        super(context);
    }

    public void m8715a(Context context, int i) {
        if (this.f5031j) {
            Log.e("AmPmCirclesView", "AmPmCirclesView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.f5024c = resources.getColor(C1284a.bpWhite);
        this.f5026e = resources.getColor(C1284a.bpBlue);
        this.f5025d = resources.getColor(C1284a.ampm_text_color);
        this.f5022a.setTypeface(Typeface.create(resources.getString(C1289f.sans_serif), 0));
        this.f5022a.setAntiAlias(true);
        this.f5022a.setTextAlign(Align.CENTER);
        this.f5027f = Float.parseFloat(resources.getString(C1289f.circle_radius_multiplier));
        this.f5028g = Float.parseFloat(resources.getString(C1289f.ampm_circle_radius_multiplier));
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f5029h = amPmStrings[0];
        this.f5030i = amPmStrings[1];
        setAmOrPm(i);
        this.f5038q = -1;
        this.f5031j = true;
    }

    void setTheme(TypedArray typedArray) {
        this.f5024c = typedArray.getColor(C1291h.BetterPickersDialog_bpMainColor1, C1284a.bpWhite);
        this.f5026e = typedArray.getColor(C1291h.BetterPickersDialog_bpAccentColor, C1284a.bpBlue);
        this.f5025d = typedArray.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.ampm_text_color);
        this.f5023b = typedArray.getInt(C1291h.BetterPickersDialog_bpSelectionAlpha, 100);
    }

    public void setAmOrPm(int i) {
        this.f5037p = i;
    }

    public void setAmOrPmPressed(int i) {
        this.f5038q = i;
    }

    public int m8714a(float f, float f2) {
        if (!this.f5032k) {
            return -1;
        }
        int i = (int) ((f2 - ((float) this.f5036o)) * (f2 - ((float) this.f5036o)));
        if (((int) Math.sqrt((double) (((f - ((float) this.f5034m)) * (f - ((float) this.f5034m))) + ((float) i)))) <= this.f5033l) {
            return 0;
        }
        if (((int) Math.sqrt((double) (((float) i) + ((f - ((float) this.f5035n)) * (f - ((float) this.f5035n)))))) <= this.f5033l) {
            return 1;
        }
        return -1;
    }

    public void onDraw(Canvas canvas) {
        int i = 255;
        if (getWidth() != 0 && this.f5031j) {
            int width;
            int height;
            int min;
            if (!this.f5032k) {
                width = getWidth() / 2;
                height = getHeight() / 2;
                min = (int) (((float) Math.min(width, height)) * this.f5027f);
                this.f5033l = (int) (((float) min) * this.f5028g);
                this.f5022a.setTextSize((float) ((this.f5033l * 3) / 4));
                this.f5036o = (height - (this.f5033l / 2)) + min;
                this.f5034m = (width - min) + this.f5033l;
                this.f5035n = (width + min) - this.f5033l;
                this.f5032k = true;
            }
            min = this.f5024c;
            width = this.f5024c;
            if (this.f5037p == 0) {
                min = this.f5026e;
                height = this.f5023b;
            } else if (this.f5037p == 1) {
                height = this.f5026e;
                width = height;
                height = 255;
                i = this.f5023b;
            } else {
                height = 255;
            }
            if (this.f5038q == 0) {
                min = this.f5026e;
                height = this.f5023b;
            } else if (this.f5038q == 1) {
                width = this.f5026e;
                i = this.f5023b;
            }
            this.f5022a.setColor(min);
            this.f5022a.setAlpha(height);
            canvas.drawCircle((float) this.f5034m, (float) this.f5036o, (float) this.f5033l, this.f5022a);
            this.f5022a.setColor(width);
            this.f5022a.setAlpha(i);
            canvas.drawCircle((float) this.f5035n, (float) this.f5036o, (float) this.f5033l, this.f5022a);
            this.f5022a.setColor(this.f5025d);
            i = this.f5036o - (((int) (this.f5022a.descent() + this.f5022a.ascent())) / 2);
            canvas.drawText(this.f5029h, (float) this.f5034m, (float) i, this.f5022a);
            canvas.drawText(this.f5030i, (float) this.f5035n, (float) i, this.f5022a);
        }
    }
}
