package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.p017e.C0215e;
import android.support.v4.view.ViewPager.SavedState;

final class bk implements C0215e<SavedState> {
    bk() {
    }

    public /* synthetic */ Object mo170b(Parcel parcel, ClassLoader classLoader) {
        return m4097a(parcel, classLoader);
    }

    public /* synthetic */ Object[] mo171b(int i) {
        return m4098a(i);
    }

    public SavedState m4097a(Parcel parcel, ClassLoader classLoader) {
        return new SavedState(parcel, classLoader);
    }

    public SavedState[] m4098a(int i) {
        return new SavedState[i];
    }
}
