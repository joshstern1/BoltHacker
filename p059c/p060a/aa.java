package com.p059c.p060a;

import android.util.Log;
import com.p059c.p061b.C1262c;
import com.p059c.p061b.C1263a;
import com.p059c.p061b.C1266b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class aa implements Cloneable {
    private static final ab f4587i = new C1255g();
    private static final ab f4588j = new C1252e();
    private static Class[] f4589k = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] f4590l = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static Class[] f4591m = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static final HashMap<Class, HashMap<String, Method>> f4592n = new HashMap();
    private static final HashMap<Class, HashMap<String, Method>> f4593o = new HashMap();
    String f4594a;
    protected C1262c f4595b;
    Method f4596c;
    Class f4597d;
    C1253j f4598e;
    final ReentrantReadWriteLock f4599f;
    final Object[] f4600g;
    private Method f4601h;
    private ab f4602p;
    private Object f4603q;

    static class C1240a extends aa {
        C1254f f4604h;
        float f4605i;
        private C1263a f4606j;

        public /* synthetic */ aa mo1212a() {
            return m8266e();
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m8266e();
        }

        public C1240a(String str, C1254f c1254f) {
            super(str);
            this.d = Float.TYPE;
            this.e = c1254f;
            this.f4604h = (C1254f) this.e;
        }

        public C1240a(String str, float... fArr) {
            super(str);
            mo1215a(fArr);
        }

        public C1240a(C1262c c1262c, float... fArr) {
            super(c1262c);
            mo1215a(fArr);
            if (c1262c instanceof C1263a) {
                this.f4606j = (C1263a) this.b;
            }
        }

        public void mo1215a(float... fArr) {
            super.mo1215a(fArr);
            this.f4604h = (C1254f) this.e;
        }

        void mo1213a(float f) {
            this.f4605i = this.f4604h.m8355b(f);
        }

        Object mo1218d() {
            return Float.valueOf(this.f4605i);
        }

        public C1240a m8266e() {
            C1240a c1240a = (C1240a) super.mo1212a();
            c1240a.f4604h = (C1254f) c1240a.e;
            return c1240a;
        }

        void mo1216b(Object obj) {
            if (this.f4606j != null) {
                this.f4606j.mo1248a(obj, this.f4605i);
            } else if (this.b != null) {
                this.b.mo1246a(obj, Float.valueOf(this.f4605i));
            } else if (this.c != null) {
                try {
                    this.g[0] = Float.valueOf(this.f4605i);
                    this.c.invoke(obj, this.g);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        void mo1214a(Class cls) {
            if (this.b == null) {
                super.mo1214a(cls);
            }
        }
    }

    static class C1241b extends aa {
        C1256h f4607h;
        int f4608i;
        private C1266b f4609j;

        public /* synthetic */ aa mo1212a() {
            return m8272e();
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m8272e();
        }

        public C1241b(String str, C1256h c1256h) {
            super(str);
            this.d = Integer.TYPE;
            this.e = c1256h;
            this.f4607h = (C1256h) this.e;
        }

        void mo1213a(float f) {
            this.f4608i = this.f4607h.m8361b(f);
        }

        Object mo1218d() {
            return Integer.valueOf(this.f4608i);
        }

        public C1241b m8272e() {
            C1241b c1241b = (C1241b) super.mo1212a();
            c1241b.f4607h = (C1256h) c1241b.e;
            return c1241b;
        }

        void mo1216b(Object obj) {
            if (this.f4609j != null) {
                this.f4609j.mo1249a(obj, this.f4608i);
            } else if (this.b != null) {
                this.b.mo1246a(obj, Integer.valueOf(this.f4608i));
            } else if (this.c != null) {
                try {
                    this.g[0] = Integer.valueOf(this.f4608i);
                    this.c.invoke(obj, this.g);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        void mo1214a(Class cls) {
            if (this.b == null) {
                super.mo1214a(cls);
            }
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1212a();
    }

    private aa(String str) {
        this.f4596c = null;
        this.f4601h = null;
        this.f4598e = null;
        this.f4599f = new ReentrantReadWriteLock();
        this.f4600g = new Object[1];
        this.f4594a = str;
    }

    private aa(C1262c c1262c) {
        this.f4596c = null;
        this.f4601h = null;
        this.f4598e = null;
        this.f4599f = new ReentrantReadWriteLock();
        this.f4600g = new Object[1];
        this.f4595b = c1262c;
        if (c1262c != null) {
            this.f4594a = c1262c.m8395a();
        }
    }

    public static aa m8244a(String str, float... fArr) {
        return new C1240a(str, fArr);
    }

    public static aa m8243a(C1262c<?, Float> c1262c, float... fArr) {
        return new C1240a((C1262c) c1262c, fArr);
    }

    public static aa m8245a(String str, C1257i... c1257iArr) {
        C1253j a = C1253j.m8349a(c1257iArr);
        if (a instanceof C1256h) {
            return new C1241b(str, (C1256h) a);
        }
        if (a instanceof C1254f) {
            return new C1240a(str, (C1254f) a);
        }
        aa aaVar = new aa(str);
        aaVar.f4598e = a;
        aaVar.f4597d = c1257iArr[0].m8371e();
        return aaVar;
    }

    public void mo1215a(float... fArr) {
        this.f4597d = Float.TYPE;
        this.f4598e = C1253j.m8348a(fArr);
    }

    private Method m8247a(Class cls, String str, Class cls2) {
        Method method = null;
        String a = aa.m8246a(str, this.f4594a);
        Class[] clsArr = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a, clsArr);
            } catch (NoSuchMethodException e) {
                Method declaredMethod;
                try {
                    declaredMethod = cls.getDeclaredMethod(a, clsArr);
                    try {
                        declaredMethod.setAccessible(true);
                        return declaredMethod;
                    } catch (NoSuchMethodException e2) {
                        Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f4594a + ": " + e);
                        return declaredMethod;
                    }
                } catch (NoSuchMethodException e3) {
                    declaredMethod = null;
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f4594a + ": " + e);
                    return declaredMethod;
                }
            }
        }
        Class[] clsArr2 = new Class[1];
        if (this.f4597d.equals(Float.class)) {
            clsArr = f4589k;
        } else if (this.f4597d.equals(Integer.class)) {
            clsArr = f4590l;
        } else {
            clsArr = this.f4597d.equals(Double.class) ? f4591m : new Class[]{this.f4597d};
        }
        int length = clsArr.length;
        int i = 0;
        while (i < length) {
            Class cls3 = clsArr[i];
            clsArr2[0] = cls3;
            try {
                method = cls.getMethod(a, clsArr2);
                this.f4597d = cls3;
                return method;
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(a, clsArr2);
                    method.setAccessible(true);
                    this.f4597d = cls3;
                    return method;
                } catch (NoSuchMethodException e5) {
                    i++;
                }
            }
        }
        Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f4594a + " with value type " + this.f4597d);
        return method;
    }

    private Method m8248a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method = null;
        try {
            this.f4599f.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            if (hashMap2 != null) {
                method = (Method) hashMap2.get(this.f4594a);
            }
            if (method == null) {
                method = m8247a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f4594a, method);
            }
            Method method2 = method;
            this.f4599f.writeLock().unlock();
            return method2;
        } catch (Throwable th) {
            this.f4599f.writeLock().unlock();
        }
    }

    void mo1214a(Class cls) {
        this.f4596c = m8248a(cls, f4592n, "set", this.f4597d);
    }

    private void m8249b(Class cls) {
        this.f4601h = m8248a(cls, f4593o, "get", null);
    }

    void m8254a(Object obj) {
        C1257i c1257i;
        if (this.f4595b != null) {
            try {
                this.f4595b.mo1247a(obj);
                Iterator it = this.f4598e.f4672e.iterator();
                while (it.hasNext()) {
                    c1257i = (C1257i) it.next();
                    if (!c1257i.m8367a()) {
                        c1257i.mo1234a(this.f4595b.mo1247a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f4595b.m8395a() + ") on target object " + obj + ". Trying reflection instead");
                this.f4595b = null;
            }
        }
        Class cls = obj.getClass();
        if (this.f4596c == null) {
            mo1214a(cls);
        }
        Iterator it2 = this.f4598e.f4672e.iterator();
        while (it2.hasNext()) {
            c1257i = (C1257i) it2.next();
            if (!c1257i.m8367a()) {
                if (this.f4601h == null) {
                    m8249b(cls);
                }
                try {
                    c1257i.mo1234a(this.f4601h.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (IllegalAccessException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    public aa mo1212a() {
        try {
            aa aaVar = (aa) super.clone();
            aaVar.f4594a = this.f4594a;
            aaVar.f4595b = this.f4595b;
            aaVar.f4598e = this.f4598e.mo1232b();
            aaVar.f4602p = this.f4602p;
            return aaVar;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void mo1216b(Object obj) {
        if (this.f4595b != null) {
            this.f4595b.mo1246a(obj, mo1218d());
        }
        if (this.f4596c != null) {
            try {
                this.f4600g[0] = mo1218d();
                this.f4596c.invoke(obj, this.f4600g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    void m8256b() {
        if (this.f4602p == null) {
            ab abVar = this.f4597d == Integer.class ? f4587i : this.f4597d == Float.class ? f4588j : null;
            this.f4602p = abVar;
        }
        if (this.f4602p != null) {
            this.f4598e.m8351a(this.f4602p);
        }
    }

    void mo1213a(float f) {
        this.f4603q = this.f4598e.mo1231a(f);
    }

    public void m8252a(C1262c c1262c) {
        this.f4595b = c1262c;
    }

    public String m8258c() {
        return this.f4594a;
    }

    Object mo1218d() {
        return this.f4603q;
    }

    public String toString() {
        return this.f4594a + ": " + this.f4598e.toString();
    }

    static String m8246a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char toUpperCase = Character.toUpperCase(str2.charAt(0));
        return str + toUpperCase + str2.substring(1);
    }
}
