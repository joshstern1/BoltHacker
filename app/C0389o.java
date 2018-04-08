package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;

abstract class C0389o extends C0388n {
    boolean f1801b;

    C0389o() {
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!(this.f1801b || i == -1)) {
            C0387m.m2693a(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (!(this.a || i == -1)) {
            C0387m.m2693a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
