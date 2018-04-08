package com.codetroopers.betterpickers.timepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C1350b implements Creator<SavedState> {
    C1350b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8781a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8782a(i);
    }

    public SavedState m8781a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m8782a(int i) {
        return new SavedState[i];
    }
}
