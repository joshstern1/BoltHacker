package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.p015d.p016a.C0196a;
import android.support.v4.view.C0641i;
import android.support.v4.view.C0675w;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.menu.C0882m;
import android.support.v7.view.menu.C0888o;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class C0859g extends MenuInflater {
    private static final Class<?>[] f2836a = new Class[]{Context.class};
    private static final Class<?>[] f2837b = f2836a;
    private final Object[] f2838c;
    private final Object[] f2839d = this.f2838c;
    private Context f2840e;
    private Object f2841f;

    private static class C0857a implements OnMenuItemClickListener {
        private static final Class<?>[] f2807a = new Class[]{MenuItem.class};
        private Object f2808b;
        private Method f2809c;

        public C0857a(Object obj, String str) {
            this.f2808b = obj;
            Class cls = obj.getClass();
            try {
                this.f2809c = cls.getMethod(str, f2807a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2809c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2809c.invoke(this.f2808b, new Object[]{menuItem})).booleanValue();
                }
                this.f2809c.invoke(this.f2808b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class C0858b {
        final /* synthetic */ C0859g f2810a;
        private Menu f2811b;
        private int f2812c;
        private int f2813d;
        private int f2814e;
        private int f2815f;
        private boolean f2816g;
        private boolean f2817h;
        private boolean f2818i;
        private int f2819j;
        private int f2820k;
        private CharSequence f2821l;
        private CharSequence f2822m;
        private int f2823n;
        private char f2824o;
        private char f2825p;
        private int f2826q;
        private boolean f2827r;
        private boolean f2828s;
        private boolean f2829t;
        private int f2830u;
        private int f2831v;
        private String f2832w;
        private String f2833x;
        private String f2834y;
        private C0641i f2835z;

        public C0858b(C0859g c0859g, Menu menu) {
            this.f2810a = c0859g;
            this.f2811b = menu;
            m5517a();
        }

        public void m5517a() {
            this.f2812c = 0;
            this.f2813d = 0;
            this.f2814e = 0;
            this.f2815f = 0;
            this.f2816g = true;
            this.f2817h = true;
        }

        public void m5518a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f2810a.f2840e.obtainStyledAttributes(attributeSet, C0841k.MenuGroup);
            this.f2812c = obtainStyledAttributes.getResourceId(C0841k.MenuGroup_android_id, 0);
            this.f2813d = obtainStyledAttributes.getInt(C0841k.MenuGroup_android_menuCategory, 0);
            this.f2814e = obtainStyledAttributes.getInt(C0841k.MenuGroup_android_orderInCategory, 0);
            this.f2815f = obtainStyledAttributes.getInt(C0841k.MenuGroup_android_checkableBehavior, 0);
            this.f2816g = obtainStyledAttributes.getBoolean(C0841k.MenuGroup_android_visible, true);
            this.f2817h = obtainStyledAttributes.getBoolean(C0841k.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m5520b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f2810a.f2840e.obtainStyledAttributes(attributeSet, C0841k.MenuItem);
            this.f2819j = obtainStyledAttributes.getResourceId(C0841k.MenuItem_android_id, 0);
            this.f2820k = (obtainStyledAttributes.getInt(C0841k.MenuItem_android_menuCategory, this.f2813d) & -65536) | (obtainStyledAttributes.getInt(C0841k.MenuItem_android_orderInCategory, this.f2814e) & 65535);
            this.f2821l = obtainStyledAttributes.getText(C0841k.MenuItem_android_title);
            this.f2822m = obtainStyledAttributes.getText(C0841k.MenuItem_android_titleCondensed);
            this.f2823n = obtainStyledAttributes.getResourceId(C0841k.MenuItem_android_icon, 0);
            this.f2824o = m5513a(obtainStyledAttributes.getString(C0841k.MenuItem_android_alphabeticShortcut));
            this.f2825p = m5513a(obtainStyledAttributes.getString(C0841k.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0841k.MenuItem_android_checkable)) {
                this.f2826q = obtainStyledAttributes.getBoolean(C0841k.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f2826q = this.f2815f;
            }
            this.f2827r = obtainStyledAttributes.getBoolean(C0841k.MenuItem_android_checked, false);
            this.f2828s = obtainStyledAttributes.getBoolean(C0841k.MenuItem_android_visible, this.f2816g);
            this.f2829t = obtainStyledAttributes.getBoolean(C0841k.MenuItem_android_enabled, this.f2817h);
            this.f2830u = obtainStyledAttributes.getInt(C0841k.MenuItem_showAsAction, -1);
            this.f2834y = obtainStyledAttributes.getString(C0841k.MenuItem_android_onClick);
            this.f2831v = obtainStyledAttributes.getResourceId(C0841k.MenuItem_actionLayout, 0);
            this.f2832w = obtainStyledAttributes.getString(C0841k.MenuItem_actionViewClass);
            this.f2833x = obtainStyledAttributes.getString(C0841k.MenuItem_actionProviderClass);
            if (this.f2833x == null) {
                z = false;
            }
            if (z && this.f2831v == 0 && this.f2832w == null) {
                this.f2835z = (C0641i) m5515a(this.f2833x, C0859g.f2837b, this.f2810a.f2839d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f2835z = null;
            }
            obtainStyledAttributes.recycle();
            this.f2818i = false;
        }

        private char m5513a(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        private void m5516a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f2827r).setVisible(this.f2828s).setEnabled(this.f2829t).setCheckable(this.f2826q >= 1).setTitleCondensed(this.f2822m).setIcon(this.f2823n).setAlphabeticShortcut(this.f2824o).setNumericShortcut(this.f2825p);
            if (this.f2830u >= 0) {
                C0675w.m4366a(menuItem, this.f2830u);
            }
            if (this.f2834y != null) {
                if (this.f2810a.f2840e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0857a(this.f2810a.m5529c(), this.f2834y));
            }
            if (menuItem instanceof C0882m) {
                C0882m c0882m = (C0882m) menuItem;
            }
            if (this.f2826q >= 2) {
                if (menuItem instanceof C0882m) {
                    ((C0882m) menuItem).m5703a(true);
                } else if (menuItem instanceof C0888o) {
                    ((C0888o) menuItem).m5733a(true);
                }
            }
            if (this.f2832w != null) {
                C0675w.m4364a(menuItem, (View) m5515a(this.f2832w, C0859g.f2836a, this.f2810a.f2838c));
            } else {
                z = false;
            }
            if (this.f2831v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0675w.m4367b(menuItem, this.f2831v);
                }
            }
            if (this.f2835z != null) {
                C0675w.m4363a(menuItem, this.f2835z);
            }
        }

        public void m5519b() {
            this.f2818i = true;
            m5516a(this.f2811b.add(this.f2812c, this.f2819j, this.f2820k, this.f2821l));
        }

        public SubMenu m5521c() {
            this.f2818i = true;
            SubMenu addSubMenu = this.f2811b.addSubMenu(this.f2812c, this.f2819j, this.f2820k, this.f2821l);
            m5516a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m5522d() {
            return this.f2818i;
        }

        private <T> T m5515a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f2810a.f2840e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    public C0859g(Context context) {
        super(context);
        this.f2840e = context;
        this.f2838c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0196a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f2840e.getResources().getLayout(i);
                m5525a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5525a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00e1;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m5518a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m5520b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m5521c();
        r10.m5525a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m5517a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x00ab:
        r3 = r7.m5522d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f2835z;
        if (r3 == 0) goto L_0x00c7;
    L_0x00b7:
        r3 = r7.f2835z;
        r3 = r3.mo878e();
        if (r3 == 0) goto L_0x00c7;
    L_0x00c1:
        r7.m5521c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c7:
        r7.m5519b();
        r3 = r5;
        goto L_0x0029;
    L_0x00cd:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d5:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d9:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private Object m5529c() {
        if (this.f2841f == null) {
            this.f2841f = m5524a(this.f2840e);
        }
        return this.f2841f;
    }

    private Object m5524a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m5524a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
