package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C3059d;
import java.util.Locale;
import java.util.Map;

class C1075d {
    final int f4106a;
    final int f4107b;
    boolean f4108c;

    public C1075d(int i, int i2, boolean z) {
        this.f4106a = i;
        this.f4107b = i2;
        this.f4108c = z;
    }

    public String m7621a(String str) {
        if (str.length() <= this.f4107b) {
            return str;
        }
        m7620a(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[]{Integer.valueOf(this.f4107b)})));
        return str.substring(0, this.f4107b);
    }

    public boolean m7622a(Object obj, String str) {
        if (obj != null) {
            return false;
        }
        m7620a(new NullPointerException(str + " must not be null"));
        return true;
    }

    public boolean m7623a(Map<String, Object> map, String str) {
        if (map.size() < this.f4106a || map.containsKey(str)) {
            return false;
        }
        m7620a(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[]{Integer.valueOf(this.f4106a)})));
        return true;
    }

    private void m7620a(RuntimeException runtimeException) {
        if (this.f4108c) {
            throw runtimeException;
        }
        C3059d.m17342h().mo2439e("Answers", "Invalid user input detected", runtimeException);
    }
}
