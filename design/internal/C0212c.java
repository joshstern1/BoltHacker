package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.C0192a.C0186d;
import android.support.design.C0192a.C0188f;
import android.support.v7.view.menu.C0195u;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0211t;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.view.menu.C0882m;
import android.support.v7.view.menu.aa;
import android.support.v7.widget.RecyclerView.C0199u;
import android.support.v7.widget.RecyclerView.C0202a;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class C0212c implements C0211t {
    private NavigationMenuView f994a;
    private LinearLayout f995b;
    private C0770a f996c;
    private C0197k f997d;
    private int f998e;
    private C0203b f999f;
    private LayoutInflater f1000g;
    private int f1001h;
    private boolean f1002i;
    private ColorStateList f1003j;
    private ColorStateList f1004k;
    private Drawable f1005l;
    private int f1006m;
    private int f1007n;
    private final OnClickListener f1008o = new C0213d(this);

    private static abstract class C0200j extends C0199u {
        public C0200j(View view) {
            super(view);
        }
    }

    private static class C0201a extends C0200j {
        public C0201a(View view) {
            super(view);
        }
    }

    private class C0203b extends C0202a<C0200j> {
        final /* synthetic */ C0212c f986a;
        private final ArrayList<C0204d> f987b = new ArrayList();
        private C0882m f988c;
        private ColorDrawable f989d;
        private boolean f990e;

        public /* synthetic */ C0199u mo148b(ViewGroup viewGroup, int i) {
            return m1401a(viewGroup, i);
        }

        C0203b(C0212c c0212c) {
            this.f986a = c0212c;
            m1398f();
        }

        public long mo144a(int i) {
            return (long) i;
        }

        public int mo143a() {
            return this.f987b.size();
        }

        public int mo147b(int i) {
            C0204d c0204d = (C0204d) this.f987b.get(i);
            if (c0204d instanceof C0206e) {
                return 2;
            }
            if (c0204d instanceof C0205c) {
                return 3;
            }
            if (!(c0204d instanceof C0207f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((C0207f) c0204d).m1415a().hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        public C0200j m1401a(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new C0208g(this.f986a.f1000g, viewGroup, this.f986a.f1008o);
                case 1:
                    return new C0210i(this.f986a.f1000g, viewGroup);
                case 2:
                    return new C0209h(this.f986a.f1000g, viewGroup);
                case 3:
                    return new C0201a(this.f986a.f995b);
                default:
                    return null;
            }
        }

        public void m1404a(C0200j c0200j, int i) {
            switch (mo147b(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) c0200j.a;
                    navigationMenuItemView.setIconTintList(this.f986a.f1004k);
                    if (this.f986a.f1002i) {
                        navigationMenuItemView.m1134a(navigationMenuItemView.getContext(), this.f986a.f1001h);
                    }
                    if (this.f986a.f1003j != null) {
                        navigationMenuItemView.setTextColor(this.f986a.f1003j);
                    }
                    navigationMenuItemView.setBackgroundDrawable(this.f986a.f1005l != null ? this.f986a.f1005l.getConstantState().newDrawable() : null);
                    navigationMenuItemView.mo130a(((C0207f) this.f987b.get(i)).m1415a(), 0);
                    return;
                case 1:
                    ((TextView) c0200j.a).setText(((C0207f) this.f987b.get(i)).m1415a().getTitle());
                    return;
                case 2:
                    C0206e c0206e = (C0206e) this.f987b.get(i);
                    c0200j.a.setPadding(0, c0206e.m1413a(), 0, c0206e.m1414b());
                    return;
                default:
                    return;
            }
        }

        public void m1403a(C0200j c0200j) {
            if (c0200j instanceof C0208g) {
                ((NavigationMenuItemView) c0200j.a).m1133a();
            }
        }

        public void m1411b() {
            m1398f();
            m1396e();
        }

        private void m1398f() {
            if (!this.f990e) {
                this.f990e = true;
                this.f987b.clear();
                this.f987b.add(new C0205c());
                int i = -1;
                int i2 = 0;
                Object obj = null;
                int size = this.f986a.f997d.m1322i().size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2;
                    int i4;
                    int i5;
                    C0882m c0882m = (C0882m) this.f986a.f997d.m1322i().get(i3);
                    if (c0882m.isChecked()) {
                        m1405a(c0882m);
                    }
                    if (c0882m.isCheckable()) {
                        c0882m.m5703a(false);
                    }
                    int i6;
                    if (c0882m.hasSubMenu()) {
                        SubMenu subMenu = c0882m.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.f987b.add(new C0206e(this.f986a.f1007n, 0));
                            }
                            this.f987b.add(new C0207f(c0882m));
                            Object obj3 = null;
                            int size2 = this.f987b.size();
                            int size3 = subMenu.size();
                            for (i6 = 0; i6 < size3; i6++) {
                                C0882m c0882m2 = (C0882m) subMenu.getItem(i6);
                                if (c0882m2.isVisible()) {
                                    if (obj3 == null && c0882m2.getIcon() != null) {
                                        obj3 = 1;
                                    }
                                    if (c0882m2.isCheckable()) {
                                        c0882m2.m5703a(false);
                                    }
                                    if (c0882m.isChecked()) {
                                        m1405a(c0882m);
                                    }
                                    this.f987b.add(new C0207f(c0882m2));
                                }
                            }
                            if (obj3 != null) {
                                m1397a(size2, this.f987b.size());
                            }
                        }
                        obj2 = obj;
                        i4 = i2;
                        i5 = i;
                    } else {
                        Object obj4;
                        i6 = c0882m.getGroupId();
                        if (i6 != i) {
                            i2 = this.f987b.size();
                            obj = c0882m.getIcon() != null ? 1 : null;
                            if (i3 != 0) {
                                i2++;
                                this.f987b.add(new C0206e(this.f986a.f1007n, this.f986a.f1007n));
                                obj4 = obj;
                                i5 = i2;
                            }
                            obj4 = obj;
                            i5 = i2;
                        } else {
                            if (obj == null && c0882m.getIcon() != null) {
                                obj = 1;
                                m1397a(i2, this.f987b.size());
                            }
                            obj4 = obj;
                            i5 = i2;
                        }
                        if (obj4 != null && c0882m.getIcon() == null) {
                            c0882m.setIcon(17170445);
                        }
                        this.f987b.add(new C0207f(c0882m));
                        obj2 = obj4;
                        i4 = i5;
                        i5 = i6;
                    }
                    i3++;
                    i2 = i4;
                    i = i5;
                    obj = obj2;
                }
                this.f990e = false;
            }
        }

        private void m1397a(int i, int i2) {
            while (i < i2) {
                MenuItem a = ((C0207f) this.f987b.get(i)).m1415a();
                if (a.getIcon() == null) {
                    if (this.f989d == null) {
                        this.f989d = new ColorDrawable(0);
                    }
                    a.setIcon(this.f989d);
                }
                i++;
            }
        }

        public void m1405a(C0882m c0882m) {
            if (this.f988c != c0882m && c0882m.isCheckable()) {
                if (this.f988c != null) {
                    this.f988c.setChecked(false);
                }
                this.f988c = c0882m;
                c0882m.setChecked(true);
            }
        }

        public Bundle m1412c() {
            Bundle bundle = new Bundle();
            if (this.f988c != null) {
                bundle.putInt("android:menu:checked", this.f988c.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.f987b.iterator();
            while (it.hasNext()) {
                C0204d c0204d = (C0204d) it.next();
                if (c0204d instanceof C0207f) {
                    C0882m a = ((C0207f) c0204d).m1415a();
                    View actionView = a != null ? a.getActionView() : null;
                    if (actionView != null) {
                        SparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void m1402a(Bundle bundle) {
            C0204d c0204d;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f990e = true;
                Iterator it = this.f987b.iterator();
                while (it.hasNext()) {
                    c0204d = (C0204d) it.next();
                    if (c0204d instanceof C0207f) {
                        C0882m a = ((C0207f) c0204d).m1415a();
                        if (a != null && a.getItemId() == i) {
                            m1405a(a);
                            break;
                        }
                    }
                }
                this.f990e = false;
                m1398f();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            Iterator it2 = this.f987b.iterator();
            while (it2.hasNext()) {
                c0204d = (C0204d) it2.next();
                if (c0204d instanceof C0207f) {
                    C0882m a2 = ((C0207f) c0204d).m1415a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray.get(a2.getItemId()));
                    }
                }
            }
        }

        public void m1408a(boolean z) {
            this.f990e = z;
        }
    }

    private interface C0204d {
    }

    private static class C0205c implements C0204d {
        private C0205c() {
        }
    }

    private static class C0206e implements C0204d {
        private final int f991a;
        private final int f992b;

        public C0206e(int i, int i2) {
            this.f991a = i;
            this.f992b = i2;
        }

        public int m1413a() {
            return this.f991a;
        }

        public int m1414b() {
            return this.f992b;
        }
    }

    private static class C0207f implements C0204d {
        private final C0882m f993a;

        private C0207f(C0882m c0882m) {
            this.f993a = c0882m;
        }

        public C0882m m1415a() {
            return this.f993a;
        }
    }

    private static class C0208g extends C0200j {
        public C0208g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(C0188f.design_navigation_item, viewGroup, false));
            this.a.setOnClickListener(onClickListener);
        }
    }

    private static class C0209h extends C0200j {
        public C0209h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C0188f.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class C0210i extends C0200j {
        public C0210i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C0188f.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public void mo149a(Context context, C0197k c0197k) {
        this.f1000g = LayoutInflater.from(context);
        this.f997d = c0197k;
        this.f1007n = context.getResources().getDimensionPixelOffset(C0186d.design_navigation_separator_vertical_padding);
    }

    public C0195u m1438a(ViewGroup viewGroup) {
        if (this.f994a == null) {
            this.f994a = (NavigationMenuView) this.f1000g.inflate(C0188f.design_navigation_menu, viewGroup, false);
            if (this.f999f == null) {
                this.f999f = new C0203b(this);
            }
            this.f995b = (LinearLayout) this.f1000g.inflate(C0188f.design_navigation_item_header, this.f994a, false);
            this.f994a.setAdapter(this.f999f);
        }
        return this.f994a;
    }

    public void mo153a(boolean z) {
        if (this.f999f != null) {
            this.f999f.m1411b();
        }
    }

    public void mo152a(C0770a c0770a) {
        this.f996c = c0770a;
    }

    public boolean mo155a(aa aaVar) {
        return false;
    }

    public void mo151a(C0197k c0197k, boolean z) {
        if (this.f996c != null) {
            this.f996c.mo728a(c0197k, z);
        }
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

    public int mo157b() {
        return this.f998e;
    }

    public void m1439a(int i) {
        this.f998e = i;
    }

    public Parcelable mo159c() {
        Parcelable bundle = new Bundle();
        if (this.f994a != null) {
            SparseArray sparseArray = new SparseArray();
            this.f994a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f999f != null) {
            bundle.putBundle("android:menu:adapter", this.f999f.m1412c());
        }
        return bundle;
    }

    public void mo150a(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f994a.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            this.f999f.m1402a(bundle2);
        }
    }

    public void m1445a(C0882m c0882m) {
        this.f999f.m1405a(c0882m);
    }

    public View m1453b(int i) {
        View inflate = this.f1000g.inflate(i, this.f995b, false);
        m1447a(inflate);
        return inflate;
    }

    public void m1447a(View view) {
        this.f995b.addView(view);
        this.f994a.setPadding(0, 0, 0, this.f994a.getPaddingBottom());
    }

    public int m1459d() {
        return this.f995b.getChildCount();
    }

    public ColorStateList m1461e() {
        return this.f1004k;
    }

    public void m1441a(ColorStateList colorStateList) {
        this.f1004k = colorStateList;
        mo153a(false);
    }

    public ColorStateList m1462f() {
        return this.f1003j;
    }

    public void m1454b(ColorStateList colorStateList) {
        this.f1003j = colorStateList;
        mo153a(false);
    }

    public void m1458c(int i) {
        this.f1001h = i;
        this.f1002i = true;
        mo153a(false);
    }

    public Drawable m1463g() {
        return this.f1005l;
    }

    public void m1442a(Drawable drawable) {
        this.f1005l = drawable;
        mo153a(false);
    }

    public void m1455b(boolean z) {
        if (this.f999f != null) {
            this.f999f.m1408a(z);
        }
    }

    public void m1460d(int i) {
        if (this.f1006m != i) {
            this.f1006m = i;
            if (this.f995b.getChildCount() == 0) {
                this.f994a.setPadding(0, this.f1006m, 0, this.f994a.getPaddingBottom());
            }
        }
    }
}
