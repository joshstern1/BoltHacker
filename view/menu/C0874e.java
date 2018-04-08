package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.C0645j;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0834d;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.widget.bm;
import android.support.v7.widget.bn;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class C0874e extends C0873q implements C0211t, OnKeyListener, OnDismissListener {
    private final Context f2925a;
    private final int f2926b;
    private final int f2927c;
    private final int f2928d;
    private final boolean f2929e;
    private final Handler f2930f;
    private final List<C0197k> f2931g = new LinkedList();
    private final List<C0871a> f2932h = new ArrayList();
    private final OnGlobalLayoutListener f2933i = new C0875f(this);
    private final bm f2934j = new C0876g(this);
    private int f2935k = 0;
    private int f2936l = 0;
    private View f2937m;
    private View f2938n;
    private int f2939o;
    private boolean f2940p;
    private boolean f2941q;
    private int f2942r;
    private int f2943s;
    private boolean f2944t;
    private boolean f2945u;
    private C0770a f2946v;
    private ViewTreeObserver f2947w;
    private OnDismissListener f2948x;
    private boolean f2949y;

    private static class C0871a {
        public final bn f2921a;
        public final C0197k f2922b;
        public final int f2923c;

        public C0871a(bn bnVar, C0197k c0197k, int i) {
            this.f2921a = bnVar;
            this.f2922b = c0197k;
            this.f2923c = i;
        }

        public ListView m5612a() {
            return this.f2921a.mo871g();
        }
    }

    public C0874e(Context context, View view, int i, int i2, boolean z) {
        this.f2925a = context;
        this.f2937m = view;
        this.f2927c = i;
        this.f2928d = i2;
        this.f2929e = z;
        this.f2944t = false;
        this.f2939o = m5644j();
        Resources resources = context.getResources();
        this.f2926b = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0834d.abc_config_prefDialogWidth));
        this.f2930f = new Handler();
    }

    public void mo865b(boolean z) {
        this.f2944t = z;
    }

    private bn m5643i() {
        bn bnVar = new bn(this.f2925a, null, this.f2927c, this.f2928d);
        bnVar.m6890a(this.f2934j);
        bnVar.m5942a((OnItemClickListener) this);
        bnVar.m5944a((OnDismissListener) this);
        bnVar.m5941a(this.f2937m);
        bnVar.m5952e(this.f2936l);
        bnVar.m5945a(true);
        return bnVar;
    }

    public void mo868d() {
        if (!mo870f()) {
            for (C0197k c : this.f2931g) {
                m5640c(c);
            }
            this.f2931g.clear();
            this.f2938n = this.f2937m;
            if (this.f2938n != null) {
                Object obj = this.f2947w == null ? 1 : null;
                this.f2947w = this.f2938n.getViewTreeObserver();
                if (obj != null) {
                    this.f2947w.addOnGlobalLayoutListener(this.f2933i);
                }
            }
        }
    }

    public void mo869e() {
        int size = this.f2932h.size();
        if (size > 0) {
            C0871a[] c0871aArr = (C0871a[]) this.f2932h.toArray(new C0871a[size]);
            for (size--; size >= 0; size--) {
                C0871a c0871a = c0871aArr[size];
                if (c0871a.f2921a.mo870f()) {
                    c0871a.f2921a.mo869e();
                }
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo869e();
        return true;
    }

    private int m5644j() {
        if (ao.m3938h(this.f2937m) == 1) {
            return 0;
        }
        return 1;
    }

    private int m5641d(int i) {
        ListView a = ((C0871a) this.f2932h.get(this.f2932h.size() - 1)).m5612a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f2938n.getWindowVisibleDisplayFrame(rect);
        if (this.f2939o == 1) {
            if ((a.getWidth() + iArr[0]) + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void mo861a(C0197k c0197k) {
        c0197k.m1295a((C0211t) this, this.f2925a);
        if (mo870f()) {
            m5640c(c0197k);
        } else {
            this.f2931g.add(c0197k);
        }
    }

    private void m5640c(C0197k c0197k) {
        View a;
        C0871a c0871a;
        LayoutInflater from = LayoutInflater.from(this.f2925a);
        Object c0880j = new C0880j(c0197k, from, this.f2929e);
        if (!mo870f() && this.f2944t) {
            c0880j.m5688a(true);
        } else if (mo870f()) {
            c0880j.m5688a(C0873q.m5619b(c0197k));
        }
        int a2 = C0873q.m5617a(c0880j, null, this.f2925a, this.f2926b);
        bn i = m5643i();
        i.mo926a((ListAdapter) c0880j);
        i.m5953f(a2);
        i.m5952e(this.f2936l);
        if (this.f2932h.size() > 0) {
            C0871a c0871a2 = (C0871a) this.f2932h.get(this.f2932h.size() - 1);
            a = m5635a(c0871a2, c0197k);
            c0871a = c0871a2;
        } else {
            a = null;
            c0871a = null;
        }
        if (a != null) {
            boolean z;
            int i2;
            i.mo1008b(false);
            i.m6891a(null);
            int d = m5641d(a2);
            if (d == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f2939o = d;
            int[] iArr = new int[2];
            a.getLocationInWindow(iArr);
            int j = c0871a.f2921a.m5961j() + iArr[0];
            int k = iArr[1] + c0871a.f2921a.m5962k();
            if ((this.f2936l & 5) == 5) {
                if (z) {
                    i2 = j + a2;
                } else {
                    i2 = j - a.getWidth();
                }
            } else if (z) {
                i2 = a.getWidth() + j;
            } else {
                i2 = j - a2;
            }
            i.m5947c(i2);
            i.m5950d(k);
        } else {
            if (this.f2940p) {
                i.m5947c(this.f2942r);
            }
            if (this.f2941q) {
                i.m5950d(this.f2943s);
            }
            i.m5939a(m5633h());
        }
        this.f2932h.add(new C0871a(i, c0197k, this.f2939o));
        i.mo868d();
        if (c0871a == null && this.f2945u && c0197k.m1326m() != null) {
            ViewGroup g = i.mo871g();
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0838h.abc_popup_menu_header_item_layout, g, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(c0197k.m1326m());
            g.addHeaderView(frameLayout, null, false);
            i.mo868d();
        }
    }

    private MenuItem m5634a(C0197k c0197k, C0197k c0197k2) {
        int size = c0197k.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0197k.getItem(i);
            if (item.hasSubMenu() && c0197k2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View m5635a(C0871a c0871a, C0197k c0197k) {
        int i = 0;
        MenuItem a = m5634a(c0871a.f2922b, c0197k);
        if (a == null) {
            return null;
        }
        int headersCount;
        C0880j c0880j;
        int i2;
        ListView a2 = c0871a.m5612a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0880j = (C0880j) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0880j = (C0880j) adapter;
            headersCount = 0;
        }
        int count = c0880j.getCount();
        while (i < count) {
            if (a == c0880j.m5687a(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        if (i2 < 0 || i2 >= a2.getChildCount()) {
            return null;
        }
        return a2.getChildAt(i2);
    }

    public boolean mo870f() {
        return this.f2932h.size() > 0 && ((C0871a) this.f2932h.get(0)).f2921a.mo870f();
    }

    public void onDismiss() {
        C0871a c0871a;
        int size = this.f2932h.size();
        for (int i = 0; i < size; i++) {
            c0871a = (C0871a) this.f2932h.get(i);
            if (!c0871a.f2921a.mo870f()) {
                break;
            }
        }
        c0871a = null;
        if (c0871a != null) {
            c0871a.f2922b.m1306b(false);
        }
    }

    public void mo153a(boolean z) {
        for (C0871a a : this.f2932h) {
            C0873q.m5618a(a.m5612a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void mo152a(C0770a c0770a) {
        this.f2946v = c0770a;
    }

    public boolean mo155a(aa aaVar) {
        for (C0871a c0871a : this.f2932h) {
            if (aaVar == c0871a.f2922b) {
                c0871a.m5612a().requestFocus();
                return true;
            }
        }
        if (!aaVar.hasVisibleItems()) {
            return false;
        }
        mo861a((C0197k) aaVar);
        if (this.f2946v != null) {
            this.f2946v.mo729a(aaVar);
        }
        return true;
    }

    private int m5642d(C0197k c0197k) {
        int size = this.f2932h.size();
        for (int i = 0; i < size; i++) {
            if (c0197k == ((C0871a) this.f2932h.get(i)).f2922b) {
                return i;
            }
        }
        return -1;
    }

    public void mo151a(C0197k c0197k, boolean z) {
        int d = m5642d(c0197k);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.f2932h.size()) {
                ((C0871a) this.f2932h.get(i)).f2922b.m1306b(false);
            }
            C0871a c0871a = (C0871a) this.f2932h.remove(d);
            c0871a.f2922b.m1305b((C0211t) this);
            if (this.f2949y) {
                c0871a.f2921a.m6893b(null);
                c0871a.f2921a.m5946b(0);
            }
            c0871a.f2921a.mo869e();
            d = this.f2932h.size();
            if (d > 0) {
                this.f2939o = ((C0871a) this.f2932h.get(d - 1)).f2923c;
            } else {
                this.f2939o = m5644j();
            }
            if (d == 0) {
                mo869e();
                if (this.f2946v != null) {
                    this.f2946v.mo728a(c0197k, true);
                }
                if (this.f2947w != null) {
                    if (this.f2947w.isAlive()) {
                        this.f2947w.removeGlobalOnLayoutListener(this.f2933i);
                    }
                    this.f2947w = null;
                }
                this.f2948x.onDismiss();
            } else if (z) {
                ((C0871a) this.f2932h.get(0)).f2922b.m1306b(false);
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

    public void mo860a(int i) {
        if (this.f2935k != i) {
            this.f2935k = i;
            this.f2936l = C0645j.m4290a(i, ao.m3938h(this.f2937m));
        }
    }

    public void mo862a(View view) {
        if (this.f2937m != view) {
            this.f2937m = view;
            this.f2936l = C0645j.m4290a(this.f2935k, ao.m3938h(this.f2937m));
        }
    }

    public void mo863a(OnDismissListener onDismissListener) {
        this.f2948x = onDismissListener;
    }

    public ListView mo871g() {
        if (this.f2932h.isEmpty()) {
            return null;
        }
        return ((C0871a) this.f2932h.get(this.f2932h.size() - 1)).m5612a();
    }

    public void mo864b(int i) {
        this.f2940p = true;
        this.f2942r = i;
    }

    public void mo866c(int i) {
        this.f2941q = true;
        this.f2943s = i;
    }

    public void mo867c(boolean z) {
        this.f2945u = z;
    }
}
