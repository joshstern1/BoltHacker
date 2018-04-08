package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class C0778b {
    private Object f2506a;
    private boolean f2507b;

    public interface C0825a {
        void mo840a(C0778b c0778b);

        boolean mo841a(C0778b c0778b, Menu menu);

        boolean mo842a(C0778b c0778b, MenuItem menuItem);

        boolean mo843b(C0778b c0778b, Menu menu);
    }

    public abstract MenuInflater mo753a();

    public abstract void mo754a(int i);

    public abstract void mo755a(View view);

    public abstract void mo756a(CharSequence charSequence);

    public abstract Menu mo758b();

    public abstract void mo759b(int i);

    public abstract void mo760b(CharSequence charSequence);

    public abstract void mo761c();

    public abstract void mo762d();

    public abstract CharSequence mo763f();

    public abstract CharSequence mo764g();

    public abstract View mo766i();

    public void m5087a(Object obj) {
        this.f2506a = obj;
    }

    public Object m5098j() {
        return this.f2506a;
    }

    public void mo757a(boolean z) {
        this.f2507b = z;
    }

    public boolean m5099k() {
        return this.f2507b;
    }

    public boolean mo765h() {
        return false;
    }
}
