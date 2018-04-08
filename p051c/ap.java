package com.p041a.p042a.p051c;

import android.content.Context;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p054g.C3044o;

class ap {
    private final Context f4251a;
    private final C3044o f4252b;

    public ap(Context context, C3044o c3044o) {
        this.f4251a = context;
        this.f4252b = c3044o;
    }

    public String m7755a() {
        return m7752a("com.crashlytics.CrashSubmissionPromptTitle", this.f4252b.f10053a);
    }

    public String m7756b() {
        return m7752a("com.crashlytics.CrashSubmissionPromptMessage", this.f4252b.f10054b);
    }

    public String m7757c() {
        return m7752a("com.crashlytics.CrashSubmissionSendTitle", this.f4252b.f10055c);
    }

    public String m7758d() {
        return m7752a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f4252b.f10059g);
    }

    public String m7759e() {
        return m7752a("com.crashlytics.CrashSubmissionCancelTitle", this.f4252b.f10057e);
    }

    private String m7752a(String str, String str2) {
        return m7754b(C2956j.m17003b(this.f4251a, str), str2);
    }

    private String m7754b(String str, String str2) {
        return m7753a(str) ? str2 : str;
    }

    private boolean m7753a(String str) {
        return str == null || str.length() == 0;
    }
}
