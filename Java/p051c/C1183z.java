package com.p041a.p042a.p051c;

import java.io.File;
import java.io.FilenameFilter;

final class C1183z implements FilenameFilter {
    C1183z() {
    }

    public boolean accept(File file, String str) {
        return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
    }
}
