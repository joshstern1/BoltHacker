package com.p074e.p075a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.p074e.p075a.C1401a.C1400a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class ab {
    static final Handler f5325a = new ac(Looper.getMainLooper());
    static volatile ab f5326b = null;
    final Context f5327c;
    final C1437p f5328d;
    final C1427j f5329e;
    final am f5330f;
    final Map<Object, C1401a> f5331g;
    final Map<ImageView, C1433o> f5332h;
    final ReferenceQueue<Object> f5333i;
    final Config f5334j;
    boolean f5335k;
    volatile boolean f5336l;
    boolean f5337m;
    private final C1405c f5338n;
    private final C1408f f5339o;
    private final C1404b f5340p;
    private final List<ak> f5341q;

    public static class C1403a {
        private final Context f5303a;
        private C1402r f5304b;
        private ExecutorService f5305c;
        private C1427j f5306d;
        private C1405c f5307e;
        private C1408f f5308f;
        private List<ak> f5309g;
        private Config f5310h;
        private boolean f5311i;
        private boolean f5312j;

        public C1403a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f5303a = context.getApplicationContext();
        }

        public ab m8978a() {
            Context context = this.f5303a;
            if (this.f5304b == null) {
                this.f5304b = as.m9071a(context);
            }
            if (this.f5306d == null) {
                this.f5306d = new C1443u(context);
            }
            if (this.f5305c == null) {
                this.f5305c = new ag();
            }
            if (this.f5308f == null) {
                this.f5308f = C1408f.f5324a;
            }
            am amVar = new am(this.f5306d);
            return new ab(context, new C1437p(context, this.f5305c, ab.f5325a, this.f5304b, this.f5306d, amVar), this.f5306d, this.f5307e, this.f5308f, this.f5309g, amVar, this.f5310h, this.f5311i, this.f5312j);
        }
    }

    private static class C1404b extends Thread {
        private final ReferenceQueue<Object> f5313a;
        private final Handler f5314b;

        C1404b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f5313a = referenceQueue;
            this.f5314b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    C1400a c1400a = (C1400a) this.f5313a.remove(1000);
                    Message obtainMessage = this.f5314b.obtainMessage();
                    if (c1400a != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = c1400a.f5289a;
                        this.f5314b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException e) {
                    return;
                } catch (Exception e2) {
                    this.f5314b.post(new ad(this, e2));
                    return;
                }
            }
        }
    }

    public interface C1405c {
        void m8979a(ab abVar, Uri uri, Exception exception);
    }

    public enum C1406d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        final int f5319d;

        private C1406d(int i) {
            this.f5319d = i;
        }
    }

    public enum C1407e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface C1408f {
        public static final C1408f f5324a = new ae();

        ah mo1324a(ah ahVar);
    }

    ab(Context context, C1437p c1437p, C1427j c1427j, C1405c c1405c, C1408f c1408f, List<ak> list, am amVar, Config config, boolean z, boolean z2) {
        this.f5327c = context;
        this.f5328d = c1437p;
        this.f5329e = c1427j;
        this.f5338n = c1405c;
        this.f5339o = c1408f;
        this.f5334j = config;
        List arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new al(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C1431m(context));
        arrayList.add(new C1446w(context));
        arrayList.add(new C1432n(context));
        arrayList.add(new C1419b(context));
        arrayList.add(new C1441s(context));
        arrayList.add(new C1450z(c1437p.f5483d, amVar));
        this.f5341q = Collections.unmodifiableList(arrayList);
        this.f5330f = amVar;
        this.f5331g = new WeakHashMap();
        this.f5332h = new WeakHashMap();
        this.f5335k = z;
        this.f5336l = z2;
        this.f5333i = new ReferenceQueue();
        this.f5340p = new C1404b(this.f5333i, f5325a);
        this.f5340p.start();
    }

    public void m8990a(ImageView imageView) {
        m8984a((Object) imageView);
    }

    public aj m8988a(Uri uri) {
        return new aj(this, uri, 0);
    }

    public aj m8987a(int i) {
        if (i != 0) {
            return new aj(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public void m8994b(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("uri == null");
        }
        this.f5329e.mo1331b(uri.toString());
    }

    List<ak> m8989a() {
        return this.f5341q;
    }

    ah m8986a(ah ahVar) {
        ah a = this.f5339o.mo1324a(ahVar);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Request transformer " + this.f5339o.getClass().getCanonicalName() + " returned null for " + ahVar);
    }

    void m8991a(ImageView imageView, C1433o c1433o) {
        this.f5332h.put(imageView, c1433o);
    }

    void m8992a(C1401a c1401a) {
        Object d = c1401a.m8966d();
        if (!(d == null || this.f5331g.get(d) == c1401a)) {
            m8984a(d);
            this.f5331g.put(d, c1401a);
        }
        m8995b(c1401a);
    }

    void m8995b(C1401a c1401a) {
        this.f5328d.m9149a(c1401a);
    }

    Bitmap m8985a(String str) {
        Bitmap a = this.f5329e.mo1328a(str);
        if (a != null) {
            this.f5330f.m9045a();
        } else {
            this.f5330f.m9049b();
        }
        return a;
    }

    void m8993a(C1420c c1420c) {
        Object obj = 1;
        C1401a i = c1420c.m9112i();
        List k = c1420c.m9114k();
        Object obj2 = (k == null || k.isEmpty()) ? null : 1;
        if (i == null && obj2 == null) {
            obj = null;
        }
        if (obj != null) {
            Uri uri = c1420c.m9111h().f5372d;
            Exception l = c1420c.m9115l();
            Bitmap e = c1420c.m9108e();
            C1406d m = c1420c.m9116m();
            if (i != null) {
                m8982a(e, m, i);
            }
            if (obj2 != null) {
                int size = k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m8982a(e, m, (C1401a) k.get(i2));
                }
            }
            if (this.f5338n != null && l != null) {
                this.f5338n.m8979a(this, uri, l);
            }
        }
    }

    void m8996c(C1401a c1401a) {
        Bitmap bitmap = null;
        if (C1447x.m9188a(c1401a.f5294e)) {
            bitmap = m8985a(c1401a.m8967e());
        }
        if (bitmap != null) {
            m8982a(bitmap, C1406d.MEMORY, c1401a);
            if (this.f5336l) {
                as.m9082a("Main", "completed", c1401a.f5291b.m9011a(), "from " + C1406d.MEMORY);
                return;
            }
            return;
        }
        m8992a(c1401a);
        if (this.f5336l) {
            as.m9081a("Main", "resumed", c1401a.f5291b.m9011a());
        }
    }

    private void m8982a(Bitmap bitmap, C1406d c1406d, C1401a c1401a) {
        if (!c1401a.m8968f()) {
            if (!c1401a.m8969g()) {
                this.f5331g.remove(c1401a.m8966d());
            }
            if (bitmap == null) {
                c1401a.mo1332a();
                if (this.f5336l) {
                    as.m9081a("Main", "errored", c1401a.f5291b.m9011a());
                }
            } else if (c1406d == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                c1401a.mo1333a(bitmap, c1406d);
                if (this.f5336l) {
                    as.m9082a("Main", "completed", c1401a.f5291b.m9011a(), "from " + c1406d);
                }
            }
        }
    }

    private void m8984a(Object obj) {
        as.m9078a();
        C1401a c1401a = (C1401a) this.f5331g.remove(obj);
        if (c1401a != null) {
            c1401a.mo1334b();
            this.f5328d.m9156b(c1401a);
        }
        if (obj instanceof ImageView) {
            C1433o c1433o = (C1433o) this.f5332h.remove((ImageView) obj);
            if (c1433o != null) {
                c1433o.m9140a();
            }
        }
    }

    public static ab m8981a(Context context) {
        if (f5326b == null) {
            synchronized (ab.class) {
                if (f5326b == null) {
                    f5326b = new C1403a(context).m8978a();
                }
            }
        }
        return f5326b;
    }
}
