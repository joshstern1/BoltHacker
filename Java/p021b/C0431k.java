package android.support.v4.p021b;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.C0376d;

public final class C0431k {
    public static int m2931a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0376d.m2644a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0376d.m2643a(context, a, str2) != 0 ? -2 : 0;
    }

    public static int m2930a(Context context, String str) {
        return C0431k.m2931a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
