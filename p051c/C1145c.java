package com.p041a.p042a.p051c;

import android.os.Process;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p046b.C2967t;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class C1145c {
    private static final AtomicLong f4325a = new AtomicLong(0);
    private static String f4326b;

    public C1145c(C2967t c2967t) {
        r0 = new byte[10];
        m7886a(r0);
        m7888b(r0);
        m7890c(r0);
        String a = C2956j.m16987a(c2967t.m17038b());
        String a2 = C2956j.m16989a(r0);
        f4326b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), a.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void m7886a(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] a = C1145c.m7887a(j);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = C1145c.m7889b(time);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    private void m7888b(byte[] bArr) {
        byte[] b = C1145c.m7889b(f4325a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    private void m7890c(byte[] bArr) {
        byte[] b = C1145c.m7889b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    private static byte[] m7887a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] m7889b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f4326b;
    }
}
