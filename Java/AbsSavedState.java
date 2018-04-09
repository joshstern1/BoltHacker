package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p017e.C0468d;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = C0468d.m3057a(new C0576a());
    public static final AbsSavedState f1986a = new C05141();
    private final Parcelable f1987b;

    final class C05141 extends AbsSavedState {
        C05141() {
            super();
        }
    }

    private AbsSavedState() {
        this.f1987b = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == f1986a) {
            parcelable = null;
        }
        this.f1987b = parcelable;
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = f1986a;
        }
        this.f1987b = readParcelable;
    }

    public final Parcelable m3182a() {
        return this.f1987b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1987b, i);
    }
}
