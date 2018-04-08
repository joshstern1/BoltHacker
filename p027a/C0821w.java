package android.support.v7.p027a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.p027a.C0814s.C0813b;
import android.support.v7.view.C0778b;
import android.support.v7.view.C0778b.C0825a;
import android.support.v7.view.C0856f.C0855a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0821w extends C0820v {
    private static ar f2745r;
    private int f2746s = -100;
    private boolean f2747t;
    private boolean f2748u = true;

    class C0816a extends C0813b {
        final /* synthetic */ C0821w f2717c;

        C0816a(C0821w c0821w, Callback callback) {
            this.f2717c = c0821w;
            super(c0821w, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.f2717c.mo839o()) {
                return m5360a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode m5360a(ActionMode.Callback callback) {
            Object c0855a = new C0855a(this.f2717c.a, callback);
            C0778b b = this.f2717c.m5413b((C0825a) c0855a);
            if (b != null) {
                return c0855a.m5511b(b);
            }
            return null;
        }
    }

    C0821w(Context context, Window window, C0763q c0763q) {
        super(context, window, c0763q);
    }

    public void mo819a(Bundle bundle) {
        super.mo819a(bundle);
        if (bundle != null && this.f2746s == -100) {
            this.f2746s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback mo837a(Callback callback) {
        return new C0816a(this, callback);
    }

    public boolean mo839o() {
        return this.f2748u;
    }

    public boolean mo812i() {
        this.f2747t = true;
        int d = mo838d(this.f2746s == -100 ? C0811r.m5311j() : this.f2746s);
        if (d != -1) {
            return m5433e(d);
        }
        return false;
    }

    int mo838d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                return m5434u().m5082a() ? 2 : 1;
            default:
                return i;
        }
    }

    public void mo809c(Bundle bundle) {
        super.mo809c(bundle);
        if (this.f2746s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f2746s);
        }
    }

    private boolean m5433e(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    private ar m5434u() {
        if (f2745r == null) {
            f2745r = new ar(this.a.getApplicationContext());
        }
        return f2745r;
    }
}
