package com.p059c.p060a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.p059c.p060a.C1238a.C1237a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ac extends C1238a {
    private static ThreadLocal<C1242a> f4610h = new ThreadLocal();
    private static final ThreadLocal<ArrayList<ac>> f4611i = new ad();
    private static final ThreadLocal<ArrayList<ac>> f4612j = new ae();
    private static final ThreadLocal<ArrayList<ac>> f4613k = new af();
    private static final ThreadLocal<ArrayList<ac>> f4614l = new ag();
    private static final ThreadLocal<ArrayList<ac>> f4615m = new ah();
    private static final Interpolator f4616n = new AccelerateDecelerateInterpolator();
    private static final ab f4617o = new C1255g();
    private static final ab f4618p = new C1252e();
    private static long f4619z = 10;
    private int f4620A = 0;
    private int f4621B = 1;
    private Interpolator f4622C = f4616n;
    private ArrayList<C1243b> f4623D = null;
    long f4624b;
    long f4625c = -1;
    int f4626d = 0;
    boolean f4627e = false;
    aa[] f4628f;
    HashMap<String, aa> f4629g;
    private boolean f4630q = false;
    private int f4631r = 0;
    private float f4632s = 0.0f;
    private boolean f4633t = false;
    private long f4634u;
    private boolean f4635v = false;
    private boolean f4636w = false;
    private long f4637x = 300;
    private long f4638y = 0;

    private static class C1242a extends Handler {
        private C1242a() {
        }

        public void handleMessage(Message message) {
            ArrayList arrayList;
            Object obj;
            ArrayList arrayList2;
            int size;
            int i;
            ac acVar;
            ArrayList arrayList3 = (ArrayList) ac.f4611i.get();
            ArrayList arrayList4 = (ArrayList) ac.f4613k.get();
            switch (message.what) {
                case 0:
                    arrayList = (ArrayList) ac.f4612j.get();
                    if (arrayList3.size() > 0 || arrayList4.size() > 0) {
                        obj = null;
                    } else {
                        int i2 = 1;
                    }
                    while (arrayList.size() > 0) {
                        arrayList2 = (ArrayList) arrayList.clone();
                        arrayList.clear();
                        size = arrayList2.size();
                        for (i = 0; i < size; i++) {
                            acVar = (ac) arrayList2.get(i);
                            if (acVar.f4638y == 0) {
                                acVar.m8290r();
                            } else {
                                arrayList4.add(acVar);
                            }
                        }
                    }
                    break;
                case 1:
                    obj = 1;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            arrayList = (ArrayList) ac.f4615m.get();
            arrayList2 = (ArrayList) ac.f4614l.get();
            size = arrayList4.size();
            for (i = 0; i < size; i++) {
                acVar = (ac) arrayList4.get(i);
                if (acVar.mo1238a(currentAnimationTimeMillis)) {
                    arrayList.add(acVar);
                }
            }
            size = arrayList.size();
            if (size > 0) {
                for (i = 0; i < size; i++) {
                    acVar = (ac) arrayList.get(i);
                    acVar.m8290r();
                    acVar.f4635v = true;
                    arrayList4.remove(acVar);
                }
                arrayList.clear();
            }
            i = arrayList3.size();
            int i3 = 0;
            while (i3 < i) {
                int i4;
                ac acVar2 = (ac) arrayList3.get(i3);
                if (acVar2.m8303e(currentAnimationTimeMillis)) {
                    arrayList2.add(acVar2);
                }
                if (arrayList3.size() == i) {
                    i4 = i3 + 1;
                    i3 = i;
                } else {
                    i--;
                    arrayList2.remove(acVar2);
                    i4 = i3;
                    i3 = i;
                }
                i = i3;
                i3 = i4;
            }
            if (arrayList2.size() > 0) {
                for (i3 = 0; i3 < arrayList2.size(); i3++) {
                    ((ac) arrayList2.get(i3)).mo1243i();
                }
                arrayList2.clear();
            }
            if (obj == null) {
                return;
            }
            if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, ac.f4619z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public interface C1243b {
        void mo1275a(ac acVar);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1244j();
    }

    public /* synthetic */ C1238a mo1225g() {
        return mo1244j();
    }

    public static ac m8280b(float... fArr) {
        ac acVar = new ac();
        acVar.mo1240a(fArr);
        return acVar;
    }

    public void mo1240a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.f4628f == null || this.f4628f.length == 0) {
                m8295a(aa.m8244a("", fArr));
            } else {
                this.f4628f[0].mo1215a(fArr);
            }
            this.f4627e = false;
        }
    }

    public void m8295a(aa... aaVarArr) {
        this.f4628f = aaVarArr;
        this.f4629g = new HashMap(r2);
        for (aa aaVar : aaVarArr) {
            this.f4629g.put(aaVar.m8258c(), aaVar);
        }
        this.f4627e = false;
    }

    void mo1242h() {
        if (!this.f4627e) {
            for (aa b : this.f4628f) {
                b.m8256b();
            }
            this.f4627e = true;
        }
    }

    public ac mo1241b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f4637x = j;
        return this;
    }

    public void m8299c(long j) {
        mo1242h();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f4626d != 1) {
            this.f4625c = j;
            this.f4626d = 2;
        }
        this.f4624b = currentAnimationTimeMillis - j;
        m8303e(currentAnimationTimeMillis);
    }

    public long m8307k() {
        if (!this.f4627e || this.f4626d == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f4624b;
    }

    public void m8300d(long j) {
        this.f4638y = j;
    }

    public void m8293a(C1243b c1243b) {
        if (this.f4623D == null) {
            this.f4623D = new ArrayList();
        }
        this.f4623D.add(c1243b);
    }

    private void m8276a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f4630q = z;
        this.f4631r = 0;
        this.f4626d = 0;
        this.f4636w = true;
        this.f4633t = false;
        ((ArrayList) f4612j.get()).add(this);
        if (this.f4638y == 0) {
            m8299c(m8307k());
            this.f4626d = 0;
            this.f4635v = true;
            if (this.a != null) {
                ArrayList arrayList = (ArrayList) this.a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C1237a) arrayList.get(i)).mo1226a(this);
                }
            }
        }
        C1242a c1242a = (C1242a) f4610h.get();
        if (c1242a == null) {
            c1242a = new C1242a();
            f4610h.set(c1242a);
        }
        c1242a.sendEmptyMessage(0);
    }

    public void mo1219a() {
        m8276a(false);
    }

    public void mo1220b() {
        if (this.f4626d != 0 || ((ArrayList) f4612j.get()).contains(this) || ((ArrayList) f4613k.get()).contains(this)) {
            if (this.f4635v && this.a != null) {
                Iterator it = ((ArrayList) this.a.clone()).iterator();
                while (it.hasNext()) {
                    ((C1237a) it.next()).mo1228c(this);
                }
            }
            mo1243i();
        }
    }

    public void mo1221c() {
        if (!((ArrayList) f4611i.get()).contains(this) && !((ArrayList) f4612j.get()).contains(this)) {
            this.f4633t = false;
            m8290r();
        } else if (!this.f4627e) {
            mo1242h();
        }
        if (this.f4620A <= 0 || (this.f4620A & 1) != 1) {
            mo1239a(1.0f);
        } else {
            mo1239a(0.0f);
        }
        mo1243i();
    }

    public boolean mo1223d() {
        return this.f4626d == 1 || this.f4635v;
    }

    public boolean mo1224e() {
        return this.f4636w;
    }

    private void mo1243i() {
        ((ArrayList) f4611i.get()).remove(this);
        ((ArrayList) f4612j.get()).remove(this);
        ((ArrayList) f4613k.get()).remove(this);
        this.f4626d = 0;
        if (this.f4635v && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1237a) arrayList.get(i)).mo1227b(this);
            }
        }
        this.f4635v = false;
        this.f4636w = false;
    }

    private void m8290r() {
        mo1242h();
        ((ArrayList) f4611i.get()).add(this);
        if (this.f4638y > 0 && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1237a) arrayList.get(i)).mo1226a(this);
            }
        }
    }

    private boolean mo1238a(long j) {
        if (this.f4633t) {
            long j2 = j - this.f4634u;
            if (j2 > this.f4638y) {
                this.f4624b = j - (j2 - this.f4638y);
                this.f4626d = 1;
                return true;
            }
        }
        this.f4633t = true;
        this.f4634u = j;
        return false;
    }

    boolean m8303e(long j) {
        boolean z = false;
        if (this.f4626d == 0) {
            this.f4626d = 1;
            if (this.f4625c < 0) {
                this.f4624b = j;
            } else {
                this.f4624b = j - this.f4625c;
                this.f4625c = -1;
            }
        }
        switch (this.f4626d) {
            case 1:
            case 2:
                float f;
                float f2 = this.f4637x > 0 ? ((float) (j - this.f4624b)) / ((float) this.f4637x) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.f4631r < this.f4620A || this.f4620A == -1) {
                    if (this.a != null) {
                        int size = this.a.size();
                        for (int i = 0; i < size; i++) {
                            ((C1237a) this.a.get(i)).mo1229d(this);
                        }
                    }
                    if (this.f4621B == 2) {
                        this.f4630q = !this.f4630q;
                    }
                    this.f4631r += (int) f2;
                    f = f2 % 1.0f;
                    this.f4624b += this.f4637x;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = true;
                }
                if (this.f4630q) {
                    f = 1.0f - f;
                }
                mo1239a(f);
                break;
        }
        return z;
    }

    void mo1239a(float f) {
        int i;
        float interpolation = this.f4622C.getInterpolation(f);
        this.f4632s = interpolation;
        for (aa a : this.f4628f) {
            a.mo1213a(interpolation);
        }
        if (this.f4623D != null) {
            int size = this.f4623D.size();
            for (i = 0; i < size; i++) {
                ((C1243b) this.f4623D.get(i)).mo1275a(this);
            }
        }
    }

    public ac mo1244j() {
        int i = 0;
        ac acVar = (ac) super.mo1225g();
        if (this.f4623D != null) {
            ArrayList arrayList = this.f4623D;
            acVar.f4623D = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                acVar.f4623D.add(arrayList.get(i2));
            }
        }
        acVar.f4625c = -1;
        acVar.f4630q = false;
        acVar.f4631r = 0;
        acVar.f4627e = false;
        acVar.f4626d = 0;
        acVar.f4633t = false;
        aa[] aaVarArr = this.f4628f;
        if (aaVarArr != null) {
            int length = aaVarArr.length;
            acVar.f4628f = new aa[length];
            acVar.f4629g = new HashMap(length);
            while (i < length) {
                aa a = aaVarArr[i].mo1212a();
                acVar.f4628f[i] = a;
                acVar.f4629g.put(a.m8258c(), a);
                i++;
            }
        }
        return acVar;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f4628f != null) {
            for (aa aaVar : this.f4628f) {
                str = str + "\n    " + aaVar.toString();
            }
        }
        return str;
    }
}
