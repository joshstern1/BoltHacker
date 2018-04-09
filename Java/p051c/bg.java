package com.p041a.p042a.p051c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

final class bg {
    public static void m7884a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles != null && listFiles.length > i) {
            Arrays.sort(listFiles, comparator);
            int length = listFiles.length;
            int length2 = listFiles.length;
            int i2 = 0;
            while (i2 < length2) {
                File file2 = listFiles[i2];
                if (length > i) {
                    file2.delete();
                    length--;
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
