package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.C2758w.C2756d;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class az {
    private static int f9232a = -99;
    private static Class<?> f9233c;
    private ServiceConnection f9234b;
    private Object f9235d;
    private Method f9236e;
    private Method f9237f;
    private Context f9238g;
    private ArrayList<String> f9239h;
    private Editor f9240i;
    private boolean f9241j = true;
    private boolean f9242k = false;

    az(Context context) {
        boolean z = true;
        this.f9238g = context;
        SharedPreferences sharedPreferences = this.f9238g.getSharedPreferences("GTPlayerPurchases", 0);
        this.f9240i = sharedPreferences.edit();
        this.f9239h = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString("purchaseTokens", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f9239h.add(jSONArray.get(i).toString());
            }
            if (jSONArray.length() != 0) {
                z = false;
            }
            this.f9241j = z;
            if (this.f9241j) {
                this.f9241j = sharedPreferences.getBoolean("ExistingPurchases", true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m15971a();
    }

    static boolean m15956a(Context context) {
        if (f9232a == -99) {
            f9232a = context.checkCallingOrSelfPermission("com.android.vending.BILLING");
        }
        try {
            if (f9232a == 0) {
                f9233c = Class.forName("com.android.vending.billing.IInAppBillingService");
            }
            if (f9232a == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            f9232a = 0;
            return false;
        }
    }

    void m15971a() {
        if (this.f9234b == null) {
            this.f9234b = new ba(this);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this.f9238g.bindService(intent, this.f9234b, 1);
        } else if (this.f9235d != null) {
            m15964c();
        }
    }

    private void m15964c() {
        if (!this.f9242k) {
            new Thread(new bb(this)).start();
        }
    }

    private void m15955a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        try {
            if (this.f9237f == null) {
                this.f9237f = m15967e(f9233c);
                this.f9237f.setAccessible(true);
            }
            new Bundle().putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle bundle = (Bundle) this.f9237f.invoke(this.f9235d, new Object[]{Integer.valueOf(3), this.f9238g.getPackageName(), "inapp", bundle});
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                String string;
                ArrayList stringArrayList = bundle.getStringArrayList("DETAILS_LIST");
                Map hashMap = new HashMap();
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject((String) it.next());
                    string = jSONObject.getString("productId");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sku", string);
                    jSONObject2.put("iso", jSONObject.getString("price_currency_code"));
                    jSONObject2.put("amount", divide.toString());
                    hashMap.put(string, jSONObject2);
                }
                JSONArray jSONArray = new JSONArray();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    string = (String) it2.next();
                    if (hashMap.containsKey(string)) {
                        jSONArray.put(hashMap.get(string));
                    }
                }
                if (jSONArray.length() > 0) {
                    C2758w.m16056a(new bc(this, jSONArray, arrayList2));
                }
            }
        } catch (Throwable th) {
            C2758w.m16058a(C2756d.WARN, "Failed to track IAP purchases", th);
        }
    }

    private static Method m15963c(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == IBinder.class) {
                return method;
            }
        }
        return null;
    }

    private static Method m15966d(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == String.class) {
                return method;
            }
        }
        return null;
    }

    private static Method m15967e(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == Bundle.class) {
                return method;
            }
        }
        return null;
    }
}
