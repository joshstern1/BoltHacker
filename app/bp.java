package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p021b.C0307a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

public final class bp implements Iterable<Intent> {
    private static final C0370b f1743a;
    private final ArrayList<Intent> f1744b = new ArrayList();
    private final Context f1745c;

    public interface C0369a {
        Intent mo790a();
    }

    interface C0370b {
    }

    static class C0371c implements C0370b {
        C0371c() {
        }
    }

    static class C0372d implements C0370b {
        C0372d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1743a = new C0372d();
        } else {
            f1743a = new C0371c();
        }
    }

    private bp(Context context) {
        this.f1745c = context;
    }

    public static bp m2631a(Context context) {
        return new bp(context);
    }

    public bp m2634a(Intent intent) {
        this.f1744b.add(intent);
        return this;
    }

    public bp m2632a(Activity activity) {
        Intent a;
        Intent intent = null;
        if (activity instanceof C0369a) {
            intent = ((C0369a) activity).mo790a();
        }
        if (intent == null) {
            a = aq.m2445a(activity);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f1745c.getPackageManager());
            }
            m2633a(component);
            m2634a(a);
        }
        return this;
    }

    public bp m2633a(ComponentName componentName) {
        int size = this.f1744b.size();
        try {
            Intent a = aq.m2446a(this.f1745c, componentName);
            while (a != null) {
                this.f1744b.add(size, a);
                a = aq.m2446a(this.f1745c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1744b.iterator();
    }

    public void m2635a() {
        m2636a(null);
    }

    public void m2636a(Bundle bundle) {
        if (this.f1744b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f1744b.toArray(new Intent[this.f1744b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0307a.m2328a(this.f1745c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.f1745c.startActivity(intent);
        }
    }
}
