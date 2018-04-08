package com.onesignal;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import java.lang.reflect.Field;

class C2729c {
    static void m15975a() {
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            C2729c.m15976a(cls, invoke, ((Instrumentation) declaredField.get(invoke)).addMonitor((String) null, null, false));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void m15976a(Class cls, Object obj, ActivityMonitor activityMonitor) {
        new Thread(new C2730d(cls, activityMonitor, obj)).start();
    }
}
