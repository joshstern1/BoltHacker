package p003b;

import java.io.IOException;

class C1017c implements ab {
    final /* synthetic */ ab f3946a;
    final /* synthetic */ C0051a f3947b;

    C1017c(C0051a c0051a, ab abVar) {
        this.f3947b = c0051a;
        this.f3946a = abVar;
    }

    public long read(C1021e c1021e, long j) throws IOException {
        this.f3947b.m336c();
        try {
            long read = this.f3946a.read(c1021e, j);
            this.f3947b.m334a(true);
            return read;
        } catch (IOException e) {
            throw this.f3947b.m335b(e);
        } catch (Throwable th) {
            this.f3947b.m334a(false);
        }
    }

    public void close() throws IOException {
        try {
            this.f3946a.close();
            this.f3947b.m334a(true);
        } catch (IOException e) {
            throw this.f3947b.m335b(e);
        } catch (Throwable th) {
            this.f3947b.m334a(false);
        }
    }

    public ac timeout() {
        return this.f3947b;
    }

    public String toString() {
        return "AsyncTimeout.source(" + this.f3946a + ")";
    }
}
