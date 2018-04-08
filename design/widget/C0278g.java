package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.C0461a;

class C0278g extends Drawable {
    final Paint f1363a = new Paint(1);
    final Rect f1364b = new Rect();
    final RectF f1365c = new RectF();
    float f1366d;
    private int f1367e;
    private int f1368f;
    private int f1369g;
    private int f1370h;
    private ColorStateList f1371i;
    private int f1372j;
    private boolean f1373k = true;
    private float f1374l;

    public C0278g() {
        this.f1363a.setStyle(Style.STROKE);
    }

    void m2115a(int i, int i2, int i3, int i4) {
        this.f1367e = i;
        this.f1368f = i2;
        this.f1369g = i3;
        this.f1370h = i4;
    }

    void m2114a(float f) {
        if (this.f1366d != f) {
            this.f1366d = f;
            this.f1363a.setStrokeWidth(1.3333f * f);
            this.f1373k = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f1373k) {
            this.f1363a.setShader(m2113a());
            this.f1373k = false;
        }
        float strokeWidth = this.f1363a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f1365c;
        copyBounds(this.f1364b);
        rectF.set(this.f1364b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f1374l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f1363a);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f1366d);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.f1363a.setAlpha(i);
        invalidateSelf();
    }

    void m2116a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f1372j = colorStateList.getColorForState(getState(), this.f1372j);
        }
        this.f1371i = colorStateList;
        this.f1373k = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1363a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f1366d > 0.0f ? -3 : -2;
    }

    final void m2117b(float f) {
        if (f != this.f1374l) {
            this.f1374l = f;
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        this.f1373k = true;
    }

    public boolean isStateful() {
        return (this.f1371i != null && this.f1371i.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f1371i != null) {
            int colorForState = this.f1371i.getColorForState(iArr, this.f1372j);
            if (colorForState != this.f1372j) {
                this.f1373k = true;
                this.f1372j = colorForState;
            }
        }
        if (this.f1373k) {
            invalidateSelf();
        }
        return this.f1373k;
    }

    private Shader m2113a() {
        Rect rect = this.f1364b;
        copyBounds(rect);
        float height = this.f1366d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0461a.m3047a(this.f1367e, this.f1372j), C0461a.m3047a(this.f1368f, this.f1372j), C0461a.m3047a(C0461a.m3049b(this.f1368f, 0), this.f1372j), C0461a.m3047a(C0461a.m3049b(this.f1370h, 0), this.f1372j), C0461a.m3047a(this.f1370h, this.f1372j), C0461a.m3047a(this.f1369g, this.f1372j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }
}
