package com.p041a.p042a.p049b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C1108o;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p046b.C2967t;
import io.p038b.p039a.p040a.p044a.p046b.C2967t.C2966a;
import io.p038b.p039a.p040a.p044a.p046b.C2975z;
import io.p038b.p039a.p040a.p044a.p050a.C2944b;
import io.p038b.p039a.p040a.p044a.p054g.C3032f;
import io.p038b.p039a.p040a.p044a.p054g.C3048q;
import io.p038b.p039a.p040a.p044a.p054g.C3050t;
import io.p038b.p039a.p040a.p044a.p055e.C3010b;
import io.p038b.p039a.p040a.p044a.p121f.C3026d;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class C1109e extends C1062l<Boolean> implements C1108o {
    private final C2944b<String> f4179a = new C2944b();
    private final C1115j f4180b = new C1115j();
    private C1103l f4181c;

    protected /* synthetic */ Object mo1150f() {
        return m7720c();
    }

    @TargetApi(14)
    protected boolean h_() {
        this.f4181c = m7716a(VERSION.SDK_INT, (Application) m7540E().getApplicationContext());
        return true;
    }

    protected Boolean m7720c() {
        C3059d.m17342h().mo2431a("Beta", "Beta kit initializing...");
        Context E = m7540E();
        C2967t D = m7539D();
        if (TextUtils.isEmpty(m7714a(E, D.m17046j()))) {
            C3059d.m17342h().mo2431a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C3059d.m17342h().mo2431a("Beta", "Beta device token is present, checking for app updates.");
        C3032f h = m7715h();
        C1110f a = m7713a(E);
        if (m7718a(h, a)) {
            this.f4181c.mo1175a(E, this, D, h, a, new C3026d(this), new C2975z(), new C3010b(C3059d.m17342h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    C1103l m7716a(int i, Application application) {
        if (i >= 14) {
            return new C1105b(m7541F().m17354e(), m7541F().m17355f());
        }
        return new C1116k();
    }

    public Map<C2966a, String> mo1176e() {
        CharSequence a = m7714a(m7540E(), m7539D().m17046j());
        Map<C2966a, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(C2966a.FONT_TOKEN, a);
        }
        return hashMap;
    }

    public String mo1149b() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String mo1148a() {
        return "1.2.1.139";
    }

    boolean m7718a(C3032f c3032f, C1110f c1110f) {
        return (c3032f == null || TextUtils.isEmpty(c3032f.f10035a) || c1110f == null) ? false : true;
    }

    private String m7714a(Context context, String str) {
        Object obj;
        try {
            obj = (String) this.f4179a.mo2397a(context, this.f4180b);
            if ("".equals(obj)) {
                obj = null;
            }
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Beta", "Failed to load the Beta device token", e);
            obj = null;
        }
        C3059d.m17342h().mo2431a("Beta", "Beta device token present: " + (!TextUtils.isEmpty(obj)));
        return obj;
    }

    private C3032f m7715h() {
        C3050t b = C3048q.m17296a().m17300b();
        if (b != null) {
            return b.f10080f;
        }
        return null;
    }

    private C1110f m7713a(Context context) {
        C1110f a;
        Throwable th;
        Throwable e;
        Throwable th2;
        C1110f c1110f;
        InputStream inputStream = null;
        InputStream open;
        try {
            open = context.getAssets().open("crashlytics-build.properties");
            Object obj;
            if (open != null) {
                try {
                    a = C1110f.m7724a(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        C3059d.m17342h().mo2439e("Beta", "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                C3059d.m17342h().mo2439e("Beta", "Error closing Beta build properties asset", th22);
                            }
                        }
                        return c1110f;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                C3059d.m17342h().mo2439e("Beta", "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    C3059d.m17342h().mo2431a("Beta", a.f4185d + " build properties: " + a.f4183b + " (" + a.f4182a + ")" + " - " + a.f4184c);
                    c1110f = a;
                } catch (Throwable e22) {
                    th = e22;
                    c1110f = a;
                    th222 = th;
                    C3059d.m17342h().mo2439e("Beta", "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return c1110f;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    C3059d.m17342h().mo2439e("Beta", "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            c1110f = inputStream2;
            C3059d.m17342h().mo2439e("Beta", "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return c1110f;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return c1110f;
    }

    String m7723g() {
        return C2956j.m17003b(m7540E(), "com.crashlytics.ApiEndpoint");
    }
}
