package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ae implements Creator<FragmentManagerState> {
    ae() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2336a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2337a(i);
    }

    public FragmentManagerState m2336a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] m2337a(int i) {
        return new FragmentManagerState[i];
    }
}
