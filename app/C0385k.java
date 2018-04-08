package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0385k implements Creator<BackStackState> {
    C0385k() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2690a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2691a(i);
    }

    public BackStackState m2690a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] m2691a(int i) {
        return new BackStackState[i];
    }
}
