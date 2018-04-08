package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.C0192a.C0185c;
import android.support.v7.p018d.p019a.C0254a;

class ae extends C0254a {
    static final double f1259a = Math.cos(Math.toRadians(45.0d));
    final Paint f1260b;
    final Paint f1261c;
    final RectF f1262d;
    float f1263e;
    Path f1264f;
    float f1265g;
    float f1266h;
    float f1267i;
    float f1268j;
    private boolean f1269k = true;
    private final int f1270l;
    private final int f1271m;
    private final int f1272n;
    private boolean f1273o = true;
    private float f1274p;
    private boolean f1275q = false;

    public ae(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f1270l = resources.getColor(C0185c.design_fab_shadow_start_color);
        this.f1271m = resources.getColor(C0185c.design_fab_shadow_mid_color);
        this.f1272n = resources.getColor(C0185c.design_fab_shadow_end_color);
        this.f1260b = new Paint(5);
        this.f1260b.setStyle(Style.FILL);
        this.f1263e = (float) Math.round(f);
        this.f1262d = new RectF();
        this.f1261c = new Paint(this.f1260b);
        this.f1261c.setAntiAlias(false);
        m1929a(f2, f3);
    }

    private static int m1926d(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void m1930a(boolean z) {
        this.f1273o = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f1260b.setAlpha(i);
        this.f1261c.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.f1269k = true;
    }

    void m1929a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float d = (float) m1926d(f);
        float d2 = (float) m1926d(f2);
        if (d > d2) {
            if (!this.f1275q) {
                this.f1275q = true;
            }
            d = d2;
        }
        if (this.f1268j != d || this.f1266h != d2) {
            this.f1268j = d;
            this.f1266h = d2;
            this.f1267i = (float) Math.round(d * 1.5f);
            this.f1265g = d2;
            this.f1269k = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m1921a(this.f1266h, this.f1263e, this.f1273o));
        int ceil2 = (int) Math.ceil((double) m1924b(this.f1266h, this.f1263e, this.f1273o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float m1921a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f1259a) * ((double) f2)));
        }
        return 1.5f * f;
    }

    public static float m1924b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f1259a) * ((double) f2)));
        }
        return f;
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        if (this.f1269k) {
            m1923a(getBounds());
            this.f1269k = false;
        }
        m1922a(canvas);
        super.draw(canvas);
    }

    final void m1928a(float f) {
        if (this.f1274p != f) {
            this.f1274p = f;
            invalidateSelf();
        }
    }

    private void m1922a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f1274p, this.f1262d.centerX(), this.f1262d.centerY());
        float f = (-this.f1263e) - this.f1267i;
        float f2 = this.f1263e;
        Object obj = this.f1262d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f1262d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f1268j - (this.f1268j * 0.5f)) + f2);
        float f4 = f2 / ((this.f1268j - (this.f1268j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f1268j - (this.f1268j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f1262d.left + f2, this.f1262d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f1264f, this.f1260b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f1262d.width() - (2.0f * f2), -this.f1263e, this.f1261c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f1262d.right - f2, this.f1262d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1264f, this.f1260b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f1262d.width() - (2.0f * f2), this.f1267i + (-this.f1263e), this.f1261c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f1262d.left + f2, this.f1262d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1264f, this.f1260b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f1262d.height() - (2.0f * f2), -this.f1263e, this.f1261c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f1262d.right - f2, this.f1262d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1264f, this.f1260b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f1262d.height() - (2.0f * f2), -this.f1263e, this.f1261c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m1925c() {
        RectF rectF = new RectF(-this.f1263e, -this.f1263e, this.f1263e, this.f1263e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f1267i, -this.f1267i);
        if (this.f1264f == null) {
            this.f1264f = new Path();
        } else {
            this.f1264f.reset();
        }
        this.f1264f.setFillType(FillType.EVEN_ODD);
        this.f1264f.moveTo(-this.f1263e, 0.0f);
        this.f1264f.rLineTo(-this.f1267i, 0.0f);
        this.f1264f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1264f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1264f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f1263e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f1260b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f1270l, this.f1271m, this.f1272n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f1261c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f1270l, this.f1271m, this.f1272n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f1261c.setAntiAlias(false);
    }

    private void m1923a(Rect rect) {
        float f = this.f1266h * 1.5f;
        this.f1262d.set(((float) rect.left) + this.f1266h, ((float) rect.top) + f, ((float) rect.right) - this.f1266h, ((float) rect.bottom) - f);
        m1920b().setBounds((int) this.f1262d.left, (int) this.f1262d.top, (int) this.f1262d.right, (int) this.f1262d.bottom);
        m1925c();
    }

    public void m1931b(float f) {
        m1929a(f, this.f1266h);
    }

    public void m1932c(float f) {
        m1929a(this.f1268j, f);
    }

    public float m1927a() {
        return this.f1268j;
    }
}
