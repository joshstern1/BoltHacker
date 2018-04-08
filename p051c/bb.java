package com.p041a.p042a.p051c;

import java.io.File;
import java.io.FilenameFilter;

final class bb implements FilenameFilter {
    bb() {
    }

    public boolean accept(File file, String str) {
        return str.endsWith(".cls") && !str.contains("Session");
    }
}
