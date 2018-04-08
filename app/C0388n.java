package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

abstract class C0388n extends C0387m {
    C0388n() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo367a(view, str, context, attributeSet);
        if (a != null || VERSION.SDK_INT < 11) {
            return a;
        }
        return super.onCreateView(view, str, context, attributeSet);
    }
}
