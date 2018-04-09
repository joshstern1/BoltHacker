package com.p059c.p060a;

import com.p059c.p060a.C1238a.C1237a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class C1250c extends C1238a {
    boolean f4654b = false;
    private ArrayList<C1238a> f4655c = new ArrayList();
    private HashMap<C1238a, C1249e> f4656d = new HashMap();
    private ArrayList<C1249e> f4657e = new ArrayList();
    private ArrayList<C1249e> f4658f = new ArrayList();
    private boolean f4659g = true;
    private C1245a f4660h = null;
    private boolean f4661i = false;
    private long f4662j = 0;
    private ac f4663k = null;
    private long f4664l = -1;

    private class C1245a implements C1237a {
        final /* synthetic */ C1250c f4639a;
        private C1250c f4640b;

        C1245a(C1250c c1250c, C1250c c1250c2) {
            this.f4639a = c1250c;
            this.f4640b = c1250c2;
        }

        public void mo1228c(C1238a c1238a) {
            if (!this.f4639a.f4654b && this.f4639a.f4655c.size() == 0 && this.f4639a.a != null) {
                int size = this.f4639a.a.size();
                for (int i = 0; i < size; i++) {
                    ((C1237a) this.f4639a.a.get(i)).mo1228c(this.f4640b);
                }
            }
        }

        public void mo1227b(C1238a c1238a) {
            c1238a.m8237b(this);
            this.f4639a.f4655c.remove(c1238a);
            ((C1249e) this.f4640b.f4656d.get(c1238a)).f4653f = true;
            if (!this.f4639a.f4654b) {
                int i;
                boolean z;
                ArrayList c = this.f4640b.f4658f;
                int size = c.size();
                for (i = 0; i < size; i++) {
                    if (!((C1249e) c.get(i)).f4653f) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    if (this.f4639a.a != null) {
                        ArrayList arrayList = (ArrayList) this.f4639a.a.clone();
                        int size2 = arrayList.size();
                        for (i = 0; i < size2; i++) {
                            ((C1237a) arrayList.get(i)).mo1227b(this.f4640b);
                        }
                    }
                    this.f4640b.f4661i = false;
                }
            }
        }

        public void mo1229d(C1238a c1238a) {
        }

        public void mo1226a(C1238a c1238a) {
        }
    }

    public class C1246b {
        final /* synthetic */ C1250c f4641a;
        private C1249e f4642b;

        C1246b(C1250c c1250c, C1238a c1238a) {
            this.f4641a = c1250c;
            this.f4642b = (C1249e) c1250c.f4656d.get(c1238a);
            if (this.f4642b == null) {
                this.f4642b = new C1249e(c1238a);
                c1250c.f4656d.put(c1238a, this.f4642b);
                c1250c.f4657e.add(this.f4642b);
            }
        }

        public C1246b m8321a(C1238a c1238a) {
            C1249e c1249e = (C1249e) this.f4641a.f4656d.get(c1238a);
            if (c1249e == null) {
                c1249e = new C1249e(c1238a);
                this.f4641a.f4656d.put(c1238a, c1249e);
                this.f4641a.f4657e.add(c1249e);
            }
            c1249e.m8328a(new C1247c(this.f4642b, 0));
            return this;
        }
    }

    private static class C1247c {
        public C1249e f4643a;
        public int f4644b;

        public C1247c(C1249e c1249e, int i) {
            this.f4643a = c1249e;
            this.f4644b = i;
        }
    }

    private static class C1248d implements C1237a {
        private C1250c f4645a;
        private C1249e f4646b;
        private int f4647c;

        public C1248d(C1250c c1250c, C1249e c1249e, int i) {
            this.f4645a = c1250c;
            this.f4646b = c1249e;
            this.f4647c = i;
        }

        public void mo1228c(C1238a c1238a) {
        }

        public void mo1227b(C1238a c1238a) {
            if (this.f4647c == 1) {
                m8322e(c1238a);
            }
        }

        public void mo1229d(C1238a c1238a) {
        }

        public void mo1226a(C1238a c1238a) {
            if (this.f4647c == 0) {
                m8322e(c1238a);
            }
        }

        private void m8322e(C1238a c1238a) {
            if (!this.f4645a.f4654b) {
                Object obj;
                int size = this.f4646b.f4650c.size();
                for (int i = 0; i < size; i++) {
                    obj = (C1247c) this.f4646b.f4650c.get(i);
                    if (obj.f4644b == this.f4647c && obj.f4643a.f4648a == c1238a) {
                        c1238a.m8237b(this);
                        break;
                    }
                }
                obj = null;
                this.f4646b.f4650c.remove(obj);
                if (this.f4646b.f4650c.size() == 0) {
                    this.f4646b.f4648a.mo1219a();
                    this.f4645a.f4655c.add(this.f4646b.f4648a);
                }
            }
        }
    }

    private static class C1249e implements Cloneable {
        public C1238a f4648a;
        public ArrayList<C1247c> f4649b = null;
        public ArrayList<C1247c> f4650c = null;
        public ArrayList<C1249e> f4651d = null;
        public ArrayList<C1249e> f4652e = null;
        public boolean f4653f = false;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m8327a();
        }

        public C1249e(C1238a c1238a) {
            this.f4648a = c1238a;
        }

        public void m8328a(C1247c c1247c) {
            if (this.f4649b == null) {
                this.f4649b = new ArrayList();
                this.f4651d = new ArrayList();
            }
            this.f4649b.add(c1247c);
            if (!this.f4651d.contains(c1247c.f4643a)) {
                this.f4651d.add(c1247c.f4643a);
            }
            C1249e c1249e = c1247c.f4643a;
            if (c1249e.f4652e == null) {
                c1249e.f4652e = new ArrayList();
            }
            c1249e.f4652e.add(this);
        }

        public C1249e m8327a() {
            try {
                C1249e c1249e = (C1249e) super.clone();
                c1249e.f4648a = this.f4648a.mo1225g();
                return c1249e;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m8343h();
    }

    public /* synthetic */ C1238a mo1225g() {
        return m8343h();
    }

    public void m8337a(C1238a... c1238aArr) {
        int i = 1;
        if (c1238aArr != null) {
            this.f4659g = true;
            C1246b a = m8335a(c1238aArr[0]);
            while (i < c1238aArr.length) {
                a.m8321a(c1238aArr[i]);
                i++;
            }
        }
    }

    public C1246b m8335a(C1238a c1238a) {
        if (c1238a == null) {
            return null;
        }
        this.f4659g = true;
        return new C1246b(this, c1238a);
    }

    public void mo1220b() {
        this.f4654b = true;
        if (mo1224e()) {
            Iterator it;
            ArrayList arrayList;
            if (this.a != null) {
                ArrayList arrayList2 = (ArrayList) this.a.clone();
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C1237a) it.next()).mo1228c(this);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (this.f4663k != null && this.f4663k.mo1223d()) {
                this.f4663k.mo1220b();
            } else if (this.f4658f.size() > 0) {
                it = this.f4658f.iterator();
                while (it.hasNext()) {
                    ((C1249e) it.next()).f4648a.mo1220b();
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((C1237a) it2.next()).mo1227b(this);
                }
            }
            this.f4661i = false;
        }
    }

    public void mo1221c() {
        this.f4654b = true;
        if (mo1224e()) {
            Iterator it;
            if (this.f4658f.size() != this.f4657e.size()) {
                m8334i();
                it = this.f4658f.iterator();
                while (it.hasNext()) {
                    C1249e c1249e = (C1249e) it.next();
                    if (this.f4660h == null) {
                        this.f4660h = new C1245a(this, this);
                    }
                    c1249e.f4648a.m8235a(this.f4660h);
                }
            }
            if (this.f4663k != null) {
                this.f4663k.mo1220b();
            }
            if (this.f4658f.size() > 0) {
                it = this.f4658f.iterator();
                while (it.hasNext()) {
                    ((C1249e) it.next()).f4648a.mo1221c();
                }
            }
            if (this.a != null) {
                it = ((ArrayList) this.a.clone()).iterator();
                while (it.hasNext()) {
                    ((C1237a) it.next()).mo1227b(this);
                }
            }
            this.f4661i = false;
        }
    }

    public boolean mo1223d() {
        Iterator it = this.f4657e.iterator();
        while (it.hasNext()) {
            if (((C1249e) it.next()).f4648a.mo1223d()) {
                return true;
            }
        }
        return false;
    }

    public boolean mo1224e() {
        return this.f4661i;
    }

    public void mo1219a() {
        int i;
        int i2;
        ArrayList arrayList;
        int i3 = 0;
        this.f4654b = false;
        this.f4661i = true;
        m8334i();
        int size = this.f4658f.size();
        for (i = 0; i < size; i++) {
            C1249e c1249e = (C1249e) this.f4658f.get(i);
            Collection f = c1249e.f4648a.m8241f();
            if (f != null && f.size() > 0) {
                Iterator it = new ArrayList(f).iterator();
                while (it.hasNext()) {
                    C1237a c1237a = (C1237a) it.next();
                    if ((c1237a instanceof C1248d) || (c1237a instanceof C1245a)) {
                        c1249e.f4648a.m8237b(c1237a);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (i2 = 0; i2 < size; i2++) {
            c1249e = (C1249e) this.f4658f.get(i2);
            if (this.f4660h == null) {
                this.f4660h = new C1245a(this, this);
            }
            if (c1249e.f4649b == null || c1249e.f4649b.size() == 0) {
                arrayList2.add(c1249e);
            } else {
                int size2 = c1249e.f4649b.size();
                for (i = 0; i < size2; i++) {
                    C1247c c1247c = (C1247c) c1249e.f4649b.get(i);
                    c1247c.f4643a.f4648a.m8235a(new C1248d(this, c1249e, c1247c.f4644b));
                }
                c1249e.f4650c = (ArrayList) c1249e.f4649b.clone();
            }
            c1249e.f4648a.m8235a(this.f4660h);
        }
        if (this.f4662j <= 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c1249e = (C1249e) it2.next();
                c1249e.f4648a.mo1219a();
                this.f4655c.add(c1249e.f4648a);
            }
        } else {
            this.f4663k = ac.m8280b(0.0f, 1.0f);
            this.f4663k.mo1241b(this.f4662j);
            this.f4663k.m8235a(new C1251d(this, arrayList2));
            this.f4663k.mo1219a();
        }
        if (this.a != null) {
            arrayList = (ArrayList) this.a.clone();
            i2 = arrayList.size();
            for (i = 0; i < i2; i++) {
                ((C1237a) arrayList.get(i)).mo1226a(this);
            }
        }
        if (this.f4657e.size() == 0 && this.f4662j == 0) {
            this.f4661i = false;
            if (this.a != null) {
                arrayList = (ArrayList) this.a.clone();
                i = arrayList.size();
                while (i3 < i) {
                    ((C1237a) arrayList.get(i3)).mo1227b(this);
                    i3++;
                }
            }
        }
    }

    public C1250c m8343h() {
        C1250c c1250c = (C1250c) super.mo1225g();
        c1250c.f4659g = true;
        c1250c.f4654b = false;
        c1250c.f4661i = false;
        c1250c.f4655c = new ArrayList();
        c1250c.f4656d = new HashMap();
        c1250c.f4657e = new ArrayList();
        c1250c.f4658f = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it = this.f4657e.iterator();
        while (it.hasNext()) {
            C1249e c1249e = (C1249e) it.next();
            C1249e a = c1249e.m8327a();
            hashMap.put(c1249e, a);
            c1250c.f4657e.add(a);
            c1250c.f4656d.put(a.f4648a, a);
            a.f4649b = null;
            a.f4650c = null;
            a.f4652e = null;
            a.f4651d = null;
            ArrayList f = a.f4648a.m8241f();
            if (f != null) {
                Iterator it2 = f.iterator();
                ArrayList arrayList = null;
                while (it2.hasNext()) {
                    C1237a c1237a = (C1237a) it2.next();
                    if (c1237a instanceof C1245a) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c1237a);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        f.remove((C1237a) it3.next());
                    }
                }
            }
        }
        it = this.f4657e.iterator();
        while (it.hasNext()) {
            c1249e = (C1249e) it.next();
            a = (C1249e) hashMap.get(c1249e);
            if (c1249e.f4649b != null) {
                Iterator it4 = c1249e.f4649b.iterator();
                while (it4.hasNext()) {
                    C1247c c1247c = (C1247c) it4.next();
                    a.m8328a(new C1247c((C1249e) hashMap.get(c1247c.f4643a), c1247c.f4644b));
                }
            }
        }
        return c1250c;
    }

    private void m8334i() {
        int size;
        C1249e c1249e;
        int i;
        if (this.f4659g) {
            this.f4658f.clear();
            ArrayList arrayList = new ArrayList();
            size = this.f4657e.size();
            for (int i2 = 0; i2 < size; i2++) {
                c1249e = (C1249e) this.f4657e.get(i2);
                if (c1249e.f4649b == null || c1249e.f4649b.size() == 0) {
                    arrayList.add(c1249e);
                }
            }
            Object arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (i = 0; i < size2; i++) {
                    c1249e = (C1249e) arrayList.get(i);
                    this.f4658f.add(c1249e);
                    if (c1249e.f4652e != null) {
                        int size3 = c1249e.f4652e.size();
                        for (size = 0; size < size3; size++) {
                            C1249e c1249e2 = (C1249e) c1249e.f4652e.get(size);
                            c1249e2.f4651d.remove(c1249e);
                            if (c1249e2.f4651d.size() == 0) {
                                arrayList2.add(c1249e2);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.f4659g = false;
            if (this.f4658f.size() != this.f4657e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f4657e.size();
        for (i = 0; i < size4; i++) {
            c1249e = (C1249e) this.f4657e.get(i);
            if (c1249e.f4649b != null && c1249e.f4649b.size() > 0) {
                int size5 = c1249e.f4649b.size();
                for (size = 0; size < size5; size++) {
                    C1247c c1247c = (C1247c) c1249e.f4649b.get(size);
                    if (c1249e.f4651d == null) {
                        c1249e.f4651d = new ArrayList();
                    }
                    if (!c1249e.f4651d.contains(c1247c.f4643a)) {
                        c1249e.f4651d.add(c1247c.f4643a);
                    }
                }
            }
            c1249e.f4653f = false;
        }
    }
}
