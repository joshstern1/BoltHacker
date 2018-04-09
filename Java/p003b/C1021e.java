package p003b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import no.nordicsemi.android.dfu.DfuBaseService;

public final class C1021e implements C1019h, C1020i, Cloneable {
    private static final byte[] f3950c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    C1036x f3951a;
    long f3952b;

    public /* synthetic */ C1019h mo1098b(C1024j c1024j) throws IOException {
        return m7331a(c1024j);
    }

    public /* synthetic */ C1019h mo1099b(String str) throws IOException {
        return m7332a(str);
    }

    public /* synthetic */ C1019h mo1101c(byte[] bArr) throws IOException {
        return m7343b(bArr);
    }

    public /* synthetic */ C1019h mo1102c(byte[] bArr, int i, int i2) throws IOException {
        return m7344b(bArr, i, i2);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m7385u();
    }

    public /* synthetic */ C1019h mo1106g(int i) throws IOException {
        return m7354d(i);
    }

    public /* synthetic */ C1019h mo1109h(int i) throws IOException {
        return m7349c(i);
    }

    public /* synthetic */ C1019h mo1111i(int i) throws IOException {
        return m7342b(i);
    }

    public /* synthetic */ C1019h mo1114k(long j) throws IOException {
        return m7372j(j);
    }

    public /* synthetic */ C1019h mo1117l(long j) throws IOException {
        return m7368i(j);
    }

    public /* synthetic */ C1019h mo1122w() throws IOException {
        return m7353d();
    }

    public long m7324a() {
        return this.f3952b;
    }

    public C1021e mo1097b() {
        return this;
    }

    public OutputStream m7352c() {
        return new C1022f(this);
    }

    public C1021e m7353d() {
        return this;
    }

    public boolean mo1104e() {
        return this.f3952b == 0;
    }

    public void mo1096a(long j) throws EOFException {
        if (this.f3952b < j) {
            throw new EOFException();
        }
    }

    public boolean mo1100b(long j) {
        return this.f3952b >= j;
    }

    public InputStream mo1105f() {
        return new C1023g(this);
    }

    public C1021e m7330a(C1021e c1021e, long j, long j2) {
        if (c1021e == null) {
            throw new IllegalArgumentException("out == null");
        }
        ae.m7284a(this.f3952b, j, j2);
        if (j2 != 0) {
            c1021e.f3952b += j2;
            C1036x c1036x = this.f3951a;
            while (j >= ((long) (c1036x.f3988c - c1036x.f3987b))) {
                j -= (long) (c1036x.f3988c - c1036x.f3987b);
                c1036x = c1036x.f3991f;
            }
            while (j2 > 0) {
                C1036x c1036x2 = new C1036x(c1036x);
                c1036x2.f3987b = (int) (((long) c1036x2.f3987b) + j);
                c1036x2.f3988c = Math.min(c1036x2.f3987b + ((int) j2), c1036x2.f3988c);
                if (c1021e.f3951a == null) {
                    c1036x2.f3992g = c1036x2;
                    c1036x2.f3991f = c1036x2;
                    c1021e.f3951a = c1036x2;
                } else {
                    c1021e.f3951a.f3992g.m7471a(c1036x2);
                }
                j2 -= (long) (c1036x2.f3988c - c1036x2.f3987b);
                c1036x = c1036x.f3991f;
                j = 0;
            }
        }
        return this;
    }

    public long m7362g() {
        long j = this.f3952b;
        if (j == 0) {
            return 0;
        }
        C1036x c1036x = this.f3951a.f3992g;
        if (c1036x.f3988c >= DfuBaseService.ERROR_REMOTE_MASK || !c1036x.f3990e) {
            return j;
        }
        return j - ((long) (c1036x.f3988c - c1036x.f3987b));
    }

    public byte mo1108h() {
        if (this.f3952b == 0) {
            throw new IllegalStateException("size == 0");
        }
        C1036x c1036x = this.f3951a;
        int i = c1036x.f3987b;
        int i2 = c1036x.f3988c;
        int i3 = i + 1;
        byte b = c1036x.f3986a[i];
        this.f3952b--;
        if (i3 == i2) {
            this.f3951a = c1036x.m7469a();
            C1037y.m7475a(c1036x);
        } else {
            c1036x.f3987b = i3;
        }
        return b;
    }

    public byte m7348c(long j) {
        ae.m7284a(this.f3952b, j, 1);
        C1036x c1036x = this.f3951a;
        while (true) {
            int i = c1036x.f3988c - c1036x.f3987b;
            if (j < ((long) i)) {
                return c1036x.f3986a[c1036x.f3987b + ((int) j)];
            }
            j -= (long) i;
            c1036x = c1036x.f3991f;
        }
    }

    public short mo1112i() {
        if (this.f3952b < 2) {
            throw new IllegalStateException("size < 2: " + this.f3952b);
        }
        C1036x c1036x = this.f3951a;
        int i = c1036x.f3987b;
        int i2 = c1036x.f3988c;
        if (i2 - i < 2) {
            return (short) (((mo1108h() & 255) << 8) | (mo1108h() & 255));
        }
        byte[] bArr = c1036x.f3986a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f3952b -= 2;
        if (i4 == i2) {
            this.f3951a = c1036x.m7469a();
            C1037y.m7475a(c1036x);
        } else {
            c1036x.f3987b = i4;
        }
        return (short) i;
    }

    public int mo1113j() {
        if (this.f3952b < 4) {
            throw new IllegalStateException("size < 4: " + this.f3952b);
        }
        C1036x c1036x = this.f3951a;
        int i = c1036x.f3987b;
        int i2 = c1036x.f3988c;
        if (i2 - i < 4) {
            return ((((mo1108h() & 255) << 24) | ((mo1108h() & 255) << 16)) | ((mo1108h() & 255) << 8)) | (mo1108h() & 255);
        }
        byte[] bArr = c1036x.f3986a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.f3952b -= 4;
        if (i4 == i2) {
            this.f3951a = c1036x.m7469a();
            C1037y.m7475a(c1036x);
            return i;
        }
        c1036x.f3987b = i4;
        return i;
    }

    public short mo1115k() {
        return ae.m7283a(mo1112i());
    }

    public int mo1116l() {
        return ae.m7282a(mo1113j());
    }

    public long mo1118m() {
        if (this.f3952b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        Object obj2 = null;
        long j2 = -7;
        do {
            C1036x c1036x = this.f3951a;
            byte[] bArr = c1036x.f3986a;
            int i2 = c1036x.f3987b;
            int i3 = c1036x.f3988c;
            while (i2 < i3) {
                int i4 = bArr[i2];
                if (i4 >= (byte) 48 && i4 <= (byte) 57) {
                    int i5 = 48 - i4;
                    if (j < -922337203685477580L || (j == -922337203685477580L && ((long) i5) < j2)) {
                        C1021e b = new C1021e().m7368i(j).m7342b(i4);
                        if (obj == null) {
                            b.mo1108h();
                        }
                        throw new NumberFormatException("Number too large: " + b.m7380p());
                    }
                    j = (j * 10) + ((long) i5);
                } else if (i4 != 45 || i != 0) {
                    if (i != 0) {
                        obj2 = 1;
                        if (i2 != i3) {
                            this.f3951a = c1036x.m7469a();
                            C1037y.m7475a(c1036x);
                        } else {
                            c1036x.f3987b = i2;
                        }
                        if (obj2 == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(i4));
                    }
                } else {
                    obj = 1;
                    j2--;
                }
                i2++;
                i++;
            }
            if (i2 != i3) {
                c1036x.f3987b = i2;
            } else {
                this.f3951a = c1036x.m7469a();
                C1037y.m7475a(c1036x);
            }
            if (obj2 == null) {
                break;
            }
        } while (this.f3951a != null);
        this.f3952b -= (long) i;
        if (obj != null) {
            return j;
        }
        return -j;
    }

    public long mo1119n() {
        if (this.f3952b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            C1036x c1036x = this.f3951a;
            byte[] bArr = c1036x.f3986a;
            int i2 = c1036x.f3987b;
            int i3 = c1036x.f3988c;
            int i4 = i2;
            while (i4 < i3) {
                byte b = bArr[i4];
                if (b >= (byte) 48 && b <= (byte) 57) {
                    i2 = b - 48;
                } else if (b >= (byte) 97 && b <= (byte) 102) {
                    i2 = (b - 97) + 10;
                } else if (b < (byte) 65 || b > (byte) 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.f3951a = c1036x.m7469a();
                            C1037y.m7475a(c1036x);
                        } else {
                            c1036x.f3987b = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                } else {
                    i2 = (b - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new C1021e().m7372j(j).m7342b((int) b).m7380p());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                c1036x.f3987b = i4;
            } else {
                this.f3951a = c1036x.m7469a();
                C1037y.m7475a(c1036x);
            }
            if (obj == null) {
                break;
            }
        } while (this.f3951a != null);
        this.f3952b -= (long) i;
        return j;
    }

    public C1024j m7379o() {
        return new C1024j(mo1121s());
    }

    public C1024j mo1103d(long j) throws EOFException {
        return new C1024j(mo1107g(j));
    }

    public long mo1094a(aa aaVar) throws IOException {
        long j = this.f3952b;
        if (j > 0) {
            aaVar.mo8a(this, j);
        }
        return j;
    }

    public String m7380p() {
        try {
            return m7336a(this.f3952b, ae.f3943a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String m7357e(long j) throws EOFException {
        return m7336a(j, ae.f3943a);
    }

    public String m7337a(Charset charset) {
        try {
            return m7336a(this.f3952b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String m7336a(long j, Charset charset) throws EOFException {
        ae.m7284a(this.f3952b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            C1036x c1036x = this.f3951a;
            if (((long) c1036x.f3987b) + j > ((long) c1036x.f3988c)) {
                return new String(mo1107g(j), charset);
            }
            String str = new String(c1036x.f3986a, c1036x.f3987b, (int) j, charset);
            c1036x.f3987b = (int) (((long) c1036x.f3987b) + j);
            this.f3952b -= j;
            if (c1036x.f3987b != c1036x.f3988c) {
                return str;
            }
            this.f3951a = c1036x.m7469a();
            C1037y.m7475a(c1036x);
            return str;
        }
    }

    public String mo1120q() throws EOFException {
        long a = mo1093a((byte) 10);
        if (a != -1) {
            return m7361f(a);
        }
        C1021e c1021e = new C1021e();
        m7330a(c1021e, 0, Math.min(32, this.f3952b));
        throw new EOFException("\\n not found: size=" + m7324a() + " content=" + c1021e.m7379o().mo1135c() + "…");
    }

    String m7361f(long j) throws EOFException {
        if (j <= 0 || m7348c(j - 1) != (byte) 13) {
            String e = m7357e(j);
            mo1110h(1);
            return e;
        }
        e = m7357e(j - 1);
        mo1110h(2);
        return e;
    }

    public int m7382r() throws EOFException {
        if (this.f3952b == 0) {
            throw new EOFException();
        }
        int i;
        int i2;
        int i3;
        byte c = m7348c(0);
        if ((c & 128) == 0) {
            i = 0;
            i2 = c & 127;
            i3 = 1;
        } else if ((c & 224) == 192) {
            i2 = c & 31;
            i3 = 2;
            i = 128;
        } else if ((c & 240) == 224) {
            i2 = c & 15;
            i3 = 3;
            i = 2048;
        } else if ((c & 248) == 240) {
            i2 = c & 7;
            i3 = 4;
            i = 65536;
        } else {
            mo1110h(1);
            return 65533;
        }
        if (this.f3952b < ((long) i3)) {
            throw new EOFException("size < " + i3 + ": " + this.f3952b + " (to read code point prefixed 0x" + Integer.toHexString(c) + ")");
        }
        int i4 = i2;
        i2 = 1;
        while (i2 < i3) {
            c = m7348c((long) i2);
            if ((c & 192) == 128) {
                i2++;
                i4 = (c & 63) | (i4 << 6);
            } else {
                mo1110h((long) i2);
                return 65533;
            }
        }
        mo1110h((long) i3);
        if (i4 > 1114111) {
            return 65533;
        }
        if (i4 >= 55296 && i4 <= 57343) {
            return 65533;
        }
        if (i4 < i) {
            return 65533;
        }
        return i4;
    }

    public byte[] mo1121s() {
        try {
            return mo1107g(this.f3952b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] mo1107g(long j) throws EOFException {
        ae.m7284a(this.f3952b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        m7340a(bArr);
        return bArr;
    }

    public void m7340a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = m7323a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public int m7323a(byte[] bArr, int i, int i2) {
        ae.m7284a((long) bArr.length, (long) i, (long) i2);
        C1036x c1036x = this.f3951a;
        if (c1036x == null) {
            return -1;
        }
        int min = Math.min(i2, c1036x.f3988c - c1036x.f3987b);
        System.arraycopy(c1036x.f3986a, c1036x.f3987b, bArr, i, min);
        c1036x.f3987b += min;
        this.f3952b -= (long) min;
        if (c1036x.f3987b != c1036x.f3988c) {
            return min;
        }
        this.f3951a = c1036x.m7469a();
        C1037y.m7475a(c1036x);
        return min;
    }

    public void m7384t() {
        try {
            mo1110h(this.f3952b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void mo1110h(long j) throws EOFException {
        while (j > 0) {
            if (this.f3951a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f3951a.f3988c - this.f3951a.f3987b));
            this.f3952b -= (long) min;
            j -= (long) min;
            C1036x c1036x = this.f3951a;
            c1036x.f3987b = min + c1036x.f3987b;
            if (this.f3951a.f3987b == this.f3951a.f3988c) {
                C1036x c1036x2 = this.f3951a;
                this.f3951a = c1036x2.m7469a();
                C1037y.m7475a(c1036x2);
            }
        }
    }

    public C1021e m7331a(C1024j c1024j) {
        if (c1024j == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        c1024j.mo1131a(this);
        return this;
    }

    public C1021e m7332a(String str) {
        return m7333a(str, 0, str.length());
    }

    public C1021e m7333a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < '') {
                    int i4;
                    C1036x e = m7356e(1);
                    byte[] bArr = e.f3986a;
                    int i5 = e.f3988c - i;
                    int min = Math.min(i2, 8192 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - e.f3988c;
                    e.f3988c += i4;
                    this.f3952b += (long) i4;
                } else if (charAt < 'ࠀ') {
                    m7342b((charAt >> 6) | 192);
                    m7342b((charAt & 63) | 128);
                    i3 = i + 1;
                } else if (charAt < '?' || charAt > '?') {
                    m7342b((charAt >> 12) | 224);
                    m7342b(((charAt >> 6) & 63) | 128);
                    m7342b((charAt & 63) | 128);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '?' || i3 < 56320 || i3 > 57343) {
                        m7342b(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        m7342b((i3 >> 18) | 240);
                        m7342b(((i3 >> 12) & 63) | 128);
                        m7342b(((i3 >> 6) & 63) | 128);
                        m7342b((i3 & 63) | 128);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    public C1021e m7329a(int i) {
        if (i < 128) {
            m7342b(i);
        } else if (i < 2048) {
            m7342b((i >> 6) | 192);
            m7342b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                m7342b((i >> 12) | 224);
                m7342b(((i >> 6) & 63) | 128);
                m7342b((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            m7342b((i >> 18) | 240);
            m7342b(((i >> 12) & 63) | 128);
            m7342b(((i >> 6) & 63) | 128);
            m7342b((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public C1021e m7335a(String str, Charset charset) {
        return m7334a(str, 0, str.length(), charset);
    }

    public C1021e m7334a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(ae.f3943a)) {
            return m7332a(str);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return m7344b(bytes, 0, bytes.length);
        }
    }

    public C1021e m7343b(byte[] bArr) {
        if (bArr != null) {
            return m7344b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public C1021e m7344b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        ae.m7284a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            C1036x e = m7356e(1);
            int min = Math.min(i3 - i, 8192 - e.f3988c);
            System.arraycopy(bArr, i, e.f3986a, e.f3988c, min);
            i += min;
            e.f3988c = min + e.f3988c;
        }
        this.f3952b += (long) i2;
        return this;
    }

    public long mo1095a(ab abVar) throws IOException {
        if (abVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = abVar.read(this, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public C1021e m7342b(int i) {
        C1036x e = m7356e(1);
        byte[] bArr = e.f3986a;
        int i2 = e.f3988c;
        e.f3988c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f3952b++;
        return this;
    }

    public C1021e m7349c(int i) {
        C1036x e = m7356e(2);
        byte[] bArr = e.f3986a;
        int i2 = e.f3988c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f3988c = i2;
        this.f3952b += 2;
        return this;
    }

    public C1021e m7354d(int i) {
        C1036x e = m7356e(4);
        byte[] bArr = e.f3986a;
        int i2 = e.f3988c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f3988c = i2;
        this.f3952b += 4;
        return this;
    }

    public C1021e m7368i(long j) {
        if (j == 0) {
            return m7342b(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return m7332a("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        C1036x e = m7356e(i);
        byte[] bArr = e.f3986a;
        int i2 = e.f3988c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f3950c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        e.f3988c += i;
        this.f3952b = ((long) i) + this.f3952b;
        return this;
    }

    public C1021e m7372j(long j) {
        if (j == 0) {
            return m7342b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C1036x e = m7356e(numberOfTrailingZeros);
        byte[] bArr = e.f3986a;
        int i = e.f3988c;
        for (int i2 = (e.f3988c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f3950c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f3988c += numberOfTrailingZeros;
        this.f3952b = ((long) numberOfTrailingZeros) + this.f3952b;
        return this;
    }

    C1036x m7356e(int i) {
        if (i < 1 || i > DfuBaseService.ERROR_REMOTE_MASK) {
            throw new IllegalArgumentException();
        } else if (this.f3951a == null) {
            this.f3951a = C1037y.m7474a();
            C1036x c1036x = this.f3951a;
            C1036x c1036x2 = this.f3951a;
            r0 = this.f3951a;
            c1036x2.f3992g = r0;
            c1036x.f3991f = r0;
            return r0;
        } else {
            r0 = this.f3951a.f3992g;
            if (r0.f3988c + i > DfuBaseService.ERROR_REMOTE_MASK || !r0.f3990e) {
                return r0.m7471a(C1037y.m7474a());
            }
            return r0;
        }
    }

    public void mo8a(C1021e c1021e, long j) {
        if (c1021e == null) {
            throw new IllegalArgumentException("source == null");
        } else if (c1021e == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            ae.m7284a(c1021e.f3952b, 0, j);
            while (j > 0) {
                C1036x c1036x;
                if (j < ((long) (c1021e.f3951a.f3988c - c1021e.f3951a.f3987b))) {
                    c1036x = this.f3951a != null ? this.f3951a.f3992g : null;
                    if (c1036x != null && c1036x.f3990e) {
                        if ((((long) c1036x.f3988c) + j) - ((long) (c1036x.f3989d ? 0 : c1036x.f3987b)) <= 8192) {
                            c1021e.f3951a.m7472a(c1036x, (int) j);
                            c1021e.f3952b -= j;
                            this.f3952b += j;
                            return;
                        }
                    }
                    c1021e.f3951a = c1021e.f3951a.m7470a((int) j);
                }
                C1036x c1036x2 = c1021e.f3951a;
                long j2 = (long) (c1036x2.f3988c - c1036x2.f3987b);
                c1021e.f3951a = c1036x2.m7469a();
                if (this.f3951a == null) {
                    this.f3951a = c1036x2;
                    c1036x2 = this.f3951a;
                    c1036x = this.f3951a;
                    C1036x c1036x3 = this.f3951a;
                    c1036x.f3992g = c1036x3;
                    c1036x2.f3991f = c1036x3;
                } else {
                    this.f3951a.f3992g.m7471a(c1036x2).m7473b();
                }
                c1021e.f3952b -= j2;
                this.f3952b += j2;
                j -= j2;
            }
        }
    }

    public long read(C1021e c1021e, long j) {
        if (c1021e == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f3952b == 0) {
            return -1;
        } else {
            if (j > this.f3952b) {
                j = this.f3952b;
            }
            c1021e.mo8a(this, j);
            return j;
        }
    }

    public long mo1093a(byte b) {
        return m7326a(b, 0);
    }

    public long m7326a(byte b, long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C1036x c1036x = this.f3951a;
        if (c1036x == null) {
            return -1;
        }
        C1036x c1036x2;
        if (this.f3952b - j >= j) {
            c1036x2 = c1036x;
            while (true) {
                long j3 = ((long) (c1036x2.f3988c - c1036x2.f3987b)) + j2;
                if (j3 >= j) {
                    break;
                }
                c1036x2 = c1036x2.f3991f;
                j2 = j3;
            }
        } else {
            j2 = this.f3952b;
            c1036x2 = c1036x;
            while (j2 > j) {
                c1036x2 = c1036x2.f3992g;
                j2 -= (long) (c1036x2.f3988c - c1036x2.f3987b);
            }
        }
        while (j2 < this.f3952b) {
            byte[] bArr = c1036x2.f3986a;
            int i = c1036x2.f3988c;
            for (int i2 = (int) ((((long) c1036x2.f3987b) + j) - j2); i2 < i; i2++) {
                if (bArr[i2] == b) {
                    return j2 + ((long) (i2 - c1036x2.f3987b));
                }
            }
            j2 += (long) (c1036x2.f3988c - c1036x2.f3987b);
            c1036x2 = c1036x2.f3991f;
            j = j2;
        }
        return -1;
    }

    public void flush() {
    }

    public void close() {
    }

    public ac timeout() {
        return ac.f223b;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1021e)) {
            return false;
        }
        C1021e c1021e = (C1021e) obj;
        if (this.f3952b != c1021e.f3952b) {
            return false;
        }
        if (this.f3952b == 0) {
            return true;
        }
        C1036x c1036x = this.f3951a;
        C1036x c1036x2 = c1021e.f3951a;
        int i = c1036x.f3987b;
        int i2 = c1036x2.f3987b;
        while (j < this.f3952b) {
            long min = (long) Math.min(c1036x.f3988c - i, c1036x2.f3988c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = c1036x.f3986a[i];
                i = i2 + 1;
                if (b != c1036x2.f3986a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == c1036x.f3988c) {
                c1036x = c1036x.f3991f;
                i = c1036x.f3987b;
            }
            if (i2 == c1036x2.f3988c) {
                c1036x2 = c1036x2.f3991f;
                i2 = c1036x2.f3987b;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        C1036x c1036x = this.f3951a;
        if (c1036x == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c1036x.f3987b;
            while (i2 < c1036x.f3988c) {
                int i3 = c1036x.f3986a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            c1036x = c1036x.f3991f;
        } while (c1036x != this.f3951a);
        return i;
    }

    public String toString() {
        return m7386v().toString();
    }

    public C1021e m7385u() {
        C1021e c1021e = new C1021e();
        if (this.f3952b == 0) {
            return c1021e;
        }
        c1021e.f3951a = new C1036x(this.f3951a);
        C1036x c1036x = c1021e.f3951a;
        C1036x c1036x2 = c1021e.f3951a;
        C1036x c1036x3 = c1021e.f3951a;
        c1036x2.f3992g = c1036x3;
        c1036x.f3991f = c1036x3;
        for (c1036x = this.f3951a.f3991f; c1036x != this.f3951a; c1036x = c1036x.f3991f) {
            c1021e.f3951a.f3992g.m7471a(new C1036x(c1036x));
        }
        c1021e.f3952b = this.f3952b;
        return c1021e;
    }

    public C1024j m7386v() {
        if (this.f3952b <= 2147483647L) {
            return m7359f((int) this.f3952b);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f3952b);
    }

    public C1024j m7359f(int i) {
        if (i == 0) {
            return C1024j.f3956b;
        }
        return new C1038z(this, i);
    }
}
