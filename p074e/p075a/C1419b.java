package com.p074e.p075a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ak.C1411a;
import java.io.IOException;

class C1419b extends ak {
    private static final int f5441a = "file:///android_asset/".length();
    private final AssetManager f5442b;

    public C1419b(Context context) {
        this.f5442b = context.getAssets();
    }

    public boolean mo1326a(ah ahVar) {
        Uri uri = ahVar.f5372d;
        if ("file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0))) {
            return true;
        }
        return false;
    }

    public C1411a mo1325a(ah ahVar, int i) throws IOException {
        return new C1411a(this.f5442b.open(C1419b.m9091b(ahVar)), C1406d.DISK);
    }

    static String m9091b(ah ahVar) {
        return ahVar.f5372d.toString().substring(f5441a);
    }
}
