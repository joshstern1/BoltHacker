package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;
import android.support.design.widget.ap.C0256b;

class aq implements Callback {
    final /* synthetic */ ap f1294a;

    aq(ap apVar) {
        this.f1294a = apVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f1294a.m1958b((C0256b) message.obj);
                return true;
            default:
                return false;
        }
    }
}
