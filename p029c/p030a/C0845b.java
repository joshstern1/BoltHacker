package android.support.v7.p029c.p030a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.p021b.C0307a;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class C0845b {
    private static final ThreadLocal<TypedValue> f2785a = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<C0844a>> f2786b = new WeakHashMap(0);
    private static final Object f2787c = new Object();

    private static class C0844a {
        final ColorStateList f2783a;
        final Configuration f2784b;

        C0844a(ColorStateList colorStateList, Configuration configuration) {
            this.f2783a = colorStateList;
            this.f2784b = configuration;
        }
    }

    public static ColorStateList m5468a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList c = C0845b.m5472c(context, i);
        if (c != null) {
            return c;
        }
        c = C0845b.m5471b(context, i);
        if (c == null) {
            return C0307a.m2329b(context, i);
        }
        C0845b.m5470a(context, i, c);
        return c;
    }

    private static ColorStateList m5471b(Context context, int i) {
        ColorStateList colorStateList = null;
        if (!C0845b.m5473d(context, i)) {
            Resources resources = context.getResources();
            try {
                colorStateList = C0843a.m5464a(resources, resources.getXml(i), context.getTheme());
            } catch (Throwable e) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        return colorStateList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m5472c(android.content.Context r5, int r6) {
        /*
        r2 = f2787c;
        monitor-enter(r2);
        r0 = f2786b;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0035 }
        r0 = (android.util.SparseArray) r0;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0032;
    L_0x000d:
        r1 = r0.size();	 Catch:{ all -> 0x0035 }
        if (r1 <= 0) goto L_0x0032;
    L_0x0013:
        r1 = r0.get(r6);	 Catch:{ all -> 0x0035 }
        r1 = (android.support.v7.p029c.p030a.C0845b.C0844a) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r1.f2784b;	 Catch:{ all -> 0x0035 }
        r4 = r5.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r3 == 0) goto L_0x002f;
    L_0x002b:
        r0 = r1.f2783a;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
    L_0x002e:
        return r0;
    L_0x002f:
        r0.remove(r6);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        r0 = 0;
        goto L_0x002e;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.b.c(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static void m5470a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f2787c) {
            SparseArray sparseArray = (SparseArray) f2786b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f2786b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0844a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean m5473d(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = C0845b.m5469a();
        resources.getValue(i, a, true);
        if (a.type < 28 || a.type > 31) {
            return false;
        }
        return true;
    }

    private static TypedValue m5469a() {
        TypedValue typedValue = (TypedValue) f2785a.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2785a.set(typedValue);
        return typedValue;
    }
}
