package com.p074e.p075a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class ac extends Handler {
    ac(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        List list;
        int size;
        int i;
        switch (message.what) {
            case 3:
                C1401a c1401a = (C1401a) message.obj;
                if (c1401a.m8972j().f5336l) {
                    as.m9082a("Main", "canceled", c1401a.f5291b.m9011a(), "target got garbage collected");
                }
                c1401a.f5290a.m8984a(c1401a.m8966d());
                return;
            case 8:
                list = (List) message.obj;
                size = list.size();
                for (i = 0; i < size; i++) {
                    C1420c c1420c = (C1420c) list.get(i);
                    c1420c.f5448b.m8993a(c1420c);
                }
                return;
            case 13:
                list = (List) message.obj;
                size = list.size();
                for (i = 0; i < size; i++) {
                    C1401a c1401a2 = (C1401a) list.get(i);
                    c1401a2.f5290a.m8996c(c1401a2);
                }
                return;
            default:
                throw new AssertionError("Unknown handler message received: " + message.what);
        }
    }
}
