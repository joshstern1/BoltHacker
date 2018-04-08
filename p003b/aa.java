package p003b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface aa extends Closeable, Flushable {
    void mo8a(C1021e c1021e, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;

    ac timeout();
}
