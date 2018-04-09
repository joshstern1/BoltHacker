package com.p041a.p042a;

import com.p041a.p042a.p043a.C1063a;
import com.p041a.p042a.p049b.C1109e;
import com.p041a.p042a.p051c.C1154g;
import io.p038b.p039a.p040a.C1062l;
import io.p038b.p039a.p040a.C1101m;
import io.p038b.p039a.p040a.C3059d;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class C1102a extends C1062l<Void> implements C1101m {
    public final C1063a f4160a;
    public final C1109e f4161b;
    public final C1154g f4162c;
    public final Collection<? extends C1062l> f4163d;

    protected /* synthetic */ Object mo1150f() {
        return m7700d();
    }

    public C1102a() {
        this(new C1063a(), new C1109e(), new C1154g());
    }

    C1102a(C1063a c1063a, C1109e c1109e, C1154g c1154g) {
        this.f4160a = c1063a;
        this.f4161b = c1109e;
        this.f4162c = c1154g;
        this.f4163d = Collections.unmodifiableCollection(Arrays.asList(new C1062l[]{c1063a, c1109e, c1154g}));
    }

    public String mo1148a() {
        return "2.6.1.139";
    }

    public String mo1149b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends C1062l> mo1174c() {
        return this.f4163d;
    }

    protected Void m7700d() {
        return null;
    }

    public static C1102a m7695e() {
        return (C1102a) C3059d.m17334a(C1102a.class);
    }

    public static void m7692a(String str) {
        C1102a.m7696g();
        C1102a.m7695e().f4162c.m7963a(str);
    }

    public static void m7693b(String str) {
        C1102a.m7696g();
        C1102a.m7695e().f4162c.m7967b(str);
    }

    public static void m7694c(String str) {
        C1102a.m7696g();
        C1102a.m7695e().f4162c.m7969c(str);
    }

    private static void m7696g() {
        if (C1102a.m7695e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
