package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class af implements Creator<SavedState> {
    af() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4681a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4682a(i);
    }

    public SavedState m4681a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m4682a(int i) {
        return new SavedState[i];
    }
}
