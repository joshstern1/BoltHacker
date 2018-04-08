package com.p074e.p075a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p074e.p075a.ab.C1406d;

class C1442t extends C1401a<ImageView> {
    C1429l f5504m;

    C1442t(ab abVar, ImageView imageView, ah ahVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, C1429l c1429l, boolean z) {
        super(abVar, imageView, ahVar, i, i2, i3, drawable, str, obj, z);
        this.f5504m = c1429l;
    }

    public void mo1333a(Bitmap bitmap, C1406d c1406d) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            C1406d c1406d2 = c1406d;
            af.m9000a(imageView, this.a.f5327c, bitmap2, c1406d2, this.d, this.a.f5335k);
            if (this.f5504m != null) {
                this.f5504m.m9131a();
            }
        }
    }

    public void mo1332a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.g != 0) {
                imageView.setImageResource(this.g);
            } else if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
            if (this.f5504m != null) {
                this.f5504m.m9132b();
            }
        }
    }

    void mo1334b() {
        super.mo1334b();
        if (this.f5504m != null) {
            this.f5504m = null;
        }
    }
}
