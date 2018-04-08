package android.support.v4.p017e;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class C0468d {

    static class C0467a<T> implements Creator<T> {
        final C0215e<T> f1912a;

        public C0467a(C0215e<T> c0215e) {
            this.f1912a = c0215e;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f1912a.mo170b(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f1912a.mo171b(i);
        }
    }

    public static <T> Creator<T> m3057a(C0215e<T> c0215e) {
        if (VERSION.SDK_INT >= 13) {
            return C0470g.m3058a(c0215e);
        }
        return new C0467a(c0215e);
    }
}
