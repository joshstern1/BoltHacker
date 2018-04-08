package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.bg;
import com.onesignal.C2758w.C2756d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2753u {
    private static Context f9275a;
    private static Intent f9276b;

    public static void m16035a(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            bg.m2604a(context).m2608a(intent.getIntExtra("notificationId", 0));
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
        C2753u.m16038b(context, intent);
    }

    static void m16038b(Context context, Intent intent) {
        JSONArray a;
        f9275a = context;
        f9276b = intent;
        String stringExtra = f9276b.getStringExtra("summary");
        boolean booleanExtra = f9276b.getBooleanExtra("dismissed", false);
        SQLiteDatabase writableDatabase = new af(f9275a).getWritableDatabase();
        if (!booleanExtra) {
            try {
                a = C2750r.m16029a(new JSONObject(f9276b.getStringExtra("onesignal_data")));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!(booleanExtra || stringExtra == null)) {
                C2753u.m16037a(a, stringExtra, writableDatabase);
            }
            C2753u.m16036a(writableDatabase);
            if (stringExtra == null && f9276b.getStringExtra("grp") != null) {
                C2753u.m16039b(writableDatabase);
            }
            writableDatabase.close();
            if (!booleanExtra) {
                C2758w.m16053a(f9275a, a, intent.getBooleanExtra("from_alert", false));
            }
        }
        a = null;
        C2753u.m16037a(a, stringExtra, writableDatabase);
        C2753u.m16036a(writableDatabase);
        C2753u.m16039b(writableDatabase);
        writableDatabase.close();
        if (!booleanExtra) {
            C2758w.m16053a(f9275a, a, intent.getBooleanExtra("from_alert", false));
        }
    }

    private static void m16037a(JSONArray jSONArray, String str, SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("notification", new String[]{"full_data"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, null, null, null);
        if (query.getCount() > 1) {
            query.moveToFirst();
            do {
                try {
                    jSONArray.put(new JSONObject(query.getString(query.getColumnIndex("full_data"))));
                } catch (Throwable th) {
                    C2758w.m16057a(C2756d.ERROR, "Could not parse JSON of sub notification in group: " + str);
                }
            } while (query.moveToNext());
        }
        query.close();
    }

    private static void m16036a(SQLiteDatabase sQLiteDatabase) {
        String str;
        String[] strArr = null;
        if (f9276b.getStringExtra("summary") != null) {
            str = "group_id = ?";
            strArr = new String[]{f9276b.getStringExtra("summary")};
        } else {
            str = "android_notification_id = " + f9276b.getIntExtra("notificationId", 0);
        }
        sQLiteDatabase.update("notification", C2753u.m16034a(), str, strArr);
    }

    private static void m16039b(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("notification", new String[]{"android_notification_id"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{f9276b.getStringExtra("grp")}, null, null, null);
        if (query.getCount() == 0) {
            sQLiteDatabase.update("notification", C2753u.m16034a(), "group_id = ?", new String[]{r8});
        } else {
            try {
                C2741k.m15996a(f9275a, true, new JSONObject("{\"grp\": \"" + r8 + "\"}"));
            } catch (JSONException e) {
            }
        }
        query.close();
    }

    private static ContentValues m16034a() {
        ContentValues contentValues = new ContentValues();
        if (f9276b.getBooleanExtra("dismissed", false)) {
            contentValues.put("dismissed", Integer.valueOf(1));
        } else {
            contentValues.put("opened", Integer.valueOf(1));
        }
        return contentValues;
    }
}
