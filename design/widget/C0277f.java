package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0277f implements Creator<SavedState> {
    C0277f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2111a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2112a(i);
    }

    public SavedState m2111a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m2112a(int i) {
        return new SavedState[i];
    }
}
