package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.app.ai.C0310a;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class al extends EpicenterCallback {
    final /* synthetic */ C0310a f1573a;
    private Rect f1574b;

    al(C0310a c0310a) {
        this.f1573a = c0310a;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.f1574b == null && this.f1573a.f1563a != null) {
            this.f1574b = ai.m2401c(this.f1573a.f1563a);
        }
        return this.f1574b;
    }
}
