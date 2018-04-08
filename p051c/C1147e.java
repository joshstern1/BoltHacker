package com.p041a.p042a.p051c;

import java.io.File;
import java.io.FilenameFilter;

final class C1147e implements FilenameFilter {
    C1147e() {
    }

    public boolean accept(File file, String str) {
        return str.endsWith(".cls_temp");
    }
}
