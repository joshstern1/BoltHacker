package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class C0641i {
    private final Context f2148a;
    private C0639a f2149b;
    private C0640b f2150c;

    public interface C0639a {
        void mo914b(boolean z);
    }

    public interface C0640b {
        void mo874a(boolean z);
    }

    public abstract View mo875a();

    public C0641i(Context context) {
        this.f2148a = context;
    }

    public View mo883a(MenuItem menuItem) {
        return mo875a();
    }

    public boolean mo885b() {
        return false;
    }

    public boolean mo886c() {
        return true;
    }

    public boolean mo877d() {
        return false;
    }

    public boolean mo878e() {
        return false;
    }

    public void mo876a(SubMenu subMenu) {
    }

    public void m4278a(boolean z) {
        if (this.f2149b != null) {
            this.f2149b.mo914b(z);
        }
    }

    public void m4275a(C0639a c0639a) {
        this.f2149b = c0639a;
    }

    public void mo884a(C0640b c0640b) {
        if (!(this.f2150c == null || c0640b == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2150c = c0640b;
    }

    public void m4283f() {
        this.f2150c = null;
        this.f2149b = null;
    }
}
