package com.p041a.p042a.p051c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.p041a.p042a.p043a.C1063a;
import com.p041a.p042a.p051c.p052a.C1124a;
import com.p041a.p042a.p051c.p052a.p053a.C1120d;
import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2954h;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p046b.C2958l.C2959a;
import io.p038b.p039a.p040a.p044a.p046b.C2962p;
import io.p038b.p039a.p040a.p044a.p047c.C1157q;
import io.p038b.p039a.p040a.p044a.p047c.C2992h;
import io.p038b.p039a.p040a.p044a.p047c.C3000r;
import io.p038b.p039a.p040a.p044a.p054g.C3044o;
import io.p038b.p039a.p040a.p044a.p054g.C3045p;
import io.p038b.p039a.p040a.p044a.p054g.C3048q;
import io.p038b.p039a.p040a.p044a.p054g.C3050t;
import io.p038b.p039a.p040a.p044a.p055e.C1176i;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import io.p038b.p039a.p040a.p044a.p055e.C3010b;
import io.p038b.p039a.p040a.p044a.p121f.C3023a;
import io.p038b.p039a.p040a.p044a.p121f.C3024b;
import io.p038b.p039a.p040a.p044a.p121f.C3025c;
import io.p038b.p039a.p040a.p044a.p121f.C3026d;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@C2992h(a = {C1124a.class})
public class C1154g extends C1062l<Void> {
    private C3009g f4339A;
    private C1171r f4340B;
    private C1124a f4341C;
    private final long f4342a;
    private final ConcurrentHashMap<String, String> f4343b;
    private File f4344c;
    private C3023a f4345d;
    private C1174u f4346k;
    private C1174u f4347l;
    private C1151v f4348m;
    private C1182y f4349n;
    private String f4350o;
    private String f4351p;
    private String f4352q;
    private String f4353r;
    private String f4354s;
    private String f4355t;
    private String f4356u;
    private String f4357v;
    private String f4358w;
    private float f4359x;
    private boolean f4360y;
    private final aw f4361z;

    private static final class C1150a implements Callable<Boolean> {
        private final C1174u f4336a;

        public /* synthetic */ Object call() throws Exception {
            return m7939a();
        }

        public C1150a(C1174u c1174u) {
            this.f4336a = c1174u;
        }

        public Boolean m7939a() throws Exception {
            if (!this.f4336a.m8022b()) {
                return Boolean.FALSE;
            }
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Found previous crash marker.");
            this.f4336a.m8023c();
            return Boolean.TRUE;
        }
    }

    private static final class C1152b implements C1151v {
        private C1152b() {
        }

        public void mo1194a() {
        }
    }

    private static class C1153c {
        private boolean f4337a;
        private final CountDownLatch f4338b;

        private C1153c() {
            this.f4337a = false;
            this.f4338b = new CountDownLatch(1);
        }

        void m7942a(boolean z) {
            this.f4337a = z;
            this.f4338b.countDown();
        }

        boolean m7943a() {
            return this.f4337a;
        }

        void m7944b() {
            try {
                this.f4338b.await();
            } catch (InterruptedException e) {
            }
        }
    }

    protected /* synthetic */ Object mo1150f() {
        return m7968c();
    }

    public C1154g() {
        this(1.0f, null, null, false);
    }

    C1154g(float f, C1151v c1151v, aw awVar, boolean z) {
        this(f, c1151v, awVar, z, C2962p.m17026a("Crashlytics Exception Handler"));
    }

    C1154g(float f, C1151v c1151v, aw awVar, boolean z, ExecutorService executorService) {
        this.f4350o = null;
        this.f4351p = null;
        this.f4352q = null;
        this.f4359x = f;
        if (c1151v == null) {
            c1151v = new C1152b();
        }
        this.f4348m = c1151v;
        this.f4361z = awVar;
        this.f4360y = z;
        this.f4340B = new C1171r(executorService);
        this.f4343b = new ConcurrentHashMap();
        this.f4342a = System.currentTimeMillis();
    }

    protected boolean h_() {
        return m7965a(super.m7540E());
    }

    boolean m7965a(Context context) {
        if (this.f4360y) {
            return false;
        }
        this.f4355t = new C2954h().m16973a(context);
        if (this.f4355t == null) {
            return false;
        }
        C3059d.m17342h().mo2435c("CrashlyticsCore", "Initializing Crashlytics " + mo1148a());
        this.f4345d = new C3024b(this);
        this.f4347l = new C1174u("crash_marker", this.f4345d);
        this.f4346k = new C1174u("initialization_marker", this.f4345d);
        try {
            m7950a(context, this.f4355t);
            be asVar = new as(context, m7972h());
            boolean u = m7985u();
            m7947K();
            m7951a(asVar);
            if (!u || !C2956j.m17019n(context)) {
                return true;
            }
            m7946J();
            return false;
        } catch (Throwable e) {
            throw new C3000r(e);
        } catch (Throwable e2) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e2);
            return false;
        }
    }

    private void m7950a(Context context, String str) throws NameNotFoundException {
        C1176i c1177x = this.f4361z != null ? new C1177x(this.f4361z) : null;
        this.f4339A = new C3010b(C3059d.m17342h());
        this.f4339A.mo2414a(c1177x);
        this.f4354s = context.getPackageName();
        this.f4356u = m7539D().m17046j();
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Installer package name is: " + this.f4356u);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.f4354s, 0);
        this.f4357v = Integer.toString(packageInfo.versionCode);
        this.f4358w = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
        this.f4353r = C2956j.m17018m(context);
        m7960a(this.f4353r, C1154g.m7956b(context)).m7737a(str, this.f4354s);
    }

    private void m7951a(be beVar) {
        try {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Installing exception handler...");
            this.f4349n = new C1182y(Thread.getDefaultUncaughtExceptionHandler(), this.f4340B, m7539D(), beVar, this.f4345d, this);
            this.f4349n.m8082b();
            Thread.setDefaultUncaughtExceptionHandler(this.f4349n);
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Successfully installed exception handler.");
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "There was a problem installing the exception handler.", e);
        }
    }

    protected Void m7968c() {
        m7983s();
        this.f4349n.m8087g();
        try {
            C3050t b = C3048q.m17296a().m17300b();
            if (b == null) {
                C3059d.m17342h().mo2436d("CrashlyticsCore", "Received null settings, skipping initialization!");
            } else if (b.f10078d.f10047c) {
                this.f4349n.m8083c();
                ak a = m7961a(b);
                if (a == null) {
                    C3059d.m17342h().mo2436d("CrashlyticsCore", "Unable to create a call to upload reports.");
                    m7984t();
                } else {
                    new ba(a).m7845a(this.f4359x);
                    m7984t();
                }
            } else {
                C3059d.m17342h().mo2431a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                m7984t();
            }
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            m7984t();
        }
        return null;
    }

    public String mo1149b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String mo1148a() {
        return "2.3.10.127";
    }

    public static C1154g m7958e() {
        return (C1154g) C3059d.m17334a(C1154g.class);
    }

    public void m7963a(String str) {
        if (!this.f4360y) {
            this.f4350o = C1154g.m7957d(str);
            this.f4349n.m8079a(this.f4350o, this.f4352q, this.f4351p);
        }
    }

    public void m7967b(String str) {
        if (!this.f4360y) {
            this.f4352q = C1154g.m7957d(str);
            this.f4349n.m8079a(this.f4350o, this.f4352q, this.f4351p);
        }
    }

    public void m7969c(String str) {
        if (!this.f4360y) {
            this.f4351p = C1154g.m7957d(str);
            this.f4349n.m8079a(this.f4350o, this.f4352q, this.f4351p);
        }
    }

    static void m7952a(String str, String str2) {
        C1063a c1063a = (C1063a) C3059d.m17334a(C1063a.class);
        if (c1063a != null) {
            c1063a.m7556a(new C2959a(str, str2));
        }
    }

    Map<String, String> m7971g() {
        return Collections.unmodifiableMap(this.f4343b);
    }

    C1125a m7960a(String str, boolean z) {
        return new C1125a(str, z);
    }

    String m7972h() {
        return this.f4354s;
    }

    String m7973i() {
        return this.f4355t;
    }

    String m7974j() {
        return this.f4356u;
    }

    String m7975k() {
        return this.f4358w;
    }

    String m7976l() {
        return this.f4357v;
    }

    String m7977m() {
        return C2956j.m17003b(m7540E(), "com.crashlytics.ApiEndpoint");
    }

    String m7978n() {
        return this.f4353r;
    }

    C1182y m7979o() {
        return this.f4349n;
    }

    String m7980p() {
        return m7539D().m17037a() ? this.f4350o : null;
    }

    String m7981q() {
        return m7539D().m17037a() ? this.f4351p : null;
    }

    String m7982r() {
        return m7539D().m17037a() ? this.f4352q : null;
    }

    private void m7946J() {
        Callable c1160h = new C1160h(this);
        for (C1157q a : m7544I()) {
            c1160h.m7999a(a);
        }
        Future submit = m7541F().m17355f().submit(c1160h);
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    void m7983s() {
        this.f4340B.m8017a(new C1161i(this));
    }

    void m7984t() {
        this.f4340B.m8019b(new C1162j(this));
    }

    boolean m7985u() {
        return ((Boolean) this.f4340B.m8017a(new C1163k(this))).booleanValue();
    }

    C1120d m7986v() {
        if (this.f4341C != null) {
            return this.f4341C.m7736a();
        }
        return null;
    }

    File m7987w() {
        if (this.f4344c == null) {
            this.f4344c = new C3024b(this).mo2419a();
        }
        return this.f4344c;
    }

    boolean m7988x() {
        return ((Boolean) C3048q.m17296a().m17299a(new C1165l(this), Boolean.valueOf(false))).booleanValue();
    }

    boolean m7989y() {
        return new C3026d(this).mo2420a().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void m7964a(boolean z) {
        C3025c c3026d = new C3026d(this);
        c3026d.mo2421a(c3026d.mo2422b().putBoolean("always_send_reports_opt_in", z));
    }

    boolean m7990z() {
        return ((Boolean) C3048q.m17296a().m17299a(new C1166m(this), Boolean.valueOf(true))).booleanValue();
    }

    ak m7961a(C3050t c3050t) {
        if (c3050t != null) {
            return new al(this, m7977m(), c3050t.f10075a.f10032d, this.f4339A);
        }
        return null;
    }

    private void m7947K() {
        if (Boolean.TRUE.equals((Boolean) this.f4340B.m8017a(new C1150a(this.f4347l)))) {
            try {
                this.f4348m.mo1194a();
            } catch (Throwable e) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void m7959A() {
        this.f4347l.m8021a();
    }

    private boolean m7953a(Activity activity, C3044o c3044o) {
        ap apVar = new ap(activity, c3044o);
        C1153c c1153c = new C1153c();
        activity.runOnUiThread(new C1167n(this, activity, c1153c, apVar, c3044o));
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Waiting for user opt-in.");
        c1153c.m7944b();
        return c1153c.m7943a();
    }

    static C3045p m7945B() {
        C3050t b = C3048q.m17296a().m17300b();
        return b == null ? null : b.f10076b;
    }

    private static boolean m7956b(Context context) {
        return C2956j.m16999a(context, "com.crashlytics.RequireBuildId", true);
    }

    private static String m7957d(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.length() > 1024) {
            return str.substring(0, 1024);
        }
        return str;
    }

    private static int m7955b(float f, int i) {
        return (int) (((float) i) * f);
    }
}
