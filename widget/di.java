package android.support.v7.widget;

import android.os.Parcel;
import android.support.v4.p017e.C0215e;
import android.support.v7.widget.Toolbar.SavedState;

final class di implements C0215e<SavedState> {
    di() {
    }

    public /* synthetic */ Object mo170b(Parcel parcel, ClassLoader classLoader) {
        return m7085a(parcel, classLoader);
    }

    public /* synthetic */ Object[] mo171b(int i) {
        return m7086a(i);
    }

    public SavedState m7085a(Parcel parcel, ClassLoader classLoader) {
        return new SavedState(parcel, classLoader);
    }

    public SavedState[] m7086a(int i) {
        return new SavedState[i];
    }
}
