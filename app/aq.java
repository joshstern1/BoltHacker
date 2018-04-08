package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.p021b.C0424f;
import android.util.Log;

public final class aq {
    private static final C0318a f1609a;

    interface C0318a {
        Intent mo311a(Activity activity);

        String mo312a(Context context, ActivityInfo activityInfo);

        boolean mo313a(Activity activity, Intent intent);

        void mo314b(Activity activity, Intent intent);
    }

    static class C0319b implements C0318a {
        C0319b() {
        }

        public Intent mo311a(Activity activity) {
            String b = aq.m2448b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                if (aq.m2449b((Context) activity, componentName) == null) {
                    return C0424f.m2910a(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b + "' in manifest");
                return null;
            }
        }

        public boolean mo313a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void mo314b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String mo312a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    static class C0320c extends C0319b {
        C0320c() {
        }

        public Intent mo311a(Activity activity) {
            Intent a = ar.m2451a(activity);
            if (a == null) {
                return m2443b(activity);
            }
            return a;
        }

        Intent m2443b(Activity activity) {
            return super.mo311a(activity);
        }

        public boolean mo313a(Activity activity, Intent intent) {
            return ar.m2453a(activity, intent);
        }

        public void mo314b(Activity activity, Intent intent) {
            ar.m2454b(activity, intent);
        }

        public String mo312a(Context context, ActivityInfo activityInfo) {
            String a = ar.m2452a(activityInfo);
            if (a == null) {
                return super.mo312a(context, activityInfo);
            }
            return a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1609a = new C0320c();
        } else {
            f1609a = new C0319b();
        }
    }

    public static boolean m2447a(Activity activity, Intent intent) {
        return f1609a.mo313a(activity, intent);
    }

    public static void m2450b(Activity activity, Intent intent) {
        f1609a.mo314b(activity, intent);
    }

    public static Intent m2445a(Activity activity) {
        return f1609a.mo311a(activity);
    }

    public static Intent m2446a(Context context, ComponentName componentName) throws NameNotFoundException {
        String b = m2449b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        if (m2449b(context, componentName2) == null) {
            return C0424f.m2910a(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String m2448b(Activity activity) {
        try {
            return m2449b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m2449b(Context context, ComponentName componentName) throws NameNotFoundException {
        return f1609a.mo312a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
}
