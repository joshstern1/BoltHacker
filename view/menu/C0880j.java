package android.support.v7.view.menu;

import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.view.menu.C0195u.C0194a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class C0880j extends BaseAdapter {
    static final int f2968a = C0838h.abc_popup_menu_item_layout;
    C0197k f2969b;
    private int f2970c = -1;
    private boolean f2971d;
    private final boolean f2972e;
    private final LayoutInflater f2973f;

    public /* synthetic */ Object getItem(int i) {
        return m5687a(i);
    }

    public C0880j(C0197k c0197k, LayoutInflater layoutInflater, boolean z) {
        this.f2972e = z;
        this.f2973f = layoutInflater;
        this.f2969b = c0197k;
        m5689b();
    }

    public void m5688a(boolean z) {
        this.f2971d = z;
    }

    public int getCount() {
        ArrayList l = this.f2972e ? this.f2969b.m1325l() : this.f2969b.m1322i();
        if (this.f2970c < 0) {
            return l.size();
        }
        return l.size() - 1;
    }

    public C0197k m5686a() {
        return this.f2969b;
    }

    public C0882m m5687a(int i) {
        ArrayList l = this.f2972e ? this.f2969b.m1325l() : this.f2969b.m1322i();
        if (this.f2970c >= 0 && i >= this.f2970c) {
            i++;
        }
        return (C0882m) l.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f2973f.inflate(f2968a, viewGroup, false);
        } else {
            inflate = view;
        }
        C0194a c0194a = (C0194a) inflate;
        if (this.f2971d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        c0194a.mo130a(m5687a(i), 0);
        return inflate;
    }

    void m5689b() {
        C0882m r = this.f2969b.m1331r();
        if (r != null) {
            ArrayList l = this.f2969b.m1325l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0882m) l.get(i)) == r) {
                    this.f2970c = i;
                    return;
                }
            }
        }
        this.f2970c = -1;
    }

    public void notifyDataSetChanged() {
        m5689b();
        super.notifyDataSetChanged();
    }
}
