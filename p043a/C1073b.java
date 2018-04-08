package com.p041a.p042a.p043a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class C1073b {
    final C1075d f4102a;
    final Map<String, Object> f4103b = new ConcurrentHashMap();

    public C1073b(C1075d c1075d) {
        this.f4102a = c1075d;
    }

    void m7617a(String str, String str2) {
        if (!this.f4102a.m7622a((Object) str, "key") && !this.f4102a.m7622a((Object) str2, "value")) {
            m7616a(this.f4102a.m7621a(str), this.f4102a.m7621a(str2));
        }
    }

    void m7616a(String str, Object obj) {
        if (!this.f4102a.m7623a(this.f4103b, str)) {
            this.f4103b.put(str, obj);
        }
    }

    public String toString() {
        return new JSONObject(this.f4103b).toString();
    }
}
