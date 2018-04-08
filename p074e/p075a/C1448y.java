package com.p074e.p075a;

public enum C1448y {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    final int f5533d;

    public static boolean m9190a(int i) {
        return (NO_CACHE.f5533d & i) == 0;
    }

    public static boolean m9191b(int i) {
        return (NO_STORE.f5533d & i) == 0;
    }

    public static boolean m9192c(int i) {
        return (OFFLINE.f5533d & i) != 0;
    }

    private C1448y(int i) {
        this.f5533d = i;
    }
}
