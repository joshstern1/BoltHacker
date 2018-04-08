package no.nordicsemi.android.support.v18.scanner;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C3113r implements Creator<ScanResult> {
    C3113r() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17513a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17514a(i);
    }

    public ScanResult m17513a(Parcel parcel) {
        return new ScanResult(parcel);
    }

    public ScanResult[] m17514a(int i) {
        return new ScanResult[i];
    }
}
