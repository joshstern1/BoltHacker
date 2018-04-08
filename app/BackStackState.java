package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.C0381g.C0379a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C0385k();
    final int[] f1472a;
    final int f1473b;
    final int f1474c;
    final String f1475d;
    final int f1476e;
    final int f1477f;
    final CharSequence f1478g;
    final int f1479h;
    final CharSequence f1480i;
    final ArrayList<String> f1481j;
    final ArrayList<String> f1482k;

    public BackStackState(C0381g c0381g) {
        int i = 0;
        for (C0379a c0379a = c0381g.f1763c; c0379a != null; c0379a = c0379a.f1747a) {
            if (c0379a.f1755i != null) {
                i += c0379a.f1755i.size();
            }
        }
        this.f1472a = new int[(i + (c0381g.f1765e * 7))];
        if (c0381g.f1772l) {
            i = 0;
            for (C0379a c0379a2 = c0381g.f1763c; c0379a2 != null; c0379a2 = c0379a2.f1747a) {
                int i2 = i + 1;
                this.f1472a[i] = c0379a2.f1749c;
                int i3 = i2 + 1;
                this.f1472a[i2] = c0379a2.f1750d != null ? c0379a2.f1750d.f1517p : -1;
                int i4 = i3 + 1;
                this.f1472a[i3] = c0379a2.f1751e;
                i2 = i4 + 1;
                this.f1472a[i4] = c0379a2.f1752f;
                i4 = i2 + 1;
                this.f1472a[i2] = c0379a2.f1753g;
                i2 = i4 + 1;
                this.f1472a[i4] = c0379a2.f1754h;
                if (c0379a2.f1755i != null) {
                    int size = c0379a2.f1755i.size();
                    i4 = i2 + 1;
                    this.f1472a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f1472a[i4] = ((Fragment) c0379a2.f1755i.get(i2)).f1517p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f1472a[i2] = 0;
                }
            }
            this.f1473b = c0381g.f1770j;
            this.f1474c = c0381g.f1771k;
            this.f1475d = c0381g.f1774n;
            this.f1476e = c0381g.f1776p;
            this.f1477f = c0381g.f1777q;
            this.f1478g = c0381g.f1778r;
            this.f1479h = c0381g.f1779s;
            this.f1480i = c0381g.f1780t;
            this.f1481j = c0381g.f1781u;
            this.f1482k = c0381g.f1782v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f1472a = parcel.createIntArray();
        this.f1473b = parcel.readInt();
        this.f1474c = parcel.readInt();
        this.f1475d = parcel.readString();
        this.f1476e = parcel.readInt();
        this.f1477f = parcel.readInt();
        this.f1478g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1479h = parcel.readInt();
        this.f1480i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1481j = parcel.createStringArrayList();
        this.f1482k = parcel.createStringArrayList();
    }

    public C0381g m2236a(C0404y c0404y) {
        C0381g c0381g = new C0381g(c0404y);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f1472a.length) {
            C0379a c0379a = new C0379a();
            int i3 = i2 + 1;
            c0379a.f1749c = this.f1472a[i2];
            if (C0404y.f1843a) {
                Log.v("FragmentManager", "Instantiate " + c0381g + " op #" + i + " base fragment #" + this.f1472a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f1472a[i3];
            if (i2 >= 0) {
                c0379a.f1750d = (Fragment) c0404y.f1849f.get(i2);
            } else {
                c0379a.f1750d = null;
            }
            i3 = i4 + 1;
            c0379a.f1751e = this.f1472a[i4];
            i4 = i3 + 1;
            c0379a.f1752f = this.f1472a[i3];
            i3 = i4 + 1;
            c0379a.f1753g = this.f1472a[i4];
            int i5 = i3 + 1;
            c0379a.f1754h = this.f1472a[i3];
            i4 = i5 + 1;
            int i6 = this.f1472a[i5];
            if (i6 > 0) {
                c0379a.f1755i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0404y.f1843a) {
                        Log.v("FragmentManager", "Instantiate " + c0381g + " set remove fragment #" + this.f1472a[i4]);
                    }
                    i5 = i4 + 1;
                    c0379a.f1755i.add((Fragment) c0404y.f1849f.get(this.f1472a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0381g.f1766f = c0379a.f1751e;
            c0381g.f1767g = c0379a.f1752f;
            c0381g.f1768h = c0379a.f1753g;
            c0381g.f1769i = c0379a.f1754h;
            c0381g.m2681a(c0379a);
            i++;
            i2 = i4;
        }
        c0381g.f1770j = this.f1473b;
        c0381g.f1771k = this.f1474c;
        c0381g.f1774n = this.f1475d;
        c0381g.f1776p = this.f1476e;
        c0381g.f1772l = true;
        c0381g.f1777q = this.f1477f;
        c0381g.f1778r = this.f1478g;
        c0381g.f1779s = this.f1479h;
        c0381g.f1780t = this.f1480i;
        c0381g.f1781u = this.f1481j;
        c0381g.f1782v = this.f1482k;
        c0381g.m2680a(1);
        return c0381g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1472a);
        parcel.writeInt(this.f1473b);
        parcel.writeInt(this.f1474c);
        parcel.writeString(this.f1475d);
        parcel.writeInt(this.f1476e);
        parcel.writeInt(this.f1477f);
        TextUtils.writeToParcel(this.f1478g, parcel, 0);
        parcel.writeInt(this.f1479h);
        TextUtils.writeToParcel(this.f1480i, parcel, 0);
        parcel.writeStringList(this.f1481j);
        parcel.writeStringList(this.f1482k);
    }
}
