package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class ae implements Callback {
    final /* synthetic */ ab f2363a;

    ae(ab abVar) {
        this.f2363a = abVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f2363a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f2363a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f2363a.unscheduleSelf(runnable);
    }
}
