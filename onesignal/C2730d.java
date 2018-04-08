package com.onesignal;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.app.OnActivityPausedListener;
import java.lang.reflect.Method;

final class C2730d implements Runnable {
    final /* synthetic */ Class f9249a;
    final /* synthetic */ ActivityMonitor f9250b;
    final /* synthetic */ Object f9251c;

    C2730d(Class cls, ActivityMonitor activityMonitor, Object obj) {
        this.f9249a = cls;
        this.f9250b = activityMonitor;
        this.f9251c = obj;
    }

    public void run() {
        try {
            C2731e c2731e = new C2731e(this);
            Method method = this.f9249a.getMethod("registerOnActivityPausedListener", new Class[]{Activity.class, OnActivityPausedListener.class});
            while (true) {
                Activity waitForActivity = this.f9250b.waitForActivity();
                if (!waitForActivity.isFinishing()) {
                    C2720a.m15867c(waitForActivity);
                    method.invoke(this.f9251c, new Object[]{waitForActivity, c2731e});
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
