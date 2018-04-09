package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class bd implements az {
    private final File f4315a;
    private final Map<String, String> f4316b;

    public bd(File file) {
        this(file, Collections.emptyMap());
    }

    public bd(File file, Map<String, String> map) {
        this.f4315a = file;
        this.f4316b = new HashMap(map);
        if (this.f4315a.length() == 0) {
            this.f4316b.putAll(ba.f4307a);
        }
    }

    public File mo1192d() {
        return this.f4315a;
    }

    public String mo1190b() {
        return mo1192d().getName();
    }

    public String mo1191c() {
        String b = mo1190b();
        return b.substring(0, b.lastIndexOf(46));
    }

    public Map<String, String> mo1193e() {
        return Collections.unmodifiableMap(this.f4316b);
    }

    public boolean mo1189a() {
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Removing report at " + this.f4315a.getPath());
        return this.f4315a.delete();
    }
}
