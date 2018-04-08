package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;

abstract class C0387m extends C0386l {
    boolean f1800a;

    C0387m() {
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws SendIntentException {
        if (!(this.f1800a || i == -1)) {
            C0387m.m2693a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    void b_() {
        super.onBackPressed();
    }

    static void m2693a(int i) {
        if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }
}
