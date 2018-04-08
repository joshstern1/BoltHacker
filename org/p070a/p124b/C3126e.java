package org.p070a.p124b;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.p070a.C1375a.C3116b;
import org.p070a.p124b.C3121a.C3119a;
import org.p070a.p124b.C3121a.C3120b;
import org.p070a.p125c.C3127a;
import org.p070a.p125c.C3128b;
import org.p070a.p125c.C3129c;
import org.p070a.p125c.C3130d;
import org.p070a.p126d.C3135d;
import org.p070a.p126d.C3135d.C3140a;
import org.p070a.p126d.C3139b;
import org.p070a.p127e.C3141f;
import org.p070a.p127e.C3142a;
import org.p070a.p127e.C3143c;
import org.p070a.p127e.C3144b;
import org.p070a.p127e.C3147h;
import org.p070a.p127e.C3148i;

public class C3126e extends C3125d {
    private static final byte[] f10296j = new byte[]{(byte) -1, (byte) 0};
    private boolean f10297i = false;
    private final Random f10298k = new Random();

    public static byte[] m17570a(String str, String str2, byte[] bArr) throws C3130d {
        byte[] a = C3126e.m17569a(str);
        byte[] a2 = C3126e.m17569a(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{a[0], a[1], a[2], a[3], a2[0], a2[1], a2[2], a2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String m17571e() {
        Random random = new Random();
        long nextInt = (long) (random.nextInt(12) + 1);
        String l = Long.toString(((long) (random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1)) * nextInt);
        int nextInt2 = random.nextInt(12) + 1;
        for (int i = 0; i < nextInt2; i++) {
            int abs = Math.abs(random.nextInt(l.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l = abs;
        }
        String str = l;
        for (int i2 = 0; ((long) i2) < nextInt; i2++) {
            str = Math.abs(random.nextInt(str.length() - 1) + 1);
        }
        return str;
    }

    private static byte[] m17569a(String str) throws C3130d {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = (long) (str.split(" ").length - 1);
            if (length == 0) {
                throw new C3130d("invalid Sec-WebSocket-Key (/key2/)");
            }
            parseLong = new Long(parseLong / length).longValue();
            return new byte[]{(byte) ((int) (parseLong >> 24)), (byte) ((int) ((parseLong << 8) >> 24)), (byte) ((int) ((parseLong << 16) >> 24)), (byte) ((int) ((parseLong << 24) >> 24))};
        } catch (NumberFormatException e) {
            throw new C3130d("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    public C3120b mo2531a(C3142a c3142a, C3147h c3147h) {
        if (this.f10297i) {
            return C3120b.NOT_MATCHED;
        }
        try {
            if (!c3147h.mo2552b("Sec-WebSocket-Origin").equals(c3142a.mo2552b("Origin")) || !m17531a((C3141f) c3147h)) {
                return C3120b.NOT_MATCHED;
            }
            byte[] c = c3147h.mo2555c();
            if (c == null || c.length == 0) {
                throw new C3127a();
            } else if (Arrays.equals(c, C3126e.m17570a(c3142a.mo2552b("Sec-WebSocket-Key1"), c3142a.mo2552b("Sec-WebSocket-Key2"), c3142a.mo2555c()))) {
                return C3120b.MATCHED;
            } else {
                return C3120b.NOT_MATCHED;
            }
        } catch (Throwable e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    public C3120b mo2530a(C3142a c3142a) {
        if (c3142a.mo2552b("Upgrade").equals("WebSocket") && c3142a.mo2552b("Connection").contains("Upgrade") && c3142a.mo2552b("Sec-WebSocket-Key1").length() > 0 && !c3142a.mo2552b("Sec-WebSocket-Key2").isEmpty() && c3142a.mo2554c("Origin")) {
            return C3120b.MATCHED;
        }
        return C3120b.NOT_MATCHED;
    }

    public C3144b mo2532a(C3144b c3144b) {
        c3144b.mo2550a("Upgrade", "WebSocket");
        c3144b.mo2550a("Connection", "Upgrade");
        c3144b.mo2550a("Sec-WebSocket-Key1", C3126e.m17571e());
        c3144b.mo2550a("Sec-WebSocket-Key2", C3126e.m17571e());
        if (!c3144b.mo2554c("Origin")) {
            c3144b.mo2550a("Origin", "random" + this.f10298k.nextInt());
        }
        byte[] bArr = new byte[8];
        this.f10298k.nextBytes(bArr);
        c3144b.mo2551a(bArr);
        return c3144b;
    }

    public C3143c mo2533a(C3142a c3142a, C3148i c3148i) throws C3130d {
        c3148i.mo2559a("WebSocket Protocol Handshake");
        c3148i.mo2550a("Upgrade", "WebSocket");
        c3148i.mo2550a("Connection", c3142a.mo2552b("Connection"));
        c3148i.mo2550a("Sec-WebSocket-Origin", c3142a.mo2552b("Origin"));
        c3148i.mo2550a("Sec-WebSocket-Location", "ws://" + c3142a.mo2552b("Host") + c3142a.mo2556a());
        String b = c3142a.mo2552b("Sec-WebSocket-Key1");
        String b2 = c3142a.mo2552b("Sec-WebSocket-Key2");
        byte[] c = c3142a.mo2555c();
        if (b == null || b2 == null || c == null || c.length != 8) {
            throw new C3130d("Bad keys");
        }
        c3148i.mo2551a(C3126e.m17570a(b, b2, c));
        return c3148i;
    }

    public C3141f mo2538d(ByteBuffer byteBuffer) throws C3130d {
        C3141f a = C3121a.m17518a(byteBuffer, this.d);
        if ((a.mo2554c("Sec-WebSocket-Key1") || this.d == C3116b.CLIENT) && !a.mo2554c("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[(this.d == C3116b.SERVER ? 8 : 16)];
            try {
                byteBuffer.get(bArr);
                a.mo2551a(bArr);
            } catch (BufferUnderflowException e) {
                throw new C3127a(byteBuffer.capacity() + 16);
            }
        }
        return a;
    }

    public List<C3135d> mo2536c(ByteBuffer byteBuffer) throws C3128b {
        byteBuffer.mark();
        List<C3135d> e = super.m17567e(byteBuffer);
        if (e == null) {
            byteBuffer.reset();
            e = this.g;
            this.f = true;
            if (this.h == null) {
                this.h = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() > this.h.remaining()) {
                    throw new C3129c();
                }
                this.h.put(byteBuffer);
                if (this.h.hasRemaining()) {
                    this.g = new LinkedList();
                } else if (Arrays.equals(this.h.array(), f10296j)) {
                    e.add(new C3139b(1000));
                } else {
                    throw new C3129c();
                }
            }
            throw new C3129c();
        }
        return e;
    }

    public ByteBuffer mo2528a(C3135d c3135d) {
        if (c3135d.mo2546f() == C3140a.CLOSING) {
            return ByteBuffer.wrap(f10296j);
        }
        return super.mo2528a(c3135d);
    }

    public C3119a mo2535b() {
        return C3119a.ONEWAY;
    }

    public C3121a mo2537c() {
        return new C3126e();
    }
}
