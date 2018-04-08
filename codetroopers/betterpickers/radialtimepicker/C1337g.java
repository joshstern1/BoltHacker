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
import com.p059c.p060a.C1257i;
import com.p059c.p060a.C1260k;
import com.p059c.p060a.aa;
import com.p059c.p060a.ac;
import com.p059c.p060a.ac.C1243b;
import com.p059c.p062c.p063a.C1280a;

public class C1337g extends View {
    private float[] f5079A;
    private float f5080B;
    private float f5081C;
    private float f5082D;
    private C1336a f5083E;
    C1260k f5084a;
    C1260k f5085b;
    private final Paint f5086c = new Paint();
    private boolean f5087d;
    private boolean f5088e = false;
    private Typeface f5089f;
    private Typeface f5090g;
    private String[] f5091h;
    private String[] f5092i;
    private boolean f5093j;
    private boolean f5094k;
    private float f5095l;
    private float f5096m;
    private float f5097n;
    private float f5098o;
    private float f5099p;
    private float f5100q;
    private int f5101r;
    private int f5102s;
    private float f5103t;
    private boolean f5104u;
    private float f5105v;
    private float f5106w;
    private float[] f5107x;
    private float[] f5108y;
    private float[] f5109z;

    private class C1336a implements C1243b {
        final /* synthetic */ C1337g f5078a;

        private C1336a(C1337g c1337g) {
            this.f5078a = c1337g;
        }

        public void mo1275a(ac acVar) {
            this.f5078a.invalidate();
        }
    }

    public C1337g(Context context) {
        super(context);
    }

    public void m8725a(Resources resources, String[] strArr, String[] strArr2, boolean z, boolean z2) {
        int i = -1;
        boolean z3 = false;
        if (this.f5088e) {
            Log.e("RadialTextsView", "This RadialTextsView may only be initialized once.");
            return;
        }
        int i2;
        this.f5086c.setColor(resources.getColor(C1284a.numbers_text_color));
        this.f5089f = Typeface.create(resources.getString(C1289f.radial_numbers_typeface), 0);
        this.f5090g = Typeface.create(resources.getString(C1289f.sans_serif), 0);
        this.f5086c.setAntiAlias(true);
        this.f5086c.setTextAlign(Align.CENTER);
        this.f5091h = strArr;
        this.f5092i = strArr2;
        this.f5093j = z;
        if (strArr2 != null) {
            z3 = true;
        }
        this.f5094k = z3;
        if (z) {
            this.f5095l = Float.parseFloat(resources.getString(C1289f.circle_radius_multiplier_24HourMode));
        } else {
            this.f5095l = Float.parseFloat(resources.getString(C1289f.circle_radius_multiplier));
            this.f5096m = Float.parseFloat(resources.getString(C1289f.ampm_circle_radius_multiplier));
        }
        this.f5107x = new float[7];
        this.f5108y = new float[7];
        if (this.f5094k) {
            this.f5097n = Float.parseFloat(resources.getString(C1289f.numbers_radius_multiplier_outer));
            this.f5099p = Float.parseFloat(resources.getString(C1289f.text_size_multiplier_outer));
            this.f5098o = Float.parseFloat(resources.getString(C1289f.numbers_radius_multiplier_inner));
            this.f5100q = Float.parseFloat(resources.getString(C1289f.text_size_multiplier_inner));
            this.f5109z = new float[7];
            this.f5079A = new float[7];
        } else {
            this.f5097n = Float.parseFloat(resources.getString(C1289f.numbers_radius_multiplier_normal));
            this.f5099p = Float.parseFloat(resources.getString(C1289f.text_size_multiplier_normal));
        }
        this.f5080B = 1.0f;
        if (z2) {
            i2 = -1;
        } else {
            i2 = 1;
        }
        this.f5081C = (((float) i2) * 0.05f) + 1.0f;
        if (z2) {
            i = 1;
        }
        this.f5082D = (0.3f * ((float) i)) + 1.0f;
        this.f5083E = new C1336a();
        this.f5104u = true;
        this.f5088e = true;
    }

    void setTheme(TypedArray typedArray) {
        this.f5086c.setColor(typedArray.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.numbers_text_color));
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void setAnimationRadiusMultiplier(float f) {
        this.f5080B = f;
        this.f5104u = true;
    }

    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && this.f5088e) {
            if (!this.f5087d) {
                this.f5101r = getWidth() / 2;
                this.f5102s = getHeight() / 2;
                this.f5103t = ((float) Math.min(this.f5101r, this.f5102s)) * this.f5095l;
                if (!this.f5093j) {
                    this.f5102s = (int) (((float) this.f5102s) - ((this.f5103t * this.f5096m) / 2.0f));
                }
                this.f5105v = this.f5103t * this.f5099p;
                if (this.f5094k) {
                    this.f5106w = this.f5103t * this.f5100q;
                }
                m8722a();
                this.f5104u = true;
                this.f5087d = true;
            }
            if (this.f5104u) {
                m8723a(this.f5080B * (this.f5103t * this.f5097n), (float) this.f5101r, (float) this.f5102s, this.f5105v, this.f5107x, this.f5108y);
                if (this.f5094k) {
                    m8723a(this.f5080B * (this.f5103t * this.f5098o), (float) this.f5101r, (float) this.f5102s, this.f5106w, this.f5109z, this.f5079A);
                }
                this.f5104u = false;
            }
            m8724a(canvas, this.f5105v, this.f5089f, this.f5091h, this.f5108y, this.f5107x);
            if (this.f5094k) {
                m8724a(canvas, this.f5106w, this.f5090g, this.f5092i, this.f5079A, this.f5109z);
            }
        }
    }

    private void m8723a(float f, float f2, float f3, float f4, float[] fArr, float[] fArr2) {
        float sqrt = (((float) Math.sqrt(3.0d)) * f) / 2.0f;
        float f5 = f / 2.0f;
        this.f5086c.setTextSize(f4);
        float descent = f3 - ((this.f5086c.descent() + this.f5086c.ascent()) / 2.0f);
        fArr[0] = descent - f;
        fArr2[0] = f2 - f;
        fArr[1] = descent - sqrt;
        fArr2[1] = f2 - sqrt;
        fArr[2] = descent - f5;
        fArr2[2] = f2 - f5;
        fArr[3] = descent;
        fArr2[3] = f2;
        fArr[4] = descent + f5;
        fArr2[4] = f5 + f2;
        fArr[5] = descent + sqrt;
        fArr2[5] = sqrt + f2;
        fArr[6] = descent + f;
        fArr2[6] = f2 + f;
    }

    private void m8724a(Canvas canvas, float f, Typeface typeface, String[] strArr, float[] fArr, float[] fArr2) {
        this.f5086c.setTextSize(f);
        this.f5086c.setTypeface(typeface);
        canvas.drawText(strArr[0], fArr[3], fArr2[0], this.f5086c);
        canvas.drawText(strArr[1], fArr[4], fArr2[1], this.f5086c);
        canvas.drawText(strArr[2], fArr[5], fArr2[2], this.f5086c);
        canvas.drawText(strArr[3], fArr[6], fArr2[3], this.f5086c);
        canvas.drawText(strArr[4], fArr[5], fArr2[4], this.f5086c);
        canvas.drawText(strArr[5], fArr[4], fArr2[5], this.f5086c);
        canvas.drawText(strArr[6], fArr[3], fArr2[6], this.f5086c);
        canvas.drawText(strArr[7], fArr[2], fArr2[5], this.f5086c);
        canvas.drawText(strArr[8], fArr[1], fArr2[4], this.f5086c);
        canvas.drawText(strArr[9], fArr[0], fArr2[3], this.f5086c);
        canvas.drawText(strArr[10], fArr[1], fArr2[2], this.f5086c);
        canvas.drawText(strArr[11], fArr[2], fArr2[1], this.f5086c);
    }

    private void m8722a() {
        Object a;
        C1257i a2 = C1257i.m8364a(0.0f, 1.0f);
        C1257i a3 = C1257i.m8364a(0.2f, this.f5081C);
        C1257i a4 = C1257i.m8364a(1.0f, this.f5082D);
        aa a5 = aa.m8245a("animationRadiusMultiplier", a2, a3, a4);
        a2 = C1257i.m8364a(0.0f, 1.0f);
        a4 = C1257i.m8364a(1.0f, 0.0f);
        aa a6 = aa.m8245a("alpha", a2, a4);
        if (C1280a.f4708a) {
            a = C1280a.m8460a((View) this);
        } else {
            C1337g c1337g = this;
        }
        this.f5084a = C1260k.m8383a(a, a5, a6).mo1238a((long) 500);
        this.f5084a.m8293a(this.f5083E);
        int i = (int) ((1.0f + 0.25f) * ((float) 500));
        float f = (0.25f * ((float) 500)) / ((float) i);
        float f2 = 1.0f - (0.2f * (1.0f - f));
        C1257i a7 = C1257i.m8364a(0.0f, this.f5082D);
        a4 = C1257i.m8364a(f, this.f5082D);
        C1257i a8 = C1257i.m8364a(f2, this.f5081C);
        C1257i a9 = C1257i.m8364a(1.0f, 1.0f);
        aa a10 = aa.m8245a("animationRadiusMultiplier", a7, a4, a8, a9);
        a7 = C1257i.m8364a(0.0f, 0.0f);
        a2 = C1257i.m8364a(f, 0.0f);
        a4 = C1257i.m8364a(1.0f, 1.0f);
        aa a11 = aa.m8245a("alpha", a7, a2, a4);
        if (C1280a.f4708a) {
            a = C1280a.m8460a((View) this);
        } else {
            c1337g = this;
        }
        this.f5085b = C1260k.m8383a(a, a10, a11).mo1238a((long) i);
        this.f5085b.m8293a(this.f5083E);
    }

    public C1260k getDisappearAnimator() {
        if (this.f5088e && this.f5087d && this.f5084a != null) {
            return this.f5084a;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }

    public C1260k getReappearAnimator() {
        if (this.f5088e && this.f5087d && this.f5085b != null) {
            return this.f5085b;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }
}
