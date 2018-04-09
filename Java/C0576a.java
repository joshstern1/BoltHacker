package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.p017e.C0215e;

final class C0576a implements C0215e<AbsSavedState> {
    C0576a() {
    }

    public /* synthetic */ Object mo170b(Parcel parcel, ClassLoader classLoader) {
        return m3640a(parcel, classLoader);
    }

    public /* synthetic */ Object[] mo171b(int i) {
        return m3641a(i);
    }

    public AbsSavedState m3640a(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.f1986a;
        }
        throw new IllegalStateException("superState must be null");
    }

    public AbsSavedState[] m3641a(int i) {
        return new AbsSavedState[i];
    }
}
