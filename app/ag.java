package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.aj;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class ag extends aj {
    private final C0401x f1558a;
    private ah f1559b = null;
    private ArrayList<SavedState> f1560c = new ArrayList();
    private ArrayList<Fragment> f1561d = new ArrayList();
    private Fragment f1562e = null;

    public abstract Fragment mo2185a(int i);

    public ag(C0401x c0401x) {
        this.f1558a = c0401x;
    }

    public void mo302a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object mo300a(ViewGroup viewGroup, int i) {
        if (this.f1561d.size() > i) {
            Fragment fragment = (Fragment) this.f1561d.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f1559b == null) {
            this.f1559b = this.f1558a.mo378a();
        }
        Fragment a = mo2185a(i);
        if (this.f1560c.size() > i) {
            SavedState savedState = (SavedState) this.f1560c.get(i);
            if (savedState != null) {
                a.m2275a(savedState);
            }
        }
        while (this.f1561d.size() <= i) {
            this.f1561d.add(null);
        }
        a.m2292d(false);
        a.m2296e(false);
        this.f1561d.set(i, a);
        this.f1559b.mo340a(viewGroup.getId(), a);
        return a;
    }

    public void mo303a(ViewGroup viewGroup, int i, Object obj) {
        Object a;
        Fragment fragment = (Fragment) obj;
        if (this.f1559b == null) {
            this.f1559b = this.f1558a.mo378a();
        }
        while (this.f1560c.size() <= i) {
            this.f1560c.add(null);
        }
        ArrayList arrayList = this.f1560c;
        if (fragment.m2313p()) {
            a = this.f1558a.mo374a(fragment);
        } else {
            a = null;
        }
        arrayList.set(i, a);
        this.f1561d.set(i, null);
        this.f1559b.mo341a(fragment);
    }

    public void mo306b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f1562e) {
            if (this.f1562e != null) {
                this.f1562e.m2292d(false);
                this.f1562e.m2296e(false);
            }
            if (fragment != null) {
                fragment.m2292d(true);
                fragment.m2296e(true);
            }
            this.f1562e = fragment;
        }
    }

    public void mo305b(ViewGroup viewGroup) {
        if (this.f1559b != null) {
            this.f1559b.mo345d();
            this.f1559b = null;
        }
    }

    public boolean mo304a(View view, Object obj) {
        return ((Fragment) obj).m2317t() == view;
    }

    public Parcelable mo299a() {
        Bundle bundle = null;
        if (this.f1560c.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.f1560c.size()];
            this.f1560c.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f1561d.size(); i++) {
            Fragment fragment = (Fragment) this.f1561d.get(i);
            if (fragment != null && fragment.m2313p()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f1558a.mo381a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public void mo301a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f1560c.clear();
            this.f1561d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f1560c.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f1558a.mo376a(bundle, str);
                    if (a != null) {
                        while (this.f1561d.size() <= parseInt) {
                            this.f1561d.add(null);
                        }
                        a.m2292d(false);
                        this.f1561d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
