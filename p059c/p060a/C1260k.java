package com.p059c.p060a;

import android.view.View;
import com.p059c.p061b.C1262c;
import com.p059c.p062c.p063a.C1280a;
import java.util.HashMap;
import java.util.Map;

public final class C1260k extends ac {
    private static final Map<String, C1262c> f4688h = new HashMap();
    private Object f4689i;
    private String f4690j;
    private C1262c f4691k;

    public /* synthetic */ ac mo1241b(long j) {
        return mo1238a(j);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1243i();
    }

    public /* synthetic */ C1238a mo1225g() {
        return mo1243i();
    }

    public /* synthetic */ ac mo1244j() {
        return mo1243i();
    }

    static {
        f4688h.put("alpha", C1261l.f4692a);
        f4688h.put("pivotX", C1261l.f4693b);
        f4688h.put("pivotY", C1261l.f4694c);
        f4688h.put("translationX", C1261l.f4695d);
        f4688h.put("translationY", C1261l.f4696e);
        f4688h.put("rotation", C1261l.f4697f);
        f4688h.put("rotationX", C1261l.f4698g);
        f4688h.put("rotationY", C1261l.f4699h);
        f4688h.put("scaleX", C1261l.f4700i);
        f4688h.put("scaleY", C1261l.f4701j);
        f4688h.put("scrollX", C1261l.f4702k);
        f4688h.put("scrollY", C1261l.f4703l);
        f4688h.put("x", C1261l.f4704m);
        f4688h.put("y", C1261l.f4705n);
    }

    public void m8387a(C1262c c1262c) {
        if (this.f != null) {
            aa aaVar = this.f[0];
            String c = aaVar.m8258c();
            aaVar.m8252a(c1262c);
            this.g.remove(c);
            this.g.put(this.f4690j, aaVar);
        }
        if (this.f4691k != null) {
            this.f4690j = c1262c.m8395a();
        }
        this.f4691k = c1262c;
        this.e = false;
    }

    public static C1260k m8383a(Object obj, aa... aaVarArr) {
        C1260k c1260k = new C1260k();
        c1260k.f4689i = obj;
        c1260k.m8295a(aaVarArr);
        return c1260k;
    }

    public void mo1240a(float... fArr) {
        if (this.f != null && this.f.length != 0) {
            super.mo1240a(fArr);
        } else if (this.f4691k != null) {
            m8295a(aa.m8243a(this.f4691k, fArr));
        } else {
            m8295a(aa.m8244a(this.f4690j, fArr));
        }
    }

    public void mo1219a() {
        super.mo1219a();
    }

    void mo1242h() {
        if (!this.e) {
            if (this.f4691k == null && C1280a.f4708a && (this.f4689i instanceof View) && f4688h.containsKey(this.f4690j)) {
                m8387a((C1262c) f4688h.get(this.f4690j));
            }
            for (aa a : this.f) {
                a.m8254a(this.f4689i);
            }
            super.mo1242h();
        }
    }

    public C1260k mo1238a(long j) {
        super.mo1241b(j);
        return this;
    }

    void mo1239a(float f) {
        super.mo1239a(f);
        for (aa b : this.f) {
            b.mo1216b(this.f4689i);
        }
    }

    public C1260k mo1243i() {
        return (C1260k) super.mo1244j();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f4689i;
        if (this.f != null) {
            for (aa aaVar : this.f) {
                str = str + "\n    " + aaVar.toString();
            }
        }
        return str;
    }
}
