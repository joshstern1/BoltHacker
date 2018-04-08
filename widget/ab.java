package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.p026b.C0600b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

class ab extends Drawable implements Animatable {
    private static final Interpolator f2345b = new LinearInterpolator();
    private static final Interpolator f2346c = new C0600b();
    boolean f2347a;
    private final int[] f2348d = new int[]{-16777216};
    private final ArrayList<Animation> f2349e = new ArrayList();
    private final C0700a f2350f;
    private float f2351g;
    private Resources f2352h;
    private View f2353i;
    private Animation f2354j;
    private float f2355k;
    private double f2356l;
    private double f2357m;
    private final Callback f2358n = new ae(this);

    private static class C0700a {
        private final RectF f2321a = new RectF();
        private final Paint f2322b = new Paint();
        private final Paint f2323c = new Paint();
        private final Callback f2324d;
        private float f2325e = 0.0f;
        private float f2326f = 0.0f;
        private float f2327g = 0.0f;
        private float f2328h = 5.0f;
        private float f2329i = 2.5f;
        private int[] f2330j;
        private int f2331k;
        private float f2332l;
        private float f2333m;
        private float f2334n;
        private boolean f2335o;
        private Path f2336p;
        private float f2337q;
        private double f2338r;
        private int f2339s;
        private int f2340t;
        private int f2341u;
        private final Paint f2342v = new Paint(1);
        private int f2343w;
        private int f2344x;

        public C0700a(Callback callback) {
            this.f2324d = callback;
            this.f2322b.setStrokeCap(Cap.SQUARE);
            this.f2322b.setAntiAlias(true);
            this.f2322b.setStyle(Style.STROKE);
            this.f2323c.setStyle(Style.FILL);
            this.f2323c.setAntiAlias(true);
        }

        public void m4636a(int i) {
            this.f2343w = i;
        }

        public void m4635a(float f, float f2) {
            this.f2339s = (int) f;
            this.f2340t = (int) f2;
        }

        public void m4638a(Canvas canvas, Rect rect) {
            RectF rectF = this.f2321a;
            rectF.set(rect);
            rectF.inset(this.f2329i, this.f2329i);
            float f = (this.f2325e + this.f2327g) * 360.0f;
            float f2 = ((this.f2326f + this.f2327g) * 360.0f) - f;
            this.f2322b.setColor(this.f2344x);
            canvas.drawArc(rectF, f, f2, false, this.f2322b);
            m4629a(canvas, f, f2, rect);
            if (this.f2341u < 255) {
                this.f2342v.setColor(this.f2343w);
                this.f2342v.setAlpha(255 - this.f2341u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f2342v);
            }
        }

        private void m4629a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f2335o) {
                if (this.f2336p == null) {
                    this.f2336p = new Path();
                    this.f2336p.setFillType(FillType.EVEN_ODD);
                } else {
                    this.f2336p.reset();
                }
                float f3 = ((float) (((int) this.f2329i) / 2)) * this.f2337q;
                float cos = (float) ((this.f2338r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.f2338r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.f2336p.moveTo(0.0f, 0.0f);
                this.f2336p.lineTo(((float) this.f2339s) * this.f2337q, 0.0f);
                this.f2336p.lineTo((((float) this.f2339s) * this.f2337q) / 2.0f, ((float) this.f2340t) * this.f2337q);
                this.f2336p.offset(cos - f3, sin);
                this.f2336p.close();
                this.f2323c.setColor(this.f2344x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f2336p, this.f2323c);
            }
        }

        public void m4641a(int[] iArr) {
            this.f2330j = iArr;
            m4647c(0);
        }

        public void m4644b(int i) {
            this.f2344x = i;
        }

        public void m4647c(int i) {
            this.f2331k = i;
            this.f2344x = this.f2330j[this.f2331k];
        }

        public int m4632a() {
            return this.f2330j[m4630n()];
        }

        private int m4630n() {
            return (this.f2331k + 1) % this.f2330j.length;
        }

        public void m4642b() {
            m4647c(m4630n());
        }

        public void m4639a(ColorFilter colorFilter) {
            this.f2322b.setColorFilter(colorFilter);
            m4631o();
        }

        public void m4650d(int i) {
            this.f2341u = i;
        }

        public int m4645c() {
            return this.f2341u;
        }

        public void m4634a(float f) {
            this.f2328h = f;
            this.f2322b.setStrokeWidth(f);
            m4631o();
        }

        public float m4648d() {
            return this.f2328h;
        }

        public void m4643b(float f) {
            this.f2325e = f;
            m4631o();
        }

        public float m4651e() {
            return this.f2325e;
        }

        public float m4653f() {
            return this.f2332l;
        }

        public float m4654g() {
            return this.f2333m;
        }

        public int m4655h() {
            return this.f2330j[this.f2331k];
        }

        public void m4646c(float f) {
            this.f2326f = f;
            m4631o();
        }

        public float m4656i() {
            return this.f2326f;
        }

        public void m4649d(float f) {
            this.f2327g = f;
            m4631o();
        }

        public void m4637a(int i, int i2) {
            float min = (float) Math.min(i, i2);
            if (this.f2338r <= 0.0d || min < 0.0f) {
                min = (float) Math.ceil((double) (this.f2328h / 2.0f));
            } else {
                min = (float) (((double) (min / 2.0f)) - this.f2338r);
            }
            this.f2329i = min;
        }

        public void m4633a(double d) {
            this.f2338r = d;
        }

        public double m4657j() {
            return this.f2338r;
        }

        public void m4640a(boolean z) {
            if (this.f2335o != z) {
                this.f2335o = z;
                m4631o();
            }
        }

        public void m4652e(float f) {
            if (f != this.f2337q) {
                this.f2337q = f;
                m4631o();
            }
        }

        public float m4658k() {
            return this.f2334n;
        }

        public void m4659l() {
            this.f2332l = this.f2325e;
            this.f2333m = this.f2326f;
            this.f2334n = this.f2327g;
        }

        public void m4660m() {
            this.f2332l = 0.0f;
            this.f2333m = 0.0f;
            this.f2334n = 0.0f;
            m4643b(0.0f);
            m4646c(0.0f);
            m4649d(0.0f);
        }

        private void m4631o() {
            this.f2324d.invalidateDrawable(null);
        }
    }

    public ab(Context context, View view) {
        this.f2353i = view;
        this.f2352h = context.getResources();
        this.f2350f = new C0700a(this.f2358n);
        this.f2350f.m4641a(this.f2348d);
        m4675a(1);
        m4670b();
    }

    private void m4667a(double d, double d2, double d3, double d4, float f, float f2) {
        C0700a c0700a = this.f2350f;
        float f3 = this.f2352h.getDisplayMetrics().density;
        this.f2356l = ((double) f3) * d;
        this.f2357m = ((double) f3) * d2;
        c0700a.m4634a(((float) d4) * f3);
        c0700a.m4633a(((double) f3) * d3);
        c0700a.m4647c(0);
        c0700a.m4635a(f * f3, f3 * f2);
        c0700a.m4637a((int) this.f2356l, (int) this.f2357m);
    }

    public void m4675a(int i) {
        if (i == 0) {
            m4667a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m4667a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m4676a(boolean z) {
        this.f2350f.m4640a(z);
    }

    public void m4673a(float f) {
        this.f2350f.m4652e(f);
    }

    public void m4674a(float f, float f2) {
        this.f2350f.m4643b(f);
        this.f2350f.m4646c(f2);
    }

    public void m4678b(float f) {
        this.f2350f.m4649d(f);
    }

    public void m4679b(int i) {
        this.f2350f.m4636a(i);
    }

    public void m4677a(int... iArr) {
        this.f2350f.m4641a(iArr);
        this.f2350f.m4647c(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.f2357m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f2356l;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f2351g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f2350f.m4638a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f2350f.m4650d(i);
    }

    public int getAlpha() {
        return this.f2350f.m4645c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2350f.m4639a(colorFilter);
    }

    void m4680c(float f) {
        this.f2351g = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f2349e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f2354j.reset();
        this.f2350f.m4659l();
        if (this.f2350f.m4656i() != this.f2350f.m4651e()) {
            this.f2347a = true;
            this.f2354j.setDuration(666);
            this.f2353i.startAnimation(this.f2354j);
            return;
        }
        this.f2350f.m4647c(0);
        this.f2350f.m4660m();
        this.f2354j.setDuration(1332);
        this.f2353i.startAnimation(this.f2354j);
    }

    public void stop() {
        this.f2353i.clearAnimation();
        m4680c(0.0f);
        this.f2350f.m4640a(false);
        this.f2350f.m4647c(0);
        this.f2350f.m4660m();
    }

    private float m4661a(C0700a c0700a) {
        return (float) Math.toRadians(((double) c0700a.m4648d()) / (6.283185307179586d * c0700a.m4657j()));
    }

    private int m4665a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    private void m4668a(float f, C0700a c0700a) {
        if (f > 0.75f) {
            c0700a.m4644b(m4665a((f - 0.75f) / 0.25f, c0700a.m4655h(), c0700a.m4632a()));
        }
    }

    private void m4671b(float f, C0700a c0700a) {
        m4668a(f, c0700a);
        float floor = (float) (Math.floor((double) (c0700a.m4658k() / 0.8f)) + 1.0d);
        float a = m4661a(c0700a);
        c0700a.m4643b((((c0700a.m4654g() - a) - c0700a.m4653f()) * f) + c0700a.m4653f());
        c0700a.m4646c(c0700a.m4654g());
        c0700a.m4649d(((floor - c0700a.m4658k()) * f) + c0700a.m4658k());
    }

    private void m4670b() {
        C0700a c0700a = this.f2350f;
        Animation acVar = new ac(this, c0700a);
        acVar.setRepeatCount(-1);
        acVar.setRepeatMode(1);
        acVar.setInterpolator(f2345b);
        acVar.setAnimationListener(new ad(this, c0700a));
        this.f2354j = acVar;
    }
}
