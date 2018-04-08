package com.onesignal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

@TargetApi(14)
class C2727b implements ActivityLifecycleCallbacks {
    C2727b() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C2720a.m15861a(activity);
    }

    public void onActivityStarted(Activity activity) {
        C2720a.m15864b(activity);
    }

    public void onActivityResumed(Activity activity) {
        C2720a.m15867c(activity);
    }

    public void onActivityPaused(Activity activity) {
        C2720a.m15868d(activity);
    }

    public void onActivityStopped(Activity activity) {
        C2720a.m15869e(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        C2720a.m15870f(activity);
    }
}
