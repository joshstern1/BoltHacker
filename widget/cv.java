package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class cv implements Creator<FullSpanItem> {
    cv() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7027a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7028a(i);
    }

    public FullSpanItem m7027a(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public FullSpanItem[] m7028a(int i) {
        return new FullSpanItem[i];
    }
}
