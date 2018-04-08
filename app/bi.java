package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.bl.C0367a;
import android.support.v4.app.bl.C0367a.C0368a;

public final class bi extends C0367a {
    public static final C0368a f1735a = new bj();
    private static final C0363a f1736g;
    private final String f1737b;
    private final CharSequence f1738c;
    private final CharSequence[] f1739d;
    private final boolean f1740e;
    private final Bundle f1741f;

    interface C0363a {
    }

    static class C0364b implements C0363a {
        C0364b() {
        }
    }

    static class C0365c implements C0363a {
        C0365c() {
        }
    }

    static class C0366d implements C0363a {
        C0366d() {
        }
    }

    public String mo333a() {
        return this.f1737b;
    }

    public CharSequence mo334b() {
        return this.f1738c;
    }

    public CharSequence[] mo335c() {
        return this.f1739d;
    }

    public boolean mo336d() {
        return this.f1740e;
    }

    public Bundle mo337e() {
        return this.f1741f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f1736g = new C0364b();
        } else if (VERSION.SDK_INT >= 16) {
            f1736g = new C0366d();
        } else {
            f1736g = new C0365c();
        }
    }
}
