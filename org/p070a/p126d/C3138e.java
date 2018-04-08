package org.p070a.p126d;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.p070a.p125c.C3128b;
import org.p070a.p126d.C3135d.C3140a;
import org.p070a.p128f.C3152b;

public class C3138e implements C3137c {
    protected static byte[] f10322b = new byte[0];
    private ByteBuffer f10323a;
    protected boolean f10324c;
    protected C3140a f10325d;
    protected boolean f10326e;

    public C3138e(C3140a c3140a) {
        this.f10325d = c3140a;
        this.f10323a = ByteBuffer.wrap(f10322b);
    }

    public C3138e(C3135d c3135d) {
        this.f10324c = c3135d.mo2544d();
        this.f10325d = c3135d.mo2546f();
        this.f10323a = c3135d.mo2543c();
        this.f10326e = c3135d.mo2545e();
    }

    public boolean mo2544d() {
        return this.f10324c;
    }

    public C3140a mo2546f() {
        return this.f10325d;
    }

    public boolean mo2545e() {
        return this.f10326e;
    }

    public ByteBuffer mo2543c() {
        return this.f10323a;
    }

    public void mo2541a(boolean z) {
        this.f10324c = z;
    }

    public void mo2540a(C3140a c3140a) {
        this.f10325d = c3140a;
    }

    public void mo2539a(ByteBuffer byteBuffer) throws C3128b {
        this.f10323a = byteBuffer;
    }

    public void mo2542b(boolean z) {
        this.f10326e = z;
    }

    public String toString() {
        return "Framedata{ optcode:" + mo2546f() + ", fin:" + mo2544d() + ", payloadlength:[pos:" + this.f10323a.position() + ", len:" + this.f10323a.remaining() + "], payload:" + Arrays.toString(C3152b.m17670a(new String(this.f10323a.array()))) + "}";
    }
}
