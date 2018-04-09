package com.p041a.p042a.p051c;

import java.io.File;
import java.io.FilenameFilter;

class ad implements FilenameFilter {
    final /* synthetic */ String f4229a;
    final /* synthetic */ C1182y f4230b;

    ad(C1182y c1182y, String str) {
        this.f4230b = c1182y;
        this.f4229a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.f4229a);
    }
}
