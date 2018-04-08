package com.p041a.p042a.p051c;

import java.io.File;
import java.util.Comparator;

final class ae implements Comparator<File> {
    ae() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7741a((File) obj, (File) obj2);
    }

    public int m7741a(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }
}
