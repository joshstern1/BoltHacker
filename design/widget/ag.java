package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;

final class ag implements Callback {
    ag() {
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                ((Snackbar) message.obj).m1778b();
                return true;
            case 1:
                ((Snackbar) message.obj).m1776a(message.arg1);
                return true;
            default:
                return false;
        }
    }
}
