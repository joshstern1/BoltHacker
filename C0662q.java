package android.support.v4.view;

import android.content.Context;
import android.support.v4.view.C0660p.C0659a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

class C0662q {
    private static Field f2155a;
    private static boolean f2156b;

    static class C0661a extends C0659a implements Factory2 {
        C0661a(C0403s c0403s) {
            super(c0403s);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.mo379a(view, str, context, attributeSet);
        }
    }

    static void m4328a(LayoutInflater layoutInflater, C0403s c0403s) {
        Factory2 c0661a;
        if (c0403s != null) {
            c0661a = new C0661a(c0403s);
        } else {
            c0661a = null;
        }
        layoutInflater.setFactory2(c0661a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0662q.m4329a(layoutInflater, (Factory2) factory);
        } else {
            C0662q.m4329a(layoutInflater, c0661a);
        }
    }

    static void m4329a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f2156b) {
            try {
                f2155a = LayoutInflater.class.getDeclaredField("mFactory2");
                f2155a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f2156b = true;
        }
        if (f2155a != null) {
            try {
                f2155a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
