package p003b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class C1029q {
    static final Logger f3973a = Logger.getLogger(C1029q.class.getName());

    private C1029q() {
    }

    public static C1020i m7427a(ab abVar) {
        return new C1034v(abVar);
    }

    public static C1019h m7426a(aa aaVar) {
        return new C1033u(aaVar);
    }

    public static aa m7420a(OutputStream outputStream) {
        return C1029q.m7421a(outputStream, new ac());
    }

    private static aa m7421a(OutputStream outputStream, ac acVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (acVar != null) {
            return new C1030r(acVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static aa m7422a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        ac c = C1029q.m7431c(socket);
        return c.m330a(C1029q.m7421a(socket.getOutputStream(), c));
    }

    public static ab m7424a(InputStream inputStream) {
        return C1029q.m7425a(inputStream, new ac());
    }

    private static ab m7425a(InputStream inputStream, ac acVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (acVar != null) {
            return new C1031s(acVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static ab m7423a(File file) throws FileNotFoundException {
        if (file != null) {
            return C1029q.m7424a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static aa m7429b(File file) throws FileNotFoundException {
        if (file != null) {
            return C1029q.m7420a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static aa m7432c(File file) throws FileNotFoundException {
        if (file != null) {
            return C1029q.m7420a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static ab m7430b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        ac c = C1029q.m7431c(socket);
        return c.m331a(C1029q.m7425a(socket.getInputStream(), c));
    }

    private static C0051a m7431c(Socket socket) {
        return new C1032t(socket);
    }

    static boolean m7428a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
