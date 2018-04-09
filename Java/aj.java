package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class aj {
    private final DataSetObservable f1556a = new DataSetObservable();
    private DataSetObserver f1557b;

    public abstract boolean mo304a(View view, Object obj);

    public abstract int mo1273b();

    public void mo302a(ViewGroup viewGroup) {
        m2346a((View) viewGroup);
    }

    public Object mo300a(ViewGroup viewGroup, int i) {
        return m2342a((View) viewGroup, i);
    }

    public void mo303a(ViewGroup viewGroup, int i, Object obj) {
        m2347a((View) viewGroup, i, obj);
    }

    public void mo306b(ViewGroup viewGroup, int i, Object obj) {
        m2355b((View) viewGroup, i, obj);
    }

    public void mo305b(ViewGroup viewGroup) {
        m2354b((View) viewGroup);
    }

    @Deprecated
    public void m2346a(View view) {
    }

    @Deprecated
    public Object m2342a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void m2347a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @Deprecated
    public void m2355b(View view, int i, Object obj) {
    }

    @Deprecated
    public void m2354b(View view) {
    }

    public Parcelable mo299a() {
        return null;
    }

    public void mo301a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int m2340a(Object obj) {
        return -1;
    }

    public void m2344a(DataSetObserver dataSetObserver) {
        this.f1556a.registerObserver(dataSetObserver);
    }

    public void m2353b(DataSetObserver dataSetObserver) {
        this.f1556a.unregisterObserver(dataSetObserver);
    }

    void m2359c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f1557b = dataSetObserver;
        }
    }

    public CharSequence mo2186b(int i) {
        return null;
    }

    public float m2358c(int i) {
        return 1.0f;
    }
}
