package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class dd extends cb {
    private final WeakReference<Context> f3827a;

    public dd(Context context, Resources resources) {
        super(resources);
        this.f3827a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f3827a.get();
        if (!(drawable == null || context == null)) {
            C1011w.m7254a();
            C1011w.m7260a(context, i, drawable);
        }
        return drawable;
    }
}
