package com.p074e.p075a;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.p074e.p075a.ab.C1407e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class ah {
    private static final long f5368s = TimeUnit.SECONDS.toNanos(5);
    int f5369a;
    long f5370b;
    int f5371c;
    public final Uri f5372d;
    public final int f5373e;
    public final String f5374f;
    public final List<ap> f5375g;
    public final int f5376h;
    public final int f5377i;
    public final boolean f5378j;
    public final boolean f5379k;
    public final boolean f5380l;
    public final float f5381m;
    public final float f5382n;
    public final float f5383o;
    public final boolean f5384p;
    public final Config f5385q;
    public final C1407e f5386r;

    public static final class C1410a {
        private Uri f5353a;
        private int f5354b;
        private String f5355c;
        private int f5356d;
        private int f5357e;
        private boolean f5358f;
        private boolean f5359g;
        private boolean f5360h;
        private float f5361i;
        private float f5362j;
        private float f5363k;
        private boolean f5364l;
        private List<ap> f5365m;
        private Config f5366n;
        private C1407e f5367o;

        C1410a(Uri uri, int i, Config config) {
            this.f5353a = uri;
            this.f5354b = i;
            this.f5366n = config;
        }

        boolean m9007a() {
            return (this.f5353a == null && this.f5354b == 0) ? false : true;
        }

        boolean m9008b() {
            return (this.f5356d == 0 && this.f5357e == 0) ? false : true;
        }

        public C1410a m9005a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f5356d = i;
                this.f5357e = i2;
                return this;
            }
        }

        public C1410a m9009c() {
            if (this.f5359g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f5358f = true;
            return this;
        }

        public C1410a m9006a(ap apVar) {
            if (apVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (apVar.mo2294a() == null) {
                throw new IllegalArgumentException("Transformation key must not be null.");
            } else {
                if (this.f5365m == null) {
                    this.f5365m = new ArrayList(2);
                }
                this.f5365m.add(apVar);
                return this;
            }
        }

        public ah m9010d() {
            if (this.f5359g && this.f5358f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f5358f && this.f5356d == 0 && this.f5357e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (this.f5359g && this.f5356d == 0 && this.f5357e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.f5367o == null) {
                    this.f5367o = C1407e.NORMAL;
                }
                return new ah(this.f5353a, this.f5354b, this.f5355c, this.f5365m, this.f5356d, this.f5357e, this.f5358f, this.f5359g, this.f5360h, this.f5361i, this.f5362j, this.f5363k, this.f5364l, this.f5366n, this.f5367o);
            }
        }
    }

    private ah(Uri uri, int i, String str, List<ap> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Config config, C1407e c1407e) {
        this.f5372d = uri;
        this.f5373e = i;
        this.f5374f = str;
        if (list == null) {
            this.f5375g = null;
        } else {
            this.f5375g = Collections.unmodifiableList(list);
        }
        this.f5376h = i2;
        this.f5377i = i3;
        this.f5378j = z;
        this.f5379k = z2;
        this.f5380l = z3;
        this.f5381m = f;
        this.f5382n = f2;
        this.f5383o = f3;
        this.f5384p = z4;
        this.f5385q = config;
        this.f5386r = c1407e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.f5373e > 0) {
            stringBuilder.append(this.f5373e);
        } else {
            stringBuilder.append(this.f5372d);
        }
        if (!(this.f5375g == null || this.f5375g.isEmpty())) {
            for (ap a : this.f5375g) {
                stringBuilder.append(' ').append(a.mo2294a());
            }
        }
        if (this.f5374f != null) {
            stringBuilder.append(" stableKey(").append(this.f5374f).append(')');
        }
        if (this.f5376h > 0) {
            stringBuilder.append(" resize(").append(this.f5376h).append(',').append(this.f5377i).append(')');
        }
        if (this.f5378j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.f5379k) {
            stringBuilder.append(" centerInside");
        }
        if (this.f5381m != 0.0f) {
            stringBuilder.append(" rotation(").append(this.f5381m);
            if (this.f5384p) {
                stringBuilder.append(" @ ").append(this.f5382n).append(',').append(this.f5383o);
            }
            stringBuilder.append(')');
        }
        if (this.f5385q != null) {
            stringBuilder.append(' ').append(this.f5385q);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    String m9011a() {
        long nanoTime = System.nanoTime() - this.f5370b;
        if (nanoTime > f5368s) {
            return m9012b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return m9012b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    String m9012b() {
        return "[R" + this.f5369a + ']';
    }

    String m9013c() {
        if (this.f5372d != null) {
            return String.valueOf(this.f5372d.getPath());
        }
        return Integer.toHexString(this.f5373e);
    }

    public boolean m9014d() {
        return (this.f5376h == 0 && this.f5377i == 0) ? false : true;
    }

    boolean m9015e() {
        return m9016f() || m9017g();
    }

    boolean m9016f() {
        return m9014d() || this.f5381m != 0.0f;
    }

    boolean m9017g() {
        return this.f5375g != null;
    }
}
