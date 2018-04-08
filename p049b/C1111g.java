package com.p041a.p042a.p049b;

import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C1065a;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import io.p038b.p039a.p040a.p044a.p055e.C3011c;
import io.p038b.p039a.p040a.p044a.p055e.C3017d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class C1111g extends C1065a {
    private final C1113i f4186b;

    static String m7727a(String str) {
        return "3:" + str;
    }

    public C1111g(C1062l c1062l, String str, String str2, C3009g c3009g, C1113i c1113i) {
        super(c1062l, str, str2, c3009g, C3011c.GET);
        this.f4186b = c1113i;
    }

    public C1112h m7729a(String str, String str2, C1110f c1110f) {
        C3017d a;
        Throwable e;
        Throwable th;
        C1112h c1112h = null;
        try {
            Map a2 = m7728a(c1110f);
            try {
                a = m7726a(m7579a(a2), str, str2);
                C3059d.m17342h().mo2431a("Beta", "Checking for updates from " + m7580a());
                C3059d.m17342h().mo2431a("Beta", "Checking for updates query params are: " + a2);
                if (a.m17214c()) {
                    C3059d.m17342h().mo2431a("Beta", "Checking for updates was successful");
                    c1112h = this.f4186b.m7730a(new JSONObject(a.m17219e()));
                    if (a != null) {
                        C3059d.m17342h().mo2431a("Fabric", "Checking for updates request ID: " + a.m17210b("X-REQUEST-ID"));
                    }
                } else {
                    C3059d.m17342h().mo2438e("Beta", "Checking for updates failed. Response code: " + a.m17208b());
                    if (a != null) {
                        C3059d.m17342h().mo2431a("Fabric", "Checking for updates request ID: " + a.m17210b("X-REQUEST-ID"));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C3059d.m17342h().mo2439e("Beta", "Error while checking for updates from " + m7580a(), e);
                    if (a != null) {
                        C3059d.m17342h().mo2431a("Fabric", "Checking for updates request ID: " + a.m17210b("X-REQUEST-ID"));
                    }
                    return c1112h;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        C3059d.m17342h().mo2431a("Fabric", "Checking for updates request ID: " + a.m17210b("X-REQUEST-ID"));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            C3059d.m17342h().mo2439e("Beta", "Error while checking for updates from " + m7580a(), e);
            if (a != null) {
                C3059d.m17342h().mo2431a("Fabric", "Checking for updates request ID: " + a.m17210b("X-REQUEST-ID"));
            }
            return c1112h;
        } catch (Throwable e4) {
            a = null;
            th = e4;
            if (a != null) {
                C3059d.m17342h().mo2431a("Fabric", "Checking for updates request ID: " + a.m17210b("X-REQUEST-ID"));
            }
            throw th;
        }
        return c1112h;
    }

    private C3017d m7726a(C3017d c3017d, String str, String str2) {
        return c3017d.m17198a("Accept", "application/json").m17198a("User-Agent", "Crashlytics Android SDK/" + this.a.mo1148a()).m17198a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").m17198a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m17198a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo1148a()).m17198a("X-CRASHLYTICS-API-KEY", str).m17198a("X-CRASHLYTICS-BETA-TOKEN", C1111g.m7727a(str2));
    }

    private Map<String, String> m7728a(C1110f c1110f) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c1110f.f4182a);
        hashMap.put("display_version", c1110f.f4183b);
        hashMap.put("instance", c1110f.f4184c);
        hashMap.put("source", "3");
        return hashMap;
    }
}
