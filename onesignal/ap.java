package com.onesignal;

import android.content.Context;
import com.onesignal.ao.C2724a;

public class ap implements ao {
    private static C2724a f9208a;
    private static boolean f9209b = false;

    public void mo2312a(Context context, String str, C2724a c2724a) {
        f9208a = c2724a;
        new Thread(new aq(this, context, c2724a)).start();
    }

    public static void m15935a(String str) {
        f9209b = true;
        f9208a.mo2316a(str);
    }
}
