package com.p074e.p075a;

import android.content.Context;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ak.C1411a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class C1432n extends ak {
    final Context f5474a;

    C1432n(Context context) {
        this.f5474a = context;
    }

    public boolean mo1326a(ah ahVar) {
        return "content".equals(ahVar.f5372d.getScheme());
    }

    public C1411a mo1325a(ah ahVar, int i) throws IOException {
        return new C1411a(m9139b(ahVar), C1406d.DISK);
    }

    InputStream m9139b(ah ahVar) throws FileNotFoundException {
        return this.f5474a.getContentResolver().openInputStream(ahVar.f5372d);
    }
}
