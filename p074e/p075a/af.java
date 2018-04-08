package com.p074e.p075a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.p074e.p075a.ab.C1406d;

final class af extends BitmapDrawable {
    private static final Paint f5344e = new Paint();
    Drawable f5345a;
    long f5346b;
    boolean f5347c;
    int f5348d = 255;
    private final boolean f5349f;
    private final float f5350g;
    private final C1406d f5351h;

    static void m9000a(ImageView imageView, Context context, Bitmap bitmap, C1406d c1406d, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new af(context, bitmap, drawable, c1406d, z, z2));
    }

    static void m9001a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    af(Context context, Bitmap bitmap, Drawable drawable, C1406d c1406d, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f5349f = z2;
        this.f5350g = context.getResources().getDisplayMetrics().density;
        this.f5351h = c1406d;
        boolean z3 = (c1406d == C1406d.MEMORY || z) ? false : true;
        if (z3) {
            this.f5345a = drawable;
            this.f5347c = true;
            this.f5346b = SystemClock.uptimeMillis();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f5347c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f5346b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f5347c = false;
                this.f5345a = null;
                super.draw(canvas);
            } else {
                if (this.f5345a != null) {
                    this.f5345a.draw(canvas);
                }
                super.setAlpha((int) (uptimeMillis * ((float) this.f5348d)));
                super.draw(canvas);
                super.setAlpha(this.f5348d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f5349f) {
            m8999a(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f5348d = i;
        if (this.f5345a != null) {
            this.f5345a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f5345a != null) {
            this.f5345a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f5345a != null) {
            this.f5345a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private void m8999a(Canvas canvas) {
        f5344e.setColor(-1);
        canvas.drawPath(af.m8998a(new Point(0, 0), (int) (16.0f * this.f5350g)), f5344e);
        f5344e.setColor(this.f5351h.f5319d);
        canvas.drawPath(af.m8998a(new Point(0, 0), (int) (15.0f * this.f5350g)), f5344e);
    }

    private static Path m8998a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }
}
