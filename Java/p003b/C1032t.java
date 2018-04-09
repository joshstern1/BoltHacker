package p003b;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

final class C1032t extends C0051a {
    final /* synthetic */ Socket f3978a;

    C1032t(Socket socket) {
        this.f3978a = socket;
    }

    protected IOException mo48a(IOException iOException) {
        IOException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    protected void mo49a() {
        try {
            this.f3978a.close();
        } catch (Throwable e) {
            C1029q.f3973a.log(Level.WARNING, "Failed to close timed out socket " + this.f3978a, e);
        } catch (AssertionError e2) {
            if (C1029q.m7428a(e2)) {
                C1029q.f3973a.log(Level.WARNING, "Failed to close timed out socket " + this.f3978a, e2);
                return;
            }
            throw e2;
        }
    }
}
