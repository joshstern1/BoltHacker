package com.p041a.p042a.p051c;

import java.io.File;
import java.io.FilenameFilter;

final class ag implements FilenameFilter {
    ag() {
    }

    public boolean accept(File file, String str) {
        return C1182y.f4395e.matcher(str).matches();
    }
}
