package android.support.v4.p021b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

class C0416b {
    public static Drawable m2901a(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File m2902a(Context context) {
        return context.getNoBackupFilesDir();
    }
}
