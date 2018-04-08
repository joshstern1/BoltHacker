package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaSessionCompat {

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C0513a();
        private final Object f1985a;

        Token(Object obj) {
            this.f1985a = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f1985a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f1985a);
            }
        }

        public Object m3179a() {
            return this.f1985a;
        }
    }
}
