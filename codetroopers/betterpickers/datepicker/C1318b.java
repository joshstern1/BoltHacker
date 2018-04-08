package com.codetroopers.betterpickers.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C1318b implements Creator<SavedState> {
    C1318b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8633a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8634a(i);
    }

    public SavedState m8633a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m8634a(int i) {
        return new SavedState[i];
    }
}
