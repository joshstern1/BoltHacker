package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.v4.app.an.C0313a;
import android.support.v4.p017e.C0466c;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bg {
    private static final int f1726a = f1732i.mo330a();
    private static final Object f1727b = new Object();
    private static String f1728c;
    private static Set<String> f1729d = new HashSet();
    private static final Object f1730g = new Object();
    private static C0362j f1731h;
    private static final C0353b f1732i;
    private final Context f1733e;
    private final NotificationManager f1734f = ((NotificationManager) this.f1733e.getSystemService("notification"));

    private interface C0351k {
        void mo329a(an anVar) throws RemoteException;
    }

    private static class C0352a implements C0351k {
        final String f1706a;
        final int f1707b;
        final String f1708c;
        final boolean f1709d = false;

        public C0352a(String str, int i, String str2) {
            this.f1706a = str;
            this.f1707b = i;
            this.f1708c = str2;
        }

        public void mo329a(an anVar) throws RemoteException {
            if (this.f1709d) {
                anVar.mo307a(this.f1706a);
            } else {
                anVar.mo308a(this.f1706a, this.f1707b, this.f1708c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.f1706a);
            stringBuilder.append(", id:").append(this.f1707b);
            stringBuilder.append(", tag:").append(this.f1708c);
            stringBuilder.append(", all:").append(this.f1709d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    interface C0353b {
        int mo330a();

        void mo331a(NotificationManager notificationManager, String str, int i);

        void mo332a(NotificationManager notificationManager, String str, int i, Notification notification);
    }

    static class C0354d implements C0353b {
        C0354d() {
        }

        public void mo331a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        public void mo332a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }

        public int mo330a() {
            return 1;
        }
    }

    static class C0355e extends C0354d {
        C0355e() {
        }

        public void mo331a(NotificationManager notificationManager, String str, int i) {
            bh.m2612a(notificationManager, str, i);
        }

        public void mo332a(NotificationManager notificationManager, String str, int i, Notification notification) {
            bh.m2613a(notificationManager, str, i, notification);
        }
    }

    static class C0356f extends C0355e {
        C0356f() {
        }

        public int mo330a() {
            return 33;
        }
    }

    static class C0357g extends C0356f {
        C0357g() {
        }
    }

    static class C0358c extends C0357g {
        C0358c() {
        }
    }

    private static class C0359h implements C0351k {
        final String f1710a;
        final int f1711b;
        final String f1712c;
        final Notification f1713d;

        public C0359h(String str, int i, String str2, Notification notification) {
            this.f1710a = str;
            this.f1711b = i;
            this.f1712c = str2;
            this.f1713d = notification;
        }

        public void mo329a(an anVar) throws RemoteException {
            anVar.mo309a(this.f1710a, this.f1711b, this.f1712c, this.f1713d);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.f1710a);
            stringBuilder.append(", id:").append(this.f1711b);
            stringBuilder.append(", tag:").append(this.f1712c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class C0360i {
        final ComponentName f1714a;
        final IBinder f1715b;

        public C0360i(ComponentName componentName, IBinder iBinder) {
            this.f1714a = componentName;
            this.f1715b = iBinder;
        }
    }

    private static class C0362j implements ServiceConnection, Callback {
        private final Context f1721a;
        private final HandlerThread f1722b;
        private final Handler f1723c;
        private final Map<ComponentName, C0361a> f1724d = new HashMap();
        private Set<String> f1725e = new HashSet();

        private static class C0361a {
            public final ComponentName f1716a;
            public boolean f1717b = false;
            public an f1718c;
            public LinkedList<C0351k> f1719d = new LinkedList();
            public int f1720e = 0;

            public C0361a(ComponentName componentName) {
                this.f1716a = componentName;
            }
        }

        public C0362j(Context context) {
            this.f1721a = context;
            this.f1722b = new HandlerThread("NotificationManagerCompat");
            this.f1722b.start();
            this.f1723c = new Handler(this.f1722b.getLooper(), this);
        }

        public void m2602a(C0351k c0351k) {
            this.f1723c.obtainMessage(0, c0351k).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m2599b((C0351k) message.obj);
                    return true;
                case 1:
                    C0360i c0360i = (C0360i) message.obj;
                    m2595a(c0360i.f1714a, c0360i.f1715b);
                    return true;
                case 2:
                    m2594a((ComponentName) message.obj);
                    return true;
                case 3:
                    m2597b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        private void m2599b(C0351k c0351k) {
            m2593a();
            for (C0361a c0361a : this.f1724d.values()) {
                c0361a.f1719d.add(c0351k);
                m2601d(c0361a);
            }
        }

        private void m2595a(ComponentName componentName, IBinder iBinder) {
            C0361a c0361a = (C0361a) this.f1724d.get(componentName);
            if (c0361a != null) {
                c0361a.f1718c = C0313a.m2408a(iBinder);
                c0361a.f1720e = 0;
                m2601d(c0361a);
            }
        }

        private void m2594a(ComponentName componentName) {
            C0361a c0361a = (C0361a) this.f1724d.get(componentName);
            if (c0361a != null) {
                m2598b(c0361a);
            }
        }

        private void m2597b(ComponentName componentName) {
            C0361a c0361a = (C0361a) this.f1724d.get(componentName);
            if (c0361a != null) {
                m2601d(c0361a);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f1723c.obtainMessage(1, new C0360i(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1723c.obtainMessage(2, componentName).sendToTarget();
        }

        private void m2593a() {
            Set b = bg.m2607b(this.f1721a);
            if (!b.equals(this.f1725e)) {
                this.f1725e = b;
                List<ResolveInfo> queryIntentServices = this.f1721a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (b.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f1724d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f1724d.put(componentName2, new C0361a(componentName2));
                    }
                }
                Iterator it = this.f1724d.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        m2598b((C0361a) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean m2596a(C0361a c0361a) {
            if (c0361a.f1717b) {
                return true;
            }
            c0361a.f1717b = this.f1721a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(c0361a.f1716a), this, bg.f1726a);
            if (c0361a.f1717b) {
                c0361a.f1720e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + c0361a.f1716a);
                this.f1721a.unbindService(this);
            }
            return c0361a.f1717b;
        }

        private void m2598b(C0361a c0361a) {
            if (c0361a.f1717b) {
                this.f1721a.unbindService(this);
                c0361a.f1717b = false;
            }
            c0361a.f1718c = null;
        }

        private void m2600c(C0361a c0361a) {
            if (!this.f1723c.hasMessages(3, c0361a.f1716a)) {
                c0361a.f1720e++;
                if (c0361a.f1720e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + c0361a.f1719d.size() + " tasks to " + c0361a.f1716a + " after " + c0361a.f1720e + " retries");
                    c0361a.f1719d.clear();
                    return;
                }
                int i = (1 << (c0361a.f1720e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f1723c.sendMessageDelayed(this.f1723c.obtainMessage(3, c0361a.f1716a), (long) i);
            }
        }

        private void m2601d(C0361a c0361a) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + c0361a.f1716a + ", " + c0361a.f1719d.size() + " queued tasks");
            }
            if (!c0361a.f1719d.isEmpty()) {
                if (!m2596a(c0361a) || c0361a.f1718c == null) {
                    m2600c(c0361a);
                    return;
                }
                while (true) {
                    C0351k c0351k = (C0351k) c0361a.f1719d.peek();
                    if (c0351k == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + c0351k);
                        }
                        c0351k.mo329a(c0361a.f1718c);
                        c0361a.f1719d.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + c0361a.f1716a);
                        }
                    } catch (Throwable e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + c0361a.f1716a, e2);
                    }
                }
                if (!c0361a.f1719d.isEmpty()) {
                    m2600c(c0361a);
                }
            }
        }
    }

    static {
        if (C0466c.m3056a()) {
            f1732i = new C0358c();
        } else if (VERSION.SDK_INT >= 19) {
            f1732i = new C0357g();
        } else if (VERSION.SDK_INT >= 14) {
            f1732i = new C0356f();
        } else if (VERSION.SDK_INT >= 5) {
            f1732i = new C0355e();
        } else {
            f1732i = new C0354d();
        }
    }

    public static bg m2604a(Context context) {
        return new bg(context);
    }

    private bg(Context context) {
        this.f1733e = context;
    }

    public void m2608a(int i) {
        m2610a(null, i);
    }

    public void m2610a(String str, int i) {
        f1732i.mo331a(this.f1734f, str, i);
        if (VERSION.SDK_INT <= 19) {
            m2605a(new C0352a(this.f1733e.getPackageName(), i, str));
        }
    }

    public void m2609a(int i, Notification notification) {
        m2611a(null, i, notification);
    }

    public void m2611a(String str, int i, Notification notification) {
        if (m2606a(notification)) {
            m2605a(new C0359h(this.f1733e.getPackageName(), i, str, notification));
            f1732i.mo331a(this.f1734f, str, i);
            return;
        }
        f1732i.mo332a(this.f1734f, str, i, notification);
    }

    public static Set<String> m2607b(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1727b) {
            if (string != null) {
                if (!string.equals(f1728c)) {
                    String[] split = string.split(":");
                    Set hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f1729d = hashSet;
                    f1728c = string;
                }
            }
        }
        return f1729d;
    }

    private static boolean m2606a(Notification notification) {
        Bundle a = av.m2539a(notification);
        return a != null && a.getBoolean("android.support.useSideChannel");
    }

    private void m2605a(C0351k c0351k) {
        synchronized (f1730g) {
            if (f1731h == null) {
                f1731h = new C0362j(this.f1733e.getApplicationContext());
            }
            f1731h.m2602a(c0351k);
        }
    }
}
