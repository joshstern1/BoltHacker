package com.onesignal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;
import org.json.JSONException;
import org.json.JSONObject;

class aj {
    static HashMap<Integer, C2722a> f9194a = new HashMap();
    private static boolean f9195b = false;
    private static boolean f9196c = false;
    private static boolean f9197d = false;
    private static C2723b f9198e;
    private static C2723b f9199f;
    private static Context f9200g;
    private static final String[] f9201h = new String[]{"lat", "long", "loc_acc", "loc_type"};
    private static final Set<String> f9202i = new HashSet(Arrays.asList(f9201h));

    static class C2722a extends HandlerThread {
        int f9186a;
        Handler f9187b = null;
        int f9188c;

        C2722a(int i) {
            super("NetworkHandlerThread");
            this.f9186a = i;
            start();
            this.f9187b = new Handler(getLooper());
        }

        public void m15884a() {
            this.f9188c = 0;
            this.f9187b.removeCallbacksAndMessages(null);
            this.f9187b.postDelayed(m15883d(), BootloaderScanner.TIMEOUT);
        }

        private Runnable m15883d() {
            switch (this.f9186a) {
                case 0:
                    return new am(this);
                default:
                    return null;
            }
        }

        void m15885b() {
            this.f9187b.removeCallbacksAndMessages(null);
        }

        void m15886c() {
            if (this.f9188c < 3 && !this.f9187b.hasMessages(0)) {
                this.f9188c++;
                this.f9187b.postDelayed(m15883d(), (long) (this.f9188c * 10000));
            }
        }
    }

    class C2723b {
        JSONObject f9189a;
        JSONObject f9190b;
        final /* synthetic */ aj f9191c;
        private final int f9192d;
        private String f9193e;

        private C2723b(aj ajVar, String str, boolean z) {
            this.f9191c = ajVar;
            this.f9192d = -2;
            this.f9193e = str;
            if (z) {
                m15898c();
                return;
            }
            this.f9189a = new JSONObject();
            this.f9190b = new JSONObject();
        }

        private C2723b m15888a(String str) {
            C2723b c2723b = new C2723b(this.f9191c, str, false);
            try {
                c2723b.f9189a = new JSONObject(this.f9189a.toString());
                c2723b.f9190b = new JSONObject(this.f9190b.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return c2723b;
        }

        private void m15892a() {
            try {
                this.f9190b.put("notification_types", m15895b());
            } catch (JSONException e) {
            }
        }

        private int m15895b() {
            try {
                int i = this.f9189a.getInt("subscribableStatus");
                boolean z = this.f9189a.getBoolean("userSubscribePref");
                if (i < -2) {
                    return i;
                }
                return z ? 1 : -2;
            } catch (JSONException e) {
                e.printStackTrace();
                return 1;
            }
        }

        private Set<String> m15889a(JSONObject jSONObject, JSONObject jSONObject2) {
            try {
                if (jSONObject.getDouble("lat") == jSONObject2.getDouble("lat") && jSONObject.getDouble("long") == jSONObject2.getDouble("long") && jSONObject.getDouble("loc_acc") == jSONObject2.getDouble("loc_acc") && jSONObject.getDouble("loc_type") == jSONObject2.getDouble("loc_type")) {
                    return null;
                }
                return aj.f9202i;
            } catch (Throwable th) {
                return aj.f9202i;
            }
        }

        private JSONObject m15891a(C2723b c2723b, boolean z) {
            m15892a();
            c2723b.m15892a();
            JSONObject a = aj.m15914b(this.f9190b, c2723b.f9190b, null, m15889a(this.f9190b, c2723b.f9190b));
            if (!z && a.toString().equals("{}")) {
                return null;
            }
            try {
                if (!a.has("app_id")) {
                    a.put("app_id", (String) this.f9190b.opt("app_id"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return a;
        }

        void m15900a(String str, Object obj) {
            try {
                this.f9190b.put(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        void m15901b(String str, Object obj) {
            try {
                this.f9189a.put(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void m15898c() {
            int i = 1;
            SharedPreferences g = C2758w.m16097g(aj.f9200g);
            String string = g.getString("ONESIGNAL_USERSTATE_DEPENDVALYES_" + this.f9193e, null);
            if (string == null) {
                this.f9189a = new JSONObject();
                try {
                    int i2;
                    boolean z;
                    if (this.f9193e.equals("CURRENT_STATE")) {
                        i2 = g.getInt("ONESIGNAL_SUBSCRIPTION", 1);
                    } else {
                        i2 = g.getInt("ONESIGNAL_SYNCED_SUBSCRIPTION", 1);
                    }
                    if (i2 == -2) {
                        z = false;
                    } else {
                        i = i2;
                        z = true;
                    }
                    this.f9189a.put("subscribableStatus", i);
                    this.f9189a.put("userSubscribePref", z);
                } catch (JSONException e) {
                }
            } else {
                try {
                    this.f9189a = new JSONObject(string);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            string = g.getString("ONESIGNAL_USERSTATE_SYNCVALYES_" + this.f9193e, null);
            if (string == null) {
                try {
                    this.f9190b = new JSONObject();
                    this.f9190b.put("identifier", g.getString("GT_REGISTRATION_ID", null));
                    return;
                } catch (JSONException e22) {
                    e22.printStackTrace();
                    return;
                }
            }
            this.f9190b = new JSONObject(string);
        }

        private void m15899d() {
            Editor edit = C2758w.m16097g(aj.f9200g).edit();
            edit.putString("ONESIGNAL_USERSTATE_SYNCVALYES_" + this.f9193e, this.f9190b.toString());
            edit.putString("ONESIGNAL_USERSTATE_DEPENDVALYES_" + this.f9193e, this.f9189a.toString());
            edit.commit();
        }

        private void m15897b(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null) {
                aj.m15914b(this.f9189a, jSONObject, this.f9189a, null);
            }
            if (jSONObject2 != null) {
                aj.m15914b(this.f9190b, jSONObject2, this.f9190b, null);
                if (jSONObject2.has("tags")) {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject optJSONObject = jSONObject2.optJSONObject("tags");
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        try {
                            String str = (String) keys.next();
                            if (!"".equals(optJSONObject.optString(str))) {
                                jSONObject3.put(str, optJSONObject.optString(str));
                            }
                        } catch (Throwable th) {
                        }
                    }
                    if (jSONObject3.toString().equals("{}")) {
                        this.f9190b.remove("tags");
                    } else {
                        this.f9190b.put("tags", jSONObject3);
                    }
                }
            }
            if (jSONObject != null || jSONObject2 != null) {
                m15899d();
            }
        }
    }

    aj() {
    }

    private static JSONObject m15914b(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        JSONObject jSONObject4;
        Iterator keys = jSONObject2.keys();
        if (jSONObject3 != null) {
            jSONObject4 = jSONObject3;
        } else {
            jSONObject4 = new JSONObject();
        }
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Object obj = jSONObject2.get(str);
                if (jSONObject.has(str)) {
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject5 = jSONObject.getJSONObject(str);
                        JSONObject jSONObject6 = null;
                        if (jSONObject3 != null && jSONObject3.has(str)) {
                            jSONObject6 = jSONObject3.getJSONObject(str);
                        }
                        String jSONObject7 = m15914b(jSONObject5, (JSONObject) obj, jSONObject6, set).toString();
                        if (!jSONObject7.equals("{}")) {
                            jSONObject4.put(str, new JSONObject(jSONObject7));
                        }
                    } else {
                        if (set != null) {
                            if (set.contains(str)) {
                                jSONObject4.put(str, obj);
                            }
                        }
                        Object obj2 = jSONObject.get(str);
                        if (!obj.equals(obj2)) {
                            if (!(obj2 instanceof Integer) || "".equals(obj)) {
                                jSONObject4.put(str, obj);
                            } else if (((Number) obj2).doubleValue() != ((Number) obj).doubleValue()) {
                                jSONObject4.put(str, obj);
                            }
                        }
                    }
                } else if (obj instanceof JSONObject) {
                    jSONObject4.put(str, new JSONObject(obj.toString()));
                } else {
                    jSONObject4.put(str, obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject4;
    }

    private static JSONObject m15913b(JSONObject jSONObject) {
        if (!jSONObject.has("tags")) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject optJSONObject = jSONObject.optJSONObject("tags");
        Iterator keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                Object obj = optJSONObject.get(str);
                if (!"".equals(obj)) {
                    jSONObject2.put(str, obj);
                }
            } catch (Throwable th) {
            }
        }
        return jSONObject2;
    }

    public static void m15904a() {
        for (Entry value : f9194a.entrySet()) {
            ((C2722a) value.getValue()).m15885b();
        }
        if (f9199f != null) {
            f9199f.m15899d();
        }
    }

    static void m15905a(Context context) {
        f9200g = context;
        if (f9198e == null) {
            aj ajVar = new aj();
            ajVar.getClass();
            f9198e = new C2723b("CURRENT_STATE", true);
            ajVar = new aj();
            ajVar.getClass();
            f9199f = new C2723b("TOSYNC_STATE", true);
        }
    }

    static C2723b m15912b() {
        aj ajVar = new aj();
        ajVar.getClass();
        return new C2723b("nonPersist", false);
    }

    static void m15909a(boolean z) {
        boolean z2 = (f9195b || !f9196c || f9197d) ? false : true;
        JSONObject a = f9198e.m15891a(f9199f, z2);
        JSONObject b = m15914b(f9198e.f9189a, f9199f.f9189a, null, null);
        if (a == null) {
            f9198e.m15897b(b, null);
            return;
        }
        String e = C2758w.m16092e();
        f9199f.m15899d();
        if (f9195b || z) {
            ag.m15881c("players/" + e, a, new ak(b, a));
        } else if (f9196c) {
            if (e == null) {
                e = "players";
            } else {
                e = "players/" + e + "/on_session";
            }
            f9197d = true;
            ag.m15882d(e, a, new al(b, a));
        }
    }

    private static boolean m15915b(int i, String str, String str2) {
        if (i != 400 || str == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errors") && jSONObject.optString("errors").contains(str2)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static C2722a m15911b(Integer num) {
        if (!f9194a.containsKey(num)) {
            f9194a.put(num, new C2722a(num.intValue()));
        }
        return (C2722a) f9194a.get(num);
    }

    private static C2723b m15926k() {
        if (f9199f == null) {
            f9199f = f9198e.m15888a("TOSYNC_STATE");
        }
        m15927l();
        return f9199f;
    }

    private static void m15927l() {
        m15911b(Integer.valueOf(0)).m15884a();
    }

    static void m15906a(C2723b c2723b) {
        JSONObject jSONObject = m15926k().f9190b;
        m15914b(jSONObject, c2723b.f9190b, jSONObject, null);
        jSONObject = m15926k().f9189a;
        m15914b(jSONObject, c2723b.f9189a, jSONObject, null);
        f9196c = true;
    }

    static void m15908a(JSONObject jSONObject) {
        JSONObject jSONObject2 = m15926k().f9190b;
        try {
            m15914b(jSONObject2, new JSONObject().put("tags", jSONObject), jSONObject2, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static void m15907a(String str) {
        try {
            m15926k().f9190b.put("identifier", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static boolean m15917c() {
        return f9199f.m15895b() > 0;
    }

    static String m15919d() {
        return f9199f.f9190b.optString("identifier", null);
    }

    static JSONObject m15920e() {
        return m15913b(f9199f.f9190b);
    }

    static void m15921f() {
        f9195b = false;
        C2758w.m16077b(null);
        f9198e.f9190b = new JSONObject();
        f9198e.m15899d();
    }
}
