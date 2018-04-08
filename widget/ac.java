package android.support.v4.widget;

import android.support.v4.widget.ab.C0700a;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class ac extends Animation {
    final /* synthetic */ C0700a f2359a;
    final /* synthetic */ ab f2360b;

    ac(ab abVar, C0700a c0700a) {
        this.f2360b = abVar;
        this.f2359a = c0700a;
    }

    public void applyTransformation(float f, Transformation transformation) {
        if (this.f2360b.f2347a) {
            this.f2360b.m4671b(f, this.f2359a);
            return;
        }
        float a = this.f2360b.m4661a(this.f2359a);
        float g = this.f2359a.m4654g();
        float f2 = this.f2359a.m4653f();
        float k = this.f2359a.m4658k();
        this.f2360b.m4668a(f, this.f2359a);
        if (f <= 0.5f) {
            float f3 = 0.8f - a;
            this.f2359a.m4643b(f2 + (ab.f2346c.getInterpolation(f / 0.5f) * f3));
        }
        if (f > 0.5f) {
            this.f2359a.m4646c(((0.8f - a) * ab.f2346c.getInterpolation((f - 0.5f) / 0.5f)) + g);
        }
        this.f2359a.m4649d((0.25f * f) + k);
        this.f2360b.m4680c((216.0f * f) + (1080.0f * (this.f2360b.f2355k / 5.0f)));
    }
}
