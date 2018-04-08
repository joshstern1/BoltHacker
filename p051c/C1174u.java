package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p121f.C3023a;
import java.io.File;

class C1174u {
    private final String f4384a;
    private final C3023a f4385b;

    public C1174u(String str, C3023a c3023a) {
        this.f4384a = str;
        this.f4385b = c3023a;
    }

    public boolean m8021a() {
        boolean z = false;
        try {
            z = m8020d().createNewFile();
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Error creating marker: " + this.f4384a, e);
        }
        return z;
    }

    public boolean m8022b() {
        return m8020d().exists();
    }

    public boolean m8023c() {
        return m8020d().delete();
    }

    private File m8020d() {
        return new File(this.f4385b.mo2419a(), this.f4384a);
    }
}
