package org.p070a.p124b;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
import org.p070a.p127e.C3141f;
import org.p070a.p127e.C3142a;
import org.p070a.p127e.C3143c;
import org.p070a.p127e.C3144b;
import org.p070a.p127e.C3147h;
import org.p070a.p127e.C3148i;
import org.p070a.p128f.C3152b;

public class C3125d extends C3121a {
    protected boolean f10292f = false;
    protected List<C3135d> f10293g = new LinkedList();
    protected ByteBuffer f10294h;
    private final Random f10295i = new Random();

    public C3120b mo2531a(C3142a c3142a, C3147h c3147h) {
        return (c3142a.mo2552b("WebSocket-Origin").equals(c3147h.mo2552b("Origin")) && m17531a((C3141f) c3147h)) ? C3120b.MATCHED : C3120b.NOT_MATCHED;
    }

    public C3120b mo2530a(C3142a c3142a) {
        if (c3142a.mo2554c("Origin") && m17531a((C3141f) c3142a)) {
            return C3120b.MATCHED;
        }
        return C3120b.NOT_MATCHED;
    }

    public ByteBuffer mo2528a(C3135d c3135d) {
        if (c3135d.mo2546f() != C3140a.TEXT) {
            throw new RuntimeException("only text frames supported");
        }
        ByteBuffer c = c3135d.mo2543c();
        ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + 2);
        allocate.put((byte) 0);
        c.mark();
        allocate.put(c);
        c.reset();
        allocate.put((byte) -1);
        allocate.flip();
        return allocate;
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

    public C3144b mo2532a(C3144b c3144b) throws C3130d {
        c3144b.mo2550a("Upgrade", "WebSocket");
        c3144b.mo2550a("Connection", "Upgrade");
        if (!c3144b.mo2554c("Origin")) {
            c3144b.mo2550a("Origin", "random" + this.f10295i.nextInt());
        }
        return c3144b;
    }

    public C3143c mo2533a(C3142a c3142a, C3148i c3148i) throws C3130d {
        c3148i.mo2559a("Web Socket Protocol Handshake");
        c3148i.mo2550a("Upgrade", "WebSocket");
        c3148i.mo2550a("Connection", c3142a.mo2552b("Connection"));
        c3148i.mo2550a("WebSocket-Origin", c3142a.mo2552b("Origin"));
        c3148i.mo2550a("WebSocket-Location", "ws://" + c3142a.mo2552b("Host") + c3142a.mo2556a());
        return c3148i;
    }

    protected List<C3135d> m17567e(ByteBuffer byteBuffer) throws C3128b {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == (byte) 0) {
                if (this.f10292f) {
                    throw new C3129c("unexpected START_OF_FRAME");
                }
                this.f10292f = true;
            } else if (b == (byte) -1) {
                if (this.f10292f) {
                    if (this.f10294h != null) {
                        this.f10294h.flip();
                        C3138e c3138e = new C3138e();
                        c3138e.mo2539a(this.f10294h);
                        c3138e.mo2541a(true);
                        c3138e.mo2540a(C3140a.TEXT);
                        this.f10293g.add(c3138e);
                        this.f10294h = null;
                        byteBuffer.mark();
                    }
                    this.f10292f = false;
                } else {
                    throw new C3129c("unexpected END_OF_FRAME");
                }
            } else if (!this.f10292f) {
                return null;
            } else {
                if (this.f10294h == null) {
                    this.f10294h = m17566d();
                } else if (!this.f10294h.hasRemaining()) {
                    this.f10294h = m17568f(this.f10294h);
                }
                this.f10294h.put(b);
            }
        }
        List<C3135d> list = this.f10293g;
        this.f10293g = new LinkedList();
        return list;
    }

    public List<C3135d> mo2536c(ByteBuffer byteBuffer) throws C3128b {
        List<C3135d> e = m17567e(byteBuffer);
        if (e != null) {
            return e;
        }
        throw new C3128b(1002);
    }

    public void mo2534a() {
        this.f10292f = false;
        this.f10294h = null;
    }

    public C3119a mo2535b() {
        return C3119a.NONE;
    }

    public ByteBuffer m17566d() {
        return ByteBuffer.allocate(b);
    }

    public ByteBuffer m17568f(ByteBuffer byteBuffer) throws C3131e, C3128b {
        byteBuffer.flip();
        ByteBuffer allocate = ByteBuffer.allocate(m17520a(byteBuffer.capacity() * 2));
        allocate.put(byteBuffer);
        return allocate;
    }

    public C3121a mo2537c() {
        return new C3125d();
    }
}
