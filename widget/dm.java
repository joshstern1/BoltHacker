package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p027a.C0811r;
import java.lang.ref.WeakReference;

public class dm extends Resources {
    private final WeakReference<Context> f3856a;

    public static boolean m7140a() {
        return C0811r.m5312k() && VERSION.SDK_INT <= 20;
    }

    public dm(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f3856a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Context context = (Context) this.f3856a.get();
        if (context != null) {
            return C1011w.m7254a().m7274a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable m7141a(int i) {
        return super.getDrawable(i);
    }
}
