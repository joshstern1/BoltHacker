package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ao;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class C0721c extends ImageView {
    private AnimationListener f2425a;
    private int f2426b;

    private class C0720a extends OvalShape {
        final /* synthetic */ C0721c f2421a;
        private RadialGradient f2422b;
        private Paint f2423c = new Paint();
        private int f2424d;

        public C0720a(C0721c c0721c, int i, int i2) {
            this.f2421a = c0721c;
            c0721c.f2426b = i;
            this.f2424d = i2;
            this.f2422b = new RadialGradient((float) (this.f2424d / 2), (float) (this.f2424d / 2), (float) c0721c.f2426b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f2423c.setShader(this.f2422b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f2421a.getWidth();
            int height = this.f2421a.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f2424d / 2) + this.f2421a.f2426b), this.f2423c);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f2424d / 2), paint);
        }
    }

    public C0721c(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f2426b = (int) (3.5f * f2);
        if (m4849a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ao.m3935f((View) this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C0720a(this, this.f2426b, i2));
            ao.m3906a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f2426b, (float) i4, (float) i3, 503316480);
            int i5 = this.f2426b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean m4849a() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m4849a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f2426b * 2), getMeasuredHeight() + (this.f2426b * 2));
        }
    }

    public void m4850a(AnimationListener animationListener) {
        this.f2425a = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f2425a != null) {
            this.f2425a.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f2425a != null) {
            this.f2425a.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
