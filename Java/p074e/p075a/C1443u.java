package com.p074e.p075a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class C1443u implements C1427j {
    final LinkedHashMap<String, Bitmap> f5505b;
    private final int f5506c;
    private int f5507d;
    private int f5508e;
    private int f5509f;
    private int f5510g;
    private int f5511h;

    public C1443u(Context context) {
        this(as.m9088c(context));
    }

    public C1443u(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f5506c = i;
        this.f5505b = new LinkedHashMap(0, 0.75f, true);
    }

    public Bitmap mo1328a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = (Bitmap) this.f5505b.get(str);
            if (bitmap != null) {
                this.f5510g++;
                return bitmap;
            }
            this.f5511h++;
            return null;
        }
    }

    public void mo1329a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f5508e++;
            this.f5507d += as.m9068a(bitmap);
            Bitmap bitmap2 = (Bitmap) this.f5505b.put(str, bitmap);
            if (bitmap2 != null) {
                this.f5507d -= as.m9068a(bitmap2);
            }
        }
        m9174a(this.f5506c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9174a(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.f5507d;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.f5505b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r3.f5507d;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r3.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r3.f5507d;	 Catch:{ all -> 0x0032 }
        if (r0 <= r4) goto L_0x0041;
    L_0x0039:
        r0 = r3.f5505b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r3.f5505b;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0032 }
        r2 = r3.f5505b;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r1 = r3.f5507d;	 Catch:{ all -> 0x0032 }
        r0 = com.p074e.p075a.as.m9068a(r0);	 Catch:{ all -> 0x0032 }
        r0 = r1 - r0;
        r3.f5507d = r0;	 Catch:{ all -> 0x0032 }
        r0 = r3.f5509f;	 Catch:{ all -> 0x0032 }
        r0 = r0 + 1;
        r3.f5509f = r0;	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.u.a(int):void");
    }

    public final synchronized int mo1327a() {
        return this.f5507d;
    }

    public final synchronized int mo1330b() {
        return this.f5506c;
    }

    public final synchronized void mo1331b(String str) {
        Object obj = null;
        synchronized (this) {
            int length = str.length();
            Iterator it = this.f5505b.entrySet().iterator();
            while (it.hasNext()) {
                Object obj2;
                Entry entry = (Entry) it.next();
                String str2 = (String) entry.getKey();
                Bitmap bitmap = (Bitmap) entry.getValue();
                int indexOf = str2.indexOf(10);
                if (indexOf == length && str2.substring(0, indexOf).equals(str)) {
                    it.remove();
                    this.f5507d -= as.m9068a(bitmap);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj != null) {
                m9174a(this.f5506c);
            }
        }
    }
}
