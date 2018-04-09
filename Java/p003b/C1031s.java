package p003b;

import java.io.IOException;
import java.io.InputStream;

final class C1031s implements ab {
    final /* synthetic */ ac f3976a;
    final /* synthetic */ InputStream f3977b;

    C1031s(ac acVar, InputStream inputStream) {
        this.f3976a = acVar;
        this.f3977b = inputStream;
    }

    public long read(C1021e c1021e, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            try {
                this.f3976a.mo1092g();
                C1036x e = c1021e.m7356e(1);
                int read = this.f3977b.read(e.f3986a, e.f3988c, (int) Math.min(j, (long) (8192 - e.f3988c)));
                if (read == -1) {
                    return -1;
                }
                e.f3988c += read;
                c1021e.f3952b += (long) read;
                return (long) read;
            } catch (AssertionError e2) {
                if (C1029q.m7428a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
    }

    public void close() throws IOException {
        this.f3977b.close();
    }

    public ac timeout() {
        return this.f3976a;
    }

    public String toString() {
        return "source(" + this.f3977b + ")";
    }
}
