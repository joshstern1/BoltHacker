package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.apmem.tools.layouts.C3157c.C3156a;

class C3154a {
    private int f10372a = 0;
    private boolean f10373b = false;
    private float f10374c = 0.0f;
    private int f10375d = 51;
    private int f10376e = 0;

    public C3154a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3156a.FlowLayout);
        try {
            m17709a(obtainStyledAttributes.getInteger(C3156a.FlowLayout_android_orientation, 0));
            m17710a(obtainStyledAttributes.getBoolean(C3156a.FlowLayout_debugDraw, false));
            m17708a(obtainStyledAttributes.getFloat(C3156a.FlowLayout_weightDefault, 0.0f));
            m17711b(obtainStyledAttributes.getInteger(C3156a.FlowLayout_android_gravity, 0));
            m17714c(obtainStyledAttributes.getInteger(C3156a.FlowLayout_layoutDirection, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public int m17707a() {
        return this.f10372a;
    }

    public void m17709a(int i) {
        if (i == 1) {
            this.f10372a = i;
        } else {
            this.f10372a = 0;
        }
    }

    public boolean m17712b() {
        return this.f10373b;
    }

    public void m17710a(boolean z) {
        this.f10373b = z;
    }

    public float m17713c() {
        return this.f10374c;
    }

    public void m17708a(float f) {
        this.f10374c = Math.max(0.0f, f);
    }

    public int m17715d() {
        return this.f10375d;
    }

    public void m17711b(int i) {
        this.f10375d = i;
    }

    public int m17716e() {
        return this.f10376e;
    }

    public void m17714c(int i) {
        if (i == 1) {
            this.f10376e = i;
        } else {
            this.f10376e = 0;
        }
    }
}
