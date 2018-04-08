package org.p070a.p126d;

import java.nio.ByteBuffer;
import org.p070a.p125c.C3128b;
import org.p070a.p125c.C3129c;
import org.p070a.p126d.C3135d.C3140a;
import org.p070a.p128f.C3152b;

public class C3139b extends C3138e implements C3136a {
    static final ByteBuffer f10327a = ByteBuffer.allocate(0);
    private int f10328f;
    private String f10329g;

    public C3139b() {
        super(C3140a.CLOSING);
        mo2541a(true);
    }

    public C3139b(int i) throws C3128b {
        super(C3140a.CLOSING);
        mo2541a(true);
        m17627a(i, "");
    }

    public C3139b(int i, String str) throws C3128b {
        super(C3140a.CLOSING);
        mo2541a(true);
        m17627a(i, str);
    }

    private void m17627a(int i, String str) throws C3128b {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i != 1005) {
            byte[] a = C3152b.m17670a(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(a.length + 2);
            allocate2.put(allocate);
            allocate2.put(a);
            allocate2.rewind();
            mo2539a(allocate2);
        } else if (str2.length() > 0) {
            throw new C3128b(1002, "A close frame must have a closecode if it has a reason");
        }
    }

    private void m17628g() throws C3129c {
        this.f10328f = 1005;
        ByteBuffer c = super.mo2543c();
        c.mark();
        if (c.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(c.getShort());
            allocate.position(0);
            this.f10328f = allocate.getInt();
            if (this.f10328f == 1006 || this.f10328f == 1015 || this.f10328f == 1005 || this.f10328f > 4999 || this.f10328f < 1000 || this.f10328f == 1004) {
                throw new C3129c("closecode must not be sent over the wire: " + this.f10328f);
            }
        }
        c.reset();
    }

    public int mo2547a() {
        return this.f10328f;
    }

    private void m17629h() throws C3128b {
        if (this.f10328f == 1005) {
            this.f10329g = C3152b.m17668a(super.mo2543c());
            return;
        }
        ByteBuffer c = super.mo2543c();
        int position = c.position();
        try {
            c.position(c.position() + 2);
            this.f10329g = C3152b.m17668a(c);
            c.position(position);
        } catch (Throwable e) {
            throw new C3129c(e);
        } catch (Throwable th) {
            c.position(position);
        }
    }

    public String mo2548b() {
        return this.f10329g;
    }

    public String toString() {
        return super.toString() + "code: " + this.f10328f;
    }

    public void mo2539a(ByteBuffer byteBuffer) throws C3128b {
        super.mo2539a(byteBuffer);
        m17628g();
        m17629h();
    }

    public ByteBuffer mo2543c() {
        if (this.f10328f == 1005) {
            return f10327a;
        }
        return super.mo2543c();
    }
}
