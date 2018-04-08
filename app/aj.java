package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class aj extends EpicenterCallback {
    final /* synthetic */ Rect f1564a;

    aj(Rect rect) {
        this.f1564a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f1564a;
    }
}
