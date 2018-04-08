package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p021b.C0307a;

public class C0308a extends C0307a {
    public static void m2332a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0373c.m2638a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m2331a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0373c.m2637a(activity);
        } else {
            activity.finish();
        }
    }
}
