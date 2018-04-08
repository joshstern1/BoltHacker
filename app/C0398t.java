package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

class C0398t extends Handler {
    final /* synthetic */ C0397s f1836a;

    C0398t(C0397s c0397s) {
        this.f1836a = c0397s;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f1836a.f1830g) {
                    this.f1836a.m2756a(false);
                    return;
                }
                return;
            case 2:
                this.f1836a.a_();
                this.f1836a.f1827d.m2789n();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
