package org.p070a.p126d;

import java.nio.ByteBuffer;

public interface C3135d {

    public enum C3140a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    ByteBuffer mo2543c();

    boolean mo2544d();

    boolean mo2545e();

    C3140a mo2546f();
}
