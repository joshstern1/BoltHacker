package org.p070a.p124b;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.p070a.C1375a.C3116b;
import org.p070a.p124b.C3121a.C3119a;
import org.p070a.p124b.C3121a.C3120b;
import org.p070a.p125c.C3128b;
import org.p070a.p125c.C3129c;
import org.p070a.p125c.C3130d;
import org.p070a.p125c.C3131e;
import org.p070a.p125c.C3132f;
import org.p070a.p126d.C3135d;
import org.p070a.p126d.C3135d.C3140a;
import org.p070a.p126d.C3137c;
import org.p070a.p126d.C3138e;
import org.p070a.p126d.C3139b;
import org.p070a.p127e.C3141f;
import org.p070a.p127e.C3142a;
import org.p070a.p127e.C3143c;
import org.p070a.p127e.C3144b;
import org.p070a.p127e.C3147h;
import org.p070a.p127e.C3148i;
import org.p070a.p128f.C3151a;
import org.p070a.p128f.C3152b;

public class C3123b extends C3121a {
    static final /* synthetic */ boolean f10288f = (!C3123b.class.desiredAssertionStatus());
    private ByteBuffer f10289g;
    private C3135d f10290h = null;
    private final Random f10291i = new Random();

    private class C3122a extends Throwable {
        final /* synthetic */ C3123b f10286a;
        private int f10287b;

        public C3122a(C3123b c3123b, int i) {
            this.f10286a = c3123b;
            this.f10287b = i;
        }

        public int m17536a() {
            return this.f10287b;
        }
    }

    public static int m17541b(C3141f c3141f) {
        int i = -1;
        String b = c3141f.mo2552b("Sec-WebSocket-Version");
        if (b.length() > 0) {
            try {
                i = new Integer(b.trim()).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public C3120b mo2531a(C3142a c3142a, C3147h c3147h) throws C3130d {
        if (!c3142a.mo2554c("Sec-WebSocket-Key") || !c3147h.mo2554c("Sec-WebSocket-Accept")) {
            return C3120b.NOT_MATCHED;
        }
        if (m17538a(c3142a.mo2552b("Sec-WebSocket-Key")).equals(c3147h.mo2552b("Sec-WebSocket-Accept"))) {
            return C3120b.MATCHED;
        }
        return C3120b.NOT_MATCHED;
    }

    public C3120b mo2530a(C3142a c3142a) throws C3130d {
        int b = C3123b.m17541b(c3142a);
        if (b == 7 || b == 8) {
            return m17531a((C3141f) c3142a) ? C3120b.MATCHED : C3120b.NOT_MATCHED;
        } else {
            return C3120b.NOT_MATCHED;
        }
    }

    public ByteBuffer mo2528a(C3135d c3135d) {
        int i;
        int i2 = -128;
        int i3 = 0;
        ByteBuffer c = c3135d.mo2543c();
        int i4 = this.d == C3116b.CLIENT ? 1 : 0;
        int i5 = c.remaining() <= 125 ? 1 : c.remaining() <= 65535 ? 2 : 8;
        if (i5 > 1) {
            i = i5 + 1;
        } else {
            i = i5;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((i4 != 0 ? 4 : 0) + (i + 1)) + c.remaining());
        byte a = m17537a(c3135d.mo2546f());
        if (c3135d.mo2544d()) {
            i = -128;
        } else {
            i = 0;
        }
        allocate.put((byte) (((byte) i) | a));
        byte[] a2 = m17540a((long) c.remaining(), i5);
        if (f10288f || a2.length == i5) {
            if (i5 == 1) {
                byte b = a2[0];
                if (i4 == 0) {
                    i2 = 0;
                }
                allocate.put((byte) (b | i2));
            } else if (i5 == 2) {
                if (i4 == 0) {
                    i2 = 0;
                }
                allocate.put((byte) (i2 | 126));
                allocate.put(a2);
            } else if (i5 == 8) {
                if (i4 == 0) {
                    i2 = 0;
                }
                allocate.put((byte) (i2 | 127));
                allocate.put(a2);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (i4 != 0) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.f10291i.nextInt());
                allocate.put(allocate2.array());
                while (c.hasRemaining()) {
                    allocate.put((byte) (c.get() ^ allocate2.get(i3 % 4)));
                    i3++;
                }
            } else {
                allocate.put(c);
            }
            if (f10288f || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public List<C3135d> mo2529a(String str, boolean z) {
        C3137c c3138e = new C3138e();
        try {
            c3138e.mo2539a(ByteBuffer.wrap(C3152b.m17670a(str)));
            c3138e.mo2541a(true);
            c3138e.mo2540a(C3140a.TEXT);
            c3138e.mo2542b(z);
            return Collections.singletonList(c3138e);
        } catch (Throwable e) {
            throw new C3132f(e);
        }
    }

    private byte m17537a(C3140a c3140a) {
        if (c3140a == C3140a.CONTINUOUS) {
            return (byte) 0;
        }
        if (c3140a == C3140a.TEXT) {
            return (byte) 1;
        }
        if (c3140a == C3140a.BINARY) {
            return (byte) 2;
        }
        if (c3140a == C3140a.CLOSING) {
            return (byte) 8;
        }
        if (c3140a == C3140a.PING) {
            return (byte) 9;
        }
        if (c3140a == C3140a.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + c3140a.toString());
    }

    private String m17538a(String str) {
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return C3151a.m17658a(MessageDigest.getInstance("SHA1").digest(str2.getBytes()));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public C3144b mo2532a(C3144b c3144b) {
        c3144b.mo2550a("Upgrade", "websocket");
        c3144b.mo2550a("Connection", "Upgrade");
        c3144b.mo2550a("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.f10291i.nextBytes(bArr);
        c3144b.mo2550a("Sec-WebSocket-Key", C3151a.m17658a(bArr));
        return c3144b;
    }

    public C3143c mo2533a(C3142a c3142a, C3148i c3148i) throws C3130d {
        c3148i.mo2550a("Upgrade", "websocket");
        c3148i.mo2550a("Connection", c3142a.mo2552b("Connection"));
        c3148i.mo2559a("Switching Protocols");
        String b = c3142a.mo2552b("Sec-WebSocket-Key");
        if (b == null) {
            throw new C3130d("missing Sec-WebSocket-Key");
        }
        c3148i.mo2550a("Sec-WebSocket-Accept", m17538a(b));
        return c3148i;
    }

    private byte[] m17540a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    private C3140a m17539a(byte b) throws C3129c {
        switch (b) {
            case (byte) 0:
                return C3140a.CONTINUOUS;
            case (byte) 1:
                return C3140a.TEXT;
            case (byte) 2:
                return C3140a.BINARY;
            case (byte) 8:
                return C3140a.CLOSING;
            case (byte) 9:
                return C3140a.PING;
            case (byte) 10:
                return C3140a.PONG;
            default:
                throw new C3129c("unknow optcode " + ((short) b));
        }
    }

    public List<C3135d> mo2536c(ByteBuffer byteBuffer) throws C3131e, C3128b {
        List<C3135d> linkedList = new LinkedList();
        if (this.f10289g != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f10289g.remaining();
                if (remaining2 > remaining) {
                    this.f10289g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.f10289g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(m17552e((ByteBuffer) this.f10289g.duplicate().position(0)));
                this.f10289g = null;
            } catch (C3122a e) {
                this.f10289g.limit();
                r0 = ByteBuffer.allocate(m17520a(e.m17536a()));
                if (f10288f || r0.limit() > this.f10289g.limit()) {
                    ByteBuffer allocate;
                    this.f10289g.rewind();
                    allocate.put(this.f10289g);
                    this.f10289g = allocate;
                    return mo2536c(byteBuffer);
                }
                throw new AssertionError();
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(m17552e(byteBuffer));
            } catch (C3122a e2) {
                byteBuffer.reset();
                this.f10289g = ByteBuffer.allocate(m17520a(e2.m17536a()));
                this.f10289g.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public C3135d m17552e(ByteBuffer byteBuffer) throws C3122a, C3128b {
        int i = 2;
        int i2 = 0;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new C3122a(this, 2);
        }
        boolean z;
        byte b = byteBuffer.get();
        if ((b >> 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != (byte) 0) {
            throw new C3129c("bad rsv " + b2);
        }
        byte b3 = byteBuffer.get();
        int i3 = (b3 & -128) != 0 ? 1 : 0;
        int i4 = (byte) (b3 & 127);
        C3140a a = m17539a((byte) (b & 15));
        if (z || !(a == C3140a.PING || a == C3140a.PONG || a == C3140a.CLOSING)) {
            int i5;
            if (i4 < 0 || i4 > 125) {
                if (a == C3140a.PING || a == C3140a.PONG || a == C3140a.CLOSING) {
                    throw new C3129c("more than 125 octets");
                } else if (i4 == 126) {
                    if (remaining < 4) {
                        throw new C3122a(this, 4);
                    }
                    byte[] bArr = new byte[3];
                    bArr[1] = byteBuffer.get();
                    bArr[2] = byteBuffer.get();
                    i4 = new BigInteger(bArr).intValue();
                    i = 4;
                } else if (remaining < 10) {
                    throw new C3122a(this, 10);
                } else {
                    byte[] bArr2 = new byte[8];
                    for (i5 = 0; i5 < 8; i5++) {
                        bArr2[i5] = byteBuffer.get();
                    }
                    long longValue = new BigInteger(bArr2).longValue();
                    if (longValue > 2147483647L) {
                        throw new C3131e("Payloadsize is to big...");
                    }
                    i = 10;
                    i4 = (int) longValue;
                }
            }
            if (i3 != 0) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            i5 = (i5 + i) + i4;
            if (remaining < i5) {
                throw new C3122a(this, i5);
            }
            C3135d c3139b;
            ByteBuffer allocate = ByteBuffer.allocate(m17520a(i4));
            if (i3 != 0) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                while (i2 < i4) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                    i2++;
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (a == C3140a.CLOSING) {
                c3139b = new C3139b();
            } else {
                c3139b = new C3138e();
                c3139b.mo2541a(z);
                c3139b.mo2540a(a);
            }
            allocate.flip();
            c3139b.mo2539a(allocate);
            return c3139b;
        }
        throw new C3129c("control frames may no be fragmented");
    }

    public void mo2534a() {
        this.f10289g = null;
    }

    public C3121a mo2537c() {
        return new C3123b();
    }

    public C3119a mo2535b() {
        return C3119a.TWOWAY;
    }
}
