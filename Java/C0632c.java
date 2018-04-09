package android.support.v4.view;

import android.support.v4.view.C0249b.C0596a;
import android.support.v4.view.C0635e.C0631a;
import android.support.v4.view.p025a.C0547e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0632c implements C0631a {
    final /* synthetic */ C0249b f2141a;
    final /* synthetic */ C0596a f2142b;

    C0632c(C0596a c0596a, C0249b c0249b) {
        this.f2142b = c0596a;
        this.f2141a = c0249b;
    }

    public boolean mo621a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2141a.mo667d(view, accessibilityEvent);
    }

    public void mo623b(View view, AccessibilityEvent accessibilityEvent) {
        this.f2141a.mo220a(view, accessibilityEvent);
    }

    public void mo620a(View view, Object obj) {
        this.f2141a.mo219a(view, new C0547e(obj));
    }

    public void mo624c(View view, AccessibilityEvent accessibilityEvent) {
        this.f2141a.mo221b(view, accessibilityEvent);
    }

    public boolean mo622a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2141a.mo666a(viewGroup, view, accessibilityEvent);
    }

    public void mo619a(View view, int i) {
        this.f2141a.m1878a(view, i);
    }

    public void mo625d(View view, AccessibilityEvent accessibilityEvent) {
        this.f2141a.m1884c(view, accessibilityEvent);
    }
}
