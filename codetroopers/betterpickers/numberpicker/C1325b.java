package com.codetroopers.betterpickers.numberpicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C1325b implements Creator<SavedState> {
    C1325b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8692a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8693a(i);
    }

    public SavedState m8692a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m8693a(int i) {
        return new SavedState[i];
    }
}
