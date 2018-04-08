package com.onesignal;

import android.os.Bundle;
import java.util.ArrayList;
import org.json.JSONObject;

class bb implements Runnable {
    final /* synthetic */ az f9244a;

    bb(az azVar) {
        this.f9244a = azVar;
    }

    public void run() {
        this.f9244a.f9242k = true;
        try {
            if (this.f9244a.f9236e == null) {
                this.f9244a.f9236e = az.m15966d(az.f9233c);
                this.f9244a.f9236e.setAccessible(true);
            }
            Bundle bundle = (Bundle) this.f9244a.f9236e.invoke(this.f9244a.f9235d, new Object[]{Integer.valueOf(3), this.f9244a.f9238g.getPackageName(), "inapp", null});
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str = (String) stringArrayList.get(i);
                    String string = new JSONObject((String) stringArrayList2.get(i)).getString("purchaseToken");
                    if (!(this.f9244a.f9239h.contains(string) || arrayList2.contains(string))) {
                        arrayList2.add(string);
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    this.f9244a.m15955a(arrayList, arrayList2);
                } else if (stringArrayList2.size() == 0) {
                    this.f9244a.f9241j = false;
                    this.f9244a.f9240i.putBoolean("ExistingPurchases", false);
                    this.f9244a.f9240i.commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f9244a.f9242k = false;
    }
}
