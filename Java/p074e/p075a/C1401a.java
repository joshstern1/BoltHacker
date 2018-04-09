package com.p074e.p075a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ab.C1407e;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class C1401a<T> {
    final ab f5290a;
    final ah f5291b;
    final WeakReference<T> f5292c;
    final boolean f5293d;
    final int f5294e;
    final int f5295f;
    final int f5296g;
    final Drawable f5297h;
    final String f5298i;
    final Object f5299j;
    boolean f5300k;
    boolean f5301l;

    static class C1400a<M> extends WeakReference<M> {
        final C1401a f5289a;

        public C1400a(C1401a c1401a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f5289a = c1401a;
        }
    }

    abstract void mo1332a();

    abstract void mo1333a(Bitmap bitmap, C1406d c1406d);

    C1401a(ab abVar, T t, ah ahVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f5290a = abVar;
        this.f5291b = ahVar;
        this.f5292c = t == null ? null : new C1400a(this, t, abVar.f5333i);
        this.f5294e = i;
        this.f5295f = i2;
        this.f5293d = z;
        this.f5296g = i3;
        this.f5297h = drawable;
        this.f5298i = str;
        if (obj == null) {
            C1401a c1401a = this;
        }
        this.f5299j = obj;
    }

    void mo1334b() {
        this.f5301l = true;
    }

    ah m8965c() {
        return this.f5291b;
    }

    T m8966d() {
        return this.f5292c == null ? null : this.f5292c.get();
    }

    String m8967e() {
        return this.f5298i;
    }

    boolean m8968f() {
        return this.f5301l;
    }

    boolean m8969g() {
        return this.f5300k;
    }

    int m8970h() {
        return this.f5294e;
    }

    int m8971i() {
        return this.f5295f;
    }

    ab m8972j() {
        return this.f5290a;
    }

    C1407e m8973k() {
        return this.f5291b.f5386r;
    }

    Object m8974l() {
        return this.f5299j;
    }
}
