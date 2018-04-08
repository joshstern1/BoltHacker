package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.p044a.p047c.p048a.C1096a;
import java.util.Random;

class C1097w implements C1096a {
    final C1096a f4153a;
    final Random f4154b;
    final double f4155c;

    public C1097w(C1096a c1096a, double d) {
        this(c1096a, d, new Random());
    }

    public C1097w(C1096a c1096a, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (c1096a == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.f4153a = c1096a;
            this.f4155c = d;
            this.f4154b = random;
        }
    }

    public long mo1173a(int i) {
        return (long) (m7685a() * ((double) this.f4153a.mo1173a(i)));
    }

    double m7685a() {
        double d = 1.0d - this.f4155c;
        return d + (((this.f4155c + 1.0d) - d) * this.f4154b.nextDouble());
    }
}
