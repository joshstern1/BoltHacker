package android.support.v4.p020a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

class C0305d implements C0303b {
    private TimeInterpolator f1471a;

    C0305d() {
    }

    public void mo297a(View view) {
        if (this.f1471a == null) {
            this.f1471a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f1471a);
    }
}
