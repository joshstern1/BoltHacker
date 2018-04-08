package android.support.v4.p021b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class C0430j extends Handler {
    final /* synthetic */ C0429i f1892a;

    C0430j(C0429i c0429i, Looper looper) {
        this.f1892a = c0429i;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f1892a.m2925a();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
