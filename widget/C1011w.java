package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p011a.p012a.C0167b;
import android.support.p011a.p012a.C0181h;
import android.support.v4.p013c.C0461a;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.p021b.C0307a;
import android.support.v4.p024g.C0495a;
import android.support.v4.p024g.C0501f;
import android.support.v4.p024g.C0502g;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0833c;
import android.support.v7.p028b.C0842a.C0835e;
import android.support.v7.p029c.p030a.C0845b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class C1011w {
    private static final Mode f3923a = Mode.SRC_IN;
    private static C1011w f3924b;
    private static final C1009b f3925c = new C1009b(6);
    private static final int[] f3926d = new int[]{C0835e.abc_textfield_search_default_mtrl_alpha, C0835e.abc_textfield_default_mtrl_alpha, C0835e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f3927e = new int[]{C0835e.abc_ic_commit_search_api_mtrl_alpha, C0835e.abc_seekbar_tick_mark_material, C0835e.abc_ic_menu_share_mtrl_alpha, C0835e.abc_ic_menu_copy_mtrl_am_alpha, C0835e.abc_ic_menu_cut_mtrl_alpha, C0835e.abc_ic_menu_selectall_mtrl_alpha, C0835e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f3928f = new int[]{C0835e.abc_textfield_activated_mtrl_alpha, C0835e.abc_textfield_search_activated_mtrl_alpha, C0835e.abc_cab_background_top_mtrl_alpha, C0835e.abc_text_cursor_material};
    private static final int[] f3929g = new int[]{C0835e.abc_popup_background_mtrl_mult, C0835e.abc_cab_background_internal_bg, C0835e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f3930h = new int[]{C0835e.abc_tab_indicator_material, C0835e.abc_textfield_search_material};
    private static final int[] f3931i = new int[]{C0835e.abc_btn_check_material, C0835e.abc_btn_radio_material};
    private WeakHashMap<Context, SparseArray<ColorStateList>> f3932j;
    private C0495a<String, C1007c> f3933k;
    private SparseArray<String> f3934l;
    private final Object f3935m = new Object();
    private final WeakHashMap<Context, C0501f<WeakReference<ConstantState>>> f3936n = new WeakHashMap(0);
    private TypedValue f3937o;
    private boolean f3938p;

    private interface C1007c {
        Drawable mo1089a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class C1008a implements C1007c {
        private C1008a() {
        }

        public Drawable mo1089a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0167b.m1038a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class C1009b extends C0502g<Integer, PorterDuffColorFilter> {
        public C1009b(int i) {
            super(i);
        }

        PorterDuffColorFilter m7245a(int i, Mode mode) {
            return (PorterDuffColorFilter) m3152a((Object) Integer.valueOf(C1009b.m7244b(i, mode)));
        }

        PorterDuffColorFilter m7246a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m3153a(Integer.valueOf(C1009b.m7244b(i, mode)), porterDuffColorFilter);
        }

        private static int m7244b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    private static class C1010d implements C1007c {
        private C1010d() {
        }

        public Drawable mo1089a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0181h.m1101a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static C1011w m7254a() {
        if (f3924b == null) {
            f3924b = new C1011w();
            C1011w.m7258a(f3924b);
        }
        return f3924b;
    }

    private static void m7258a(C1011w c1011w) {
        int i = VERSION.SDK_INT;
        if (i < 23) {
            c1011w.m7259a("vector", new C1010d());
            if (i >= 11) {
                c1011w.m7259a("animated-vector", new C1008a());
            }
        }
    }

    public Drawable m7272a(Context context, int i) {
        return m7273a(context, i, false);
    }

    public Drawable m7273a(Context context, int i, boolean z) {
        m7268d(context);
        Drawable d = m7267d(context, i);
        if (d == null) {
            d = m7266c(context, i);
        }
        if (d == null) {
            d = C0307a.m2325a(context, i);
        }
        if (d != null) {
            d = m7252a(context, i, z, d);
        }
        if (d != null) {
            az.m6864b(d);
        }
        return d;
    }

    private static long m7248a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable m7266c(Context context, int i) {
        if (this.f3937o == null) {
            this.f3937o = new TypedValue();
        }
        TypedValue typedValue = this.f3937o;
        context.getResources().getValue(i, typedValue, true);
        long a = C1011w.m7248a(typedValue);
        Drawable a2 = m7253a(context, a);
        if (a2 == null) {
            if (i == C0835e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m7272a(context, C0835e.abc_cab_background_internal_bg), m7272a(context, C0835e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m7261a(context, a, a2);
            }
        }
        return a2;
    }

    private Drawable m7252a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m7275b(context, i);
        if (b != null) {
            if (az.m6865c(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0441a.m3002f(drawable);
            C0441a.m2992a(drawable, b);
            Mode a = m7271a(i);
            if (a == null) {
                return drawable;
            }
            C0441a.m2995a(drawable, a);
            return drawable;
        } else if (i == C0835e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C1011w.m7256a(r0.findDrawableByLayerId(16908288), cz.m7054a(context, C0831a.colorControlNormal), f3923a);
            C1011w.m7256a(r0.findDrawableByLayerId(16908303), cz.m7054a(context, C0831a.colorControlNormal), f3923a);
            C1011w.m7256a(r0.findDrawableByLayerId(16908301), cz.m7054a(context, C0831a.colorControlActivated), f3923a);
            return drawable;
        } else if (i == C0835e.abc_ratingbar_material || i == C0835e.abc_ratingbar_indicator_material || i == C0835e.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            C1011w.m7256a(r0.findDrawableByLayerId(16908288), cz.m7058c(context, C0831a.colorControlNormal), f3923a);
            C1011w.m7256a(r0.findDrawableByLayerId(16908303), cz.m7054a(context, C0831a.colorControlActivated), f3923a);
            C1011w.m7256a(r0.findDrawableByLayerId(16908301), cz.m7054a(context, C0831a.colorControlActivated), f3923a);
            return drawable;
        } else if (C1011w.m7260a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m7267d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f3933k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f3933k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f3934l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f3934l;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f3933k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r9.f3934l = r0;
    L_0x0036:
        r0 = r9.f3937o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f3937o = r0;
    L_0x0041:
        r2 = r9.f3937o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C1011w.m7248a(r2);
        r1 = r9.m7253a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f3934l;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f3934l;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f3933k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C1011w.C1007c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.mo1089a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m7261a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.w.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m7253a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.f3935m;
        monitor-enter(r3);
        r0 = r4.f3936n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.p024g.C0501f) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.m3142a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.m3147b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.w.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean m7261a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f3935m) {
            C0501f c0501f = (C0501f) this.f3936n.get(context);
            if (c0501f == null) {
                c0501f = new C0501f();
                this.f3936n.put(context, c0501f);
            }
            c0501f.m3148b(j, new WeakReference(constantState));
        }
        return true;
    }

    public final Drawable m7274a(Context context, dm dmVar, int i) {
        Drawable d = m7267d(context, i);
        if (d == null) {
            d = dmVar.m7141a(i);
        }
        if (d != null) {
            return m7252a(context, i, false, d);
        }
        return null;
    }

    static boolean m7260a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f3923a;
        if (C1011w.m7263a(f3926d, i)) {
            i2 = C0831a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C1011w.m7263a(f3928f, i)) {
            i2 = C0831a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C1011w.m7263a(f3929g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0835e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == C0835e.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            i3 = -1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (az.m6865c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C1011w.m7250a(cz.m7054a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void m7259a(String str, C1007c c1007c) {
        if (this.f3933k == null) {
            this.f3933k = new C0495a();
        }
        this.f3933k.put(str, c1007c);
    }

    private static boolean m7263a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    final Mode m7271a(int i) {
        if (i == C0835e.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    public final ColorStateList m7275b(Context context, int i) {
        ColorStateList e = m7269e(context, i);
        if (e == null) {
            if (i == C0835e.abc_edit_text_material) {
                e = C0845b.m5468a(context, C0833c.abc_tint_edittext);
            } else if (i == C0835e.abc_switch_track_mtrl_alpha) {
                e = C0845b.m5468a(context, C0833c.abc_tint_switch_track);
            } else if (i == C0835e.abc_switch_thumb_material) {
                e = C0845b.m5468a(context, C0833c.abc_tint_switch_thumb);
            } else if (i == C0835e.abc_btn_default_mtrl_shape) {
                e = m7249a(context);
            } else if (i == C0835e.abc_btn_borderless_material) {
                e = m7264b(context);
            } else if (i == C0835e.abc_btn_colored_material) {
                e = m7265c(context);
            } else if (i == C0835e.abc_spinner_mtrl_am_alpha || i == C0835e.abc_spinner_textfield_background_material) {
                e = C0845b.m5468a(context, C0833c.abc_tint_spinner);
            } else if (C1011w.m7263a(f3927e, i)) {
                e = cz.m7057b(context, C0831a.colorControlNormal);
            } else if (C1011w.m7263a(f3930h, i)) {
                e = C0845b.m5468a(context, C0833c.abc_tint_default);
            } else if (C1011w.m7263a(f3931i, i)) {
                e = C0845b.m5468a(context, C0833c.abc_tint_btn_checkable);
            } else if (i == C0835e.abc_seekbar_thumb_material) {
                e = C0845b.m5468a(context, C0833c.abc_tint_seek_thumb);
            }
            if (e != null) {
                m7255a(context, i, e);
            }
        }
        return e;
    }

    private ColorStateList m7269e(Context context, int i) {
        if (this.f3932j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f3932j.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    private void m7255a(Context context, int i, ColorStateList colorStateList) {
        if (this.f3932j == null) {
            this.f3932j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f3932j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f3932j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private ColorStateList m7249a(Context context) {
        return m7270f(context, cz.m7054a(context, C0831a.colorButtonNormal));
    }

    private ColorStateList m7264b(Context context) {
        return m7270f(context, 0);
    }

    private ColorStateList m7265c(Context context) {
        return m7270f(context, cz.m7054a(context, C0831a.colorAccent));
    }

    private ColorStateList m7270f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = cz.m7054a(context, C0831a.colorControlHighlight);
        r0[0] = cz.f3808a;
        r1[0] = cz.m7058c(context, C0831a.colorButtonNormal);
        r0[1] = cz.f3811d;
        r1[1] = C0461a.m3047a(a, i);
        r0[2] = cz.f3809b;
        r1[2] = C0461a.m3047a(a, i);
        r0[3] = cz.f3815h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    public static void m7257a(Drawable drawable, dc dcVar, int[] iArr) {
        if (!az.m6865c(drawable) || drawable.mutate() == drawable) {
            if (dcVar.f3826d || dcVar.f3825c) {
                drawable.setColorFilter(C1011w.m7251a(dcVar.f3826d ? dcVar.f3823a : null, dcVar.f3825c ? dcVar.f3824b : f3923a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter m7251a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return C1011w.m7250a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter m7250a(int i, Mode mode) {
        PorterDuffColorFilter a = f3925c.m7245a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f3925c.m7246a(i, mode, a);
        return a;
    }

    private static void m7256a(Drawable drawable, int i, Mode mode) {
        if (az.m6865c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f3923a;
        }
        drawable.setColorFilter(C1011w.m7250a(i, mode));
    }

    private void m7268d(Context context) {
        if (!this.f3938p) {
            this.f3938p = true;
            Drawable a = m7272a(context, C0835e.abc_ic_ab_back_material);
            if (a == null || !C1011w.m7262a(a)) {
                this.f3938p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean m7262a(Drawable drawable) {
        return (drawable instanceof C0181h) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
