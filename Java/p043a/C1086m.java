package com.p041a.p042a.p043a;

import android.app.Activity;
import android.os.Bundle;
import com.p041a.p042a.p043a.ae.C1071b;
import io.p038b.p039a.p040a.C3054a.C1085b;

class C1086m extends C1085b {
    private final ac f4128a;
    private final C1089p f4129b;

    public C1086m(ac acVar, C1089p c1089p) {
        this.f4128a = acVar;
        this.f4129b = c1089p;
    }

    public void mo1160a(Activity activity, Bundle bundle) {
    }

    public void mo1159a(Activity activity) {
        this.f4128a.m7587a(activity, C1071b.START);
    }

    public void mo1161b(Activity activity) {
        this.f4128a.m7587a(activity, C1071b.RESUME);
        this.f4129b.m7663a();
    }

    public void mo1163c(Activity activity) {
        this.f4128a.m7587a(activity, C1071b.PAUSE);
        this.f4129b.m7666b();
    }

    public void mo1164d(Activity activity) {
        this.f4128a.m7587a(activity, C1071b.STOP);
    }

    public void mo1162b(Activity activity, Bundle bundle) {
    }

    public void mo1165e(Activity activity) {
    }
}
