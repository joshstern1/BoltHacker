package com.onesignal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.onesignal.ag.C2721a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2758w {
    private static Double f9288A;
    private static Float f9289B;
    private static Integer f9290C;
    private static C2755a f9291D;
    static String f9292a;
    static String f9293b;
    static Context f9294c;
    static boolean f9295d;
    public static String f9296e = "native";
    static Collection<JSONArray> f9297f = new ArrayList();
    private static boolean f9298g;
    private static C2756d f9299h = C2756d.NONE;
    private static C2756d f9300i = C2756d.WARN;
    private static String f9301j = null;
    private static int f9302k = 1;
    private static C2757e f9303l;
    private static boolean f9304m;
    private static C2728c f9305n;
    private static long f9306o = 1;
    private static long f9307p = -1;
    private static az f9308q;
    private static ay f9309r;
    private static C2732h f9310s = new C2734g();
    private static int f9311t;
    private static C2754v f9312u;
    private static boolean f9313v;
    private static String f9314w;
    private static boolean f9315x;
    private static boolean f9316y;
    private static Double f9317z;

    public interface C2652b {
        void mo2295a(JSONObject jSONObject);
    }

    public interface C2728c {
        void mo2313a(String str, String str2);
    }

    public static class C2755a {
        Context f9277a;
        C2757e f9278b;
        boolean f9279c;

        private C2755a() {
        }

        private C2755a(Context context) {
            this.f9277a = context;
        }

        public void m16043a() {
            C2758w.m16076b(this);
        }
    }

    public enum C2756d {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    public interface C2757e {
        void m16044a(String str, JSONObject jSONObject, boolean z);
    }

    public static C2755a m16045a(Context context) {
        return new C2755a(context);
    }

    private static void m16076b(C2755a c2755a) {
        f9291D = c2755a;
        Context context = f9291D.f9277a;
        f9291D.f9277a = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            C2758w.m16052a(context, bundle.getString("onesignal_google_project_number").substring(4), bundle.getString("onesignal_app_id"), f9291D.f9278b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void m16052a(Context context, String str, String str2, C2757e c2757e) {
        if (f9291D == null) {
            f9291D = new C2755a();
        }
        f9312u = new C2754v();
        f9311t = f9312u.m16040a();
        try {
            UUID.fromString(str2);
            if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals(str2) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals(str2)) {
                C2758w.m16057a(C2756d.WARN, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
            }
            if (f9311t == 1) {
                try {
                    Double.parseDouble(str);
                    if (str.length() < 8 || str.length() > 16) {
                        throw new IllegalArgumentException("Google Project number (Sender_ID) should be a 10 to 14 digit number in length.");
                    }
                } catch (Throwable th) {
                    C2758w.m16058a(C2756d.FATAL, "Google Project number (Sender_ID) format is invalid. Please use the 10 to 14 digit number found in the Google Developer Console for your project.\nExample: '703322744261'\n", th);
                    f9302k = -6;
                }
                try {
                    Class.forName("com.google.android.gms.b.b");
                } catch (Throwable th2) {
                    C2758w.m16058a(C2756d.FATAL, "The GCM Google Play services client library was not found. Please make sure to include it in your project.", th2);
                    f9302k = -4;
                }
            }
            f9293b = str;
            try {
                Class.forName("android.support.v4.view.v");
                try {
                    Class.forName("android.support.v4.b.l");
                    Class.forName("android.support.v4.app.bg");
                } catch (Throwable th22) {
                    C2758w.m16058a(C2756d.FATAL, "The included Android Support Library v4 is to old or incomplete. Please update your project's android-support-v4.jar to the latest revision.", th22);
                    f9302k = -5;
                }
            } catch (Throwable th222) {
                C2758w.m16058a(C2756d.FATAL, "Could not find the Android Support Library v4. Please make sure android-support-v4.jar has been correctly added to your project.", th222);
                f9302k = -3;
            }
            if (f9295d) {
                if (context != null) {
                    f9294c = context.getApplicationContext();
                }
                if (c2757e != null) {
                    f9303l = c2757e;
                }
                if (f9303l != null) {
                    C2758w.m16114u();
                    return;
                }
                return;
            }
            boolean z = context instanceof Activity;
            f9304m = z;
            f9292a = str2;
            f9294c = context.getApplicationContext();
            if (z) {
                C2720a.f9174b = (Activity) context;
            } else {
                C2720a.f9173a = true;
            }
            f9303l = c2757e;
            f9306o = SystemClock.elapsedRealtime();
            aj.m15905a(f9294c);
            f9294c.startService(new Intent(f9294c, SyncService.class));
            if (VERSION.SDK_INT > 13) {
                ((Application) f9294c).registerActivityLifecycleCallbacks(new C2727b());
            } else {
                C2729c.m15975a();
            }
            try {
                Class.forName("com.amazon.device.iap.PurchasingListener");
                f9309r = new ay(f9294c);
            } catch (ClassNotFoundException e) {
            }
            String d = C2758w.m16088d();
            if (d == null) {
                C2758w.m16089d(f9292a);
            } else if (!d.equals(f9292a)) {
                C2758w.m16057a(C2756d.DEBUG, "APP ID changed, clearing user id as it is no longer valid.");
                C2758w.m16089d(f9292a);
                aj.m15921f();
            }
            if (f9304m || C2758w.m16092e() == null) {
                C2758w.m16113t();
            }
            if (f9303l != null) {
                C2758w.m16114u();
            }
            if (az.m15956a(f9294c)) {
                f9308q = new az(f9294c);
            }
            f9295d = true;
        } catch (Throwable th2222) {
            C2758w.m16058a(C2756d.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", th2222);
        }
    }

    private static void m16113t() {
        if (!f9298g) {
            ao apVar;
            f9298g = true;
            if (f9311t == 2) {
                apVar = new ap();
            } else {
                apVar = new ar();
            }
            apVar.mo2312a(f9294c, f9293b, new C2759x());
            C2748p.m16021a(f9294c, f9291D.f9279c, new C2760y());
        }
    }

    private static void m16114u() {
        for (JSONArray a : f9297f) {
            C2758w.m16065a(a, false);
        }
        f9297f.clear();
    }

    private static void m16115v() {
        String d = aj.m15919d();
        if (f9314w != null && !f9314w.equals(d)) {
            aj.m15907a(f9314w);
            C2758w.m16084c();
        }
    }

    private static boolean m16071a(C2756d c2756d) {
        return c2756d.compareTo(f9299h) < 1 || c2756d.compareTo(f9300i) < 1;
    }

    static void m16057a(C2756d c2756d, String str) {
        C2758w.m16058a(c2756d, str, null);
    }

    static void m16058a(C2756d c2756d, String str, Throwable th) {
        if (c2756d.compareTo(f9300i) < 1) {
            if (c2756d == C2756d.VERBOSE) {
                Log.v("OneSignal", str, th);
            } else if (c2756d == C2756d.DEBUG) {
                Log.d("OneSignal", str, th);
            } else if (c2756d == C2756d.INFO) {
                Log.i("OneSignal", str, th);
            } else if (c2756d == C2756d.WARN) {
                Log.w("OneSignal", str, th);
            } else if (c2756d == C2756d.ERROR || c2756d == C2756d.FATAL) {
                Log.e("OneSignal", str, th);
            }
        }
        if (c2756d.compareTo(f9299h) < 1 && C2720a.f9174b != null) {
            try {
                String str2 = str + "\n";
                if (th != null) {
                    str2 = str2 + th.getMessage();
                    Writer stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str2 = str2 + stringWriter.toString();
                }
                C2758w.m16059a(new C2761z(c2756d, str2));
            } catch (Throwable th2) {
                Log.e("OneSignal", "Error showing logging message.", th2);
            }
        }
    }

    private static void m16078b(String str, int i, Throwable th, String str2) {
        String str3 = "";
        if (str2 != null && C2758w.m16071a(C2756d.INFO)) {
            str3 = "\n" + str2 + "\n";
        }
        C2758w.m16058a(C2756d.WARN, "HTTP code: " + i + " " + str + str3, th);
    }

    static void m16068a(boolean z) {
        f9304m = false;
        if (f9295d) {
            if (f9309r != null) {
                f9309r.m15948a();
            }
            if (f9306o != -1) {
                long elapsedRealtime = (long) ((((double) (SystemClock.elapsedRealtime() - f9306o)) / 1000.0d) + 0.5d);
                f9306o = SystemClock.elapsedRealtime();
                if (elapsedRealtime >= 0 && elapsedRealtime <= 604800) {
                    if (f9294c == null) {
                        C2758w.m16057a(C2756d.ERROR, "Android Context not found, please call OneSignal.init when your app starts.");
                        return;
                    }
                    elapsedRealtime += C2758w.m16095f();
                    if (z || elapsedRealtime < 60 || C2758w.m16092e() == null) {
                        C2758w.m16074b(elapsedRealtime);
                    } else {
                        C2758w.m16051a(elapsedRealtime, true);
                    }
                }
            }
        }
    }

    static void m16051a(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", f9292a);
            jSONObject.put("state", "ping");
            jSONObject.put("active_time", j);
            C2758w.m16079b(jSONObject);
            String str = "players/" + C2758w.m16092e() + "/on_focus";
            C2721a aaVar = new aa();
            if (z) {
                ag.m15882d(str, jSONObject, aaVar);
            } else {
                ag.m15880b(str, jSONObject, aaVar);
            }
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.ERROR, "Generating on_focus:JSON Failed.", th);
        }
    }

    static void m16049a() {
        f9304m = true;
        f9306o = SystemClock.elapsedRealtime();
        C2758w.m16113t();
        if (f9308q != null) {
            f9308q.m15971a();
        }
    }

    static boolean m16081b() {
        return f9304m;
    }

    private static void m16079b(JSONObject jSONObject) {
        try {
            jSONObject.put("net_type", f9312u.m16041b());
        } catch (Throwable th) {
        }
    }

    private static int m16116w() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    private static void m16117x() {
        C2758w.m16057a(C2756d.DEBUG, "registerUser: registerForPushFired:" + f9315x + ", locationFired: " + f9316y);
        if (!f9315x || !f9316y) {
            return;
        }
        if (f9313v) {
            C2758w.m16115v();
            return;
        }
        f9313v = true;
        new Thread(new ab()).start();
    }

    public static void m16062a(String str, String str2) {
        try {
            C2758w.m16067a(new JSONObject().put(str, str2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void m16067a(JSONObject jSONObject) {
        if (f9294c == null) {
            C2758w.m16057a(C2756d.ERROR, "You must initialize OneSignal before modifying tags! Omitting this tag operation.");
        } else if (jSONObject != null) {
            JSONObject e = aj.m15920e();
            JSONObject jSONObject2 = new JSONObject();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    Object obj = jSONObject.get(str);
                    if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
                        C2758w.m16057a(C2756d.ERROR, "Omitting key '" + str + "'! sendTags DO NOT supported nested values!");
                    } else if (!jSONObject.isNull(str) && !"".equals(obj)) {
                        jSONObject2.put(str, obj.toString());
                    } else if (e.has(str)) {
                        jSONObject2.put(str, "");
                    }
                } catch (Throwable th) {
                }
            }
            if (!jSONObject2.toString().equals("{}")) {
                aj.m15908a(jSONObject2);
            }
        }
    }

    public static void m16055a(C2652b c2652b) {
        if (f9294c == null) {
            C2758w.m16057a(C2756d.ERROR, "You must initialize OneSignal before getting tags! Omitting this tag operation.");
        } else if (c2652b == null) {
            C2758w.m16057a(C2756d.ERROR, "getTagsHandler is null!");
        } else {
            JSONObject e = aj.m15920e();
            if (e == null || e.toString().equals("{}")) {
                c2652b.mo2295a(null);
            } else {
                c2652b.mo2295a(aj.m15920e());
            }
        }
    }

    public static void m16060a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONObject.put(jSONArray.getString(i), "");
            }
            C2758w.m16067a(jSONObject);
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.ERROR, "Failed to generate JSON for deleteTags.", th);
        }
    }

    public static void m16056a(C2728c c2728c) {
        f9305n = c2728c;
        if (C2758w.m16092e() != null) {
            C2758w.m16118y();
        }
    }

    static void m16084c() {
        if (f9305n != null) {
            C2758w.m16059a(new ac());
        }
    }

    private static void m16118y() {
        if (f9305n != null) {
            String d = aj.m15919d();
            if (!aj.m15917c()) {
                d = null;
            }
            String e = C2758w.m16092e();
            if (e != null) {
                f9305n.mo2313a(e, d);
                if (d != null) {
                    f9305n = null;
                }
            }
        }
    }

    static void m16066a(JSONArray jSONArray, boolean z, C2721a c2721a) {
        if (C2758w.m16092e() != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", f9292a);
                if (z) {
                    jSONObject.put("existing", true);
                }
                jSONObject.put("purchases", jSONArray);
                ag.m15880b("players/" + C2758w.m16092e() + "/on_purchase", jSONObject, c2721a);
            } catch (Throwable th) {
                C2758w.m16058a(C2756d.ERROR, "Failed to generate JSON for sendPurchases.", th);
            }
        }
    }

    private static boolean m16070a(Context context, JSONArray jSONArray) {
        boolean z = false;
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("custom")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom"));
                    if (jSONObject2.has("u")) {
                        String string = jSONObject2.getString("u");
                        if (!string.contains("://")) {
                            string = "http://" + string;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
                        intent.addFlags(1476919296);
                        context.startActivity(intent);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                C2758w.m16058a(C2756d.ERROR, "Error parsing JSON item " + i + "/" + length + " for launching a web URL.", th);
            }
        }
        return z;
    }

    private static void m16065a(JSONArray jSONArray, boolean z) {
        Throwable th;
        if (f9303l == null) {
            f9297f.add(jSONArray);
            return;
        }
        int length = jSONArray.length();
        int i = 0;
        JSONObject jSONObject = null;
        String str = null;
        while (i < length) {
            JSONObject jSONObject2;
            try {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                if (jSONObject3.has("custom")) {
                    JSONObject jSONObject4 = new JSONObject(jSONObject3.getString("custom"));
                    jSONObject2 = new JSONObject();
                    if (jSONObject4.has("a")) {
                        jSONObject2 = jSONObject4.getJSONObject("a");
                    }
                    if (jSONObject3.has("title")) {
                        jSONObject2.put("title", jSONObject3.getString("title"));
                    }
                    if (jSONObject4.has("u")) {
                        jSONObject2.put("launchURL", jSONObject4.getString("u"));
                    }
                    if (jSONObject3.has("sound")) {
                        jSONObject2.put("sound", jSONObject3.getString("sound"));
                    }
                    if (jSONObject3.has("sicon")) {
                        jSONObject2.put("smallIcon", jSONObject3.getString("sicon"));
                    }
                    if (jSONObject3.has("licon")) {
                        jSONObject2.put("largeIcon", jSONObject3.getString("licon"));
                    }
                    if (jSONObject3.has("bicon")) {
                        jSONObject2.put("bigPicture", jSONObject3.getString("bicon"));
                    }
                    if (jSONObject2.equals(new JSONObject())) {
                        jSONObject2 = null;
                    }
                } else {
                    jSONObject2 = null;
                }
                if (str == null) {
                    try {
                        str = jSONObject3.getString("alert");
                    } catch (Throwable th2) {
                        th = th2;
                        C2758w.m16058a(C2756d.ERROR, "Error parsing JSON item " + i + "/" + length + " for callback.", th);
                        i++;
                        jSONObject = jSONObject2;
                    }
                } else {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (!jSONObject.has("stacked_notifications")) {
                        jSONObject.put("stacked_notifications", new JSONArray());
                    }
                    jSONObject2.put("message", jSONObject3.getString("alert"));
                    jSONObject.getJSONArray("stacked_notifications").put(jSONObject2);
                    jSONObject2 = jSONObject;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                jSONObject2 = jSONObject;
                th = th4;
                C2758w.m16058a(C2756d.ERROR, "Error parsing JSON item " + i + "/" + length + " for callback.", th);
                i++;
                jSONObject = jSONObject2;
            }
            i++;
            jSONObject = jSONObject2;
        }
        C2758w.m16063a(str, jSONObject, z);
    }

    private static void m16063a(String str, JSONObject jSONObject, boolean z) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            f9303l.m16044a(str, jSONObject, z);
        } else {
            C2758w.m16059a(new ad(str, jSONObject, z));
        }
    }

    static void m16064a(JSONArray jSONArray) {
        C2758w.m16085c(f9294c, jSONArray);
        C2758w.m16065a(jSONArray, true);
    }

    public static void m16053a(Context context, JSONArray jSONArray, boolean z) {
        C2758w.m16085c(context, jSONArray);
        boolean a = C2758w.m16070a(context, jSONArray);
        C2758w.m16065a(jSONArray, false);
        if (!z && !a) {
            C2758w.m16075b(context, jSONArray);
        }
    }

    private static void m16075b(Context context, JSONArray jSONArray) {
        Intent launchIntentForPackage;
        boolean z = true;
        PackageManager packageManager = context.getPackageManager();
        boolean z2 = false;
        Intent intent = new Intent().setAction("com.onesignal.NotificationOpened.RECEIVE").setPackage(context.getPackageName());
        if (packageManager.queryBroadcastReceivers(intent, 32).size() > 0) {
            intent.putExtra("onesignal_data", jSONArray.toString());
            context.sendBroadcast(intent);
            z2 = true;
        }
        if (packageManager.queryIntentActivities(intent, 65536).size() > 0) {
            if (!z2) {
                intent.putExtra("onesignal_data", jSONArray.toString());
            }
            intent.setFlags(268566528);
            context.startActivity(intent);
        } else {
            z = z2;
        }
        if (!z) {
            try {
                z2 = "DISABLE".equals(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.onesignal.NotificationOpened.DEFAULT"));
            } catch (Throwable th) {
                C2758w.m16058a(C2756d.ERROR, "", th);
            }
            if (!z2) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(268566528);
                    context.startActivity(launchIntentForPackage);
                }
            }
        }
        z2 = z;
        if (!z2) {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268566528);
                context.startActivity(launchIntentForPackage);
            }
        }
    }

    private static void m16085c(Context context, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("custom")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom"));
                    if (jSONObject2.has("i")) {
                        String string = jSONObject2.getString("i");
                        jSONObject2 = new JSONObject();
                        jSONObject2.put("app_id", C2758w.m16100h(context));
                        jSONObject2.put("player_id", C2758w.m16102i(context));
                        jSONObject2.put("opened", true);
                        ag.m15878a("notifications/" + string, jSONObject2, new ae());
                    }
                }
            } catch (Throwable th) {
                C2758w.m16058a(C2756d.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    private static void m16089d(String str) {
        if (f9294c != null) {
            Editor edit = C2758w.m16097g(f9294c).edit();
            edit.putString("GT_APP_ID", str);
            edit.commit();
        }
    }

    static String m16088d() {
        return C2758w.m16100h(f9294c);
    }

    private static String m16100h(Context context) {
        if (context == null) {
            return "";
        }
        return C2758w.m16097g(context).getString("GT_APP_ID", null);
    }

    private static String m16102i(Context context) {
        if (context == null) {
            return "";
        }
        return C2758w.m16097g(context).getString("GT_PLAYER_ID", null);
    }

    static String m16092e() {
        if (f9301j == null && f9294c != null) {
            f9301j = C2758w.m16097g(f9294c).getString("GT_PLAYER_ID", null);
        }
        return f9301j;
    }

    static void m16077b(String str) {
        f9301j = str;
        if (f9294c != null) {
            Editor edit = C2758w.m16097g(f9294c).edit();
            edit.putString("GT_PLAYER_ID", f9301j);
            edit.commit();
        }
    }

    static boolean m16082b(Context context) {
        return C2758w.m16097g(context).getBoolean("GT_VIBRATE_ENABLED", true);
    }

    static boolean m16087c(Context context) {
        return C2758w.m16097g(context).getBoolean("GT_SOUND_ENABLED", true);
    }

    public static void m16080b(boolean z) {
        if (f9294c != null) {
            Editor edit = C2758w.m16097g(f9294c).edit();
            edit.putBoolean("ONESIGNAL_ALWAYS_SHOW_NOTIF", z);
            edit.commit();
        }
    }

    static boolean m16090d(Context context) {
        return C2758w.m16097g(context).getBoolean("ONESIGNAL_ALWAYS_SHOW_NOTIF", false);
    }

    static boolean m16093e(Context context) {
        return C2758w.m16097g(context).getBoolean("ONESIGNAL_INAPP_ALERT", false);
    }

    public static void m16086c(boolean z) {
        if (f9294c != null) {
            Editor edit = C2758w.m16097g(f9294c).edit();
            edit.putBoolean("ONESIGNAL_PREVENT_DISPLAYING", z);
            edit.commit();
        }
    }

    static boolean m16096f(Context context) {
        return C2758w.m16097g(context).getBoolean("ONESIGNAL_PREVENT_DISPLAYING", false);
    }

    static long m16095f() {
        if (f9307p == -1 && f9294c != null) {
            f9307p = C2758w.m16097g(f9294c).getLong("GT_UNSENT_ACTIVE_TIME", 0);
        }
        C2758w.m16057a(C2756d.INFO, "GetUnsentActiveTime: " + f9307p);
        return f9307p;
    }

    private static void m16074b(long j) {
        f9307p = j;
        if (f9294c != null) {
            C2758w.m16057a(C2756d.INFO, "SaveUnsentActiveTime: " + f9307p);
            Editor edit = C2758w.m16097g(f9294c).edit();
            edit.putLong("GT_UNSENT_ACTIVE_TIME", j);
            edit.commit();
        }
    }

    static SharedPreferences m16097g(Context context) {
        return context.getSharedPreferences(C2758w.class.getSimpleName(), 0);
    }

    static boolean m16072a(String str, Context context) {
        if (str == null || "".equals(str)) {
            return false;
        }
        SQLiteDatabase readableDatabase = new af(context).getReadableDatabase();
        Cursor query = readableDatabase.query("notification", new String[]{"notification_id"}, "notification_id = ?", new String[]{str}, null, null, null);
        boolean moveToFirst = query.moveToFirst();
        query.close();
        readableDatabase.close();
        if (!moveToFirst) {
            return false;
        }
        C2758w.m16057a(C2756d.DEBUG, "Duplicate GCM message received, skipping processing. " + str);
        return true;
    }

    static void m16059a(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    static boolean m16069a(Context context, Bundle bundle) {
        if (bundle.isEmpty()) {
            return false;
        }
        try {
            if (bundle.containsKey("custom")) {
                JSONObject jSONObject = new JSONObject(bundle.getString("custom"));
                if (!jSONObject.has("i")) {
                    C2758w.m16057a(C2756d.DEBUG, "Not a OneSignal formatted GCM message. No 'i' field in custom.");
                    return false;
                } else if (C2758w.m16072a(jSONObject.getString("i"), context)) {
                    return false;
                } else {
                    return true;
                }
            }
            C2758w.m16057a(C2756d.DEBUG, "Not a OneSignal formatted GCM message. No 'custom' field in the bundle.");
            return false;
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.DEBUG, "Could not parse bundle for duplicate, probably not a OneSignal notification.", th);
            return false;
        }
    }
}
