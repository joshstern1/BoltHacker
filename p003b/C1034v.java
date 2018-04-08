package p003b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class C1034v implements C1020i {
    public final C1021e f3982a = new C1021e();
    public final ab f3983b;
    boolean f3984c;

    C1034v(ab abVar) {
        if (abVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f3983b = abVar;
    }

    public C1021e mo1097b() {
        return this.f3982a;
    }

    public long read(C1021e c1021e, long j) throws IOException {
        if (c1021e == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f3984c) {
            throw new IllegalStateException("closed");
        } else if (this.f3982a.f3952b == 0 && this.f3983b.read(this.f3982a, 8192) == -1) {
            return -1;
        } else {
            return this.f3982a.read(c1021e, Math.min(j, this.f3982a.f3952b));
        }
    }

    public boolean mo1104e() throws IOException {
        if (!this.f3984c) {
            return this.f3982a.mo1104e() && this.f3983b.read(this.f3982a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void mo1096a(long j) throws IOException {
        if (!mo1100b(j)) {
            throw new EOFException();
        }
    }

    public boolean mo1100b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f3984c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f3982a.f3952b < j) {
                if (this.f3983b.read(this.f3982a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte mo1108h() throws IOException {
        mo1096a(1);
        return this.f3982a.mo1108h();
    }

    public C1024j mo1103d(long j) throws IOException {
        mo1096a(j);
        return this.f3982a.mo1103d(j);
    }

    public byte[] mo1121s() throws IOException {
        this.f3982a.mo1095a(this.f3983b);
        return this.f3982a.mo1121s();
    }

    public byte[] mo1107g(long j) throws IOException {
        mo1096a(j);
        return this.f3982a.mo1107g(j);
    }

    public long mo1094a(aa aaVar) throws IOException {
        if (aaVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f3983b.read(this.f3982a, 8192) != -1) {
            long g = this.f3982a.m7362g();
            if (g > 0) {
                j += g;
                aaVar.mo8a(this.f3982a, g);
            }
        }
        if (this.f3982a.m7324a() <= 0) {
            return j;
        }
        j += this.f3982a.m7324a();
        aaVar.mo8a(this.f3982a, this.f3982a.m7324a());
        return j;
    }

    public String mo1120q() throws IOException {
        long a = mo1093a((byte) 10);
        if (a != -1) {
            return this.f3982a.m7361f(a);
        }
        C1021e c1021e = new C1021e();
        this.f3982a.m7330a(c1021e, 0, Math.min(32, this.f3982a.m7324a()));
        throw new EOFException("\\n not found: size=" + this.f3982a.m7324a() + " content=" + c1021e.m7379o().mo1135c() + "…");
    }

    public short mo1112i() throws IOException {
        mo1096a(2);
        return this.f3982a.mo1112i();
    }

    public short mo1115k() throws IOException {
        mo1096a(2);
        return this.f3982a.mo1115k();
    }

    public int mo1113j() throws IOException {
        mo1096a(4);
        return this.f3982a.mo1113j();
    }

    public int mo1116l() throws IOException {
        mo1096a(4);
        return this.f3982a.mo1116l();
    }

    public long mo1118m() throws IOException {
        mo1096a(1);
        int i = 0;
        while (mo1100b((long) (i + 1))) {
            byte c = this.f3982a.m7348c((long) i);
            if ((c < (byte) 48 || c > (byte) 57) && !(i == 0 && c == (byte) 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(c)}));
                }
                return this.f3982a.mo1118m();
            }
            i++;
        }
        return this.f3982a.mo1118m();
    }

    public long mo1119n() throws IOException {
        mo1096a(1);
        for (int i = 0; mo1100b((long) (i + 1)); i++) {
            byte c = this.f3982a.m7348c((long) i);
            if ((c < (byte) 48 || c > (byte) 57) && ((c < (byte) 97 || c > (byte) 102) && (c < (byte) 65 || c > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(c)}));
                }
                return this.f3982a.mo1119n();
            }
        }
        return this.f3982a.mo1119n();
    }

    public void mo1110h(long j) throws IOException {
        if (this.f3984c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f3982a.f3952b == 0 && this.f3983b.read(this.f3982a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f3982a.m7324a());
            this.f3982a.mo1110h(min);
            j -= min;
        }
    }

    public long mo1093a(byte b) throws IOException {
        return m7450a(b, 0);
    }

    public long m7450a(byte b, long j) throws IOException {
        if (this.f3984c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long a = this.f3982a.m7326a(b, j);
            if (a != -1) {
                return a;
            }
            a = this.f3982a.f3952b;
            if (this.f3983b.read(this.f3982a, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, a);
        }
    }

    public InputStream mo1105f() {
        return new C1035w(this);
    }

    public void close() throws IOException {
        if (!this.f3984c) {
            this.f3984c = true;
            this.f3983b.close();
            this.f3982a.m7384t();
        }
    }

    public ac timeout() {
        return this.f3983b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f3983b + ")";
    }
}
