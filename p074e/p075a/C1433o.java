package com.p074e.p075a;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class C1433o implements OnPreDrawListener {
    final aj f5475a;
    final WeakReference<ImageView> f5476b;
    C1429l f5477c;

    C1433o(aj ajVar, ImageView imageView, C1429l c1429l) {
        this.f5475a = ajVar;
        this.f5476b = new WeakReference(imageView);
        this.f5477c = c1429l;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f5476b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    this.f5475a.m9025b().m9021a(width, height).m9024a(imageView, this.f5477c);
                }
            }
        }
        return true;
    }

    void m9140a() {
        this.f5477c = null;
        ImageView imageView = (ImageView) this.f5476b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }
}
