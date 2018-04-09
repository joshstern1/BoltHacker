package com.p074e.p075a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ah.C1410a;
import java.util.concurrent.atomic.AtomicInteger;

public class aj {
    private static final AtomicInteger f5387a = new AtomicInteger();
    private final ab f5388b;
    private final C1410a f5389c;
    private boolean f5390d;
    private boolean f5391e;
    private boolean f5392f;
    private int f5393g;
    private int f5394h;
    private int f5395i;
    private int f5396j;
    private Drawable f5397k;
    private Drawable f5398l;
    private Object f5399m;

    aj(ab abVar, Uri uri, int i) {
        this.f5392f = true;
        if (abVar.f5337m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f5388b = abVar;
        this.f5389c = new C1410a(uri, i, abVar.f5334j);
    }

    aj() {
        this.f5392f = true;
        this.f5388b = null;
        this.f5389c = new C1410a(null, 0, null);
    }

    public aj m9020a() {
        this.f5391e = true;
        return this;
    }

    aj m9025b() {
        this.f5391e = false;
        return this;
    }

    public aj m9021a(int i, int i2) {
        this.f5389c.m9005a(i, i2);
        return this;
    }

    public aj m9026c() {
        this.f5389c.m9009c();
        return this;
    }

    public aj m9022a(ap apVar) {
        this.f5389c.m9006a(apVar);
        return this;
    }

    public void m9023a(ImageView imageView) {
        m9024a(imageView, null);
    }

    public void m9024a(ImageView imageView, C1429l c1429l) {
        long nanoTime = System.nanoTime();
        as.m9078a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.f5389c.m9007a()) {
            if (this.f5391e) {
                if (this.f5389c.m9008b()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width == 0 || height == 0) {
                    if (this.f5392f) {
                        af.m9001a(imageView, m9019d());
                    }
                    this.f5388b.m8991a(imageView, new C1433o(this, imageView, c1429l));
                    return;
                }
                this.f5389c.m9005a(width, height);
            }
            ah a = m9018a(nanoTime);
            String a2 = as.m9074a(a);
            if (C1447x.m9188a(this.f5395i)) {
                Bitmap a3 = this.f5388b.m8985a(a2);
                if (a3 != null) {
                    this.f5388b.m8990a(imageView);
                    af.m9000a(imageView, this.f5388b.f5327c, a3, C1406d.MEMORY, this.f5390d, this.f5388b.f5335k);
                    if (this.f5388b.f5336l) {
                        as.m9082a("Main", "completed", a.m9012b(), "from " + C1406d.MEMORY);
                    }
                    if (c1429l != null) {
                        c1429l.m9131a();
                        return;
                    }
                    return;
                }
            }
            if (this.f5392f) {
                af.m9001a(imageView, m9019d());
            }
            this.f5388b.m8992a(new C1442t(this.f5388b, imageView, a, this.f5395i, this.f5396j, this.f5394h, this.f5398l, a2, this.f5399m, c1429l, this.f5390d));
        } else {
            this.f5388b.m8990a(imageView);
            if (this.f5392f) {
                af.m9001a(imageView, m9019d());
            }
        }
    }

    private Drawable m9019d() {
        if (this.f5393g != 0) {
            return this.f5388b.f5327c.getResources().getDrawable(this.f5393g);
        }
        return this.f5397k;
    }

    private ah m9018a(long j) {
        int andIncrement = f5387a.getAndIncrement();
        ah d = this.f5389c.m9010d();
        d.f5369a = andIncrement;
        d.f5370b = j;
        boolean z = this.f5388b.f5336l;
        if (z) {
            as.m9082a("Main", "created", d.m9012b(), d.toString());
        }
        ah a = this.f5388b.m8986a(d);
        if (a != d) {
            a.f5369a = andIncrement;
            a.f5370b = j;
            if (z) {
                as.m9082a("Main", "changed", a.m9011a(), "into " + a);
            }
        }
        return a;
    }
}
