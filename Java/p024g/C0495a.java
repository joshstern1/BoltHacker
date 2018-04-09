package android.support.v4.p024g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C0495a<K, V> extends C0494j<K, V> implements Map<K, V> {
    C0496h<K, V> f1942a;

    public C0495a(int i) {
        super(i);
    }

    private C0496h<K, V> m3103b() {
        if (this.f1942a == null) {
            this.f1942a = new C0497b(this);
        }
        return this.f1942a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m3098a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m3104a(Collection<?> collection) {
        return C0496h.m3108c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m3103b().m3120d();
    }

    public Set<K> keySet() {
        return m3103b().m3121e();
    }

    public Collection<V> values() {
        return m3103b().m3122f();
    }
}
