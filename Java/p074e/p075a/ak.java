package com.p074e.p075a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.p074e.p075a.ab.C1406d;
import java.io.IOException;
import java.io.InputStream;

public abstract class ak {

    public static final class C1411a {
        private final C1406d f5400a;
        private final Bitmap f5401b;
        private final InputStream f5402c;
        private final int f5403d;

        public C1411a(Bitmap bitmap, C1406d c1406d) {
            this((Bitmap) as.m9073a((Object) bitmap, "bitmap == null"), null, c1406d, 0);
        }

        public C1411a(InputStream inputStream, C1406d c1406d) {
            this(null, (InputStream) as.m9073a((Object) inputStream, "stream == null"), c1406d, 0);
        }

        C1411a(Bitmap bitmap, InputStream inputStream, C1406d c1406d, int i) {
            int i2;
            int i3 = 1;
            if (bitmap != null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (inputStream == null) {
                i3 = 0;
            }
            if ((i3 ^ i2) == 0) {
                throw new AssertionError();
            }
            this.f5401b = bitmap;
            this.f5402c = inputStream;
            this.f5400a = (C1406d) as.m9073a((Object) c1406d, "loadedFrom == null");
            this.f5403d = i;
        }

        public Bitmap m9027a() {
            return this.f5401b;
        }

        public InputStream m9028b() {
            return this.f5402c;
        }

        public C1406d m9029c() {
            return this.f5400a;
        }

        int m9030d() {
            return this.f5403d;
        }
    }

    public abstract C1411a mo1325a(ah ahVar, int i) throws IOException;

    public abstract boolean mo1326a(ah ahVar);

    int mo1335a() {
        return 0;
    }

    boolean mo1336a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean mo1337b() {
        return false;
    }

    static Options m9034c(ah ahVar) {
        boolean d = ahVar.m9014d();
        Object obj = ahVar.f5385q != null ? 1 : null;
        Options options = null;
        if (d || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = d;
            if (obj != null) {
                options.inPreferredConfig = ahVar.f5385q;
            }
        }
        return options;
    }

    static boolean m9033a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void m9032a(int i, int i2, Options options, ah ahVar) {
        ak.m9031a(i, i2, options.outWidth, options.outHeight, options, ahVar);
    }

    static void m9031a(int i, int i2, int i3, int i4, Options options, ah ahVar) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                i5 = (int) Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor = (int) Math.floor((double) (((float) i3) / ((float) i)));
                if (ahVar.f5379k) {
                    i5 = Math.max(i5, floor);
                } else {
                    i5 = Math.min(i5, floor);
                }
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }
}
