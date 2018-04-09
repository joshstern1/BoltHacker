package p003b;

import java.io.Serializable;
import java.util.Arrays;

public class C1024j implements Serializable, Comparable<C1024j> {
    static final char[] f3955a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final C1024j f3956b = C1024j.m7390a(new byte[0]);
    final byte[] f3957c;
    transient int f3958d;
    transient String f3959e;

    public /* synthetic */ int compareTo(Object obj) {
        return m7393a((C1024j) obj);
    }

    C1024j(byte[] bArr) {
        this.f3957c = bArr;
    }

    public static C1024j m7390a(byte... bArr) {
        if (bArr != null) {
            return new C1024j((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static C1024j m7389a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        C1024j c1024j = new C1024j(str.getBytes(ae.f3943a));
        c1024j.f3959e = str;
        return c1024j;
    }

    public String mo1130a() {
        String str = this.f3959e;
        if (str != null) {
            return str;
        }
        str = new String(this.f3957c, ae.f3943a);
        this.f3959e = str;
        return str;
    }

    public String mo1134b() {
        return C1018d.m7289a(this.f3957c);
    }

    public static C1024j m7391b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a = C1018d.m7291a(str);
        return a != null ? new C1024j(a) : null;
    }

    public String mo1135c() {
        int i = 0;
        char[] cArr = new char[(this.f3957c.length * 2)];
        byte[] bArr = this.f3957c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f3955a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = f3955a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public C1024j mo1136d() {
        int i = 0;
        while (i < this.f3957c.length) {
            byte b = this.f3957c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f3957c.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new C1024j(bArr);
            }
        }
        return this;
    }

    public C1024j mo1129a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.f3957c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f3957c.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f3957c.length) {
                return this;
            } else {
                Object obj = new byte[i3];
                System.arraycopy(this.f3957c, i, obj, 0, i3);
                this(obj);
                return this;
            }
        }
    }

    public byte mo1128a(int i) {
        return this.f3957c[i];
    }

    public int mo1137e() {
        return this.f3957c.length;
    }

    public byte[] mo1139f() {
        return (byte[]) this.f3957c.clone();
    }

    void mo1131a(C1021e c1021e) {
        c1021e.m7344b(this.f3957c, 0, this.f3957c.length);
    }

    public boolean mo1132a(int i, C1024j c1024j, int i2, int i3) {
        return c1024j.mo1133a(i2, this.f3957c, i, i3);
    }

    public boolean mo1133a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f3957c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && ae.m7286a(this.f3957c, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z;
        if ((obj instanceof C1024j) && ((C1024j) obj).mo1137e() == this.f3957c.length && ((C1024j) obj).mo1133a(0, this.f3957c, 0, this.f3957c.length)) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.f3958d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f3957c);
        this.f3958d = i;
        return i;
    }

    public int m7393a(C1024j c1024j) {
        int e = mo1137e();
        int e2 = c1024j.mo1137e();
        int min = Math.min(e, e2);
        int i = 0;
        while (i < min) {
            int a = mo1128a(i) & 255;
            int a2 = c1024j.mo1128a(i) & 255;
            if (a == a2) {
                i++;
            } else if (a < a2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (e == e2) {
            return 0;
        }
        if (e >= e2) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        if (this.f3957c.length == 0) {
            return "[size=0]";
        }
        String a = mo1130a();
        int a2 = C1024j.m7388a(a, 64);
        if (a2 != -1) {
            String replace = a.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            return a2 < a.length() ? "[size=" + this.f3957c.length + " text=" + replace + "…]" : "[text=" + replace + "]";
        } else if (this.f3957c.length <= 64) {
            return "[hex=" + mo1135c() + "]";
        } else {
            return "[size=" + this.f3957c.length + " hex=" + mo1129a(0, 64).mo1135c() + "…]";
        }
    }

    static int m7388a(String str, int i) {
        int i2 = 0;
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
