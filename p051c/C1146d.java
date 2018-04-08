package com.p041a.p042a.p051c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class C1146d extends FileOutputStream {
    public static final FilenameFilter f4327a = new C1147e();
    private final String f4328b;
    private File f4329c;
    private File f4330d;
    private boolean f4331e = false;

    public C1146d(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.f4328b = file + File.separator + str;
        this.f4329c = new File(this.f4328b + ".cls_temp");
    }

    public synchronized void close() throws IOException {
        if (!this.f4331e) {
            this.f4331e = true;
            super.flush();
            super.close();
            File file = new File(this.f4328b + ".cls");
            if (this.f4329c.renameTo(file)) {
                this.f4329c = null;
                this.f4330d = file;
            } else {
                String str = "";
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.f4329c.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.f4329c + " -> " + file + str);
            }
        }
    }

    public void m7891a() throws IOException {
        if (!this.f4331e) {
            this.f4331e = true;
            super.flush();
            super.close();
        }
    }
}
