package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class ar {
    public static Intent m2451a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean m2453a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m2454b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static String m2452a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
