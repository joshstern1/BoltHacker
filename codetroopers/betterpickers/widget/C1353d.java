package com.codetroopers.betterpickers.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C1353d implements Creator<SavedState> {
    C1353d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8789a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8790a(i);
    }

    public SavedState m8789a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m8790a(int i) {
        return new SavedState[i];
    }
}
