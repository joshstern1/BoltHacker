package android.support.v4.p024g;

import android.util.Log;
import java.io.Writer;

public class C0500e extends Writer {
    private final String f1950a;
    private StringBuilder f1951b = new StringBuilder(128);

    public C0500e(String str) {
        this.f1950a = str;
    }

    public void close() {
        m3139a();
    }

    public void flush() {
        m3139a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m3139a();
            } else {
                this.f1951b.append(c);
            }
        }
    }

    private void m3139a() {
        if (this.f1951b.length() > 0) {
            Log.d(this.f1950a, this.f1951b.toString());
            this.f1951b.delete(0, this.f1951b.length());
        }
    }
}
