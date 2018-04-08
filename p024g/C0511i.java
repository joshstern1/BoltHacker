package android.support.v4.p024g;

public final class C0511i {

    public interface C0508a<T> {
        T mo428a();

        boolean mo429a(T t);
    }

    public static class C0509b<T> implements C0508a<T> {
        private final Object[] f1977a;
        private int f1978b;

        public C0509b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1977a = new Object[i];
        }

        public T mo428a() {
            if (this.f1978b <= 0) {
                return null;
            }
            int i = this.f1978b - 1;
            T t = this.f1977a[i];
            this.f1977a[i] = null;
            this.f1978b--;
            return t;
        }

        public boolean mo429a(T t) {
            if (m3162b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f1978b >= this.f1977a.length) {
                return false;
            } else {
                this.f1977a[this.f1978b] = t;
                this.f1978b++;
                return true;
            }
        }

        private boolean m3162b(T t) {
            for (int i = 0; i < this.f1978b; i++) {
                if (this.f1977a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class C0510c<T> extends C0509b<T> {
        private final Object f1979a = new Object();

        public C0510c(int i) {
            super(i);
        }

        public T mo428a() {
            T a;
            synchronized (this.f1979a) {
                a = super.mo428a();
            }
            return a;
        }

        public boolean mo429a(T t) {
            boolean a;
            synchronized (this.f1979a) {
                a = super.mo429a(t);
            }
            return a;
        }
    }
}
