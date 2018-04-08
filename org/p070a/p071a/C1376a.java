package org.p070a.p071a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import org.p070a.C1374b;
import org.p070a.C1375a;
import org.p070a.C3134c;
import org.p070a.p124b.C3121a;
import org.p070a.p124b.C3124c;
import org.p070a.p125c.C3130d;
import org.p070a.p126d.C3135d;
import org.p070a.p127e.C3141f;
import org.p070a.p127e.C3144b;
import org.p070a.p127e.C3146d;
import org.p070a.p127e.C3147h;

public abstract class C1376a extends C1374b implements Runnable, C1375a {
    static final /* synthetic */ boolean f5204b = (!C1376a.class.desiredAssertionStatus());
    protected URI f5205a;
    private C3134c f5206c;
    private Socket f5207d;
    private InputStream f5208e;
    private OutputStream f5209f;
    private Proxy f5210g;
    private Thread f5211h;
    private C3121a f5212i;
    private Map<String, String> f5213j;
    private CountDownLatch f5214k;
    private CountDownLatch f5215l;
    private int f5216m;

    private class C3118a implements Runnable {
        final /* synthetic */ C1376a f10273a;

        private C3118a(C1376a c1376a) {
            this.f10273a = c1376a;
        }

        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) this.f10273a.f5206c.f10307f.take();
                    this.f10273a.f5209f.write(byteBuffer.array(), 0, byteBuffer.limit());
                    this.f10273a.f5209f.flush();
                } catch (IOException e) {
                    this.f10273a.f5206c.m17601b();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    public abstract void mo1307a(int i, String str, boolean z);

    public abstract void mo1308a(Exception exception);

    public abstract void mo1309a(String str);

    public abstract void mo1310a(C3147h c3147h);

    public C1376a(URI uri) {
        this(uri, new C3124c());
    }

    public C1376a(URI uri, C3121a c3121a) {
        this(uri, c3121a, null, 0);
    }

    public C1376a(URI uri, C3121a c3121a, Map<String, String> map, int i) {
        this.f5205a = null;
        this.f5206c = null;
        this.f5207d = null;
        this.f5210g = Proxy.NO_PROXY;
        this.f5214k = new CountDownLatch(1);
        this.f5215l = new CountDownLatch(1);
        this.f5216m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (c3121a == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.f5205a = uri;
            this.f5212i = c3121a;
            this.f5213j = map;
            this.f5216m = i;
            this.f5206c = new C3134c(this, c3121a);
        }
    }

    public void m8886b() {
        if (this.f5211h != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.f5211h = new Thread(this);
        this.f5211h.start();
    }

    public void m8893c() {
        if (this.f5211h != null) {
            this.f5206c.m17592a(1000);
        }
    }

    public void m8888b(String str) throws NotYetConnectedException {
        this.f5206c.m17596a(str);
    }

    public void run() {
        try {
            if (this.f5207d == null) {
                this.f5207d = new Socket(this.f5210g);
            } else if (this.f5207d.isClosed()) {
                throw new IOException();
            }
            if (!this.f5207d.isBound()) {
                this.f5207d.connect(new InetSocketAddress(this.f5205a.getHost(), m8867e()), this.f5216m);
            }
            this.f5208e = this.f5207d.getInputStream();
            this.f5209f = this.f5207d.getOutputStream();
            m8868f();
            this.f5211h = new Thread(new C3118a());
            this.f5211h.start();
            byte[] bArr = new byte[C3134c.f10301a];
            while (!m8894d()) {
                try {
                    int read = this.f5208e.read(bArr);
                    if (read != -1) {
                        this.f5206c.m17597a(ByteBuffer.wrap(bArr, 0, read));
                    }
                } catch (IOException e) {
                    this.f5206c.m17601b();
                } catch (Exception e2) {
                    mo1308a(e2);
                    this.f5206c.m17602b(1006, e2.getMessage());
                }
            }
            this.f5206c.m17601b();
            if (!f5204b && !this.f5207d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e22) {
            mo1299a(this.f5206c, e22);
            this.f5206c.m17602b(-1, e22.getMessage());
        }
    }

    private int m8867e() {
        int port = this.f5205a.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.f5205a.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void m8868f() throws C3130d {
        String path = this.f5205a.getPath();
        String query = this.f5205a.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int e = m8867e();
        query = this.f5205a.getHost() + (e != 80 ? ":" + e : "");
        C3144b c3146d = new C3146d();
        c3146d.mo2557a(path);
        c3146d.mo2550a("Host", query);
        if (this.f5213j != null) {
            for (Entry entry : this.f5213j.entrySet()) {
                c3146d.mo2550a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.f5206c.m17600a(c3146d);
    }

    public final void mo1300a(C1375a c1375a, String str) {
        mo1309a(str);
    }

    public final void mo1301a(C1375a c1375a, ByteBuffer byteBuffer) {
        m8876a(byteBuffer);
    }

    public void mo1291a(C1375a c1375a, C3135d c3135d) {
        m8891b(c3135d);
    }

    public final void mo1302a(C1375a c1375a, C3141f c3141f) {
        this.f5214k.countDown();
        mo1310a((C3147h) c3141f);
    }

    public final void mo1298a(C1375a c1375a, int i, String str, boolean z) {
        this.f5214k.countDown();
        this.f5215l.countDown();
        if (this.f5211h != null) {
            this.f5211h.interrupt();
        }
        try {
            if (this.f5207d != null) {
                this.f5207d.close();
            }
        } catch (Exception e) {
            mo1299a((C1375a) this, e);
        }
        mo1307a(i, str, z);
    }

    public final void mo1299a(C1375a c1375a, Exception exception) {
        mo1308a(exception);
    }

    public final void mo1304b(C1375a c1375a) {
    }

    public void mo1297a(C1375a c1375a, int i, String str) {
        m8870a(i, str);
    }

    public void mo1305b(C1375a c1375a, int i, String str, boolean z) {
        m8887b(i, str, z);
    }

    public void m8870a(int i, String str) {
    }

    public void m8887b(int i, String str, boolean z) {
    }

    public InetSocketAddress mo1306c(C1375a c1375a) {
        if (this.f5207d != null) {
            return (InetSocketAddress) this.f5207d.getLocalSocketAddress();
        }
        return null;
    }

    public void m8876a(ByteBuffer byteBuffer) {
    }

    public void m8891b(C3135d c3135d) {
    }

    public void m8874a(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        this.f5210g = proxy;
    }

    public void m8875a(Socket socket) {
        if (this.f5207d != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.f5207d = socket;
    }

    public boolean m8894d() {
        return this.f5206c.m17607f();
    }

    public void mo1303a(C3135d c3135d) {
        this.f5206c.mo1303a(c3135d);
    }

    public InetSocketAddress mo1296a() {
        return this.f5206c.mo1296a();
    }
}
