package com.onesignal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Process;

class C2739i {

    static class C2735a {
        static void m15983a(Activity activity, String[] strArr, int i) {
            C2736b.m15984a(activity, strArr, i);
        }
    }

    @TargetApi(23)
    static class C2736b {
        static void m15984a(Activity activity, String[] strArr, int i) {
            if (activity instanceof C2738d) {
                ((C2738d) activity).m15986a(i);
            }
            activity.requestPermissions(strArr, i);
        }
    }

    static class C2737c {
        static int m15985a(Context context, String str) {
            if (str != null) {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            }
            throw new IllegalArgumentException("permission is null");
        }
    }

    interface C2738d {
        void m15986a(int i);
    }
}
