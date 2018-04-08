package android.support.v7.p027a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.p027a.C0790b.C0781a;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.view.C0774j;
import android.support.v7.view.C0778b;
import android.support.v7.view.C0778b.C0825a;
import android.support.v7.view.C0859g;
import android.support.v7.view.menu.C0197k;
import android.support.v7.widget.de;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class C0814s extends C0811r {
    private static final int[] f2702m = new int[]{16842836};
    final Context f2703a;
    final Window f2704b;
    final Callback f2705c = this.f2704b.getCallback();
    final Callback f2706d;
    final C0763q f2707e;
    C0760a f2708f;
    MenuInflater f2709g;
    boolean f2710h;
    boolean f2711i;
    boolean f2712j;
    boolean f2713k;
    boolean f2714l;
    private CharSequence f2715n;
    private boolean f2716o;

    private class C0812a implements C0781a {
        final /* synthetic */ C0814s f2700a;

        private C0812a(C0814s c0814s) {
            this.f2700a = c0814s;
        }

        public Drawable mo778a() {
            de a = de.m7065a(mo781b(), null, new int[]{C0831a.homeAsUpIndicator});
            Drawable a2 = a.m7069a(0);
            a.m7070a();
            return a2;
        }

        public Context mo781b() {
            return this.f2700a.m5355n();
        }

        public boolean mo782c() {
            C0760a a = this.f2700a.mo806a();
            return (a == null || (a.mo732a() & 4) == 0) ? false : true;
        }

        public void mo780a(Drawable drawable, int i) {
            C0760a a = this.f2700a.mo806a();
            if (a != null) {
                a.mo736a(drawable);
                a.mo734a(i);
            }
        }

        public void mo779a(int i) {
            C0760a a = this.f2700a.mo806a();
            if (a != null) {
                a.mo734a(i);
            }
        }
    }

    class C0813b extends C0774j {
        final /* synthetic */ C0814s f2701a;

        C0813b(C0814s c0814s, Callback callback) {
            this.f2701a = c0814s;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f2701a.mo824a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.f2701a.mo823a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0197k)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0197k c0197k;
            if (menu instanceof C0197k) {
                c0197k = (C0197k) menu;
            } else {
                c0197k = null;
            }
            if (i == 0 && c0197k == null) {
                return false;
            }
            if (c0197k != null) {
                c0197k.m1310c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0197k == null) {
                return onPreparePanel;
            }
            c0197k.m1310c(false);
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f2701a.mo829b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f2701a.mo817a(i, menu);
        }
    }

    abstract C0778b mo815a(C0825a c0825a);

    abstract void mo817a(int i, Menu menu);

    abstract boolean mo823a(int i, KeyEvent keyEvent);

    abstract boolean mo824a(KeyEvent keyEvent);

    abstract void mo828b(CharSequence charSequence);

    abstract boolean mo829b(int i, Menu menu);

    abstract void mo835l();

    C0814s(Context context, Window window, C0763q c0763q) {
        this.f2703a = context;
        this.f2704b = window;
        this.f2707e = c0763q;
        if (this.f2705c instanceof C0813b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f2706d = mo837a(this.f2705c);
        this.f2704b.setCallback(this.f2706d);
        de a = de.m7065a(context, null, f2702m);
        Drawable b = a.m7073b(0);
        if (b != null) {
            this.f2704b.setBackgroundDrawable(b);
        }
        a.m7070a();
    }

    Callback mo837a(Callback callback) {
        return new C0813b(this, callback);
    }

    public C0760a mo806a() {
        mo835l();
        return this.f2708f;
    }

    final C0760a m5354m() {
        return this.f2708f;
    }

    public MenuInflater mo808b() {
        if (this.f2709g == null) {
            mo835l();
            this.f2709g = new C0859g(this.f2708f != null ? this.f2708f.mo742c() : this.f2703a);
        }
        return this.f2709g;
    }

    public final C0781a mo811g() {
        return new C0812a();
    }

    final Context m5355n() {
        Context context = null;
        C0760a a = mo806a();
        if (a != null) {
            context = a.mo742c();
        }
        if (context == null) {
            return this.f2703a;
        }
        return context;
    }

    public void mo810f() {
        this.f2716o = true;
    }

    public boolean mo839o() {
        return false;
    }

    public boolean mo812i() {
        return false;
    }

    final boolean m5357p() {
        return this.f2716o;
    }

    final Callback m5358q() {
        return this.f2704b.getCallback();
    }

    public final void mo807a(CharSequence charSequence) {
        this.f2715n = charSequence;
        mo828b(charSequence);
    }

    public void mo809c(Bundle bundle) {
    }

    final CharSequence m5359r() {
        if (this.f2705c instanceof Activity) {
            return ((Activity) this.f2705c).getTitle();
        }
        return this.f2715n;
    }
}
