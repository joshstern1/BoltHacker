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
import com.p059c.p060a.C1257i;
import com.p059c.p060a.C1260k;
import com.p059c.p060a.aa;
import com.p059c.p060a.ac;
import com.p059c.p060a.ac.C1243b;
import com.p059c.p062c.p063a.C1280a;

public class C1334e extends View {
    private final Paint f5054a = new Paint();
    private boolean f5055b = false;
    private boolean f5056c;
    private float f5057d;
    private float f5058e;
    private float f5059f;
    private float f5060g;
    private float f5061h;
    private float f5062i;
    private float f5063j;
    private boolean f5064k;
    private boolean f5065l;
    private int f5066m;
    private int f5067n;
    private int f5068o;
    private int f5069p;
    private float f5070q;
    private float f5071r;
    private int f5072s;
    private int f5073t;
    private C1333a f5074u;
    private int f5075v;
    private double f5076w;
    private boolean f5077x;

    private class C1333a implements C1243b {
        final /* synthetic */ C1334e f5053a;

        private C1333a(C1334e c1334e) {
            this.f5053a = c1334e;
        }

        public void mo1275a(ac acVar) {
            this.f5053a.invalidate();
        }
    }

    public C1334e(Context context) {
        super(context);
    }

    public void m8720a(Context context, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        int i2 = -1;
        if (this.f5055b) {
            Log.e("RadialSelectorView", "This RadialSelectorView may only be initialized once.");
            return;
        }
        int i3;
        Resources resources = context.getResources();
        this.f5054a.setAntiAlias(true);
        this.f5064k = z;
        if (z) {
            this.f5057d = Float.parseFloat(resources.getString(C1289f.circle_radius_multiplier_24HourMode));
        } else {
            this.f5057d = Float.parseFloat(resources.getString(C1289f.circle_radius_multiplier));
            this.f5058e = Float.parseFloat(resources.getString(C1289f.ampm_circle_radius_multiplier));
        }
        this.f5065l = z2;
        if (z2) {
            this.f5059f = Float.parseFloat(resources.getString(C1289f.numbers_radius_multiplier_inner));
            this.f5060g = Float.parseFloat(resources.getString(C1289f.numbers_radius_multiplier_outer));
        } else {
            this.f5061h = Float.parseFloat(resources.getString(C1289f.numbers_radius_multiplier_normal));
        }
        this.f5062i = Float.parseFloat(resources.getString(C1289f.selection_radius_multiplier));
        this.f5063j = 1.0f;
        if (z3) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        this.f5070q = (((float) i3) * 0.05f) + 1.0f;
        if (z3) {
            i2 = 1;
        }
        this.f5071r = (0.3f * ((float) i2)) + 1.0f;
        this.f5074u = new C1333a();
        m8719a(i, z4, false);
        this.f5055b = true;
    }

    void setTheme(TypedArray typedArray) {
        this.f5054a.setColor(typedArray.getColor(C1291h.BetterPickersDialog_bpAccentColor, C1284a.bpBlue));
        this.f5066m = typedArray.getInt(C1291h.BetterPickersDialog_bpSelectionAlpha, 51);
    }

    public void m8719a(int i, boolean z, boolean z2) {
        this.f5075v = i;
        this.f5076w = (((double) i) * 3.141592653589793d) / 180.0d;
        this.f5077x = z2;
        if (!this.f5065l) {
            return;
        }
        if (z) {
            this.f5061h = this.f5059f;
        } else {
            this.f5061h = this.f5060g;
        }
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void setAnimationRadiusMultiplier(float f) {
        this.f5063j = f;
    }

    public int m8718a(float f, float f2, boolean z, Boolean[] boolArr) {
        boolean z2 = true;
        if (!this.f5056c) {
            return -1;
        }
        boolean z3;
        double sqrt = Math.sqrt((double) (((f2 - ((float) this.f5068o)) * (f2 - ((float) this.f5068o))) + ((f - ((float) this.f5067n)) * (f - ((float) this.f5067n)))));
        if (this.f5065l) {
            if (z) {
                if (((int) Math.abs(sqrt - ((double) ((int) (((float) this.f5069p) * this.f5059f))))) <= ((int) Math.abs(sqrt - ((double) ((int) (((float) this.f5069p) * this.f5060g)))))) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolArr[0] = Boolean.valueOf(z3);
            } else {
                int i = ((int) (((float) this.f5069p) * this.f5060g)) + this.f5073t;
                int i2 = (int) (((float) this.f5069p) * ((this.f5060g + this.f5059f) / 2.0f));
                if (sqrt >= ((double) (((int) (((float) this.f5069p) * this.f5059f)) - this.f5073t)) && sqrt <= ((double) i2)) {
                    boolArr[0] = Boolean.valueOf(true);
                } else if (sqrt > ((double) i) || sqrt < ((double) i2)) {
                    return -1;
                } else {
                    boolArr[0] = Boolean.valueOf(false);
                }
            }
        } else if (!z && ((int) Math.abs(sqrt - ((double) this.f5072s))) > ((int) (((float) this.f5069p) * (1.0f - this.f5061h)))) {
            return -1;
        }
        int asin = (int) ((Math.asin(((double) Math.abs(f2 - ((float) this.f5068o))) / sqrt) * 180.0d) / 3.141592653589793d);
        z3 = f > ((float) this.f5067n);
        if (f2 >= ((float) this.f5068o)) {
            z2 = false;
        }
        if (z3 && z2) {
            return 90 - asin;
        }
        if (z3 && !z2) {
            return asin + 90;
        }
        if (z3 || z2) {
            return (z3 || !z2) ? asin : asin + 270;
        } else {
            return 270 - asin;
        }
    }

    public void onDraw(Canvas canvas) {
        int i = 1;
        if (getWidth() != 0 && this.f5055b) {
            int i2;
            if (!this.f5056c) {
                this.f5067n = getWidth() / 2;
                this.f5068o = getHeight() / 2;
                this.f5069p = (int) (((float) Math.min(this.f5067n, this.f5068o)) * this.f5057d);
                if (!this.f5064k) {
                    this.f5068o -= ((int) (((float) this.f5069p) * this.f5058e)) / 2;
                }
                this.f5073t = (int) (((float) this.f5069p) * this.f5062i);
                this.f5056c = true;
            }
            this.f5072s = (int) ((((float) this.f5069p) * this.f5061h) * this.f5063j);
            int sin = ((int) (((double) this.f5072s) * Math.sin(this.f5076w))) + this.f5067n;
            int cos = this.f5068o - ((int) (((double) this.f5072s) * Math.cos(this.f5076w)));
            this.f5054a.setAlpha(this.f5066m);
            canvas.drawCircle((float) sin, (float) cos, (float) this.f5073t, this.f5054a);
            boolean z = this.f5077x;
            if (this.f5075v % 30 == 0) {
                i = 0;
            }
            if ((i | z) != 0) {
                this.f5054a.setAlpha(255);
                canvas.drawCircle((float) sin, (float) cos, (float) ((this.f5073t * 2) / 7), this.f5054a);
                i2 = sin;
            } else {
                cos = this.f5072s - this.f5073t;
                sin = this.f5067n + ((int) (((double) cos) * Math.sin(this.f5076w)));
                cos = this.f5068o - ((int) (((double) cos) * Math.cos(this.f5076w)));
                i2 = sin;
            }
            this.f5054a.setAlpha(255);
            this.f5054a.setStrokeWidth(1.0f);
            canvas.drawLine((float) this.f5067n, (float) this.f5068o, (float) i2, (float) cos, this.f5054a);
        }
    }

    public C1260k getDisappearAnimator() {
        if (this.f5055b && this.f5056c) {
            Object a;
            C1257i a2 = C1257i.m8364a(0.0f, 1.0f);
            C1257i a3 = C1257i.m8364a(0.2f, this.f5070q);
            C1257i a4 = C1257i.m8364a(1.0f, this.f5071r);
            aa a5 = aa.m8245a("animationRadiusMultiplier", a2, a3, a4);
            a3 = C1257i.m8364a(0.0f, 1.0f);
            a4 = C1257i.m8364a(1.0f, 0.0f);
            aa a6 = aa.m8245a("alpha", a3, a4);
            if (C1280a.f4708a) {
                a = C1280a.m8460a((View) this);
            } else {
                C1334e c1334e = this;
            }
            C1260k a7 = C1260k.m8383a(a, a5, a6).mo1238a((long) 500);
            a7.m8293a(this.f5074u);
            return a7;
        }
        Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
        return null;
    }

    public C1260k getReappearAnimator() {
        if (this.f5055b && this.f5056c) {
            Object a;
            int i = (int) ((1.0f + 0.25f) * ((float) 500));
            float f = (((float) 500) * 0.25f) / ((float) i);
            float f2 = 1.0f - (0.2f * (1.0f - f));
            C1257i a2 = C1257i.m8364a(0.0f, this.f5071r);
            C1257i a3 = C1257i.m8364a(f, this.f5071r);
            C1257i a4 = C1257i.m8364a(f2, this.f5070q);
            C1257i a5 = C1257i.m8364a(1.0f, 1.0f);
            aa a6 = aa.m8245a("animationRadiusMultiplier", a2, a3, a4, a5);
            a4 = C1257i.m8364a(0.0f, 0.0f);
            C1257i a7 = C1257i.m8364a(f, 0.0f);
            a3 = C1257i.m8364a(1.0f, 1.0f);
            aa a8 = aa.m8245a("alpha", a4, a7, a3);
            if (C1280a.f4708a) {
                a = C1280a.m8460a((View) this);
            } else {
                C1334e c1334e = this;
            }
            C1260k a9 = C1260k.m8383a(a, a6, a8).mo1238a((long) i);
            a9.m8293a(this.f5074u);
            return a9;
        }
        Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
        return null;
    }
}
