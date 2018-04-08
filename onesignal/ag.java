package com.onesignal;

import com.onesignal.C2758w.C2756d;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

class ag {

    static class C2721a {
        C2721a() {
        }

        void mo2310a(String str) {
        }

        void mo2309a(int i, String str, Throwable th) {
        }
    }

    static void m15878a(String str, JSONObject jSONObject, C2721a c2721a) {
        new Thread(new ah(str, jSONObject, c2721a)).start();
    }

    static void m15880b(String str, JSONObject jSONObject, C2721a c2721a) {
        new Thread(new ai(str, jSONObject, c2721a)).start();
    }

    static void m15881c(String str, JSONObject jSONObject, C2721a c2721a) {
        m15879b(str, "PUT", jSONObject, c2721a);
    }

    static void m15882d(String str, JSONObject jSONObject, C2721a c2721a) {
        m15879b(str, "POST", jSONObject, c2721a);
    }

    private static void m15879b(String str, String str2, JSONObject jSONObject, C2721a c2721a) {
        int i;
        HttpURLConnection httpURLConnection;
        Throwable th;
        String str3 = null;
        int i2 = -1;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("https://onesignal.com/api/v1/" + str).openConnection();
            try {
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setConnectTimeout(120000);
                httpURLConnection2.setReadTimeout(120000);
                if (jSONObject != null) {
                    httpURLConnection2.setDoInput(true);
                }
                httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpURLConnection2.setRequestMethod(str2);
                if (jSONObject != null) {
                    String jSONObject2 = jSONObject.toString();
                    C2758w.m16057a(C2756d.DEBUG, str2 + " SEND JSON: " + jSONObject2);
                    byte[] bytes = jSONObject2.getBytes("UTF-8");
                    httpURLConnection2.setFixedLengthStreamingMode(bytes.length);
                    httpURLConnection2.getOutputStream().write(bytes);
                }
                i2 = httpURLConnection2.getResponseCode();
                if (i2 == 200) {
                    Scanner scanner = new Scanner(httpURLConnection2.getInputStream(), "UTF-8");
                    str3 = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                    scanner.close();
                    C2758w.m16057a(C2756d.DEBUG, str2 + " RECEIVED JSON: " + str3);
                    if (c2721a != null) {
                        c2721a.mo2310a(str3);
                    }
                } else {
                    InputStream errorStream = httpURLConnection2.getErrorStream();
                    if (errorStream == null) {
                        errorStream = httpURLConnection2.getInputStream();
                    }
                    if (errorStream != null) {
                        Scanner scanner2 = new Scanner(errorStream, "UTF-8");
                        str3 = scanner2.useDelimiter("\\A").hasNext() ? scanner2.next() : "";
                        scanner2.close();
                        C2758w.m16057a(C2756d.WARN, str2 + " RECEIVED JSON: " + str3);
                    } else {
                        C2758w.m16057a(C2756d.WARN, str2 + " HTTP Code: " + i2 + " No response body!");
                    }
                    if (c2721a != null) {
                        c2721a.mo2309a(i2, str3, null);
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                httpURLConnection = httpURLConnection2;
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
