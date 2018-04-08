package android.support.design.widget;

import android.animation.ValueAnimator;
import android.support.design.widget.bf.C0266e;
import android.support.design.widget.bf.C0266e.C0264a;
import android.support.design.widget.bf.C0266e.C0265b;
import android.view.animation.Interpolator;

class bk extends C0266e {
    final ValueAnimator f1343a = new ValueAnimator();

    bk() {
    }

    public void mo257a() {
        this.f1343a.start();
    }

    public boolean mo264b() {
        return this.f1343a.isRunning();
    }

    public void mo263a(Interpolator interpolator) {
        this.f1343a.setInterpolator(interpolator);
    }

    public void mo262a(C0265b c0265b) {
        this.f1343a.addUpdateListener(new bl(this, c0265b));
    }

    public void mo261a(C0264a c0264a) {
        this.f1343a.addListener(new bm(this, c0264a));
    }

    public void mo260a(int i, int i2) {
        this.f1343a.setIntValues(new int[]{i, i2});
    }

    public int mo265c() {
        return ((Integer) this.f1343a.getAnimatedValue()).intValue();
    }

    public void mo258a(float f, float f2) {
        this.f1343a.setFloatValues(new float[]{f, f2});
    }

    public float mo266d() {
        return ((Float) this.f1343a.getAnimatedValue()).floatValue();
    }

    public void mo259a(int i) {
        this.f1343a.setDuration((long) i);
    }

    public void mo267e() {
        this.f1343a.cancel();
    }

    public float mo268f() {
        return this.f1343a.getAnimatedFraction();
    }

    public long mo269g() {
        return this.f1343a.getDuration();
    }
}
