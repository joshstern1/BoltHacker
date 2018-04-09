package android.support.v7.p018d.p019a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0840j;
import android.support.v7.p028b.C0842a.C0841k;

public class C0783b extends Drawable {
    private static final float f2551b = ((float) Math.toRadians(45.0d));
    private final Paint f2552a = new Paint();
    private float f2553c;
    private float f2554d;
    private float f2555e;
    private float f2556f;
    private boolean f2557g;
    private final Path f2558h = new Path();
    private final int f2559i;
    private boolean f2560j = false;
    private float f2561k;
    private float f2562l;
    private int f2563m = 2;

    public C0783b(Context context) {
        this.f2552a.setStyle(Style.STROKE);
        this.f2552a.setStrokeJoin(Join.MITER);
        this.f2552a.setStrokeCap(Cap.BUTT);
        this.f2552a.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, C0841k.DrawerArrowToggle, C0831a.drawerArrowStyle, C0840j.Base_Widget_AppCompat_DrawerArrowToggle);
        m5185a(obtainStyledAttributes.getColor(C0841k.DrawerArrowToggle_color, 0));
        m5187b(obtainStyledAttributes.getDimension(C0841k.DrawerArrowToggle_thickness, 0.0f));
        m5186a(obtainStyledAttributes.getBoolean(C0841k.DrawerArrowToggle_spinBars, true));
        m5189c((float) Math.round(obtainStyledAttributes.getDimension(C0841k.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f2559i = obtainStyledAttributes.getDimensionPixelSize(C0841k.DrawerArrowToggle_drawableSize, 0);
        this.f2554d = (float) Math.round(obtainStyledAttributes.getDimension(C0841k.DrawerArrowToggle_barLength, 0.0f));
        this.f2553c = (float) Math.round(obtainStyledAttributes.getDimension(C0841k.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f2555e = obtainStyledAttributes.getDimension(C0841k.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void m5185a(int i) {
        if (i != this.f2552a.getColor()) {
            this.f2552a.setColor(i);
            invalidateSelf();
        }
    }

    public void m5187b(float f) {
        if (this.f2552a.getStrokeWidth() != f) {
            this.f2552a.setStrokeWidth(f);
            this.f2562l = (float) (((double) (f / 2.0f)) * Math.cos((double) f2551b));
            invalidateSelf();
        }
    }

    public void m5189c(float f) {
        if (f != this.f2556f) {
            this.f2556f = f;
            invalidateSelf();
        }
    }

    public void m5186a(boolean z) {
        if (this.f2557g != z) {
            this.f2557g = z;
            invalidateSelf();
        }
    }

    public void m5188b(boolean z) {
        if (this.f2560j != z) {
            this.f2560j = z;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        int i;
        float f;
        float f2;
        Rect bounds = getBounds();
        switch (this.f2563m) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 3:
                if (C0441a.m3004h(this) != 0) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
            default:
                if (C0441a.m3004h(this) != 1) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
        }
        float a = C0783b.m5184a(this.f2554d, (float) Math.sqrt((double) ((this.f2553c * this.f2553c) * 2.0f)), this.f2561k);
        float a2 = C0783b.m5184a(this.f2554d, this.f2555e, this.f2561k);
        float round = (float) Math.round(C0783b.m5184a(0.0f, this.f2562l, this.f2561k));
        float a3 = C0783b.m5184a(0.0f, f2551b, this.f2561k);
        if (i != 0) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (i != 0) {
            f2 = 180.0f;
        } else {
            f2 = 0.0f;
        }
        f2 = C0783b.m5184a(f, f2, this.f2561k);
        f = (float) Math.round(((double) a) * Math.cos((double) a3));
        a = (float) Math.round(((double) a) * Math.sin((double) a3));
        this.f2558h.rewind();
        a3 = C0783b.m5184a(this.f2556f + this.f2552a.getStrokeWidth(), -this.f2562l, this.f2561k);
        float f3 = (-a2) / 2.0f;
        this.f2558h.moveTo(f3 + round, 0.0f);
        this.f2558h.rLineTo(a2 - (round * 2.0f), 0.0f);
        this.f2558h.moveTo(f3, a3);
        this.f2558h.rLineTo(f, a);
        this.f2558h.moveTo(f3, -a3);
        this.f2558h.rLineTo(f, -a);
        this.f2558h.close();
        canvas.save();
        f = this.f2552a.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), (float) (((double) ((float) ((((int) ((((float) bounds.height()) - (3.0f * f)) - (this.f2556f * 2.0f))) / 4) * 2))) + ((((double) f) * 1.5d) + ((double) this.f2556f))));
        if (this.f2557g) {
            canvas.rotate(((float) ((i ^ this.f2560j) != 0 ? -1 : 1)) * f2);
        } else if (i != 0) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f2558h, this.f2552a);
        canvas.restore();
    }

    public void setAlpha(int i) {
        if (i != this.f2552a.getAlpha()) {
            this.f2552a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2552a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f2559i;
    }

    public int getIntrinsicWidth() {
        return this.f2559i;
    }

    public int getOpacity() {
        return -3;
    }

    public void m5190d(float f) {
        if (this.f2561k != f) {
            this.f2561k = f;
            invalidateSelf();
        }
    }

    private static float m5184a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
