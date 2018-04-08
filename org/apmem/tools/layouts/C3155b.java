package org.apmem.tools.layouts;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout.C3153a;

class C3155b {
    private final List<View> f10377a = new ArrayList();
    private final int f10378b;
    private int f10379c;
    private int f10380d;
    private int f10381e = 0;
    private int f10382f = 0;

    public C3155b(int i) {
        this.f10378b = i;
    }

    public void m17720a(View view) {
        m17719a(this.f10377a.size(), view);
    }

    public void m17719a(int i, View view) {
        C3153a c3153a = (C3153a) view.getLayoutParams();
        this.f10377a.add(i, view);
        this.f10379c = (this.f10379c + c3153a.m17683d()) + c3153a.m17687g();
        this.f10380d = Math.max(this.f10380d, c3153a.m17688h() + c3153a.m17685e());
    }

    public boolean m17723b(View view) {
        C3153a c3153a = (C3153a) view.getLayoutParams();
        return c3153a.m17687g() + (this.f10379c + c3153a.m17683d()) <= this.f10378b;
    }

    public int m17717a() {
        return this.f10381e;
    }

    public void m17718a(int i) {
        this.f10381e = i;
    }

    public int m17721b() {
        return this.f10380d;
    }

    public int m17724c() {
        return this.f10379c;
    }

    public int m17726d() {
        return this.f10382f;
    }

    public void m17722b(int i) {
        this.f10382f = i;
    }

    public List<View> m17728e() {
        return this.f10377a;
    }

    public void m17725c(int i) {
        this.f10380d = i;
    }

    public void m17727d(int i) {
        this.f10379c = i;
    }
}
