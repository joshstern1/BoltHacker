package com.p074e.p075a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class at extends Handler {
    at(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        sendMessageDelayed(obtainMessage(), 1000);
    }
}
