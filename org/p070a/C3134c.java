package org.p070a;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.p070a.C1375a.C3115a;
import org.p070a.C1375a.C3116b;
import org.p070a.p124b.C3121a;
import org.p070a.p124b.C3121a.C3119a;
import org.p070a.p124b.C3121a.C3120b;
import org.p070a.p124b.C3123b;
import org.p070a.p124b.C3124c;
import org.p070a.p124b.C3125d;
import org.p070a.p124b.C3126e;
import org.p070a.p125c.C3127a;
import org.p070a.p125c.C3128b;
import org.p070a.p125c.C3130d;
import org.p070a.p125c.C3133g;
import org.p070a.p126d.C3135d;
import org.p070a.p126d.C3135d.C3140a;
import org.p070a.p126d.C3136a;
import org.p070a.p126d.C3139b;
import org.p070a.p127e.C3141f;
import org.p070a.p127e.C3142a;
import org.p070a.p127e.C3144b;
import org.p070a.p127e.C3147h;
import org.p070a.p128f.C3152b;

public class C3134c implements C1375a {
    public static int f10301a = DfuBaseService.ERROR_CONNECTION_MASK;
    public static boolean f10302b = false;
    public static final List<C3121a> f10303c = new ArrayList(4);
    static final /* synthetic */ boolean f10304h = (!C3134c.class.desiredAssertionStatus());
    public SelectionKey f10305d;
    public ByteChannel f10306e;
    public final BlockingQueue<ByteBuffer> f10307f;
    public final BlockingQueue<ByteBuffer> f10308g;
    private volatile boolean f10309i = false;
    private C3115a f10310j = C3115a.NOT_YET_CONNECTED;
    private final C1373d f10311k;
    private List<C3121a> f10312l;
    private C3121a f10313m = null;
    private C3116b f10314n;
    private C3140a f10315o = null;
    private ByteBuffer f10316p = ByteBuffer.allocate(0);
    private C3142a f10317q = null;
    private String f10318r = null;
    private Integer f10319s = null;
    private Boolean f10320t = null;
    private String f10321u = null;

    static {
        f10303c.add(new C3124c());
        f10303c.add(new C3123b());
        f10303c.add(new C3126e());
        f10303c.add(new C3125d());
    }

    public C3134c(C1373d c1373d, C3121a c3121a) {
        if (c1373d == null || (c3121a == null && this.f10314n == C3116b.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f10307f = new LinkedBlockingQueue();
        this.f10308g = new LinkedBlockingQueue();
        this.f10311k = c1373d;
        this.f10314n = C3116b.CLIENT;
        if (c3121a != null) {
            this.f10313m = c3121a.mo2537c();
        }
    }

    public void m17597a(ByteBuffer byteBuffer) {
        if (f10304h || byteBuffer.hasRemaining()) {
            if (f10302b) {
                System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + "}");
            }
            if (this.f10310j != C3115a.NOT_YET_CONNECTED) {
                m17588c(byteBuffer);
            } else if (m17586b(byteBuffer)) {
                if (!f10304h && this.f10316p.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                    throw new AssertionError();
                } else if (byteBuffer.hasRemaining()) {
                    m17588c(byteBuffer);
                } else if (this.f10316p.hasRemaining()) {
                    m17588c(this.f10316p);
                }
            }
            if (!f10304h && !m17605d() && !m17606e() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            return;
        }
        throw new AssertionError();
    }

    private boolean m17586b(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.f10316p.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.f10316p.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.f10316p.capacity() + byteBuffer.remaining());
                this.f10316p.flip();
                allocate.put(this.f10316p);
                this.f10316p = allocate;
            }
            this.f10316p.put(byteBuffer);
            this.f10316p.flip();
            byteBuffer2 = this.f10316p;
        }
        byteBuffer2.mark();
        try {
            if (this.f10313m == null && m17589d(byteBuffer2) == C3120b.MATCHED) {
                try {
                    m17590e(ByteBuffer.wrap(C3152b.m17670a(this.f10311k.mo1289a(this))));
                    m17593a(-3, "");
                } catch (C3128b e) {
                    m17587c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                }
                return false;
            }
            try {
                C3141f d;
                if (this.f10314n != C3116b.SERVER) {
                    if (this.f10314n == C3116b.CLIENT) {
                        this.f10313m.m17530a(this.f10314n);
                        d = this.f10313m.mo2538d(byteBuffer2);
                        if (d instanceof C3147h) {
                            d = (C3147h) d;
                            if (this.f10313m.mo2531a(this.f10317q, (C3147h) d) == C3120b.MATCHED) {
                                try {
                                    this.f10311k.mo1293a((C1375a) this, this.f10317q, (C3147h) d);
                                    m17585a(d);
                                    return true;
                                } catch (C3128b e2) {
                                    m17603b(e2.m17582a(), e2.getMessage(), false);
                                    return false;
                                } catch (Exception e3) {
                                    this.f10311k.mo1299a((C1375a) this, e3);
                                    m17603b(-1, e3.getMessage(), false);
                                    return false;
                                }
                            }
                            m17593a(1002, "draft " + this.f10313m + " refuses handshake");
                        } else {
                            m17603b(1002, "wrong http function", false);
                            return false;
                        }
                    }
                    return false;
                } else if (this.f10313m == null) {
                    for (C3121a c : this.f10312l) {
                        C3121a c2 = c.mo2537c();
                        try {
                            c2.m17530a(this.f10314n);
                            byteBuffer2.reset();
                            d = c2.mo2538d(byteBuffer2);
                            if (d instanceof C3142a) {
                                d = (C3142a) d;
                                if (c2.mo2530a((C3142a) d) == C3120b.MATCHED) {
                                    this.f10321u = d.mo2556a();
                                    try {
                                        m17584a(c2.m17523a(c2.mo2533a((C3142a) d, this.f10311k.mo1290a((C1375a) this, c2, (C3142a) d)), this.f10314n));
                                        this.f10313m = c2;
                                        m17585a(d);
                                        return true;
                                    } catch (C3128b e22) {
                                        m17603b(e22.m17582a(), e22.getMessage(), false);
                                        return false;
                                    } catch (Exception e32) {
                                        this.f10311k.mo1299a((C1375a) this, e32);
                                        m17603b(-1, e32.getMessage(), false);
                                        return false;
                                    }
                                }
                                continue;
                            } else {
                                m17603b(1002, "wrong http function", false);
                                return false;
                            }
                        } catch (C3130d e4) {
                        }
                    }
                    if (this.f10313m == null) {
                        m17593a(1002, "no draft matches");
                    }
                    return false;
                } else {
                    d = this.f10313m.mo2538d(byteBuffer2);
                    if (d instanceof C3142a) {
                        d = (C3142a) d;
                        if (this.f10313m.mo2530a((C3142a) d) == C3120b.MATCHED) {
                            m17585a(d);
                            return true;
                        }
                        m17593a(1002, "the handshake did finaly not match");
                        return false;
                    }
                    m17603b(1002, "wrong http function", false);
                    return false;
                }
            } catch (C3128b e222) {
                m17598a(e222);
            }
        } catch (C3127a e5) {
            C3127a c3127a = e5;
            if (this.f10316p.capacity() == 0) {
                byteBuffer2.reset();
                int a = c3127a.m17581a();
                if (a == 0) {
                    a = byteBuffer2.capacity() + 16;
                } else if (!f10304h && c3127a.m17581a() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.f10316p = ByteBuffer.allocate(a);
                this.f10316p.put(byteBuffer);
            } else {
                this.f10316p.position(this.f10316p.limit());
                this.f10316p.limit(this.f10316p.capacity());
            }
        }
    }

    private void m17588c(ByteBuffer byteBuffer) {
        try {
            for (C3135d c3135d : this.f10313m.mo2536c(byteBuffer)) {
                if (f10302b) {
                    System.out.println("matched frame: " + c3135d);
                }
                C3140a f = c3135d.mo2546f();
                boolean d = c3135d.mo2544d();
                if (f == C3140a.CLOSING) {
                    int a;
                    String b;
                    String str = "";
                    if (c3135d instanceof C3136a) {
                        C3136a c3136a = (C3136a) c3135d;
                        a = c3136a.mo2547a();
                        b = c3136a.mo2548b();
                    } else {
                        b = str;
                        a = 1005;
                    }
                    if (this.f10310j == C3115a.CLOSING) {
                        m17594a(a, b, true);
                    } else if (this.f10313m.mo2535b() == C3119a.TWOWAY) {
                        m17587c(a, b, true);
                    } else {
                        m17603b(a, b, false);
                    }
                } else if (f == C3140a.PING) {
                    this.f10311k.mo1294b(this, c3135d);
                } else if (f == C3140a.PONG) {
                    this.f10311k.mo1295c(this, c3135d);
                } else if (!d || f == C3140a.CONTINUOUS) {
                    if (f != C3140a.CONTINUOUS) {
                        if (this.f10315o != null) {
                            throw new C3128b(1002, "Previous continuous frame sequence not completed.");
                        }
                        this.f10315o = f;
                    } else if (d) {
                        if (this.f10315o == null) {
                            throw new C3128b(1002, "Continuous frame sequence was not started.");
                        }
                        this.f10315o = null;
                    } else if (this.f10315o == null) {
                        throw new C3128b(1002, "Continuous frame sequence was not started.");
                    }
                    try {
                        this.f10311k.mo1291a((C1375a) this, c3135d);
                    } catch (Exception e) {
                        this.f10311k.mo1299a((C1375a) this, e);
                    }
                } else if (this.f10315o != null) {
                    throw new C3128b(1002, "Continuous frame sequence not completed.");
                } else if (f == C3140a.TEXT) {
                    try {
                        this.f10311k.mo1300a((C1375a) this, C3152b.m17668a(c3135d.mo2543c()));
                    } catch (Exception e2) {
                        this.f10311k.mo1299a((C1375a) this, e2);
                    }
                } else if (f == C3140a.BINARY) {
                    try {
                        this.f10311k.mo1301a((C1375a) this, c3135d.mo2543c());
                    } catch (Exception e22) {
                        this.f10311k.mo1299a((C1375a) this, e22);
                    }
                } else {
                    throw new C3128b(1002, "non control or continious frame expected");
                }
            }
        } catch (C3128b e3) {
            this.f10311k.mo1299a((C1375a) this, (Exception) e3);
            m17598a(e3);
        }
    }

    private void m17587c(int i, String str, boolean z) {
        if (this.f10310j != C3115a.CLOSING && this.f10310j != C3115a.CLOSED) {
            if (this.f10310j == C3115a.OPEN) {
                if (i != 1006) {
                    if (this.f10313m.mo2535b() != C3119a.NONE) {
                        if (!z) {
                            try {
                                this.f10311k.mo1297a((C1375a) this, i, str);
                            } catch (Exception e) {
                                this.f10311k.mo1299a((C1375a) this, e);
                            }
                        }
                        try {
                            mo1303a(new C3139b(i, str));
                        } catch (Exception e2) {
                            this.f10311k.mo1299a((C1375a) this, e2);
                            m17603b(1006, "generated frame is invalid", false);
                        }
                    }
                    m17603b(i, str, z);
                } else if (f10304h || !z) {
                    this.f10310j = C3115a.CLOSING;
                    m17603b(i, str, false);
                    return;
                } else {
                    throw new AssertionError();
                }
            } else if (i != -3) {
                m17603b(-1, str, false);
            } else if (f10304h || z) {
                m17603b(-3, str, true);
            } else {
                throw new AssertionError();
            }
            if (i == 1002) {
                m17603b(i, str, z);
            }
            this.f10310j = C3115a.CLOSING;
            this.f10316p = null;
        }
    }

    public void m17593a(int i, String str) {
        m17587c(i, str, false);
    }

    protected synchronized void m17594a(int i, String str, boolean z) {
        if (this.f10310j != C3115a.CLOSED) {
            if (this.f10305d != null) {
                this.f10305d.cancel();
            }
            if (this.f10306e != null) {
                try {
                    this.f10306e.close();
                } catch (Exception e) {
                    this.f10311k.mo1299a((C1375a) this, e);
                }
            }
            try {
                this.f10311k.mo1298a(this, i, str, z);
            } catch (Exception e2) {
                this.f10311k.mo1299a((C1375a) this, e2);
            }
            if (this.f10313m != null) {
                this.f10313m.mo2534a();
            }
            this.f10317q = null;
            this.f10310j = C3115a.CLOSED;
            this.f10307f.clear();
        }
    }

    protected void m17595a(int i, boolean z) {
        m17594a(i, "", z);
    }

    public void m17602b(int i, String str) {
        m17594a(i, str, false);
    }

    protected synchronized void m17603b(int i, String str, boolean z) {
        if (!this.f10309i) {
            this.f10319s = Integer.valueOf(i);
            this.f10318r = str;
            this.f10320t = Boolean.valueOf(z);
            this.f10309i = true;
            this.f10311k.mo1304b(this);
            try {
                this.f10311k.mo1305b(this, i, str, z);
            } catch (Exception e) {
                this.f10311k.mo1299a((C1375a) this, e);
            }
            if (this.f10313m != null) {
                this.f10313m.mo2534a();
            }
            this.f10317q = null;
        }
    }

    public void m17601b() {
        if (m17608g() == C3115a.NOT_YET_CONNECTED) {
            m17595a(-1, true);
        } else if (this.f10309i) {
            m17594a(this.f10319s.intValue(), this.f10318r, this.f10320t.booleanValue());
        } else if (this.f10313m.mo2535b() == C3119a.NONE) {
            m17595a(1000, true);
        } else if (this.f10313m.mo2535b() != C3119a.ONEWAY) {
            m17595a(1006, true);
        } else if (this.f10314n == C3116b.SERVER) {
            m17595a(1006, true);
        } else {
            m17595a(1000, true);
        }
    }

    public void m17592a(int i) {
        m17587c(i, "", false);
    }

    public void m17598a(C3128b c3128b) {
        m17587c(c3128b.m17582a(), c3128b.getMessage(), false);
    }

    public void m17596a(String str) throws C3133g {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        m17583a(this.f10313m.mo2529a(str, this.f10314n == C3116b.CLIENT));
    }

    private void m17583a(Collection<C3135d> collection) {
        if (m17604c()) {
            for (C3135d a : collection) {
                mo1303a(a);
            }
            return;
        }
        throw new C3133g();
    }

    public void mo1303a(C3135d c3135d) {
        if (f10302b) {
            System.out.println("send frame: " + c3135d);
        }
        m17590e(this.f10313m.mo2528a(c3135d));
    }

    private C3120b m17589d(ByteBuffer byteBuffer) throws C3127a {
        byteBuffer.mark();
        if (byteBuffer.limit() > C3121a.f10283c.length) {
            return C3120b.NOT_MATCHED;
        }
        if (byteBuffer.limit() < C3121a.f10283c.length) {
            throw new C3127a(C3121a.f10283c.length);
        }
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            if (C3121a.f10283c[i] != byteBuffer.get()) {
                byteBuffer.reset();
                return C3120b.NOT_MATCHED;
            }
            i++;
        }
        return C3120b.MATCHED;
    }

    public void m17600a(C3144b c3144b) throws C3130d {
        if (f10304h || this.f10310j != C3115a.CONNECTING) {
            this.f10317q = this.f10313m.mo2532a(c3144b);
            this.f10321u = c3144b.mo2556a();
            if (f10304h || this.f10321u != null) {
                try {
                    this.f10311k.mo1292a((C1375a) this, this.f10317q);
                    m17584a(this.f10313m.m17523a(this.f10317q, this.f10314n));
                    return;
                } catch (C3128b e) {
                    throw new C3130d("Handshake data rejected by client.");
                } catch (Exception e2) {
                    this.f10311k.mo1299a((C1375a) this, e2);
                    throw new C3130d("rejected because of" + e2);
                }
            }
            throw new AssertionError();
        }
        throw new AssertionError("shall only be called once");
    }

    private void m17590e(ByteBuffer byteBuffer) {
        if (f10302b) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + "}");
        }
        this.f10307f.add(byteBuffer);
        this.f10311k.mo1304b(this);
    }

    private void m17584a(List<ByteBuffer> list) {
        for (ByteBuffer e : list) {
            m17590e(e);
        }
    }

    private void m17585a(C3141f c3141f) {
        if (f10302b) {
            System.out.println("open using draft: " + this.f10313m.getClass().getSimpleName());
        }
        this.f10310j = C3115a.OPEN;
        try {
            this.f10311k.mo1302a((C1375a) this, c3141f);
        } catch (Exception e) {
            this.f10311k.mo1299a((C1375a) this, e);
        }
    }

    public boolean m17604c() {
        if (f10304h || this.f10310j != C3115a.OPEN || !this.f10309i) {
            return this.f10310j == C3115a.OPEN;
        } else {
            throw new AssertionError();
        }
    }

    public boolean m17605d() {
        return this.f10310j == C3115a.CLOSING;
    }

    public boolean m17606e() {
        return this.f10309i;
    }

    public boolean m17607f() {
        return this.f10310j == C3115a.CLOSED;
    }

    public C3115a m17608g() {
        return this.f10310j;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress mo1296a() {
        return this.f10311k.mo1306c(this);
    }
}
