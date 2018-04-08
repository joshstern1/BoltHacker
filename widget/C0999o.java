package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class C0999o implements OnGlobalLayoutListener {
    final /* synthetic */ ActivityChooserView f3893a;

    C0999o(ActivityChooserView activityChooserView) {
        this.f3893a = activityChooserView;
    }

    public void onGlobalLayout() {
        if (!this.f3893a.m5929c()) {
            return;
        }
        if (this.f3893a.isShown()) {
            this.f3893a.getListPopupWindow().mo868d();
            if (this.f3893a.f3165a != null) {
                this.f3893a.f3165a.m4278a(true);
                return;
            }
            return;
        }
        this.f3893a.getListPopupWindow().mo869e();
    }
}
