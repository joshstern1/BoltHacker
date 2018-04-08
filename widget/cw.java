package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager.SavedState;

final class cw implements Creator<SavedState> {
    cw() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7029a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7030a(i);
    }

    public SavedState m7029a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m7030a(int i) {
        return new SavedState[i];
    }
}
