package android.support.v7.widget;

import android.support.v7.widget.AppCompatSpinner.C0912b;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

class ak implements OnDismissListener {
    final /* synthetic */ OnGlobalLayoutListener f3621a;
    final /* synthetic */ C0912b f3622b;

    ak(C0912b c0912b, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f3622b = c0912b;
        this.f3621a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f3622b.f3226a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f3621a);
        }
    }
}
