package com.electricimp.blinkup;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MCrypt {
    private static final char PADDING_CHAR = '\u0000';
    private String SecretKey = "e:imp:02:07:2013";
    private Cipher cipher;
    private String iv = "deadbeefbeefdead";
    private IvParameterSpec ivspec;
    private SecretKeySpec keyspec;

    public MCrypt(String str, String str2) {
        if (str != null) {
            this.iv = str;
        }
        if (str2 != null) {
            this.SecretKey = str2;
        }
        this.ivspec = new IvParameterSpec(this.iv.getBytes());
        this.keyspec = new SecretKeySpec(this.SecretKey.getBytes(), "AES");
        try {
            this.cipher = Cipher.getInstance("AES/CBC/NoPadding");
        } catch (Throwable e) {
            Log.e("BlinkUp", Log.getStackTraceString(e));
        } catch (Throwable e2) {
            Log.e("BlinkUp", Log.getStackTraceString(e2));
        }
    }

    public byte[] encrypt(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            this.cipher.init(1, this.keyspec, this.ivspec);
            return this.cipher.doFinal(padString(str).getBytes());
        } catch (Exception e) {
            throw new Exception("[encrypt] " + e.getMessage());
        }
    }

    public byte[] decrypt(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            this.cipher.init(2, this.keyspec, this.ivspec);
            return this.cipher.doFinal(hexToBytes(str));
        } catch (Exception e) {
            throw new Exception("[decrypt] " + e.getMessage());
        }
    }

    public String decryptToString(String str) throws Exception {
        String str2 = new String(decrypt(str));
        int indexOf = str2.indexOf(0);
        if (indexOf > 0) {
            return str2.substring(0, indexOf);
        }
        return str2;
    }

    public static String bytesToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        String str = "";
        for (int i = 0; i < length; i++) {
            if ((bArr[i] & 255) < 16) {
                str = str + "0" + Integer.toHexString(bArr[i] & 255);
            } else {
                str = str + Integer.toHexString(bArr[i] & 255);
            }
        }
        return str;
    }

    public static byte[] hexToBytes(String str) {
        byte[] bArr = null;
        if (str != null && str.length() >= 2) {
            int length = str.length() / 2;
            bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
            }
        }
        return bArr;
    }

    private static String padString(String str) {
        int length = 16 - (str.length() % 16);
        for (int i = 0; i < length; i++) {
            str = str + '\u0000';
        }
        return str;
    }
}
