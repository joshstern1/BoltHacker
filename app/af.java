package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class af implements Creator<FragmentState> {
    af() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2338a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2339a(i);
    }

    public FragmentState m2338a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] m2339a(int i) {
        return new FragmentState[i];
    }
}
