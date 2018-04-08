package no.nordicsemi.android.dfu.internal.exception;

public class UnknownResponseException extends Exception {
    private static final char[] HEX_ARRAY = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final long serialVersionUID = -8716125467309979289L;
    private final int mExpectedOpCode;
    private final byte[] mResponse;

    public UnknownResponseException(String str, byte[] bArr, int i) {
        super(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        this.mResponse = bArr;
        this.mExpectedOpCode = i;
    }

    public String getMessage() {
        return String.format("%s (response: %s, expected: 0x10%02X..)", new Object[]{super.getMessage(), bytesToHex(this.mResponse, 0, this.mResponse.length), Integer.valueOf(this.mExpectedOpCode)});
    }

    public static String bytesToHex(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length <= i || i2 <= 0) {
            return "";
        }
        int min = Math.min(i2, bArr.length - i);
        char[] cArr = new char[(min * 2)];
        for (int i3 = 0; i3 < min; i3++) {
            int i4 = bArr[i + i3] & 255;
            cArr[i3 * 2] = HEX_ARRAY[i4 >>> 4];
            cArr[(i3 * 2) + 1] = HEX_ARRAY[i4 & 15];
        }
        return "0x" + new String(cArr);
    }
}
