package p003b;

import java.io.IOException;

public abstract class C0068m implements ab {
    private final ab delegate;

    public C0068m(ab abVar) {
        if (abVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = abVar;
    }

    public final ab delegate() {
        return this.delegate;
    }

    public long read(C1021e c1021e, long j) throws IOException {
        return this.delegate.read(c1021e, j);
    }

    public ac timeout() {
        return this.delegate.timeout();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
