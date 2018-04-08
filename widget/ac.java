package android.support.v7.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class ac implements OnScrollChangedListener {
    final /* synthetic */ Field f3599a;
    final /* synthetic */ PopupWindow f3600b;
    final /* synthetic */ OnScrollChangedListener f3601c;

    ac(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
        this.f3599a = field;
        this.f3600b = popupWindow;
        this.f3601c = onScrollChangedListener;
    }

    public void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference) this.f3599a.get(this.f3600b);
            if (weakReference != null && weakReference.get() != null) {
                this.f3601c.onScrollChanged();
            }
        } catch (IllegalAccessException e) {
        }
    }
}
