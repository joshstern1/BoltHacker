package android.support.v4.p017e;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class C0469f<T> implements ClassLoaderCreator<T> {
    private final C0215e<T> f1913a;

    public C0469f(C0215e<T> c0215e) {
        this.f1913a = c0215e;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f1913a.mo170b(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f1913a.mo170b(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f1913a.mo171b(i);
    }
}
