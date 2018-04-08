package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.C0192a.C0191i;
import android.support.v4.p023f.C0487e;
import android.support.v4.view.C0645j;
import android.support.v4.view.ao;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class C0280i {
    private static final boolean f1375a = (VERSION.SDK_INT < 18);
    private static final Paint f1376b = null;
    private boolean f1377A;
    private Bitmap f1378B;
    private Paint f1379C;
    private float f1380D;
    private float f1381E;
    private float f1382F;
    private float f1383G;
    private boolean f1384H;
    private final TextPaint f1385I;
    private Interpolator f1386J;
    private Interpolator f1387K;
    private float f1388L;
    private float f1389M;
    private float f1390N;
    private int f1391O;
    private float f1392P;
    private float f1393Q;
    private float f1394R;
    private int f1395S;
    private final View f1396c;
    private boolean f1397d;
    private float f1398e;
    private final Rect f1399f;
    private final Rect f1400g;
    private final RectF f1401h;
    private int f1402i = 16;
    private int f1403j = 16;
    private float f1404k = 15.0f;
    private float f1405l = 15.0f;
    private int f1406m;
    private int f1407n;
    private float f1408o;
    private float f1409p;
    private float f1410q;
    private float f1411r;
    private float f1412s;
    private float f1413t;
    private Typeface f1414u;
    private Typeface f1415v;
    private Typeface f1416w;
    private CharSequence f1417x;
    private CharSequence f1418y;
    private boolean f1419z;

    static {
        if (f1376b != null) {
            f1376b.setAntiAlias(true);
            f1376b.setColor(-65281);
        }
    }

    public C0280i(View view) {
        this.f1396c = view;
        this.f1385I = new TextPaint(129);
        this.f1400g = new Rect();
        this.f1399f = new Rect();
        this.f1401h = new RectF();
    }

    void m2138a(Interpolator interpolator) {
        this.f1387K = interpolator;
        m2149e();
    }

    void m2144b(Interpolator interpolator) {
        this.f1386J = interpolator;
        m2149e();
    }

    void m2133a(float f) {
        if (this.f1404k != f) {
            this.f1404k = f;
            m2149e();
        }
    }

    void m2134a(int i) {
        if (this.f1407n != i) {
            this.f1407n = i;
            m2149e();
        }
    }

    void m2142b(int i) {
        if (this.f1406m != i) {
            this.f1406m = i;
            m2149e();
        }
    }

    void m2135a(int i, int i2, int i3, int i4) {
        if (!C0280i.m2121a(this.f1399f, i, i2, i3, i4)) {
            this.f1399f.set(i, i2, i3, i4);
            this.f1384H = true;
            m2132a();
        }
    }

    void m2143b(int i, int i2, int i3, int i4) {
        if (!C0280i.m2121a(this.f1400g, i, i2, i3, i4)) {
            this.f1400g.set(i, i2, i3, i4);
            this.f1384H = true;
            m2132a();
        }
    }

    void m2132a() {
        boolean z = this.f1400g.width() > 0 && this.f1400g.height() > 0 && this.f1399f.width() > 0 && this.f1399f.height() > 0;
        this.f1397d = z;
    }

    void m2146c(int i) {
        if (this.f1402i != i) {
            this.f1402i = i;
            m2149e();
        }
    }

    void m2148d(int i) {
        if (this.f1403j != i) {
            this.f1403j = i;
            m2149e();
        }
    }

    void m2150e(int i) {
        TypedArray obtainStyledAttributes = this.f1396c.getContext().obtainStyledAttributes(i, C0191i.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0191i.TextAppearance_android_textColor)) {
            this.f1407n = obtainStyledAttributes.getColor(C0191i.TextAppearance_android_textColor, this.f1407n);
        }
        if (obtainStyledAttributes.hasValue(C0191i.TextAppearance_android_textSize)) {
            this.f1405l = (float) obtainStyledAttributes.getDimensionPixelSize(C0191i.TextAppearance_android_textSize, (int) this.f1405l);
        }
        this.f1391O = obtainStyledAttributes.getInt(C0191i.TextAppearance_android_shadowColor, 0);
        this.f1389M = obtainStyledAttributes.getFloat(C0191i.TextAppearance_android_shadowDx, 0.0f);
        this.f1390N = obtainStyledAttributes.getFloat(C0191i.TextAppearance_android_shadowDy, 0.0f);
        this.f1388L = obtainStyledAttributes.getFloat(C0191i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f1414u = m2126f(i);
        }
        m2149e();
    }

    private Typeface m2126f(int i) {
        TypedArray obtainStyledAttributes = this.f1396c.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    void m2137a(Typeface typeface) {
        this.f1415v = typeface;
        this.f1414u = typeface;
        m2149e();
    }

    Typeface m2140b() {
        return this.f1414u != null ? this.f1414u : Typeface.DEFAULT;
    }

    void m2141b(float f) {
        float a = ab.m1909a(f, 0.0f, 1.0f);
        if (a != this.f1398e) {
            this.f1398e = a;
            m2128h();
        }
    }

    float m2145c() {
        return this.f1398e;
    }

    float m2147d() {
        return this.f1405l;
    }

    private void m2128h() {
        m2123c(this.f1398e);
    }

    private void m2123c(float f) {
        m2124d(f);
        this.f1412s = C0280i.m2118a(this.f1410q, this.f1411r, f, this.f1386J);
        this.f1413t = C0280i.m2118a(this.f1408o, this.f1409p, f, this.f1386J);
        m2125e(C0280i.m2118a(this.f1404k, this.f1405l, f, this.f1387K));
        if (this.f1407n != this.f1406m) {
            this.f1385I.setColor(C0280i.m2119a(this.f1406m, this.f1407n, f));
        } else {
            this.f1385I.setColor(this.f1407n);
        }
        this.f1385I.setShadowLayer(C0280i.m2118a(this.f1392P, this.f1388L, f, null), C0280i.m2118a(this.f1393Q, this.f1389M, f, null), C0280i.m2118a(this.f1394R, this.f1390N, f, null), C0280i.m2119a(this.f1395S, this.f1391O, f));
        ao.m3928d(this.f1396c);
    }

    private void m2129i() {
        int i;
        int i2 = 1;
        float f = 0.0f;
        float f2 = this.f1383G;
        m2127f(this.f1405l);
        float measureText = this.f1418y != null ? this.f1385I.measureText(this.f1418y, 0, this.f1418y.length()) : 0.0f;
        int i3 = this.f1403j;
        if (this.f1419z) {
            i = 1;
        } else {
            i = 0;
        }
        i = C0645j.m4290a(i3, i);
        switch (i & 112) {
            case 48:
                this.f1409p = ((float) this.f1400g.top) - this.f1385I.ascent();
                break;
            case 80:
                this.f1409p = (float) this.f1400g.bottom;
                break;
            default:
                this.f1409p = (((this.f1385I.descent() - this.f1385I.ascent()) / 2.0f) - this.f1385I.descent()) + ((float) this.f1400g.centerY());
                break;
        }
        switch (i & 7) {
            case 1:
                this.f1411r = ((float) this.f1400g.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.f1411r = ((float) this.f1400g.right) - measureText;
                break;
            default:
                this.f1411r = (float) this.f1400g.left;
                break;
        }
        m2127f(this.f1404k);
        if (this.f1418y != null) {
            f = this.f1385I.measureText(this.f1418y, 0, this.f1418y.length());
        }
        int i4 = this.f1402i;
        if (!this.f1419z) {
            i2 = 0;
        }
        i4 = C0645j.m4290a(i4, i2);
        switch (i4 & 112) {
            case 48:
                this.f1408o = ((float) this.f1399f.top) - this.f1385I.ascent();
                break;
            case 80:
                this.f1408o = (float) this.f1399f.bottom;
                break;
            default:
                this.f1408o = (((this.f1385I.descent() - this.f1385I.ascent()) / 2.0f) - this.f1385I.descent()) + ((float) this.f1399f.centerY());
                break;
        }
        switch (i4 & 7) {
            case 1:
                this.f1410q = ((float) this.f1399f.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.f1410q = ((float) this.f1399f.right) - f;
                break;
            default:
                this.f1410q = (float) this.f1399f.left;
                break;
        }
        m2131k();
        m2125e(f2);
    }

    private void m2124d(float f) {
        this.f1401h.left = C0280i.m2118a((float) this.f1399f.left, (float) this.f1400g.left, f, this.f1386J);
        this.f1401h.top = C0280i.m2118a(this.f1408o, this.f1409p, f, this.f1386J);
        this.f1401h.right = C0280i.m2118a((float) this.f1399f.right, (float) this.f1400g.right, f, this.f1386J);
        this.f1401h.bottom = C0280i.m2118a((float) this.f1399f.bottom, (float) this.f1400g.bottom, f, this.f1386J);
    }

    public void m2136a(Canvas canvas) {
        int save = canvas.save();
        if (this.f1418y != null && this.f1397d) {
            float f;
            float f2 = this.f1412s;
            float f3 = this.f1413t;
            int i = (!this.f1377A || this.f1378B == null) ? 0 : 1;
            float f4;
            if (i != 0) {
                f = this.f1380D * this.f1382F;
                f4 = this.f1381E * this.f1382F;
            } else {
                f = this.f1385I.ascent() * this.f1382F;
                f4 = this.f1385I.descent() * this.f1382F;
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.f1382F != 1.0f) {
                canvas.scale(this.f1382F, this.f1382F, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.f1378B, f2, f3, this.f1379C);
            } else {
                canvas.drawText(this.f1418y, 0, this.f1418y.length(), f2, f3, this.f1385I);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean m2122b(CharSequence charSequence) {
        int i = 1;
        if (ao.m3938h(this.f1396c) != 1) {
            i = 0;
        }
        return (i != 0 ? C0487e.f1928d : C0487e.f1927c).mo416a(charSequence, 0, charSequence.length());
    }

    private void m2125e(float f) {
        m2127f(f);
        boolean z = f1375a && this.f1382F != 1.0f;
        this.f1377A = z;
        if (this.f1377A) {
            m2130j();
        }
        ao.m3928d(this.f1396c);
    }

    private void m2127f(float f) {
        boolean z = true;
        if (this.f1417x != null) {
            float width;
            float f2;
            boolean z2;
            if (C0280i.m2120a(f, this.f1405l)) {
                width = (float) this.f1400g.width();
                float f3 = this.f1405l;
                this.f1382F = 1.0f;
                if (this.f1416w != this.f1414u) {
                    this.f1416w = this.f1414u;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.f1399f.width();
                width = this.f1404k;
                if (this.f1416w != this.f1415v) {
                    this.f1416w = this.f1415v;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (C0280i.m2120a(f, this.f1404k)) {
                    this.f1382F = 1.0f;
                } else {
                    this.f1382F = f / this.f1404k;
                }
            }
            if (f2 > 0.0f) {
                if (this.f1383G != width || this.f1384H || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f1383G = width;
                this.f1384H = false;
            }
            if (this.f1418y == null || r0) {
                this.f1385I.setTextSize(this.f1383G);
                this.f1385I.setTypeface(this.f1416w);
                TextPaint textPaint = this.f1385I;
                if (this.f1382F == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence ellipsize = TextUtils.ellipsize(this.f1417x, this.f1385I, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f1418y)) {
                    this.f1418y = ellipsize;
                    this.f1419z = m2122b(this.f1418y);
                }
            }
        }
    }

    private void m2130j() {
        if (this.f1378B == null && !this.f1399f.isEmpty() && !TextUtils.isEmpty(this.f1418y)) {
            m2123c(0.0f);
            this.f1380D = this.f1385I.ascent();
            this.f1381E = this.f1385I.descent();
            int round = Math.round(this.f1385I.measureText(this.f1418y, 0, this.f1418y.length()));
            int round2 = Math.round(this.f1381E - this.f1380D);
            if (round > 0 && round2 > 0) {
                this.f1378B = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.f1378B).drawText(this.f1418y, 0, this.f1418y.length(), 0.0f, ((float) round2) - this.f1385I.descent(), this.f1385I);
                if (this.f1379C == null) {
                    this.f1379C = new Paint(3);
                }
            }
        }
    }

    public void m2149e() {
        if (this.f1396c.getHeight() > 0 && this.f1396c.getWidth() > 0) {
            m2129i();
            m2128h();
        }
    }

    void m2139a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f1417x)) {
            this.f1417x = charSequence;
            this.f1418y = null;
            m2131k();
            m2149e();
        }
    }

    CharSequence m2151f() {
        return this.f1417x;
    }

    private void m2131k() {
        if (this.f1378B != null) {
            this.f1378B.recycle();
            this.f1378B = null;
        }
    }

    private static boolean m2120a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    int m2152g() {
        return this.f1407n;
    }

    private static int m2119a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static float m2118a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return C0252a.m1907a(f, f2, f3);
    }

    private static boolean m2121a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
