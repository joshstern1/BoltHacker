package android.support.v7.p027a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.au;
import android.support.v4.app.av;
import android.support.v4.app.av.C0323s;
import android.support.v4.app.av.C0326d;
import android.support.v4.app.av.C0327e;
import android.support.v4.media.session.MediaSessionCompat.Token;

public class aj extends av {

    public static class C0765a extends C0326d {
        public C0765a(Context context) {
            super(context);
        }

        protected C0327e mo726c() {
            if (VERSION.SDK_INT >= 21) {
                return new C0768d();
            }
            if (VERSION.SDK_INT >= 16) {
                return new C0767c();
            }
            if (VERSION.SDK_INT >= 14) {
                return new C0766b();
            }
            return super.mo726c();
        }
    }

    private static class C0766b extends C0327e {
        private C0766b() {
        }

        public Notification mo727a(C0326d c0326d, au auVar) {
            aj.m5024b(auVar, c0326d);
            return auVar.mo328b();
        }
    }

    private static class C0767c extends C0327e {
        private C0767c() {
        }

        public Notification mo727a(C0326d c0326d, au auVar) {
            aj.m5024b(auVar, c0326d);
            Notification b = auVar.mo328b();
            aj.m5023b(b, c0326d);
            return b;
        }
    }

    private static class C0768d extends C0327e {
        private C0768d() {
        }

        public Notification mo727a(C0326d c0326d, au auVar) {
            aj.m5026d(auVar, c0326d.f1644m);
            return auVar.mo328b();
        }
    }

    public static class C0769e extends C0323s {
        int[] f2472a = null;
        Token f2473b;
        boolean f2474c;
        PendingIntent f2475h;
    }

    private static void m5026d(au auVar, C0323s c0323s) {
        if (c0323s instanceof C0769e) {
            C0769e c0769e = (C0769e) c0323s;
            al.m5027a(auVar, c0769e.f2472a, c0769e.f2473b != null ? c0769e.f2473b.m3179a() : null);
        }
    }

    private static void m5024b(au auVar, C0326d c0326d) {
        if (c0326d.f1644m instanceof C0769e) {
            C0769e c0769e = (C0769e) c0326d.f1644m;
            am.m5034a(auVar, c0326d.f1632a, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1640i, c0326d.f1638g, c0326d.f1645n, c0326d.f1643l, c0326d.f1630F.when, c0326d.f1653v, c0769e.f2472a, c0769e.f2474c, c0769e.f2475h);
        }
    }

    private static void m5023b(Notification notification, C0326d c0326d) {
        if (c0326d.f1644m instanceof C0769e) {
            C0769e c0769e = (C0769e) c0326d.f1644m;
            am.m5033a(notification, c0326d.f1632a, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1640i, c0326d.f1638g, c0326d.f1645n, c0326d.f1643l, c0326d.f1630F.when, c0326d.f1653v, c0769e.f2474c, c0769e.f2475h);
        }
    }
}
