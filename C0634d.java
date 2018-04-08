package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.C0249b.C0597c;
import android.support.v4.view.C0637g.C0633a;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.view.p025a.C0558l;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0634d implements C0633a {
    final /* synthetic */ C0249b f2144a;
    final /* synthetic */ C0597c f2145b;

    C0634d(C0597c c0597c, C0249b c0249b) {
        this.f2145b = c0597c;
        this.f2144a = c0249b;
    }

    public boolean mo637a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2144a.mo667d(view, accessibilityEvent);
    }

    public void mo639b(View view, AccessibilityEvent accessibilityEvent) {
        this.f2144a.mo220a(view, accessibilityEvent);
    }

    public void mo635a(View view, Object obj) {
        this.f2144a.mo219a(view, new C0547e(obj));
    }

    public void mo640c(View view, AccessibilityEvent accessibilityEvent) {
        this.f2144a.mo221b(view, accessibilityEvent);
    }

    public boolean mo638a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2144a.mo666a(viewGroup, view, accessibilityEvent);
    }

    public void mo634a(View view, int i) {
        this.f2144a.m1878a(view, i);
    }

    public void mo641d(View view, AccessibilityEvent accessibilityEvent) {
        this.f2144a.m1884c(view, accessibilityEvent);
    }

    public Object mo633a(View view) {
        C0558l a = this.f2144a.mo716a(view);
        return a != null ? a.m3545a() : null;
    }

    public boolean mo636a(View view, int i, Bundle bundle) {
        return this.f2144a.mo431a(view, i, bundle);
    }
}
