package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class at {
    private static final Charset f4259a = Charset.forName("UTF-8");
    private final File f4260b;

    public at(File file) {
        this.f4260b = file;
    }

    public void m7784a(String str, bf bfVar) {
        Closeable bufferedWriter;
        Throwable e;
        File c = m7779c(str);
        Closeable closeable = null;
        try {
            String a = at.m7777a(bfVar);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c), f4259a));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                C2956j.m16996a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3059d.m17342h().mo2439e("CrashlyticsCore", "Error serializing user metadata.", e);
                    C2956j.m16996a(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    C2956j.m16996a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Error serializing user metadata.", e);
            C2956j.m16996a(bufferedWriter, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            e = th2;
            C2956j.m16996a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    public bf m7783a(String str) {
        Closeable fileInputStream;
        Throwable e;
        File c = m7779c(str);
        if (!c.exists()) {
            return bf.f4317a;
        }
        try {
            fileInputStream = new FileInputStream(c);
            try {
                bf e2 = at.m7781e(C2956j.m16985a((InputStream) fileInputStream));
                C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
                return e2;
            } catch (Exception e3) {
                e = e3;
                try {
                    C3059d.m17342h().mo2439e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
                    return bf.f4317a;
                } catch (Throwable th) {
                    e = th;
                    C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
            return bf.f4317a;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    public Map<String, String> m7785b(String str) {
        Closeable fileInputStream;
        Throwable e;
        File d = m7780d(str);
        if (!d.exists()) {
            return Collections.emptyMap();
        }
        try {
            fileInputStream = new FileInputStream(d);
            try {
                Map<String, String> f = at.m7782f(C2956j.m16985a((InputStream) fileInputStream));
                C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
                return f;
            } catch (Exception e2) {
                e = e2;
                try {
                    C3059d.m17342h().mo2439e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C2956j.m16996a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    private File m7779c(String str) {
        return new File(this.f4260b, str + "user" + ".meta");
    }

    private File m7780d(String str) {
        return new File(this.f4260b, str + "keys" + ".meta");
    }

    private static bf m7781e(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new bf(at.m7778a(jSONObject, "userId"), at.m7778a(jSONObject, "userName"), at.m7778a(jSONObject, "userEmail"));
    }

    private static String m7777a(bf bfVar) throws JSONException {
        return new au(bfVar).toString();
    }

    private static Map<String, String> m7782f(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, at.m7778a(jSONObject, str2));
        }
        return hashMap;
    }

    private static String m7778a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
