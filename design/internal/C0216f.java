package android.support.design.internal;

import android.os.Parcel;
import android.support.v4.p017e.C0215e;

final class C0216f implements C0215e<ParcelableSparseArray> {
    C0216f() {
    }

    public /* synthetic */ Object mo170b(Parcel parcel, ClassLoader classLoader) {
        return m1476a(parcel, classLoader);
    }

    public /* synthetic */ Object[] mo171b(int i) {
        return m1477a(i);
    }

    public ParcelableSparseArray m1476a(Parcel parcel, ClassLoader classLoader) {
        return new ParcelableSparseArray(parcel, classLoader);
    }

    public ParcelableSparseArray[] m1477a(int i) {
        return new ParcelableSparseArray[i];
    }
}
