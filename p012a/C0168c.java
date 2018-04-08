package android.support.p011a.p012a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class C0168c implements Callback {
    final /* synthetic */ C0167b f792a;

    C0168c(C0167b c0167b) {
        this.f792a = c0167b;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f792a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f792a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f792a.unscheduleSelf(runnable);
    }
}
