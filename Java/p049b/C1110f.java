package com.p041a.p042a.p049b;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class C1110f {
    public final String f4182a;
    public final String f4183b;
    public final String f4184c;
    public final String f4185d;

    C1110f(String str, String str2, String str3, String str4) {
        this.f4182a = str;
        this.f4183b = str2;
        this.f4184c = str3;
        this.f4185d = str4;
    }

    public static C1110f m7725a(Properties properties) {
        return new C1110f(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static C1110f m7724a(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return C1110f.m7725a(properties);
    }
}
