package com.onesignal;

import android.R.drawable;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.av.C0323s;
import android.support.v4.app.av.C0324b;
import android.support.v4.app.av.C0325c;
import android.support.v4.app.av.C0326d;
import android.support.v4.app.av.C0329g;
import android.support.v4.app.bg;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import com.onesignal.C2758w.C2756d;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class C2741k {
    private static Context f9254a = null;
    private static String f9255b = null;
    private static Resources f9256c = null;
    private static Class<?> f9257d;
    private static boolean f9258e;

    static void m15995a(Context context) {
        f9254a = context;
        f9255b = f9254a.getPackageName();
        f9256c = f9254a.getResources();
        PackageManager packageManager = f9254a.getPackageManager();
        Intent intent = new Intent(f9254a, NotificationOpenedReceiver.class);
        intent.setPackage(f9254a.getPackageName());
        if (packageManager.queryBroadcastReceivers(intent, 0).size() > 0) {
            f9258e = true;
            f9257d = NotificationOpenedReceiver.class;
            return;
        }
        f9257d = C2752t.class;
    }

    public static int m15988a(Context context, Bundle bundle, boolean z) {
        C2741k.m15995a(context);
        JSONObject b = C2750r.m16032b(bundle);
        if (!z || C2720a.f9174b == null) {
            return C2741k.m16004c(b);
        }
        return C2741k.m15989a(b, C2720a.f9174b);
    }

    private static int m15989a(JSONObject jSONObject, Activity activity) {
        int nextInt = new Random().nextInt();
        activity.runOnUiThread(new C2742l(activity, jSONObject, nextInt));
        return nextInt;
    }

    private static CharSequence m16002b(JSONObject jSONObject) {
        CharSequence charSequence = null;
        try {
            charSequence = jSONObject.getString("title");
        } catch (Throwable th) {
        }
        if (charSequence != null) {
            return charSequence;
        }
        return f9254a.getPackageManager().getApplicationLabel(f9254a.getApplicationInfo());
    }

    private static PendingIntent m15990a(int i, Intent intent) {
        if (f9258e) {
            return PendingIntent.getBroadcast(f9254a, i, intent, 134217728);
        }
        return PendingIntent.getActivity(f9254a, i, intent, 134217728);
    }

    private static Intent m16000b(int i) {
        Intent putExtra = new Intent(f9254a, f9257d).putExtra("notificationId", i);
        return f9258e ? putExtra : putExtra.addFlags(603979776);
    }

    private static Intent m16005c(int i) {
        Intent putExtra = new Intent(f9254a, f9257d).putExtra("notificationId", i).putExtra("dismissed", true);
        return f9258e ? putExtra : putExtra.addFlags(402718720);
    }

    private static C0326d m15993a(JSONObject jSONObject, boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        int f = C2741k.m16011f(jSONObject);
        if (C2758w.m16082b(f9254a)) {
            i = 2;
        } else {
            i = 0;
        }
        CharSequence charSequence = null;
        try {
            charSequence = jSONObject.getString("alert");
        } catch (Throwable th) {
        }
        C0326d b = new C0326d(f9254a).m2500c(true).m2480a(f).m2490a(C2741k.m16002b(jSONObject)).m2489a(new C0325c().m2476a(charSequence)).m2496b(charSequence);
        if (z) {
            b.m2499c(charSequence);
        }
        if (jSONObject.has("bgac")) {
            try {
                b.m2504e(new BigInteger(jSONObject.getString("bgac"), 16).intValue());
            } catch (Throwable th2) {
            }
        }
        if (z && jSONObject.has("ledc")) {
            try {
                b.m2481a(new BigInteger(jSONObject.getString("ledc"), 16).intValue(), 2000, 5000);
            } catch (Throwable th3) {
                i |= 4;
            }
        } else {
            i |= 4;
        }
        try {
            if (jSONObject.has("vis")) {
                i2 = Integer.parseInt(jSONObject.getString("vis"));
            }
            b.m2505f(i2);
        } catch (Throwable th4) {
        }
        Bitmap e = C2741k.m16010e(jSONObject);
        if (e != null) {
            b.m2486a(e);
        }
        e = C2741k.m15992a(jSONObject, "bicon");
        if (e != null) {
            b.m2489a(new C0324b().m2474a(e).m2475a(charSequence));
        }
        if (z && C2758w.m16087c(f9254a)) {
            Uri g = C2741k.m16012g(jSONObject);
            if (g != null) {
                b.m2487a(g);
            } else {
                i |= 1;
            }
        }
        if (z) {
            i3 = i;
        }
        b.m2498c(i3);
        return b;
    }

    private static int m16004c(JSONObject jSONObject) {
        String string;
        Random random = new Random();
        try {
            string = jSONObject.getString("grp");
        } catch (Throwable th) {
            string = null;
        }
        int nextInt = random.nextInt();
        C0326d a = C2741k.m15993a(jSONObject, true);
        C2741k.m15997a(jSONObject, a, nextInt, null);
        if (string != null) {
            a.m2485a(C2741k.m15990a(random.nextInt(), C2741k.m16000b(nextInt).putExtra("onesignal_data", jSONObject.toString()).putExtra("grp", string)));
            a.m2495b(C2741k.m15990a(random.nextInt(), C2741k.m16005c(nextInt).putExtra("grp", string)));
            a.m2491a(string);
            C2741k.m16008d(jSONObject);
        } else {
            a.m2485a(C2741k.m15990a(random.nextInt(), C2741k.m16000b(nextInt).putExtra("onesignal_data", jSONObject.toString())));
            a.m2495b(C2741k.m15990a(random.nextInt(), C2741k.m16005c(nextInt)));
        }
        if (string == null || VERSION.SDK_INT > 17) {
            bg.m2604a(f9254a).m2609a(nextInt, a.m2493b());
        }
        return nextInt;
    }

    private static void m16008d(JSONObject jSONObject) {
        C2741k.m15996a(null, false, jSONObject);
    }

    static void m15996a(Context context, boolean z, JSONObject jSONObject) {
        String string;
        String string2;
        int i;
        Notification b;
        if (z) {
            C2741k.m15995a(context);
        }
        String str = null;
        try {
            string = jSONObject.getString("grp");
        } catch (Throwable th) {
            string = str;
        }
        Random random = new Random();
        PendingIntent a = C2741k.m15990a(random.nextInt(), C2741k.m16005c(0).putExtra("summary", string));
        SQLiteDatabase writableDatabase = new af(f9254a).getWritableDatabase();
        Cursor query = writableDatabase.query("notification", new String[]{"android_notification_id", "full_data", "is_summary", "title", "message"}, "group_id = ? AND dismissed = 0 AND opened = 0", new String[]{string}, null, null, "_id DESC");
        int nextInt = random.nextInt();
        String str2 = null;
        Collection arrayList;
        if (query.moveToFirst()) {
            arrayList = new ArrayList();
            do {
                if (query.getInt(query.getColumnIndex("is_summary")) == 1) {
                    nextInt = query.getInt(query.getColumnIndex("android_notification_id"));
                } else {
                    string2 = query.getString(query.getColumnIndex("title"));
                    if (string2 == null) {
                        string2 = "";
                    } else {
                        string2 = string2 + " ";
                    }
                    SpannableString spannableString = new SpannableString(string2 + query.getString(query.getColumnIndex("message")));
                    if (string2.length() > 0) {
                        spannableString.setSpan(new StyleSpan(1), 0, string2.length(), 0);
                    }
                    arrayList.add(spannableString);
                    if (str2 == null) {
                        str2 = query.getString(query.getColumnIndex("full_data"));
                    }
                }
            } while (query.moveToNext());
            if (z) {
                try {
                    i = nextInt;
                    jSONObject = new JSONObject(str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            i = nextInt;
        } else {
            arrayList = null;
            i = nextInt;
        }
        if (r4 == null || (z && r4.size() <= 1)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("android_notification_id", Integer.valueOf(i));
            contentValues.put("group_id", string);
            contentValues.put("is_summary", Integer.valueOf(1));
            writableDatabase.insert("notification", null, contentValues);
            C0326d a2 = C2741k.m15993a(jSONObject, !z);
            PendingIntent a3 = C2741k.m15990a(random.nextInt(), C2741k.m16000b(i).putExtra("onesignal_data", jSONObject.toString()).putExtra("summary", string));
            C2741k.m15997a(jSONObject, a2, i, string);
            a2.m2485a(a3).m2495b(a).m2497b(z).m2491a(string).m2503d(true);
            b = a2.m2493b();
        } else {
            CharSequence charSequence;
            int size = r4.size() + (z ? 0 : 1);
            str2 = null;
            if (jSONObject.has("grp_msg")) {
                try {
                    str2 = jSONObject.getString("grp_msg").replace("$[notif_count]", "" + size);
                } catch (Throwable th2) {
                }
            }
            if (str2 == null) {
                charSequence = size + " new messages";
            } else {
                Object obj = str2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("alert", charSequence);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            PendingIntent a4 = C2741k.m15990a(random.nextInt(), C2741k.m16000b(i).putExtra("summary", string).putExtra("onesignal_data", jSONObject2.toString()));
            C0326d a5 = C2741k.m15993a(jSONObject, !z);
            a5.m2485a(a4).m2495b(a).m2490a(f9254a.getPackageManager().getApplicationLabel(f9254a.getApplicationInfo())).m2496b(charSequence).m2494b(size).m2497b(z).m2491a(string).m2503d(true);
            if (!z) {
                a5.m2499c(charSequence);
            }
            C0323s c0329g = new C0329g();
            str2 = null;
            if (!z) {
                try {
                    str2 = jSONObject.getString("title");
                } catch (Throwable th3) {
                }
                if (str2 == null) {
                    str2 = "";
                } else {
                    str2 = str2 + " ";
                }
                string2 = "";
                try {
                    string2 = jSONObject.getString("alert");
                } catch (Throwable th4) {
                }
                CharSequence spannableString2 = new SpannableString(str2 + string2);
                if (str2.length() > 0) {
                    spannableString2.setSpan(new StyleSpan(1), 0, str2.length(), 0);
                }
                c0329g.m2509b(spannableString2);
            }
            for (SpannableString b2 : r4) {
                c0329g.m2509b(b2);
            }
            c0329g.m2508a(charSequence);
            a5.m2489a(c0329g);
            b = a5.m2493b();
        }
        bg.m2604a(f9254a).m2609a(i, b);
        query.close();
        writableDatabase.close();
    }

    private static boolean m15999a(String str) {
        return (str == null || str.matches("^[0-9]")) ? false : true;
    }

    private static Bitmap m16010e(JSONObject jSONObject) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        Bitmap a = C2741k.m15992a(jSONObject, "licon");
        if (a == null) {
            a = C2741k.m16001b("ic_onesignal_large_icon_default");
        }
        if (a == null) {
            a = C2741k.m16001b("ic_gamethrive_large_icon_default");
        }
        if (a == null) {
            return null;
        }
        try {
            int dimension = (int) f9256c.getDimension(17104902);
            int dimension2 = (int) f9256c.getDimension(17104901);
            int height = a.getHeight();
            int width = a.getWidth();
            if (width > dimension2 || height > dimension) {
                if (height > width) {
                    dimension2 = (int) ((((float) width) / ((float) height)) * ((float) dimension));
                } else if (width > height) {
                    dimension = (int) ((((float) height) / ((float) width)) * ((float) dimension2));
                }
                return Bitmap.createScaledBitmap(a, dimension2, dimension, true);
            }
        } catch (Throwable th) {
        }
        return a;
    }

    private static Bitmap m16001b(String str) {
        Bitmap decodeStream;
        try {
            decodeStream = BitmapFactory.decodeStream(f9254a.getAssets().open(str));
        } catch (Throwable th) {
            decodeStream = null;
        }
        if (decodeStream != null) {
            return decodeStream;
        }
        try {
            Bitmap bitmap = decodeStream;
            for (String str2 : Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"})) {
                try {
                    decodeStream = BitmapFactory.decodeStream(f9254a.getAssets().open(str + str2));
                } catch (Throwable th2) {
                    decodeStream = bitmap;
                }
                if (decodeStream != null) {
                    return decodeStream;
                }
                bitmap = decodeStream;
            }
            int d = C2741k.m16007d(str);
            if (d != 0) {
                return BitmapFactory.decodeResource(f9256c, d);
            }
        } catch (Throwable th3) {
        }
        return null;
    }

    private static Bitmap m16006c(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            return null;
        }
    }

    private static Bitmap m15992a(JSONObject jSONObject, String str) {
        String str2 = null;
        if (!jSONObject.has(str)) {
            return str2;
        }
        try {
            str2 = jSONObject.getString(str);
        } catch (Throwable th) {
        }
        if (str2.startsWith("http://") || str2.startsWith("https://")) {
            return C2741k.m16006c(str2);
        }
        return C2741k.m16001b(str2);
    }

    private static int m16007d(String str) {
        int i = 0;
        if (!C2741k.m15999a(str)) {
            return i;
        }
        int e = C2741k.m16009e(str);
        if (e != 0) {
            return e;
        }
        try {
            return drawable.class.getField(str).getInt(null);
        } catch (Throwable th) {
            return i;
        }
    }

    private static int m16011f(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject.has("sicon")) {
            try {
                i = C2741k.m16007d(jSONObject.getString("sicon"));
            } catch (Throwable th) {
            }
            if (i != 0) {
                return i;
            }
        }
        i = C2741k.m16009e("ic_stat_onesignal_default");
        if (i != 0) {
            return i;
        }
        i = C2741k.m16009e("ic_stat_gamethrive_default");
        if (i != 0) {
            return i;
        }
        i = C2741k.m16009e("corona_statusbar_icon_default");
        if (i != 0) {
            return i;
        }
        i = f9254a.getApplicationInfo().icon;
        return i == 0 ? 17301651 : i;
    }

    private static int m16009e(String str) {
        return f9256c.getIdentifier(str, "drawable", f9255b);
    }

    private static Uri m16012g(JSONObject jSONObject) {
        try {
            String string;
            int identifier;
            if (jSONObject.has("sound")) {
                string = jSONObject.getString("sound");
            } else {
                string = null;
            }
            if (C2741k.m15999a(string)) {
                identifier = f9256c.getIdentifier(string, "raw", f9255b);
                if (identifier != 0) {
                    return Uri.parse("android.resource://" + f9255b + "/" + identifier);
                }
            }
            identifier = f9256c.getIdentifier("onesignal_default_sound", "raw", f9255b);
            if (identifier != 0) {
                return Uri.parse("android.resource://" + f9255b + "/" + identifier);
            }
            identifier = f9256c.getIdentifier("gamethrive_default_sound", "raw", f9255b);
            if (identifier != 0) {
                return Uri.parse("android.resource://" + f9255b + "/" + identifier);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static void m15997a(JSONObject jSONObject, C0326d c0326d, int i, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom"));
            if (jSONObject2.has("a")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
                if (jSONObject3.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("actionButtons");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        int d;
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                        jSONObject3.put("actionSelected", jSONObject4.getString("id"));
                        JSONObject jSONObject5 = new JSONObject(jSONObject.toString());
                        jSONObject5.put("custom", jSONObject2.toString());
                        Intent b = C2741k.m16000b(i);
                        b.setAction("" + i2);
                        b.putExtra("action_button", true);
                        b.putExtra("onesignal_data", jSONObject5.toString());
                        if (str != null) {
                            b.putExtra("summary", str);
                        } else if (jSONObject.has("grp")) {
                            b.putExtra("grp", jSONObject.getString("grp"));
                        }
                        PendingIntent a = C2741k.m15990a(i, b);
                        if (jSONObject4.has("icon")) {
                            d = C2741k.m16007d(jSONObject4.getString("icon"));
                        } else {
                            d = 0;
                        }
                        c0326d.m2483a(d, jSONObject4.getString("text"), a);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void m16003b(JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom"));
            if (jSONObject2.has("a")) {
                jSONObject2 = jSONObject2.getJSONObject("a");
                if (jSONObject2.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("actionButtons");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        list.add(jSONObject3.getString("text"));
                        list2.add(jSONObject3.getString("id"));
                    }
                }
            }
            if (list.size() < 3) {
                list.add("Close");
                list2.add("__DEFAULT__");
            }
        } catch (Throwable e) {
            C2758w.m16058a(C2756d.ERROR, "Failed to parse buttons for alert dialog.", e);
        }
    }
}
