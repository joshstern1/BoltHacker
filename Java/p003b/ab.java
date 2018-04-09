package p003b;

import java.io.Closeable;
import java.io.IOException;

public interface ab extends Closeable {
    void close() throws IOException;

    long read(C1021e c1021e, long j) throws IOException;

    ac timeout();
}
