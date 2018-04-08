package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

class C0378f {
    public static String m2646a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int m2645a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
