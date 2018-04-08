package org.p070a.p128f;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.p070a.p125c.C3128b;

public class C3152b {
    public static CodingErrorAction f10359a = CodingErrorAction.REPORT;

    public static byte[] m17670a(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] m17671b(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String m17669a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "ASCII");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String m17668a(ByteBuffer byteBuffer) throws C3128b {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(f10359a);
        newDecoder.onUnmappableCharacter(f10359a);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (Throwable e) {
            throw new C3128b(1007, e);
        }
    }
}
