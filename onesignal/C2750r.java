package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2750r {
    public static void m16030a(Context context, Bundle bundle) {
        boolean z = true;
        if (C2758w.m16069a(context, bundle)) {
            boolean z2;
            boolean e = C2758w.m16093e(context);
            boolean z3 = C2758w.f9295d && C2758w.m16081b();
            if (C2758w.m16090d(context) || e || !z3) {
                z2 = true;
            } else {
                z2 = false;
            }
            C2750r.m16033c(bundle);
            C2740j.m15987a(context, bundle, z3);
            if (!C2758w.m16096f(context) && bundle.containsKey("alert") && bundle.getString("alert") != null && !bundle.getString("alert").equals("")) {
                int a;
                if (z2) {
                    if (e && z3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    a = C2741k.m15988a(context, bundle, z3);
                } else {
                    new Thread(new C2751s(bundle)).start();
                    a = -1;
                }
                if (z2) {
                    z = false;
                }
                C2750r.m16031a(context, bundle, z, a);
            }
        }
    }

    private static void m16031a(Context context, Bundle bundle, boolean z, int i) {
        try {
            JSONObject jSONObject = new JSONObject(bundle.getString("custom"));
            SQLiteDatabase writableDatabase = new af(context).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("notification_id", jSONObject.getString("i"));
            if (bundle.containsKey("grp")) {
                contentValues.put("group_id", bundle.getString("grp"));
            }
            contentValues.put("opened", Integer.valueOf(z ? 1 : 0));
            if (!z) {
                contentValues.put("android_notification_id", Integer.valueOf(i));
            }
            if (bundle.containsKey("title")) {
                contentValues.put("title", bundle.getString("title"));
            }
            contentValues.put("message", bundle.getString("alert"));
            contentValues.put("full_data", C2750r.m16032b(bundle).toString());
            writableDatabase.insert("notification", null, contentValues);
            writableDatabase.delete("notification", "created_time < " + ((System.currentTimeMillis() / 1000) - 604800) + " AND " + "(" + "dismissed" + " = 1 OR " + "opened" + " = 1" + ")", null);
            writableDatabase.close();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray m16029a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    public static JSONArray m16028a(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(C2750r.m16032b(bundle));
        return jSONArray;
    }

    public static JSONObject m16032b(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e) {
            }
        }
        return jSONObject;
    }

    private static void m16033c(Bundle bundle) {
        if (bundle.containsKey("o")) {
            try {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject(bundle.getString("custom"));
                if (jSONObject2.has("a")) {
                    jSONObject = jSONObject2.getJSONObject("a");
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(bundle.getString("o"));
                bundle.remove("o");
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object string;
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string2 = jSONObject3.getString("n");
                    jSONObject3.remove("n");
                    if (jSONObject3.has("i")) {
                        string = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        String str = string2;
                    }
                    jSONObject3.put("id", string);
                    jSONObject3.put("text", string2);
                    if (jSONObject3.has("p")) {
                        jSONObject3.put("icon", jSONObject3.getString("p"));
                        jSONObject3.remove("p");
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put("actionSelected", "__DEFAULT__");
                if (!jSONObject2.has("a")) {
                    jSONObject2.put("a", jSONObject);
                }
                bundle.putString("custom", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
