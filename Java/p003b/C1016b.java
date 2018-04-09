package p003b;

import java.io.IOException;

class C1016b implements aa {
    final /* synthetic */ aa f3944a;
    final /* synthetic */ C0051a f3945b;

    C1016b(C0051a c0051a, aa aaVar) {
        this.f3945b = c0051a;
        this.f3944a = aaVar;
    }

    public void mo8a(C1021e c1021e, long j) throws IOException {
        ae.m7284a(c1021e.f3952b, 0, j);
        long j2 = j;
        while (j2 > 0) {
            C1036x c1036x = c1021e.f3951a;
            long j3 = 0;
            while (j3 < 65536) {
                long j4 = ((long) (c1021e.f3951a.f3988c - c1021e.f3951a.f3987b)) + j3;
                if (j4 >= j2) {
                    j3 = j2;
                    break;
                } else {
                    c1036x = c1036x.f3991f;
                    j3 = j4;
                }
            }
            this.f3945b.m336c();
            try {
                this.f3944a.mo8a(c1021e, j3);
                j2 -= j3;
                this.f3945b.m334a(true);
            } catch (IOException e) {
                throw this.f3945b.m335b(e);
            } catch (Throwable th) {
                this.f3945b.m334a(false);
            }
        }
    }

    public void flush() throws IOException {
        this.f3945b.m336c();
        try {
            this.f3944a.flush();
            this.f3945b.m334a(true);
        } catch (IOException e) {
            throw this.f3945b.m335b(e);
        } catch (Throwable th) {
            this.f3945b.m334a(false);
        }
    }

    public void close() throws IOException {
        this.f3945b.m336c();
        try {
            this.f3944a.close();
            this.f3945b.m334a(true);
        } catch (IOException e) {
            throw this.f3945b.m335b(e);
        } catch (Throwable th) {
            this.f3945b.m334a(false);
        }
    }

    public ac timeout() {
        return this.f3945b;
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.f3944a + ")";
    }
}
