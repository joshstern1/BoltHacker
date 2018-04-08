package com.onesignal;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.onesignal.C2758w.C2756d;
import com.onesignal.ao.C2724a;

class aq implements Runnable {
    final /* synthetic */ Context f9210a;
    final /* synthetic */ C2724a f9211b;
    final /* synthetic */ ap f9212c;

    aq(ap apVar, Context context, C2724a c2724a) {
        this.f9212c = apVar;
        this.f9210a = context;
        this.f9211b = c2724a;
    }

    public void run() {
        ADM adm = new ADM(this.f9210a);
        String registrationId = adm.getRegistrationId();
        if (registrationId == null) {
            adm.startRegister();
        } else {
            C2758w.m16057a(C2756d.DEBUG, "ADM Already registed with ID:" + registrationId);
            this.f9211b.mo2316a(registrationId);
        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
        }
        if (!ap.f9209b) {
            C2758w.m16057a(C2756d.ERROR, "com.onesignal.ADMMessageHandler timed out, please check that your have the reciever, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions.");
            ap.m15935a(null);
        }
    }
}
