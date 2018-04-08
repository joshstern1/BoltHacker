package org.p070a.p124b;

import org.p070a.p124b.C3121a.C3120b;
import org.p070a.p125c.C3130d;
import org.p070a.p127e.C3142a;
import org.p070a.p127e.C3144b;

public class C3124c extends C3123b {
    public C3120b mo2530a(C3142a c3142a) throws C3130d {
        if (C3123b.m17541b(c3142a) == 13) {
            return C3120b.MATCHED;
        }
        return C3120b.NOT_MATCHED;
    }

    public C3144b mo2532a(C3144b c3144b) {
        super.mo2532a(c3144b);
        c3144b.mo2550a("Sec-WebSocket-Version", "13");
        return c3144b;
    }

    public C3121a mo2537c() {
        return new C3124c();
    }
}
