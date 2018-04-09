package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class C0660p {

    static class C0659a implements Factory {
        final C0403s f2154a;

        C0659a(C0403s c0403s) {
            this.f2154a = c0403s;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f2154a.mo379a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f2154a + "}";
        }
    }

    static void m4327a(LayoutInflater layoutInflater, C0403s c0403s) {
        layoutInflater.setFactory(c0403s != null ? new C0659a(c0403s) : null);
    }

    static C0403s m4326a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof C0659a) {
            return ((C0659a) factory).f2154a;
        }
        return null;
    }
}
