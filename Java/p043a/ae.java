package com.p041a.p042a.p043a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class ae {
    public final af f4076a;
    public final long f4077b;
    public final C1071b f4078c;
    public final Map<String, String> f4079d;
    public final String f4080e;
    public final Map<String, Object> f4081f;
    public final String f4082g;
    public final Map<String, Object> f4083h;
    private String f4084i;

    static class C1070a {
        final C1071b f4060a;
        final long f4061b = System.currentTimeMillis();
        Map<String, String> f4062c = null;
        String f4063d = null;
        Map<String, Object> f4064e = null;
        String f4065f = null;
        Map<String, Object> f4066g = null;

        public C1070a(C1071b c1071b) {
            this.f4060a = c1071b;
        }

        public C1070a m7603a(Map<String, String> map) {
            this.f4062c = map;
            return this;
        }

        public C1070a m7602a(String str) {
            this.f4063d = str;
            return this;
        }

        public C1070a m7605b(Map<String, Object> map) {
            this.f4064e = map;
            return this;
        }

        public ae m7604a(af afVar) {
            return new ae(afVar, this.f4061b, this.f4060a, this.f4062c, this.f4063d, this.f4064e, this.f4065f, this.f4066g);
        }
    }

    enum C1071b {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    public static C1070a m7607a(C1071b c1071b, Activity activity) {
        return new C1070a(c1071b).m7603a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static C1070a m7606a() {
        return new C1070a(C1071b.INSTALL);
    }

    public static C1070a m7609a(String str) {
        return new C1070a(C1071b.CRASH).m7603a(Collections.singletonMap("sessionId", str));
    }

    public static C1070a m7610a(String str, String str2) {
        return ae.m7609a(str).m7605b(Collections.singletonMap("exceptionName", str2));
    }

    public static C1070a m7608a(C1091r c1091r) {
        return new C1070a(C1071b.CUSTOM).m7602a(c1091r.m7667b()).m7605b(c1091r.m7619a());
    }

    private ae(af afVar, long j, C1071b c1071b, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f4076a = afVar;
        this.f4077b = j;
        this.f4078c = c1071b;
        this.f4079d = map;
        this.f4080e = str;
        this.f4081f = map2;
        this.f4082g = str2;
        this.f4083h = map3;
    }

    public String toString() {
        if (this.f4084i == null) {
            this.f4084i = "[" + getClass().getSimpleName() + ": " + "timestamp=" + this.f4077b + ", type=" + this.f4078c + ", details=" + this.f4079d + ", customType=" + this.f4080e + ", customAttributes=" + this.f4081f + ", predefinedType=" + this.f4082g + ", predefinedAttributes=" + this.f4083h + ", metadata=[" + this.f4076a + "]]";
        }
        return this.f4084i;
    }
}
