package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C1065a;
import io.p038b.p039a.p040a.p044a.p046b.C2974y;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import io.p038b.p039a.p040a.p044a.p055e.C3011c;
import io.p038b.p039a.p040a.p044a.p055e.C3017d;
import java.util.Map.Entry;
import no.nordicsemi.android.dfu.DfuBaseService;

class al extends C1065a implements ak {
    public al(C1062l c1062l, String str, String str2, C3009g c3009g) {
        super(c1062l, str, str2, c3009g, C3011c.POST);
    }

    public boolean mo1178a(aj ajVar) {
        C3017d b = m7747b(m7746a(m7581b(), ajVar), ajVar);
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Sending report to: " + m7580a());
        int b2 = b.m17208b();
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Create report request ID: " + b.m17210b("X-REQUEST-ID"));
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Result was: " + b2);
        return C2974y.m17080a(b2) == 0;
    }

    private C3017d m7746a(C3017d c3017d, aj ajVar) {
        C3017d a = c3017d.m17198a("X-CRASHLYTICS-API-KEY", ajVar.f4239a).m17198a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m17198a("X-CRASHLYTICS-API-CLIENT-VERSION", C1154g.m7958e().mo1148a());
        C3017d c3017d2 = a;
        for (Entry a2 : ajVar.f4240b.mo1193e().entrySet()) {
            c3017d2 = c3017d2.m17204a(a2);
        }
        return c3017d2;
    }

    private C3017d m7747b(C3017d c3017d, aj ajVar) {
        az azVar = ajVar.f4240b;
        return c3017d.m17201a("report[file]", azVar.mo1190b(), DfuBaseService.MIME_TYPE_OCTET_STREAM, azVar.mo1192d()).m17218e("report[identifier]", azVar.mo1191c());
    }
}
