package p003b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class ac {
    public static final ac f223b = new ad();
    private boolean f224a;
    private long f225c;
    private long f226d;

    public ac mo1091a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.f226d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long p_() {
        return this.f226d;
    }

    public boolean q_() {
        return this.f224a;
    }

    public long mo1123d() {
        if (this.f224a) {
            return this.f225c;
        }
        throw new IllegalStateException("No deadline");
    }

    public ac mo1090a(long j) {
        this.f224a = true;
        this.f225c = j;
        return this;
    }

    public ac r_() {
        this.f226d = 0;
        return this;
    }

    public ac mo1124f() {
        this.f224a = false;
        return this;
    }

    public void mo1092g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f224a && this.f225c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
