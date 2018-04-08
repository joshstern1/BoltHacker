package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager.SavedState;

final class bg implements Creator<SavedState> {
    bg() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6882a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6883a(i);
    }

    public SavedState m6882a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m6883a(int i) {
        return new SavedState[i];
    }
}
