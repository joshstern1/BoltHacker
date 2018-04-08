package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p015d.p016a.C0196a;
import android.support.v4.p021b.C0307a;
import android.support.v4.view.C0641i;
import android.support.v4.view.C0675w;
import android.support.v7.p028b.C0842a.C0832b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class C0197k implements C0196a {
    private static final int[] f942d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f943a;
    Drawable f944b;
    View f945c;
    private final Context f946e;
    private final Resources f947f;
    private boolean f948g;
    private boolean f949h;
    private C0253a f950i;
    private ArrayList<C0882m> f951j;
    private ArrayList<C0882m> f952k;
    private boolean f953l;
    private ArrayList<C0882m> f954m;
    private ArrayList<C0882m> f955n;
    private boolean f956o;
    private int f957p = 0;
    private ContextMenuInfo f958q;
    private boolean f959r = false;
    private boolean f960s = false;
    private boolean f961t = false;
    private boolean f962u = false;
    private ArrayList<C0882m> f963v = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<C0211t>> f964w = new CopyOnWriteArrayList();
    private C0882m f965x;
    private boolean f966y;

    public interface C0253a {
        void mo222a(C0197k c0197k);

        boolean mo223a(C0197k c0197k, MenuItem menuItem);
    }

    public interface C0865b {
        boolean mo848a(C0882m c0882m);
    }

    public C0197k(Context context) {
        this.f946e = context;
        this.f947f = context.getResources();
        this.f951j = new ArrayList();
        this.f952k = new ArrayList();
        this.f953l = true;
        this.f954m = new ArrayList();
        this.f955n = new ArrayList();
        this.f956o = true;
        m1280e(true);
    }

    public C0197k m1284a(int i) {
        this.f957p = i;
        return this;
    }

    public void m1294a(C0211t c0211t) {
        m1295a(c0211t, this.f946e);
    }

    public void m1295a(C0211t c0211t, Context context) {
        this.f964w.add(new WeakReference(c0211t));
        c0211t.mo149a(context, this);
        this.f956o = true;
    }

    public void m1305b(C0211t c0211t) {
        Iterator it = this.f964w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0211t c0211t2 = (C0211t) weakReference.get();
            if (c0211t2 == null || c0211t2 == c0211t) {
                this.f964w.remove(weakReference);
            }
        }
    }

    private void m1278d(boolean z) {
        if (!this.f964w.isEmpty()) {
            m1320g();
            Iterator it = this.f964w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0211t c0211t = (C0211t) weakReference.get();
                if (c0211t == null) {
                    this.f964w.remove(weakReference);
                } else {
                    c0211t.mo153a(z);
                }
            }
            m1321h();
        }
    }

    private boolean m1277a(aa aaVar, C0211t c0211t) {
        boolean z = false;
        if (this.f964w.isEmpty()) {
            return false;
        }
        if (c0211t != null) {
            z = c0211t.mo155a(aaVar);
        }
        Iterator it = this.f964w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0211t c0211t2 = (C0211t) weakReference.get();
            if (c0211t2 == null) {
                this.f964w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = c0211t2.mo155a(aaVar);
            }
            z2 = z;
        }
        return z2;
    }

    private void m1279e(Bundle bundle) {
        if (!this.f964w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.f964w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0211t c0211t = (C0211t) weakReference.get();
                if (c0211t == null) {
                    this.f964w.remove(weakReference);
                } else {
                    int b = c0211t.mo157b();
                    if (b > 0) {
                        Parcelable c = c0211t.mo159c();
                        if (c != null) {
                            sparseArray.put(b, c);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void m1282f(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f964w.isEmpty()) {
            Iterator it = this.f964w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0211t c0211t = (C0211t) weakReference.get();
                if (c0211t == null) {
                    this.f964w.remove(weakReference);
                } else {
                    int b = c0211t.mo157b();
                    if (b > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(b);
                        if (parcelable != null) {
                            c0211t.mo150a(parcelable);
                        }
                    }
                }
            }
        }
    }

    public void m1291a(Bundle bundle) {
        m1279e(bundle);
    }

    public void m1303b(Bundle bundle) {
        m1282f(bundle);
    }

    public void m1309c(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = C0675w.m4365a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (C0675w.m4369c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((aa) item.getSubMenu()).m1309c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo160a(), sparseArray);
        }
    }

    public void m1315d(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo160a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = C0675w.m4365a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((aa) item.getSubMenu()).m1315d(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    C0675w.m4368b(item);
                }
            }
        }
    }

    protected String mo160a() {
        return "android:menu:actionviewstates";
    }

    public void mo161a(C0253a c0253a) {
        this.f950i = c0253a;
    }

    protected MenuItem m1289a(int i, int i2, int i3, CharSequence charSequence) {
        int f = C0197k.m1281f(i3);
        MenuItem a = m1274a(i, i2, i3, f, charSequence, this.f957p);
        if (this.f958q != null) {
            a.m5702a(this.f958q);
        }
        this.f951j.add(C0197k.m1273a(this.f951j, f), a);
        mo169a(true);
        return a;
    }

    private C0882m m1274a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0882m(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m1289a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m1289a(0, 0, 0, this.f947f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1289a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1289a(i, i2, i3, this.f947f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f947f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0882m c0882m = (C0882m) m1289a(i, i2, i3, charSequence);
        aa aaVar = new aa(this.f946e, this, c0882m);
        c0882m.m5701a(aaVar);
        return aaVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f947f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f946e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m1276a(m1302b(i), true);
    }

    public void removeGroup(int i) {
        int c = m1308c(i);
        if (c >= 0) {
            int size = this.f951j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0882m) this.f951j.get(c)).getGroupId() != i) {
                    mo169a(true);
                } else {
                    m1276a(c, false);
                    i2 = i3;
                }
            }
            mo169a(true);
        }
    }

    private void m1276a(int i, boolean z) {
        if (i >= 0 && i < this.f951j.size()) {
            this.f951j.remove(i);
            if (z) {
                mo169a(true);
            }
        }
    }

    public void clear() {
        if (this.f965x != null) {
            mo166d(this.f965x);
        }
        this.f951j.clear();
        mo169a(true);
    }

    void m1296a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f951j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0882m) this.f951j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m5714g() && menuItem2.isCheckable()) {
                menuItem2.m5705b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f951j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0882m c0882m = (C0882m) this.f951j.get(i2);
            if (c0882m.getGroupId() == i) {
                c0882m.m5703a(z2);
                c0882m.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f951j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            C0882m c0882m = (C0882m) this.f951j.get(i2);
            if (c0882m.getGroupId() == i && c0882m.m5708c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            mo169a(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f951j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0882m c0882m = (C0882m) this.f951j.get(i2);
            if (c0882m.getGroupId() == i) {
                c0882m.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f966y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0882m) this.f951j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0882m c0882m = (C0882m) this.f951j.get(i2);
            if (c0882m.getItemId() == i) {
                return c0882m;
            }
            if (c0882m.hasSubMenu()) {
                MenuItem findItem = c0882m.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m1302b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0882m) this.f951j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m1308c(int i) {
        return m1283a(i, 0);
    }

    public int m1283a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0882m) this.f951j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f951j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f951j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m1288a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f948g = z;
        mo169a(false);
    }

    private static int m1281f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f942d.length) {
            return (f942d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean mo163b() {
        return this.f948g;
    }

    private void m1280e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f947f.getConfiguration().keyboard != 1 && this.f947f.getBoolean(C0832b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f949h = z2;
    }

    public boolean mo164c() {
        return this.f949h;
    }

    Resources m1313d() {
        return this.f947f;
    }

    public Context m1317e() {
        return this.f946e;
    }

    boolean mo162a(C0197k c0197k, MenuItem menuItem) {
        return this.f950i != null && this.f950i.mo223a(c0197k, menuItem);
    }

    public void m1319f() {
        if (this.f950i != null) {
            this.f950i.mo222a(this);
        }
    }

    private static int m1273a(ArrayList<C0882m> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0882m) arrayList.get(size)).m5707c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m1288a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m1300a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m1306b(true);
        }
        return z;
    }

    void m1297a(List<C0882m> list, int i, KeyEvent keyEvent) {
        boolean b = mo163b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f951j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0882m c0882m = (C0882m) this.f951j.get(i2);
                if (c0882m.hasSubMenu()) {
                    ((C0197k) c0882m.getSubMenu()).m1297a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0882m.getAlphabeticShortcut() : c0882m.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0882m.isEnabled())) {
                    list.add(c0882m);
                }
            }
        }
    }

    C0882m m1288a(int i, KeyEvent keyEvent) {
        List list = this.f963v;
        list.clear();
        m1297a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0882m) list.get(0);
        }
        boolean b = mo163b();
        for (int i2 = 0; i2 < size; i2++) {
            char alphabeticShortcut;
            C0882m c0882m = (C0882m) list.get(i2);
            if (b) {
                alphabeticShortcut = c0882m.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = c0882m.getNumericShortcut();
            }
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0882m;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0882m;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0882m;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m1300a(findItem(i), i2);
    }

    public boolean m1300a(MenuItem menuItem, int i) {
        return m1301a(menuItem, null, i);
    }

    public boolean m1301a(MenuItem menuItem, C0211t c0211t, int i) {
        C0882m c0882m = (C0882m) menuItem;
        if (c0882m == null || !c0882m.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = c0882m.m5706b();
        C0641i a = c0882m.mo851a();
        if (a == null || !a.mo878e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (c0882m.m5721n()) {
            expandActionView = c0882m.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m1306b(true);
            return expandActionView;
        } else if (c0882m.hasSubMenu() || z) {
            if (!c0882m.hasSubMenu()) {
                c0882m.m5701a(new aa(m1317e(), this, c0882m));
            }
            aa aaVar = (aa) c0882m.getSubMenu();
            if (z) {
                a.mo876a((SubMenu) aaVar);
            }
            expandActionView = m1277a(aaVar, c0211t) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m1306b(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m1306b(true);
            }
            return b;
        }
    }

    public final void m1306b(boolean z) {
        if (!this.f962u) {
            this.f962u = true;
            Iterator it = this.f964w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0211t c0211t = (C0211t) weakReference.get();
                if (c0211t == null) {
                    this.f964w.remove(weakReference);
                } else {
                    c0211t.mo151a(this, z);
                }
            }
            this.f962u = false;
        }
    }

    public void close() {
        m1306b(true);
    }

    public void mo169a(boolean z) {
        if (this.f959r) {
            this.f960s = true;
            return;
        }
        if (z) {
            this.f953l = true;
            this.f956o = true;
        }
        m1278d(z);
    }

    public void m1320g() {
        if (!this.f959r) {
            this.f959r = true;
            this.f960s = false;
        }
    }

    public void m1321h() {
        this.f959r = false;
        if (this.f960s) {
            this.f960s = false;
            mo169a(true);
        }
    }

    void m1293a(C0882m c0882m) {
        this.f953l = true;
        mo169a(true);
    }

    void m1304b(C0882m c0882m) {
        this.f956o = true;
        mo169a(true);
    }

    public ArrayList<C0882m> m1322i() {
        if (!this.f953l) {
            return this.f952k;
        }
        this.f952k.clear();
        int size = this.f951j.size();
        for (int i = 0; i < size; i++) {
            C0882m c0882m = (C0882m) this.f951j.get(i);
            if (c0882m.isVisible()) {
                this.f952k.add(c0882m);
            }
        }
        this.f953l = false;
        this.f956o = true;
        return this.f952k;
    }

    public void m1323j() {
        ArrayList i = m1322i();
        if (this.f956o) {
            Iterator it = this.f964w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0211t c0211t = (C0211t) weakReference.get();
                if (c0211t == null) {
                    this.f964w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0211t.mo154a() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f954m.clear();
                this.f955n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0882m c0882m = (C0882m) i.get(i4);
                    if (c0882m.m5717j()) {
                        this.f954m.add(c0882m);
                    } else {
                        this.f955n.add(c0882m);
                    }
                }
            } else {
                this.f954m.clear();
                this.f955n.clear();
                this.f955n.addAll(m1322i());
            }
            this.f956o = false;
        }
    }

    public ArrayList<C0882m> m1324k() {
        m1323j();
        return this.f954m;
    }

    public ArrayList<C0882m> m1325l() {
        m1323j();
        return this.f955n;
    }

    public void clearHeader() {
        this.f944b = null;
        this.f943a = null;
        this.f945c = null;
        mo169a(false);
    }

    private void m1275a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m1313d();
        if (view != null) {
            this.f945c = view;
            this.f943a = null;
            this.f944b = null;
        } else {
            if (i > 0) {
                this.f943a = d.getText(i);
            } else if (charSequence != null) {
                this.f943a = charSequence;
            }
            if (i2 > 0) {
                this.f944b = C0307a.m2325a(m1317e(), i2);
            } else if (drawable != null) {
                this.f944b = drawable;
            }
            this.f945c = null;
        }
        mo169a(false);
    }

    protected C0197k m1287a(CharSequence charSequence) {
        m1275a(0, charSequence, 0, null, null);
        return this;
    }

    protected C0197k m1314d(int i) {
        m1275a(i, null, 0, null, null);
        return this;
    }

    protected C0197k m1285a(Drawable drawable) {
        m1275a(0, null, 0, drawable, null);
        return this;
    }

    protected C0197k m1318e(int i) {
        m1275a(0, null, i, null, null);
        return this;
    }

    protected C0197k m1286a(View view) {
        m1275a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m1326m() {
        return this.f943a;
    }

    public Drawable m1327n() {
        return this.f944b;
    }

    public View m1328o() {
        return this.f945c;
    }

    public C0197k mo167p() {
        return this;
    }

    boolean m1330q() {
        return this.f961t;
    }

    public boolean mo165c(C0882m c0882m) {
        boolean z = false;
        if (!this.f964w.isEmpty()) {
            m1320g();
            Iterator it = this.f964w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0211t c0211t = (C0211t) weakReference.get();
                if (c0211t == null) {
                    this.f964w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0211t.mo156a(this, c0882m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1321h();
            if (z) {
                this.f965x = c0882m;
            }
        }
        return z;
    }

    public boolean mo166d(C0882m c0882m) {
        boolean z = false;
        if (!this.f964w.isEmpty() && this.f965x == c0882m) {
            m1320g();
            Iterator it = this.f964w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0211t c0211t = (C0211t) weakReference.get();
                if (c0211t == null) {
                    this.f964w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0211t.mo158b(this, c0882m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1321h();
            if (z) {
                this.f965x = null;
            }
        }
        return z;
    }

    public C0882m m1331r() {
        return this.f965x;
    }

    public void m1310c(boolean z) {
        this.f966y = z;
    }
}
