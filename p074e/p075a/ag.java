package com.p074e.p075a;

import android.net.NetworkInfo;
import com.p074e.p075a.ab.C1407e;
import com.p074e.p075a.as.C1418e;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ag extends ThreadPoolExecutor {

    private static final class C1409a extends FutureTask<C1420c> implements Comparable<C1409a> {
        private final C1420c f5352a;

        public /* synthetic */ int compareTo(Object obj) {
            return m9002a((C1409a) obj);
        }

        public C1409a(C1420c c1420c) {
            super(c1420c, null);
            this.f5352a = c1420c;
        }

        public int m9002a(C1409a c1409a) {
            C1407e n = this.f5352a.m9117n();
            C1407e n2 = c1409a.f5352a.m9117n();
            return n == n2 ? this.f5352a.f5447a - c1409a.f5352a.f5447a : n2.ordinal() - n.ordinal();
        }
    }

    ag() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1418e());
    }

    void m9004a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m9003a(3);
            return;
        }
        switch (networkInfo.getType()) {
            case 0:
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        m9003a(1);
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 12:
                        m9003a(2);
                        return;
                    case 13:
                    case 14:
                    case 15:
                        m9003a(3);
                        return;
                    default:
                        m9003a(3);
                        return;
                }
            case 1:
            case 6:
            case 9:
                m9003a(4);
                return;
            default:
                m9003a(3);
                return;
        }
    }

    private void m9003a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public Future<?> submit(Runnable runnable) {
        Object c1409a = new C1409a((C1420c) runnable);
        execute(c1409a);
        return c1409a;
    }
}
