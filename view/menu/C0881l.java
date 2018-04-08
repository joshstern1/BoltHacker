package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p027a.C0809o;
import android.support.v7.p027a.C0809o.C0808a;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.view.menu.C0211t.C0770a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class C0881l implements OnClickListener, OnDismissListener, OnKeyListener, C0770a {
    C0879i f2974a;
    private C0197k f2975b;
    private C0809o f2976c;
    private C0770a f2977d;

    public C0881l(C0197k c0197k) {
        this.f2975b = c0197k;
    }

    public void m5691a(IBinder iBinder) {
        C0197k c0197k = this.f2975b;
        C0808a c0808a = new C0808a(c0197k.m1317e());
        this.f2974a = new C0879i(c0808a.m5273a(), C0838h.abc_list_menu_item_layout);
        this.f2974a.mo152a((C0770a) this);
        this.f2975b.m1294a(this.f2974a);
        c0808a.m5281a(this.f2974a.m5685d(), (OnClickListener) this);
        View o = c0197k.m1328o();
        if (o != null) {
            c0808a.m5280a(o);
        } else {
            c0808a.m5279a(c0197k.m1327n()).m5282a(c0197k.m1326m());
        }
        c0808a.m5278a((OnKeyListener) this);
        this.f2976c = c0808a.m5286b();
        this.f2976c.setOnDismissListener(this);
        LayoutParams attributes = this.f2976c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f2976c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f2976c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f2976c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f2975b.m1306b(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f2975b.performShortcut(i, keyEvent, 0);
    }

    public void m5690a() {
        if (this.f2976c != null) {
            this.f2976c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f2974a.mo151a(this.f2975b, true);
    }

    public void mo728a(C0197k c0197k, boolean z) {
        if (z || c0197k == this.f2975b) {
            m5690a();
        }
        if (this.f2977d != null) {
            this.f2977d.mo728a(c0197k, z);
        }
    }

    public boolean mo729a(C0197k c0197k) {
        if (this.f2977d != null) {
            return this.f2977d.mo729a(c0197k);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2975b.m1300a((C0882m) this.f2974a.m5685d().getItem(i), 0);
    }
}
