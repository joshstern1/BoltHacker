package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.C2720a.C2717a;
import com.onesignal.C2739i.C2735a;

public class PermissionsActivity extends Activity {
    static boolean f9166a;
    static boolean f9167b;
    private static C2717a f9168c;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m15848b();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m15848b();
    }

    private void m15848b() {
        if (!f9166a) {
            f9166a = true;
            C2735a.m15983a(this, new String[]{C2748p.f9269a}, 2);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        f9167b = true;
        f9166a = false;
        if (i == 2) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                C2748p.m16023b();
            } else {
                C2748p.m16020a();
            }
        }
        C2720a.m15865b(f9168c);
        finish();
    }

    static void m15847a() {
        if (!f9166a && !f9167b) {
            f9168c = new an();
            C2720a.m15862a(f9168c);
        }
    }
}
