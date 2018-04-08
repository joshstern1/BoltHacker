package org.p070a;

import java.net.InetSocketAddress;
import org.p070a.p126d.C3135d;

public interface C1375a {

    public enum C3115a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public enum C3116b {
        CLIENT,
        SERVER
    }

    InetSocketAddress mo1296a();

    void mo1303a(C3135d c3135d);
}
