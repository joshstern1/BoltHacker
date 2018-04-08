package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new ae();
    FragmentState[] f1528a;
    int[] f1529b;
    BackStackState[] f1530c;

    public FragmentManagerState(Parcel parcel) {
        this.f1528a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f1529b = parcel.createIntArray();
        this.f1530c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f1528a, i);
        parcel.writeIntArray(this.f1529b);
        parcel.writeTypedArray(this.f1530c, i);
    }
}
