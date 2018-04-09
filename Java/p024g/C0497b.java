package android.support.v4.p024g;

import java.util.Map;

class C0497b extends C0496h<K, V> {
    final /* synthetic */ C0495a f1946a;

    C0497b(C0495a c0495a) {
        this.f1946a = c0495a;
    }

    protected int mo419a() {
        return this.f1946a.h;
    }

    protected Object mo421a(int i, int i2) {
        return this.f1946a.g[(i << 1) + i2];
    }

    protected int mo420a(Object obj) {
        return this.f1946a.m3095a(obj);
    }

    protected int mo425b(Object obj) {
        return this.f1946a.m3099b(obj);
    }

    protected Map<K, V> mo426b() {
        return this.f1946a;
    }

    protected void mo424a(K k, V v) {
        this.f1946a.put(k, v);
    }

    protected V mo422a(int i, V v) {
        return this.f1946a.m3097a(i, (Object) v);
    }

    protected void mo423a(int i) {
        this.f1946a.m3102d(i);
    }

    protected void mo427c() {
        this.f1946a.clear();
    }
}
