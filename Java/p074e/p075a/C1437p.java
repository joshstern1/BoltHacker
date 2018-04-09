package com.p074e.p075a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.p074e.p075a.C1450z.C1449a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class C1437p {
    final C1435b f5480a = new C1435b();
    final Context f5481b;
    final ExecutorService f5482c;
    final C1402r f5483d;
    final Map<String, C1420c> f5484e;
    final Map<Object, C1401a> f5485f;
    final Map<Object, C1401a> f5486g;
    final Set<Object> f5487h;
    final Handler f5488i;
    final Handler f5489j;
    final C1427j f5490k;
    final am f5491l;
    final List<C1420c> f5492m;
    final C1436c f5493n;
    final boolean f5494o;
    boolean f5495p;

    private static class C1434a extends Handler {
        private final C1437p f5478a;

        public C1434a(Looper looper, C1437p c1437p) {
            super(looper);
            this.f5478a = c1437p;
        }

        public void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case 1:
                    this.f5478a.m9160c((C1401a) message.obj);
                    return;
                case 2:
                    this.f5478a.m9162d((C1401a) message.obj);
                    return;
                case 4:
                    this.f5478a.m9164e((C1420c) message.obj);
                    return;
                case 5:
                    this.f5478a.m9163d((C1420c) message.obj);
                    return;
                case 6:
                    this.f5478a.m9152a((C1420c) message.obj, false);
                    return;
                case 7:
                    this.f5478a.m9147a();
                    return;
                case 9:
                    this.f5478a.m9155b((NetworkInfo) message.obj);
                    return;
                case 10:
                    C1437p c1437p = this.f5478a;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    c1437p.m9159b(z);
                    return;
                case 11:
                    this.f5478a.m9153a(message.obj);
                    return;
                case 12:
                    this.f5478a.m9158b(message.obj);
                    return;
                default:
                    ab.f5325a.post(new C1438q(this, message));
                    return;
            }
        }
    }

    static class C1435b extends HandlerThread {
        C1435b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class C1436c extends BroadcastReceiver {
        private final C1437p f5479a;

        C1436c(C1437p c1437p) {
            this.f5479a = c1437p;
        }

        void m9141a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f5479a.f5494o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f5479a.f5481b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f5479a.m9154a(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f5479a.m9148a(((ConnectivityManager) as.m9072a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    C1437p(Context context, ExecutorService executorService, Handler handler, C1402r c1402r, C1427j c1427j, am amVar) {
        this.f5480a.start();
        as.m9079a(this.f5480a.getLooper());
        this.f5481b = context;
        this.f5482c = executorService;
        this.f5484e = new LinkedHashMap();
        this.f5485f = new WeakHashMap();
        this.f5486g = new WeakHashMap();
        this.f5487h = new HashSet();
        this.f5488i = new C1434a(this.f5480a.getLooper(), this);
        this.f5483d = c1402r;
        this.f5489j = handler;
        this.f5490k = c1427j;
        this.f5491l = amVar;
        this.f5492m = new ArrayList(4);
        this.f5495p = as.m9090d(this.f5481b);
        this.f5494o = as.m9086b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f5493n = new C1436c(this);
        this.f5493n.m9141a();
    }

    void m9149a(C1401a c1401a) {
        this.f5488i.sendMessage(this.f5488i.obtainMessage(1, c1401a));
    }

    void m9156b(C1401a c1401a) {
        this.f5488i.sendMessage(this.f5488i.obtainMessage(2, c1401a));
    }

    void m9151a(C1420c c1420c) {
        this.f5488i.sendMessage(this.f5488i.obtainMessage(4, c1420c));
    }

    void m9157b(C1420c c1420c) {
        this.f5488i.sendMessageDelayed(this.f5488i.obtainMessage(5, c1420c), 500);
    }

    void m9161c(C1420c c1420c) {
        this.f5488i.sendMessage(this.f5488i.obtainMessage(6, c1420c));
    }

    void m9148a(NetworkInfo networkInfo) {
        this.f5488i.sendMessage(this.f5488i.obtainMessage(9, networkInfo));
    }

    void m9154a(boolean z) {
        int i;
        Handler handler = this.f5488i;
        Handler handler2 = this.f5488i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.sendMessage(handler2.obtainMessage(10, i, 0));
    }

    void m9160c(C1401a c1401a) {
        m9150a(c1401a, true);
    }

    void m9150a(C1401a c1401a, boolean z) {
        if (this.f5487h.contains(c1401a.m8974l())) {
            this.f5486g.put(c1401a.m8966d(), c1401a);
            if (c1401a.m8972j().f5336l) {
                as.m9082a("Dispatcher", "paused", c1401a.f5291b.m9011a(), "because tag '" + c1401a.m8974l() + "' is paused");
                return;
            }
            return;
        }
        C1420c c1420c = (C1420c) this.f5484e.get(c1401a.m8967e());
        if (c1420c != null) {
            c1420c.m9102a(c1401a);
        } else if (!this.f5482c.isShutdown()) {
            Object a = C1420c.m9097a(c1401a.m8972j(), this, this.f5490k, this.f5491l, c1401a);
            a.f5460n = this.f5482c.submit(a);
            this.f5484e.put(c1401a.m8967e(), a);
            if (z) {
                this.f5485f.remove(c1401a.m8966d());
            }
            if (c1401a.m8972j().f5336l) {
                as.m9081a("Dispatcher", "enqueued", c1401a.f5291b.m9011a());
            }
        } else if (c1401a.m8972j().f5336l) {
            as.m9082a("Dispatcher", "ignored", c1401a.f5291b.m9011a(), "because shut down");
        }
    }

    void m9162d(C1401a c1401a) {
        String e = c1401a.m8967e();
        C1420c c1420c = (C1420c) this.f5484e.get(e);
        if (c1420c != null) {
            c1420c.m9104b(c1401a);
            if (c1420c.m9105b()) {
                this.f5484e.remove(e);
                if (c1401a.m8972j().f5336l) {
                    as.m9081a("Dispatcher", "canceled", c1401a.m8965c().m9011a());
                }
            }
        }
        if (this.f5487h.contains(c1401a.m8974l())) {
            this.f5486g.remove(c1401a.m8966d());
            if (c1401a.m8972j().f5336l) {
                as.m9082a("Dispatcher", "canceled", c1401a.m8965c().m9011a(), "because paused request got canceled");
            }
        }
        C1401a c1401a2 = (C1401a) this.f5485f.remove(c1401a.m8966d());
        if (c1401a2 != null && c1401a2.m8972j().f5336l) {
            as.m9082a("Dispatcher", "canceled", c1401a2.m8965c().m9011a(), "from replaying");
        }
    }

    void m9153a(Object obj) {
        if (this.f5487h.add(obj)) {
            Iterator it = this.f5484e.values().iterator();
            while (it.hasNext()) {
                C1420c c1420c = (C1420c) it.next();
                boolean z = c1420c.m9113j().f5336l;
                C1401a i = c1420c.m9112i();
                List k = c1420c.m9114k();
                Object obj2 = (k == null || k.isEmpty()) ? null : 1;
                if (i != null || obj2 != null) {
                    if (i != null && i.m8974l().equals(obj)) {
                        c1420c.m9104b(i);
                        this.f5486g.put(i.m8966d(), i);
                        if (z) {
                            as.m9082a("Dispatcher", "paused", i.f5291b.m9011a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (obj2 != null) {
                        for (int size = k.size() - 1; size >= 0; size--) {
                            C1401a c1401a = (C1401a) k.get(size);
                            if (c1401a.m8974l().equals(obj)) {
                                c1420c.m9104b(c1401a);
                                this.f5486g.put(c1401a.m8966d(), c1401a);
                                if (z) {
                                    as.m9082a("Dispatcher", "paused", c1401a.f5291b.m9011a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (c1420c.m9105b()) {
                        it.remove();
                        if (z) {
                            as.m9082a("Dispatcher", "canceled", as.m9076a(c1420c), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void m9158b(Object obj) {
        if (this.f5487h.remove(obj)) {
            Object obj2 = null;
            Iterator it = this.f5486g.values().iterator();
            while (it.hasNext()) {
                C1401a c1401a = (C1401a) it.next();
                if (c1401a.m8974l().equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(c1401a);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.f5489j.sendMessage(this.f5489j.obtainMessage(13, obj2));
            }
        }
    }

    void m9163d(C1420c c1420c) {
        boolean z = true;
        if (!c1420c.m9106c()) {
            if (this.f5482c.isShutdown()) {
                m9152a(c1420c, false);
                return;
            }
            NetworkInfo activeNetworkInfo;
            if (this.f5494o) {
                activeNetworkInfo = ((ConnectivityManager) as.m9072a(this.f5481b, "connectivity")).getActiveNetworkInfo();
            } else {
                activeNetworkInfo = null;
            }
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            boolean a = c1420c.m9103a(this.f5495p, activeNetworkInfo);
            boolean d = c1420c.m9107d();
            if (!a) {
                if (!(this.f5494o && d)) {
                    z = false;
                }
                m9152a(c1420c, z);
                if (z) {
                    m9145f(c1420c);
                }
            } else if (!this.f5494o || z2) {
                if (c1420c.m9113j().f5336l) {
                    as.m9081a("Dispatcher", "retrying", as.m9076a(c1420c));
                }
                if (c1420c.m9115l() instanceof C1449a) {
                    c1420c.f5455i |= C1448y.NO_CACHE.f5533d;
                }
                c1420c.f5460n = this.f5482c.submit(c1420c);
            } else {
                m9152a(c1420c, d);
                if (d) {
                    m9145f(c1420c);
                }
            }
        }
    }

    void m9164e(C1420c c1420c) {
        if (C1447x.m9189b(c1420c.m9110g())) {
            this.f5490k.mo1329a(c1420c.m9109f(), c1420c.m9108e());
        }
        this.f5484e.remove(c1420c.m9109f());
        m9146g(c1420c);
        if (c1420c.m9113j().f5336l) {
            as.m9082a("Dispatcher", "batched", as.m9076a(c1420c), "for completion");
        }
    }

    void m9147a() {
        List arrayList = new ArrayList(this.f5492m);
        this.f5492m.clear();
        this.f5489j.sendMessage(this.f5489j.obtainMessage(8, arrayList));
        m9142a(arrayList);
    }

    void m9152a(C1420c c1420c, boolean z) {
        if (c1420c.m9113j().f5336l) {
            as.m9082a("Dispatcher", "batched", as.m9076a(c1420c), "for error" + (z ? " (will replay)" : ""));
        }
        this.f5484e.remove(c1420c.m9109f());
        m9146g(c1420c);
    }

    void m9159b(boolean z) {
        this.f5495p = z;
    }

    void m9155b(NetworkInfo networkInfo) {
        if (this.f5482c instanceof ag) {
            ((ag) this.f5482c).m9004a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            m9143b();
        }
    }

    private void m9143b() {
        if (!this.f5485f.isEmpty()) {
            Iterator it = this.f5485f.values().iterator();
            while (it.hasNext()) {
                C1401a c1401a = (C1401a) it.next();
                it.remove();
                if (c1401a.m8972j().f5336l) {
                    as.m9081a("Dispatcher", "replaying", c1401a.m8965c().m9011a());
                }
                m9150a(c1401a, false);
            }
        }
    }

    private void m9145f(C1420c c1420c) {
        C1401a i = c1420c.m9112i();
        if (i != null) {
            m9144e(i);
        }
        List k = c1420c.m9114k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                m9144e((C1401a) k.get(i2));
            }
        }
    }

    private void m9144e(C1401a c1401a) {
        Object d = c1401a.m8966d();
        if (d != null) {
            c1401a.f5300k = true;
            this.f5485f.put(d, c1401a);
        }
    }

    private void m9146g(C1420c c1420c) {
        if (!c1420c.m9106c()) {
            this.f5492m.add(c1420c);
            if (!this.f5488i.hasMessages(7)) {
                this.f5488i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void m9142a(List<C1420c> list) {
        if (list != null && !list.isEmpty() && ((C1420c) list.get(0)).m9113j().f5336l) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C1420c c1420c : list) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(as.m9076a(c1420c));
            }
            as.m9081a("Dispatcher", "delivered", stringBuilder.toString());
        }
    }
}
