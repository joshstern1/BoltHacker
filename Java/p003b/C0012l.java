package p003b;

import java.io.IOException;

public abstract class C0012l implements aa {
    private final aa f62a;

    public C0012l(aa aaVar) {
        if (aaVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f62a = aaVar;
    }

    public void mo8a(C1021e c1021e, long j) throws IOException {
        this.f62a.mo8a(c1021e, j);
    }

    public void flush() throws IOException {
        this.f62a.flush();
    }

    public ac timeout() {
        return this.f62a.timeout();
    }

    public void close() throws IOException {
        this.f62a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f62a.toString() + ")";
    }
}
