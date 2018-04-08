package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ax.C0344a;
import android.support.v4.app.ay.C0345a;
import android.support.v4.app.az.C0346a;
import android.support.v4.app.ba.C0321a;
import android.support.v4.app.ba.C0321a.C0343a;
import android.support.v4.app.bd.C0348a;
import android.support.v4.app.be.C0349a;
import android.support.v4.app.bf.C0350a;
import android.support.v4.app.bl.C0367a;
import android.support.v4.p017e.C0466c;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class av {
    private static final C0332i f1680a;

    public static class C0322a extends C0321a {
        public static final C0343a f1610d = new aw();
        public int f1611a;
        public CharSequence f1612b;
        public PendingIntent f1613c;
        private final Bundle f1614e;
        private final bi[] f1615f;
        private boolean f1616g;

        public /* synthetic */ C0367a[] mo320g() {
            return m2470f();
        }

        public C0322a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, false);
        }

        private C0322a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, bi[] biVarArr, boolean z) {
            this.f1616g = false;
            this.f1611a = i;
            this.f1612b = C0326d.m2478d(charSequence);
            this.f1613c = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f1614e = bundle;
            this.f1615f = biVarArr;
            this.f1616g = z;
        }

        public int mo315a() {
            return this.f1611a;
        }

        public CharSequence mo316b() {
            return this.f1612b;
        }

        public PendingIntent mo317c() {
            return this.f1613c;
        }

        public Bundle mo318d() {
            return this.f1614e;
        }

        public boolean mo319e() {
            return this.f1616g;
        }

        public bi[] m2470f() {
            return this.f1615f;
        }
    }

    public static abstract class C0323s {
        C0326d f1617d;
        CharSequence f1618e;
        CharSequence f1619f;
        boolean f1620g = false;

        public void m2473a(C0326d c0326d) {
            if (this.f1617d != c0326d) {
                this.f1617d = c0326d;
                if (this.f1617d != null) {
                    this.f1617d.m2489a(this);
                }
            }
        }

        public void mo321a(Bundle bundle) {
        }
    }

    public static class C0324b extends C0323s {
        Bitmap f1621a;
        Bitmap f1622b;
        boolean f1623c;

        public C0324b m2475a(CharSequence charSequence) {
            this.f = C0326d.m2478d(charSequence);
            this.g = true;
            return this;
        }

        public C0324b m2474a(Bitmap bitmap) {
            this.f1621a = bitmap;
            return this;
        }
    }

    public static class C0325c extends C0323s {
        CharSequence f1624a;

        public C0325c m2476a(CharSequence charSequence) {
            this.f1624a = C0326d.m2478d(charSequence);
            return this;
        }
    }

    public static class C0326d {
        int f1625A = 0;
        Notification f1626B;
        RemoteViews f1627C;
        RemoteViews f1628D;
        RemoteViews f1629E;
        public Notification f1630F = new Notification();
        public ArrayList<String> f1631G;
        public Context f1632a;
        public CharSequence f1633b;
        public CharSequence f1634c;
        PendingIntent f1635d;
        PendingIntent f1636e;
        RemoteViews f1637f;
        public Bitmap f1638g;
        public CharSequence f1639h;
        public int f1640i;
        int f1641j;
        boolean f1642k = true;
        public boolean f1643l;
        public C0323s f1644m;
        public CharSequence f1645n;
        public CharSequence[] f1646o;
        int f1647p;
        int f1648q;
        boolean f1649r;
        String f1650s;
        boolean f1651t;
        String f1652u;
        public ArrayList<C0322a> f1653v = new ArrayList();
        boolean f1654w = false;
        String f1655x;
        Bundle f1656y;
        int f1657z = 0;

        public C0326d(Context context) {
            this.f1632a = context;
            this.f1630F.when = System.currentTimeMillis();
            this.f1630F.audioStreamType = -1;
            this.f1641j = 0;
            this.f1631G = new ArrayList();
        }

        public C0326d m2484a(long j) {
            this.f1630F.when = j;
            return this;
        }

        public C0326d m2480a(int i) {
            this.f1630F.icon = i;
            return this;
        }

        public C0326d m2490a(CharSequence charSequence) {
            this.f1633b = C0326d.m2478d(charSequence);
            return this;
        }

        public C0326d m2496b(CharSequence charSequence) {
            this.f1634c = C0326d.m2478d(charSequence);
            return this;
        }

        public C0326d m2494b(int i) {
            this.f1640i = i;
            return this;
        }

        public C0326d m2482a(int i, int i2, boolean z) {
            this.f1647p = i;
            this.f1648q = i2;
            this.f1649r = z;
            return this;
        }

        public C0326d m2485a(PendingIntent pendingIntent) {
            this.f1635d = pendingIntent;
            return this;
        }

        public C0326d m2495b(PendingIntent pendingIntent) {
            this.f1630F.deleteIntent = pendingIntent;
            return this;
        }

        public C0326d m2499c(CharSequence charSequence) {
            this.f1630F.tickerText = C0326d.m2478d(charSequence);
            return this;
        }

        public C0326d m2486a(Bitmap bitmap) {
            this.f1638g = bitmap;
            return this;
        }

        public C0326d m2487a(Uri uri) {
            this.f1630F.sound = uri;
            this.f1630F.audioStreamType = -1;
            return this;
        }

        public C0326d m2481a(int i, int i2, int i3) {
            int i4;
            int i5 = 1;
            this.f1630F.ledARGB = i;
            this.f1630F.ledOnMS = i2;
            this.f1630F.ledOffMS = i3;
            if (this.f1630F.ledOnMS == 0 || this.f1630F.ledOffMS == 0) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            Notification notification = this.f1630F;
            int i6 = this.f1630F.flags & -2;
            if (i4 == 0) {
                i5 = 0;
            }
            notification.flags = i6 | i5;
            return this;
        }

        public C0326d m2492a(boolean z) {
            m2477a(2, z);
            return this;
        }

        public C0326d m2497b(boolean z) {
            m2477a(8, z);
            return this;
        }

        public C0326d m2500c(boolean z) {
            m2477a(16, z);
            return this;
        }

        public C0326d m2498c(int i) {
            this.f1630F.defaults = i;
            if ((i & 4) != 0) {
                Notification notification = this.f1630F;
                notification.flags |= 1;
            }
            return this;
        }

        private void m2477a(int i, boolean z) {
            if (z) {
                Notification notification = this.f1630F;
                notification.flags |= i;
                return;
            }
            notification = this.f1630F;
            notification.flags &= i ^ -1;
        }

        public C0326d m2502d(int i) {
            this.f1641j = i;
            return this;
        }

        public C0326d m2491a(String str) {
            this.f1650s = str;
            return this;
        }

        public C0326d m2503d(boolean z) {
            this.f1651t = z;
            return this;
        }

        public Bundle m2479a() {
            if (this.f1656y == null) {
                this.f1656y = new Bundle();
            }
            return this.f1656y;
        }

        public C0326d m2483a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1653v.add(new C0322a(i, charSequence, pendingIntent));
            return this;
        }

        public C0326d m2489a(C0323s c0323s) {
            if (this.f1644m != c0323s) {
                this.f1644m = c0323s;
                if (this.f1644m != null) {
                    this.f1644m.m2473a(this);
                }
            }
            return this;
        }

        public C0326d m2504e(int i) {
            this.f1657z = i;
            return this;
        }

        public C0326d m2505f(int i) {
            this.f1625A = i;
            return this;
        }

        public C0326d m2488a(C0328f c0328f) {
            c0328f.mo325a(this);
            return this;
        }

        public Notification m2493b() {
            return av.f1680a.mo322a(this, mo726c());
        }

        protected C0327e mo726c() {
            return new C0327e();
        }

        protected static CharSequence m2478d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    protected static class C0327e {
        protected C0327e() {
        }

        public Notification mo727a(C0326d c0326d, au auVar) {
            return auVar.mo328b();
        }
    }

    public interface C0328f {
        C0326d mo325a(C0326d c0326d);
    }

    public static class C0329g extends C0323s {
        ArrayList<CharSequence> f1658a = new ArrayList();

        public C0329g m2508a(CharSequence charSequence) {
            this.e = C0326d.m2478d(charSequence);
            return this;
        }

        public C0329g m2509b(CharSequence charSequence) {
            this.f1658a.add(C0326d.m2478d(charSequence));
            return this;
        }
    }

    public static class C0331h extends C0323s {
        CharSequence f1664a;
        CharSequence f1665b;
        List<C0330a> f1666c = new ArrayList();

        public static final class C0330a {
            private final CharSequence f1659a;
            private final long f1660b;
            private final CharSequence f1661c;
            private String f1662d;
            private Uri f1663e;

            public CharSequence m2512a() {
                return this.f1659a;
            }

            public long m2513b() {
                return this.f1660b;
            }

            public CharSequence m2514c() {
                return this.f1661c;
            }

            public String m2515d() {
                return this.f1662d;
            }

            public Uri m2516e() {
                return this.f1663e;
            }

            private Bundle m2511f() {
                Bundle bundle = new Bundle();
                if (this.f1659a != null) {
                    bundle.putCharSequence("text", this.f1659a);
                }
                bundle.putLong("time", this.f1660b);
                if (this.f1661c != null) {
                    bundle.putCharSequence("sender", this.f1661c);
                }
                if (this.f1662d != null) {
                    bundle.putString("type", this.f1662d);
                }
                if (this.f1663e != null) {
                    bundle.putParcelable("uri", this.f1663e);
                }
                return bundle;
            }

            static Bundle[] m2510a(List<C0330a> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((C0330a) list.get(i)).m2511f();
                }
                return bundleArr;
            }
        }

        C0331h() {
        }

        public void mo321a(Bundle bundle) {
            super.mo321a(bundle);
            if (this.f1664a != null) {
                bundle.putCharSequence("android.selfDisplayName", this.f1664a);
            }
            if (this.f1665b != null) {
                bundle.putCharSequence("android.conversationTitle", this.f1665b);
            }
            if (!this.f1666c.isEmpty()) {
                bundle.putParcelableArray("android.messages", C0330a.m2510a(this.f1666c));
            }
        }
    }

    interface C0332i {
        Notification mo322a(C0326d c0326d, C0327e c0327e);

        Bundle mo323a(Notification notification);

        ArrayList<Parcelable> mo324a(C0322a[] c0322aArr);
    }

    static class C0333m implements C0332i {
        C0333m() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            Notification a = ba.m2561a(c0326d.f1630F, c0326d.f1632a, c0326d.f1633b, c0326d.f1634c, c0326d.f1635d);
            if (c0326d.f1641j > 0) {
                a.flags |= 128;
            }
            if (c0326d.f1627C != null) {
                a.contentView = c0326d.f1627C;
            }
            return a;
        }

        public Bundle mo323a(Notification notification) {
            return null;
        }

        public ArrayList<Parcelable> mo324a(C0322a[] c0322aArr) {
            return null;
        }
    }

    static class C0334q extends C0333m {
        C0334q() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            au c0349a = new C0349a(c0326d.f1632a, c0326d.f1630F, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1637f, c0326d.f1640i, c0326d.f1635d, c0326d.f1636e, c0326d.f1638g, c0326d.f1647p, c0326d.f1648q, c0326d.f1649r, c0326d.f1643l, c0326d.f1641j, c0326d.f1645n, c0326d.f1654w, c0326d.f1656y, c0326d.f1650s, c0326d.f1651t, c0326d.f1652u, c0326d.f1627C, c0326d.f1628D);
            av.m2543b((at) c0349a, c0326d.f1653v);
            av.m2545c(c0349a, c0326d.f1644m);
            Notification a = c0327e.mo727a(c0326d, c0349a);
            if (c0326d.f1644m != null) {
                c0326d.f1644m.mo321a(mo323a(a));
            }
            return a;
        }

        public Bundle mo323a(Notification notification) {
            return be.m2570a(notification);
        }

        public ArrayList<Parcelable> mo324a(C0322a[] c0322aArr) {
            return be.m2573a((C0321a[]) c0322aArr);
        }
    }

    static class C0335r extends C0334q {
        C0335r() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            au c0350a = new C0350a(c0326d.f1632a, c0326d.f1630F, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1637f, c0326d.f1640i, c0326d.f1635d, c0326d.f1636e, c0326d.f1638g, c0326d.f1647p, c0326d.f1648q, c0326d.f1649r, c0326d.f1642k, c0326d.f1643l, c0326d.f1641j, c0326d.f1645n, c0326d.f1654w, c0326d.f1631G, c0326d.f1656y, c0326d.f1650s, c0326d.f1651t, c0326d.f1652u, c0326d.f1627C, c0326d.f1628D);
            av.m2543b((at) c0350a, c0326d.f1653v);
            av.m2545c(c0350a, c0326d.f1644m);
            return c0327e.mo727a(c0326d, c0350a);
        }

        public Bundle mo323a(Notification notification) {
            return bf.m2580a(notification);
        }
    }

    static class C0336j extends C0335r {
        C0336j() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            au c0344a = new C0344a(c0326d.f1632a, c0326d.f1630F, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1637f, c0326d.f1640i, c0326d.f1635d, c0326d.f1636e, c0326d.f1638g, c0326d.f1647p, c0326d.f1648q, c0326d.f1649r, c0326d.f1642k, c0326d.f1643l, c0326d.f1641j, c0326d.f1645n, c0326d.f1654w, c0326d.f1631G, c0326d.f1656y, c0326d.f1650s, c0326d.f1651t, c0326d.f1652u, c0326d.f1627C, c0326d.f1628D);
            av.m2543b((at) c0344a, c0326d.f1653v);
            av.m2545c(c0344a, c0326d.f1644m);
            Notification a = c0327e.mo727a(c0326d, c0344a);
            if (c0326d.f1644m != null) {
                c0326d.f1644m.mo321a(mo323a(a));
            }
            return a;
        }

        public ArrayList<Parcelable> mo324a(C0322a[] c0322aArr) {
            return ax.m2551a((C0321a[]) c0322aArr);
        }
    }

    static class C0337k extends C0336j {
        C0337k() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            au c0345a = new C0345a(c0326d.f1632a, c0326d.f1630F, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1637f, c0326d.f1640i, c0326d.f1635d, c0326d.f1636e, c0326d.f1638g, c0326d.f1647p, c0326d.f1648q, c0326d.f1649r, c0326d.f1642k, c0326d.f1643l, c0326d.f1641j, c0326d.f1645n, c0326d.f1654w, c0326d.f1655x, c0326d.f1631G, c0326d.f1656y, c0326d.f1657z, c0326d.f1625A, c0326d.f1626B, c0326d.f1650s, c0326d.f1651t, c0326d.f1652u, c0326d.f1627C, c0326d.f1628D, c0326d.f1629E);
            av.m2543b((at) c0345a, c0326d.f1653v);
            av.m2545c(c0345a, c0326d.f1644m);
            Notification a = c0327e.mo727a(c0326d, c0345a);
            if (c0326d.f1644m != null) {
                c0326d.f1644m.mo321a(mo323a(a));
            }
            return a;
        }
    }

    static class C0338l extends C0337k {
        C0338l() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            au c0346a = new C0346a(c0326d.f1632a, c0326d.f1630F, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1637f, c0326d.f1640i, c0326d.f1635d, c0326d.f1636e, c0326d.f1638g, c0326d.f1647p, c0326d.f1648q, c0326d.f1649r, c0326d.f1642k, c0326d.f1643l, c0326d.f1641j, c0326d.f1645n, c0326d.f1654w, c0326d.f1655x, c0326d.f1631G, c0326d.f1656y, c0326d.f1657z, c0326d.f1625A, c0326d.f1626B, c0326d.f1650s, c0326d.f1651t, c0326d.f1652u, c0326d.f1646o, c0326d.f1627C, c0326d.f1628D, c0326d.f1629E);
            av.m2543b((at) c0346a, c0326d.f1653v);
            av.m2546d(c0346a, c0326d.f1644m);
            Notification a = c0327e.mo727a(c0326d, c0346a);
            if (c0326d.f1644m != null) {
                c0326d.f1644m.mo321a(mo323a(a));
            }
            return a;
        }
    }

    static class C0339n extends C0333m {
        C0339n() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            Notification a = bb.m2562a(c0326d.f1630F, c0326d.f1632a, c0326d.f1633b, c0326d.f1634c, c0326d.f1635d, c0326d.f1636e);
            if (c0326d.f1641j > 0) {
                a.flags |= 128;
            }
            if (c0326d.f1627C != null) {
                a.contentView = c0326d.f1627C;
            }
            return a;
        }
    }

    static class C0340o extends C0333m {
        C0340o() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            Notification a = bc.m2563a(c0326d.f1632a, c0326d.f1630F, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1637f, c0326d.f1640i, c0326d.f1635d, c0326d.f1636e, c0326d.f1638g);
            if (c0326d.f1627C != null) {
                a.contentView = c0326d.f1627C;
            }
            return a;
        }
    }

    static class C0341p extends C0333m {
        C0341p() {
        }

        public Notification mo322a(C0326d c0326d, C0327e c0327e) {
            Notification a = c0327e.mo727a(c0326d, new C0348a(c0326d.f1632a, c0326d.f1630F, c0326d.f1633b, c0326d.f1634c, c0326d.f1639h, c0326d.f1637f, c0326d.f1640i, c0326d.f1635d, c0326d.f1636e, c0326d.f1638g, c0326d.f1647p, c0326d.f1648q, c0326d.f1649r));
            if (c0326d.f1627C != null) {
                a.contentView = c0326d.f1627C;
            }
            return a;
        }
    }

    public static final class C0342t implements C0328f {
        private ArrayList<C0322a> f1667a = new ArrayList();
        private int f1668b = 1;
        private PendingIntent f1669c;
        private ArrayList<Notification> f1670d = new ArrayList();
        private Bitmap f1671e;
        private int f1672f;
        private int f1673g = 8388613;
        private int f1674h = -1;
        private int f1675i = 0;
        private int f1676j;
        private int f1677k = 80;
        private int f1678l;
        private String f1679m;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m2537a();
        }

        public C0326d mo325a(C0326d c0326d) {
            Bundle bundle = new Bundle();
            if (!this.f1667a.isEmpty()) {
                bundle.putParcelableArrayList("actions", av.f1680a.mo324a((C0322a[]) this.f1667a.toArray(new C0322a[this.f1667a.size()])));
            }
            if (this.f1668b != 1) {
                bundle.putInt("flags", this.f1668b);
            }
            if (this.f1669c != null) {
                bundle.putParcelable("displayIntent", this.f1669c);
            }
            if (!this.f1670d.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[]) this.f1670d.toArray(new Notification[this.f1670d.size()]));
            }
            if (this.f1671e != null) {
                bundle.putParcelable("background", this.f1671e);
            }
            if (this.f1672f != 0) {
                bundle.putInt("contentIcon", this.f1672f);
            }
            if (this.f1673g != 8388613) {
                bundle.putInt("contentIconGravity", this.f1673g);
            }
            if (this.f1674h != -1) {
                bundle.putInt("contentActionIndex", this.f1674h);
            }
            if (this.f1675i != 0) {
                bundle.putInt("customSizePreset", this.f1675i);
            }
            if (this.f1676j != 0) {
                bundle.putInt("customContentHeight", this.f1676j);
            }
            if (this.f1677k != 80) {
                bundle.putInt("gravity", this.f1677k);
            }
            if (this.f1678l != 0) {
                bundle.putInt("hintScreenTimeout", this.f1678l);
            }
            if (this.f1679m != null) {
                bundle.putString("dismissalId", this.f1679m);
            }
            c0326d.m2479a().putBundle("android.wearable.EXTENSIONS", bundle);
            return c0326d;
        }

        public C0342t m2537a() {
            C0342t c0342t = new C0342t();
            c0342t.f1667a = new ArrayList(this.f1667a);
            c0342t.f1668b = this.f1668b;
            c0342t.f1669c = this.f1669c;
            c0342t.f1670d = new ArrayList(this.f1670d);
            c0342t.f1671e = this.f1671e;
            c0342t.f1672f = this.f1672f;
            c0342t.f1673g = this.f1673g;
            c0342t.f1674h = this.f1674h;
            c0342t.f1675i = this.f1675i;
            c0342t.f1676j = this.f1676j;
            c0342t.f1677k = this.f1677k;
            c0342t.f1678l = this.f1678l;
            c0342t.f1679m = this.f1679m;
            return c0342t;
        }

        public C0342t m2538a(C0322a c0322a) {
            this.f1667a.add(c0322a);
            return this;
        }
    }

    private static void m2543b(at atVar, ArrayList<C0322a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            atVar.mo327a((C0322a) it.next());
        }
    }

    private static void m2545c(au auVar, C0323s c0323s) {
        if (c0323s == null) {
            return;
        }
        if (c0323s instanceof C0325c) {
            C0325c c0325c = (C0325c) c0323s;
            be.m2575a(auVar, c0325c.e, c0325c.g, c0325c.f, c0325c.f1624a);
        } else if (c0323s instanceof C0329g) {
            C0329g c0329g = (C0329g) c0323s;
            be.m2576a(auVar, c0329g.e, c0329g.g, c0329g.f, c0329g.f1658a);
        } else if (c0323s instanceof C0324b) {
            C0324b c0324b = (C0324b) c0323s;
            be.m2574a(auVar, c0324b.e, c0324b.g, c0324b.f, c0324b.f1621a, c0324b.f1622b, c0324b.f1623c);
        } else if (!(c0323s instanceof C0331h)) {
        }
    }

    private static void m2546d(au auVar, C0323s c0323s) {
        if (c0323s == null) {
            return;
        }
        if (c0323s instanceof C0331h) {
            C0331h c0331h = (C0331h) c0323s;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            List arrayList5 = new ArrayList();
            for (C0330a c0330a : c0331h.f1666c) {
                arrayList.add(c0330a.m2512a());
                arrayList2.add(Long.valueOf(c0330a.m2513b()));
                arrayList3.add(c0330a.m2514c());
                arrayList4.add(c0330a.m2515d());
                arrayList5.add(c0330a.m2516e());
            }
            az.m2559a(auVar, c0331h.f1664a, c0331h.f1665b, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
            return;
        }
        m2545c(auVar, c0323s);
    }

    static {
        if (C0466c.m3056a()) {
            f1680a = new C0338l();
        } else if (VERSION.SDK_INT >= 21) {
            f1680a = new C0337k();
        } else if (VERSION.SDK_INT >= 20) {
            f1680a = new C0336j();
        } else if (VERSION.SDK_INT >= 19) {
            f1680a = new C0335r();
        } else if (VERSION.SDK_INT >= 16) {
            f1680a = new C0334q();
        } else if (VERSION.SDK_INT >= 14) {
            f1680a = new C0341p();
        } else if (VERSION.SDK_INT >= 11) {
            f1680a = new C0340o();
        } else if (VERSION.SDK_INT >= 9) {
            f1680a = new C0339n();
        } else {
            f1680a = new C0333m();
        }
    }

    public static Bundle m2539a(Notification notification) {
        return f1680a.mo323a(notification);
    }
}
