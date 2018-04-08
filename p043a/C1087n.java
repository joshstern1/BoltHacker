package com.p041a.p042a.p043a;

import android.annotation.SuppressLint;
import android.content.Context;
import io.p038b.p039a.p040a.p044a.p121f.C3025c;
import io.p038b.p039a.p040a.p044a.p121f.C3026d;

class C1087n {
    private final C3025c f4130a;

    public static C1087n m7656a(Context context) {
        return new C1087n(new C3026d(context, "settings"));
    }

    C1087n(C3025c c3025c) {
        this.f4130a = c3025c;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void m7657a() {
        this.f4130a.mo2421a(this.f4130a.mo2422b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean m7658b() {
        return this.f4130a.mo2420a().getBoolean("analytics_launched", false);
    }
}
