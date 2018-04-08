package android.support.v7.p027a;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.p027a.C0821w.C0816a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0822x extends C0821w {
    private final UiModeManager f2749r;

    class C0817a extends C0816a {
        final /* synthetic */ C0822x f2718d;

        C0817a(C0822x c0822x, Callback callback) {
            this.f2718d = c0822x;
            super(c0822x, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.f2718d.mo839o()) {
                switch (i) {
                    case 0:
                        return m5360a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    C0822x(Context context, Window window, C0763q c0763q) {
        super(context, window, c0763q);
        this.f2749r = (UiModeManager) context.getSystemService("uimode");
    }

    Callback mo837a(Callback callback) {
        return new C0817a(this, callback);
    }

    int mo838d(int i) {
        if (i == 0 && this.f2749r.getNightMode() == 0) {
            return -1;
        }
        return super.mo838d(i);
    }
}
