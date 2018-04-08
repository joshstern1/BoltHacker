package com.facebook.shimmer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.facebook.shimmer.C1470a.C1469a;

public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode f5560c = new PorterDuffXfermode(Mode.DST_IN);
    protected ValueAnimator f5561a;
    protected Bitmap f5562b;
    private Paint f5563d;
    private Paint f5564e;
    private C1465a f5565f;
    private C1468d f5566g;
    private Bitmap f5567h;
    private Bitmap f5568i;
    private boolean f5569j;
    private int f5570k;
    private int f5571l;
    private int f5572m;
    private int f5573n;
    private int f5574o;
    private int f5575p;
    private boolean f5576q;
    private OnGlobalLayoutListener f5577r;

    private static class C1465a {
        public C1466b f5539a;
        public float f5540b;
        public float f5541c;
        public int f5542d;
        public int f5543e;
        public float f5544f;
        public float f5545g;
        public float f5546h;
        public C1467c f5547i;

        private C1465a() {
        }

        public int m9198a(int i) {
            return this.f5542d > 0 ? this.f5542d : (int) (((float) i) * this.f5545g);
        }

        public int m9200b(int i) {
            return this.f5543e > 0 ? this.f5543e : (int) (((float) i) * this.f5546h);
        }

        public int[] m9199a() {
            switch (this.f5547i) {
                case RADIAL:
                    return new int[]{-16777216, -16777216, 0};
                default:
                    return new int[]{0, -16777216, -16777216, 0};
            }
        }

        public float[] m9201b() {
            switch (this.f5547i) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.f5544f, 1.0f), Math.min(this.f5544f + this.f5541c, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.f5544f) - this.f5541c) / 2.0f, 0.0f), Math.max((1.0f - this.f5544f) / 2.0f, 0.0f), Math.min((this.f5544f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f5544f + 1.0f) + this.f5541c) / 2.0f, 1.0f)};
            }
        }
    }

    public enum C1466b {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    public enum C1467c {
        LINEAR,
        RADIAL
    }

    private static class C1468d {
        public int f5556a;
        public int f5557b;
        public int f5558c;
        public int f5559d;

        private C1468d() {
        }

        public void m9202a(int i, int i2, int i3, int i4) {
            this.f5556a = i;
            this.f5557b = i2;
            this.f5558c = i3;
            this.f5559d = i4;
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.f5565f = new C1465a();
        this.f5563d = new Paint();
        this.f5564e = new Paint();
        this.f5564e.setAntiAlias(true);
        this.f5564e.setDither(true);
        this.f5564e.setFilterBitmap(true);
        this.f5564e.setXfermode(f5560c);
        m9220a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1469a.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(0, false));
                }
                if (obtainStyledAttributes.hasValue(1)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(1, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setDuration(obtainStyledAttributes.getInt(2, 0));
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    setRepeatCount(obtainStyledAttributes.getInt(3, 0));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    setRepeatMode(obtainStyledAttributes.getInt(5, 0));
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    switch (obtainStyledAttributes.getInt(6, 0)) {
                        case 90:
                            this.f5565f.f5539a = C1466b.CW_90;
                            break;
                        case 180:
                            this.f5565f.f5539a = C1466b.CW_180;
                            break;
                        case 270:
                            this.f5565f.f5539a = C1466b.CW_270;
                            break;
                        default:
                            this.f5565f.f5539a = C1466b.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    switch (obtainStyledAttributes.getInt(13, 0)) {
                        case 1:
                            this.f5565f.f5547i = C1467c.RADIAL;
                            break;
                        default:
                            this.f5565f.f5547i = C1467c.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.f5565f.f5541c = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.f5565f.f5542d = obtainStyledAttributes.getDimensionPixelSize(8, 0);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.f5565f.f5543e = obtainStyledAttributes.getDimensionPixelSize(9, 0);
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    this.f5565f.f5544f = obtainStyledAttributes.getFloat(10, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    this.f5565f.f5545g = obtainStyledAttributes.getFloat(11, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    this.f5565f.f5546h = obtainStyledAttributes.getFloat(12, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.f5565f.f5540b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void m9220a() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f5565f.f5539a = C1466b.CW_0;
        this.f5565f.f5547i = C1467c.LINEAR;
        this.f5565f.f5541c = 0.5f;
        this.f5565f.f5542d = 0;
        this.f5565f.f5543e = 0;
        this.f5565f.f5544f = 0.0f;
        this.f5565f.f5545g = 1.0f;
        this.f5565f.f5546h = 1.0f;
        this.f5565f.f5540b = 20.0f;
        this.f5566g = new C1468d();
        setBaseAlpha(0.3f);
        m9217g();
    }

    public void setAutoStart(boolean z) {
        this.f5569j = z;
        m9217g();
    }

    public float getBaseAlpha() {
        return ((float) this.f5563d.getAlpha()) / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.f5563d.setAlpha((int) (m9203a(0.0f, 1.0f, f) * 255.0f));
        m9217g();
    }

    public int getDuration() {
        return this.f5570k;
    }

    public void setDuration(int i) {
        this.f5570k = i;
        m9217g();
    }

    public int getRepeatCount() {
        return this.f5571l;
    }

    public void setRepeatCount(int i) {
        this.f5571l = i;
        m9217g();
    }

    public int getRepeatDelay() {
        return this.f5572m;
    }

    public void setRepeatDelay(int i) {
        this.f5572m = i;
        m9217g();
    }

    public int getRepeatMode() {
        return this.f5573n;
    }

    public void setRepeatMode(int i) {
        this.f5573n = i;
        m9217g();
    }

    public C1467c getMaskShape() {
        return this.f5565f.f5547i;
    }

    public void setMaskShape(C1467c c1467c) {
        this.f5565f.f5547i = c1467c;
        m9217g();
    }

    public C1466b getAngle() {
        return this.f5565f.f5539a;
    }

    public void setAngle(C1466b c1466b) {
        this.f5565f.f5539a = c1466b;
        m9217g();
    }

    public float getDropoff() {
        return this.f5565f.f5541c;
    }

    public void setDropoff(float f) {
        this.f5565f.f5541c = f;
        m9217g();
    }

    public int getFixedWidth() {
        return this.f5565f.f5542d;
    }

    public void setFixedWidth(int i) {
        this.f5565f.f5542d = i;
        m9217g();
    }

    public int getFixedHeight() {
        return this.f5565f.f5543e;
    }

    public void setFixedHeight(int i) {
        this.f5565f.f5543e = i;
        m9217g();
    }

    public float getIntensity() {
        return this.f5565f.f5544f;
    }

    public void setIntensity(float f) {
        this.f5565f.f5544f = f;
        m9217g();
    }

    public float getRelativeWidth() {
        return this.f5565f.f5545g;
    }

    public void setRelativeWidth(int i) {
        this.f5565f.f5545g = (float) i;
        m9217g();
    }

    public float getRelativeHeight() {
        return this.f5565f.f5546h;
    }

    public void setRelativeHeight(int i) {
        this.f5565f.f5546h = (float) i;
        m9217g();
    }

    public float getTilt() {
        return this.f5565f.f5540b;
    }

    public void setTilt(float f) {
        this.f5565f.f5540b = f;
        m9217g();
    }

    public void m9221b() {
        if (!this.f5576q) {
            getShimmerAnimation().start();
            this.f5576q = true;
        }
    }

    public void m9222c() {
        if (this.f5561a != null) {
            this.f5561a.end();
            this.f5561a.removeAllUpdateListeners();
            this.f5561a.cancel();
        }
        this.f5561a = null;
        this.f5576q = false;
    }

    private void setMaskOffsetX(int i) {
        if (this.f5574o != i) {
            this.f5574o = i;
            invalidate();
        }
    }

    private void setMaskOffsetY(int i) {
        if (this.f5575p != i) {
            this.f5575p = i;
            invalidate();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5577r == null) {
            this.f5577r = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f5577r);
    }

    private OnGlobalLayoutListener getLayoutListener() {
        return new C1471b(this);
    }

    protected void onDetachedFromWindow() {
        m9222c();
        if (this.f5577r != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f5577r);
            this.f5577r = null;
        }
        super.onDetachedFromWindow();
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.f5576q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            m9206a(canvas);
        }
    }

    private static float m9203a(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean m9206a(Canvas canvas) {
        Bitmap d = m9213d();
        Bitmap e = m9215e();
        if (d == null || e == null) {
            return false;
        }
        m9208b(new Canvas(d));
        canvas.drawBitmap(d, 0.0f, 0.0f, this.f5563d);
        m9211c(new Canvas(e));
        canvas.drawBitmap(e, 0.0f, 0.0f, null);
        return true;
    }

    private Bitmap m9213d() {
        if (this.f5568i == null) {
            this.f5568i = m9216f();
        }
        return this.f5568i;
    }

    private Bitmap m9215e() {
        if (this.f5567h == null) {
            this.f5567h = m9216f();
        }
        return this.f5567h;
    }

    private Bitmap m9216f() {
        int width = getWidth();
        int height = getHeight();
        try {
            return m9204a(width, height);
        } catch (OutOfMemoryError e) {
            StringBuilder stringBuilder = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            stringBuilder.append(" (width = ");
            stringBuilder.append(width);
            stringBuilder.append(", height = ");
            stringBuilder.append(height);
            stringBuilder.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append("\n");
            }
            Log.d("ShimmerFrameLayout", stringBuilder.toString());
            return null;
        }
    }

    private void m9208b(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void m9211c(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.f5574o, this.f5575p, this.f5574o + maskBitmap.getWidth(), this.f5575p + maskBitmap.getHeight());
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, (float) this.f5574o, (float) this.f5575p, this.f5564e);
        }
    }

    private void m9217g() {
        m9222c();
        m9218h();
        m9219i();
    }

    private void m9218h() {
        if (this.f5562b != null) {
            this.f5562b.recycle();
            this.f5562b = null;
        }
    }

    private void m9219i() {
        if (this.f5568i != null) {
            this.f5568i.recycle();
            this.f5568i = null;
        }
        if (this.f5567h != null) {
            this.f5567h.recycle();
            this.f5567h = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f5562b != null) {
            return this.f5562b;
        }
        Shader radialGradient;
        int a = this.f5565f.m9198a(getWidth());
        int b = this.f5565f.m9200b(getHeight());
        this.f5562b = m9204a(a, b);
        Canvas canvas = new Canvas(this.f5562b);
        switch (this.f5565f.f5547i) {
            case RADIAL:
                radialGradient = new RadialGradient((float) (a / 2), (float) (b / 2), (float) (((double) Math.max(a, b)) / Math.sqrt(2.0d)), this.f5565f.m9199a(), this.f5565f.m9201b(), TileMode.REPEAT);
                break;
            default:
                int i;
                int i2;
                int i3;
                int i4;
                switch (this.f5565f.f5539a) {
                    case CW_90:
                        i = b;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = a;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = b;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = a;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient((float) i4, (float) i3, (float) i2, (float) i, this.f5565f.m9199a(), this.f5565f.m9201b(), TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.f5565f.f5540b, (float) (a / 2), (float) (b / 2));
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * ((double) Math.max(a, b)))) / 2;
        float f = (float) (sqrt + b);
        canvas.drawRect((float) (-sqrt), (float) (-sqrt), (float) (a + sqrt), f, paint);
        return this.f5562b;
    }

    private Animator getShimmerAnimation() {
        if (this.f5561a != null) {
            return this.f5561a;
        }
        int width = getWidth();
        int height = getHeight();
        int i = C14641.f5537a[this.f5565f.f5547i.ordinal()];
        switch (this.f5565f.f5539a) {
            case CW_90:
                this.f5566g.m9202a(0, -height, 0, height);
                break;
            case CW_180:
                this.f5566g.m9202a(width, 0, -width, 0);
                break;
            case CW_270:
                this.f5566g.m9202a(0, height, 0, -height);
                break;
            default:
                this.f5566g.m9202a(-width, 0, width, 0);
                break;
        }
        this.f5561a = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f + (((float) this.f5572m) / ((float) this.f5570k))});
        this.f5561a.setDuration((long) (this.f5570k + this.f5572m));
        this.f5561a.setRepeatCount(this.f5571l);
        this.f5561a.setRepeatMode(this.f5573n);
        this.f5561a.addUpdateListener(new C1472c(this));
        return this.f5561a;
    }

    protected static Bitmap m9204a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
    }
}
