package p003b;

final class C1037y {
    static C1036x f3993a;
    static long f3994b;

    private C1037y() {
    }

    static C1036x m7474a() {
        synchronized (C1037y.class) {
            if (f3993a != null) {
                C1036x c1036x = f3993a;
                f3993a = c1036x.f3991f;
                c1036x.f3991f = null;
                f3994b -= 8192;
                return c1036x;
            }
            return new C1036x();
        }
    }

    static void m7475a(C1036x c1036x) {
        if (c1036x.f3991f != null || c1036x.f3992g != null) {
            throw new IllegalArgumentException();
        } else if (!c1036x.f3989d) {
            synchronized (C1037y.class) {
                if (f3994b + 8192 > 65536) {
                    return;
                }
                f3994b += 8192;
                c1036x.f3991f = f3993a;
                c1036x.f3988c = 0;
                c1036x.f3987b = 0;
                f3993a = c1036x;
            }
        }
    }
}
