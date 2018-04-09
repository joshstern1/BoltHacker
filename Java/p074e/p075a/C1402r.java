package com.p074e.p075a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface C1402r {

    public static class C1439a {
        final InputStream f5498a;
        final Bitmap f5499b;
        final boolean f5500c;
        final long f5501d;

        public C1439a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f5498a = inputStream;
            this.f5499b = null;
            this.f5500c = z;
            this.f5501d = j;
        }

        public InputStream m9165a() {
            return this.f5498a;
        }

        @Deprecated
        public Bitmap m9166b() {
            return this.f5499b;
        }

        public long m9167c() {
            return this.f5501d;
        }
    }

    public static class C1440b extends IOException {
        final boolean f5502a;
        final int f5503b;

        public C1440b(String str, int i, int i2) {
            super(str);
            this.f5502a = C1448y.m9192c(i);
            this.f5503b = i2;
        }
    }

    C1439a mo1323a(Uri uri, int i) throws IOException;
}
