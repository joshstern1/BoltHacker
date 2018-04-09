package android.support.v4.p024g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class C0496h<K, V> {
    C0504b f1943b;
    C0505c f1944c;
    C0507e f1945d;

    final class C0503a<T> implements Iterator<T> {
        final int f1965a;
        int f1966b;
        int f1967c;
        boolean f1968d = false;
        final /* synthetic */ C0496h f1969e;

        C0503a(C0496h c0496h, int i) {
            this.f1969e = c0496h;
            this.f1965a = i;
            this.f1966b = c0496h.mo419a();
        }

        public boolean hasNext() {
            return this.f1967c < this.f1966b;
        }

        public T next() {
            T a = this.f1969e.mo421a(this.f1967c, this.f1965a);
            this.f1967c++;
            this.f1968d = true;
            return a;
        }

        public void remove() {
            if (this.f1968d) {
                this.f1967c--;
                this.f1966b--;
                this.f1968d = false;
                this.f1969e.mo423a(this.f1967c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class C0504b implements Set<Entry<K, V>> {
        final /* synthetic */ C0496h f1970a;

        C0504b(C0496h c0496h) {
            this.f1970a = c0496h;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m3158a((Entry) obj);
        }

        public boolean m3158a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f1970a.mo419a();
            for (Entry entry : collection) {
                this.f1970a.mo424a(entry.getKey(), entry.getValue());
            }
            return a != this.f1970a.mo419a();
        }

        public void clear() {
            this.f1970a.mo427c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f1970a.mo420a(entry.getKey());
            if (a >= 0) {
                return C0498c.m3135a(this.f1970a.mo421a(a, 1), entry.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f1970a.mo419a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0506d(this.f1970a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f1970a.mo419a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C0496h.m3106a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f1970a.mo419a() - 1;
            int i = 0;
            while (a >= 0) {
                int i2;
                Object a2 = this.f1970a.mo421a(a, 0);
                Object a3 = this.f1970a.mo421a(a, 1);
                int hashCode = a2 == null ? 0 : a2.hashCode();
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                a--;
                i += i2 ^ hashCode;
            }
            return i;
        }
    }

    final class C0505c implements Set<K> {
        final /* synthetic */ C0496h f1971a;

        C0505c(C0496h c0496h) {
            this.f1971a = c0496h;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1971a.mo427c();
        }

        public boolean contains(Object obj) {
            return this.f1971a.mo420a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0496h.m3105a(this.f1971a.mo426b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f1971a.mo419a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0503a(this.f1971a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f1971a.mo420a(obj);
            if (a < 0) {
                return false;
            }
            this.f1971a.mo423a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0496h.m3107b(this.f1971a.mo426b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0496h.m3108c(this.f1971a.mo426b(), collection);
        }

        public int size() {
            return this.f1971a.mo419a();
        }

        public Object[] toArray() {
            return this.f1971a.m3118b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1971a.m3115a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return C0496h.m3106a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f1971a.mo419a() - 1; a >= 0; a--) {
                Object a2 = this.f1971a.mo421a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    final class C0506d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f1972a;
        int f1973b;
        boolean f1974c = false;
        final /* synthetic */ C0496h f1975d;

        public /* synthetic */ Object next() {
            return m3159a();
        }

        C0506d(C0496h c0496h) {
            this.f1975d = c0496h;
            this.f1972a = c0496h.mo419a() - 1;
            this.f1973b = -1;
        }

        public boolean hasNext() {
            return this.f1973b < this.f1972a;
        }

        public Entry<K, V> m3159a() {
            this.f1973b++;
            this.f1974c = true;
            return this;
        }

        public void remove() {
            if (this.f1974c) {
                this.f1975d.mo423a(this.f1973b);
                this.f1973b--;
                this.f1972a--;
                this.f1974c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f1974c) {
                return this.f1975d.mo421a(this.f1973b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1974c) {
                return this.f1975d.mo421a(this.f1973b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f1974c) {
                return this.f1975d.mo422a(this.f1973b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f1974c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0498c.m3135a(entry.getKey(), this.f1975d.mo421a(this.f1973b, 0)) && C0498c.m3135a(entry.getValue(), this.f1975d.mo421a(this.f1973b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f1974c) {
                Object a = this.f1975d.mo421a(this.f1973b, 0);
                Object a2 = this.f1975d.mo421a(this.f1973b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class C0507e implements Collection<V> {
        final /* synthetic */ C0496h f1976a;

        C0507e(C0496h c0496h) {
            this.f1976a = c0496h;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1976a.mo427c();
        }

        public boolean contains(Object obj) {
            return this.f1976a.mo425b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f1976a.mo419a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0503a(this.f1976a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f1976a.mo425b(obj);
            if (b < 0) {
                return false;
            }
            this.f1976a.mo423a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f1976a.mo419a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f1976a.mo421a(i, 1))) {
                    this.f1976a.mo423a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f1976a.mo419a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f1976a.mo421a(i, 1))) {
                    this.f1976a.mo423a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f1976a.mo419a();
        }

        public Object[] toArray() {
            return this.f1976a.m3118b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1976a.m3115a((Object[]) tArr, 1);
        }
    }

    protected abstract int mo419a();

    protected abstract int mo420a(Object obj);

    protected abstract Object mo421a(int i, int i2);

    protected abstract V mo422a(int i, V v);

    protected abstract void mo423a(int i);

    protected abstract void mo424a(K k, V v);

    protected abstract int mo425b(Object obj);

    protected abstract Map<K, V> mo426b();

    protected abstract void mo427c();

    C0496h() {
    }

    public static <K, V> boolean m3105a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m3107b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m3108c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m3118b(int i) {
        int a = mo419a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo421a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m3115a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo419a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo421a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m3106a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> m3120d() {
        if (this.f1943b == null) {
            this.f1943b = new C0504b(this);
        }
        return this.f1943b;
    }

    public Set<K> m3121e() {
        if (this.f1944c == null) {
            this.f1944c = new C0505c(this);
        }
        return this.f1944c;
    }

    public Collection<V> m3122f() {
        if (this.f1945d == null) {
            this.f1945d = new C0507e(this);
        }
        return this.f1945d;
    }
}
