package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.p028b.C0842a.C0834d;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.widget.bn;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class C0894y extends C0873q implements C0211t, OnKeyListener, OnItemClickListener, OnDismissListener {
    private final Context f3026a;
    private final C0197k f3027b;
    private final C0880j f3028c;
    private final boolean f3029d;
    private final int f3030e;
    private final int f3031f;
    private final int f3032g;
    private final bn f3033h;
    private final OnGlobalLayoutListener f3034i = new C0895z(this);
    private OnDismissListener f3035j;
    private View f3036k;
    private View f3037l;
    private C0770a f3038m;
    private ViewTreeObserver f3039n;
    private boolean f3040o;
    private boolean f3041p;
    private int f3042q;
    private int f3043r = 0;
    private boolean f3044s;

    public C0894y(Context context, C0197k c0197k, View view, int i, int i2, boolean z) {
        this.f3026a = context;
        this.f3027b = c0197k;
        this.f3029d = z;
        this.f3028c = new C0880j(c0197k, LayoutInflater.from(context), this.f3029d);
        this.f3031f = i;
        this.f3032g = i2;
        Resources resources = context.getResources();
        this.f3030e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0834d.abc_config_prefDialogWidth));
        this.f3036k = view;
        this.f3033h = new bn(this.f3026a, null, this.f3031f, this.f3032g);
        c0197k.m1295a((C0211t) this, context);
    }

    public void mo865b(boolean z) {
        this.f3028c.m5688a(z);
    }

    public void mo860a(int i) {
        this.f3043r = i;
    }

    private boolean m5758i() {
        if (mo870f()) {
            return true;
        }
        if (this.f3040o || this.f3036k == null) {
            return false;
        }
        this.f3037l = this.f3036k;
        this.f3033h.m5944a((OnDismissListener) this);
        this.f3033h.m5942a((OnItemClickListener) this);
        this.f3033h.m5945a(true);
        View view = this.f3037l;
        boolean z = this.f3039n == null;
        this.f3039n = view.getViewTreeObserver();
        if (z) {
            this.f3039n.addOnGlobalLayoutListener(this.f3034i);
        }
        this.f3033h.m5941a(view);
        this.f3033h.m5952e(this.f3043r);
        if (!this.f3041p) {
            this.f3042q = C0873q.m5617a(this.f3028c, null, this.f3026a, this.f3030e);
            this.f3041p = true;
        }
        this.f3033h.m5956g(this.f3042q);
        this.f3033h.m5958h(2);
        this.f3033h.m5939a(m5633h());
        this.f3033h.mo868d();
        ViewGroup g = this.f3033h.mo871g();
        g.setOnKeyListener(this);
        if (this.f3044s && this.f3027b.m1326m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f3026a).inflate(C0838h.abc_popup_menu_header_item_layout, g, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f3027b.m1326m());
            }
            frameLayout.setEnabled(false);
            g.addHeaderView(frameLayout, null, false);
        }
        this.f3033h.mo926a(this.f3028c);
        this.f3033h.mo868d();
        return true;
    }

    public void mo868d() {
        if (!m5758i()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void mo869e() {
        if (mo870f()) {
            this.f3033h.mo869e();
        }
    }

    public void mo861a(C0197k c0197k) {
    }

    public boolean mo870f() {
        return !this.f3040o && this.f3033h.mo870f();
    }

    public void onDismiss() {
        this.f3040o = true;
        this.f3027b.close();
        if (this.f3039n != null) {
            if (!this.f3039n.isAlive()) {
                this.f3039n = this.f3037l.getViewTreeObserver();
            }
            this.f3039n.removeGlobalOnLayoutListener(this.f3034i);
            this.f3039n = null;
        }
        if (this.f3035j != null) {
            this.f3035j.onDismiss();
        }
    }

    public void mo153a(boolean z) {
        this.f3041p = false;
        if (this.f3028c != null) {
            this.f3028c.notifyDataSetChanged();
        }
    }

    public void mo152a(C0770a c0770a) {
        this.f3038m = c0770a;
    }

    public boolean mo155a(aa aaVar) {
        if (aaVar.hasVisibleItems()) {
            C0891r c0891r = new C0891r(this.f3026a, aaVar, this.f3037l, this.f3029d, this.f3031f, this.f3032g);
            c0891r.m5743a(this.f3038m);
            c0891r.m5746a(C0873q.m5619b((C0197k) aaVar));
            c0891r.m5745a(this.f3035j);
            this.f3035j = null;
            this.f3027b.m1306b(false);
            if (c0891r.m5747a(this.f3033h.m5961j(), this.f3033h.m5962k())) {
                if (this.f3038m != null) {
                    this.f3038m.mo729a(aaVar);
                }
                return true;
            }
        }
        return false;
    }

    public void mo151a(C0197k c0197k, boolean z) {
        if (c0197k == this.f3027b) {
            mo869e();
            if (this.f3038m != null) {
                this.f3038m.mo728a(c0197k, z);
            }
        }
    }

    public boolean mo154a() {
        return false;
    }

    public Parcelable mo159c() {
        return null;
    }

    public void mo150a(Parcelable parcelable) {
    }

    public void mo862a(View view) {
        this.f3036k = view;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo869e();
        return true;
    }

    public void mo863a(OnDismissListener onDismissListener) {
        this.f3035j = onDismissListener;
    }

    public ListView mo871g() {
        return this.f3033h.mo871g();
    }

    public void mo864b(int i) {
        this.f3033h.m5947c(i);
    }

    public void mo866c(int i) {
        this.f3033h.m5950d(i);
    }

    public void mo867c(boolean z) {
        this.f3044s = z;
    }
}
