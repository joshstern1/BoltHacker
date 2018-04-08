package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p046b.C2972w;
import java.io.File;

class ax implements aq {
    private final File f4296a;
    private final int f4297b;
    private C2972w f4298c;

    public ax(File file, int i) {
        this.f4296a = file;
        this.f4297b = i;
    }

    public C1142b mo1179a() {
        if (!this.f4296a.exists()) {
            return null;
        }
        m7823d();
        if (this.f4298c == null) {
            return null;
        }
        int[] iArr = new int[]{0};
        byte[] bArr = new byte[this.f4298c.m17073a()];
        try {
            this.f4298c.m17074a(new ay(this, bArr, iArr));
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return C1142b.m7835a(bArr, 0, iArr[0]);
    }

    public void mo1180b() {
        C2956j.m16996a(this.f4298c, "There was a problem closing the Crashlytics log file.");
        this.f4298c = null;
    }

    public void mo1181c() {
        mo1180b();
        this.f4296a.delete();
    }

    private void m7823d() {
        if (this.f4298c == null) {
            try {
                this.f4298c = new C2972w(this.f4296a);
            } catch (Throwable e) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Could not open log file: " + this.f4296a, e);
            }
        }
    }
}
