package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.C0381g.C0380b;
import android.support.v4.app.C0401x.C0400a;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.p017e.C0466c;
import android.support.v4.p024g.C0499d;
import android.support.v4.p024g.C0500e;
import android.support.v4.view.C0403s;
import android.support.v4.view.ao;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;

final class C0404y extends C0401x implements C0403s {
    static final Interpolator f1839A = new DecelerateInterpolator(2.5f);
    static final Interpolator f1840B = new DecelerateInterpolator(1.5f);
    static final Interpolator f1841C = new AccelerateInterpolator(2.5f);
    static final Interpolator f1842D = new AccelerateInterpolator(1.5f);
    static boolean f1843a = false;
    static final boolean f1844b;
    static Field f1845r = null;
    ArrayList<Runnable> f1846c;
    Runnable[] f1847d;
    boolean f1848e;
    ArrayList<Fragment> f1849f;
    ArrayList<Fragment> f1850g;
    ArrayList<Integer> f1851h;
    ArrayList<C0381g> f1852i;
    ArrayList<Fragment> f1853j;
    ArrayList<C0381g> f1854k;
    ArrayList<Integer> f1855l;
    ArrayList<C0400a> f1856m;
    int f1857n = 0;
    C0394w f1858o;
    C0391u f1859p;
    Fragment f1860q;
    boolean f1861s;
    boolean f1862t;
    boolean f1863u;
    String f1864v;
    boolean f1865w;
    Bundle f1866x = null;
    SparseArray<Parcelable> f1867y = null;
    Runnable f1868z = new C0405z(this);

    static class C0309a implements AnimationListener {
        private AnimationListener f1548a;
        private boolean f1549b;
        private View f1550c;

        public C0309a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f1550c = view;
            }
        }

        public C0309a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f1548a = animationListener;
                this.f1550c = view;
                this.f1549b = true;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.f1548a != null) {
                this.f1548a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1550c != null && this.f1549b) {
                if (ao.m3897I(this.f1550c) || C0466c.m3056a()) {
                    this.f1550c.post(new ac(this));
                } else {
                    ao.m3906a(this.f1550c, 0, null);
                }
            }
            if (this.f1548a != null) {
                this.f1548a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f1548a != null) {
                this.f1548a.onAnimationRepeat(animation);
            }
        }
    }

    static class C0402b {
        public static final int[] f1838a = new int[]{16842755, 16842960, 16842961};
    }

    C0404y() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f1844b = z;
    }

    static boolean m2812a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m2811a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ao.m3937g(view) == 0 && ao.m3889A(view) && C0404y.m2812a(animation);
    }

    private void m2810a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0500e("FragmentManager"));
        if (this.f1858o != null) {
            try {
                this.f1858o.mo360a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo382a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public ah mo378a() {
        return new C0381g(this);
    }

    public boolean mo383b() {
        return m2864g();
    }

    public boolean mo384c() {
        m2816x();
        mo383b();
        return m2838a(this.f1858o.m2733h(), null, -1, 0);
    }

    public void mo380a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m2836a(new aa(this, i, i2), false);
    }

    public void mo381a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f1517p < 0) {
            m2810a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f1517p);
    }

    public Fragment mo376a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f1849f.size()) {
            m2810a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f1849f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m2810a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public List<Fragment> mo385d() {
        return this.f1849f;
    }

    public SavedState mo374a(Fragment fragment) {
        if (fragment.f1517p < 0) {
            m2810a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.f1512k <= 0) {
            return null;
        }
        Bundle g = m2863g(fragment);
        if (g != null) {
            return new SavedState(g);
        }
        return null;
    }

    public boolean mo386e() {
        return this.f1863u;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f1860q != null) {
            C0499d.m3138a(this.f1860q, stringBuilder);
        } else {
            C0499d.m3138a(this.f1858o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void mo382a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f1849f != null) {
            size = this.f1849f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f1849f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.mo1460a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f1850g != null) {
            size = this.f1850g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f1850g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f1853j != null) {
            size = this.f1853j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f1853j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f1852i != null) {
            size = this.f1852i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0381g c0381g = (C0381g) this.f1852i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0381g.toString());
                    c0381g.m2683a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f1854k != null) {
                int size2 = this.f1854k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0381g = (C0381g) this.f1854k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0381g);
                    }
                }
            }
            if (this.f1855l != null && this.f1855l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f1855l.toArray()));
            }
        }
        if (this.f1846c != null) {
            i = this.f1846c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f1846c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1858o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1859p);
        if (this.f1860q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1860q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1857n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1862t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1863u);
        if (this.f1861s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1861s);
        }
        if (this.f1864v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f1864v);
        }
        if (this.f1851h != null && this.f1851h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f1851h.toArray()));
        }
    }

    static Animation m2809a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f1839A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f1840B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m2808a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f1840B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m2824a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m2259a(i, z, fragment.f1502Q);
        if (a != null) {
            return a;
        }
        if (fragment.f1502Q != 0) {
            a = AnimationUtils.loadAnimation(this.f1858o.m2732g(), fragment.f1502Q);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0404y.m2813b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0404y.m2809a(this.f1858o.m2732g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0404y.m2809a(this.f1858o.m2732g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0404y.m2809a(this.f1858o.m2732g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0404y.m2809a(this.f1858o.m2732g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0404y.m2808a(this.f1858o.m2732g(), 0.0f, 1.0f);
            case 6:
                return C0404y.m2808a(this.f1858o.m2732g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f1858o.mo365d()) {
                    i2 = this.f1858o.mo366e();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m2843b(Fragment fragment) {
        if (!fragment.f1506U) {
            return;
        }
        if (this.f1848e) {
            this.f1865w = true;
            return;
        }
        fragment.f1506U = false;
        m2833a(fragment, this.f1857n, 0, 0, false);
    }

    private void m2814b(View view, Animation animation) {
        if (view != null && animation != null && C0404y.m2811a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f1845r == null) {
                    f1845r = Animation.class.getDeclaredField("mListener");
                    f1845r.setAccessible(true);
                }
                animationListener = (AnimationListener) f1845r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            ao.m3906a(view, 2, null);
            animation.setAnimationListener(new C0309a(view, animation, animationListener));
        }
    }

    boolean m2849b(int i) {
        return this.f1857n >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m2833a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r11.f1523v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f1496K;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f1524w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f1512k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f1512k;
    L_0x001a:
        r0 = r11.f1506U;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f1512k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f1512k;
        if (r0 >= r12) goto L_0x02eb;
    L_0x0029:
        r0 = r11.f1525x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f1526y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f1513l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f1513l = r7;
        r2 = r11.f1514m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m2833a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f1512k;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x026d;
            case 3: goto L_0x0272;
            case 4: goto L_0x0293;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.f1512k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.f1512k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f1512k = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f1843a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.f1515n;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.f1515n;
        r1 = r10.f1858o;
        r1 = r1.m2732g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f1515n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f1516o = r0;
        r0 = r11.f1515n;
        r1 = "android:target_state";
        r0 = r10.mo376a(r0, r1);
        r11.f1520s = r0;
        r0 = r11.f1520s;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.f1515n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f1522u = r0;
    L_0x00d1:
        r0 = r11.f1515n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f1507V = r0;
        r0 = r11.f1507V;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.f1506U = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f1858o;
        r11.f1488C = r0;
        r0 = r10.f1860q;
        r11.f1491F = r0;
        r0 = r10.f1860q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f1860q;
        r0 = r0.f1489D;
    L_0x00f4:
        r11.f1487B = r0;
        r11.f1501P = r3;
        r0 = r10.f1858o;
        r0 = r0.m2732g();
        r11.mo348a(r0);
        r0 = r11.f1501P;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.app.bo;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f1858o;
        r0 = r0.m2734i();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.f1491F;
        if (r0 != 0) goto L_0x02ba;
    L_0x012f:
        r0 = r10.f1858o;
        r0.mo363b(r11);
    L_0x0134:
        r0 = r11.f1498M;
        if (r0 != 0) goto L_0x02c1;
    L_0x0138:
        r0 = r11.f1515n;
        r11.m2303i(r0);
    L_0x013d:
        r11.f1498M = r3;
        r0 = r11.f1525x;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.f1515n;
        r0 = r11.mo350b(r0);
        r1 = r11.f1515n;
        r0 = r11.m2283b(r0, r7, r1);
        r11.f1504S = r0;
        r0 = r11.f1504S;
        if (r0 == 0) goto L_0x02d4;
    L_0x0155:
        r0 = r11.f1504S;
        r11.f1505T = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x02ca;
    L_0x015f:
        r0 = r11.f1504S;
        android.support.v4.view.ao.m3921b(r0, r3);
    L_0x0164:
        r0 = r11.f1495J;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.f1504S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.f1504S;
        r1 = r11.f1515n;
        r11.mo2188a(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x026d;
    L_0x0178:
        r0 = f1843a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.f1525x;
        if (r0 != 0) goto L_0x025d;
    L_0x0198:
        r0 = r11.f1493H;
        if (r0 == 0) goto L_0x0421;
    L_0x019c:
        r0 = r11.f1493H;
        r1 = -1;
        if (r0 != r1) goto L_0x01c2;
    L_0x01a1:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m2810a(r0);
    L_0x01c2:
        r0 = r10.f1859p;
        r1 = r11.f1493H;
        r0 = r0.mo357a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0211;
    L_0x01ce:
        r1 = r11.f1527z;
        if (r1 != 0) goto L_0x0211;
    L_0x01d2:
        r1 = r11.m2310m();	 Catch:{ NotFoundException -> 0x02d8 }
        r2 = r11.f1493H;	 Catch:{ NotFoundException -> 0x02d8 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x02d8 }
    L_0x01dc:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.f1493H;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.m2810a(r2);
    L_0x0211:
        r11.f1503R = r0;
        r1 = r11.f1515n;
        r1 = r11.mo350b(r1);
        r2 = r11.f1515n;
        r1 = r11.m2283b(r1, r0, r2);
        r11.f1504S = r1;
        r1 = r11.f1504S;
        if (r1 == 0) goto L_0x02e7;
    L_0x0225:
        r1 = r11.f1504S;
        r11.f1505T = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x02dd;
    L_0x022f:
        r1 = r11.f1504S;
        android.support.v4.view.ao.m3921b(r1, r3);
    L_0x0234:
        if (r0 == 0) goto L_0x024b;
    L_0x0236:
        r1 = r10.m2824a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0246;
    L_0x023c:
        r2 = r11.f1504S;
        r10.m2814b(r2, r1);
        r2 = r11.f1504S;
        r2.startAnimation(r1);
    L_0x0246:
        r1 = r11.f1504S;
        r0.addView(r1);
    L_0x024b:
        r0 = r11.f1495J;
        if (r0 == 0) goto L_0x0256;
    L_0x024f:
        r0 = r11.f1504S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0256:
        r0 = r11.f1504S;
        r1 = r11.f1515n;
        r11.mo2188a(r0, r1);
    L_0x025d:
        r0 = r11.f1515n;
        r11.m2306j(r0);
        r0 = r11.f1504S;
        if (r0 == 0) goto L_0x026b;
    L_0x0266:
        r0 = r11.f1515n;
        r11.m2298f(r0);
    L_0x026b:
        r11.f1515n = r7;
    L_0x026d:
        r0 = 2;
        if (r12 <= r0) goto L_0x0272;
    L_0x0270:
        r11.f1512k = r6;
    L_0x0272:
        if (r12 <= r6) goto L_0x0293;
    L_0x0274:
        r0 = f1843a;
        if (r0 == 0) goto L_0x0290;
    L_0x0278:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0290:
        r11.m2248I();
    L_0x0293:
        if (r12 <= r9) goto L_0x0045;
    L_0x0295:
        r0 = f1843a;
        if (r0 == 0) goto L_0x02b1;
    L_0x0299:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b1:
        r11.m2249J();
        r11.f1515n = r7;
        r11.f1516o = r7;
        goto L_0x0045;
    L_0x02ba:
        r0 = r11.f1491F;
        r0.m2276a(r11);
        goto L_0x0134;
    L_0x02c1:
        r0 = r11.f1515n;
        r11.m2300g(r0);
        r11.f1512k = r5;
        goto L_0x013d;
    L_0x02ca:
        r0 = r11.f1504S;
        r0 = android.support.v4.app.as.m2455a(r0);
        r11.f1504S = r0;
        goto L_0x0164;
    L_0x02d4:
        r11.f1505T = r7;
        goto L_0x0176;
    L_0x02d8:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x01dc;
    L_0x02dd:
        r1 = r11.f1504S;
        r1 = android.support.v4.app.as.m2455a(r1);
        r11.f1504S = r1;
        goto L_0x0234;
    L_0x02e7:
        r11.f1505T = r7;
        goto L_0x025d;
    L_0x02eb:
        r0 = r11.f1512k;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ef:
        r0 = r11.f1512k;
        switch(r0) {
            case 1: goto L_0x02f6;
            case 2: goto L_0x0374;
            case 3: goto L_0x0353;
            case 4: goto L_0x0332;
            case 5: goto L_0x0310;
            default: goto L_0x02f4;
        };
    L_0x02f4:
        goto L_0x0045;
    L_0x02f6:
        if (r12 >= r5) goto L_0x0045;
    L_0x02f8:
        r0 = r10.f1863u;
        if (r0 == 0) goto L_0x0307;
    L_0x02fc:
        r0 = r11.f1513l;
        if (r0 == 0) goto L_0x0307;
    L_0x0300:
        r0 = r11.f1513l;
        r11.f1513l = r7;
        r0.clearAnimation();
    L_0x0307:
        r0 = r11.f1513l;
        if (r0 == 0) goto L_0x03e3;
    L_0x030b:
        r11.f1514m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0310:
        r0 = 5;
        if (r12 >= r0) goto L_0x0332;
    L_0x0313:
        r0 = f1843a;
        if (r0 == 0) goto L_0x032f;
    L_0x0317:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x032f:
        r11.m2251L();
    L_0x0332:
        if (r12 >= r9) goto L_0x0353;
    L_0x0334:
        r0 = f1843a;
        if (r0 == 0) goto L_0x0350;
    L_0x0338:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0350:
        r11.m2252M();
    L_0x0353:
        if (r12 >= r6) goto L_0x0374;
    L_0x0355:
        r0 = f1843a;
        if (r0 == 0) goto L_0x0371;
    L_0x0359:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0371:
        r11.m2253N();
    L_0x0374:
        r0 = 2;
        if (r12 >= r0) goto L_0x02f6;
    L_0x0377:
        r0 = f1843a;
        if (r0 == 0) goto L_0x0393;
    L_0x037b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0393:
        r0 = r11.f1504S;
        if (r0 == 0) goto L_0x03a6;
    L_0x0397:
        r0 = r10.f1858o;
        r0 = r0.mo361a(r11);
        if (r0 == 0) goto L_0x03a6;
    L_0x039f:
        r0 = r11.f1516o;
        if (r0 != 0) goto L_0x03a6;
    L_0x03a3:
        r10.m2862f(r11);
    L_0x03a6:
        r11.m2254O();
        r0 = r11.f1504S;
        if (r0 == 0) goto L_0x03db;
    L_0x03ad:
        r0 = r11.f1503R;
        if (r0 == 0) goto L_0x03db;
    L_0x03b1:
        r0 = r10.f1857n;
        if (r0 <= 0) goto L_0x041f;
    L_0x03b5:
        r0 = r10.f1863u;
        if (r0 != 0) goto L_0x041f;
    L_0x03b9:
        r0 = r10.m2824a(r11, r13, r3, r14);
    L_0x03bd:
        if (r0 == 0) goto L_0x03d4;
    L_0x03bf:
        r1 = r11.f1504S;
        r11.f1513l = r1;
        r11.f1514m = r12;
        r1 = r11.f1504S;
        r2 = new android.support.v4.app.ab;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f1504S;
        r1.startAnimation(r0);
    L_0x03d4:
        r0 = r11.f1503R;
        r1 = r11.f1504S;
        r0.removeView(r1);
    L_0x03db:
        r11.f1503R = r7;
        r11.f1504S = r7;
        r11.f1505T = r7;
        goto L_0x02f6;
    L_0x03e3:
        r0 = f1843a;
        if (r0 == 0) goto L_0x03ff;
    L_0x03e7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ff:
        r0 = r11.f1498M;
        if (r0 != 0) goto L_0x0414;
    L_0x0403:
        r11.m2255P();
    L_0x0406:
        r11.m2256Q();
        if (r15 != 0) goto L_0x0045;
    L_0x040b:
        r0 = r11.f1498M;
        if (r0 != 0) goto L_0x0417;
    L_0x040f:
        r10.m2858e(r11);
        goto L_0x0045;
    L_0x0414:
        r11.f1512k = r3;
        goto L_0x0406;
    L_0x0417:
        r11.f1488C = r7;
        r11.f1491F = r7;
        r11.f1487B = r7;
        goto L_0x0045;
    L_0x041f:
        r0 = r7;
        goto L_0x03bd;
    L_0x0421:
        r0 = r7;
        goto L_0x0211;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.y.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m2852c(Fragment fragment) {
        m2833a(fragment, this.f1857n, 0, 0, false);
    }

    void m2828a(int i, boolean z) {
        m2826a(i, 0, 0, z);
    }

    void m2826a(int i, int i2, int i3, boolean z) {
        if (this.f1858o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f1857n != i) {
            this.f1857n = i;
            if (this.f1849f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f1849f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f1849f.get(i4);
                    if (fragment != null) {
                        m2833a(fragment, i, i2, i3, false);
                        if (fragment.f1508W != null) {
                            a = i5 | fragment.f1508W.mo310a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m2861f();
                }
                if (this.f1861s && this.f1858o != null && this.f1857n == 5) {
                    this.f1858o.mo364c();
                    this.f1861s = false;
                }
            }
        }
    }

    void m2861f() {
        if (this.f1849f != null) {
            for (int i = 0; i < this.f1849f.size(); i++) {
                Fragment fragment = (Fragment) this.f1849f.get(i);
                if (fragment != null) {
                    m2843b(fragment);
                }
            }
        }
    }

    void m2856d(Fragment fragment) {
        if (fragment.f1517p < 0) {
            if (this.f1851h == null || this.f1851h.size() <= 0) {
                if (this.f1849f == null) {
                    this.f1849f = new ArrayList();
                }
                fragment.m2263a(this.f1849f.size(), this.f1860q);
                this.f1849f.add(fragment);
            } else {
                fragment.m2263a(((Integer) this.f1851h.remove(this.f1851h.size() - 1)).intValue(), this.f1860q);
                this.f1849f.set(fragment.f1517p, fragment);
            }
            if (f1843a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m2858e(Fragment fragment) {
        if (fragment.f1517p >= 0) {
            if (f1843a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f1849f.set(fragment.f1517p, null);
            if (this.f1851h == null) {
                this.f1851h = new ArrayList();
            }
            this.f1851h.add(Integer.valueOf(fragment.f1517p));
            this.f1858o.m2720a(fragment.f1518q);
            fragment.m2321x();
        }
    }

    public void m2834a(Fragment fragment, boolean z) {
        if (this.f1850g == null) {
            this.f1850g = new ArrayList();
        }
        if (f1843a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m2856d(fragment);
        if (!fragment.f1496K) {
            if (this.f1850g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f1850g.add(fragment);
            fragment.f1523v = true;
            fragment.f1524w = false;
            if (fragment.f1499N && fragment.f1500O) {
                this.f1861s = true;
            }
            if (z) {
                m2852c(fragment);
            }
        }
    }

    public void m2832a(Fragment fragment, int i, int i2) {
        if (f1843a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f1486A);
        }
        boolean z = !fragment.m2304i();
        if (!fragment.f1496K || z) {
            int i3;
            if (this.f1850g != null) {
                this.f1850g.remove(fragment);
            }
            if (fragment.f1499N && fragment.f1500O) {
                this.f1861s = true;
            }
            fragment.f1523v = false;
            fragment.f1524w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m2833a(fragment, i3, i, i2, false);
        }
    }

    public void m2844b(Fragment fragment, int i, int i2) {
        if (f1843a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f1495J) {
            fragment.f1495J = true;
            if (fragment.f1504S != null) {
                Animation a = m2824a(fragment, i, false, i2);
                if (a != null) {
                    m2814b(fragment.f1504S, a);
                    fragment.f1504S.startAnimation(a);
                }
                fragment.f1504S.setVisibility(8);
            }
            if (fragment.f1523v && fragment.f1499N && fragment.f1500O) {
                this.f1861s = true;
            }
            fragment.m2287c(true);
        }
    }

    public void m2853c(Fragment fragment, int i, int i2) {
        if (f1843a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f1495J) {
            fragment.f1495J = false;
            if (fragment.f1504S != null) {
                Animation a = m2824a(fragment, i, true, i2);
                if (a != null) {
                    m2814b(fragment.f1504S, a);
                    fragment.f1504S.startAnimation(a);
                }
                fragment.f1504S.setVisibility(0);
            }
            if (fragment.f1523v && fragment.f1499N && fragment.f1500O) {
                this.f1861s = true;
            }
            fragment.m2287c(false);
        }
    }

    public void m2857d(Fragment fragment, int i, int i2) {
        if (f1843a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f1496K) {
            fragment.f1496K = true;
            if (fragment.f1523v) {
                if (this.f1850g != null) {
                    if (f1843a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f1850g.remove(fragment);
                }
                if (fragment.f1499N && fragment.f1500O) {
                    this.f1861s = true;
                }
                fragment.f1523v = false;
                m2833a(fragment, 1, i, i2, false);
            }
        }
    }

    public void m2859e(Fragment fragment, int i, int i2) {
        if (f1843a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f1496K) {
            fragment.f1496K = false;
            if (!fragment.f1523v) {
                if (this.f1850g == null) {
                    this.f1850g = new ArrayList();
                }
                if (this.f1850g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f1843a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f1850g.add(fragment);
                fragment.f1523v = true;
                if (fragment.f1499N && fragment.f1500O) {
                    this.f1861s = true;
                }
                m2833a(fragment, this.f1857n, i, i2, false);
            }
        }
    }

    public Fragment mo375a(int i) {
        int size;
        Fragment fragment;
        if (this.f1850g != null) {
            for (size = this.f1850g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1850g.get(size);
                if (fragment != null && fragment.f1492G == i) {
                    return fragment;
                }
            }
        }
        if (this.f1849f != null) {
            for (size = this.f1849f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1849f.get(size);
                if (fragment != null && fragment.f1492G == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment mo377a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f1850g == null || str == null)) {
            for (size = this.f1850g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1850g.get(size);
                if (fragment != null && str.equals(fragment.f1494I)) {
                    return fragment;
                }
            }
        }
        if (!(this.f1849f == null || str == null)) {
            for (size = this.f1849f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1849f.get(size);
                if (fragment != null && str.equals(fragment.f1494I)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m2842b(String str) {
        if (!(this.f1849f == null || str == null)) {
            for (int size = this.f1849f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f1849f.get(size);
                if (fragment != null) {
                    fragment = fragment.m2257a(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void m2816x() {
        if (this.f1862t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f1864v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f1864v);
        }
    }

    public void m2836a(Runnable runnable, boolean z) {
        if (!z) {
            m2816x();
        }
        synchronized (this) {
            if (this.f1863u || this.f1858o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f1846c == null) {
                this.f1846c = new ArrayList();
            }
            this.f1846c.add(runnable);
            if (this.f1846c.size() == 1) {
                this.f1858o.m2733h().removeCallbacks(this.f1868z);
                this.f1858o.m2733h().post(this.f1868z);
            }
        }
    }

    public int m2817a(C0381g c0381g) {
        int size;
        synchronized (this) {
            if (this.f1855l == null || this.f1855l.size() <= 0) {
                if (this.f1854k == null) {
                    this.f1854k = new ArrayList();
                }
                size = this.f1854k.size();
                if (f1843a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0381g);
                }
                this.f1854k.add(c0381g);
            } else {
                size = ((Integer) this.f1855l.remove(this.f1855l.size() - 1)).intValue();
                if (f1843a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0381g);
                }
                this.f1854k.set(size, c0381g);
            }
        }
        return size;
    }

    public void m2827a(int i, C0381g c0381g) {
        synchronized (this) {
            if (this.f1854k == null) {
                this.f1854k = new ArrayList();
            }
            int size = this.f1854k.size();
            if (i < size) {
                if (f1843a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0381g);
                }
                this.f1854k.set(i, c0381g);
            } else {
                while (size < i) {
                    this.f1854k.add(null);
                    if (this.f1855l == null) {
                        this.f1855l = new ArrayList();
                    }
                    if (f1843a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f1855l.add(Integer.valueOf(size));
                    size++;
                }
                if (f1843a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0381g);
                }
                this.f1854k.add(c0381g);
            }
        }
    }

    public void m2851c(int i) {
        synchronized (this) {
            this.f1854k.set(i, null);
            if (this.f1855l == null) {
                this.f1855l = new ArrayList();
            }
            if (f1843a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f1855l.add(Integer.valueOf(i));
        }
    }

    public void m2847b(Runnable runnable, boolean z) {
        if (this.f1848e) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.f1858o.m2733h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                m2816x();
            }
            this.f1848e = true;
            runnable.run();
            this.f1848e = false;
            m2865h();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2864g() {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r0 = r6.f1848e;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "FragmentManager is already executing transactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = android.os.Looper.myLooper();
        r3 = r6.f1858o;
        r3 = r3.m2733h();
        r3 = r3.getLooper();
        if (r0 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of fragment host";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f1846c;	 Catch:{ all -> 0x0078 }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f1846c;	 Catch:{ all -> 0x0078 }
        r3 = r3.size();	 Catch:{ all -> 0x0078 }
        if (r3 != 0) goto L_0x0039;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.m2865h();
        return r0;
    L_0x0039:
        r0 = r6.f1846c;	 Catch:{ all -> 0x0078 }
        r3 = r0.size();	 Catch:{ all -> 0x0078 }
        r0 = r6.f1847d;	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0048;
    L_0x0043:
        r0 = r6.f1847d;	 Catch:{ all -> 0x0078 }
        r0 = r0.length;	 Catch:{ all -> 0x0078 }
        if (r0 >= r3) goto L_0x004c;
    L_0x0048:
        r0 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0078 }
        r6.f1847d = r0;	 Catch:{ all -> 0x0078 }
    L_0x004c:
        r0 = r6.f1846c;	 Catch:{ all -> 0x0078 }
        r4 = r6.f1847d;	 Catch:{ all -> 0x0078 }
        r0.toArray(r4);	 Catch:{ all -> 0x0078 }
        r0 = r6.f1846c;	 Catch:{ all -> 0x0078 }
        r0.clear();	 Catch:{ all -> 0x0078 }
        r0 = r6.f1858o;	 Catch:{ all -> 0x0078 }
        r0 = r0.m2733h();	 Catch:{ all -> 0x0078 }
        r4 = r6.f1868z;	 Catch:{ all -> 0x0078 }
        r0.removeCallbacks(r4);	 Catch:{ all -> 0x0078 }
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.f1848e = r2;
        r0 = r1;
    L_0x0067:
        if (r0 >= r3) goto L_0x007b;
    L_0x0069:
        r4 = r6.f1847d;
        r4 = r4[r0];
        r4.run();
        r4 = r6.f1847d;
        r5 = 0;
        r4[r0] = r5;
        r0 = r0 + 1;
        goto L_0x0067;
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        throw r0;
    L_0x007b:
        r6.f1848e = r1;
        r0 = r2;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.y.g():boolean");
    }

    void m2865h() {
        if (this.f1865w) {
            int i = 0;
            for (int i2 = 0; i2 < this.f1849f.size(); i2++) {
                Fragment fragment = (Fragment) this.f1849f.get(i2);
                if (!(fragment == null || fragment.f1508W == null)) {
                    i |= fragment.f1508W.mo310a();
                }
            }
            if (i == 0) {
                this.f1865w = false;
                m2861f();
            }
        }
    }

    void m2866i() {
        if (this.f1856m != null) {
            for (int i = 0; i < this.f1856m.size(); i++) {
                ((C0400a) this.f1856m.get(i)).m2794a();
            }
        }
    }

    void m2845b(C0381g c0381g) {
        if (this.f1852i == null) {
            this.f1852i = new ArrayList();
        }
        this.f1852i.add(c0381g);
        m2866i();
    }

    boolean m2838a(Handler handler, String str, int i, int i2) {
        if (this.f1852i == null) {
            return false;
        }
        int size;
        C0381g c0381g;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f1852i.size() - 1;
            if (size < 0) {
                return false;
            }
            c0381g = (C0381g) this.f1852i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            if (this.f1857n >= 1) {
                c0381g.m2682a(sparseArray, sparseArray2);
            }
            c0381g.m2679a(true, null, sparseArray, sparseArray2);
            m2866i();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f1852i.size() - 1;
                while (size2 >= 0) {
                    c0381g = (C0381g) this.f1852i.get(size2);
                    if ((str != null && str.equals(c0381g.m2688e())) || (i >= 0 && i == c0381g.f1776p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0381g = (C0381g) this.f1852i.get(size2);
                        if ((str == null || !str.equals(c0381g.m2688e())) && (i < 0 || i != c0381g.f1776p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f1852i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f1852i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f1852i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            if (this.f1857n >= 1) {
                for (size2 = 0; size2 <= size3; size2++) {
                    ((C0381g) arrayList.get(size2)).m2682a(sparseArray3, sparseArray4);
                }
            }
            C0380b c0380b = null;
            int i3 = 0;
            while (i3 <= size3) {
                boolean z;
                if (f1843a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                c0381g = (C0381g) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                i3++;
                c0380b = c0381g.m2679a(z, c0380b, sparseArray3, sparseArray4);
            }
            m2866i();
        }
        return true;
    }

    ad m2867j() {
        List list;
        List list2;
        if (this.f1849f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f1849f.size()) {
                ArrayList arrayList;
                Fragment fragment = (Fragment) this.f1849f.get(i);
                if (fragment != null) {
                    boolean z;
                    if (fragment.f1497L) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        fragment.f1498M = true;
                        fragment.f1521t = fragment.f1520s != null ? fragment.f1520s.f1517p : -1;
                        if (f1843a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                        }
                    }
                    if (fragment.f1489D != null) {
                        ad j = fragment.f1489D.m2867j();
                        if (j != null) {
                            ArrayList arrayList2;
                            if (list == null) {
                                arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    arrayList2.add(null);
                                }
                            } else {
                                arrayList2 = list;
                            }
                            arrayList2.add(j);
                            list = arrayList2;
                            z = true;
                            if (!(list == null || r0)) {
                                list.add(null);
                            }
                        }
                    }
                    z = false;
                    list.add(null);
                }
                i++;
                Object obj = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            return null;
        }
        return new ad(list2, list);
    }

    void m2862f(Fragment fragment) {
        if (fragment.f1505T != null) {
            if (this.f1867y == null) {
                this.f1867y = new SparseArray();
            } else {
                this.f1867y.clear();
            }
            fragment.f1505T.saveHierarchyState(this.f1867y);
            if (this.f1867y.size() > 0) {
                fragment.f1516o = this.f1867y;
                this.f1867y = null;
            }
        }
    }

    Bundle m2863g(Fragment fragment) {
        Bundle bundle;
        if (this.f1866x == null) {
            this.f1866x = new Bundle();
        }
        fragment.m2308k(this.f1866x);
        if (this.f1866x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f1866x;
            this.f1866x = null;
        }
        if (fragment.f1504S != null) {
            m2862f(fragment);
        }
        if (fragment.f1516o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f1516o);
        }
        if (!fragment.f1507V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f1507V);
        }
        return bundle;
    }

    Parcelable m2868k() {
        BackStackState[] backStackStateArr = null;
        m2864g();
        if (f1844b) {
            this.f1862t = true;
        }
        if (this.f1849f == null || this.f1849f.size() <= 0) {
            return null;
        }
        int size = this.f1849f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f1849f.get(i);
            if (fragment != null) {
                if (fragment.f1517p < 0) {
                    m2810a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f1517p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f1512k <= 0 || fragmentState.f1541k != null) {
                    fragmentState.f1541k = fragment.f1515n;
                } else {
                    fragmentState.f1541k = m2863g(fragment);
                    if (fragment.f1520s != null) {
                        if (fragment.f1520s.f1517p < 0) {
                            m2810a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f1520s));
                        }
                        if (fragmentState.f1541k == null) {
                            fragmentState.f1541k = new Bundle();
                        }
                        mo381a(fragmentState.f1541k, "android:target_state", fragment.f1520s);
                        if (fragment.f1522u != 0) {
                            fragmentState.f1541k.putInt("android:target_req_state", fragment.f1522u);
                        }
                    }
                }
                if (f1843a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f1541k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f1850g != null) {
                i = this.f1850g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f1850g.get(i2)).f1517p;
                        if (iArr[i2] < 0) {
                            m2810a(new IllegalStateException("Failure saving state: active " + this.f1850g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f1843a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f1850g.get(i2));
                        }
                    }
                    if (this.f1852i != null) {
                        i = this.f1852i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((C0381g) this.f1852i.get(i2));
                                if (f1843a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1852i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f1528a = fragmentStateArr;
                    fragmentManagerState.f1529b = iArr;
                    fragmentManagerState.f1530c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f1852i != null) {
                i = this.f1852i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((C0381g) this.f1852i.get(i2));
                        if (f1843a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1852i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f1528a = fragmentStateArr;
            fragmentManagerState.f1529b = iArr;
            fragmentManagerState.f1530c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f1843a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m2831a(Parcelable parcelable, ad adVar) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f1528a != null) {
                List a;
                int size;
                int i;
                Fragment fragment;
                List list;
                if (adVar != null) {
                    a = adVar.m2334a();
                    List b = adVar.m2335b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean z = false;
                    }
                    for (i = 0; i < size; i++) {
                        fragment = (Fragment) a.get(i);
                        if (f1843a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f1528a[fragment.f1517p];
                        fragmentState.f1542l = fragment;
                        fragment.f1516o = null;
                        fragment.f1486A = 0;
                        fragment.f1526y = false;
                        fragment.f1523v = false;
                        fragment.f1520s = null;
                        if (fragmentState.f1541k != null) {
                            fragmentState.f1541k.setClassLoader(this.f1858o.m2732g().getClassLoader());
                            fragment.f1516o = fragmentState.f1541k.getSparseParcelableArray("android:view_state");
                            fragment.f1515n = fragmentState.f1541k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f1849f = new ArrayList(fragmentManagerState.f1528a.length);
                if (this.f1851h != null) {
                    this.f1851h.clear();
                }
                int i2 = 0;
                while (i2 < fragmentManagerState.f1528a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.f1528a[i2];
                    if (fragmentState2 != null) {
                        ad adVar2;
                        if (list == null || i2 >= list.size()) {
                            adVar2 = null;
                        } else {
                            adVar2 = (ad) list.get(i2);
                        }
                        fragment = fragmentState2.m2324a(this.f1858o, this.f1860q, adVar2);
                        if (f1843a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + fragment);
                        }
                        this.f1849f.add(fragment);
                        fragmentState2.f1542l = null;
                    } else {
                        this.f1849f.add(null);
                        if (this.f1851h == null) {
                            this.f1851h = new ArrayList();
                        }
                        if (f1843a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f1851h.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                if (adVar != null) {
                    a = adVar.m2334a();
                    if (a != null) {
                        i2 = a.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (i = 0; i < i2; i++) {
                        fragment = (Fragment) a.get(i);
                        if (fragment.f1521t >= 0) {
                            if (fragment.f1521t < this.f1849f.size()) {
                                fragment.f1520s = (Fragment) this.f1849f.get(fragment.f1521t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f1521t);
                                fragment.f1520s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f1529b != null) {
                    this.f1850g = new ArrayList(fragmentManagerState.f1529b.length);
                    for (size = 0; size < fragmentManagerState.f1529b.length; size++) {
                        fragment = (Fragment) this.f1849f.get(fragmentManagerState.f1529b[size]);
                        if (fragment == null) {
                            m2810a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f1529b[size]));
                        }
                        fragment.f1523v = true;
                        if (f1843a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + fragment);
                        }
                        if (this.f1850g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f1850g.add(fragment);
                    }
                } else {
                    this.f1850g = null;
                }
                if (fragmentManagerState.f1530c != null) {
                    this.f1852i = new ArrayList(fragmentManagerState.f1530c.length);
                    for (int i3 = 0; i3 < fragmentManagerState.f1530c.length; i3++) {
                        C0381g a2 = fragmentManagerState.f1530c[i3].m2236a(this);
                        if (f1843a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + a2.f1776p + "): " + a2);
                            a2.m2684a("  ", new PrintWriter(new C0500e("FragmentManager")), false);
                        }
                        this.f1852i.add(a2);
                        if (a2.f1776p >= 0) {
                            m2827a(a2.f1776p, a2);
                        }
                    }
                    return;
                }
                this.f1852i = null;
            }
        }
    }

    public void m2835a(C0394w c0394w, C0391u c0391u, Fragment fragment) {
        if (this.f1858o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1858o = c0394w;
        this.f1859p = c0391u;
        this.f1860q = fragment;
    }

    public void m2869l() {
        this.f1862t = false;
    }

    public void m2870m() {
        this.f1862t = false;
        m2828a(1, false);
    }

    public void m2871n() {
        this.f1862t = false;
        m2828a(2, false);
    }

    public void m2872o() {
        this.f1862t = false;
        m2828a(4, false);
    }

    public void m2873p() {
        this.f1862t = false;
        m2828a(5, false);
    }

    public void m2874q() {
        m2828a(4, false);
    }

    public void m2875r() {
        this.f1862t = true;
        m2828a(3, false);
    }

    public void m2876s() {
        m2828a(2, false);
    }

    public void m2877t() {
        m2828a(1, false);
    }

    public void m2878u() {
        this.f1863u = true;
        m2864g();
        m2828a(0, false);
        this.f1858o = null;
        this.f1859p = null;
        this.f1860q = null;
    }

    public void m2829a(Configuration configuration) {
        if (this.f1850g != null) {
            for (int i = 0; i < this.f1850g.size(); i++) {
                Fragment fragment = (Fragment) this.f1850g.get(i);
                if (fragment != null) {
                    fragment.m2273a(configuration);
                }
            }
        }
    }

    public void m2879v() {
        if (this.f1850g != null) {
            for (int i = 0; i < this.f1850g.size(); i++) {
                Fragment fragment = (Fragment) this.f1850g.get(i);
                if (fragment != null) {
                    fragment.m2250K();
                }
            }
        }
    }

    public boolean m2840a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f1850g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f1850g.size()) {
                fragment = (Fragment) this.f1850g.get(i2);
                if (fragment != null && fragment.m2285b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f1853j != null) {
            while (i < this.f1853j.size()) {
                fragment = (Fragment) this.f1853j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m2322y();
                }
                i++;
            }
        }
        this.f1853j = arrayList;
        return z;
    }

    public boolean m2839a(Menu menu) {
        if (this.f1850g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f1850g.size(); i++) {
            Fragment fragment = (Fragment) this.f1850g.get(i);
            if (fragment != null && fragment.m2288c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m2841a(MenuItem menuItem) {
        if (this.f1850g == null) {
            return false;
        }
        for (int i = 0; i < this.f1850g.size(); i++) {
            Fragment fragment = (Fragment) this.f1850g.get(i);
            if (fragment != null && fragment.m2289c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m2850b(MenuItem menuItem) {
        if (this.f1850g == null) {
            return false;
        }
        for (int i = 0; i < this.f1850g.size(); i++) {
            Fragment fragment = (Fragment) this.f1850g.get(i);
            if (fragment != null && fragment.m2293d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m2846b(Menu menu) {
        if (this.f1850g != null) {
            for (int i = 0; i < this.f1850g.size(); i++) {
                Fragment fragment = (Fragment) this.f1850g.get(i);
                if (fragment != null) {
                    fragment.m2291d(menu);
                }
            }
        }
    }

    public static int m2815d(int i) {
        switch (i) {
            case DfuBaseService.ERROR_FILE_NOT_FOUND /*4097*/:
                return 8194;
            case DfuBaseService.ERROR_FILE_INVALID /*4099*/:
                return DfuBaseService.ERROR_FILE_INVALID;
            case 8194:
                return DfuBaseService.ERROR_FILE_NOT_FOUND;
            default:
                return 0;
        }
    }

    public static int m2813b(int i, boolean z) {
        switch (i) {
            case DfuBaseService.ERROR_FILE_NOT_FOUND /*4097*/:
                return z ? 1 : 2;
            case DfuBaseService.ERROR_FILE_INVALID /*4099*/:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View mo379a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0402b.f1838a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m2239b(this.f1858o.m2732g(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? mo375a(resourceId) : null;
        if (a == null && string2 != null) {
            a = mo377a(string2);
        }
        if (a == null && id != -1) {
            a = mo375a(id);
        }
        if (f1843a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.m2237a(context, string);
            a2.f1525x = true;
            a2.f1492G = resourceId != 0 ? resourceId : id;
            a2.f1493H = id;
            a2.f1494I = string2;
            a2.f1526y = true;
            a2.f1487B = this;
            a2.f1488C = this.f1858o;
            a2.m2268a(this.f1858o.m2732g(), attributeSet, a2.f1515n);
            m2834a(a2, true);
            fragment = a2;
        } else if (a.f1526y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f1526y = true;
            a.f1488C = this.f1858o;
            if (!a.f1498M) {
                a.m2268a(this.f1858o.m2732g(), attributeSet, a.f1515n);
            }
            fragment = a;
        }
        if (this.f1857n >= 1 || !fragment.f1525x) {
            m2852c(fragment);
        } else {
            m2833a(fragment, 1, 0, 0, false);
        }
        if (fragment.f1504S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f1504S.setId(resourceId);
        }
        if (fragment.f1504S.getTag() == null) {
            fragment.f1504S.setTag(string2);
        }
        return fragment.f1504S;
    }

    C0403s m2880w() {
        return this;
    }
}
