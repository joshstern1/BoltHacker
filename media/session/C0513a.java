package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.Token;

final class C0513a implements Creator<Token> {
    C0513a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3180a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3181a(i);
    }

    public Token m3180a(Parcel parcel) {
        Object readParcelable;
        if (VERSION.SDK_INT >= 21) {
            readParcelable = parcel.readParcelable(null);
        } else {
            readParcelable = parcel.readStrongBinder();
        }
        return new Token(readParcelable);
    }

    public Token[] m3181a(int i) {
        return new Token[i];
    }
}
