package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bd implements Creator<SavedState> {
    bd() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2013a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2014a(i);
    }

    public SavedState m2013a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m2014a(int i) {
        return new SavedState[i];
    }
}
