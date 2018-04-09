package android.support.v7.p027a;

import android.content.Context;
import android.support.v7.p027a.C0822x.C0817a;
import android.view.Window;
import android.view.Window.Callback;

class C0823u extends C0822x {

    class C0818a extends C0817a {
        final /* synthetic */ C0823u f2719b;

        C0818a(C0823u c0823u, Callback callback) {
            this.f2719b = c0823u;
            super(c0823u, callback);
        }
    }

    C0823u(Context context, Window window, C0763q c0763q) {
        super(context, window, c0763q);
    }

    Callback mo837a(Callback callback) {
        return new C0818a(this, callback);
    }
}
