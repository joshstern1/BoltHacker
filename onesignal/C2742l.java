package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class C2742l implements Runnable {
    final /* synthetic */ Activity f9259a;
    final /* synthetic */ JSONObject f9260b;
    final /* synthetic */ int f9261c;

    C2742l(Activity activity, JSONObject jSONObject, int i) {
        this.f9259a = activity;
        this.f9260b = jSONObject;
        this.f9261c = i;
    }

    public void run() {
        Builder builder = new Builder(this.f9259a);
        builder.setTitle(C2741k.m16002b(this.f9260b));
        try {
            builder.setMessage(this.f9260b.getString("alert"));
        } catch (Throwable th) {
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        C2741k.m16003b(this.f9260b, arrayList, arrayList2);
        Intent a = C2741k.m16000b(this.f9261c);
        a.putExtra("action_button", true);
        a.putExtra("from_alert", true);
        a.putExtra("onesignal_data", this.f9260b.toString());
        try {
            if (this.f9260b.has("grp")) {
                a.putExtra("grp", this.f9260b.getString("grp"));
            }
        } catch (JSONException e) {
        }
        OnClickListener c2743m = new C2743m(this, arrayList2, a);
        builder.setOnCancelListener(new C2744n(this, a));
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                builder.setNeutralButton((CharSequence) arrayList.get(i), c2743m);
            } else if (i == 1) {
                builder.setNegativeButton((CharSequence) arrayList.get(i), c2743m);
            } else if (i == 2) {
                builder.setPositiveButton((CharSequence) arrayList.get(i), c2743m);
            }
        }
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }
}
