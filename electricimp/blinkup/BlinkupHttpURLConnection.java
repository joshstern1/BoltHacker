package com.electricimp.blinkup;

import java.net.URLConnection;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public abstract class BlinkupHttpURLConnection {
    private static final int CONNECTION_TIMEOUT = 60000;
    private static final String GEOTRUST_COMMON_NAME = "CN=GeoTrust Global CA";
    private static final int SOCKET_TIMEOUT = 60000;

    public static HttpsURLConnection get(URLConnection uRLConnection) {
        return configure(uRLConnection);
    }

    public static HttpsURLConnection post(URLConnection uRLConnection) {
        HttpsURLConnection configure = configure(uRLConnection);
        configure.setDoOutput(true);
        return configure;
    }

    private static HttpsURLConnection configure(URLConnection uRLConnection) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
        httpsURLConnection.setConnectTimeout(60000);
        httpsURLConnection.setReadTimeout(60000);
        if (getGeoTrustCertificate() == null) {
            httpsURLConnection.setSSLSocketFactory(newSslSocketFactory());
        }
        return httpsURLConnection;
    }

    private static SSLSocketFactory newSslSocketFactory() {
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new PinningTrustManager(PinningTrustManager.RAPIDSSL_PIN)};
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            return instance.getSocketFactory();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    private static X509Certificate getGeoTrustCertificate() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            if (instance.getTrustManagers().length == 0) {
                return null;
            }
            for (X509Certificate x509Certificate : ((X509TrustManager) instance.getTrustManagers()[0]).getAcceptedIssuers()) {
                for (String trim : x509Certificate.getIssuerDN().getName().split(",")) {
                    if (trim.trim().equals(GEOTRUST_COMMON_NAME)) {
                        return x509Certificate;
                    }
                }
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
        } catch (KeyStoreException e2) {
        }
    }
}
