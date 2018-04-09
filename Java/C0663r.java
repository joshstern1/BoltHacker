package android.support.v4.view;

import android.support.v4.view.C0662q.C0661a;
import android.view.LayoutInflater;

class C0663r {
    static void m4330a(LayoutInflater layoutInflater, C0403s c0403s) {
        layoutInflater.setFactory2(c0403s != null ? new C0661a(c0403s) : null);
    }
}
