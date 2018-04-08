package android.support.v7.widget;

import android.support.v7.widget.AppCompatSpinner.C0912b;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class aj implements OnGlobalLayoutListener {
    final /* synthetic */ C0912b f3620a;

    aj(C0912b c0912b) {
        this.f3620a = c0912b;
    }

    public void onGlobalLayout() {
        if (this.f3620a.m5969b(this.f3620a.f3226a)) {
            this.f3620a.mo927b();
            super.mo868d();
            return;
        }
        this.f3620a.mo869e();
    }
}
