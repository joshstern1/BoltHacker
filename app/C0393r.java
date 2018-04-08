package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment.SavedState;

final class C0393r implements Creator<SavedState> {
    C0393r() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2714a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2715a(i);
    }

    public SavedState m2714a(Parcel parcel) {
        return new SavedState(parcel, null);
    }

    public SavedState[] m2715a(int i) {
        return new SavedState[i];
    }
}
