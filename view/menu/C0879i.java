package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.view.menu.C0195u.C0194a;
import android.support.v7.view.menu.C0211t.C0770a;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class C0879i implements C0211t, OnItemClickListener {
    Context f2958a;
    LayoutInflater f2959b;
    C0197k f2960c;
    ExpandedMenuView f2961d;
    int f2962e;
    int f2963f;
    C0878a f2964g;
    private int f2965h;
    private C0770a f2966i;
    private int f2967j;

    private class C0878a extends BaseAdapter {
        final /* synthetic */ C0879i f2956a;
        private int f2957b = -1;

        public /* synthetic */ Object getItem(int i) {
            return m5668a(i);
        }

        public C0878a(C0879i c0879i) {
            this.f2956a = c0879i;
            m5669a();
        }

        public int getCount() {
            int size = this.f2956a.f2960c.m1325l().size() - this.f2956a.f2965h;
            return this.f2957b < 0 ? size : size - 1;
        }

        public C0882m m5668a(int i) {
            ArrayList l = this.f2956a.f2960c.m1325l();
            int a = this.f2956a.f2965h + i;
            if (this.f2957b >= 0 && a >= this.f2957b) {
                a++;
            }
            return (C0882m) l.get(a);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f2956a.f2959b.inflate(this.f2956a.f2963f, viewGroup, false);
            } else {
                inflate = view;
            }
            ((C0194a) inflate).mo130a(m5668a(i), 0);
            return inflate;
        }

        void m5669a() {
            C0882m r = this.f2956a.f2960c.m1331r();
            if (r != null) {
                ArrayList l = this.f2956a.f2960c.m1325l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0882m) l.get(i)) == r) {
                        this.f2957b = i;
                        return;
                    }
                }
            }
            this.f2957b = -1;
        }

        public void notifyDataSetChanged() {
            m5669a();
            super.notifyDataSetChanged();
        }
    }

    public C0879i(Context context, int i) {
        this(i, 0);
        this.f2958a = context;
        this.f2959b = LayoutInflater.from(this.f2958a);
    }

    public C0879i(int i, int i2) {
        this.f2963f = i;
        this.f2962e = i2;
    }

    public void mo149a(Context context, C0197k c0197k) {
        if (this.f2962e != 0) {
            this.f2958a = new ContextThemeWrapper(context, this.f2962e);
            this.f2959b = LayoutInflater.from(this.f2958a);
        } else if (this.f2958a != null) {
            this.f2958a = context;
            if (this.f2959b == null) {
                this.f2959b = LayoutInflater.from(this.f2958a);
            }
        }
        this.f2960c = c0197k;
        if (this.f2964g != null) {
            this.f2964g.notifyDataSetChanged();
        }
    }

    public C0195u m5671a(ViewGroup viewGroup) {
        if (this.f2961d == null) {
            this.f2961d = (ExpandedMenuView) this.f2959b.inflate(C0838h.abc_expanded_menu_layout, viewGroup, false);
            if (this.f2964g == null) {
                this.f2964g = new C0878a(this);
            }
            this.f2961d.setAdapter(this.f2964g);
            this.f2961d.setOnItemClickListener(this);
        }
        return this.f2961d;
    }

    public ListAdapter m5685d() {
        if (this.f2964g == null) {
            this.f2964g = new C0878a(this);
        }
        return this.f2964g;
    }

    public void mo153a(boolean z) {
        if (this.f2964g != null) {
            this.f2964g.notifyDataSetChanged();
        }
    }

    public void mo152a(C0770a c0770a) {
        this.f2966i = c0770a;
    }

    public boolean mo155a(aa aaVar) {
        if (!aaVar.hasVisibleItems()) {
            return false;
        }
        new C0881l(aaVar).m5691a(null);
        if (this.f2966i != null) {
            this.f2966i.mo729a(aaVar);
        }
        return true;
    }

    public void mo151a(C0197k c0197k, boolean z) {
        if (this.f2966i != null) {
            this.f2966i.mo728a(c0197k, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2960c.m1301a(this.f2964g.m5668a(i), (C0211t) this, 0);
    }

    public boolean mo154a() {
        return false;
    }

    public boolean mo156a(C0197k c0197k, C0882m c0882m) {
        return false;
    }

    public boolean mo158b(C0197k c0197k, C0882m c0882m) {
        return false;
    }

    public void m5673a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.f2961d != null) {
            this.f2961d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void m5682b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f2961d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public int mo157b() {
        return this.f2967j;
    }

    public Parcelable mo159c() {
        if (this.f2961d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m5673a(bundle);
        return bundle;
    }

    public void mo150a(Parcelable parcelable) {
        m5682b((Bundle) parcelable);
    }
}
