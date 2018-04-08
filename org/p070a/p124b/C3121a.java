package org.p070a.p124b;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.p070a.C1375a.C3116b;
import org.p070a.p125c.C3127a;
import org.p070a.p125c.C3128b;
import org.p070a.p125c.C3130d;
import org.p070a.p125c.C3131e;
import org.p070a.p126d.C3135d;
import org.p070a.p126d.C3135d.C3140a;
import org.p070a.p127e.C3141f;
import org.p070a.p127e.C3142a;
import org.p070a.p127e.C3143c;
import org.p070a.p127e.C3144b;
import org.p070a.p127e.C3146d;
import org.p070a.p127e.C3147h;
import org.p070a.p127e.C3148i;
import org.p070a.p127e.C3149e;
import org.p070a.p128f.C3152b;

public abstract class C3121a {
    public static int f10281a = 1000;
    public static int f10282b = 64;
    public static final byte[] f10283c = C3152b.m17670a("<policy-file-request/>\u0000");
    protected C3116b f10284d = null;
    protected C3140a f10285e = null;

    public enum C3119a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    public enum C3120b {
        MATCHED,
        NOT_MATCHED
    }

    public abstract ByteBuffer mo2528a(C3135d c3135d);

    public abstract List<C3135d> mo2529a(String str, boolean z);

    public abstract C3120b mo2530a(C3142a c3142a) throws C3130d;

    public abstract C3120b mo2531a(C3142a c3142a, C3147h c3147h) throws C3130d;

    public abstract C3144b mo2532a(C3144b c3144b) throws C3130d;

    public abstract C3143c mo2533a(C3142a c3142a, C3148i c3148i) throws C3130d;

    public abstract void mo2534a();

    public abstract C3119a mo2535b();

    public abstract List<C3135d> mo2536c(ByteBuffer byteBuffer) throws C3128b;

    public abstract C3121a mo2537c();

    public static ByteBuffer m17517a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String m17519b(ByteBuffer byteBuffer) {
        ByteBuffer a = C3121a.m17517a(byteBuffer);
        return a == null ? null : C3152b.m17669a(a.array(), 0, a.limit());
    }

    public static C3143c m17518a(ByteBuffer byteBuffer, C3116b c3116b) throws C3130d, C3127a {
        String b = C3121a.m17519b(byteBuffer);
        if (b == null) {
            throw new C3127a(byteBuffer.capacity() + 128);
        }
        String[] split = b.split(" ", 3);
        if (split.length != 3) {
            throw new C3130d();
        }
        C3143c c3149e;
        if (c3116b == C3116b.CLIENT) {
            c3149e = new C3149e();
            C3148i c3148i = (C3148i) c3149e;
            c3148i.mo2560a(Short.parseShort(split[1]));
            c3148i.mo2559a(split[2]);
        } else {
            c3149e = new C3146d();
            c3149e.mo2557a(split[1]);
        }
        b = C3121a.m17519b(byteBuffer);
        while (b != null && b.length() > 0) {
            String[] split2 = b.split(":", 2);
            if (split2.length != 2) {
                throw new C3130d("not an http header");
            }
            c3149e.mo2550a(split2[0], split2[1].replaceFirst("^ +", ""));
            b = C3121a.m17519b(byteBuffer);
        }
        if (b != null) {
            return c3149e;
        }
        throw new C3127a();
    }

    protected boolean m17531a(C3141f c3141f) {
        return c3141f.mo2552b("Upgrade").equalsIgnoreCase("websocket") && c3141f.mo2552b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<ByteBuffer> m17523a(C3141f c3141f, C3116b c3116b) {
        return m17524a(c3141f, c3116b, true);
    }

    public List<ByteBuffer> m17524a(C3141f c3141f, C3116b c3116b, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (c3141f instanceof C3142a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((C3142a) c3141f).mo2556a());
            stringBuilder.append(" HTTP/1.1");
        } else if (c3141f instanceof C3147h) {
            stringBuilder.append("HTTP/1.1 101 " + ((C3147h) c3141f).mo2558a());
        } else {
            throw new RuntimeException("unknow role");
        }
        stringBuilder.append("\r\n");
        Iterator b = c3141f.mo2553b();
        while (b.hasNext()) {
            String str = (String) b.next();
            String b2 = c3141f.mo2552b(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(b2);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        byte[] b3 = C3152b.m17671b(stringBuilder.toString());
        byte[] c = z ? c3141f.mo2555c() : null;
        ByteBuffer allocate = ByteBuffer.allocate((c == null ? 0 : c.length) + b3.length);
        allocate.put(b3);
        if (c != null) {
            allocate.put(c);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public C3141f mo2538d(ByteBuffer byteBuffer) throws C3130d {
        return C3121a.m17518a(byteBuffer, this.f10284d);
    }

    public int m17520a(int i) throws C3131e, C3128b {
        if (i >= 0) {
            return i;
        }
        throw new C3128b(1002, "Negative count");
    }

    public void m17530a(C3116b c3116b) {
        this.f10284d = c3116b;
    }
}
