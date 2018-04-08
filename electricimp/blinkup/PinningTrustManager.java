package com.electricimp.blinkup;

import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;

public class PinningTrustManager implements X509TrustManager {
    public static final String RAPIDSSL_PIN = "887a93b328b96b2ae7422b18ce5489364faded56";
    private final byte[] pin;

    public PinningTrustManager(String str) {
        this.pin = hexStringToByteArray(str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        int length = x509CertificateArr.length;
        int i = 0;
        while (i < length) {
            if (!isValidPin(x509CertificateArr[i])) {
                i++;
            } else {
                return;
            }
        }
        throw new CertificateException("Server is not trusted");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    private boolean isValidPin(X509Certificate x509Certificate) throws CertificateException {
        try {
            return Arrays.equals(this.pin, MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded()));
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
