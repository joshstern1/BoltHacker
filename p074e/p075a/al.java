package com.p074e.p075a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ak.C1411a;
import java.io.IOException;

class al extends ak {
    private final Context f5404a;

    al(Context context) {
        this.f5404a = context;
    }

    public boolean mo1326a(ah ahVar) {
        if (ahVar.f5373e != 0) {
            return true;
        }
        return "android.resource".equals(ahVar.f5372d.getScheme());
    }

    public C1411a mo1325a(ah ahVar, int i) throws IOException {
        Resources a = as.m9070a(this.f5404a, ahVar);
        return new C1411a(al.m9040a(a, as.m9067a(a, ahVar), ahVar), C1406d.DISK);
    }

    private static Bitmap m9040a(Resources resources, int i, ah ahVar) {
        Options c = ak.m9034c(ahVar);
        if (ak.m9033a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            ak.m9032a(ahVar.f5376h, ahVar.f5377i, c, ahVar);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }
}
