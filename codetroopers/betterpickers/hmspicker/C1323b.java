package com.codetroopers.betterpickers.hmspicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C1323b implements Creator<SavedState> {
    C1323b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8670a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8671a(i);
    }

    public SavedState m8670a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m8671a(int i) {
        return new SavedState[i];
    }
}
