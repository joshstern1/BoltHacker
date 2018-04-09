package android.support.v4.p021b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;

public class C0307a {
    private static final Object f1543a = new Object();
    private static TypedValue f1544b;

    public static boolean m2328a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0419e.m2906a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0418d.m2905a(context, intentArr);
            return true;
        }
    }

    public static final Drawable m2325a(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return C0416b.m2901a(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f1543a) {
            if (f1544b == null) {
                f1544b = new TypedValue();
            }
            context.getResources().getValue(i, f1544b, true);
            i2 = f1544b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static final ColorStateList m2329b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return C0417c.m2903a(context, i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static final int m2330c(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return C0417c.m2904b(context, i);
        }
        return context.getResources().getColor(i);
    }

    public static final File m2326a(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return C0416b.m2902a(context);
        }
        return C0307a.m2327a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File m2327a(File file) {
        synchronized (C0307a.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
