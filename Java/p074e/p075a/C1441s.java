package com.p074e.p075a;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ak.C1411a;
import java.io.IOException;

class C1441s extends C1432n {
    C1441s(Context context) {
        super(context);
    }

    public boolean mo1326a(ah ahVar) {
        return "file".equals(ahVar.f5372d.getScheme());
    }

    public C1411a mo1325a(ah ahVar, int i) throws IOException {
        return new C1411a(null, m9139b(ahVar), C1406d.DISK, C1441s.m9168a(ahVar.f5372d));
    }

    static int m9168a(Uri uri) throws IOException {
        switch (new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1)) {
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }
}
