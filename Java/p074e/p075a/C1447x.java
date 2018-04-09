package com.p074e.p075a;

public enum C1447x {
    NO_CACHE(1),
    NO_STORE(2);
    
    final int f5528c;

    static boolean m9188a(int i) {
        return (NO_CACHE.f5528c & i) == 0;
    }

    static boolean m9189b(int i) {
        return (NO_STORE.f5528c & i) == 0;
    }

    private C1447x(int i) {
        this.f5528c = i;
    }
}
