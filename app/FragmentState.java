package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new af();
    final String f1531a;
    final int f1532b;
    final boolean f1533c;
    final int f1534d;
    final int f1535e;
    final String f1536f;
    final boolean f1537g;
    final boolean f1538h;
    final Bundle f1539i;
    final boolean f1540j;
    Bundle f1541k;
    Fragment f1542l;

    public FragmentState(Fragment fragment) {
        this.f1531a = fragment.getClass().getName();
        this.f1532b = fragment.f1517p;
        this.f1533c = fragment.f1525x;
        this.f1534d = fragment.f1492G;
        this.f1535e = fragment.f1493H;
        this.f1536f = fragment.f1494I;
        this.f1537g = fragment.f1497L;
        this.f1538h = fragment.f1496K;
        this.f1539i = fragment.f1519r;
        this.f1540j = fragment.f1495J;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f1531a = parcel.readString();
        this.f1532b = parcel.readInt();
        this.f1533c = parcel.readInt() != 0;
        this.f1534d = parcel.readInt();
        this.f1535e = parcel.readInt();
        this.f1536f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f1537g = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f1538h = z;
        this.f1539i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f1540j = z2;
        this.f1541k = parcel.readBundle();
    }

    public Fragment m2324a(C0394w c0394w, Fragment fragment, ad adVar) {
        if (this.f1542l == null) {
            Context g = c0394w.m2732g();
            if (this.f1539i != null) {
                this.f1539i.setClassLoader(g.getClassLoader());
            }
            this.f1542l = Fragment.m2238a(g, this.f1531a, this.f1539i);
            if (this.f1541k != null) {
                this.f1541k.setClassLoader(g.getClassLoader());
                this.f1542l.f1515n = this.f1541k;
            }
            this.f1542l.m2263a(this.f1532b, fragment);
            this.f1542l.f1525x = this.f1533c;
            this.f1542l.f1527z = true;
            this.f1542l.f1492G = this.f1534d;
            this.f1542l.f1493H = this.f1535e;
            this.f1542l.f1494I = this.f1536f;
            this.f1542l.f1497L = this.f1537g;
            this.f1542l.f1496K = this.f1538h;
            this.f1542l.f1495J = this.f1540j;
            this.f1542l.f1487B = c0394w.f1815d;
            if (C0404y.f1843a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f1542l);
            }
        }
        this.f1542l.f1490E = adVar;
        return this.f1542l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f1531a);
        parcel.writeInt(this.f1532b);
        parcel.writeInt(this.f1533c ? 1 : 0);
        parcel.writeInt(this.f1534d);
        parcel.writeInt(this.f1535e);
        parcel.writeString(this.f1536f);
        if (this.f1537g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f1538h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f1539i);
        if (!this.f1540j) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f1541k);
    }
}
