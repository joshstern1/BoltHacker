package android.support.v7.p027a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ao;
import android.support.v7.p027a.C0760a.C0758b;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.p028b.C0842a.C0840j;
import android.support.v7.view.C0774j;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0197k.C0253a;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.view.menu.C0879i;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.C0776c;
import android.support.v7.widget.ap;
import android.support.v7.widget.dj;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

class an extends C0760a {
    private ap f2482a;
    private boolean f2483b;
    private Callback f2484c;
    private boolean f2485d;
    private boolean f2486e;
    private ArrayList<C0758b> f2487f = new ArrayList();
    private C0879i f2488g;
    private final Runnable f2489h = new ao(this);
    private final C0776c f2490i = new ap(this);

    private final class C0771a implements C0770a {
        final /* synthetic */ an f2476a;
        private boolean f2477b;

        private C0771a(an anVar) {
            this.f2476a = anVar;
        }

        public boolean mo729a(C0197k c0197k) {
            if (this.f2476a.f2484c == null) {
                return false;
            }
            this.f2476a.f2484c.onMenuOpened(108, c0197k);
            return true;
        }

        public void mo728a(C0197k c0197k, boolean z) {
            if (!this.f2477b) {
                this.f2477b = true;
                this.f2476a.f2482a.mo1081n();
                if (this.f2476a.f2484c != null) {
                    this.f2476a.f2484c.onPanelClosed(108, c0197k);
                }
                this.f2477b = false;
            }
        }
    }

    private final class C0772b implements C0253a {
        final /* synthetic */ an f2478a;

        private C0772b(an anVar) {
            this.f2478a = anVar;
        }

        public boolean mo223a(C0197k c0197k, MenuItem menuItem) {
            return false;
        }

        public void mo222a(C0197k c0197k) {
            if (this.f2478a.f2484c == null) {
                return;
            }
            if (this.f2478a.f2482a.mo1076i()) {
                this.f2478a.f2484c.onPanelClosed(108, c0197k);
            } else if (this.f2478a.f2484c.onPreparePanel(0, null, c0197k)) {
                this.f2478a.f2484c.onMenuOpened(108, c0197k);
            }
        }
    }

    private final class C0773c implements C0770a {
        final /* synthetic */ an f2479a;

        private C0773c(an anVar) {
            this.f2479a = anVar;
        }

        public void mo728a(C0197k c0197k, boolean z) {
            if (this.f2479a.f2484c != null) {
                this.f2479a.f2484c.onPanelClosed(0, c0197k);
            }
        }

        public boolean mo729a(C0197k c0197k) {
            if (c0197k == null && this.f2479a.f2484c != null) {
                this.f2479a.f2484c.onMenuOpened(0, c0197k);
            }
            return true;
        }
    }

    private class C0775d extends C0774j {
        final /* synthetic */ an f2481a;

        public C0775d(an anVar, Callback callback) {
            this.f2481a = anVar;
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !this.f2481a.f2483b) {
                this.f2481a.f2482a.mo1080m();
                this.f2481a.f2483b = true;
            }
            return onPreparePanel;
        }

        public View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu r = this.f2481a.f2482a.mo1085r();
                    if (onPreparePanel(i, null, r) && onMenuOpened(i, r)) {
                        return this.f2481a.m5044a(r);
                    }
            }
            return super.onCreatePanelView(i);
        }
    }

    void m5073j() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.m5050k();
        r2 = r1 instanceof android.support.v7.view.menu.C0197k;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (android.support.v7.view.menu.C0197k) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.m1320g();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.f2484c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.f2484c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.m1321h();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.m1321h();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.an.j():void");
    }

    public an(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f2482a = new dj(toolbar, false);
        this.f2484c = new C0775d(this, callback);
        this.f2482a.mo1060a(this.f2484c);
        toolbar.setOnMenuItemClickListener(this.f2490i);
        this.f2482a.mo1061a(charSequence);
    }

    public Callback m5072i() {
        return this.f2484c;
    }

    public void mo744d(boolean z) {
    }

    public void mo733a(float f) {
        ao.m3935f(this.f2482a.mo1054a(), f);
    }

    public Context mo742c() {
        return this.f2482a.mo1063b();
    }

    public void mo736a(Drawable drawable) {
        this.f2482a.mo1065b(drawable);
    }

    public void mo746f(boolean z) {
    }

    public void mo734a(int i) {
        this.f2482a.mo1070d(i);
    }

    public void mo748g(boolean z) {
    }

    public void mo735a(Configuration configuration) {
        super.mo735a(configuration);
    }

    public void mo737a(CharSequence charSequence) {
        this.f2482a.mo1061a(charSequence);
    }

    public boolean mo749g() {
        ViewGroup a = this.f2482a.mo1054a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m5054a(int i, int i2) {
        this.f2482a.mo1067c((this.f2482a.mo1082o() & (i2 ^ -1)) | (i & i2));
    }

    public void mo738a(boolean z) {
        m5054a(z ? 2 : 0, 2);
    }

    public void mo740b(boolean z) {
        m5054a(z ? 4 : 0, 4);
    }

    public void mo743c(boolean z) {
        m5054a(z ? 8 : 0, 8);
    }

    public int mo732a() {
        return this.f2482a.mo1082o();
    }

    public boolean mo741b() {
        return this.f2482a.mo1084q() == 0;
    }

    public boolean mo745e() {
        this.f2482a.mo1054a().removeCallbacks(this.f2489h);
        ao.m3913a(this.f2482a.mo1054a(), this.f2489h);
        return true;
    }

    public boolean mo747f() {
        if (!this.f2482a.mo1068c()) {
            return false;
        }
        this.f2482a.mo1069d();
        return true;
    }

    public boolean mo739a(int i, KeyEvent keyEvent) {
        Menu k = m5050k();
        if (k != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            k.setQwertyMode(z);
            k.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    void mo750h() {
        this.f2482a.mo1054a().removeCallbacks(this.f2489h);
    }

    public void mo751h(boolean z) {
        if (z != this.f2486e) {
            this.f2486e = z;
            int size = this.f2487f.size();
            for (int i = 0; i < size; i++) {
                ((C0758b) this.f2487f.get(i)).m4961a(z);
            }
        }
    }

    private View m5044a(Menu menu) {
        m5047b(menu);
        if (menu == null || this.f2488g == null || this.f2488g.m5685d().getCount() <= 0) {
            return null;
        }
        return (View) this.f2488g.m5671a(this.f2482a.mo1054a());
    }

    private void m5047b(Menu menu) {
        if (this.f2488g == null && (menu instanceof C0197k)) {
            C0197k c0197k = (C0197k) menu;
            Context b = this.f2482a.mo1063b();
            TypedValue typedValue = new TypedValue();
            Theme newTheme = b.getResources().newTheme();
            newTheme.setTo(b.getTheme());
            newTheme.resolveAttribute(C0831a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0831a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0840j.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(b, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f2488g = new C0879i(contextThemeWrapper, C0838h.abc_list_menu_item_layout);
            this.f2488g.mo152a(new C0773c());
            c0197k.m1294a(this.f2488g);
        }
    }

    private Menu m5050k() {
        if (!this.f2485d) {
            this.f2482a.mo1057a(new C0771a(), new C0772b());
            this.f2485d = true;
        }
        return this.f2482a.mo1085r();
    }
}
