package p003b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class C1027o implements ab {
    private int f3964a = 0;
    private final C1020i f3965b;
    private final Inflater f3966c;
    private final C1028p f3967d;
    private final CRC32 f3968e = new CRC32();

    public C1027o(ab abVar) {
        if (abVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f3966c = new Inflater(true);
        this.f3965b = C1029q.m7427a(abVar);
        this.f3967d = new C1028p(this.f3965b, this.f3966c);
    }

    public long read(C1021e c1021e, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f3964a == 0) {
                m7414a();
                this.f3964a = 1;
            }
            if (this.f3964a == 1) {
                long j2 = c1021e.f3952b;
                long read = this.f3967d.read(c1021e, j);
                if (read != -1) {
                    m7415a(c1021e, j2, read);
                    return read;
                }
                this.f3964a = 2;
            }
            if (this.f3964a == 2) {
                m7417b();
                this.f3964a = 3;
                if (!this.f3965b.mo1104e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void m7414a() throws IOException {
        Object obj;
        long a;
        this.f3965b.mo1096a(10);
        byte c = this.f3965b.mo1097b().m7348c(3);
        if (((c >> 1) & 1) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m7415a(this.f3965b.mo1097b(), 0, 10);
        }
        m7416a("ID1ID2", 8075, this.f3965b.mo1112i());
        this.f3965b.mo1110h(8);
        if (((c >> 2) & 1) == 1) {
            this.f3965b.mo1096a(2);
            if (obj != null) {
                m7415a(this.f3965b.mo1097b(), 0, 2);
            }
            short k = this.f3965b.mo1097b().mo1115k();
            this.f3965b.mo1096a((long) k);
            if (obj != null) {
                m7415a(this.f3965b.mo1097b(), 0, (long) k);
            }
            this.f3965b.mo1110h((long) k);
        }
        if (((c >> 3) & 1) == 1) {
            a = this.f3965b.mo1093a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m7415a(this.f3965b.mo1097b(), 0, 1 + a);
            }
            this.f3965b.mo1110h(1 + a);
        }
        if (((c >> 4) & 1) == 1) {
            a = this.f3965b.mo1093a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m7415a(this.f3965b.mo1097b(), 0, 1 + a);
            }
            this.f3965b.mo1110h(1 + a);
        }
        if (obj != null) {
            m7416a("FHCRC", this.f3965b.mo1115k(), (short) ((int) this.f3968e.getValue()));
            this.f3968e.reset();
        }
    }

    private void m7417b() throws IOException {
        m7416a("CRC", this.f3965b.mo1116l(), (int) this.f3968e.getValue());
        m7416a("ISIZE", this.f3965b.mo1116l(), this.f3966c.getTotalOut());
    }

    public ac timeout() {
        return this.f3965b.timeout();
    }

    public void close() throws IOException {
        this.f3967d.close();
    }

    private void m7415a(C1021e c1021e, long j, long j2) {
        C1036x c1036x = c1021e.f3951a;
        while (j >= ((long) (c1036x.f3988c - c1036x.f3987b))) {
            j -= (long) (c1036x.f3988c - c1036x.f3987b);
            c1036x = c1036x.f3991f;
        }
        while (j2 > 0) {
            int i = (int) (((long) c1036x.f3987b) + j);
            int min = (int) Math.min((long) (c1036x.f3988c - i), j2);
            this.f3968e.update(c1036x.f3986a, i, min);
            j2 -= (long) min;
            c1036x = c1036x.f3991f;
            j = 0;
        }
    }

    private void m7416a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
