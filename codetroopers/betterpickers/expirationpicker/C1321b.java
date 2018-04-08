package com.codetroopers.betterpickers.expirationpicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C1321b implements Creator<SavedState> {
    C1321b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8658a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8659a(i);
    }

    public SavedState m8658a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m8659a(int i) {
        return new SavedState[i];
    }
}
