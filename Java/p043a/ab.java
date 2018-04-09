package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p045d.C1066g;
import io.p038b.p039a.p040a.p044a.p046b.C1065a;
import io.p038b.p039a.p040a.p044a.p046b.C2974y;
import io.p038b.p039a.p040a.p044a.p055e.C3009g;
import io.p038b.p039a.p040a.p044a.p055e.C3011c;
import io.p038b.p039a.p040a.p044a.p055e.C3017d;
import java.io.File;
import java.util.List;

class ab extends C1065a implements C1066g {
    private final String f4054b;

    public ab(C1062l c1062l, String str, String str2, C3009g c3009g, String str3) {
        super(c1062l, str, str2, c3009g, C3011c.POST);
        this.f4054b = str3;
    }

    public boolean mo1155a(List<File> list) {
        C3017d a = m7581b().m17198a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m17198a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo1148a()).m17198a("X-CRASHLYTICS-API-KEY", this.f4054b);
        int i = 0;
        for (File file : list) {
            a.m17201a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        C3059d.m17342h().mo2431a("Answers", "Sending " + list.size() + " analytics files to " + m7580a());
        int b = a.m17208b();
        C3059d.m17342h().mo2431a("Answers", "Response code for analytics file send is " + b);
        if (C2974y.m17080a(b) == 0) {
            return true;
        }
        return false;
    }
}
