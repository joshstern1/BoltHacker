package com.p041a.p042a.p051c;

import java.io.File;
import java.util.Comparator;

final class af implements Comparator<File> {
    af() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7742a((File) obj, (File) obj2);
    }

    public int m7742a(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }
}
