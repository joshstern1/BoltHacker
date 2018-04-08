package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

class C0373c {
    public static void m2638a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void m2637a(Activity activity) {
        activity.finishAffinity();
    }
}
