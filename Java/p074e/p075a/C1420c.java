package com.p074e.p075a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ab.C1407e;
import com.p074e.p075a.ak.C1411a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class C1420c implements Runnable {
    private static final Object f5443t = new Object();
    private static final ThreadLocal<StringBuilder> f5444u = new C1421d();
    private static final AtomicInteger f5445v = new AtomicInteger();
    private static final ak f5446w = new C1422e();
    final int f5447a = f5445v.incrementAndGet();
    final ab f5448b;
    final C1437p f5449c;
    final C1427j f5450d;
    final am f5451e;
    final String f5452f;
    final ah f5453g;
    final int f5454h;
    int f5455i;
    final ak f5456j;
    C1401a f5457k;
    List<C1401a> f5458l;
    Bitmap f5459m;
    Future<?> f5460n;
    C1406d f5461o;
    Exception f5462p;
    int f5463q;
    int f5464r;
    C1407e f5465s;

    C1420c(ab abVar, C1437p c1437p, C1427j c1427j, am amVar, C1401a c1401a, ak akVar) {
        this.f5448b = abVar;
        this.f5449c = c1437p;
        this.f5450d = c1427j;
        this.f5451e = amVar;
        this.f5457k = c1401a;
        this.f5452f = c1401a.m8967e();
        this.f5453g = c1401a.m8965c();
        this.f5465s = c1401a.m8973k();
        this.f5454h = c1401a.m8970h();
        this.f5455i = c1401a.m8971i();
        this.f5456j = akVar;
        this.f5464r = akVar.mo1335a();
    }

    static Bitmap m9095a(InputStream inputStream, ah ahVar) throws IOException {
        InputStream c1444v = new C1444v(inputStream);
        long a = c1444v.m9182a(65536);
        Options c = ak.m9034c(ahVar);
        boolean a2 = ak.m9033a(c);
        boolean c2 = as.m9089c(c1444v);
        c1444v.m9183a(a);
        if (c2) {
            byte[] b = as.m9087b(c1444v);
            if (a2) {
                BitmapFactory.decodeByteArray(b, 0, b.length, c);
                ak.m9032a(ahVar.f5376h, ahVar.f5377i, c, ahVar);
            }
            return BitmapFactory.decodeByteArray(b, 0, b.length, c);
        }
        if (a2) {
            BitmapFactory.decodeStream(c1444v, null, c);
            ak.m9032a(ahVar.f5376h, ahVar.f5377i, c, ahVar);
            c1444v.m9183a(a);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(c1444v, null, c);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = r4.f5453g;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        com.p074e.p075a.C1420c.m9098a(r0);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0 = r4.f5448b;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0 = r0.f5336l;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        if (r0 == 0) goto L_0x0016;
    L_0x000b:
        r0 = "Hunter";
        r1 = "executing";
        r2 = com.p074e.p075a.as.m9076a(r4);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        com.p074e.p075a.as.m9081a(r0, r1, r2);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
    L_0x0016:
        r0 = r4.m9101a();	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r4.f5459m = r0;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0 = r4.f5459m;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        if (r0 != 0) goto L_0x002f;
    L_0x0020:
        r0 = r4.f5449c;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0.m9161c(r4);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
    L_0x0025:
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
    L_0x002e:
        return;
    L_0x002f:
        r0 = r4.f5449c;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0.m9151a(r4);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        goto L_0x0025;
    L_0x0035:
        r0 = move-exception;
        r1 = r0.f5502a;	 Catch:{ all -> 0x00b6 }
        if (r1 == 0) goto L_0x0040;
    L_0x003a:
        r1 = r0.f5503b;	 Catch:{ all -> 0x00b6 }
        r2 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        if (r1 == r2) goto L_0x0042;
    L_0x0040:
        r4.f5462p = r0;	 Catch:{ all -> 0x00b6 }
    L_0x0042:
        r0 = r4.f5449c;	 Catch:{ all -> 0x00b6 }
        r0.m9161c(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0051:
        r0 = move-exception;
        r4.f5462p = r0;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f5449c;	 Catch:{ all -> 0x00b6 }
        r0.m9157b(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0063:
        r0 = move-exception;
        r4.f5462p = r0;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f5449c;	 Catch:{ all -> 0x00b6 }
        r0.m9157b(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0075:
        r0 = move-exception;
        r1 = new java.io.StringWriter;	 Catch:{ all -> 0x00b6 }
        r1.<init>();	 Catch:{ all -> 0x00b6 }
        r2 = r4.f5451e;	 Catch:{ all -> 0x00b6 }
        r2 = r2.m9055e();	 Catch:{ all -> 0x00b6 }
        r3 = new java.io.PrintWriter;	 Catch:{ all -> 0x00b6 }
        r3.<init>(r1);	 Catch:{ all -> 0x00b6 }
        r2.m9056a(r3);	 Catch:{ all -> 0x00b6 }
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00b6 }
        r1 = r1.toString();	 Catch:{ all -> 0x00b6 }
        r2.<init>(r1, r0);	 Catch:{ all -> 0x00b6 }
        r4.f5462p = r2;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f5449c;	 Catch:{ all -> 0x00b6 }
        r0.m9161c(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x00a3:
        r0 = move-exception;
        r4.f5462p = r0;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f5449c;	 Catch:{ all -> 0x00b6 }
        r0.m9161c(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x00b6:
        r0 = move-exception;
        r1 = java.lang.Thread.currentThread();
        r2 = "Picasso-Idle";
        r1.setName(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.c.run():void");
    }

    Bitmap m9101a() throws IOException {
        Bitmap bitmap = null;
        if (C1447x.m9188a(this.f5454h)) {
            bitmap = this.f5450d.mo1328a(this.f5452f);
            if (bitmap != null) {
                this.f5451e.m9045a();
                this.f5461o = C1406d.MEMORY;
                if (this.f5448b.f5336l) {
                    as.m9082a("Hunter", "decoded", this.f5453g.m9011a(), "from cache");
                }
                return bitmap;
            }
        }
        this.f5453g.f5371c = this.f5464r == 0 ? C1448y.OFFLINE.f5533d : this.f5455i;
        C1411a a = this.f5456j.mo1325a(this.f5453g, this.f5455i);
        if (a != null) {
            this.f5461o = a.m9029c();
            this.f5463q = a.m9030d();
            bitmap = a.m9027a();
            if (bitmap == null) {
                InputStream b = a.m9028b();
                try {
                    bitmap = C1420c.m9095a(b, this.f5453g);
                } finally {
                    as.m9080a(b);
                }
            }
        }
        if (bitmap != null) {
            if (this.f5448b.f5336l) {
                as.m9081a("Hunter", "decoded", this.f5453g.m9011a());
            }
            this.f5451e.m9047a(bitmap);
            if (this.f5453g.m9015e() || this.f5463q != 0) {
                synchronized (f5443t) {
                    if (this.f5453g.m9016f() || this.f5463q != 0) {
                        bitmap = C1420c.m9094a(this.f5453g, bitmap, this.f5463q);
                        if (this.f5448b.f5336l) {
                            as.m9081a("Hunter", "transformed", this.f5453g.m9011a());
                        }
                    }
                    if (this.f5453g.m9017g()) {
                        bitmap = C1420c.m9096a(this.f5453g.f5375g, bitmap);
                        if (this.f5448b.f5336l) {
                            as.m9082a("Hunter", "transformed", this.f5453g.m9011a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f5451e.m9051b(bitmap);
                }
            }
        }
        return bitmap;
    }

    void m9102a(C1401a c1401a) {
        boolean z = this.f5448b.f5336l;
        ah ahVar = c1401a.f5291b;
        if (this.f5457k == null) {
            this.f5457k = c1401a;
            if (!z) {
                return;
            }
            if (this.f5458l == null || this.f5458l.isEmpty()) {
                as.m9082a("Hunter", "joined", ahVar.m9011a(), "to empty hunter");
                return;
            } else {
                as.m9082a("Hunter", "joined", ahVar.m9011a(), as.m9077a(this, "to "));
                return;
            }
        }
        if (this.f5458l == null) {
            this.f5458l = new ArrayList(3);
        }
        this.f5458l.add(c1401a);
        if (z) {
            as.m9082a("Hunter", "joined", ahVar.m9011a(), as.m9077a(this, "to "));
        }
        C1407e k = c1401a.m8973k();
        if (k.ordinal() > this.f5465s.ordinal()) {
            this.f5465s = k;
        }
    }

    void m9104b(C1401a c1401a) {
        boolean z = false;
        if (this.f5457k == c1401a) {
            this.f5457k = null;
            z = true;
        } else if (this.f5458l != null) {
            z = this.f5458l.remove(c1401a);
        }
        if (z && c1401a.m8973k() == this.f5465s) {
            this.f5465s = m9100o();
        }
        if (this.f5448b.f5336l) {
            as.m9082a("Hunter", "removed", c1401a.f5291b.m9011a(), as.m9077a(this, "from "));
        }
    }

    private C1407e m9100o() {
        int i = 1;
        int i2 = 0;
        C1407e c1407e = C1407e.LOW;
        int i3 = (this.f5458l == null || this.f5458l.isEmpty()) ? 0 : 1;
        if (this.f5457k == null && i3 == 0) {
            i = 0;
        }
        if (i == 0) {
            return c1407e;
        }
        C1407e k;
        if (this.f5457k != null) {
            k = this.f5457k.m8973k();
        } else {
            k = c1407e;
        }
        if (i3 == 0) {
            return k;
        }
        int size = this.f5458l.size();
        while (i2 < size) {
            C1407e k2 = ((C1401a) this.f5458l.get(i2)).m8973k();
            if (k2.ordinal() <= k.ordinal()) {
                k2 = k;
            }
            i2++;
            k = k2;
        }
        return k;
    }

    boolean m9105b() {
        if (this.f5457k != null) {
            return false;
        }
        if ((this.f5458l == null || this.f5458l.isEmpty()) && this.f5460n != null && this.f5460n.cancel(false)) {
            return true;
        }
        return false;
    }

    boolean m9106c() {
        return this.f5460n != null && this.f5460n.isCancelled();
    }

    boolean m9103a(boolean z, NetworkInfo networkInfo) {
        if (!(this.f5464r > 0)) {
            return false;
        }
        this.f5464r--;
        return this.f5456j.mo1336a(z, networkInfo);
    }

    boolean m9107d() {
        return this.f5456j.mo1337b();
    }

    Bitmap m9108e() {
        return this.f5459m;
    }

    String m9109f() {
        return this.f5452f;
    }

    int m9110g() {
        return this.f5454h;
    }

    ah m9111h() {
        return this.f5453g;
    }

    C1401a m9112i() {
        return this.f5457k;
    }

    ab m9113j() {
        return this.f5448b;
    }

    List<C1401a> m9114k() {
        return this.f5458l;
    }

    Exception m9115l() {
        return this.f5462p;
    }

    C1406d m9116m() {
        return this.f5461o;
    }

    C1407e m9117n() {
        return this.f5465s;
    }

    static void m9098a(ah ahVar) {
        String c = ahVar.m9013c();
        StringBuilder stringBuilder = (StringBuilder) f5444u.get();
        stringBuilder.ensureCapacity("Picasso-".length() + c.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), c);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    static C1420c m9097a(ab abVar, C1437p c1437p, C1427j c1427j, am amVar, C1401a c1401a) {
        ah c = c1401a.m8965c();
        List a = abVar.m8989a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ak akVar = (ak) a.get(i);
            if (akVar.mo1326a(c)) {
                return new C1420c(abVar, c1437p, c1427j, amVar, c1401a, akVar);
            }
        }
        return new C1420c(abVar, c1437p, c1427j, amVar, c1401a, f5446w);
    }

    static Bitmap m9096a(List<ap> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            ap apVar = (ap) list.get(i);
            try {
                bitmap = apVar.mo2293a(bitmap2);
                if (bitmap == null) {
                    StringBuilder append = new StringBuilder().append("Transformation ").append(apVar.mo2294a()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                    for (ap apVar2 : list) {
                        append.append(apVar2.mo2294a()).append('\n');
                    }
                    ab.f5325a.post(new C1424g(append));
                    return null;
                } else if (bitmap == bitmap2 && bitmap2.isRecycled()) {
                    ab.f5325a.post(new C1425h(apVar2));
                    return null;
                } else if (bitmap == bitmap2 || bitmap2.isRecycled()) {
                    i++;
                    bitmap2 = bitmap;
                } else {
                    ab.f5325a.post(new C1426i(apVar2));
                    return null;
                }
            } catch (RuntimeException e) {
                ab.f5325a.post(new C1423f(apVar2, e));
                return null;
            }
        }
        return bitmap2;
    }

    static Bitmap m9094a(ah ahVar, Bitmap bitmap, int i) {
        int ceil;
        int i2;
        int i3;
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = ahVar.f5380l;
        Matrix matrix = new Matrix();
        if (ahVar.m9016f()) {
            int i4 = ahVar.f5376h;
            int i5 = ahVar.f5377i;
            float f = ahVar.f5381m;
            if (f != 0.0f) {
                if (ahVar.f5384p) {
                    matrix.setRotate(f, ahVar.f5382n, ahVar.f5383o);
                } else {
                    matrix.setRotate(f);
                }
            }
            float f2;
            if (ahVar.f5378j) {
                int i6;
                int i7;
                f2 = ((float) i4) / ((float) width);
                f = ((float) i5) / ((float) height);
                if (f2 > f) {
                    ceil = (int) Math.ceil((double) ((f / f2) * ((float) height)));
                    f = ((float) i5) / ((float) ceil);
                    i6 = 0;
                    i7 = (height - ceil) / 2;
                    i2 = width;
                } else {
                    ceil = (int) Math.ceil((double) ((f2 / f) * ((float) width)));
                    f2 = ((float) i4) / ((float) ceil);
                    i6 = (width - ceil) / 2;
                    i7 = 0;
                    i2 = ceil;
                    ceil = height;
                }
                if (C1420c.m9099a(z, width, height, i4, i5)) {
                    matrix.preScale(f2, f);
                }
                height = i2;
                i3 = i6;
                i2 = ceil;
                ceil = i7;
            } else if (ahVar.f5379k) {
                f = ((float) i4) / ((float) width);
                f2 = ((float) i5) / ((float) height);
                if (f >= f2) {
                    f = f2;
                }
                if (C1420c.m9099a(z, width, height, i4, i5)) {
                    matrix.preScale(f, f);
                }
                ceil = 0;
                i3 = 0;
                i2 = height;
                height = width;
            } else if (!((i4 == 0 && i5 == 0) || (i4 == width && i5 == height))) {
                f2 = i4 != 0 ? ((float) i4) / ((float) width) : ((float) i5) / ((float) height);
                f = i5 != 0 ? ((float) i5) / ((float) height) : ((float) i4) / ((float) width);
                if (C1420c.m9099a(z, width, height, i4, i5)) {
                    matrix.preScale(f2, f);
                }
            }
            if (i != 0) {
                matrix.preRotate((float) i);
            }
            createBitmap = Bitmap.createBitmap(bitmap, i3, ceil, height, i2, matrix, true);
            if (createBitmap != bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }
        ceil = 0;
        i3 = 0;
        i2 = height;
        height = width;
        if (i != 0) {
            matrix.preRotate((float) i);
        }
        createBitmap = Bitmap.createBitmap(bitmap, i3, ceil, height, i2, matrix, true);
        if (createBitmap != bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    private static boolean m9099a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }
}
