package io.codetail.p122a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class C3076c {
    public static final C3074b f10162a = new C3074b();
    private Map<View, C3075c> f10163b = new HashMap();

    static class C3073a extends AnimatorListenerAdapter {
        private C3075c f10149a;
        private int f10150b;
        private int f10151c;

        C3073a(C3075c c3075c, int i) {
            this.f10149a = c3075c;
            this.f10150b = i;
            this.f10151c = c3075c.f10159g.getLayerType();
        }

        public void onAnimationStart(Animator animator) {
            this.f10149a.m17399b().setLayerType(this.f10150b, null);
        }

        public void onAnimationCancel(Animator animator) {
            this.f10149a.m17399b().setLayerType(this.f10151c, null);
        }

        public void onAnimationEnd(Animator animator) {
            this.f10149a.m17399b().setLayerType(this.f10151c, null);
        }
    }

    private static final class C3074b extends Property<C3075c, Float> {
        public /* synthetic */ Object get(Object obj) {
            return m17393a((C3075c) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m17394a((C3075c) obj, (Float) obj2);
        }

        C3074b() {
            super(Float.class, "supportCircularReveal");
        }

        public void m17394a(C3075c c3075c, Float f) {
            c3075c.m17396a(f.floatValue());
            c3075c.m17399b().invalidate();
        }

        public Float m17393a(C3075c c3075c) {
            return Float.valueOf(c3075c.m17395a());
        }
    }

    public static final class C3075c {
        private static final Paint f10152j = new Paint(1);
        final int f10153a;
        final int f10154b;
        final float f10155c;
        final float f10156d;
        boolean f10157e;
        float f10158f;
        View f10159g;
        Path f10160h = new Path();
        Op f10161i = Op.REPLACE;

        static {
            f10152j.setColor(-16711936);
            f10152j.setStyle(Style.FILL);
            f10152j.setStrokeWidth(2.0f);
        }

        public C3075c(View view, int i, int i2, float f, float f2) {
            this.f10159g = view;
            this.f10153a = i;
            this.f10154b = i2;
            this.f10155c = f;
            this.f10156d = f2;
        }

        public void m17396a(float f) {
            this.f10158f = f;
        }

        public float m17395a() {
            return this.f10158f;
        }

        public View m17399b() {
            return this.f10159g;
        }

        public void m17397a(boolean z) {
            this.f10157e = z;
        }

        boolean m17398a(Canvas canvas, View view) {
            if (view != this.f10159g || !this.f10157e) {
                return false;
            }
            this.f10160h.reset();
            this.f10160h.addCircle(view.getX() + ((float) this.f10153a), view.getY() + ((float) this.f10154b), this.f10158f, Direction.CW);
            canvas.clipPath(this.f10160h, this.f10161i);
            if (VERSION.SDK_INT >= 21) {
                view.invalidateOutline();
            }
            return true;
        }
    }

    protected ObjectAnimator m17403a(C3075c c3075c) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c3075c, f10162a, new float[]{c3075c.f10155c, c3075c.f10156d});
        ofFloat.addListener(new C3077d(this));
        this.f10163b.put(c3075c.m17399b(), c3075c);
        return ofFloat;
    }

    private static C3075c m17402b(Animator animator) {
        return (C3075c) ((ObjectAnimator) animator).getTarget();
    }

    protected boolean m17404a() {
        return false;
    }

    public boolean m17405a(Canvas canvas, View view) {
        C3075c c3075c = (C3075c) this.f10163b.get(view);
        return c3075c != null && c3075c.m17398a(canvas, view);
    }
}
