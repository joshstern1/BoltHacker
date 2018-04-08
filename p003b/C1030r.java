package p003b;

import java.io.IOException;
import java.io.OutputStream;

final class C1030r implements aa {
    final /* synthetic */ ac f3974a;
    final /* synthetic */ OutputStream f3975b;

    C1030r(ac acVar, OutputStream outputStream) {
        this.f3974a = acVar;
        this.f3975b = outputStream;
    }

    public void mo8a(C1021e c1021e, long j) throws IOException {
        ae.m7284a(c1021e.f3952b, 0, j);
        while (j > 0) {
            this.f3974a.mo1092g();
            C1036x c1036x = c1021e.f3951a;
            int min = (int) Math.min(j, (long) (c1036x.f3988c - c1036x.f3987b));
            this.f3975b.write(c1036x.f3986a, c1036x.f3987b, min);
            c1036x.f3987b += min;
            j -= (long) min;
            c1021e.f3952b -= (long) min;
            if (c1036x.f3987b == c1036x.f3988c) {
                c1021e.f3951a = c1036x.m7469a();
                C1037y.m7475a(c1036x);
            }
        }
    }

    public void flush() throws IOException {
        this.f3975b.flush();
    }

    public void close() throws IOException {
        this.f3975b.close();
    }

    public ac timeout() {
        return this.f3974a;
    }

    public String toString() {
        return "sink(" + this.f3975b + ")";
    }
}
