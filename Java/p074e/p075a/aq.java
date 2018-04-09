package com.p074e.p075a;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import com.p074e.p075a.C1402r.C1439a;
import com.p074e.p075a.C1402r.C1440b;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class aq implements C1402r {
    static volatile Object f5436a;
    private static final Object f5437b = new Object();
    private static final ThreadLocal<StringBuilder> f5438c = new ar();
    private final Context f5439d;

    private static class C1413a {
        static Object m9059a(Context context) throws IOException {
            File b = as.m9084b(context);
            Object installed = HttpResponseCache.getInstalled();
            if (installed == null) {
                return HttpResponseCache.install(b, as.m9069a(b));
            }
            return installed;
        }
    }

    public aq(Context context) {
        this.f5439d = context.getApplicationContext();
    }

    protected HttpURLConnection m9062a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    public C1439a mo1323a(Uri uri, int i) throws IOException {
        if (VERSION.SDK_INT >= 14) {
            aq.m9060a(this.f5439d);
        }
        HttpURLConnection a = m9062a(uri);
        a.setUseCaches(true);
        if (i != 0) {
            String str;
            if (C1448y.m9192c(i)) {
                str = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder stringBuilder = (StringBuilder) f5438c.get();
                stringBuilder.setLength(0);
                if (!C1448y.m9190a(i)) {
                    stringBuilder.append("no-cache");
                }
                if (!C1448y.m9191b(i)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append("no-store");
                }
                str = stringBuilder.toString();
            }
            a.setRequestProperty("Cache-Control", str);
        }
        int responseCode = a.getResponseCode();
        if (responseCode >= 300) {
            a.disconnect();
            throw new C1440b(responseCode + " " + a.getResponseMessage(), i, responseCode);
        }
        long headerFieldInt = (long) a.getHeaderFieldInt("Content-Length", -1);
        return new C1439a(a.getInputStream(), as.m9083a(a.getHeaderField("X-Android-Response-Source")), headerFieldInt);
    }

    private static void m9060a(Context context) {
        if (f5436a == null) {
            try {
                synchronized (f5437b) {
                    if (f5436a == null) {
                        f5436a = C1413a.m9059a(context);
                    }
                }
            } catch (IOException e) {
            }
        }
    }
}
